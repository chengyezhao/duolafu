package com.shoumipay.controller.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shoumipay.domain.SesameCredit;
import com.shoumipay.service.RedisService;
import com.shoumipay.service.SesameCreditService;
import com.shoumipay.service.ThirdVerifyService;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 芝麻信用分
 * 异步通知结果接收接口
 */
@Controller
public class NotifyResultSea {
    @Autowired
    SesameCreditService sesameCreditService;
    @Autowired
    ThirdVerifyService thirdVerifyService;
    @Autowired
    RedisService redisService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 接收实名认证异步通知
     */
    @RequestMapping("/services/notify/Sea")
    public void process(HttpServletRequest request, HttpServletResponse response, String data) {
        String req = request.getParameter("data");
        try {
            String result = new String(Hex.decodeHex(req.toCharArray()), "UTF-8");
            JSONObject jsonResult = JSON.parseObject(result);
            logger.info("芝麻授权异步回调请求数据" + result);
            if (jsonResult.get("resultCode") != null && jsonResult.get("resultCode").equals("0000")) {
                String openId = jsonResult.get("openId").toString();
                String orderId = jsonResult.get("customerId").toString();
                String uid = orderId.substring(0, 2);
                SesameCredit sesameCredit = sesameCreditService.selectByLatest(Long.parseLong(uid));
                if (sesameCredit == null) {
                    logger.info("数据库不存在该订单,进行插入操作");
                    SesameCredit sesameCredit1 = new SesameCredit();
                    sesameCredit1.setAuthorizeId(openId);
                    sesameCredit1.setCreateTime(new Date());
                    sesameCredit1.setUpdateTime(new Date());
                    sesameCredit1.setOrderId(orderId);
                    sesameCredit1.setUid(Long.parseLong(uid));
                    sesameCreditService.addSesameCredit(sesameCredit1);
                } else {
                    logger.info("数据库存在该订单,进行更新操作");
                    sesameCredit.setCreateTime(new Date());
                    sesameCredit.setUpdateTime(new Date());
                    sesameCredit.setOrderId(orderId);
                    sesameCredit.setUid(Long.parseLong(uid));
                    sesameCredit.setAuthorizeId(openId);
                    sesameCreditService.updateSesameCredit(sesameCredit);
                }
                SesameCredit sesameCredit1 = sesameCreditService.selectByOrderId(orderId);
                if (sesameCredit1 != null) {
                    JSONObject results = thirdVerifyService.querySesameVerify(sesameCredit1.getAuthorizeId(), new Date(), orderId);
                    if (results.get("msg").equals("芝麻分查询获取数据成功")) {
                        //将芝麻分存入数据库
                        logger.info("进行芝麻分录入操作");
                        JSONObject resultScore = JSON.parseObject(results.get("result").toString());
                        JSONArray dataScore = resultScore.getJSONArray("data");
                        Double score = dataScore.getJSONObject(0).getDouble("score");
                        sesameCredit1.setSesameScore(score);
                        sesameCredit1.setUpdateTime(new Date());
                        int index = sesameCreditService.updateSesameCredit(sesameCredit1);
                        if (index > 0) {
                            redisService.set("querySesameScore" + uid, "1", 24 * 60 * 60);//成功
                            logger.info("芝麻分录入成功");
                        } else {
                            logger.info("芝麻分录入失败");
                        }
                    } else {
                        redisService.set("querySesameScore" + uid, "0", 24 * 60 * 60);//失败
                    }
                }
            } else {
                logger.info("返回参数有误");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

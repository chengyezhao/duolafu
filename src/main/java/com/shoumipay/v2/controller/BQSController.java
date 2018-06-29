package com.shoumipay.v2.controller;

import com.alibaba.fastjson.JSONObject;
import com.shoumipay.controller.wechat.base.BaseController;
import com.shoumipay.domain.Member;
import com.shoumipay.v2.service.BQSdataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/bqs")
public class BQSController extends BaseController{

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BQSdataService bqSdataService;

    @RequestMapping(value = "/getData",method = RequestMethod.POST)
    @ResponseBody
    public String getData(@RequestParam String userName,@RequestParam String pwd,String authCode ){
        JSONObject js = new JSONObject();
        Member member = getLoginMember();
        String reqId = null;
        if (member != null){
            JSONObject json = new JSONObject();
            String data = bqSdataService.login(member,userName,pwd,reqId,authCode);
            JSONObject jsonObject = json.parseObject(data);
            if ("CCOM3069".equals(jsonObject.getString("resultCode"))){
                reqId = jsonObject.getString("reqId ");
                js.put("status",1);
                js.put("msg","请输入验证码");
                return js.toJSONString();
            }else if("CCOM1000".equals(jsonObject.getString("resultCode"))){
                String data1 =  bqSdataService.getTaobao(member);
                JSONObject jsonObject1 = json.parseObject(data);
                if ("CCOM1000".equals(jsonObject1.getString("resultCode"))){
                    js.put("msg","验证淘宝成功");
                    return js.toJSONString();
                }else{
                    js.put("msg","验证失败");
                    return js.toJSONString();
                }
            }else{
                return js.toJSONString();
            }
        }
        js.put("msg","请登录");
        return js.toJSONString();
    }

}

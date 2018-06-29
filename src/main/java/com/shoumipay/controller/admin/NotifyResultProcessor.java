package com.shoumipay.controller.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shoumipay.domain.CertificationFile;
import com.shoumipay.domain.MemberDetail;
import com.shoumipay.service.admin.CertificationFileService;
import com.shoumipay.v2.service.MemberService;
import com.shoumipay.smsmessage.MD5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


/**人脸识别
 * 异步通知结果接收接口
 *
 * @author geosmart
 * @date 2017-01-06
 */
@Controller
public class NotifyResultProcessor {
    private static final SimpleDateFormat format = new SimpleDateFormat("/yyyy/MM/dd");//再按日期分类
    @Value("${headIcon.location}")
    private String headIconLocation;
    @Value("${identify.classify}")
    private String identifyClassify;
    @Autowired
    MemberService memberService;
    @Autowired
    CertificationFileService certificationFileService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * TODO 获取商户开户的pub_key
     */
    static final String PUB_KEY = "";
    /**
     * TODO 获取商户开户的security_key
     */
    static final String SECURITY_KEY = "";

    static final String CHARSET_UTF_8 = "UTF-8";
    static final boolean IS_DEBUG = true;

    /**
     * 生成MD5签名
     *
     * @param pub_key          商户公钥
     * @param partner_order_id 商户订单号
     * @param sign_time        签名时间
     * @param security_key     商户私钥
     */
    public static String getMD5Sign(String pub_key, String partner_order_id, String sign_time, String security_key) throws UnsupportedEncodingException {
        String signStr = String.format("pub_key=%s|partner_order_id=%s|sign_time=%s|security_key=%s", pub_key, partner_order_id, sign_time, security_key);
        System.out.println("signField：" + signStr + SECURITY_KEY);
        return MD5Utils.MD5Encrpytion(signStr.getBytes("UTF-8"));
    }

    /**
     * 接收实名认证异步通知
     */
    @RequestMapping("/services/faceProcess")
    public void faceProcessNotify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final JSONObject reqObject = getRequestJson(request);
        JSONObject respJson = new JSONObject();
        //验签
        String sign = reqObject.getString("sign");
        String sign_time = reqObject.getString("sign_time");
        String partner_order_id = reqObject.getString("partner_order_id");
        logger.info("返回数据："+reqObject.toString());
        System.out.println("sign：" + sign);
        String signMD5 = getMD5Sign(PUB_KEY, partner_order_id, sign_time, SECURITY_KEY);
        System.out.println("signMD5：" + signMD5);
        if (!sign.equals(signMD5)) {
            System.err.println("异步通知签名错误");
            respJson.put("code", "0");
            respJson.put("message", "签名错误");
        } else {
            System.out.print("收到商户异步通知");
            respJson.put("code", "1");
            respJson.put("message", "收到通知");
            //TODO 异步执行商户自己的业务逻辑(以免阻塞返回导致通知多次)
            Thread asyncThread = new Thread("asyncDataHandlerThread") {
                public void run() {
                    System.out.println("异步执行商户自己的业务逻辑...");
                    try {
                        String verify_status = reqObject.getString("verify_status");//身份验证结果 1-姓名号码一致 2-姓名号码不一致 3-查询无结果
                        String auth_result = reqObject.getString("auth_result");//人像比对结果 T:通过 F:未通过
                        String fail_reason = reqObject.getString("fail_reason");//人像不通过原因
                        if (!(verify_status.equals("1"))){
                                logger.info("身份验证失败");
                                return;
                        } else if (!("T").equals(auth_result)){
                            logger.info("人像比对未通过,原因是:"+fail_reason);
                            return;
                        }
                        String partner_order_id = reqObject.getString("partner_order_id");
                        String memberId = partner_order_id.split("_")[0];
                        String id_name = reqObject.getString("id_name");
                        String id_number = reqObject.getString("id_number");
                        String ethnicity = reqObject.getString("nation");
                        String age = reqObject.getString("age");
                        String sex = reqObject.getString("gender");
                        if (sex.equals("男")){
                            sex = "0";
                        } else {
                            sex = "1";
                        }
                        String dateOfBirth = reqObject.getString("birthday");
                        String permanentAddress = reqObject.getString("address");
                        String issuingAuthority = reqObject.getString("issuing_authority");
                        String periodOfValidity = reqObject.getString("validity_period");
                        MemberDetail memberDetail = memberService.queryMemberDetailByMemberId(Long.parseLong(memberId));
                        if (memberDetail!=null){
                            memberDetail.setMemberid(Long.parseLong(memberId));
                            memberDetail.setFullname(id_name);
                            memberDetail.setIdCard(id_number);
                            memberDetail.setPeriodOfValidity(periodOfValidity.replace(".","-"));
                            memberDetail.setEthnicity(ethnicity);
                            memberDetail.setAge(Integer.parseInt(age));
                            memberDetail.setDateOfBirth(dateOfBirth.replace(".","-"));
                            memberDetail.setSex(Integer.parseInt(sex));
                            memberDetail.setPermanentAddress(permanentAddress);
                            memberDetail.setIssuingAuthority(issuingAuthority);
                            int index = memberService.uppMemberDetail(memberDetail);
                            if (index>0){
                                logger.info("身份信息数据更新成功");
                            } else{
                                logger.info("身份信息数据更新失败");
                            }
                        }else {
                            MemberDetail memberDetail1 = new MemberDetail();
                            memberDetail1.setMemberid(Long.parseLong(memberId));
                            memberDetail1.setFullname(id_name);
                            memberDetail1.setIdCard(id_number);
                            memberDetail1.setPeriodOfValidity(periodOfValidity.replace(".", "-"));
                            memberDetail1.setEthnicity(ethnicity);
                            memberDetail1.setAge(Integer.parseInt(age));
                            memberDetail1.setDateOfBirth(dateOfBirth.replace(".", "-"));
                            memberDetail1.setSex(Integer.parseInt(sex));
                            memberDetail1.setPermanentAddress(permanentAddress);
                            memberDetail1.setIssuingAuthority(issuingAuthority);
                            int index = memberService.addMemberDetail(memberDetail1);
                            if (index > 0) {
                                logger.info("身份信息数据插入成功");
                            } else {
                                logger.info("身份信息数据插入失败");
                            }
                        }
                        String idcard_front_photo = reqObject.getString("idcard_front_photo");//身份证证件正面照
                        String idcard_portrait_photo = reqObject.getString("idcard_portrait_photo");//身份证证件正面头像照
                        String idcard_back_photo = reqObject.getString("idcard_back_photo");//身份证证件背面照
                        String living_photo = reqObject.getString("living_photo");//活体清晰照
                       /* String living_video = reqObject.getString("living_video");//活体视频url*/
                        String idcard_front_photo_path = headIconLocation+identifyClassify+format.format(new Date())+ "/"+memberId + "/" + "idcard_front_photo.jpg";
                        String idcard_portrait_photo_path = headIconLocation+identifyClassify+format.format(new Date())+ "/"+memberId + "/" + "idcard_portrait_photo.jpg";
                        String idcard_back_photo_path = headIconLocation+identifyClassify+format.format(new Date())+ "/"+memberId + "/" + "idcard_back_photo.jpg";
                        String living_photo_path = headIconLocation+identifyClassify+format.format(new Date())+ "/"+memberId + "/" + "living_photo.jpg";
                       /* String living_video_path = headIconLocation+identifyClassify+format.format(new Date())+ "/"+memberId + "/" + "living_video";*/
                        if (("0").equals(fileWrite(getByte(idcard_front_photo),idcard_front_photo_path))){
                            logger.info("身份证证件正面照存入硬盘成功");
                        } else {
                            logger.info("身份证证件正面照存入硬盘失败");
                        }
                        if (("0").equals(fileWrite(getByte(idcard_portrait_photo),idcard_portrait_photo_path))){
                            logger.info("身份证证件正面头像照存入硬盘成功");
                        } else {
                            logger.info("身份证证件正面头像照存入硬盘失败");
                        }
                        if (("0").equals(fileWrite(getByte(idcard_back_photo),idcard_back_photo_path))){
                            logger.info("身份证证件背面照存入硬盘成功");
                        } else {
                            logger.info("身份证证件背面照存入硬盘失败");
                        }
                        if (("0").equals(fileWrite(getByte(living_photo),living_photo_path))){
                            logger.info("活体清晰照存入硬盘成功");
                        } else {
                            logger.info("活体清晰照存入硬盘失败");
                        }
                        /*if (fileWrite(getByte(living_video),living_video_path).equals("0")){
                            logger.info("活体视频url存入硬盘成功");
                        } else {
                            logger.info("活体视频url存入硬盘失败");
                        }*/
                        //将图片以及视频文件目录存入数据库
                        CertificationFile certificationFile = certificationFileService.queryByMemberId(Long.parseLong(memberId));
                        if (certificationFile!=null){
                            certificationFile.setMemberid(Long.parseLong(memberId));
                            certificationFile.setIdcardFrontPhotoPath(idcard_front_photo_path);
                            certificationFile.setIdcardPortraitPhotoPath(idcard_portrait_photo_path);
                            certificationFile.setIdcardBackPhotoPath(idcard_back_photo_path);
                            certificationFile.setLivingPhotoPath(living_photo_path);
                            int index = certificationFileService.updateCertification(certificationFile);
                            if (index>0){
                                logger.info("文件目录更新成功");
                            } else{
                                logger.info("文件目录更新失败");
                            }
                        } else{
                            CertificationFile certificationFile1 = new CertificationFile();
                            certificationFile1.setMemberid(Long.parseLong(memberId));
                            certificationFile1.setIdcardFrontPhotoPath(idcard_front_photo_path);
                            certificationFile1.setIdcardPortraitPhotoPath(idcard_portrait_photo_path);
                            certificationFile1.setIdcardBackPhotoPath(idcard_back_photo_path);
                            certificationFile1.setLivingPhotoPath(living_photo_path);
                            //  certificationFile.setLivingVideoPath(living_video_path);
                            int index2 = certificationFileService.addCertification(certificationFile1);
                            if (index2>0){
                                logger.info("文件录入数据库成功");
                            } else{
                                logger.info("文件录入数据库失败");
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            asyncThread.start();
        }

        System.out.println("返回结果：" + respJson.toJSONString());
        //返回结果
        response.setCharacterEncoding(CHARSET_UTF_8);
        response.setContentType("application/json; charset=utf-8");
        response.getOutputStream().write(respJson.toJSONString().getBytes(CHARSET_UTF_8));
    }

    /**
     * 获取请求json对象
     */
    private JSONObject getRequestJson(HttpServletRequest request) throws IOException {
        InputStream in = request.getInputStream();
        byte[] b = new byte[10240];
        int len;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while ((len = in.read(b)) > 0) {
            baos.write(b, 0, len);
        }
        String bodyText = new String(baos.toByteArray(), CHARSET_UTF_8);
        JSONObject json = (JSONObject) JSONObject.parse(bodyText);
        if (IS_DEBUG) {
            System.out.println("received notify message:");
            System.out.println(JSON.toJSONString(json, true));
        }
        return json;
    }
    private byte[] getByte(String data){
        BASE64Decoder decoder = new BASE64Decoder();
        try{
            byte[] dataByte = decoder.decodeBuffer(data);
            for(int i=0;i<dataByte.length;++i)
            {
                if(dataByte[i]<0)
                {//调整异常数据
                    dataByte[i]+=256;
                }
            }
            return dataByte;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    private String fileWrite(byte[] data,String path){
        if(data.length<3||path.equals("")){
            return "1";
        } else {
            try{
                File dest = new File(path);
                if (!dest.getParentFile().exists()) dest.getParentFile().mkdirs();
                FileOutputStream urlOutput = new FileOutputStream(dest);//打开输入流
                urlOutput.write(data, 0, data.length);//将byte写入硬盘
                urlOutput.close();
                return "0";
            } catch(Exception ex) {
                System.out.println("Exception: " + ex);
                ex.printStackTrace();
            }
        }
        return "1";
    }
}

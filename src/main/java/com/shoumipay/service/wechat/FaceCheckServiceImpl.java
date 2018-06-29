package com.shoumipay.service.wechat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shoumipay.tools.DateUtil;
import com.shoumipay.tools.wechat.HttpRequestUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import static com.shoumipay.tools.DateUtil.LOG_DATE_TIME;
import static com.shoumipay.tools.wechat.MD5Utils.getMD5Sign;
@Service
public class FaceCheckServiceImpl implements FaceCheckService {
    //商户公钥
    static final String pub_key = "0feefe59-1831-4264-ad41-91eb1ce158e7";
    //商户密钥
    static final String security_key = "1f5bdd58-2910-4c93-be92-09b7fe9178bf";

    //身份证正面OCR接口
    static final String IDCARD_FRONT_OCR = "https://idsafe-auth.udcredit.com/front/4.3/api/idcard_front_photo_ocr/pub_key/" + pub_key;
    //身份证背面OCR接口
    static final String IDCARD_BACK_OCR = "https://idsafe-auth.udcredit.com/front/4.3/api/idcard_back_photo_ocr/pub_key/" + pub_key;
    //OCR识别更新接口
    static final String UPDATE_OCR_INFO = "https://idsafe-auth.udcredit.com/front/4.3/api/update_ocr_info/pub_key/" + pub_key;
    //实名验证接口
    static final String IDCARD_VERIFY = "https://idsafe-auth.udcredit.com/front/4.3/api/idcard_verify/pub_key/" + pub_key;
    //人脸比对接口
    static final String FACE_COMPARE = "https://idsafe-auth.udcredit.com/front/4.3/api/face_compare/pub_key/" + pub_key;
    @Override
    public JSONObject idCardFrontOCR(String frontPicture) {
        JSONObject reqJson = new JSONObject();
        //调用OCR识别-正面
        try{
            reqJson.put("header", getRequestHeader(""));
            JSONObject body = new JSONObject();
            body.put("idcard_front_photo", frontPicture);
            reqJson.put("body", body);
            System.out.println("身份证正面OCR识别-输入参数：" + JSON.toJSONString(reqJson, true));
            String result = HttpRequestUtils.sendPost(IDCARD_FRONT_OCR, reqJson.toString(),true);
            System.out.println("身份证正面OCR识别-输出结果：" +result);
            JSONObject json = JSON.parseObject(result);
            return json;
        } catch (IOException io){
            io.printStackTrace();
        }
        return null;
    }

    @Override
    public JSONObject idCardBackOCR(String backPicture) {
        JSONObject reqJson = new JSONObject();
        //调用OCR识别-正面
        try{
            reqJson.put("header", getRequestHeader(""));
            JSONObject body = new JSONObject();
            body.put("idcard_back_photo", backPicture);
            reqJson.put("body", body);
            System.out.println("身份证反面OCR识别-输入参数：" + JSON.toJSONString(reqJson, true));
            String result = HttpRequestUtils.sendPost(IDCARD_BACK_OCR, reqJson.toString(),true);
            JSONObject json = JSON.parseObject(result);
            System.out.println("身份证反面OCR识别-输出结果：" +result);
            return json;
        } catch (IOException io){
            io.printStackTrace();
        }
        return null;
    }

    @Override
    public JSONObject updateIdcardFrontOCR(String id_name, String id_number) {
        JSONObject reqJson = new JSONObject();
        //调用OCR识别更新
        JSONObject jsonObject = idCardFrontOCR("");
        JSONObject json = jsonObject.getJSONObject("data");
        String session_id = json.getString("session_id");
        try{
            reqJson.put("header", getRequestHeader(session_id));
            JSONObject body = new JSONObject();
            body.put("id_name", id_name);
            body.put("id_number", id_number);
            reqJson.put("body", body);
            System.out.println("OCR身份信息更新-输入参数：" + JSON.toJSONString(reqJson, true));
            String resp_front = HttpRequestUtils.sendPost(UPDATE_OCR_INFO, reqJson.toString(),true);
            System.out.println("OCR身份信息更新-输出结果：" + resp_front);
            JSONObject resultJson = JSON.parseObject(resp_front);
            return resultJson;
        }catch (IOException io){
            io.printStackTrace();
        }
        return null;
    }

    @Override
    public JSONObject idCardVerify(String id_number, String id_name) {
        JSONObject reqJson = new JSONObject();
        try{
            reqJson.put("header", getRequestHeader(""));
            JSONObject body = new JSONObject();
            body.put("id_number", id_number);
            body.put("id_name", id_name);
            body.put("verify_type", "1");
            reqJson.put("body", body);
            System.out.println("实名验证接口-输入参数：" + JSON.toJSONString(reqJson, true));
            String resp_front = HttpRequestUtils.sendPost(IDCARD_VERIFY, reqJson.toString(),true);
            System.out.println("实名验证接口-输出结果：" + resp_front);
            JSONObject resultJson = JSON.parseObject(resp_front);
            return resultJson;
        } catch (IOException io){
            io.printStackTrace();
        }
        return null;
    }

    @Override
    public JSONObject faceCompare(String sessionId,String photo1,String photo2) {
        JSONObject reqJson = new JSONObject();
        try{
            reqJson.put("header", getRequestHeader(sessionId));
            JSONObject body = new JSONObject();
            //photo1参数
            JSONObject photo1JSON = new JSONObject();
            photo1JSON.put("img_file_source","2");
            photo1JSON.put("img_file_type","1");
            photo1JSON.put("img_file",photo1);
            body.put("photo1", photo1JSON);
            //photo2参数
            JSONObject photo2JSON = new JSONObject();
            photo2JSON.put("img_file_source","2");
            photo2JSON.put("img_file_type","1");
            photo2JSON.put("img_file",photo2);
            body.put("photo2", photo2JSON);
            reqJson.put("body", body);
            System.out.println("人脸比对接口-输入参数：" + JSON.toJSONString(reqJson, true));
            String resp_front = HttpRequestUtils.sendPost(FACE_COMPARE, reqJson.toString(),true);
            System.out.println("人脸比对接口-输出结果：" + resp_front);
            JSONObject resultJSON = JSON.parseObject(resp_front);
            return resultJSON;
        }catch (IOException io){
            io.printStackTrace();
        }
        return null;
    }
    /**
     * 生成请求header
     */
    JSONObject getRequestHeader(String session_id) throws IOException {
        JSONObject header = new JSONObject();
        if (session_id != null && !session_id.equals("")) {
            header.put("session_id", session_id);
        }
        String sign_time = DateUtil.format(new Date(),LOG_DATE_TIME);
        String partner_order_id = UUID.randomUUID().toString();
        String sign = getMD5Sign(pub_key, partner_order_id, sign_time, security_key);
        header.put("partner_order_id", partner_order_id);
        header.put("sign", sign);
        header.put("sign_time", sign_time);
        return header;
    }

}

package com.shoumipay.service.wechat;

import com.alibaba.fastjson.JSONObject;

public interface FaceCheckService {
    JSONObject idCardFrontOCR(String frontPicture);
    JSONObject idCardBackOCR(String backPicture);
    JSONObject updateIdcardFrontOCR(String id_name, String id_number);
    JSONObject idCardVerify(String id_number, String id_name);
    JSONObject faceCompare(String sessionId,String photo1,String photo2);
}

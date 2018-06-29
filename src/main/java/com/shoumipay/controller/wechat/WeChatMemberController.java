package com.shoumipay.controller.wechat;

import com.alibaba.fastjson.JSONObject;
import com.shoumipay.controller.wechat.base.BaseController;
import com.shoumipay.domain.MemberDetail;
import com.shoumipay.v2.service.MemberService;
import com.shoumipay.service.wechat.FaceCheckService;
import com.shoumipay.tools.StringUtil;
import com.shoumipay.tools.wechat.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/wx/member")
public class WeChatMemberController extends BaseController {
    @Autowired
    private FaceCheckService faceCheckService;
    @Autowired
    private MemberService memberService;

    @RequestMapping("/idcard")
    @Permission
    public String idCard(String pictureFront, String pictureBack, Model model) {
        String msg = "";
        if (StringUtil.isNull(pictureFront) || StringUtil.isNull(pictureBack)) {
            //return new Message(FLAG_UPLOAD_ERROR);
            msg = "图片上传失败,请再次尝试";
            model.addAttribute("msg", msg);
            return "h5/member/submit/idcard";
        } else {
            int indexFront = pictureFront.indexOf(",");
            String picFront = pictureFront.substring(indexFront + 1, pictureFront.length());
            int indexBack = pictureBack.indexOf(",");
            String picBack = pictureBack.substring(indexBack + 1, pictureBack.length());
            JSONObject frontJSON = faceCheckService.idCardFrontOCR(picFront);
            JSONObject backJSON = faceCheckService.idCardBackOCR(picBack);
            if ((Boolean) frontJSON.getJSONObject("result").get("success") && (Boolean) backJSON.getJSONObject("result").get("success")) {
                //身份信息插入数据库
                //   Member member = getLoginMember();
                MemberDetail memberDetail = new MemberDetail();
                //  memberDetail.setMemberid(member.getUid());
                memberDetail.setFullname(frontJSON.getJSONObject("data").getString("id_name"));
                memberDetail.setIdCard(frontJSON.getJSONObject("data").getString("id_number"));
                String periodOfValidity = backJSON.getJSONObject("data").getString("validity_period");
                memberDetail.setPeriodOfValidity(periodOfValidity.replace(".", "-"));
                memberDetail.setEthnicity(frontJSON.getJSONObject("data").getString("nation"));
                memberDetail.setAge(Integer.parseInt(frontJSON.getJSONObject("data").getString("age")));
                String dateOfBirth = frontJSON.getJSONObject("data").getString("birthday");
                memberDetail.setDateOfBirth(dateOfBirth.replace(".", "-"));
                String gender = frontJSON.getJSONObject("data").getString("gender");
                if (gender.equals("男")) {
                    gender = "0";
                } else {
                    gender = "1";
                }
                memberDetail.setSex(Integer.parseInt(gender));
                memberDetail.setPermanentAddress(frontJSON.getJSONObject("data").getString("address"));
                memberDetail.setIssuingAuthority(backJSON.getJSONObject("data").getString("issuing_authority"));
                /*int index = memberService.addMemberDetail(memberDetail);
                if (index>0){
                    logger.info("身份信息数据插入成功");
                } else{
                    logger.info("身份信息数据插入失败");
                }*/
                model.addAttribute("frontJSON", frontJSON.getJSONObject("data"));
                model.addAttribute("backJSON", backJSON.getJSONObject("data"));
                return "h5/member/submit/idinfo";
            } else {
                return "h5/member/submit/idinfo_result";
            }
        }
    }

    @RequestMapping("/faceverify")
    @Permission
    public String faceverify() {
        return "h5/member/start/faceverify";
    }

    @RequestMapping("/faceverifyForm")
    @Permission
    public String faceverifyForm(String pictureFace, Model model) {
        String msg = "";
        if (StringUtil.isNull(pictureFace)) {
            //return new Message(FLAG_UPLOAD_ERROR);
            msg = "图片上传失败,请再次尝试";
            model.addAttribute("msg", msg);
            return "h5/member/start/faceverify";
        } else {
            //int indexBack = pictureFace.indexOf(",");
            //String picBack = pictureFace.substring(indexBack+1,pictureFace.length());
            if (true) {
                JSONObject result = new JSONObject();
                //return  Message.success();
                result.put("name", "柴志云");
                model.addAttribute("result", result);
                return "h5/myself";
            } else {
                //return new Message(FLAG_UPLOAD_ERROR);
                model.addAttribute("msg", "图片不清晰，请重新拍照");
                return "h5/member/start/faceverify";
            }
        }
    }
}

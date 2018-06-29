package com.shoumipay.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shoumipay.constants.SmsEnum;
import com.shoumipay.domain.*;
import com.shoumipay.service.SesameCreditService;
import com.shoumipay.service.admin.*;
import com.shoumipay.tools.*;
import com.shoumipay.v2.service.MemberService;
import com.shoumipay.vo.CountOrderStatusVO;
import com.shoumipay.vo.MemberVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Zhw on 2017/10/16.
 */
@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private SesameCreditService sesameCreditService;
    @Autowired
    private GoodsOrderService orderService;
    @Autowired
    private AddressBookService addressBookService;
    @Autowired
    private MessageSendService messageSendService;

    @RequestMapping("")
    @RequiresPermissions("member:all")//权限管理;
    public String member(Model model, Integer status, String phoneNumber) {
        if (status != null) {
            model.addAttribute("sataus", status);
            model.addAttribute("satausName", status == 2 ? "加入" : "移除");
        }
        model.addAttribute("phoneNumber", phoneNumber);
        return "member-list";
    }

    @RequestMapping(value = "/queryMemberList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    //@RequiresPermissions("member:queryMemberList")//权限管理;
    public void queryMemberList(Long orderId, Integer status, Integer page, Integer rows, String phoneNumber, String fullname, String startTime, String endTime, Integer authenticationStatus
            , Integer orderStatusPay, Integer orderNum, HttpServletResponse response) throws ParseException {
        if (status != null) {
            status = (status == 1 ? 2 : 1);
        }
        StringBuffer idsBuffer = new StringBuffer();
        if (orderNum != null) {
            List<CountOrderStatusVO> countOrderStatusVOList = memberService.selectByCount();
            for (CountOrderStatusVO countOrderStatusVO : countOrderStatusVOList) {
                if (orderNum == countOrderStatusVO.getOrderNum()) {
                    idsBuffer.append(countOrderStatusVO.getMemberId().toString() + ",");
                }
            }
            if (idsBuffer.length() > 0) {
                idsBuffer.deleteCharAt(idsBuffer.length() - 1);
                orderStatusPay = 10;
            }
        } else {
            idsBuffer.append("000");
        }
        if (orderId != null) {
            GoodsOrder goodsOrder = orderService.getOrderById(orderId);
            String memberId = goodsOrder.getMemberId().toString();
            idsBuffer.append(memberId);
        }
        String ids = idsBuffer.toString();
        List<MemberVO> memberVOS = memberService.queryMemberVO(status, phoneNumber, fullname, page, rows, startTime, endTime, authenticationStatus, orderStatusPay, ids);
        if (memberVOS != null && memberVOS.size() > 0) {
            for (MemberVO memberVO : memberVOS) {
                memberVO.setUseAmount(memberService.getMemeberBalance(memberVO.getUid()));
            }
        }
        PageInfo<MemberVO> pageInfo = new PageInfo<>(memberVOS);
        JSONObject jo = new JSONObject();
        jo.put("rows", memberVOS);
        jo.put("total", pageInfo.getPages());//总页数
        jo.put("records", pageInfo.getTotal());//查询出的总记录数
        ServletUtil.createSuccessResponse(200, jo, response);
    }

    private List<MemberVO> removeVO(List<MemberVO> memberVOS) {
        if (memberVOS != null && memberVOS.size() > 0) {
            for (int i = 0; i < memberVOS.size(); i++) {
                for (int j = i + 1; j < memberVOS.size(); j++) {
                    if (memberVOS.get(i).getUid().equals(memberVOS.get(j).getUid())) {
                        memberVOS.remove(memberVOS.get(j));
                    }
                }
            }
        }
        return memberVOS;
    }

    @RequestMapping("/blacklist")
    public void uppBlacklist(HttpServletRequest request, HttpServletResponse response) {
        String ids = request.getParameter("ids");
        String status = request.getParameter("status");
        Integer state = IntegerUtil.parseInt(status);
        long index = memberService.uppMemberState(ids.split(","), state);//2为黑名单
        MessageUtil.uppOrAddMessage(index, "修改成功", "修改失败", response);
    }

    @RequestMapping(value = "/checkUserName", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    //@RequiresPermissions("member:checkUserName")//权限管理;
    public void checkMemberUserName(HttpServletResponse response, String username) {
        boolean checkResult = memberService.checkUserName(username);
        JSONObject result = new JSONObject();
        if (checkResult) {
            result.put("flag", true);
        } else {
            result.put("flag", false);
        }
        ServletUtil.createSuccessResponse(200, result, response);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    //@RequiresPermissions("member:add")//权限管理;
    public void addMember(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        JSONObject result = UserUtil.userValidityDetection(name, username, password);
        if (result != null) {
            ServletUtil.createSuccessResponse(200, result, response);
            return;
        } else {
            result = new JSONObject();
        }
        Member member = new Member(name, username, password);
        Long index = memberService.addMember(member);
        MessageUtil.uppOrAddMessage(index, "账号添加成功!", "账号添加失败!", response);
    }

    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    //@RequiresPermissions("member:updateByPrimaryKey")//权限管理;
    public void update(HttpServletRequest request, HttpServletResponse response) {
        String uid = request.getParameter("uid");
        Member member = memberService.queryByUid(LongUtil.parseLong(uid));
        if (member == null) {
            MessageUtil.failMessageFlag("系统异常请重试!", response);
            return;
        }
        String name = request.getParameter("name");
        if (StringUtil.isNull(name)) {
            MessageUtil.failMessageFlag("名称不能为空!", response);
            return;
        }
        String oldpassword = request.getParameter("oldpassword");
        if (StringUtil.isNull(oldpassword)) {
            MessageUtil.failMessageFlag("请输入旧密码!", response);
            return;
        }
        String passwordMySQL = UserUtil.getMD5Password(oldpassword, member);
        if (!passwordMySQL.equals(member.getPassword())) {
            MessageUtil.failMessageFlag("旧密码错误!", response);
            return;
        }
        String password = request.getParameter("password");
        if (StringUtil.isNull(password)) {
            MessageUtil.failMessageFlag("新密码不能为空!", response);
            return;
        }
        if (!ValidatorUtil.isPasswd(password)) {
            MessageUtil.failMessageFlag("新密码只能是数字或者字母，并且长度为6-12位!", response);
            return;
        }
        member.setName(name);
        member.setPassword(UserUtil.getMD5Password(password, member));
        int index = memberService.updateMember(member);
        MessageUtil.uppOrAddMessage(index, "账号修改成功!", "账号修改失败!", response);
    }

    @RequestMapping(value = "/queryMemberDetailByMemberId", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    //@RequiresPermissions("memberDetail:query")//权限管理;
    public void queryMemberDetailByMemberId(Long memberid, HttpServletResponse response) {
        MemberDetail memberDetail = memberService.queryMemberDetailByMemberId(memberid);
        if (memberDetail == null) {
            memberDetail = new MemberDetail();
            memberDetail.setMemberid(memberid);
        }
        ServletUtil.createSuccessResponse(200, memberDetail, response);
    }

    @PostMapping(value = "/addDetail")
    //@RequiresPermissions("memberDetail:addDetail")//权限管理;
    public void addDetail(MemberDetail memberDetail, HttpServletResponse response) {
        int index = 0;
        if (memberDetail.getId() == null) {
            index = memberService.addMemberDetail(memberDetail);
        } else {
            index = memberService.uppMemberDetail(memberDetail);
        }
        MessageUtil.uppOrAddMessage(index, "信息修改成功!", "信息修改失败!", response);
    }

    @RequestMapping(value = "/queryLinkmanByMemberId", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    //@RequiresPermissions("memberLinkman:query")//权限管理;
    public void queryLinkmanByMemberId(Long memberid, HttpServletResponse response) {
        MemberLinkman memberLinkman = memberService.queryLinkmanByMemberId(memberid);
        if (memberLinkman == null) {
            memberLinkman = new MemberLinkman();
            memberLinkman.setMemberid(memberid);
        }
        ServletUtil.createSuccessResponse(200, memberLinkman, response);
    }

    @PostMapping(value = "/addLinkman")
    //@RequiresPermissions("memberLinkman:addLinkman")//权限管理;
    public void addLinkman(MemberLinkman memberLinkman, HttpServletResponse response) {
        int index = 0;
        if (memberLinkman.getId() == null) {
            index = memberService.addMemberLinkman(memberLinkman);
        } else {
            index = memberService.uppMemberLinkman(memberLinkman);
        }
        MessageUtil.uppOrAddMessage(index, "联系人修改成功!", "联系人修改失败!", response);
    }

    @RequestMapping(value = "/queryJobByMemberId", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    //@RequiresPermissions("memberJob:query")//权限管理;
    public void queryJobByMemberId(Long memberid, HttpServletResponse response) {
        MemberJobs memberJobs = memberService.queryJobByMemberId(memberid);
        if (memberJobs == null) {
            memberJobs = new MemberJobs();
            memberJobs.setMemberid(memberid);
        }
        ServletUtil.createSuccessResponse(200, memberJobs, response);
    }

    @PostMapping(value = "/addJob")
    //@RequiresPermissions("memberJob:addJob")//权限管理;
    public void addJob(MemberJobs memberJobs, HttpServletResponse response) {
        int index = 0;
        if (memberJobs.getId() == null) {
            index = memberService.addMemberJob(memberJobs);
        } else {
            index = memberService.uppMemberJob(memberJobs);
        }
        MessageUtil.uppOrAddMessage(index, "职业修改成功!", "职业修改失败!", response);
    }

    @RequestMapping(value = "/queryDevicesByMemberId", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    //@RequiresPermissions("memberDevices:query")//权限管理;
    public void queryDevicesByMemberId(Long memberid, HttpServletResponse response) {
        MemberDevices memberDevices = memberService.queryDevicesByMemberId(memberid);
        if (memberDevices == null) {
            memberDevices = new MemberDevices();
            memberDevices.setMemberid(memberid);
        }
        ServletUtil.createSuccessResponse(200, memberDevices, response);
    }

    @PostMapping(value = "/addDevices")
    //@RequiresPermissions("memberDevices:addDevices")//权限管理;
    public void addDevices(MemberDevices memberDevices, HttpServletResponse response) {
        int index = 0;
        if (memberDevices.getId() == null) {
            index = memberService.addMemberDevices(memberDevices);
        } else {
            index = memberService.uppMemberDevices(memberDevices);
        }
        MessageUtil.uppOrAddMessage(index, "设备修改成功!", "设备修改失败!", response);
    }

    //银行卡
    @PostMapping(value = "/queryBankcardByMemberId")
    //@RequiresPermissions("memberBankcard:queryMemberId")
    public void queryBankcardByMemberId(Long memberid, HttpServletResponse response) {
        List<MemberBankcard> memberBankcardList = memberService.queryBankcardByMemberId(memberid);
        ServletUtil.createSuccessResponse(200, memberBankcardList, response);
    }

    @PostMapping(value = "/queryBankcardByCardId")
    //@RequiresPermissions("memberBankcard:queryCardId")
    public void queryBankcardByCardId(Long cardId, HttpServletResponse response) {
        MemberBankcard memberBankcard = memberService.queryBankcardByBankcardId(cardId);
        ServletUtil.createSuccessResponse(200, memberBankcard, response);
    }

    @PostMapping(value = "/addBankcard")
    //@RequiresPermissions("memberBankcard:addBankcard")
    public void addBankcard(Long id, MemberBankcard memberBankcard, HttpServletResponse response) {
        int index = 0;
        if (id != null) {
            index = memberService.delMemberBankcard(id);
        } else {
            if (memberBankcard.getCardid() == null) {
                index = memberService.addMemberBankcard(memberBankcard);
            } else {
                index = memberService.uppMemberBankcard(memberBankcard);
            }
        }
        MessageUtil.uppOrAddMessage(index, "银行卡修改成功!", "银行卡修改失败!", response);
    }

    @PostMapping(value = "/delBankcard")
    //@RequiresPermissions("memberBankcard:delBankcard")
    public void delBankcard(Long cardId, HttpServletResponse response) {
        int index = 0;
        if (cardId != null) {
            index = memberService.delMemberBankcard(cardId);
        }
        MessageUtil.uppOrAddMessage(index, "银行卡删除成功!", "银行卡删除失败!", response);
    }

    @RequestMapping(value = "/alizhima")
    public void queryZhimaByid(Long id, HttpServletResponse response) {
        SesameCredit sesameCredit = sesameCreditService.selectByLatest(id);
        ServletUtil.createSuccessResponse(200, sesameCredit, response);
    }

    @PostMapping("/addressBook")
    public void queryAddressBook(Long id, Integer page, Integer rows, HttpServletResponse response) {
        if (page != null && rows != null) {
            PageHelper.startPage(page, rows);
        }
        List<AddressBook> addressBooks = addressBookService.queryAddressBookByMemberId(id);
        PageInfo<AddressBook> pageInfo = new PageInfo<>(addressBooks);
        JSONObject jo = new JSONObject();
        jo.put("rows", addressBooks);
        jo.put("total", pageInfo.getPages());//总页数
        jo.put("records", pageInfo.getTotal());//查询出的总记录数*/
        ServletUtil.createSuccessResponse(200, jo, response);
    }

    @PostMapping("/sendSms")
    public void sendSms(HttpServletRequest request, HttpServletResponse response) {
        String ids = request.getParameter("ids");
        String[] idList = ids.split(",");
        List<String> phoneList = new LinkedList<>();
        for (String id : idList) {
            AddressBook addressBook = addressBookService.queryById(Long.parseLong(id));
            String phone = addressBook.getNumber();
            phone = phone.replaceAll(" ", "");
            phone = phone.replaceAll("-", "");
            phone = phone.replaceAll("\\+86", "");
            phoneList.add(phone);
        }
        System.out.println(phoneList);
        int index = messageSendService.messSend(phoneList, SmsEnum.CODE, null, "123456");
        if (index > 0) {
            ServletUtil.createSuccessResponse(200, "短信发送成功", response);
        } else {
            ServletUtil.createSuccessResponse(200, "短信发送失败", response);
        }
    }
}

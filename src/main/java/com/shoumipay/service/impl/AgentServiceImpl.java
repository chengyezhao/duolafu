package com.shoumipay.service.impl;

import com.github.pagehelper.PageHelper;
import com.shoumipay.dao.MemberAgentMapper;
import com.shoumipay.domain.MemberAgent;
import com.shoumipay.service.admin.AgentService;
import com.shoumipay.vo.AgentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class AgentServiceImpl implements AgentService{
    @Autowired
    MemberAgentMapper memberAgentMapper;

    @Override
    public List<AgentVO> selectAgentRecordVO(Map<String, String> param, Long id,Long agentId) {
        SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date start = null;
        Date end = null;
        try {
            if (param.get("startTime") != "" && param.get("endTime") != "") {
                start = bartDateFormat.parse(param.get("startTime"));
                end = bartDateFormat.parse(param.get("endTime"));
                if (start.getTime()>end.getTime()){
                    Date time = null;
                    time = start;
                    start = end;
                    end = time;
                }
            }
            PageHelper.startPage(Integer.parseInt(param.get("page").toString()), Integer.parseInt(param.get("rows").toString()));
            return memberAgentMapper.selectAgentRecordVO(id,agentId,start,end);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<AgentVO> selectVo(Map<String,String> param,Long agentId,Long memberId) {
        SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date start = null;
        Date end = null;
        try {
            if (param==null){
                return memberAgentMapper.selectVO(agentId,memberId,start,end);
            }
            if (param.get("startTime") != "" && param.get("endTime") != "") {
                start = bartDateFormat.parse(param.get("startTime"));
                end = bartDateFormat.parse(param.get("endTime"));
                if (start.getTime()>end.getTime()){
                    Date time = null;
                    time = start;
                    start = end;
                    end = time;
                }
            }
            PageHelper.startPage(Integer.parseInt(param.get("page").toString()), Integer.parseInt(param.get("rows").toString()));
            return memberAgentMapper.selectVO(agentId,memberId,start,end);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<AgentVO> queryByTimeId(Map<String, String> param, Long memberId,String agentType) {
        SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startTime = null;
        Date endTime = null;
        try {
            if (param.get("startTime")!=""&&param.get("endTime")!="") {
                startTime = bartDateFormat.parse(param.get("startTime"));
                endTime = bartDateFormat.parse(param.get("endTime"));
                if (startTime.getTime()>endTime.getTime()){
                    Date time = null;
                    time = startTime;
                    startTime = endTime;
                    endTime = time;
                }
            }
            PageHelper.startPage(Integer.parseInt(param.get("page").toString()), Integer.parseInt(param.get("rows").toString()));
            return memberAgentMapper.queryByTimeIdVO(memberId,agentType,startTime,endTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int insertAgent(MemberAgent memberAgent) {
        return memberAgentMapper.insertSelective(memberAgent);
    }
}

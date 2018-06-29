package com.shoumipay.service.impl;

import com.github.pagehelper.PageHelper;
import com.shoumipay.dao.NoticeMapper;
import com.shoumipay.dao.NoticeMemberMapper;
import com.shoumipay.domain.Notice;
import com.shoumipay.domain.NoticeExample.Criteria;
import com.shoumipay.domain.NoticeExample;
import com.shoumipay.domain.NoticeMember;
import com.shoumipay.service.admin.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by Tang on 2017/10/30.
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper mapper;
    @Autowired
    private NoticeMemberMapper noticeMemberMapper;

    @Override
    public Notice selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Notice> find(Long memberId, Boolean read, Integer firstRow, Integer size) {
        List<Notice> list = mapper.findNotMatch(memberId);
        if (null != list && 0 < list.size()) {
            for (Notice n : list) {
                noticeMemberMapper.insert(new NoticeMember(n.getId(), memberId, false));
            }
        }
        list = mapper.find(memberId, read, firstRow, size);
        return list;
    }

    @Override
    public Long unread(Long memberId) {
        return mapper.unread(memberId);
    }

    @Override
    public void updateRead(Long id) {
        mapper.updateRead(id);
    }

    @Override
    public int addNotice(Notice notice) {
        return mapper.insertSelective(notice);
    }

    @Override
    public void updateAllRead(Long memberId) {
        mapper.updateAllRead(memberId);
    }

    @Override
    public int updateNotice(Notice notice) {
        return mapper.updateByPrimaryKeySelective(notice);
    }

    @Override
    public List<Notice> findByNotice(Notice notice,Map<String,String> map) {
        SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            java.util.Date startTime = bartDateFormat.parse(map.get("startTime"));
            java.util.Date endTime = bartDateFormat.parse(map.get("endTime"));
            NoticeExample noticeExample = new NoticeExample();
            Criteria criteria = noticeExample.createCriteria();
            if (notice.getActive()==0){
                criteria.andActiveEqualTo(notice.getActive());
            }
            if (startTime!=null&&endTime!=null){
                criteria.andCreateTimeBetween(startTime,endTime);
            }
            if (notice.getType()!=null&&notice.getType().trim().length()>0){
                criteria.andTypeEqualTo(notice.getType());
            }
            if (notice.getProcessor()!=null){
                criteria.andProcessorEqualTo(notice.getProcessor());
            }
            PageHelper.startPage(Integer.parseInt(map.get("page").toString()), Integer.parseInt(map.get("rows").toString()));
            return mapper.selectByExample(noticeExample);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

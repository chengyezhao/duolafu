package com.shoumipay.service.admin;

import com.shoumipay.domain.Notice;

import java.util.List;
import java.util.Map;

/**
 * Created by Tang on 2017/10/30.
 */
public interface NoticeService {
    Notice selectByPrimaryKey(Long id);
    List<Notice> find(Long memberId, Boolean read, Integer firstRow, Integer size);
    Long unread(Long memberId);
    void updateRead(Long id);
    void updateAllRead(Long memberId);
    int addNotice(Notice notice);
    List<Notice> findByNotice(Notice notice,Map<String,String> map);
    int updateNotice(Notice notice);
}

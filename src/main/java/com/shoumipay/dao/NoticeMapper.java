package com.shoumipay.dao;

import com.shoumipay.domain.Notice;
import com.shoumipay.domain.NoticeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper @Component
public interface NoticeMapper {
    long countByExample(NoticeExample example);

    Long unread(Long memberId);

    int deleteByExample(NoticeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Notice record);

    int insertSelective(Notice record);

    List<Notice> selectByExample(NoticeExample example);

    List<Notice> findNotMatch(@Param("memberId") Long memberId);

    List<Notice> find(@Param(value="memberId") Long memberId, @Param(value="read") Boolean read,
                      @Param(value="firstRow") Integer firstRow, @Param(value="size") Integer size);

    Notice selectByPrimaryKey(Long id);

    void updateRead(Long id);

    void updateAllRead(Long memberId);

    int updateByExampleSelective(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByExample(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);

}
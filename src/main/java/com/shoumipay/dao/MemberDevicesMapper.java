package com.shoumipay.dao;

import com.shoumipay.domain.MemberDevices;
import com.shoumipay.domain.MemberDevicesExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper @Component
public interface MemberDevicesMapper {
    long countByExample(MemberDevicesExample example);

    int deleteByExample(MemberDevicesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberDevices record);

    int insertSelective(MemberDevices record);

    List<MemberDevices> selectByExample(MemberDevicesExample example);

    MemberDevices selectByPrimaryKey(Long id);

    MemberDevices selectByMemberId(Long memberid);

    int updateByExampleSelective(@Param("record") MemberDevices record, @Param("example") MemberDevicesExample example);

    int updateByExample(@Param("record") MemberDevices record, @Param("example") MemberDevicesExample example);

    int updateByPrimaryKeySelective(MemberDevices record);

    int updateByPrimaryKey(MemberDevices record);
}
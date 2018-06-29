package com.shoumipay.dao;

import com.shoumipay.domain.Netraffic;
import com.shoumipay.domain.NetrafficExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface NetrafficMapper {
    long countByExample(NetrafficExample example);

    int deleteByExample(NetrafficExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Netraffic record);

    int insertSelective(Netraffic record);

    List<Netraffic> selectByExample(NetrafficExample example);

    Netraffic selectByPrimaryKey(Long id);

    Netraffic selectStat(@Param("startTime") String startTime,@Param("endTime") String endTime);

    int updateByExampleSelective(@Param("record") Netraffic record, @Param("example") NetrafficExample example);

    int updateByExample(@Param("record") Netraffic record, @Param("example") NetrafficExample example);

    int updateByPrimaryKeySelective(Netraffic record);

    int updateByPrimaryKey(Netraffic record);
}
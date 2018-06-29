package com.shoumipay.dao;

import com.shoumipay.domain.JdDaiFu;
import com.shoumipay.domain.JdDaiFuExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper @Component
public interface JdDaiFuMapper {
    long countByExample(JdDaiFuExample example);

    int deleteByExample(JdDaiFuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JdDaiFu record);

    long insertSelective(JdDaiFu record);

    List<JdDaiFu> selectByExample(JdDaiFuExample example);

    JdDaiFu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") JdDaiFu record, @Param("example") JdDaiFuExample example);

    int updateByExample(@Param("record") JdDaiFu record, @Param("example") JdDaiFuExample example);

    int updateByPrimaryKeySelective(JdDaiFu record);

    int updateByPrimaryKey(JdDaiFu record);
}
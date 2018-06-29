package com.shoumipay.dao;

import com.shoumipay.domain.CertificationFile;
import com.shoumipay.domain.CertificationFileExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper @Component
public interface CertificationFileMapper {
    long countByExample(CertificationFileExample example);

    int deleteByExample(CertificationFileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CertificationFile record);

    int insertSelective(CertificationFile record);

    List<CertificationFile> selectByExample(CertificationFileExample example);

    CertificationFile selectByPrimaryKey(Long id);

    CertificationFile selectByMemberId(long memberid);

    int updateByExampleSelective(@Param("record") CertificationFile record, @Param("example") CertificationFileExample example);

    int updateByExample(@Param("record") CertificationFile record, @Param("example") CertificationFileExample example);

    int updateByPrimaryKeySelective(CertificationFile record);

    int updateByPrimaryKey(CertificationFile record);
}
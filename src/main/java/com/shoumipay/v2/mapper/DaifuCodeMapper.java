package com.shoumipay.v2.mapper;

import com.shoumipay.v2.domain.DaifuCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by yuluo on 2018/3/25.
 */
@Mapper
public interface DaifuCodeMapper {

    DaifuCode selectById(@Param("codeId") long codeId);

    DaifuCode selectByDaifuId(@Param("daifuId") String daifuId);

    List<DaifuCode> selectBy(@Param("platform")String platform, @Param("status")String status);

    int updateByPrimaryKey(DaifuCode code);

    int insert(DaifuCode code);

    List<DaifuCode> queryList(DaifuCode daifuCode);

    int update(DaifuCode daifuCode);

}

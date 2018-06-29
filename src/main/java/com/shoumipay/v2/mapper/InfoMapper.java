package com.shoumipay.v2.mapper;

import com.shoumipay.v2.vo.InfoVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InfoMapper {
    int addInfo(InfoVO infoVO);
}

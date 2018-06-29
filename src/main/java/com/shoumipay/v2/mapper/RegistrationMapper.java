package com.shoumipay.v2.mapper;

import com.shoumipay.domain.Registration;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RegistrationMapper {

    int save(Registration registration);

    /**
     * 查芝麻分,获取第三方连接
     */
    String selectByKey(@Param("key") String key);

}

package com.shoumipay.service.admin;

import com.shoumipay.constants.SmsEnum;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/10/19.
 * 短信插入数据库接口
 */
public interface MessageSendService {
    int messSend(List<String> phoneList,SmsEnum type,Long memberid,String... content);
}

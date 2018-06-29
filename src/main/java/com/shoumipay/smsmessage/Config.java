package com.shoumipay.smsmessage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2017/10/16.
 */
public class Config {
    public static String KEY;
    public static String CHANNELID;
    public static String REQUESTURL;
    static {
        Properties properties = new Properties();
        InputStream in = Config.class.getResourceAsStream("/config.properties");
        try {
            properties.load(in);
            KEY = properties.getProperty("KEY").trim();
            CHANNELID = properties.getProperty("CHANNELID").trim();
            REQUESTURL = properties.getProperty("REQUESTURL").trim();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.shoumipay.v2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtils {
    public static int bigDecimalCompare(BigDecimal a, BigDecimal b){
        return (a.setScale(3, RoundingMode.HALF_DOWN))
                .compareTo(b.setScale(3, RoundingMode.HALF_DOWN));
    }
}

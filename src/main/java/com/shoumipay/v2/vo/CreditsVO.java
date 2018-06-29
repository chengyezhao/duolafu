package com.shoumipay.v2.vo;

import java.math.BigDecimal;

/**
 * 额度
 */
public class CreditsVO {

    private BigDecimal zcredits = new BigDecimal(0.0);//总额度
    private BigDecimal zcreditsP1 = new BigDecimal(0.0);//一期额度
    private BigDecimal zcreditsP3 = new BigDecimal(0.0);//3期额度
    private BigDecimal zcreditsP6 = new BigDecimal(0.0);//6期额度

    private BigDecimal scredits = new BigDecimal(0.0);//总剩余额度
    private BigDecimal screditsP1 = new BigDecimal(0.0);//1期剩余额度
    private BigDecimal screditsP3 = new BigDecimal(0.0);//3期剩余额度
    private BigDecimal screditsP6 = new BigDecimal(0.0);//6期剩余额度

    public BigDecimal getZcredits() {
        return zcredits;
    }

    public void setZcredits(BigDecimal zcredits) {
        this.zcredits = zcredits;
    }

    public BigDecimal getScredits() {
        return scredits;
    }

    public void setScredits(BigDecimal scredits) {
        this.scredits = scredits;
    }

    public BigDecimal getZcreditsP1() {
        return zcreditsP1;
    }

    public void setZcreditsP1(BigDecimal zcreditsP1) {
        this.zcreditsP1 = zcreditsP1;
    }

    public BigDecimal getZcreditsP3() {
        return zcreditsP3;
    }

    public void setZcreditsP3(BigDecimal zcreditsP3) {
        this.zcreditsP3 = zcreditsP3;
    }

    public BigDecimal getZcreditsP6() {
        return zcreditsP6;
    }

    public void setZcreditsP6(BigDecimal zcreditsP6) {
        this.zcreditsP6 = zcreditsP6;
    }

    public BigDecimal getScreditsP1() {
        return screditsP1;
    }

    public void setScreditsP1(BigDecimal screditsP1) {
        this.screditsP1 = screditsP1;
    }

    public BigDecimal getScreditsP6() {
        return screditsP6;
    }

    public void setScreditsP6(BigDecimal screditsP6) {
        this.screditsP6 = screditsP6;
    }

    public BigDecimal getScreditsP3() {
        return screditsP3;
    }

    public void setScreditsP3(BigDecimal screditsP3) {
        this.screditsP3 = screditsP3;
    }
}

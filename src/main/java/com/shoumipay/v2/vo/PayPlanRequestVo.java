package com.shoumipay.v2.vo;

import java.math.BigDecimal;

public class PayPlanRequestVo {
    private BigDecimal price;
    private BigDecimal downPayment;
    private Integer term;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(BigDecimal downPayment) {
        this.downPayment = downPayment;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }
}

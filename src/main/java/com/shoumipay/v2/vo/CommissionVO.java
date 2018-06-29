package com.shoumipay.v2.vo;

import java.math.BigDecimal;

public class CommissionVO {
    private BigDecimal term1;
    private BigDecimal term3;
    private BigDecimal term6;

    public BigDecimal getTerm1() {
        return term1;
    }

    public void setTerm1(BigDecimal term1) {
        this.term1 = term1;
    }

    public BigDecimal getTerm3() {
        return term3;
    }

    public void setTerm3(BigDecimal term3) {
        this.term3 = term3;
    }

    public BigDecimal getTerm6() {
        return term6;
    }

    public void setTerm6(BigDecimal term6) {
        this.term6 = term6;
    }
}

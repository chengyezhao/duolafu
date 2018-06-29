package com.shoumipay.domain;

import java.math.BigDecimal;
import java.util.Date;

public class MemberAgent {
    private Long id;

    private Long memberId;

    private Date createtime;

    private Long agentId;

    private Integer agentType;

    private BigDecimal balance;

    private BigDecimal agentScore;

    private String commisionType;

    private BigDecimal commisionRate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public Integer getAgentType() {
        return agentType;
    }

    public void setAgentType(Integer agentType) {
        this.agentType = agentType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getAgentScore() {
        return agentScore;
    }

    public void setAgentScore(BigDecimal agentScore) {
        this.agentScore = agentScore;
    }

    public String getCommisionType() {
        return commisionType;
    }

    public void setCommisionType(String commisionType) {
        this.commisionType = commisionType == null ? null : commisionType.trim();
    }

    public BigDecimal getCommisionRate() {
        return commisionRate;
    }

    public void setCommisionRate(BigDecimal commisionRate) {
        this.commisionRate = commisionRate;
    }
}
package com.shoumipay.domain;

import java.util.Date;

public class ExamineRule {
    private Long id;

    private Boolean using;

    private String type;

    private String parameter;

    private Integer match;

    private Integer unmatch;

    private Long processor;

    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getUsing() {
        return using;
    }

    public void setUsing(Boolean using) {
        this.using = using;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter == null ? null : parameter.trim();
    }

    public Integer getMatch() {
        return match;
    }

    public void setMatch(Integer match) {
        this.match = match;
    }

    public Integer getUnmatch() {
        return unmatch;
    }

    public void setUnmatch(Integer unmatch) {
        this.unmatch = unmatch;
    }

    public Long getProcessor() {
        return processor;
    }

    public void setProcessor(Long processor) {
        this.processor = processor;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "ExamineRule{" +
                "id=" + id +
                ", using=" + using +
                ", type='" + type + '\'' +
                ", parameter='" + parameter + '\'' +
                ", match=" + match +
                ", unmatch=" + unmatch +
                ", processor=" + processor +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
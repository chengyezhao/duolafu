package com.shoumipay.domain;

import com.alibaba.druid.util.StringUtils;

public class Registration {

    private int id;
    private String phonenum;
    private String username;
    private String education;
    private String jobType;
    private String jobHours;
    private String sesame;
    private String instructions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobHours() {
        return jobHours;
    }

    public void setJobHours(String jobHours) {
        this.jobHours = jobHours;
    }

    public String getSesame() {
        return sesame;
    }

    public void setSesame(String sesame) {
        this.sesame = sesame;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public boolean verify(){
        if(StringUtils.isEmpty(this.getPhonenum())){
            return false;
        }
        if(StringUtils.isEmpty(this.getEducation())){
            return false;
        }
        if(StringUtils.isEmpty(this.getJobHours())){
            return false;
        }
        if(StringUtils.isEmpty(this.getInstructions())){
            return false;
        }
        if(StringUtils.isEmpty(this.getSesame())){
            return false;
        }
        return true;
    }
}

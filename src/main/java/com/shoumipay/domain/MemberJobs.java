package com.shoumipay.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MemberJobs {
    private Long id;

    private Long memberid;

    private String corporateName;

    private String industry;

    private String companyPositions;

    private String companyAddress;

    private String businessCity;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date jobsAddCompanyTime;

    private Integer jobsTime;

    private Byte isAccumulationFund;

    private Integer wages;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date jobsAddtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName == null ? null : corporateName.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getCompanyPositions() {
        return companyPositions;
    }

    public void setCompanyPositions(String companyPositions) {
        this.companyPositions = companyPositions == null ? null : companyPositions.trim();
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    public String getBusinessCity() {
        return businessCity;
    }

    public void setBusinessCity(String businessCity) {
        this.businessCity = businessCity == null ? null : businessCity.trim();
    }

    public Date getJobsAddCompanyTime() {
        return jobsAddCompanyTime;
    }

    public void setJobsAddCompanyTime(Date jobsAddCompanyTime) {
        this.jobsAddCompanyTime = jobsAddCompanyTime;
    }

    public Integer getJobsTime() {
        return jobsTime;
    }

    public void setJobsTime(Integer jobsTime) {
        this.jobsTime = jobsTime;
    }

    public Byte getIsAccumulationFund() {
        return isAccumulationFund;
    }

    public void setIsAccumulationFund(Byte isAccumulationFund) {
        this.isAccumulationFund = isAccumulationFund;
    }

    public Integer getWages() {
        return wages;
    }

    public void setWages(Integer wages) {
        this.wages = wages;
    }

    public Date getJobsAddtime() {
        return jobsAddtime;
    }

    public void setJobsAddtime(Date jobsAddtime) {
        this.jobsAddtime = jobsAddtime;
    }
}
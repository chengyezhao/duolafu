package com.shoumipay.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MemberDetail {
    private Long id;

    private String fullname;

    private Integer idType;

    private String idCard;

    private String periodOfValidity;

    private Integer age;

    private Integer sex;

    private String ethnicity;

    private String issuingAuthority;
    private String dateOfBirth;
    private String domicileCity;

    private String permanentAddress;

    private Integer recordOfFormalSchooling;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date graduationTime;

    private String nowLivingInCity;

    private String residence;

    private String vocation;

    private Integer ismarry;

    private Integer familySize;

    private Byte isroom;

    private Byte iscar;

    private Long memberid;

    private Integer forceCalculateBill;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname == null ? null : fullname.trim();
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getPeriodOfValidity() {
        return periodOfValidity;
    }

    public void setPeriodOfValidity(String periodOfValidity) {
        this.periodOfValidity = periodOfValidity == null ? null : periodOfValidity.trim();
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity == null ? null : ethnicity.trim();
    }

    public String getIssuingAuthority() {
        return issuingAuthority;
    }

    public void setIssuingAuthority(String issuingAuthority) {
        this.issuingAuthority = issuingAuthority == null ? null : issuingAuthority.trim();
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth == null ? null : dateOfBirth.trim();
    }

    public String getDomicileCity() {
        return domicileCity;
    }

    public void setDomicileCity(String domicileCity) {
        this.domicileCity = domicileCity == null ? null : domicileCity.trim();
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress == null ? null : permanentAddress.trim();
    }

    public Integer getRecordOfFormalSchooling() {
        return recordOfFormalSchooling;
    }

    public void setRecordOfFormalSchooling(Integer recordOfFormalSchooling) {
        this.recordOfFormalSchooling = recordOfFormalSchooling;
    }

    public Date getGraduationTime() {
        return graduationTime;
    }

    public void setGraduationTime(Date graduationTime) {
        this.graduationTime = graduationTime;
    }

    public String getNowLivingInCity() {
        return nowLivingInCity;
    }

    public void setNowLivingInCity(String nowLivingInCity) {
        this.nowLivingInCity = nowLivingInCity == null ? null : nowLivingInCity.trim();
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence == null ? null : residence.trim();
    }

    public String getVocation() {
        return vocation;
    }

    public void setVocation(String vocation) {
        this.vocation = vocation == null ? null : vocation.trim();
    }

    public Integer getIsmarry() {
        return ismarry;
    }

    public void setIsmarry(Integer ismarry) {
        this.ismarry = ismarry;
    }

    public Integer getFamilySize() {
        return familySize;
    }

    public void setFamilySize(Integer familySize) {
        this.familySize = familySize;
    }

    public Byte getIsroom() {
        return isroom;
    }

    public void setIsroom(Byte isroom) {
        this.isroom = isroom;
    }

    public Byte getIscar() {
        return iscar;
    }

    public void setIscar(Byte iscar) {
        this.iscar = iscar;
    }

    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }

    public Integer getForceCalculateBill() {
        return forceCalculateBill;
    }

    public void setForceCalculateBill(Integer forceCalculateBill) {
        this.forceCalculateBill = forceCalculateBill;
    }

    @Override
    public String toString() {
        return "MemberDetail{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", idType=" + idType +
                ", idCard='" + idCard + '\'' +
                ", periodOfValidity=" + periodOfValidity +
                ", age=" + age +
                ", sex=" + sex +
                ", domicileCity='" + domicileCity + '\'' +
                ", permanentAddress='" + permanentAddress + '\'' +
                ", recordOfFormalSchooling=" + recordOfFormalSchooling +
                ", graduationTime=" + graduationTime +
                ", nowLivingInCity='" + nowLivingInCity + '\'' +
                ", residence='" + residence + '\'' +
                ", vocation='" + vocation + '\'' +
                ", ismarry=" + ismarry +
                ", familySize=" + familySize +
                ", isroom=" + isroom +
                ", iscar=" + iscar +
                ", memberid=" + memberid +
                '}';
    }

}
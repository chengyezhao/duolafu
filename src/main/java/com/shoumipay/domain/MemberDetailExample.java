package com.shoumipay.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberDetailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFullnameIsNull() {
            addCriterion("fullname is null");
            return (Criteria) this;
        }

        public Criteria andFullnameIsNotNull() {
            addCriterion("fullname is not null");
            return (Criteria) this;
        }

        public Criteria andFullnameEqualTo(String value) {
            addCriterion("fullname =", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameNotEqualTo(String value) {
            addCriterion("fullname <>", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameGreaterThan(String value) {
            addCriterion("fullname >", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameGreaterThanOrEqualTo(String value) {
            addCriterion("fullname >=", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameLessThan(String value) {
            addCriterion("fullname <", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameLessThanOrEqualTo(String value) {
            addCriterion("fullname <=", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameLike(String value) {
            addCriterion("fullname like", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameNotLike(String value) {
            addCriterion("fullname not like", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameIn(List<String> values) {
            addCriterion("fullname in", values, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameNotIn(List<String> values) {
            addCriterion("fullname not in", values, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameBetween(String value1, String value2) {
            addCriterion("fullname between", value1, value2, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameNotBetween(String value1, String value2) {
            addCriterion("fullname not between", value1, value2, "fullname");
            return (Criteria) this;
        }

        public Criteria andIdTypeIsNull() {
            addCriterion("id_type is null");
            return (Criteria) this;
        }

        public Criteria andIdTypeIsNotNull() {
            addCriterion("id_type is not null");
            return (Criteria) this;
        }

        public Criteria andIdTypeEqualTo(Integer value) {
            addCriterion("id_type =", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotEqualTo(Integer value) {
            addCriterion("id_type <>", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeGreaterThan(Integer value) {
            addCriterion("id_type >", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_type >=", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeLessThan(Integer value) {
            addCriterion("id_type <", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeLessThanOrEqualTo(Integer value) {
            addCriterion("id_type <=", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeIn(List<Integer> values) {
            addCriterion("id_type in", values, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotIn(List<Integer> values) {
            addCriterion("id_type not in", values, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeBetween(Integer value1, Integer value2) {
            addCriterion("id_type between", value1, value2, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("id_type not between", value1, value2, "idType");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNull() {
            addCriterion("id_card is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNotNull() {
            addCriterion("id_card is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEqualTo(String value) {
            addCriterion("id_card =", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotEqualTo(String value) {
            addCriterion("id_card <>", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThan(String value) {
            addCriterion("id_card >", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("id_card >=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThan(String value) {
            addCriterion("id_card <", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThanOrEqualTo(String value) {
            addCriterion("id_card <=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLike(String value) {
            addCriterion("id_card like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotLike(String value) {
            addCriterion("id_card not like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardIn(List<String> values) {
            addCriterion("id_card in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotIn(List<String> values) {
            addCriterion("id_card not in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardBetween(String value1, String value2) {
            addCriterion("id_card between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotBetween(String value1, String value2) {
            addCriterion("id_card not between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andPeriodOfValidityIsNull() {
            addCriterion("period_of_validity is null");
            return (Criteria) this;
        }

        public Criteria andPeriodOfValidityIsNotNull() {
            addCriterion("period_of_validity is not null");
            return (Criteria) this;
        }

         public Criteria andPeriodOfValidityEqualTo(String value) {
            addCriterion("period_of_validity =", value, "periodOfValidity");
            return (Criteria) this;
        }

        public Criteria andPeriodOfValidityNotEqualTo(String value) {
            addCriterion("period_of_validity <>", value, "periodOfValidity");
            return (Criteria) this;
        }

        public Criteria andPeriodOfValidityGreaterThan(String value) {
            addCriterion("period_of_validity >", value, "periodOfValidity");
            return (Criteria) this;
        }

        public Criteria andPeriodOfValidityGreaterThanOrEqualTo(String value) {
            addCriterion("period_of_validity >=", value, "periodOfValidity");
            return (Criteria) this;
        }

        public Criteria andPeriodOfValidityLessThan(String value) {
            addCriterion("period_of_validity <", value, "periodOfValidity");
            return (Criteria) this;
        }

        public Criteria andPeriodOfValidityLessThanOrEqualTo(String value) {
            addCriterion("period_of_validity <=", value, "periodOfValidity");
            return (Criteria) this;
        }

        public Criteria andPeriodOfValidityLike(String value) {
            addCriterion("period_of_validity like", value, "periodOfValidity");
            return (Criteria) this;
        }

        public Criteria andPeriodOfValidityNotLike(String value) {
            addCriterion("period_of_validity not like", value, "periodOfValidity");
            return (Criteria) this;
        }

        public Criteria andPeriodOfValidityIn(List<String> values) {
            addCriterion("period_of_validity in", values, "periodOfValidity");
            return (Criteria) this;
        }

        public Criteria andPeriodOfValidityNotIn(List<String> values) {
            addCriterion("period_of_validity not in", values, "periodOfValidity");
            return (Criteria) this;
        }

        public Criteria andPeriodOfValidityBetween(String value1, String value2) {
            addCriterion("period_of_validity between", value1, value2, "periodOfValidity");
            return (Criteria) this;
        }

        public Criteria andPeriodOfValidityNotBetween(String value1, String value2) {
            addCriterion("period_of_validity not between", value1, value2, "periodOfValidity");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

 public Criteria andEthnicityIsNull() {
            addCriterion("ethnicity is null");
            return (Criteria) this;
        }

        public Criteria andEthnicityIsNotNull() {
            addCriterion("ethnicity is not null");
            return (Criteria) this;
        }

        public Criteria andEthnicityEqualTo(String value) {
            addCriterion("ethnicity =", value, "ethnicity");
            return (Criteria) this;
        }

        public Criteria andEthnicityNotEqualTo(String value) {
            addCriterion("ethnicity <>", value, "ethnicity");
            return (Criteria) this;
        }

        public Criteria andEthnicityGreaterThan(String value) {
            addCriterion("ethnicity >", value, "ethnicity");
            return (Criteria) this;
        }

        public Criteria andEthnicityGreaterThanOrEqualTo(String value) {
            addCriterion("ethnicity >=", value, "ethnicity");
            return (Criteria) this;
        }

        public Criteria andEthnicityLessThan(String value) {
            addCriterion("ethnicity <", value, "ethnicity");
            return (Criteria) this;
        }

        public Criteria andEthnicityLessThanOrEqualTo(String value) {
            addCriterion("ethnicity <=", value, "ethnicity");
            return (Criteria) this;
        }

        public Criteria andEthnicityLike(String value) {
            addCriterion("ethnicity like", value, "ethnicity");
            return (Criteria) this;
        }

        public Criteria andEthnicityNotLike(String value) {
            addCriterion("ethnicity not like", value, "ethnicity");
            return (Criteria) this;
        }

        public Criteria andEthnicityIn(List<String> values) {
            addCriterion("ethnicity in", values, "ethnicity");
            return (Criteria) this;
        }

        public Criteria andEthnicityNotIn(List<String> values) {
            addCriterion("ethnicity not in", values, "ethnicity");
            return (Criteria) this;
        }

        public Criteria andEthnicityBetween(String value1, String value2) {
            addCriterion("ethnicity between", value1, value2, "ethnicity");
            return (Criteria) this;
        }

        public Criteria andEthnicityNotBetween(String value1, String value2) {
            addCriterion("ethnicity not between", value1, value2, "ethnicity");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityIsNull() {
            addCriterion("issuing_authority is null");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityIsNotNull() {
            addCriterion("issuing_authority is not null");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityEqualTo(String value) {
            addCriterion("issuing_authority =", value, "issuingAuthority");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityNotEqualTo(String value) {
            addCriterion("issuing_authority <>", value, "issuingAuthority");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityGreaterThan(String value) {
            addCriterion("issuing_authority >", value, "issuingAuthority");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityGreaterThanOrEqualTo(String value) {
            addCriterion("issuing_authority >=", value, "issuingAuthority");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityLessThan(String value) {
            addCriterion("issuing_authority <", value, "issuingAuthority");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityLessThanOrEqualTo(String value) {
            addCriterion("issuing_authority <=", value, "issuingAuthority");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityLike(String value) {
            addCriterion("issuing_authority like", value, "issuingAuthority");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityNotLike(String value) {
            addCriterion("issuing_authority not like", value, "issuingAuthority");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityIn(List<String> values) {
            addCriterion("issuing_authority in", values, "issuingAuthority");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityNotIn(List<String> values) {
            addCriterion("issuing_authority not in", values, "issuingAuthority");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityBetween(String value1, String value2) {
            addCriterion("issuing_authority between", value1, value2, "issuingAuthority");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityNotBetween(String value1, String value2) {
            addCriterion("issuing_authority not between", value1, value2, "issuingAuthority");
            return (Criteria) this;
        }

        public Criteria andDateOfBirthIsNull() {
            addCriterion("date_of_birth is null");
            return (Criteria) this;
        }

        public Criteria andDateOfBirthIsNotNull() {
            addCriterion("date_of_birth is not null");
            return (Criteria) this;
        }

        public Criteria andDateOfBirthEqualTo(String value) {
            addCriterion("date_of_birth =", value, "dateOfBirth");
            return (Criteria) this;
        }

        public Criteria andDateOfBirthNotEqualTo(String value) {
            addCriterion("date_of_birth <>", value, "dateOfBirth");
            return (Criteria) this;
        }

        public Criteria andDateOfBirthGreaterThan(String value) {
            addCriterion("date_of_birth >", value, "dateOfBirth");
            return (Criteria) this;
        }

        public Criteria andDateOfBirthGreaterThanOrEqualTo(String value) {
            addCriterion("date_of_birth >=", value, "dateOfBirth");
            return (Criteria) this;
        }

        public Criteria andDateOfBirthLessThan(String value) {
            addCriterion("date_of_birth <", value, "dateOfBirth");
            return (Criteria) this;
        }

        public Criteria andDateOfBirthLessThanOrEqualTo(String value) {
            addCriterion("date_of_birth <=", value, "dateOfBirth");
            return (Criteria) this;
        }

        public Criteria andDateOfBirthLike(String value) {
            addCriterion("date_of_birth like", value, "dateOfBirth");
            return (Criteria) this;
        }

        public Criteria andDateOfBirthNotLike(String value) {
            addCriterion("date_of_birth not like", value, "dateOfBirth");
            return (Criteria) this;
        }

        public Criteria andDateOfBirthIn(List<String> values) {
            addCriterion("date_of_birth in", values, "dateOfBirth");
            return (Criteria) this;
        }

        public Criteria andDateOfBirthNotIn(List<String> values) {
            addCriterion("date_of_birth not in", values, "dateOfBirth");
            return (Criteria) this;
        }

        public Criteria andDateOfBirthBetween(String value1, String value2) {
            addCriterion("date_of_birth between", value1, value2, "dateOfBirth");
            return (Criteria) this;
        }

        public Criteria andDateOfBirthNotBetween(String value1, String value2) {
            addCriterion("date_of_birth not between", value1, value2, "dateOfBirth");
            return (Criteria) this;
        }

        public Criteria andDomicileCityIsNull() {
            addCriterion("domicile_city is null");
            return (Criteria) this;
        }

        public Criteria andDomicileCityIsNotNull() {
            addCriterion("domicile_city is not null");
            return (Criteria) this;
        }

        public Criteria andDomicileCityEqualTo(String value) {
            addCriterion("domicile_city =", value, "domicileCity");
            return (Criteria) this;
        }

        public Criteria andDomicileCityNotEqualTo(String value) {
            addCriterion("domicile_city <>", value, "domicileCity");
            return (Criteria) this;
        }

        public Criteria andDomicileCityGreaterThan(String value) {
            addCriterion("domicile_city >", value, "domicileCity");
            return (Criteria) this;
        }

        public Criteria andDomicileCityGreaterThanOrEqualTo(String value) {
            addCriterion("domicile_city >=", value, "domicileCity");
            return (Criteria) this;
        }

        public Criteria andDomicileCityLessThan(String value) {
            addCriterion("domicile_city <", value, "domicileCity");
            return (Criteria) this;
        }

        public Criteria andDomicileCityLessThanOrEqualTo(String value) {
            addCriterion("domicile_city <=", value, "domicileCity");
            return (Criteria) this;
        }

        public Criteria andDomicileCityLike(String value) {
            addCriterion("domicile_city like", value, "domicileCity");
            return (Criteria) this;
        }

        public Criteria andDomicileCityNotLike(String value) {
            addCriterion("domicile_city not like", value, "domicileCity");
            return (Criteria) this;
        }

        public Criteria andDomicileCityIn(List<String> values) {
            addCriterion("domicile_city in", values, "domicileCity");
            return (Criteria) this;
        }

        public Criteria andDomicileCityNotIn(List<String> values) {
            addCriterion("domicile_city not in", values, "domicileCity");
            return (Criteria) this;
        }

        public Criteria andDomicileCityBetween(String value1, String value2) {
            addCriterion("domicile_city between", value1, value2, "domicileCity");
            return (Criteria) this;
        }

        public Criteria andDomicileCityNotBetween(String value1, String value2) {
            addCriterion("domicile_city not between", value1, value2, "domicileCity");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressIsNull() {
            addCriterion("permanent_address is null");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressIsNotNull() {
            addCriterion("permanent_address is not null");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressEqualTo(String value) {
            addCriterion("permanent_address =", value, "permanentAddress");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressNotEqualTo(String value) {
            addCriterion("permanent_address <>", value, "permanentAddress");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressGreaterThan(String value) {
            addCriterion("permanent_address >", value, "permanentAddress");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressGreaterThanOrEqualTo(String value) {
            addCriterion("permanent_address >=", value, "permanentAddress");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressLessThan(String value) {
            addCriterion("permanent_address <", value, "permanentAddress");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressLessThanOrEqualTo(String value) {
            addCriterion("permanent_address <=", value, "permanentAddress");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressLike(String value) {
            addCriterion("permanent_address like", value, "permanentAddress");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressNotLike(String value) {
            addCriterion("permanent_address not like", value, "permanentAddress");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressIn(List<String> values) {
            addCriterion("permanent_address in", values, "permanentAddress");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressNotIn(List<String> values) {
            addCriterion("permanent_address not in", values, "permanentAddress");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressBetween(String value1, String value2) {
            addCriterion("permanent_address between", value1, value2, "permanentAddress");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressNotBetween(String value1, String value2) {
            addCriterion("permanent_address not between", value1, value2, "permanentAddress");
            return (Criteria) this;
        }

        public Criteria andRecordOfFormalSchoolingIsNull() {
            addCriterion("record_of_formal_schooling is null");
            return (Criteria) this;
        }

        public Criteria andRecordOfFormalSchoolingIsNotNull() {
            addCriterion("record_of_formal_schooling is not null");
            return (Criteria) this;
        }

        public Criteria andRecordOfFormalSchoolingEqualTo(Integer value) {
            addCriterion("record_of_formal_schooling =", value, "recordOfFormalSchooling");
            return (Criteria) this;
        }

        public Criteria andRecordOfFormalSchoolingNotEqualTo(Integer value) {
            addCriterion("record_of_formal_schooling <>", value, "recordOfFormalSchooling");
            return (Criteria) this;
        }

        public Criteria andRecordOfFormalSchoolingGreaterThan(Integer value) {
            addCriterion("record_of_formal_schooling >", value, "recordOfFormalSchooling");
            return (Criteria) this;
        }

        public Criteria andRecordOfFormalSchoolingGreaterThanOrEqualTo(Integer value) {
            addCriterion("record_of_formal_schooling >=", value, "recordOfFormalSchooling");
            return (Criteria) this;
        }

        public Criteria andRecordOfFormalSchoolingLessThan(Integer value) {
            addCriterion("record_of_formal_schooling <", value, "recordOfFormalSchooling");
            return (Criteria) this;
        }

        public Criteria andRecordOfFormalSchoolingLessThanOrEqualTo(Integer value) {
            addCriterion("record_of_formal_schooling <=", value, "recordOfFormalSchooling");
            return (Criteria) this;
        }

        public Criteria andRecordOfFormalSchoolingIn(List<Integer> values) {
            addCriterion("record_of_formal_schooling in", values, "recordOfFormalSchooling");
            return (Criteria) this;
        }

        public Criteria andRecordOfFormalSchoolingNotIn(List<Integer> values) {
            addCriterion("record_of_formal_schooling not in", values, "recordOfFormalSchooling");
            return (Criteria) this;
        }

        public Criteria andRecordOfFormalSchoolingBetween(Integer value1, Integer value2) {
            addCriterion("record_of_formal_schooling between", value1, value2, "recordOfFormalSchooling");
            return (Criteria) this;
        }

        public Criteria andRecordOfFormalSchoolingNotBetween(Integer value1, Integer value2) {
            addCriterion("record_of_formal_schooling not between", value1, value2, "recordOfFormalSchooling");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeIsNull() {
            addCriterion("graduation_time is null");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeIsNotNull() {
            addCriterion("graduation_time is not null");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeEqualTo(Date value) {
            addCriterion("graduation_time =", value, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeNotEqualTo(Date value) {
            addCriterion("graduation_time <>", value, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeGreaterThan(Date value) {
            addCriterion("graduation_time >", value, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("graduation_time >=", value, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeLessThan(Date value) {
            addCriterion("graduation_time <", value, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeLessThanOrEqualTo(Date value) {
            addCriterion("graduation_time <=", value, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeIn(List<Date> values) {
            addCriterion("graduation_time in", values, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeNotIn(List<Date> values) {
            addCriterion("graduation_time not in", values, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeBetween(Date value1, Date value2) {
            addCriterion("graduation_time between", value1, value2, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeNotBetween(Date value1, Date value2) {
            addCriterion("graduation_time not between", value1, value2, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andNowLivingInCityIsNull() {
            addCriterion("now_living_in_city is null");
            return (Criteria) this;
        }

        public Criteria andNowLivingInCityIsNotNull() {
            addCriterion("now_living_in_city is not null");
            return (Criteria) this;
        }

        public Criteria andNowLivingInCityEqualTo(String value) {
            addCriterion("now_living_in_city =", value, "nowLivingInCity");
            return (Criteria) this;
        }

        public Criteria andNowLivingInCityNotEqualTo(String value) {
            addCriterion("now_living_in_city <>", value, "nowLivingInCity");
            return (Criteria) this;
        }

        public Criteria andNowLivingInCityGreaterThan(String value) {
            addCriterion("now_living_in_city >", value, "nowLivingInCity");
            return (Criteria) this;
        }

        public Criteria andNowLivingInCityGreaterThanOrEqualTo(String value) {
            addCriterion("now_living_in_city >=", value, "nowLivingInCity");
            return (Criteria) this;
        }

        public Criteria andNowLivingInCityLessThan(String value) {
            addCriterion("now_living_in_city <", value, "nowLivingInCity");
            return (Criteria) this;
        }

        public Criteria andNowLivingInCityLessThanOrEqualTo(String value) {
            addCriterion("now_living_in_city <=", value, "nowLivingInCity");
            return (Criteria) this;
        }

        public Criteria andNowLivingInCityLike(String value) {
            addCriterion("now_living_in_city like", value, "nowLivingInCity");
            return (Criteria) this;
        }

        public Criteria andNowLivingInCityNotLike(String value) {
            addCriterion("now_living_in_city not like", value, "nowLivingInCity");
            return (Criteria) this;
        }

        public Criteria andNowLivingInCityIn(List<String> values) {
            addCriterion("now_living_in_city in", values, "nowLivingInCity");
            return (Criteria) this;
        }

        public Criteria andNowLivingInCityNotIn(List<String> values) {
            addCriterion("now_living_in_city not in", values, "nowLivingInCity");
            return (Criteria) this;
        }

        public Criteria andNowLivingInCityBetween(String value1, String value2) {
            addCriterion("now_living_in_city between", value1, value2, "nowLivingInCity");
            return (Criteria) this;
        }

        public Criteria andNowLivingInCityNotBetween(String value1, String value2) {
            addCriterion("now_living_in_city not between", value1, value2, "nowLivingInCity");
            return (Criteria) this;
        }

        public Criteria andResidenceIsNull() {
            addCriterion("residence is null");
            return (Criteria) this;
        }

        public Criteria andResidenceIsNotNull() {
            addCriterion("residence is not null");
            return (Criteria) this;
        }

        public Criteria andResidenceEqualTo(String value) {
            addCriterion("residence =", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceNotEqualTo(String value) {
            addCriterion("residence <>", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceGreaterThan(String value) {
            addCriterion("residence >", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceGreaterThanOrEqualTo(String value) {
            addCriterion("residence >=", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceLessThan(String value) {
            addCriterion("residence <", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceLessThanOrEqualTo(String value) {
            addCriterion("residence <=", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceLike(String value) {
            addCriterion("residence like", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceNotLike(String value) {
            addCriterion("residence not like", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceIn(List<String> values) {
            addCriterion("residence in", values, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceNotIn(List<String> values) {
            addCriterion("residence not in", values, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceBetween(String value1, String value2) {
            addCriterion("residence between", value1, value2, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceNotBetween(String value1, String value2) {
            addCriterion("residence not between", value1, value2, "residence");
            return (Criteria) this;
        }

        public Criteria andVocationIsNull() {
            addCriterion("vocation is null");
            return (Criteria) this;
        }

        public Criteria andVocationIsNotNull() {
            addCriterion("vocation is not null");
            return (Criteria) this;
        }

        public Criteria andVocationEqualTo(String value) {
            addCriterion("vocation =", value, "vocation");
            return (Criteria) this;
        }

        public Criteria andVocationNotEqualTo(String value) {
            addCriterion("vocation <>", value, "vocation");
            return (Criteria) this;
        }

        public Criteria andVocationGreaterThan(String value) {
            addCriterion("vocation >", value, "vocation");
            return (Criteria) this;
        }

        public Criteria andVocationGreaterThanOrEqualTo(String value) {
            addCriterion("vocation >=", value, "vocation");
            return (Criteria) this;
        }

        public Criteria andVocationLessThan(String value) {
            addCriterion("vocation <", value, "vocation");
            return (Criteria) this;
        }

        public Criteria andVocationLessThanOrEqualTo(String value) {
            addCriterion("vocation <=", value, "vocation");
            return (Criteria) this;
        }

        public Criteria andVocationLike(String value) {
            addCriterion("vocation like", value, "vocation");
            return (Criteria) this;
        }

        public Criteria andVocationNotLike(String value) {
            addCriterion("vocation not like", value, "vocation");
            return (Criteria) this;
        }

        public Criteria andVocationIn(List<String> values) {
            addCriterion("vocation in", values, "vocation");
            return (Criteria) this;
        }

        public Criteria andVocationNotIn(List<String> values) {
            addCriterion("vocation not in", values, "vocation");
            return (Criteria) this;
        }

        public Criteria andVocationBetween(String value1, String value2) {
            addCriterion("vocation between", value1, value2, "vocation");
            return (Criteria) this;
        }

        public Criteria andVocationNotBetween(String value1, String value2) {
            addCriterion("vocation not between", value1, value2, "vocation");
            return (Criteria) this;
        }

        public Criteria andIsmarryIsNull() {
            addCriterion("ismarry is null");
            return (Criteria) this;
        }

        public Criteria andIsmarryIsNotNull() {
            addCriterion("ismarry is not null");
            return (Criteria) this;
        }

        public Criteria andIsmarryEqualTo(Integer value) {
            addCriterion("ismarry =", value, "ismarry");
            return (Criteria) this;
        }

        public Criteria andIsmarryNotEqualTo(Integer value) {
            addCriterion("ismarry <>", value, "ismarry");
            return (Criteria) this;
        }

        public Criteria andIsmarryGreaterThan(Integer value) {
            addCriterion("ismarry >", value, "ismarry");
            return (Criteria) this;
        }

        public Criteria andIsmarryGreaterThanOrEqualTo(Integer value) {
            addCriterion("ismarry >=", value, "ismarry");
            return (Criteria) this;
        }

        public Criteria andIsmarryLessThan(Integer value) {
            addCriterion("ismarry <", value, "ismarry");
            return (Criteria) this;
        }

        public Criteria andIsmarryLessThanOrEqualTo(Integer value) {
            addCriterion("ismarry <=", value, "ismarry");
            return (Criteria) this;
        }

        public Criteria andIsmarryIn(List<Integer> values) {
            addCriterion("ismarry in", values, "ismarry");
            return (Criteria) this;
        }

        public Criteria andIsmarryNotIn(List<Integer> values) {
            addCriterion("ismarry not in", values, "ismarry");
            return (Criteria) this;
        }

        public Criteria andIsmarryBetween(Integer value1, Integer value2) {
            addCriterion("ismarry between", value1, value2, "ismarry");
            return (Criteria) this;
        }

        public Criteria andIsmarryNotBetween(Integer value1, Integer value2) {
            addCriterion("ismarry not between", value1, value2, "ismarry");
            return (Criteria) this;
        }

        public Criteria andFamilySizeIsNull() {
            addCriterion("family_size is null");
            return (Criteria) this;
        }

        public Criteria andFamilySizeIsNotNull() {
            addCriterion("family_size is not null");
            return (Criteria) this;
        }

        public Criteria andFamilySizeEqualTo(Integer value) {
            addCriterion("family_size =", value, "familySize");
            return (Criteria) this;
        }

        public Criteria andFamilySizeNotEqualTo(Integer value) {
            addCriterion("family_size <>", value, "familySize");
            return (Criteria) this;
        }

        public Criteria andFamilySizeGreaterThan(Integer value) {
            addCriterion("family_size >", value, "familySize");
            return (Criteria) this;
        }

        public Criteria andFamilySizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("family_size >=", value, "familySize");
            return (Criteria) this;
        }

        public Criteria andFamilySizeLessThan(Integer value) {
            addCriterion("family_size <", value, "familySize");
            return (Criteria) this;
        }

        public Criteria andFamilySizeLessThanOrEqualTo(Integer value) {
            addCriterion("family_size <=", value, "familySize");
            return (Criteria) this;
        }

        public Criteria andFamilySizeIn(List<Integer> values) {
            addCriterion("family_size in", values, "familySize");
            return (Criteria) this;
        }

        public Criteria andFamilySizeNotIn(List<Integer> values) {
            addCriterion("family_size not in", values, "familySize");
            return (Criteria) this;
        }

        public Criteria andFamilySizeBetween(Integer value1, Integer value2) {
            addCriterion("family_size between", value1, value2, "familySize");
            return (Criteria) this;
        }

        public Criteria andFamilySizeNotBetween(Integer value1, Integer value2) {
            addCriterion("family_size not between", value1, value2, "familySize");
            return (Criteria) this;
        }

        public Criteria andIsroomIsNull() {
            addCriterion("isRoom is null");
            return (Criteria) this;
        }

        public Criteria andIsroomIsNotNull() {
            addCriterion("isRoom is not null");
            return (Criteria) this;
        }

        public Criteria andIsroomEqualTo(Byte value) {
            addCriterion("isRoom =", value, "isroom");
            return (Criteria) this;
        }

        public Criteria andIsroomNotEqualTo(Byte value) {
            addCriterion("isRoom <>", value, "isroom");
            return (Criteria) this;
        }

        public Criteria andIsroomGreaterThan(Byte value) {
            addCriterion("isRoom >", value, "isroom");
            return (Criteria) this;
        }

        public Criteria andIsroomGreaterThanOrEqualTo(Byte value) {
            addCriterion("isRoom >=", value, "isroom");
            return (Criteria) this;
        }

        public Criteria andIsroomLessThan(Byte value) {
            addCriterion("isRoom <", value, "isroom");
            return (Criteria) this;
        }

        public Criteria andIsroomLessThanOrEqualTo(Byte value) {
            addCriterion("isRoom <=", value, "isroom");
            return (Criteria) this;
        }

        public Criteria andIsroomIn(List<Byte> values) {
            addCriterion("isRoom in", values, "isroom");
            return (Criteria) this;
        }

        public Criteria andIsroomNotIn(List<Byte> values) {
            addCriterion("isRoom not in", values, "isroom");
            return (Criteria) this;
        }

        public Criteria andIsroomBetween(Byte value1, Byte value2) {
            addCriterion("isRoom between", value1, value2, "isroom");
            return (Criteria) this;
        }

        public Criteria andIsroomNotBetween(Byte value1, Byte value2) {
            addCriterion("isRoom not between", value1, value2, "isroom");
            return (Criteria) this;
        }

        public Criteria andIscarIsNull() {
            addCriterion("isCar is null");
            return (Criteria) this;
        }

        public Criteria andIscarIsNotNull() {
            addCriterion("isCar is not null");
            return (Criteria) this;
        }

        public Criteria andIscarEqualTo(Byte value) {
            addCriterion("isCar =", value, "iscar");
            return (Criteria) this;
        }

        public Criteria andIscarNotEqualTo(Byte value) {
            addCriterion("isCar <>", value, "iscar");
            return (Criteria) this;
        }

        public Criteria andIscarGreaterThan(Byte value) {
            addCriterion("isCar >", value, "iscar");
            return (Criteria) this;
        }

        public Criteria andIscarGreaterThanOrEqualTo(Byte value) {
            addCriterion("isCar >=", value, "iscar");
            return (Criteria) this;
        }

        public Criteria andIscarLessThan(Byte value) {
            addCriterion("isCar <", value, "iscar");
            return (Criteria) this;
        }

        public Criteria andIscarLessThanOrEqualTo(Byte value) {
            addCriterion("isCar <=", value, "iscar");
            return (Criteria) this;
        }

        public Criteria andIscarIn(List<Byte> values) {
            addCriterion("isCar in", values, "iscar");
            return (Criteria) this;
        }

        public Criteria andIscarNotIn(List<Byte> values) {
            addCriterion("isCar not in", values, "iscar");
            return (Criteria) this;
        }

        public Criteria andIscarBetween(Byte value1, Byte value2) {
            addCriterion("isCar between", value1, value2, "iscar");
            return (Criteria) this;
        }

        public Criteria andIscarNotBetween(Byte value1, Byte value2) {
            addCriterion("isCar not between", value1, value2, "iscar");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNull() {
            addCriterion("memberId is null");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNotNull() {
            addCriterion("memberId is not null");
            return (Criteria) this;
        }

        public Criteria andMemberidEqualTo(Long value) {
            addCriterion("memberId =", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotEqualTo(Long value) {
            addCriterion("memberId <>", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThan(Long value) {
            addCriterion("memberId >", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThanOrEqualTo(Long value) {
            addCriterion("memberId >=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThan(Long value) {
            addCriterion("memberId <", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThanOrEqualTo(Long value) {
            addCriterion("memberId <=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidIn(List<Long> values) {
            addCriterion("memberId in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotIn(List<Long> values) {
            addCriterion("memberId not in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidBetween(Long value1, Long value2) {
            addCriterion("memberId between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotBetween(Long value1, Long value2) {
            addCriterion("memberId not between", value1, value2, "memberid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
package com.shoumipay.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberJobsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberJobsExample() {
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

        public Criteria andCorporateNameIsNull() {
            addCriterion("corporate_name is null");
            return (Criteria) this;
        }

        public Criteria andCorporateNameIsNotNull() {
            addCriterion("corporate_name is not null");
            return (Criteria) this;
        }

        public Criteria andCorporateNameEqualTo(String value) {
            addCriterion("corporate_name =", value, "corporateName");
            return (Criteria) this;
        }

        public Criteria andCorporateNameNotEqualTo(String value) {
            addCriterion("corporate_name <>", value, "corporateName");
            return (Criteria) this;
        }

        public Criteria andCorporateNameGreaterThan(String value) {
            addCriterion("corporate_name >", value, "corporateName");
            return (Criteria) this;
        }

        public Criteria andCorporateNameGreaterThanOrEqualTo(String value) {
            addCriterion("corporate_name >=", value, "corporateName");
            return (Criteria) this;
        }

        public Criteria andCorporateNameLessThan(String value) {
            addCriterion("corporate_name <", value, "corporateName");
            return (Criteria) this;
        }

        public Criteria andCorporateNameLessThanOrEqualTo(String value) {
            addCriterion("corporate_name <=", value, "corporateName");
            return (Criteria) this;
        }

        public Criteria andCorporateNameLike(String value) {
            addCriterion("corporate_name like", value, "corporateName");
            return (Criteria) this;
        }

        public Criteria andCorporateNameNotLike(String value) {
            addCriterion("corporate_name not like", value, "corporateName");
            return (Criteria) this;
        }

        public Criteria andCorporateNameIn(List<String> values) {
            addCriterion("corporate_name in", values, "corporateName");
            return (Criteria) this;
        }

        public Criteria andCorporateNameNotIn(List<String> values) {
            addCriterion("corporate_name not in", values, "corporateName");
            return (Criteria) this;
        }

        public Criteria andCorporateNameBetween(String value1, String value2) {
            addCriterion("corporate_name between", value1, value2, "corporateName");
            return (Criteria) this;
        }

        public Criteria andCorporateNameNotBetween(String value1, String value2) {
            addCriterion("corporate_name not between", value1, value2, "corporateName");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNull() {
            addCriterion("industry is null");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNotNull() {
            addCriterion("industry is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryEqualTo(String value) {
            addCriterion("industry =", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotEqualTo(String value) {
            addCriterion("industry <>", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThan(String value) {
            addCriterion("industry >", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("industry >=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThan(String value) {
            addCriterion("industry <", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThanOrEqualTo(String value) {
            addCriterion("industry <=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLike(String value) {
            addCriterion("industry like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotLike(String value) {
            addCriterion("industry not like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryIn(List<String> values) {
            addCriterion("industry in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotIn(List<String> values) {
            addCriterion("industry not in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryBetween(String value1, String value2) {
            addCriterion("industry between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotBetween(String value1, String value2) {
            addCriterion("industry not between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andCompanyPositionsIsNull() {
            addCriterion("company_positions is null");
            return (Criteria) this;
        }

        public Criteria andCompanyPositionsIsNotNull() {
            addCriterion("company_positions is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyPositionsEqualTo(String value) {
            addCriterion("company_positions =", value, "companyPositions");
            return (Criteria) this;
        }

        public Criteria andCompanyPositionsNotEqualTo(String value) {
            addCriterion("company_positions <>", value, "companyPositions");
            return (Criteria) this;
        }

        public Criteria andCompanyPositionsGreaterThan(String value) {
            addCriterion("company_positions >", value, "companyPositions");
            return (Criteria) this;
        }

        public Criteria andCompanyPositionsGreaterThanOrEqualTo(String value) {
            addCriterion("company_positions >=", value, "companyPositions");
            return (Criteria) this;
        }

        public Criteria andCompanyPositionsLessThan(String value) {
            addCriterion("company_positions <", value, "companyPositions");
            return (Criteria) this;
        }

        public Criteria andCompanyPositionsLessThanOrEqualTo(String value) {
            addCriterion("company_positions <=", value, "companyPositions");
            return (Criteria) this;
        }

        public Criteria andCompanyPositionsLike(String value) {
            addCriterion("company_positions like", value, "companyPositions");
            return (Criteria) this;
        }

        public Criteria andCompanyPositionsNotLike(String value) {
            addCriterion("company_positions not like", value, "companyPositions");
            return (Criteria) this;
        }

        public Criteria andCompanyPositionsIn(List<String> values) {
            addCriterion("company_positions in", values, "companyPositions");
            return (Criteria) this;
        }

        public Criteria andCompanyPositionsNotIn(List<String> values) {
            addCriterion("company_positions not in", values, "companyPositions");
            return (Criteria) this;
        }

        public Criteria andCompanyPositionsBetween(String value1, String value2) {
            addCriterion("company_positions between", value1, value2, "companyPositions");
            return (Criteria) this;
        }

        public Criteria andCompanyPositionsNotBetween(String value1, String value2) {
            addCriterion("company_positions not between", value1, value2, "companyPositions");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIsNull() {
            addCriterion("Company_Address is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIsNotNull() {
            addCriterion("Company_Address is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressEqualTo(String value) {
            addCriterion("Company_Address =", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotEqualTo(String value) {
            addCriterion("Company_Address <>", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressGreaterThan(String value) {
            addCriterion("Company_Address >", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressGreaterThanOrEqualTo(String value) {
            addCriterion("Company_Address >=", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLessThan(String value) {
            addCriterion("Company_Address <", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLessThanOrEqualTo(String value) {
            addCriterion("Company_Address <=", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLike(String value) {
            addCriterion("Company_Address like", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotLike(String value) {
            addCriterion("Company_Address not like", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIn(List<String> values) {
            addCriterion("Company_Address in", values, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotIn(List<String> values) {
            addCriterion("Company_Address not in", values, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressBetween(String value1, String value2) {
            addCriterion("Company_Address between", value1, value2, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotBetween(String value1, String value2) {
            addCriterion("Company_Address not between", value1, value2, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andBusinessCityIsNull() {
            addCriterion("business_city is null");
            return (Criteria) this;
        }

        public Criteria andBusinessCityIsNotNull() {
            addCriterion("business_city is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessCityEqualTo(String value) {
            addCriterion("business_city =", value, "businessCity");
            return (Criteria) this;
        }

        public Criteria andBusinessCityNotEqualTo(String value) {
            addCriterion("business_city <>", value, "businessCity");
            return (Criteria) this;
        }

        public Criteria andBusinessCityGreaterThan(String value) {
            addCriterion("business_city >", value, "businessCity");
            return (Criteria) this;
        }

        public Criteria andBusinessCityGreaterThanOrEqualTo(String value) {
            addCriterion("business_city >=", value, "businessCity");
            return (Criteria) this;
        }

        public Criteria andBusinessCityLessThan(String value) {
            addCriterion("business_city <", value, "businessCity");
            return (Criteria) this;
        }

        public Criteria andBusinessCityLessThanOrEqualTo(String value) {
            addCriterion("business_city <=", value, "businessCity");
            return (Criteria) this;
        }

        public Criteria andBusinessCityLike(String value) {
            addCriterion("business_city like", value, "businessCity");
            return (Criteria) this;
        }

        public Criteria andBusinessCityNotLike(String value) {
            addCriterion("business_city not like", value, "businessCity");
            return (Criteria) this;
        }

        public Criteria andBusinessCityIn(List<String> values) {
            addCriterion("business_city in", values, "businessCity");
            return (Criteria) this;
        }

        public Criteria andBusinessCityNotIn(List<String> values) {
            addCriterion("business_city not in", values, "businessCity");
            return (Criteria) this;
        }

        public Criteria andBusinessCityBetween(String value1, String value2) {
            addCriterion("business_city between", value1, value2, "businessCity");
            return (Criteria) this;
        }

        public Criteria andBusinessCityNotBetween(String value1, String value2) {
            addCriterion("business_city not between", value1, value2, "businessCity");
            return (Criteria) this;
        }

        public Criteria andJobsAddCompanyTimeIsNull() {
            addCriterion("jobs_add_Company_time is null");
            return (Criteria) this;
        }

        public Criteria andJobsAddCompanyTimeIsNotNull() {
            addCriterion("jobs_add_Company_time is not null");
            return (Criteria) this;
        }

        public Criteria andJobsAddCompanyTimeEqualTo(Date value) {
            addCriterion("jobs_add_Company_time =", value, "jobsAddCompanyTime");
            return (Criteria) this;
        }

        public Criteria andJobsAddCompanyTimeNotEqualTo(Date value) {
            addCriterion("jobs_add_Company_time <>", value, "jobsAddCompanyTime");
            return (Criteria) this;
        }

        public Criteria andJobsAddCompanyTimeGreaterThan(Date value) {
            addCriterion("jobs_add_Company_time >", value, "jobsAddCompanyTime");
            return (Criteria) this;
        }

        public Criteria andJobsAddCompanyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("jobs_add_Company_time >=", value, "jobsAddCompanyTime");
            return (Criteria) this;
        }

        public Criteria andJobsAddCompanyTimeLessThan(Date value) {
            addCriterion("jobs_add_Company_time <", value, "jobsAddCompanyTime");
            return (Criteria) this;
        }

        public Criteria andJobsAddCompanyTimeLessThanOrEqualTo(Date value) {
            addCriterion("jobs_add_Company_time <=", value, "jobsAddCompanyTime");
            return (Criteria) this;
        }

        public Criteria andJobsAddCompanyTimeIn(List<Date> values) {
            addCriterion("jobs_add_Company_time in", values, "jobsAddCompanyTime");
            return (Criteria) this;
        }

        public Criteria andJobsAddCompanyTimeNotIn(List<Date> values) {
            addCriterion("jobs_add_Company_time not in", values, "jobsAddCompanyTime");
            return (Criteria) this;
        }

        public Criteria andJobsAddCompanyTimeBetween(Date value1, Date value2) {
            addCriterion("jobs_add_Company_time between", value1, value2, "jobsAddCompanyTime");
            return (Criteria) this;
        }

        public Criteria andJobsAddCompanyTimeNotBetween(Date value1, Date value2) {
            addCriterion("jobs_add_Company_time not between", value1, value2, "jobsAddCompanyTime");
            return (Criteria) this;
        }

        public Criteria andJobsTimeIsNull() {
            addCriterion("jobs_time is null");
            return (Criteria) this;
        }

        public Criteria andJobsTimeIsNotNull() {
            addCriterion("jobs_time is not null");
            return (Criteria) this;
        }

        public Criteria andJobsTimeEqualTo(Integer value) {
            addCriterion("jobs_time =", value, "jobsTime");
            return (Criteria) this;
        }

        public Criteria andJobsTimeNotEqualTo(Integer value) {
            addCriterion("jobs_time <>", value, "jobsTime");
            return (Criteria) this;
        }

        public Criteria andJobsTimeGreaterThan(Integer value) {
            addCriterion("jobs_time >", value, "jobsTime");
            return (Criteria) this;
        }

        public Criteria andJobsTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("jobs_time >=", value, "jobsTime");
            return (Criteria) this;
        }

        public Criteria andJobsTimeLessThan(Integer value) {
            addCriterion("jobs_time <", value, "jobsTime");
            return (Criteria) this;
        }

        public Criteria andJobsTimeLessThanOrEqualTo(Integer value) {
            addCriterion("jobs_time <=", value, "jobsTime");
            return (Criteria) this;
        }

        public Criteria andJobsTimeIn(List<Integer> values) {
            addCriterion("jobs_time in", values, "jobsTime");
            return (Criteria) this;
        }

        public Criteria andJobsTimeNotIn(List<Integer> values) {
            addCriterion("jobs_time not in", values, "jobsTime");
            return (Criteria) this;
        }

        public Criteria andJobsTimeBetween(Integer value1, Integer value2) {
            addCriterion("jobs_time between", value1, value2, "jobsTime");
            return (Criteria) this;
        }

        public Criteria andJobsTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("jobs_time not between", value1, value2, "jobsTime");
            return (Criteria) this;
        }

        public Criteria andIsAccumulationFundIsNull() {
            addCriterion("is_accumulation_fund is null");
            return (Criteria) this;
        }

        public Criteria andIsAccumulationFundIsNotNull() {
            addCriterion("is_accumulation_fund is not null");
            return (Criteria) this;
        }

        public Criteria andIsAccumulationFundEqualTo(Byte value) {
            addCriterion("is_accumulation_fund =", value, "isAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andIsAccumulationFundNotEqualTo(Byte value) {
            addCriterion("is_accumulation_fund <>", value, "isAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andIsAccumulationFundGreaterThan(Byte value) {
            addCriterion("is_accumulation_fund >", value, "isAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andIsAccumulationFundGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_accumulation_fund >=", value, "isAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andIsAccumulationFundLessThan(Byte value) {
            addCriterion("is_accumulation_fund <", value, "isAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andIsAccumulationFundLessThanOrEqualTo(Byte value) {
            addCriterion("is_accumulation_fund <=", value, "isAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andIsAccumulationFundIn(List<Byte> values) {
            addCriterion("is_accumulation_fund in", values, "isAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andIsAccumulationFundNotIn(List<Byte> values) {
            addCriterion("is_accumulation_fund not in", values, "isAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andIsAccumulationFundBetween(Byte value1, Byte value2) {
            addCriterion("is_accumulation_fund between", value1, value2, "isAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andIsAccumulationFundNotBetween(Byte value1, Byte value2) {
            addCriterion("is_accumulation_fund not between", value1, value2, "isAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andWagesIsNull() {
            addCriterion("wages is null");
            return (Criteria) this;
        }

        public Criteria andWagesIsNotNull() {
            addCriterion("wages is not null");
            return (Criteria) this;
        }

        public Criteria andWagesEqualTo(Integer value) {
            addCriterion("wages =", value, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesNotEqualTo(Integer value) {
            addCriterion("wages <>", value, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesGreaterThan(Integer value) {
            addCriterion("wages >", value, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesGreaterThanOrEqualTo(Integer value) {
            addCriterion("wages >=", value, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesLessThan(Integer value) {
            addCriterion("wages <", value, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesLessThanOrEqualTo(Integer value) {
            addCriterion("wages <=", value, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesIn(List<Integer> values) {
            addCriterion("wages in", values, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesNotIn(List<Integer> values) {
            addCriterion("wages not in", values, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesBetween(Integer value1, Integer value2) {
            addCriterion("wages between", value1, value2, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesNotBetween(Integer value1, Integer value2) {
            addCriterion("wages not between", value1, value2, "wages");
            return (Criteria) this;
        }

        public Criteria andJobsAddtimeIsNull() {
            addCriterion("jobs_addtime is null");
            return (Criteria) this;
        }

        public Criteria andJobsAddtimeIsNotNull() {
            addCriterion("jobs_addtime is not null");
            return (Criteria) this;
        }

        public Criteria andJobsAddtimeEqualTo(Date value) {
            addCriterion("jobs_addtime =", value, "jobsAddtime");
            return (Criteria) this;
        }

        public Criteria andJobsAddtimeNotEqualTo(Date value) {
            addCriterion("jobs_addtime <>", value, "jobsAddtime");
            return (Criteria) this;
        }

        public Criteria andJobsAddtimeGreaterThan(Date value) {
            addCriterion("jobs_addtime >", value, "jobsAddtime");
            return (Criteria) this;
        }

        public Criteria andJobsAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("jobs_addtime >=", value, "jobsAddtime");
            return (Criteria) this;
        }

        public Criteria andJobsAddtimeLessThan(Date value) {
            addCriterion("jobs_addtime <", value, "jobsAddtime");
            return (Criteria) this;
        }

        public Criteria andJobsAddtimeLessThanOrEqualTo(Date value) {
            addCriterion("jobs_addtime <=", value, "jobsAddtime");
            return (Criteria) this;
        }

        public Criteria andJobsAddtimeIn(List<Date> values) {
            addCriterion("jobs_addtime in", values, "jobsAddtime");
            return (Criteria) this;
        }

        public Criteria andJobsAddtimeNotIn(List<Date> values) {
            addCriterion("jobs_addtime not in", values, "jobsAddtime");
            return (Criteria) this;
        }

        public Criteria andJobsAddtimeBetween(Date value1, Date value2) {
            addCriterion("jobs_addtime between", value1, value2, "jobsAddtime");
            return (Criteria) this;
        }

        public Criteria andJobsAddtimeNotBetween(Date value1, Date value2) {
            addCriterion("jobs_addtime not between", value1, value2, "jobsAddtime");
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
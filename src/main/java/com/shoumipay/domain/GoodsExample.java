package com.shoumipay.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andAliasIsNull() {
            addCriterion("alias is null");
            return (Criteria) this;
        }

        public Criteria andAliasIsNotNull() {
            addCriterion("alias is not null");
            return (Criteria) this;
        }

        public Criteria andAliasEqualTo(String value) {
            addCriterion("alias =", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotEqualTo(String value) {
            addCriterion("alias <>", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasGreaterThan(String value) {
            addCriterion("alias >", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasGreaterThanOrEqualTo(String value) {
            addCriterion("alias >=", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLessThan(String value) {
            addCriterion("alias <", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLessThanOrEqualTo(String value) {
            addCriterion("alias <=", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLike(String value) {
            addCriterion("alias like", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotLike(String value) {
            addCriterion("alias not like", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasIn(List<String> values) {
            addCriterion("alias in", values, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotIn(List<String> values) {
            addCriterion("alias not in", values, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasBetween(String value1, String value2) {
            addCriterion("alias between", value1, value2, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotBetween(String value1, String value2) {
            addCriterion("alias not between", value1, value2, "alias");
            return (Criteria) this;
        }

        public Criteria andTimeLimitIsNull() {
            addCriterion("time_Limit is null");
            return (Criteria) this;
        }

        public Criteria andTimeLimitIsNotNull() {
            addCriterion("time_Limit is not null");
            return (Criteria) this;
        }

        public Criteria andTimeLimitEqualTo(Integer value) {
            addCriterion("time_Limit =", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitNotEqualTo(Integer value) {
            addCriterion("time_Limit <>", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitGreaterThan(Integer value) {
            addCriterion("time_Limit >", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("time_Limit >=", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitLessThan(Integer value) {
            addCriterion("time_Limit <", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitLessThanOrEqualTo(Integer value) {
            addCriterion("time_Limit <=", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitIn(List<Integer> values) {
            addCriterion("time_Limit in", values, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitNotIn(List<Integer> values) {
            addCriterion("time_Limit not in", values, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitBetween(Integer value1, Integer value2) {
            addCriterion("time_Limit between", value1, value2, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("time_Limit not between", value1, value2, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeIsNull() {
            addCriterion("repayment_Type is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeIsNotNull() {
            addCriterion("repayment_Type is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeEqualTo(Integer value) {
            addCriterion("repayment_Type =", value, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeNotEqualTo(Integer value) {
            addCriterion("repayment_Type <>", value, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeGreaterThan(Integer value) {
            addCriterion("repayment_Type >", value, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("repayment_Type >=", value, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeLessThan(Integer value) {
            addCriterion("repayment_Type <", value, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeLessThanOrEqualTo(Integer value) {
            addCriterion("repayment_Type <=", value, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeIn(List<Integer> values) {
            addCriterion("repayment_Type in", values, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeNotIn(List<Integer> values) {
            addCriterion("repayment_Type not in", values, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeBetween(Integer value1, Integer value2) {
            addCriterion("repayment_Type between", value1, value2, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("repayment_Type not between", value1, value2, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNull() {
            addCriterion("addtime is null");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNotNull() {
            addCriterion("addtime is not null");
            return (Criteria) this;
        }

        public Criteria andAddtimeEqualTo(Date value) {
            addCriterion("addtime =", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotEqualTo(Date value) {
            addCriterion("addtime <>", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThan(Date value) {
            addCriterion("addtime >", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("addtime >=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThan(Date value) {
            addCriterion("addtime <", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThanOrEqualTo(Date value) {
            addCriterion("addtime <=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIn(List<Date> values) {
            addCriterion("addtime in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotIn(List<Date> values) {
            addCriterion("addtime not in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeBetween(Date value1, Date value2) {
            addCriterion("addtime between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotBetween(Date value1, Date value2) {
            addCriterion("addtime not between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andUpptimeIsNull() {
            addCriterion("upptime is null");
            return (Criteria) this;
        }

        public Criteria andUpptimeIsNotNull() {
            addCriterion("upptime is not null");
            return (Criteria) this;
        }

        public Criteria andUpptimeEqualTo(Date value) {
            addCriterion("upptime =", value, "upptime");
            return (Criteria) this;
        }

        public Criteria andUpptimeNotEqualTo(Date value) {
            addCriterion("upptime <>", value, "upptime");
            return (Criteria) this;
        }

        public Criteria andUpptimeGreaterThan(Date value) {
            addCriterion("upptime >", value, "upptime");
            return (Criteria) this;
        }

        public Criteria andUpptimeGreaterThanOrEqualTo(Date value) {
            addCriterion("upptime >=", value, "upptime");
            return (Criteria) this;
        }

        public Criteria andUpptimeLessThan(Date value) {
            addCriterion("upptime <", value, "upptime");
            return (Criteria) this;
        }

        public Criteria andUpptimeLessThanOrEqualTo(Date value) {
            addCriterion("upptime <=", value, "upptime");
            return (Criteria) this;
        }

        public Criteria andUpptimeIn(List<Date> values) {
            addCriterion("upptime in", values, "upptime");
            return (Criteria) this;
        }

        public Criteria andUpptimeNotIn(List<Date> values) {
            addCriterion("upptime not in", values, "upptime");
            return (Criteria) this;
        }

        public Criteria andUpptimeBetween(Date value1, Date value2) {
            addCriterion("upptime between", value1, value2, "upptime");
            return (Criteria) this;
        }

        public Criteria andUpptimeNotBetween(Date value1, Date value2) {
            addCriterion("upptime not between", value1, value2, "upptime");
            return (Criteria) this;
        }

        public Criteria andUppnameIsNull() {
            addCriterion("uppName is null");
            return (Criteria) this;
        }

        public Criteria andUppnameIsNotNull() {
            addCriterion("uppName is not null");
            return (Criteria) this;
        }

        public Criteria andUppnameEqualTo(String value) {
            addCriterion("uppName =", value, "uppname");
            return (Criteria) this;
        }

        public Criteria andUppnameNotEqualTo(String value) {
            addCriterion("uppName <>", value, "uppname");
            return (Criteria) this;
        }

        public Criteria andUppnameGreaterThan(String value) {
            addCriterion("uppName >", value, "uppname");
            return (Criteria) this;
        }

        public Criteria andUppnameGreaterThanOrEqualTo(String value) {
            addCriterion("uppName >=", value, "uppname");
            return (Criteria) this;
        }

        public Criteria andUppnameLessThan(String value) {
            addCriterion("uppName <", value, "uppname");
            return (Criteria) this;
        }

        public Criteria andUppnameLessThanOrEqualTo(String value) {
            addCriterion("uppName <=", value, "uppname");
            return (Criteria) this;
        }

        public Criteria andUppnameLike(String value) {
            addCriterion("uppName like", value, "uppname");
            return (Criteria) this;
        }

        public Criteria andUppnameNotLike(String value) {
            addCriterion("uppName not like", value, "uppname");
            return (Criteria) this;
        }

        public Criteria andUppnameIn(List<String> values) {
            addCriterion("uppName in", values, "uppname");
            return (Criteria) this;
        }

        public Criteria andUppnameNotIn(List<String> values) {
            addCriterion("uppName not in", values, "uppname");
            return (Criteria) this;
        }

        public Criteria andUppnameBetween(String value1, String value2) {
            addCriterion("uppName between", value1, value2, "uppname");
            return (Criteria) this;
        }

        public Criteria andUppnameNotBetween(String value1, String value2) {
            addCriterion("uppName not between", value1, value2, "uppname");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andCostnameIsNull() {
            addCriterion("costName is null");
            return (Criteria) this;
        }

        public Criteria andCostnameIsNotNull() {
            addCriterion("costName is not null");
            return (Criteria) this;
        }

        public Criteria andCostnameEqualTo(String value) {
            addCriterion("costName =", value, "costname");
            return (Criteria) this;
        }

        public Criteria andCostnameNotEqualTo(String value) {
            addCriterion("costName <>", value, "costname");
            return (Criteria) this;
        }

        public Criteria andCostnameGreaterThan(String value) {
            addCriterion("costName >", value, "costname");
            return (Criteria) this;
        }

        public Criteria andCostnameGreaterThanOrEqualTo(String value) {
            addCriterion("costName >=", value, "costname");
            return (Criteria) this;
        }

        public Criteria andCostnameLessThan(String value) {
            addCriterion("costName <", value, "costname");
            return (Criteria) this;
        }

        public Criteria andCostnameLessThanOrEqualTo(String value) {
            addCriterion("costName <=", value, "costname");
            return (Criteria) this;
        }

        public Criteria andCostnameLike(String value) {
            addCriterion("costName like", value, "costname");
            return (Criteria) this;
        }

        public Criteria andCostnameNotLike(String value) {
            addCriterion("costName not like", value, "costname");
            return (Criteria) this;
        }

        public Criteria andCostnameIn(List<String> values) {
            addCriterion("costName in", values, "costname");
            return (Criteria) this;
        }

        public Criteria andCostnameNotIn(List<String> values) {
            addCriterion("costName not in", values, "costname");
            return (Criteria) this;
        }

        public Criteria andCostnameBetween(String value1, String value2) {
            addCriterion("costName between", value1, value2, "costname");
            return (Criteria) this;
        }

        public Criteria andCostnameNotBetween(String value1, String value2) {
            addCriterion("costName not between", value1, value2, "costname");
            return (Criteria) this;
        }

        public Criteria andBillingMethodsIsNull() {
            addCriterion("billing_Methods is null");
            return (Criteria) this;
        }

        public Criteria andBillingMethodsIsNotNull() {
            addCriterion("billing_Methods is not null");
            return (Criteria) this;
        }

        public Criteria andBillingMethodsEqualTo(Integer value) {
            addCriterion("billing_Methods =", value, "billingMethods");
            return (Criteria) this;
        }

        public Criteria andBillingMethodsNotEqualTo(Integer value) {
            addCriterion("billing_Methods <>", value, "billingMethods");
            return (Criteria) this;
        }

        public Criteria andBillingMethodsGreaterThan(Integer value) {
            addCriterion("billing_Methods >", value, "billingMethods");
            return (Criteria) this;
        }

        public Criteria andBillingMethodsGreaterThanOrEqualTo(Integer value) {
            addCriterion("billing_Methods >=", value, "billingMethods");
            return (Criteria) this;
        }

        public Criteria andBillingMethodsLessThan(Integer value) {
            addCriterion("billing_Methods <", value, "billingMethods");
            return (Criteria) this;
        }

        public Criteria andBillingMethodsLessThanOrEqualTo(Integer value) {
            addCriterion("billing_Methods <=", value, "billingMethods");
            return (Criteria) this;
        }

        public Criteria andBillingMethodsIn(List<Integer> values) {
            addCriterion("billing_Methods in", values, "billingMethods");
            return (Criteria) this;
        }

        public Criteria andBillingMethodsNotIn(List<Integer> values) {
            addCriterion("billing_Methods not in", values, "billingMethods");
            return (Criteria) this;
        }

        public Criteria andBillingMethodsBetween(Integer value1, Integer value2) {
            addCriterion("billing_Methods between", value1, value2, "billingMethods");
            return (Criteria) this;
        }

        public Criteria andBillingMethodsNotBetween(Integer value1, Integer value2) {
            addCriterion("billing_Methods not between", value1, value2, "billingMethods");
            return (Criteria) this;
        }

        public Criteria andCostIsNull() {
            addCriterion("cost is null");
            return (Criteria) this;
        }

        public Criteria andCostIsNotNull() {
            addCriterion("cost is not null");
            return (Criteria) this;
        }

        public Criteria andCostEqualTo(BigDecimal value) {
            addCriterion("cost =", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotEqualTo(BigDecimal value) {
            addCriterion("cost <>", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThan(BigDecimal value) {
            addCriterion("cost >", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost >=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThan(BigDecimal value) {
            addCriterion("cost <", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost <=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostIn(List<BigDecimal> values) {
            addCriterion("cost in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotIn(List<BigDecimal> values) {
            addCriterion("cost not in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost not between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andProductRateIsNull() {
            addCriterion("product_Rate is null");
            return (Criteria) this;
        }

        public Criteria andProductRateIsNotNull() {
            addCriterion("product_Rate is not null");
            return (Criteria) this;
        }

        public Criteria andProductRateEqualTo(BigDecimal value) {
            addCriterion("product_Rate =", value, "productRate");
            return (Criteria) this;
        }

        public Criteria andProductRateNotEqualTo(BigDecimal value) {
            addCriterion("product_Rate <>", value, "productRate");
            return (Criteria) this;
        }

        public Criteria andProductRateGreaterThan(BigDecimal value) {
            addCriterion("product_Rate >", value, "productRate");
            return (Criteria) this;
        }

        public Criteria andProductRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_Rate >=", value, "productRate");
            return (Criteria) this;
        }

        public Criteria andProductRateLessThan(BigDecimal value) {
            addCriterion("product_Rate <", value, "productRate");
            return (Criteria) this;
        }

        public Criteria andProductRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_Rate <=", value, "productRate");
            return (Criteria) this;
        }

        public Criteria andProductRateIn(List<BigDecimal> values) {
            addCriterion("product_Rate in", values, "productRate");
            return (Criteria) this;
        }

        public Criteria andProductRateNotIn(List<BigDecimal> values) {
            addCriterion("product_Rate not in", values, "productRate");
            return (Criteria) this;
        }

        public Criteria andProductRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_Rate between", value1, value2, "productRate");
            return (Criteria) this;
        }

        public Criteria andProductRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_Rate not between", value1, value2, "productRate");
            return (Criteria) this;
        }

        public Criteria andTotalRateIsNull() {
            addCriterion("total_Rate is null");
            return (Criteria) this;
        }

        public Criteria andTotalRateIsNotNull() {
            addCriterion("total_Rate is not null");
            return (Criteria) this;
        }

        public Criteria andTotalRateEqualTo(BigDecimal value) {
            addCriterion("total_Rate =", value, "totalRate");
            return (Criteria) this;
        }

        public Criteria andTotalRateNotEqualTo(BigDecimal value) {
            addCriterion("total_Rate <>", value, "totalRate");
            return (Criteria) this;
        }

        public Criteria andTotalRateGreaterThan(BigDecimal value) {
            addCriterion("total_Rate >", value, "totalRate");
            return (Criteria) this;
        }

        public Criteria andTotalRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_Rate >=", value, "totalRate");
            return (Criteria) this;
        }

        public Criteria andTotalRateLessThan(BigDecimal value) {
            addCriterion("total_Rate <", value, "totalRate");
            return (Criteria) this;
        }

        public Criteria andTotalRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_Rate <=", value, "totalRate");
            return (Criteria) this;
        }

        public Criteria andTotalRateIn(List<BigDecimal> values) {
            addCriterion("total_Rate in", values, "totalRate");
            return (Criteria) this;
        }

        public Criteria andTotalRateNotIn(List<BigDecimal> values) {
            addCriterion("total_Rate not in", values, "totalRate");
            return (Criteria) this;
        }

        public Criteria andTotalRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_Rate between", value1, value2, "totalRate");
            return (Criteria) this;
        }

        public Criteria andTotalRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_Rate not between", value1, value2, "totalRate");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestIsNull() {
            addCriterion("overdue_Interest is null");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestIsNotNull() {
            addCriterion("overdue_Interest is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestEqualTo(BigDecimal value) {
            addCriterion("overdue_Interest =", value, "overdueInterest");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestNotEqualTo(BigDecimal value) {
            addCriterion("overdue_Interest <>", value, "overdueInterest");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestGreaterThan(BigDecimal value) {
            addCriterion("overdue_Interest >", value, "overdueInterest");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("overdue_Interest >=", value, "overdueInterest");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestLessThan(BigDecimal value) {
            addCriterion("overdue_Interest <", value, "overdueInterest");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestLessThanOrEqualTo(BigDecimal value) {
            addCriterion("overdue_Interest <=", value, "overdueInterest");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestIn(List<BigDecimal> values) {
            addCriterion("overdue_Interest in", values, "overdueInterest");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestNotIn(List<BigDecimal> values) {
            addCriterion("overdue_Interest not in", values, "overdueInterest");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("overdue_Interest between", value1, value2, "overdueInterest");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("overdue_Interest not between", value1, value2, "overdueInterest");
            return (Criteria) this;
        }
 public Criteria andMaxamountIsNull() {
            addCriterion("maxAmount is null");
            return (Criteria) this;
        }

        public Criteria andMaxamountIsNotNull() {
            addCriterion("maxAmount is not null");
            return (Criteria) this;
        }

        public Criteria andMaxamountEqualTo(BigDecimal value) {
            addCriterion("maxAmount =", value, "maxamount");
            return (Criteria) this;
        }

        public Criteria andMaxamountNotEqualTo(BigDecimal value) {
            addCriterion("maxAmount <>", value, "maxamount");
            return (Criteria) this;
        }

        public Criteria andMaxamountGreaterThan(BigDecimal value) {
            addCriterion("maxAmount >", value, "maxamount");
            return (Criteria) this;
        }

        public Criteria andMaxamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("maxAmount >=", value, "maxamount");
            return (Criteria) this;
        }

        public Criteria andMaxamountLessThan(BigDecimal value) {
            addCriterion("maxAmount <", value, "maxamount");
            return (Criteria) this;
        }

        public Criteria andMaxamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("maxAmount <=", value, "maxamount");
            return (Criteria) this;
        }

        public Criteria andMaxamountIn(List<BigDecimal> values) {
            addCriterion("maxAmount in", values, "maxamount");
            return (Criteria) this;
        }

        public Criteria andMaxamountNotIn(List<BigDecimal> values) {
            addCriterion("maxAmount not in", values, "maxamount");
            return (Criteria) this;
        }

        public Criteria andMaxamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("maxAmount between", value1, value2, "maxamount");
            return (Criteria) this;
        }

        public Criteria andMaxamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("maxAmount not between", value1, value2, "maxamount");
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
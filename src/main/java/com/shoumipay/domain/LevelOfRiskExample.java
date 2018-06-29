package com.shoumipay.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LevelOfRiskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LevelOfRiskExample() {
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

        public Criteria andLevelOfRiskIsNull() {
            addCriterion("level_Of_Risk is null");
            return (Criteria) this;
        }

        public Criteria andLevelOfRiskIsNotNull() {
            addCriterion("level_Of_Risk is not null");
            return (Criteria) this;
        }

        public Criteria andLevelOfRiskEqualTo(String value) {
            addCriterion("level_Of_Risk =", value, "levelOfRisk");
            return (Criteria) this;
        }

        public Criteria andLevelOfRiskNotEqualTo(String value) {
            addCriterion("level_Of_Risk <>", value, "levelOfRisk");
            return (Criteria) this;
        }

        public Criteria andLevelOfRiskGreaterThan(String value) {
            addCriterion("level_Of_Risk >", value, "levelOfRisk");
            return (Criteria) this;
        }

        public Criteria andLevelOfRiskGreaterThanOrEqualTo(String value) {
            addCriterion("level_Of_Risk >=", value, "levelOfRisk");
            return (Criteria) this;
        }

        public Criteria andLevelOfRiskLessThan(String value) {
            addCriterion("level_Of_Risk <", value, "levelOfRisk");
            return (Criteria) this;
        }

        public Criteria andLevelOfRiskLessThanOrEqualTo(String value) {
            addCriterion("level_Of_Risk <=", value, "levelOfRisk");
            return (Criteria) this;
        }

        public Criteria andLevelOfRiskLike(String value) {
            addCriterion("level_Of_Risk like", value, "levelOfRisk");
            return (Criteria) this;
        }

        public Criteria andLevelOfRiskNotLike(String value) {
            addCriterion("level_Of_Risk not like", value, "levelOfRisk");
            return (Criteria) this;
        }

        public Criteria andLevelOfRiskIn(List<String> values) {
            addCriterion("level_Of_Risk in", values, "levelOfRisk");
            return (Criteria) this;
        }

        public Criteria andLevelOfRiskNotIn(List<String> values) {
            addCriterion("level_Of_Risk not in", values, "levelOfRisk");
            return (Criteria) this;
        }

        public Criteria andLevelOfRiskBetween(String value1, String value2) {
            addCriterion("level_Of_Risk between", value1, value2, "levelOfRisk");
            return (Criteria) this;
        }

        public Criteria andLevelOfRiskNotBetween(String value1, String value2) {
            addCriterion("level_Of_Risk not between", value1, value2, "levelOfRisk");
            return (Criteria) this;
        }

        public Criteria andAnnualInterestRateIsNull() {
            addCriterion("annual_Interest_Rate is null");
            return (Criteria) this;
        }

        public Criteria andAnnualInterestRateIsNotNull() {
            addCriterion("annual_Interest_Rate is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualInterestRateEqualTo(BigDecimal value) {
            addCriterion("annual_Interest_Rate =", value, "annualInterestRate");
            return (Criteria) this;
        }

        public Criteria andAnnualInterestRateNotEqualTo(BigDecimal value) {
            addCriterion("annual_Interest_Rate <>", value, "annualInterestRate");
            return (Criteria) this;
        }

        public Criteria andAnnualInterestRateGreaterThan(BigDecimal value) {
            addCriterion("annual_Interest_Rate >", value, "annualInterestRate");
            return (Criteria) this;
        }

        public Criteria andAnnualInterestRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("annual_Interest_Rate >=", value, "annualInterestRate");
            return (Criteria) this;
        }

        public Criteria andAnnualInterestRateLessThan(BigDecimal value) {
            addCriterion("annual_Interest_Rate <", value, "annualInterestRate");
            return (Criteria) this;
        }

        public Criteria andAnnualInterestRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("annual_Interest_Rate <=", value, "annualInterestRate");
            return (Criteria) this;
        }

        public Criteria andAnnualInterestRateIn(List<BigDecimal> values) {
            addCriterion("annual_Interest_Rate in", values, "annualInterestRate");
            return (Criteria) this;
        }

        public Criteria andAnnualInterestRateNotIn(List<BigDecimal> values) {
            addCriterion("annual_Interest_Rate not in", values, "annualInterestRate");
            return (Criteria) this;
        }

        public Criteria andAnnualInterestRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("annual_Interest_Rate between", value1, value2, "annualInterestRate");
            return (Criteria) this;
        }

        public Criteria andAnnualInterestRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("annual_Interest_Rate not between", value1, value2, "annualInterestRate");
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

        public Criteria andPlatformManagementFeeIsNull() {
            addCriterion("platform_Management_Fee is null");
            return (Criteria) this;
        }

        public Criteria andPlatformManagementFeeIsNotNull() {
            addCriterion("platform_Management_Fee is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformManagementFeeEqualTo(BigDecimal value) {
            addCriterion("platform_Management_Fee =", value, "platformManagementFee");
            return (Criteria) this;
        }

        public Criteria andPlatformManagementFeeNotEqualTo(BigDecimal value) {
            addCriterion("platform_Management_Fee <>", value, "platformManagementFee");
            return (Criteria) this;
        }

        public Criteria andPlatformManagementFeeGreaterThan(BigDecimal value) {
            addCriterion("platform_Management_Fee >", value, "platformManagementFee");
            return (Criteria) this;
        }

        public Criteria andPlatformManagementFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("platform_Management_Fee >=", value, "platformManagementFee");
            return (Criteria) this;
        }

        public Criteria andPlatformManagementFeeLessThan(BigDecimal value) {
            addCriterion("platform_Management_Fee <", value, "platformManagementFee");
            return (Criteria) this;
        }

        public Criteria andPlatformManagementFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("platform_Management_Fee <=", value, "platformManagementFee");
            return (Criteria) this;
        }

        public Criteria andPlatformManagementFeeIn(List<BigDecimal> values) {
            addCriterion("platform_Management_Fee in", values, "platformManagementFee");
            return (Criteria) this;
        }

        public Criteria andPlatformManagementFeeNotIn(List<BigDecimal> values) {
            addCriterion("platform_Management_Fee not in", values, "platformManagementFee");
            return (Criteria) this;
        }

        public Criteria andPlatformManagementFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("platform_Management_Fee between", value1, value2, "platformManagementFee");
            return (Criteria) this;
        }

        public Criteria andPlatformManagementFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("platform_Management_Fee not between", value1, value2, "platformManagementFee");
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
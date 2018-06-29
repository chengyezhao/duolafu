package com.shoumipay.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsRepaymentPlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsRepaymentPlanExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_Id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_Id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_Id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_Id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_Id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_Id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_Id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_Id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_Id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_Id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_Id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_Id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanTimesIsNull() {
            addCriterion("repayment_plan_times is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanTimesIsNotNull() {
            addCriterion("repayment_plan_times is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanTimesEqualTo(Integer value) {
            addCriterion("repayment_plan_times =", value, "repaymentPlanTimes");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanTimesNotEqualTo(Integer value) {
            addCriterion("repayment_plan_times <>", value, "repaymentPlanTimes");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanTimesGreaterThan(Integer value) {
            addCriterion("repayment_plan_times >", value, "repaymentPlanTimes");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("repayment_plan_times >=", value, "repaymentPlanTimes");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanTimesLessThan(Integer value) {
            addCriterion("repayment_plan_times <", value, "repaymentPlanTimes");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanTimesLessThanOrEqualTo(Integer value) {
            addCriterion("repayment_plan_times <=", value, "repaymentPlanTimes");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanTimesIn(List<Integer> values) {
            addCriterion("repayment_plan_times in", values, "repaymentPlanTimes");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanTimesNotIn(List<Integer> values) {
            addCriterion("repayment_plan_times not in", values, "repaymentPlanTimes");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanTimesBetween(Integer value1, Integer value2) {
            addCriterion("repayment_plan_times between", value1, value2, "repaymentPlanTimes");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("repayment_plan_times not between", value1, value2, "repaymentPlanTimes");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanAmountIsNull() {
            addCriterion("repayment_plan_amount is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanAmountIsNotNull() {
            addCriterion("repayment_plan_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanAmountEqualTo(BigDecimal value) {
            addCriterion("repayment_plan_amount =", value, "repaymentPlanAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanAmountNotEqualTo(BigDecimal value) {
            addCriterion("repayment_plan_amount <>", value, "repaymentPlanAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanAmountGreaterThan(BigDecimal value) {
            addCriterion("repayment_plan_amount >", value, "repaymentPlanAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("repayment_plan_amount >=", value, "repaymentPlanAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanAmountLessThan(BigDecimal value) {
            addCriterion("repayment_plan_amount <", value, "repaymentPlanAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("repayment_plan_amount <=", value, "repaymentPlanAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanAmountIn(List<BigDecimal> values) {
            addCriterion("repayment_plan_amount in", values, "repaymentPlanAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanAmountNotIn(List<BigDecimal> values) {
            addCriterion("repayment_plan_amount not in", values, "repaymentPlanAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayment_plan_amount between", value1, value2, "repaymentPlanAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayment_plan_amount not between", value1, value2, "repaymentPlanAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanCapitalIsNull() {
            addCriterion("repayment_plan_capital is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanCapitalIsNotNull() {
            addCriterion("repayment_plan_capital is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanCapitalEqualTo(BigDecimal value) {
            addCriterion("repayment_plan_capital =", value, "repaymentPlanCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanCapitalNotEqualTo(BigDecimal value) {
            addCriterion("repayment_plan_capital <>", value, "repaymentPlanCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanCapitalGreaterThan(BigDecimal value) {
            addCriterion("repayment_plan_capital >", value, "repaymentPlanCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanCapitalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("repayment_plan_capital >=", value, "repaymentPlanCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanCapitalLessThan(BigDecimal value) {
            addCriterion("repayment_plan_capital <", value, "repaymentPlanCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanCapitalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("repayment_plan_capital <=", value, "repaymentPlanCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanCapitalIn(List<BigDecimal> values) {
            addCriterion("repayment_plan_capital in", values, "repaymentPlanCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanCapitalNotIn(List<BigDecimal> values) {
            addCriterion("repayment_plan_capital not in", values, "repaymentPlanCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanCapitalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayment_plan_capital between", value1, value2, "repaymentPlanCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanCapitalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayment_plan_capital not between", value1, value2, "repaymentPlanCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanInterestIsNull() {
            addCriterion("repayment_plan_interest is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanInterestIsNotNull() {
            addCriterion("repayment_plan_interest is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanInterestEqualTo(BigDecimal value) {
            addCriterion("repayment_plan_interest =", value, "repaymentPlanInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanInterestNotEqualTo(BigDecimal value) {
            addCriterion("repayment_plan_interest <>", value, "repaymentPlanInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanInterestGreaterThan(BigDecimal value) {
            addCriterion("repayment_plan_interest >", value, "repaymentPlanInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanInterestGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("repayment_plan_interest >=", value, "repaymentPlanInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanInterestLessThan(BigDecimal value) {
            addCriterion("repayment_plan_interest <", value, "repaymentPlanInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanInterestLessThanOrEqualTo(BigDecimal value) {
            addCriterion("repayment_plan_interest <=", value, "repaymentPlanInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanInterestIn(List<BigDecimal> values) {
            addCriterion("repayment_plan_interest in", values, "repaymentPlanInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanInterestNotIn(List<BigDecimal> values) {
            addCriterion("repayment_plan_interest not in", values, "repaymentPlanInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanInterestBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayment_plan_interest between", value1, value2, "repaymentPlanInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanInterestNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayment_plan_interest not between", value1, value2, "repaymentPlanInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanEndTimeIsNull() {
            addCriterion("repayment_plan_end_time is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanEndTimeIsNotNull() {
            addCriterion("repayment_plan_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanEndTimeEqualTo(Date value) {
            addCriterion("repayment_plan_end_time =", value, "repaymentPlanEndTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanEndTimeNotEqualTo(Date value) {
            addCriterion("repayment_plan_end_time <>", value, "repaymentPlanEndTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanEndTimeGreaterThan(Date value) {
            addCriterion("repayment_plan_end_time >", value, "repaymentPlanEndTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("repayment_plan_end_time >=", value, "repaymentPlanEndTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanEndTimeLessThan(Date value) {
            addCriterion("repayment_plan_end_time <", value, "repaymentPlanEndTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("repayment_plan_end_time <=", value, "repaymentPlanEndTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanEndTimeIn(List<Date> values) {
            addCriterion("repayment_plan_end_time in", values, "repaymentPlanEndTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanEndTimeNotIn(List<Date> values) {
            addCriterion("repayment_plan_end_time not in", values, "repaymentPlanEndTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanEndTimeBetween(Date value1, Date value2) {
            addCriterion("repayment_plan_end_time between", value1, value2, "repaymentPlanEndTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("repayment_plan_end_time not between", value1, value2, "repaymentPlanEndTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
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
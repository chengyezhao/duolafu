package com.shoumipay.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FinancialMACExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinancialMACExample() {
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

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Long value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Long value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Long> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Long> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andChannelIsNull() {
            addCriterion("channel is null");
            return (Criteria) this;
        }

        public Criteria andChannelIsNotNull() {
            addCriterion("channel is not null");
            return (Criteria) this;
        }

        public Criteria andChannelEqualTo(String value) {
            addCriterion("channel =", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotEqualTo(String value) {
            addCriterion("channel <>", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThan(String value) {
            addCriterion("channel >", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThanOrEqualTo(String value) {
            addCriterion("channel >=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThan(String value) {
            addCriterion("channel <", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThanOrEqualTo(String value) {
            addCriterion("channel <=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLike(String value) {
            addCriterion("channel like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotLike(String value) {
            addCriterion("channel not like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelIn(List<String> values) {
            addCriterion("channel in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotIn(List<String> values) {
            addCriterion("channel not in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelBetween(String value1, String value2) {
            addCriterion("channel between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotBetween(String value1, String value2) {
            addCriterion("channel not between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andTodayAmountNumberIsNull() {
            addCriterion("today_amount_number is null");
            return (Criteria) this;
        }

        public Criteria andTodayAmountNumberIsNotNull() {
            addCriterion("today_amount_number is not null");
            return (Criteria) this;
        }

        public Criteria andTodayAmountNumberEqualTo(Long value) {
            addCriterion("today_amount_number =", value, "todayAmountNumber");
            return (Criteria) this;
        }

        public Criteria andTodayAmountNumberNotEqualTo(Long value) {
            addCriterion("today_amount_number <>", value, "todayAmountNumber");
            return (Criteria) this;
        }

        public Criteria andTodayAmountNumberGreaterThan(Long value) {
            addCriterion("today_amount_number >", value, "todayAmountNumber");
            return (Criteria) this;
        }

        public Criteria andTodayAmountNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("today_amount_number >=", value, "todayAmountNumber");
            return (Criteria) this;
        }

        public Criteria andTodayAmountNumberLessThan(Long value) {
            addCriterion("today_amount_number <", value, "todayAmountNumber");
            return (Criteria) this;
        }

        public Criteria andTodayAmountNumberLessThanOrEqualTo(Long value) {
            addCriterion("today_amount_number <=", value, "todayAmountNumber");
            return (Criteria) this;
        }

        public Criteria andTodayAmountNumberIn(List<Long> values) {
            addCriterion("today_amount_number in", values, "todayAmountNumber");
            return (Criteria) this;
        }

        public Criteria andTodayAmountNumberNotIn(List<Long> values) {
            addCriterion("today_amount_number not in", values, "todayAmountNumber");
            return (Criteria) this;
        }

        public Criteria andTodayAmountNumberBetween(Long value1, Long value2) {
            addCriterion("today_amount_number between", value1, value2, "todayAmountNumber");
            return (Criteria) this;
        }

        public Criteria andTodayAmountNumberNotBetween(Long value1, Long value2) {
            addCriterion("today_amount_number not between", value1, value2, "todayAmountNumber");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNumberIsNull() {
            addCriterion("total_amount_number is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNumberIsNotNull() {
            addCriterion("total_amount_number is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNumberEqualTo(Long value) {
            addCriterion("total_amount_number =", value, "totalAmountNumber");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNumberNotEqualTo(Long value) {
            addCriterion("total_amount_number <>", value, "totalAmountNumber");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNumberGreaterThan(Long value) {
            addCriterion("total_amount_number >", value, "totalAmountNumber");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("total_amount_number >=", value, "totalAmountNumber");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNumberLessThan(Long value) {
            addCriterion("total_amount_number <", value, "totalAmountNumber");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNumberLessThanOrEqualTo(Long value) {
            addCriterion("total_amount_number <=", value, "totalAmountNumber");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNumberIn(List<Long> values) {
            addCriterion("total_amount_number in", values, "totalAmountNumber");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNumberNotIn(List<Long> values) {
            addCriterion("total_amount_number not in", values, "totalAmountNumber");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNumberBetween(Long value1, Long value2) {
            addCriterion("total_amount_number between", value1, value2, "totalAmountNumber");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNumberNotBetween(Long value1, Long value2) {
            addCriterion("total_amount_number not between", value1, value2, "totalAmountNumber");
            return (Criteria) this;
        }

        public Criteria andTodayRepayShouldIsNull() {
            addCriterion("today_repay_should is null");
            return (Criteria) this;
        }

        public Criteria andTodayRepayShouldIsNotNull() {
            addCriterion("today_repay_should is not null");
            return (Criteria) this;
        }

        public Criteria andTodayRepayShouldEqualTo(BigDecimal value) {
            addCriterion("today_repay_should =", value, "todayRepayShould");
            return (Criteria) this;
        }

        public Criteria andTodayRepayShouldNotEqualTo(BigDecimal value) {
            addCriterion("today_repay_should <>", value, "todayRepayShould");
            return (Criteria) this;
        }

        public Criteria andTodayRepayShouldGreaterThan(BigDecimal value) {
            addCriterion("today_repay_should >", value, "todayRepayShould");
            return (Criteria) this;
        }

        public Criteria andTodayRepayShouldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("today_repay_should >=", value, "todayRepayShould");
            return (Criteria) this;
        }

        public Criteria andTodayRepayShouldLessThan(BigDecimal value) {
            addCriterion("today_repay_should <", value, "todayRepayShould");
            return (Criteria) this;
        }

        public Criteria andTodayRepayShouldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("today_repay_should <=", value, "todayRepayShould");
            return (Criteria) this;
        }

        public Criteria andTodayRepayShouldIn(List<BigDecimal> values) {
            addCriterion("today_repay_should in", values, "todayRepayShould");
            return (Criteria) this;
        }

        public Criteria andTodayRepayShouldNotIn(List<BigDecimal> values) {
            addCriterion("today_repay_should not in", values, "todayRepayShould");
            return (Criteria) this;
        }

        public Criteria andTodayRepayShouldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("today_repay_should between", value1, value2, "todayRepayShould");
            return (Criteria) this;
        }

        public Criteria andTodayRepayShouldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("today_repay_should not between", value1, value2, "todayRepayShould");
            return (Criteria) this;
        }

        public Criteria andTodayRealityAmountIsNull() {
            addCriterion("today_reality_amount is null");
            return (Criteria) this;
        }

        public Criteria andTodayRealityAmountIsNotNull() {
            addCriterion("today_reality_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTodayRealityAmountEqualTo(BigDecimal value) {
            addCriterion("today_reality_amount =", value, "todayRealityAmount");
            return (Criteria) this;
        }

        public Criteria andTodayRealityAmountNotEqualTo(BigDecimal value) {
            addCriterion("today_reality_amount <>", value, "todayRealityAmount");
            return (Criteria) this;
        }

        public Criteria andTodayRealityAmountGreaterThan(BigDecimal value) {
            addCriterion("today_reality_amount >", value, "todayRealityAmount");
            return (Criteria) this;
        }

        public Criteria andTodayRealityAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("today_reality_amount >=", value, "todayRealityAmount");
            return (Criteria) this;
        }

        public Criteria andTodayRealityAmountLessThan(BigDecimal value) {
            addCriterion("today_reality_amount <", value, "todayRealityAmount");
            return (Criteria) this;
        }

        public Criteria andTodayRealityAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("today_reality_amount <=", value, "todayRealityAmount");
            return (Criteria) this;
        }

        public Criteria andTodayRealityAmountIn(List<BigDecimal> values) {
            addCriterion("today_reality_amount in", values, "todayRealityAmount");
            return (Criteria) this;
        }

        public Criteria andTodayRealityAmountNotIn(List<BigDecimal> values) {
            addCriterion("today_reality_amount not in", values, "todayRealityAmount");
            return (Criteria) this;
        }

        public Criteria andTodayRealityAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("today_reality_amount between", value1, value2, "todayRealityAmount");
            return (Criteria) this;
        }

        public Criteria andTodayRealityAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("today_reality_amount not between", value1, value2, "todayRealityAmount");
            return (Criteria) this;
        }

        public Criteria andTodayRepayShouldPrcIsNull() {
            addCriterion("today_repay_should_prc is null");
            return (Criteria) this;
        }

        public Criteria andTodayRepayShouldPrcIsNotNull() {
            addCriterion("today_repay_should_prc is not null");
            return (Criteria) this;
        }

        public Criteria andTodayRepayShouldPrcEqualTo(BigDecimal value) {
            addCriterion("today_repay_should_prc =", value, "todayRepayShouldPrc");
            return (Criteria) this;
        }

        public Criteria andTodayRepayShouldPrcNotEqualTo(BigDecimal value) {
            addCriterion("today_repay_should_prc <>", value, "todayRepayShouldPrc");
            return (Criteria) this;
        }

        public Criteria andTodayRepayShouldPrcGreaterThan(BigDecimal value) {
            addCriterion("today_repay_should_prc >", value, "todayRepayShouldPrc");
            return (Criteria) this;
        }

        public Criteria andTodayRepayShouldPrcGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("today_repay_should_prc >=", value, "todayRepayShouldPrc");
            return (Criteria) this;
        }

        public Criteria andTodayRepayShouldPrcLessThan(BigDecimal value) {
            addCriterion("today_repay_should_prc <", value, "todayRepayShouldPrc");
            return (Criteria) this;
        }

        public Criteria andTodayRepayShouldPrcLessThanOrEqualTo(BigDecimal value) {
            addCriterion("today_repay_should_prc <=", value, "todayRepayShouldPrc");
            return (Criteria) this;
        }

        public Criteria andTodayRepayShouldPrcIn(List<BigDecimal> values) {
            addCriterion("today_repay_should_prc in", values, "todayRepayShouldPrc");
            return (Criteria) this;
        }

        public Criteria andTodayRepayShouldPrcNotIn(List<BigDecimal> values) {
            addCriterion("today_repay_should_prc not in", values, "todayRepayShouldPrc");
            return (Criteria) this;
        }

        public Criteria andTodayRepayShouldPrcBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("today_repay_should_prc between", value1, value2, "todayRepayShouldPrc");
            return (Criteria) this;
        }

        public Criteria andTodayRepayShouldPrcNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("today_repay_should_prc not between", value1, value2, "todayRepayShouldPrc");
            return (Criteria) this;
        }

        public Criteria andTodayRealityPrcIsNull() {
            addCriterion("today_reality_prc is null");
            return (Criteria) this;
        }

        public Criteria andTodayRealityPrcIsNotNull() {
            addCriterion("today_reality_prc is not null");
            return (Criteria) this;
        }

        public Criteria andTodayRealityPrcEqualTo(BigDecimal value) {
            addCriterion("today_reality_prc =", value, "todayRealityPrc");
            return (Criteria) this;
        }

        public Criteria andTodayRealityPrcNotEqualTo(BigDecimal value) {
            addCriterion("today_reality_prc <>", value, "todayRealityPrc");
            return (Criteria) this;
        }

        public Criteria andTodayRealityPrcGreaterThan(BigDecimal value) {
            addCriterion("today_reality_prc >", value, "todayRealityPrc");
            return (Criteria) this;
        }

        public Criteria andTodayRealityPrcGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("today_reality_prc >=", value, "todayRealityPrc");
            return (Criteria) this;
        }

        public Criteria andTodayRealityPrcLessThan(BigDecimal value) {
            addCriterion("today_reality_prc <", value, "todayRealityPrc");
            return (Criteria) this;
        }

        public Criteria andTodayRealityPrcLessThanOrEqualTo(BigDecimal value) {
            addCriterion("today_reality_prc <=", value, "todayRealityPrc");
            return (Criteria) this;
        }

        public Criteria andTodayRealityPrcIn(List<BigDecimal> values) {
            addCriterion("today_reality_prc in", values, "todayRealityPrc");
            return (Criteria) this;
        }

        public Criteria andTodayRealityPrcNotIn(List<BigDecimal> values) {
            addCriterion("today_reality_prc not in", values, "todayRealityPrc");
            return (Criteria) this;
        }

        public Criteria andTodayRealityPrcBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("today_reality_prc between", value1, value2, "todayRealityPrc");
            return (Criteria) this;
        }

        public Criteria andTodayRealityPrcNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("today_reality_prc not between", value1, value2, "todayRealityPrc");
            return (Criteria) this;
        }

        public Criteria andDeductionNumberIsNull() {
            addCriterion("deduction_number is null");
            return (Criteria) this;
        }

        public Criteria andDeductionNumberIsNotNull() {
            addCriterion("deduction_number is not null");
            return (Criteria) this;
        }

        public Criteria andDeductionNumberEqualTo(Long value) {
            addCriterion("deduction_number =", value, "deductionNumber");
            return (Criteria) this;
        }

        public Criteria andDeductionNumberNotEqualTo(Long value) {
            addCriterion("deduction_number <>", value, "deductionNumber");
            return (Criteria) this;
        }

        public Criteria andDeductionNumberGreaterThan(Long value) {
            addCriterion("deduction_number >", value, "deductionNumber");
            return (Criteria) this;
        }

        public Criteria andDeductionNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("deduction_number >=", value, "deductionNumber");
            return (Criteria) this;
        }

        public Criteria andDeductionNumberLessThan(Long value) {
            addCriterion("deduction_number <", value, "deductionNumber");
            return (Criteria) this;
        }

        public Criteria andDeductionNumberLessThanOrEqualTo(Long value) {
            addCriterion("deduction_number <=", value, "deductionNumber");
            return (Criteria) this;
        }

        public Criteria andDeductionNumberIn(List<Long> values) {
            addCriterion("deduction_number in", values, "deductionNumber");
            return (Criteria) this;
        }

        public Criteria andDeductionNumberNotIn(List<Long> values) {
            addCriterion("deduction_number not in", values, "deductionNumber");
            return (Criteria) this;
        }

        public Criteria andDeductionNumberBetween(Long value1, Long value2) {
            addCriterion("deduction_number between", value1, value2, "deductionNumber");
            return (Criteria) this;
        }

        public Criteria andDeductionNumberNotBetween(Long value1, Long value2) {
            addCriterion("deduction_number not between", value1, value2, "deductionNumber");
            return (Criteria) this;
        }

        public Criteria andSuccessDeductionNumberIsNull() {
            addCriterion("success_deduction_number is null");
            return (Criteria) this;
        }

        public Criteria andSuccessDeductionNumberIsNotNull() {
            addCriterion("success_deduction_number is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessDeductionNumberEqualTo(Long value) {
            addCriterion("success_deduction_number =", value, "successDeductionNumber");
            return (Criteria) this;
        }

        public Criteria andSuccessDeductionNumberNotEqualTo(Long value) {
            addCriterion("success_deduction_number <>", value, "successDeductionNumber");
            return (Criteria) this;
        }

        public Criteria andSuccessDeductionNumberGreaterThan(Long value) {
            addCriterion("success_deduction_number >", value, "successDeductionNumber");
            return (Criteria) this;
        }

        public Criteria andSuccessDeductionNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("success_deduction_number >=", value, "successDeductionNumber");
            return (Criteria) this;
        }

        public Criteria andSuccessDeductionNumberLessThan(Long value) {
            addCriterion("success_deduction_number <", value, "successDeductionNumber");
            return (Criteria) this;
        }

        public Criteria andSuccessDeductionNumberLessThanOrEqualTo(Long value) {
            addCriterion("success_deduction_number <=", value, "successDeductionNumber");
            return (Criteria) this;
        }

        public Criteria andSuccessDeductionNumberIn(List<Long> values) {
            addCriterion("success_deduction_number in", values, "successDeductionNumber");
            return (Criteria) this;
        }

        public Criteria andSuccessDeductionNumberNotIn(List<Long> values) {
            addCriterion("success_deduction_number not in", values, "successDeductionNumber");
            return (Criteria) this;
        }

        public Criteria andSuccessDeductionNumberBetween(Long value1, Long value2) {
            addCriterion("success_deduction_number between", value1, value2, "successDeductionNumber");
            return (Criteria) this;
        }

        public Criteria andSuccessDeductionNumberNotBetween(Long value1, Long value2) {
            addCriterion("success_deduction_number not between", value1, value2, "successDeductionNumber");
            return (Criteria) this;
        }

        public Criteria andDcAmountIsNull() {
            addCriterion("dc_amount is null");
            return (Criteria) this;
        }

        public Criteria andDcAmountIsNotNull() {
            addCriterion("dc_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDcAmountEqualTo(BigDecimal value) {
            addCriterion("dc_amount =", value, "dcAmount");
            return (Criteria) this;
        }

        public Criteria andDcAmountNotEqualTo(BigDecimal value) {
            addCriterion("dc_amount <>", value, "dcAmount");
            return (Criteria) this;
        }

        public Criteria andDcAmountGreaterThan(BigDecimal value) {
            addCriterion("dc_amount >", value, "dcAmount");
            return (Criteria) this;
        }

        public Criteria andDcAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dc_amount >=", value, "dcAmount");
            return (Criteria) this;
        }

        public Criteria andDcAmountLessThan(BigDecimal value) {
            addCriterion("dc_amount <", value, "dcAmount");
            return (Criteria) this;
        }

        public Criteria andDcAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dc_amount <=", value, "dcAmount");
            return (Criteria) this;
        }

        public Criteria andDcAmountIn(List<BigDecimal> values) {
            addCriterion("dc_amount in", values, "dcAmount");
            return (Criteria) this;
        }

        public Criteria andDcAmountNotIn(List<BigDecimal> values) {
            addCriterion("dc_amount not in", values, "dcAmount");
            return (Criteria) this;
        }

        public Criteria andDcAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dc_amount between", value1, value2, "dcAmount");
            return (Criteria) this;
        }

        public Criteria andDcAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dc_amount not between", value1, value2, "dcAmount");
            return (Criteria) this;
        }

        public Criteria andDcAmountPrcIsNull() {
            addCriterion("dc_amount_prc is null");
            return (Criteria) this;
        }

        public Criteria andDcAmountPrcIsNotNull() {
            addCriterion("dc_amount_prc is not null");
            return (Criteria) this;
        }

        public Criteria andDcAmountPrcEqualTo(BigDecimal value) {
            addCriterion("dc_amount_prc =", value, "dcAmountPrc");
            return (Criteria) this;
        }

        public Criteria andDcAmountPrcNotEqualTo(BigDecimal value) {
            addCriterion("dc_amount_prc <>", value, "dcAmountPrc");
            return (Criteria) this;
        }

        public Criteria andDcAmountPrcGreaterThan(BigDecimal value) {
            addCriterion("dc_amount_prc >", value, "dcAmountPrc");
            return (Criteria) this;
        }

        public Criteria andDcAmountPrcGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dc_amount_prc >=", value, "dcAmountPrc");
            return (Criteria) this;
        }

        public Criteria andDcAmountPrcLessThan(BigDecimal value) {
            addCriterion("dc_amount_prc <", value, "dcAmountPrc");
            return (Criteria) this;
        }

        public Criteria andDcAmountPrcLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dc_amount_prc <=", value, "dcAmountPrc");
            return (Criteria) this;
        }

        public Criteria andDcAmountPrcIn(List<BigDecimal> values) {
            addCriterion("dc_amount_prc in", values, "dcAmountPrc");
            return (Criteria) this;
        }

        public Criteria andDcAmountPrcNotIn(List<BigDecimal> values) {
            addCriterion("dc_amount_prc not in", values, "dcAmountPrc");
            return (Criteria) this;
        }

        public Criteria andDcAmountPrcBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dc_amount_prc between", value1, value2, "dcAmountPrc");
            return (Criteria) this;
        }

        public Criteria andDcAmountPrcNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dc_amount_prc not between", value1, value2, "dcAmountPrc");
            return (Criteria) this;
        }

        public Criteria andDcReceivedAmoutnIsNull() {
            addCriterion("dc_received_amoutn is null");
            return (Criteria) this;
        }

        public Criteria andDcReceivedAmoutnIsNotNull() {
            addCriterion("dc_received_amoutn is not null");
            return (Criteria) this;
        }

        public Criteria andDcReceivedAmoutnEqualTo(BigDecimal value) {
            addCriterion("dc_received_amoutn =", value, "dcReceivedAmoutn");
            return (Criteria) this;
        }

        public Criteria andDcReceivedAmoutnNotEqualTo(BigDecimal value) {
            addCriterion("dc_received_amoutn <>", value, "dcReceivedAmoutn");
            return (Criteria) this;
        }

        public Criteria andDcReceivedAmoutnGreaterThan(BigDecimal value) {
            addCriterion("dc_received_amoutn >", value, "dcReceivedAmoutn");
            return (Criteria) this;
        }

        public Criteria andDcReceivedAmoutnGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dc_received_amoutn >=", value, "dcReceivedAmoutn");
            return (Criteria) this;
        }

        public Criteria andDcReceivedAmoutnLessThan(BigDecimal value) {
            addCriterion("dc_received_amoutn <", value, "dcReceivedAmoutn");
            return (Criteria) this;
        }

        public Criteria andDcReceivedAmoutnLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dc_received_amoutn <=", value, "dcReceivedAmoutn");
            return (Criteria) this;
        }

        public Criteria andDcReceivedAmoutnIn(List<BigDecimal> values) {
            addCriterion("dc_received_amoutn in", values, "dcReceivedAmoutn");
            return (Criteria) this;
        }

        public Criteria andDcReceivedAmoutnNotIn(List<BigDecimal> values) {
            addCriterion("dc_received_amoutn not in", values, "dcReceivedAmoutn");
            return (Criteria) this;
        }

        public Criteria andDcReceivedAmoutnBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dc_received_amoutn between", value1, value2, "dcReceivedAmoutn");
            return (Criteria) this;
        }

        public Criteria andDcReceivedAmoutnNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dc_received_amoutn not between", value1, value2, "dcReceivedAmoutn");
            return (Criteria) this;
        }

        public Criteria andDcReceivedAmoutnPrcIsNull() {
            addCriterion("dc_received_amoutn_prc is null");
            return (Criteria) this;
        }

        public Criteria andDcReceivedAmoutnPrcIsNotNull() {
            addCriterion("dc_received_amoutn_prc is not null");
            return (Criteria) this;
        }

        public Criteria andDcReceivedAmoutnPrcEqualTo(BigDecimal value) {
            addCriterion("dc_received_amoutn_prc =", value, "dcReceivedAmoutnPrc");
            return (Criteria) this;
        }

        public Criteria andDcReceivedAmoutnPrcNotEqualTo(BigDecimal value) {
            addCriterion("dc_received_amoutn_prc <>", value, "dcReceivedAmoutnPrc");
            return (Criteria) this;
        }

        public Criteria andDcReceivedAmoutnPrcGreaterThan(BigDecimal value) {
            addCriterion("dc_received_amoutn_prc >", value, "dcReceivedAmoutnPrc");
            return (Criteria) this;
        }

        public Criteria andDcReceivedAmoutnPrcGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dc_received_amoutn_prc >=", value, "dcReceivedAmoutnPrc");
            return (Criteria) this;
        }

        public Criteria andDcReceivedAmoutnPrcLessThan(BigDecimal value) {
            addCriterion("dc_received_amoutn_prc <", value, "dcReceivedAmoutnPrc");
            return (Criteria) this;
        }

        public Criteria andDcReceivedAmoutnPrcLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dc_received_amoutn_prc <=", value, "dcReceivedAmoutnPrc");
            return (Criteria) this;
        }

        public Criteria andDcReceivedAmoutnPrcIn(List<BigDecimal> values) {
            addCriterion("dc_received_amoutn_prc in", values, "dcReceivedAmoutnPrc");
            return (Criteria) this;
        }

        public Criteria andDcReceivedAmoutnPrcNotIn(List<BigDecimal> values) {
            addCriterion("dc_received_amoutn_prc not in", values, "dcReceivedAmoutnPrc");
            return (Criteria) this;
        }

        public Criteria andDcReceivedAmoutnPrcBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dc_received_amoutn_prc between", value1, value2, "dcReceivedAmoutnPrc");
            return (Criteria) this;
        }

        public Criteria andDcReceivedAmoutnPrcNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dc_received_amoutn_prc not between", value1, value2, "dcReceivedAmoutnPrc");
            return (Criteria) this;
        }

        public Criteria andAmountOfFundsIsNull() {
            addCriterion("amount_of_funds is null");
            return (Criteria) this;
        }

        public Criteria andAmountOfFundsIsNotNull() {
            addCriterion("amount_of_funds is not null");
            return (Criteria) this;
        }

        public Criteria andAmountOfFundsEqualTo(BigDecimal value) {
            addCriterion("amount_of_funds =", value, "amountOfFunds");
            return (Criteria) this;
        }

        public Criteria andAmountOfFundsNotEqualTo(BigDecimal value) {
            addCriterion("amount_of_funds <>", value, "amountOfFunds");
            return (Criteria) this;
        }

        public Criteria andAmountOfFundsGreaterThan(BigDecimal value) {
            addCriterion("amount_of_funds >", value, "amountOfFunds");
            return (Criteria) this;
        }

        public Criteria andAmountOfFundsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_of_funds >=", value, "amountOfFunds");
            return (Criteria) this;
        }

        public Criteria andAmountOfFundsLessThan(BigDecimal value) {
            addCriterion("amount_of_funds <", value, "amountOfFunds");
            return (Criteria) this;
        }

        public Criteria andAmountOfFundsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_of_funds <=", value, "amountOfFunds");
            return (Criteria) this;
        }

        public Criteria andAmountOfFundsIn(List<BigDecimal> values) {
            addCriterion("amount_of_funds in", values, "amountOfFunds");
            return (Criteria) this;
        }

        public Criteria andAmountOfFundsNotIn(List<BigDecimal> values) {
            addCriterion("amount_of_funds not in", values, "amountOfFunds");
            return (Criteria) this;
        }

        public Criteria andAmountOfFundsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_of_funds between", value1, value2, "amountOfFunds");
            return (Criteria) this;
        }

        public Criteria andAmountOfFundsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_of_funds not between", value1, value2, "amountOfFunds");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
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
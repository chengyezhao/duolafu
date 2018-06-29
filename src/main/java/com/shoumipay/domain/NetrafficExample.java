package com.shoumipay.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NetrafficExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NetrafficExample() {
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

        public Criteria andRegisterNumberIsNull() {
            addCriterion("register_number is null");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberIsNotNull() {
            addCriterion("register_number is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberEqualTo(Long value) {
            addCriterion("register_number =", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberNotEqualTo(Long value) {
            addCriterion("register_number <>", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberGreaterThan(Long value) {
            addCriterion("register_number >", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("register_number >=", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberLessThan(Long value) {
            addCriterion("register_number <", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberLessThanOrEqualTo(Long value) {
            addCriterion("register_number <=", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberIn(List<Long> values) {
            addCriterion("register_number in", values, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberNotIn(List<Long> values) {
            addCriterion("register_number not in", values, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberBetween(Long value1, Long value2) {
            addCriterion("register_number between", value1, value2, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberNotBetween(Long value1, Long value2) {
            addCriterion("register_number not between", value1, value2, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andApplyForNumberIsNull() {
            addCriterion("apply_for_number is null");
            return (Criteria) this;
        }

        public Criteria andApplyForNumberIsNotNull() {
            addCriterion("apply_for_number is not null");
            return (Criteria) this;
        }

        public Criteria andApplyForNumberEqualTo(Long value) {
            addCriterion("apply_for_number =", value, "applyForNumber");
            return (Criteria) this;
        }

        public Criteria andApplyForNumberNotEqualTo(Long value) {
            addCriterion("apply_for_number <>", value, "applyForNumber");
            return (Criteria) this;
        }

        public Criteria andApplyForNumberGreaterThan(Long value) {
            addCriterion("apply_for_number >", value, "applyForNumber");
            return (Criteria) this;
        }

        public Criteria andApplyForNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("apply_for_number >=", value, "applyForNumber");
            return (Criteria) this;
        }

        public Criteria andApplyForNumberLessThan(Long value) {
            addCriterion("apply_for_number <", value, "applyForNumber");
            return (Criteria) this;
        }

        public Criteria andApplyForNumberLessThanOrEqualTo(Long value) {
            addCriterion("apply_for_number <=", value, "applyForNumber");
            return (Criteria) this;
        }

        public Criteria andApplyForNumberIn(List<Long> values) {
            addCriterion("apply_for_number in", values, "applyForNumber");
            return (Criteria) this;
        }

        public Criteria andApplyForNumberNotIn(List<Long> values) {
            addCriterion("apply_for_number not in", values, "applyForNumber");
            return (Criteria) this;
        }

        public Criteria andApplyForNumberBetween(Long value1, Long value2) {
            addCriterion("apply_for_number between", value1, value2, "applyForNumber");
            return (Criteria) this;
        }

        public Criteria andApplyForNumberNotBetween(Long value1, Long value2) {
            addCriterion("apply_for_number not between", value1, value2, "applyForNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitNumberIsNull() {
            addCriterion("submit_number is null");
            return (Criteria) this;
        }

        public Criteria andSubmitNumberIsNotNull() {
            addCriterion("submit_number is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitNumberEqualTo(Long value) {
            addCriterion("submit_number =", value, "submitNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitNumberNotEqualTo(Long value) {
            addCriterion("submit_number <>", value, "submitNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitNumberGreaterThan(Long value) {
            addCriterion("submit_number >", value, "submitNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("submit_number >=", value, "submitNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitNumberLessThan(Long value) {
            addCriterion("submit_number <", value, "submitNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitNumberLessThanOrEqualTo(Long value) {
            addCriterion("submit_number <=", value, "submitNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitNumberIn(List<Long> values) {
            addCriterion("submit_number in", values, "submitNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitNumberNotIn(List<Long> values) {
            addCriterion("submit_number not in", values, "submitNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitNumberBetween(Long value1, Long value2) {
            addCriterion("submit_number between", value1, value2, "submitNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitNumberNotBetween(Long value1, Long value2) {
            addCriterion("submit_number not between", value1, value2, "submitNumber");
            return (Criteria) this;
        }

        public Criteria andPassNumberIsNull() {
            addCriterion("pass_number is null");
            return (Criteria) this;
        }

        public Criteria andPassNumberIsNotNull() {
            addCriterion("pass_number is not null");
            return (Criteria) this;
        }

        public Criteria andPassNumberEqualTo(Long value) {
            addCriterion("pass_number =", value, "passNumber");
            return (Criteria) this;
        }

        public Criteria andPassNumberNotEqualTo(Long value) {
            addCriterion("pass_number <>", value, "passNumber");
            return (Criteria) this;
        }

        public Criteria andPassNumberGreaterThan(Long value) {
            addCriterion("pass_number >", value, "passNumber");
            return (Criteria) this;
        }

        public Criteria andPassNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("pass_number >=", value, "passNumber");
            return (Criteria) this;
        }

        public Criteria andPassNumberLessThan(Long value) {
            addCriterion("pass_number <", value, "passNumber");
            return (Criteria) this;
        }

        public Criteria andPassNumberLessThanOrEqualTo(Long value) {
            addCriterion("pass_number <=", value, "passNumber");
            return (Criteria) this;
        }

        public Criteria andPassNumberIn(List<Long> values) {
            addCriterion("pass_number in", values, "passNumber");
            return (Criteria) this;
        }

        public Criteria andPassNumberNotIn(List<Long> values) {
            addCriterion("pass_number not in", values, "passNumber");
            return (Criteria) this;
        }

        public Criteria andPassNumberBetween(Long value1, Long value2) {
            addCriterion("pass_number between", value1, value2, "passNumber");
            return (Criteria) this;
        }

        public Criteria andPassNumberNotBetween(Long value1, Long value2) {
            addCriterion("pass_number not between", value1, value2, "passNumber");
            return (Criteria) this;
        }

        public Criteria andPassAmountIsNull() {
            addCriterion("pass_amount is null");
            return (Criteria) this;
        }

        public Criteria andPassAmountIsNotNull() {
            addCriterion("pass_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPassAmountEqualTo(BigDecimal value) {
            addCriterion("pass_amount =", value, "passAmount");
            return (Criteria) this;
        }

        public Criteria andPassAmountNotEqualTo(BigDecimal value) {
            addCriterion("pass_amount <>", value, "passAmount");
            return (Criteria) this;
        }

        public Criteria andPassAmountGreaterThan(BigDecimal value) {
            addCriterion("pass_amount >", value, "passAmount");
            return (Criteria) this;
        }

        public Criteria andPassAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pass_amount >=", value, "passAmount");
            return (Criteria) this;
        }

        public Criteria andPassAmountLessThan(BigDecimal value) {
            addCriterion("pass_amount <", value, "passAmount");
            return (Criteria) this;
        }

        public Criteria andPassAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pass_amount <=", value, "passAmount");
            return (Criteria) this;
        }

        public Criteria andPassAmountIn(List<BigDecimal> values) {
            addCriterion("pass_amount in", values, "passAmount");
            return (Criteria) this;
        }

        public Criteria andPassAmountNotIn(List<BigDecimal> values) {
            addCriterion("pass_amount not in", values, "passAmount");
            return (Criteria) this;
        }

        public Criteria andPassAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pass_amount between", value1, value2, "passAmount");
            return (Criteria) this;
        }

        public Criteria andPassAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pass_amount not between", value1, value2, "passAmount");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountNumberIsNull() {
            addCriterion("submit_amount_number is null");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountNumberIsNotNull() {
            addCriterion("submit_amount_number is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountNumberEqualTo(Long value) {
            addCriterion("submit_amount_number =", value, "submitAmountNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountNumberNotEqualTo(Long value) {
            addCriterion("submit_amount_number <>", value, "submitAmountNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountNumberGreaterThan(Long value) {
            addCriterion("submit_amount_number >", value, "submitAmountNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("submit_amount_number >=", value, "submitAmountNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountNumberLessThan(Long value) {
            addCriterion("submit_amount_number <", value, "submitAmountNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountNumberLessThanOrEqualTo(Long value) {
            addCriterion("submit_amount_number <=", value, "submitAmountNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountNumberIn(List<Long> values) {
            addCriterion("submit_amount_number in", values, "submitAmountNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountNumberNotIn(List<Long> values) {
            addCriterion("submit_amount_number not in", values, "submitAmountNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountNumberBetween(Long value1, Long value2) {
            addCriterion("submit_amount_number between", value1, value2, "submitAmountNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountNumberNotBetween(Long value1, Long value2) {
            addCriterion("submit_amount_number not between", value1, value2, "submitAmountNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountIsNull() {
            addCriterion("submit_amount is null");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountIsNotNull() {
            addCriterion("submit_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountEqualTo(BigDecimal value) {
            addCriterion("submit_amount =", value, "submitAmount");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountNotEqualTo(BigDecimal value) {
            addCriterion("submit_amount <>", value, "submitAmount");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountGreaterThan(BigDecimal value) {
            addCriterion("submit_amount >", value, "submitAmount");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("submit_amount >=", value, "submitAmount");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountLessThan(BigDecimal value) {
            addCriterion("submit_amount <", value, "submitAmount");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("submit_amount <=", value, "submitAmount");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountIn(List<BigDecimal> values) {
            addCriterion("submit_amount in", values, "submitAmount");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountNotIn(List<BigDecimal> values) {
            addCriterion("submit_amount not in", values, "submitAmount");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("submit_amount between", value1, value2, "submitAmount");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("submit_amount not between", value1, value2, "submitAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountNumberIsNull() {
            addCriterion("success_amount_number is null");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountNumberIsNotNull() {
            addCriterion("success_amount_number is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountNumberEqualTo(Long value) {
            addCriterion("success_amount_number =", value, "successAmountNumber");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountNumberNotEqualTo(Long value) {
            addCriterion("success_amount_number <>", value, "successAmountNumber");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountNumberGreaterThan(Long value) {
            addCriterion("success_amount_number >", value, "successAmountNumber");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("success_amount_number >=", value, "successAmountNumber");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountNumberLessThan(Long value) {
            addCriterion("success_amount_number <", value, "successAmountNumber");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountNumberLessThanOrEqualTo(Long value) {
            addCriterion("success_amount_number <=", value, "successAmountNumber");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountNumberIn(List<Long> values) {
            addCriterion("success_amount_number in", values, "successAmountNumber");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountNumberNotIn(List<Long> values) {
            addCriterion("success_amount_number not in", values, "successAmountNumber");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountNumberBetween(Long value1, Long value2) {
            addCriterion("success_amount_number between", value1, value2, "successAmountNumber");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountNumberNotBetween(Long value1, Long value2) {
            addCriterion("success_amount_number not between", value1, value2, "successAmountNumber");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountIsNull() {
            addCriterion("success_amount is null");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountIsNotNull() {
            addCriterion("success_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountEqualTo(BigDecimal value) {
            addCriterion("success_amount =", value, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountNotEqualTo(BigDecimal value) {
            addCriterion("success_amount <>", value, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountGreaterThan(BigDecimal value) {
            addCriterion("success_amount >", value, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("success_amount >=", value, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountLessThan(BigDecimal value) {
            addCriterion("success_amount <", value, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("success_amount <=", value, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountIn(List<BigDecimal> values) {
            addCriterion("success_amount in", values, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountNotIn(List<BigDecimal> values) {
            addCriterion("success_amount not in", values, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("success_amount between", value1, value2, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("success_amount not between", value1, value2, "successAmount");
            return (Criteria) this;
        }

        public Criteria andPassRateIsNull() {
            addCriterion("pass_rate is null");
            return (Criteria) this;
        }

        public Criteria andPassRateIsNotNull() {
            addCriterion("pass_rate is not null");
            return (Criteria) this;
        }

        public Criteria andPassRateEqualTo(BigDecimal value) {
            addCriterion("pass_rate =", value, "passRate");
            return (Criteria) this;
        }

        public Criteria andPassRateNotEqualTo(BigDecimal value) {
            addCriterion("pass_rate <>", value, "passRate");
            return (Criteria) this;
        }

        public Criteria andPassRateGreaterThan(BigDecimal value) {
            addCriterion("pass_rate >", value, "passRate");
            return (Criteria) this;
        }

        public Criteria andPassRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pass_rate >=", value, "passRate");
            return (Criteria) this;
        }

        public Criteria andPassRateLessThan(BigDecimal value) {
            addCriterion("pass_rate <", value, "passRate");
            return (Criteria) this;
        }

        public Criteria andPassRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pass_rate <=", value, "passRate");
            return (Criteria) this;
        }

        public Criteria andPassRateIn(List<BigDecimal> values) {
            addCriterion("pass_rate in", values, "passRate");
            return (Criteria) this;
        }

        public Criteria andPassRateNotIn(List<BigDecimal> values) {
            addCriterion("pass_rate not in", values, "passRate");
            return (Criteria) this;
        }

        public Criteria andPassRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pass_rate between", value1, value2, "passRate");
            return (Criteria) this;
        }

        public Criteria andPassRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pass_rate not between", value1, value2, "passRate");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountRateIsNull() {
            addCriterion("submit_amount_rate is null");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountRateIsNotNull() {
            addCriterion("submit_amount_rate is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountRateEqualTo(BigDecimal value) {
            addCriterion("submit_amount_rate =", value, "submitAmountRate");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountRateNotEqualTo(BigDecimal value) {
            addCriterion("submit_amount_rate <>", value, "submitAmountRate");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountRateGreaterThan(BigDecimal value) {
            addCriterion("submit_amount_rate >", value, "submitAmountRate");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("submit_amount_rate >=", value, "submitAmountRate");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountRateLessThan(BigDecimal value) {
            addCriterion("submit_amount_rate <", value, "submitAmountRate");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("submit_amount_rate <=", value, "submitAmountRate");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountRateIn(List<BigDecimal> values) {
            addCriterion("submit_amount_rate in", values, "submitAmountRate");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountRateNotIn(List<BigDecimal> values) {
            addCriterion("submit_amount_rate not in", values, "submitAmountRate");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("submit_amount_rate between", value1, value2, "submitAmountRate");
            return (Criteria) this;
        }

        public Criteria andSubmitAmountRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("submit_amount_rate not between", value1, value2, "submitAmountRate");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountRateIsNull() {
            addCriterion("success_amount_rate is null");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountRateIsNotNull() {
            addCriterion("success_amount_rate is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountRateEqualTo(BigDecimal value) {
            addCriterion("success_amount_rate =", value, "successAmountRate");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountRateNotEqualTo(BigDecimal value) {
            addCriterion("success_amount_rate <>", value, "successAmountRate");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountRateGreaterThan(BigDecimal value) {
            addCriterion("success_amount_rate >", value, "successAmountRate");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("success_amount_rate >=", value, "successAmountRate");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountRateLessThan(BigDecimal value) {
            addCriterion("success_amount_rate <", value, "successAmountRate");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("success_amount_rate <=", value, "successAmountRate");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountRateIn(List<BigDecimal> values) {
            addCriterion("success_amount_rate in", values, "successAmountRate");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountRateNotIn(List<BigDecimal> values) {
            addCriterion("success_amount_rate not in", values, "successAmountRate");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("success_amount_rate between", value1, value2, "successAmountRate");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("success_amount_rate not between", value1, value2, "successAmountRate");
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
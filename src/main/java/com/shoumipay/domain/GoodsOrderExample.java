package com.shoumipay.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsOrderExample() {
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

        public Criteria andOrderNumberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(String value) {
            addCriterion("order_number =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(String value) {
            addCriterion("order_number <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(String value) {
            addCriterion("order_number >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("order_number >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(String value) {
            addCriterion("order_number <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("order_number <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLike(String value) {
            addCriterion("order_number like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotLike(String value) {
            addCriterion("order_number not like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<String> values) {
            addCriterion("order_number in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<String> values) {
            addCriterion("order_number not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(String value1, String value2) {
            addCriterion("order_number between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(String value1, String value2) {
            addCriterion("order_number not between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNull() {
            addCriterion("member_Id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_Id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(Long value) {
            addCriterion("member_Id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Long value) {
            addCriterion("member_Id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Long value) {
            addCriterion("member_Id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Long value) {
            addCriterion("member_Id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Long value) {
            addCriterion("member_Id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Long value) {
            addCriterion("member_Id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<Long> values) {
            addCriterion("member_Id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<Long> values) {
            addCriterion("member_Id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(Long value1, Long value2) {
            addCriterion("member_Id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(Long value1, Long value2) {
            addCriterion("member_Id not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeIsNull() {
            addCriterion("order_create_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeIsNotNull() {
            addCriterion("order_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeEqualTo(Date value) {
            addCriterion("order_create_time =", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeNotEqualTo(Date value) {
            addCriterion("order_create_time <>", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeGreaterThan(Date value) {
            addCriterion("order_create_time >", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_create_time >=", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeLessThan(Date value) {
            addCriterion("order_create_time <", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_create_time <=", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeIn(List<Date> values) {
            addCriterion("order_create_time in", values, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeNotIn(List<Date> values) {
            addCriterion("order_create_time not in", values, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeBetween(Date value1, Date value2) {
            addCriterion("order_create_time between", value1, value2, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_create_time not between", value1, value2, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_Id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_Id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Long value) {
            addCriterion("goods_Id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            addCriterion("goods_Id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            addCriterion("goods_Id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_Id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Long value) {
            addCriterion("goods_Id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_Id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Long> values) {
            addCriterion("goods_Id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Long> values) {
            addCriterion("goods_Id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            addCriterion("goods_Id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_Id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

 public Criteria andDaifuIdIsNull() {
            addCriterion("daifu_id is null");
            return (Criteria) this;
        }

        public Criteria andDaifuIdIsNotNull() {
            addCriterion("daifu_id is not null");
            return (Criteria) this;
        }

        public Criteria andDaifuIdEqualTo(Long value) {
            addCriterion("daifu_id =", value, "daifuId");
            return (Criteria) this;
        }

        public Criteria andDaifuIdNotEqualTo(Long value) {
            addCriterion("daifu_id <>", value, "daifuId");
            return (Criteria) this;
        }

        public Criteria andDaifuIdGreaterThan(Long value) {
            addCriterion("daifu_id >", value, "daifuId");
            return (Criteria) this;
        }

        public Criteria andDaifuIdGreaterThanOrEqualTo(Long value) {
            addCriterion("daifu_id >=", value, "daifuId");
            return (Criteria) this;
        }

        public Criteria andDaifuIdLessThan(Long value) {
            addCriterion("daifu_id <", value, "daifuId");
            return (Criteria) this;
        }

        public Criteria andDaifuIdLessThanOrEqualTo(Long value) {
            addCriterion("daifu_id <=", value, "daifuId");
            return (Criteria) this;
        }

        public Criteria andDaifuIdIn(List<Long> values) {
            addCriterion("daifu_id in", values, "daifuId");
            return (Criteria) this;
        }

        public Criteria andDaifuIdNotIn(List<Long> values) {
            addCriterion("daifu_id not in", values, "daifuId");
            return (Criteria) this;
        }

        public Criteria andDaifuIdBetween(Long value1, Long value2) {
            addCriterion("daifu_id between", value1, value2, "daifuId");
            return (Criteria) this;
        }

        public Criteria andDaifuIdNotBetween(Long value1, Long value2) {
            addCriterion("daifu_id not between", value1, value2, "daifuId");
            return (Criteria) this;
        }
        public Criteria andOrderCodeIsNull() {
            addCriterion("order_code is null");
            return (Criteria) this;
        }

        public Criteria andOrderCodeIsNotNull() {
            addCriterion("order_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCodeEqualTo(String value) {
            addCriterion("order_code =", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotEqualTo(String value) {
            addCriterion("order_code <>", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeGreaterThan(String value) {
            addCriterion("order_code >", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeGreaterThanOrEqualTo(String value) {
            addCriterion("order_code >=", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeLessThan(String value) {
            addCriterion("order_code <", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeLessThanOrEqualTo(String value) {
            addCriterion("order_code <=", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeLike(String value) {
            addCriterion("order_code like", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotLike(String value) {
            addCriterion("order_code not like", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeIn(List<String> values) {
            addCriterion("order_code in", values, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotIn(List<String> values) {
            addCriterion("order_code not in", values, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeBetween(String value1, String value2) {
            addCriterion("order_code between", value1, value2, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotBetween(String value1, String value2) {
            addCriterion("order_code not between", value1, value2, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNull() {
            addCriterion("order_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNotNull() {
            addCriterion("order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountEqualTo(BigDecimal value) {
            addCriterion("order_amount =", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotEqualTo(BigDecimal value) {
            addCriterion("order_amount <>", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThan(BigDecimal value) {
            addCriterion("order_amount >", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount >=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThan(BigDecimal value) {
            addCriterion("order_amount <", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount <=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIn(List<BigDecimal> values) {
            addCriterion("order_amount in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotIn(List<BigDecimal> values) {
            addCriterion("order_amount not in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount not between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(Integer value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(Integer value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(Integer value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(Integer value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<Integer> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<Integer> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(Integer value1, Integer value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderTypesIsNull() {
            addCriterion("order_types is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypesIsNotNull() {
            addCriterion("order_types is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypesEqualTo(Integer value) {
            addCriterion("order_types =", value, "orderTypes");
            return (Criteria) this;
        }

        public Criteria andOrderTypesNotEqualTo(Integer value) {
            addCriterion("order_types <>", value, "orderTypes");
            return (Criteria) this;
        }

        public Criteria andOrderTypesGreaterThan(Integer value) {
            addCriterion("order_types >", value, "orderTypes");
            return (Criteria) this;
        }

        public Criteria andOrderTypesGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_types >=", value, "orderTypes");
            return (Criteria) this;
        }

        public Criteria andOrderTypesLessThan(Integer value) {
            addCriterion("order_types <", value, "orderTypes");
            return (Criteria) this;
        }

        public Criteria andOrderTypesLessThanOrEqualTo(Integer value) {
            addCriterion("order_types <=", value, "orderTypes");
            return (Criteria) this;
        }

        public Criteria andOrderTypesIn(List<Integer> values) {
            addCriterion("order_types in", values, "orderTypes");
            return (Criteria) this;
        }

        public Criteria andOrderTypesNotIn(List<Integer> values) {
            addCriterion("order_types not in", values, "orderTypes");
            return (Criteria) this;
        }

        public Criteria andOrderTypesBetween(Integer value1, Integer value2) {
            addCriterion("order_types between", value1, value2, "orderTypes");
            return (Criteria) this;
        }

        public Criteria andOrderTypesNotBetween(Integer value1, Integer value2) {
            addCriterion("order_types not between", value1, value2, "orderTypes");
            return (Criteria) this;
        }

        public Criteria andOrderAuditorIsNull() {
            addCriterion("order_auditor is null");
            return (Criteria) this;
        }

        public Criteria andOrderAuditorIsNotNull() {
            addCriterion("order_auditor is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAuditorEqualTo(String value) {
            addCriterion("order_auditor =", value, "orderAuditor");
            return (Criteria) this;
        }

        public Criteria andOrderAuditorNotEqualTo(String value) {
            addCriterion("order_auditor <>", value, "orderAuditor");
            return (Criteria) this;
        }

        public Criteria andOrderAuditorGreaterThan(String value) {
            addCriterion("order_auditor >", value, "orderAuditor");
            return (Criteria) this;
        }

        public Criteria andOrderAuditorGreaterThanOrEqualTo(String value) {
            addCriterion("order_auditor >=", value, "orderAuditor");
            return (Criteria) this;
        }

        public Criteria andOrderAuditorLessThan(String value) {
            addCriterion("order_auditor <", value, "orderAuditor");
            return (Criteria) this;
        }

        public Criteria andOrderAuditorLessThanOrEqualTo(String value) {
            addCriterion("order_auditor <=", value, "orderAuditor");
            return (Criteria) this;
        }

        public Criteria andOrderAuditorLike(String value) {
            addCriterion("order_auditor like", value, "orderAuditor");
            return (Criteria) this;
        }

        public Criteria andOrderAuditorNotLike(String value) {
            addCriterion("order_auditor not like", value, "orderAuditor");
            return (Criteria) this;
        }

        public Criteria andOrderAuditorIn(List<String> values) {
            addCriterion("order_auditor in", values, "orderAuditor");
            return (Criteria) this;
        }

        public Criteria andOrderAuditorNotIn(List<String> values) {
            addCriterion("order_auditor not in", values, "orderAuditor");
            return (Criteria) this;
        }

        public Criteria andOrderAuditorBetween(String value1, String value2) {
            addCriterion("order_auditor between", value1, value2, "orderAuditor");
            return (Criteria) this;
        }

        public Criteria andOrderAuditorNotBetween(String value1, String value2) {
            addCriterion("order_auditor not between", value1, value2, "orderAuditor");
            return (Criteria) this;
        }

        public Criteria andOrderUpptimeIsNull() {
            addCriterion("order_upptime is null");
            return (Criteria) this;
        }

        public Criteria andOrderUpptimeIsNotNull() {
            addCriterion("order_upptime is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUpptimeEqualTo(Date value) {
            addCriterion("order_upptime =", value, "orderUpptime");
            return (Criteria) this;
        }

        public Criteria andOrderUpptimeNotEqualTo(Date value) {
            addCriterion("order_upptime <>", value, "orderUpptime");
            return (Criteria) this;
        }

        public Criteria andOrderUpptimeGreaterThan(Date value) {
            addCriterion("order_upptime >", value, "orderUpptime");
            return (Criteria) this;
        }

        public Criteria andOrderUpptimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_upptime >=", value, "orderUpptime");
            return (Criteria) this;
        }

        public Criteria andOrderUpptimeLessThan(Date value) {
            addCriterion("order_upptime <", value, "orderUpptime");
            return (Criteria) this;
        }

        public Criteria andOrderUpptimeLessThanOrEqualTo(Date value) {
            addCriterion("order_upptime <=", value, "orderUpptime");
            return (Criteria) this;
        }

        public Criteria andOrderUpptimeIn(List<Date> values) {
            addCriterion("order_upptime in", values, "orderUpptime");
            return (Criteria) this;
        }

        public Criteria andOrderUpptimeNotIn(List<Date> values) {
            addCriterion("order_upptime not in", values, "orderUpptime");
            return (Criteria) this;
        }

        public Criteria andOrderUpptimeBetween(Date value1, Date value2) {
            addCriterion("order_upptime between", value1, value2, "orderUpptime");
            return (Criteria) this;
        }

        public Criteria andOrderUpptimeNotBetween(Date value1, Date value2) {
            addCriterion("order_upptime not between", value1, value2, "orderUpptime");
            return (Criteria) this;
        }

        public Criteria andOrderLevelIsNull() {
            addCriterion("order_level is null");
            return (Criteria) this;
        }

        public Criteria andOrderLevelIsNotNull() {
            addCriterion("order_level is not null");
            return (Criteria) this;
        }

        public Criteria andOrderLevelEqualTo(String value) {
            addCriterion("order_level =", value, "orderLevel");
            return (Criteria) this;
        }

        public Criteria andOrderLevelNotEqualTo(String value) {
            addCriterion("order_level <>", value, "orderLevel");
            return (Criteria) this;
        }

        public Criteria andOrderLevelGreaterThan(String value) {
            addCriterion("order_level >", value, "orderLevel");
            return (Criteria) this;
        }

        public Criteria andOrderLevelGreaterThanOrEqualTo(String value) {
            addCriterion("order_level >=", value, "orderLevel");
            return (Criteria) this;
        }

        public Criteria andOrderLevelLessThan(String value) {
            addCriterion("order_level <", value, "orderLevel");
            return (Criteria) this;
        }

        public Criteria andOrderLevelLessThanOrEqualTo(String value) {
            addCriterion("order_level <=", value, "orderLevel");
            return (Criteria) this;
        }

        public Criteria andOrderLevelLike(String value) {
            addCriterion("order_level like", value, "orderLevel");
            return (Criteria) this;
        }

        public Criteria andOrderLevelNotLike(String value) {
            addCriterion("order_level not like", value, "orderLevel");
            return (Criteria) this;
        }

        public Criteria andOrderLevelIn(List<String> values) {
            addCriterion("order_level in", values, "orderLevel");
            return (Criteria) this;
        }

        public Criteria andOrderLevelNotIn(List<String> values) {
            addCriterion("order_level not in", values, "orderLevel");
            return (Criteria) this;
        }

        public Criteria andOrderLevelBetween(String value1, String value2) {
            addCriterion("order_level between", value1, value2, "orderLevel");
            return (Criteria) this;
        }

        public Criteria andOrderLevelNotBetween(String value1, String value2) {
            addCriterion("order_level not between", value1, value2, "orderLevel");
            return (Criteria) this;
        }

        public Criteria andOrderVerifyAmountIsNull() {
            addCriterion("order_verify_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderVerifyAmountIsNotNull() {
            addCriterion("order_verify_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderVerifyAmountEqualTo(BigDecimal value) {
            addCriterion("order_verify_amount =", value, "orderVerifyAmount");
            return (Criteria) this;
        }

        public Criteria andOrderVerifyAmountNotEqualTo(BigDecimal value) {
            addCriterion("order_verify_amount <>", value, "orderVerifyAmount");
            return (Criteria) this;
        }

        public Criteria andOrderVerifyAmountGreaterThan(BigDecimal value) {
            addCriterion("order_verify_amount >", value, "orderVerifyAmount");
            return (Criteria) this;
        }

        public Criteria andOrderVerifyAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_verify_amount >=", value, "orderVerifyAmount");
            return (Criteria) this;
        }

        public Criteria andOrderVerifyAmountLessThan(BigDecimal value) {
            addCriterion("order_verify_amount <", value, "orderVerifyAmount");
            return (Criteria) this;
        }

        public Criteria andOrderVerifyAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_verify_amount <=", value, "orderVerifyAmount");
            return (Criteria) this;
        }

        public Criteria andOrderVerifyAmountIn(List<BigDecimal> values) {
            addCriterion("order_verify_amount in", values, "orderVerifyAmount");
            return (Criteria) this;
        }

        public Criteria andOrderVerifyAmountNotIn(List<BigDecimal> values) {
            addCriterion("order_verify_amount not in", values, "orderVerifyAmount");
            return (Criteria) this;
        }

        public Criteria andOrderVerifyAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_verify_amount between", value1, value2, "orderVerifyAmount");
            return (Criteria) this;
        }

        public Criteria andOrderVerifyAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_verify_amount not between", value1, value2, "orderVerifyAmount");
            return (Criteria) this;
        }

        public Criteria andOrderChannelIsNull() {
            addCriterion("order_channel is null");
            return (Criteria) this;
        }

        public Criteria andOrderChannelIsNotNull() {
            addCriterion("order_channel is not null");
            return (Criteria) this;
        }

        public Criteria andOrderChannelEqualTo(String value) {
            addCriterion("order_channel =", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelNotEqualTo(String value) {
            addCriterion("order_channel <>", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelGreaterThan(String value) {
            addCriterion("order_channel >", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelGreaterThanOrEqualTo(String value) {
            addCriterion("order_channel >=", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelLessThan(String value) {
            addCriterion("order_channel <", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelLessThanOrEqualTo(String value) {
            addCriterion("order_channel <=", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelLike(String value) {
            addCriterion("order_channel like", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelNotLike(String value) {
            addCriterion("order_channel not like", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelIn(List<String> values) {
            addCriterion("order_channel in", values, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelNotIn(List<String> values) {
            addCriterion("order_channel not in", values, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelBetween(String value1, String value2) {
            addCriterion("order_channel between", value1, value2, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelNotBetween(String value1, String value2) {
            addCriterion("order_channel not between", value1, value2, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountIsNull() {
            addCriterion("order_discount is null");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountIsNotNull() {
            addCriterion("order_discount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountEqualTo(Long value) {
            addCriterion("order_discount =", value, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountNotEqualTo(Long value) {
            addCriterion("order_discount <>", value, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountGreaterThan(Long value) {
            addCriterion("order_discount >", value, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountGreaterThanOrEqualTo(Long value) {
            addCriterion("order_discount >=", value, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountLessThan(Long value) {
            addCriterion("order_discount <", value, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountLessThanOrEqualTo(Long value) {
            addCriterion("order_discount <=", value, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountIn(List<Long> values) {
            addCriterion("order_discount in", values, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountNotIn(List<Long> values) {
            addCriterion("order_discount not in", values, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountBetween(Long value1, Long value2) {
            addCriterion("order_discount between", value1, value2, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountNotBetween(Long value1, Long value2) {
            addCriterion("order_discount not between", value1, value2, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderCardidIsNull() {
            addCriterion("order_cardId is null");
            return (Criteria) this;
        }

        public Criteria andOrderCardidIsNotNull() {
            addCriterion("order_cardId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCardidEqualTo(Long value) {
            addCriterion("order_cardId =", value, "orderCardid");
            return (Criteria) this;
        }

        public Criteria andOrderCardidNotEqualTo(Long value) {
            addCriterion("order_cardId <>", value, "orderCardid");
            return (Criteria) this;
        }

        public Criteria andOrderCardidGreaterThan(Long value) {
            addCriterion("order_cardId >", value, "orderCardid");
            return (Criteria) this;
        }

        public Criteria andOrderCardidGreaterThanOrEqualTo(Long value) {
            addCriterion("order_cardId >=", value, "orderCardid");
            return (Criteria) this;
        }

        public Criteria andOrderCardidLessThan(Long value) {
            addCriterion("order_cardId <", value, "orderCardid");
            return (Criteria) this;
        }

        public Criteria andOrderCardidLessThanOrEqualTo(Long value) {
            addCriterion("order_cardId <=", value, "orderCardid");
            return (Criteria) this;
        }

        public Criteria andOrderCardidIn(List<Long> values) {
            addCriterion("order_cardId in", values, "orderCardid");
            return (Criteria) this;
        }

        public Criteria andOrderCardidNotIn(List<Long> values) {
            addCriterion("order_cardId not in", values, "orderCardid");
            return (Criteria) this;
        }

        public Criteria andOrderCardidBetween(Long value1, Long value2) {
            addCriterion("order_cardId between", value1, value2, "orderCardid");
            return (Criteria) this;
        }

        public Criteria andOrderCardidNotBetween(Long value1, Long value2) {
            addCriterion("order_cardId not between", value1, value2, "orderCardid");
            return (Criteria) this;
        }

        public Criteria andOrderAmountRecognizedIsNull() {
            addCriterion("order_amount_recognized is null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountRecognizedIsNotNull() {
            addCriterion("order_amount_recognized is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountRecognizedEqualTo(BigDecimal value) {
            addCriterion("order_amount_recognized =", value, "orderAmountRecognized");
            return (Criteria) this;
        }

        public Criteria andOrderAmountRecognizedNotEqualTo(BigDecimal value) {
            addCriterion("order_amount_recognized <>", value, "orderAmountRecognized");
            return (Criteria) this;
        }

        public Criteria andOrderAmountRecognizedGreaterThan(BigDecimal value) {
            addCriterion("order_amount_recognized >", value, "orderAmountRecognized");
            return (Criteria) this;
        }

        public Criteria andOrderAmountRecognizedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount_recognized >=", value, "orderAmountRecognized");
            return (Criteria) this;
        }

        public Criteria andOrderAmountRecognizedLessThan(BigDecimal value) {
            addCriterion("order_amount_recognized <", value, "orderAmountRecognized");
            return (Criteria) this;
        }

        public Criteria andOrderAmountRecognizedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount_recognized <=", value, "orderAmountRecognized");
            return (Criteria) this;
        }

        public Criteria andOrderAmountRecognizedIn(List<BigDecimal> values) {
            addCriterion("order_amount_recognized in", values, "orderAmountRecognized");
            return (Criteria) this;
        }

        public Criteria andOrderAmountRecognizedNotIn(List<BigDecimal> values) {
            addCriterion("order_amount_recognized not in", values, "orderAmountRecognized");
            return (Criteria) this;
        }

        public Criteria andOrderAmountRecognizedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount_recognized between", value1, value2, "orderAmountRecognized");
            return (Criteria) this;
        }

        public Criteria andOrderAmountRecognizedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount_recognized not between", value1, value2, "orderAmountRecognized");
            return (Criteria) this;
        }

        public Criteria andOidPaybillIsNull() {
            addCriterion("oid_paybill is null");
            return (Criteria) this;
        }

        public Criteria andOidPaybillIsNotNull() {
            addCriterion("oid_paybill is not null");
            return (Criteria) this;
        }

        public Criteria andOidPaybillEqualTo(String value) {
            addCriterion("oid_paybill =", value, "oidPaybill");
            return (Criteria) this;
        }

        public Criteria andOidPaybillNotEqualTo(String value) {
            addCriterion("oid_paybill <>", value, "oidPaybill");
            return (Criteria) this;
        }

        public Criteria andOidPaybillGreaterThan(String value) {
            addCriterion("oid_paybill >", value, "oidPaybill");
            return (Criteria) this;
        }

        public Criteria andOidPaybillGreaterThanOrEqualTo(String value) {
            addCriterion("oid_paybill >=", value, "oidPaybill");
            return (Criteria) this;
        }

        public Criteria andOidPaybillLessThan(String value) {
            addCriterion("oid_paybill <", value, "oidPaybill");
            return (Criteria) this;
        }

        public Criteria andOidPaybillLessThanOrEqualTo(String value) {
            addCriterion("oid_paybill <=", value, "oidPaybill");
            return (Criteria) this;
        }

        public Criteria andOidPaybillLike(String value) {
            addCriterion("oid_paybill like", value, "oidPaybill");
            return (Criteria) this;
        }

        public Criteria andOidPaybillNotLike(String value) {
            addCriterion("oid_paybill not like", value, "oidPaybill");
            return (Criteria) this;
        }

        public Criteria andOidPaybillIn(List<String> values) {
            addCriterion("oid_paybill in", values, "oidPaybill");
            return (Criteria) this;
        }

        public Criteria andOidPaybillNotIn(List<String> values) {
            addCriterion("oid_paybill not in", values, "oidPaybill");
            return (Criteria) this;
        }

        public Criteria andOidPaybillBetween(String value1, String value2) {
            addCriterion("oid_paybill between", value1, value2, "oidPaybill");
            return (Criteria) this;
        }

        public Criteria andOidPaybillNotBetween(String value1, String value2) {
            addCriterion("oid_paybill not between", value1, value2, "oidPaybill");
            return (Criteria) this;
        }

        public Criteria andOrderRepaymentIsNull() {
            addCriterion("order_repayment is null");
            return (Criteria) this;
        }

        public Criteria andOrderRepaymentIsNotNull() {
            addCriterion("order_repayment is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRepaymentEqualTo(BigDecimal value) {
            addCriterion("order_repayment =", value, "orderRepayment");
            return (Criteria) this;
        }

        public Criteria andOrderRepaymentNotEqualTo(BigDecimal value) {
            addCriterion("order_repayment <>", value, "orderRepayment");
            return (Criteria) this;
        }

        public Criteria andOrderRepaymentGreaterThan(BigDecimal value) {
            addCriterion("order_repayment >", value, "orderRepayment");
            return (Criteria) this;
        }

        public Criteria andOrderRepaymentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_repayment >=", value, "orderRepayment");
            return (Criteria) this;
        }

        public Criteria andOrderRepaymentLessThan(BigDecimal value) {
            addCriterion("order_repayment <", value, "orderRepayment");
            return (Criteria) this;
        }

        public Criteria andOrderRepaymentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_repayment <=", value, "orderRepayment");
            return (Criteria) this;
        }

        public Criteria andOrderRepaymentIn(List<BigDecimal> values) {
            addCriterion("order_repayment in", values, "orderRepayment");
            return (Criteria) this;
        }

        public Criteria andOrderRepaymentNotIn(List<BigDecimal> values) {
            addCriterion("order_repayment not in", values, "orderRepayment");
            return (Criteria) this;
        }

        public Criteria andOrderRepaymentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_repayment between", value1, value2, "orderRepayment");
            return (Criteria) this;
        }

        public Criteria andOrderRepaymentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_repayment not between", value1, value2, "orderRepayment");
            return (Criteria) this;
        }

        public Criteria andOrderPenaltyIsNull() {
            addCriterion("order_penalty is null");
            return (Criteria) this;
        }

        public Criteria andOrderPenaltyIsNotNull() {
            addCriterion("order_penalty is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPenaltyEqualTo(BigDecimal value) {
            addCriterion("order_penalty =", value, "orderPenalty");
            return (Criteria) this;
        }

        public Criteria andOrderPenaltyNotEqualTo(BigDecimal value) {
            addCriterion("order_penalty <>", value, "orderPenalty");
            return (Criteria) this;
        }

        public Criteria andOrderPenaltyGreaterThan(BigDecimal value) {
            addCriterion("order_penalty >", value, "orderPenalty");
            return (Criteria) this;
        }

        public Criteria andOrderPenaltyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_penalty >=", value, "orderPenalty");
            return (Criteria) this;
        }

        public Criteria andOrderPenaltyLessThan(BigDecimal value) {
            addCriterion("order_penalty <", value, "orderPenalty");
            return (Criteria) this;
        }

        public Criteria andOrderPenaltyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_penalty <=", value, "orderPenalty");
            return (Criteria) this;
        }

        public Criteria andOrderPenaltyIn(List<BigDecimal> values) {
            addCriterion("order_penalty in", values, "orderPenalty");
            return (Criteria) this;
        }

        public Criteria andOrderPenaltyNotIn(List<BigDecimal> values) {
            addCriterion("order_penalty not in", values, "orderPenalty");
            return (Criteria) this;
        }

        public Criteria andOrderPenaltyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_penalty between", value1, value2, "orderPenalty");
            return (Criteria) this;
        }

        public Criteria andOrderPenaltyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_penalty not between", value1, value2, "orderPenalty");
            return (Criteria) this;
        }

        public Criteria andOrderFullnameIsNull() {
            addCriterion("order_fullName is null");
            return (Criteria) this;
        }

        public Criteria andOrderFullnameIsNotNull() {
            addCriterion("order_fullName is not null");
            return (Criteria) this;
        }

        public Criteria andOrderFullnameEqualTo(String value) {
            addCriterion("order_fullName =", value, "orderFullname");
            return (Criteria) this;
        }

        public Criteria andOrderFullnameNotEqualTo(String value) {
            addCriterion("order_fullName <>", value, "orderFullname");
            return (Criteria) this;
        }

        public Criteria andOrderFullnameGreaterThan(String value) {
            addCriterion("order_fullName >", value, "orderFullname");
            return (Criteria) this;
        }

        public Criteria andOrderFullnameGreaterThanOrEqualTo(String value) {
            addCriterion("order_fullName >=", value, "orderFullname");
            return (Criteria) this;
        }

        public Criteria andOrderFullnameLessThan(String value) {
            addCriterion("order_fullName <", value, "orderFullname");
            return (Criteria) this;
        }

        public Criteria andOrderFullnameLessThanOrEqualTo(String value) {
            addCriterion("order_fullName <=", value, "orderFullname");
            return (Criteria) this;
        }

        public Criteria andOrderFullnameLike(String value) {
            addCriterion("order_fullName like", value, "orderFullname");
            return (Criteria) this;
        }

        public Criteria andOrderFullnameNotLike(String value) {
            addCriterion("order_fullName not like", value, "orderFullname");
            return (Criteria) this;
        }

        public Criteria andOrderFullnameIn(List<String> values) {
            addCriterion("order_fullName in", values, "orderFullname");
            return (Criteria) this;
        }

        public Criteria andOrderFullnameNotIn(List<String> values) {
            addCriterion("order_fullName not in", values, "orderFullname");
            return (Criteria) this;
        }

        public Criteria andOrderFullnameBetween(String value1, String value2) {
            addCriterion("order_fullName between", value1, value2, "orderFullname");
            return (Criteria) this;
        }

        public Criteria andOrderFullnameNotBetween(String value1, String value2) {
            addCriterion("order_fullName not between", value1, value2, "orderFullname");
            return (Criteria) this;
        }

        public Criteria andOrderNextPayTimeIsNull() {
            addCriterion("order_next_Pay_Time is null");
            return (Criteria) this;
        }

        public Criteria andOrderNextPayTimeIsNotNull() {
            addCriterion("order_next_Pay_Time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNextPayTimeEqualTo(Date value) {
            addCriterion("order_next_Pay_Time =", value, "orderNextPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderNextPayTimeNotEqualTo(Date value) {
            addCriterion("order_next_Pay_Time <>", value, "orderNextPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderNextPayTimeGreaterThan(Date value) {
            addCriterion("order_next_Pay_Time >", value, "orderNextPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderNextPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_next_Pay_Time >=", value, "orderNextPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderNextPayTimeLessThan(Date value) {
            addCriterion("order_next_Pay_Time <", value, "orderNextPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderNextPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_next_Pay_Time <=", value, "orderNextPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderNextPayTimeIn(List<Date> values) {
            addCriterion("order_next_Pay_Time in", values, "orderNextPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderNextPayTimeNotIn(List<Date> values) {
            addCriterion("order_next_Pay_Time not in", values, "orderNextPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderNextPayTimeBetween(Date value1, Date value2) {
            addCriterion("order_next_Pay_Time between", value1, value2, "orderNextPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderNextPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_next_Pay_Time not between", value1, value2, "orderNextPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderOverduePayTimeIsNull() {
            addCriterion("order_overdue_Pay_Time is null");
            return (Criteria) this;
        }

        public Criteria andOrderOverduePayTimeIsNotNull() {
            addCriterion("order_overdue_Pay_Time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderOverduePayTimeEqualTo(Date value) {
            addCriterion("order_overdue_Pay_Time =", value, "orderOverduePayTime");
            return (Criteria) this;
        }

        public Criteria andOrderOverduePayTimeNotEqualTo(Date value) {
            addCriterion("order_overdue_Pay_Time <>", value, "orderOverduePayTime");
            return (Criteria) this;
        }

        public Criteria andOrderOverduePayTimeGreaterThan(Date value) {
            addCriterion("order_overdue_Pay_Time >", value, "orderOverduePayTime");
            return (Criteria) this;
        }

        public Criteria andOrderOverduePayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_overdue_Pay_Time >=", value, "orderOverduePayTime");
            return (Criteria) this;
        }

        public Criteria andOrderOverduePayTimeLessThan(Date value) {
            addCriterion("order_overdue_Pay_Time <", value, "orderOverduePayTime");
            return (Criteria) this;
        }

        public Criteria andOrderOverduePayTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_overdue_Pay_Time <=", value, "orderOverduePayTime");
            return (Criteria) this;
        }

        public Criteria andOrderOverduePayTimeIn(List<Date> values) {
            addCriterion("order_overdue_Pay_Time in", values, "orderOverduePayTime");
            return (Criteria) this;
        }

        public Criteria andOrderOverduePayTimeNotIn(List<Date> values) {
            addCriterion("order_overdue_Pay_Time not in", values, "orderOverduePayTime");
            return (Criteria) this;
        }

        public Criteria andOrderOverduePayTimeBetween(Date value1, Date value2) {
            addCriterion("order_overdue_Pay_Time between", value1, value2, "orderOverduePayTime");
            return (Criteria) this;
        }

        public Criteria andOrderOverduePayTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_overdue_Pay_Time not between", value1, value2, "orderOverduePayTime");
            return (Criteria) this;
        }

        public Criteria andOrderBadPayTimeIsNull() {
            addCriterion("order_bad_Pay_Time is null");
            return (Criteria) this;
        }

        public Criteria andOrderBadPayTimeIsNotNull() {
            addCriterion("order_bad_Pay_Time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderBadPayTimeEqualTo(Date value) {
            addCriterion("order_bad_Pay_Time =", value, "orderBadPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderBadPayTimeNotEqualTo(Date value) {
            addCriterion("order_bad_Pay_Time <>", value, "orderBadPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderBadPayTimeGreaterThan(Date value) {
            addCriterion("order_bad_Pay_Time >", value, "orderBadPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderBadPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_bad_Pay_Time >=", value, "orderBadPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderBadPayTimeLessThan(Date value) {
            addCriterion("order_bad_Pay_Time <", value, "orderBadPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderBadPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_bad_Pay_Time <=", value, "orderBadPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderBadPayTimeIn(List<Date> values) {
            addCriterion("order_bad_Pay_Time in", values, "orderBadPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderBadPayTimeNotIn(List<Date> values) {
            addCriterion("order_bad_Pay_Time not in", values, "orderBadPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderBadPayTimeBetween(Date value1, Date value2) {
            addCriterion("order_bad_Pay_Time between", value1, value2, "orderBadPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderBadPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_bad_Pay_Time not between", value1, value2, "orderBadPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderAuditFailMsgIsNull() {
            addCriterion("order_audit_fail_msg is null");
            return (Criteria) this;
        }

        public Criteria andOrderAuditFailMsgIsNotNull() {
            addCriterion("order_audit_fail_msg is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAuditFailMsgEqualTo(String value) {
            addCriterion("order_audit_fail_msg =", value, "orderAuditFailMsg");
            return (Criteria) this;
        }

        public Criteria andOrderAuditFailMsgNotEqualTo(String value) {
            addCriterion("order_audit_fail_msg <>", value, "orderAuditFailMsg");
            return (Criteria) this;
        }

        public Criteria andOrderAuditFailMsgGreaterThan(String value) {
            addCriterion("order_audit_fail_msg >", value, "orderAuditFailMsg");
            return (Criteria) this;
        }

        public Criteria andOrderAuditFailMsgGreaterThanOrEqualTo(String value) {
            addCriterion("order_audit_fail_msg >=", value, "orderAuditFailMsg");
            return (Criteria) this;
        }

        public Criteria andOrderAuditFailMsgLessThan(String value) {
            addCriterion("order_audit_fail_msg <", value, "orderAuditFailMsg");
            return (Criteria) this;
        }

        public Criteria andOrderAuditFailMsgLessThanOrEqualTo(String value) {
            addCriterion("order_audit_fail_msg <=", value, "orderAuditFailMsg");
            return (Criteria) this;
        }

        public Criteria andOrderAuditFailMsgLike(String value) {
            addCriterion("order_audit_fail_msg like", value, "orderAuditFailMsg");
            return (Criteria) this;
        }

        public Criteria andOrderAuditFailMsgNotLike(String value) {
            addCriterion("order_audit_fail_msg not like", value, "orderAuditFailMsg");
            return (Criteria) this;
        }

        public Criteria andOrderAuditFailMsgIn(List<String> values) {
            addCriterion("order_audit_fail_msg in", values, "orderAuditFailMsg");
            return (Criteria) this;
        }

        public Criteria andOrderAuditFailMsgNotIn(List<String> values) {
            addCriterion("order_audit_fail_msg not in", values, "orderAuditFailMsg");
            return (Criteria) this;
        }

        public Criteria andOrderAuditFailMsgBetween(String value1, String value2) {
            addCriterion("order_audit_fail_msg between", value1, value2, "orderAuditFailMsg");
            return (Criteria) this;
        }

        public Criteria andOrderAuditFailMsgNotBetween(String value1, String value2) {
            addCriterion("order_audit_fail_msg not between", value1, value2, "orderAuditFailMsg");
            return (Criteria) this;
        }

        public Criteria andOrderAnnotateIsNull() {
            addCriterion("order_annotate is null");
            return (Criteria) this;
        }

        public Criteria andOrderAnnotateIsNotNull() {
            addCriterion("order_annotate is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAnnotateEqualTo(String value) {
            addCriterion("order_annotate =", value, "orderAnnotate");
            return (Criteria) this;
        }

        public Criteria andOrderAnnotateNotEqualTo(String value) {
            addCriterion("order_annotate <>", value, "orderAnnotate");
            return (Criteria) this;
        }

        public Criteria andOrderAnnotateGreaterThan(String value) {
            addCriterion("order_annotate >", value, "orderAnnotate");
            return (Criteria) this;
        }

        public Criteria andOrderAnnotateGreaterThanOrEqualTo(String value) {
            addCriterion("order_annotate >=", value, "orderAnnotate");
            return (Criteria) this;
        }

        public Criteria andOrderAnnotateLessThan(String value) {
            addCriterion("order_annotate <", value, "orderAnnotate");
            return (Criteria) this;
        }

        public Criteria andOrderAnnotateLessThanOrEqualTo(String value) {
            addCriterion("order_annotate <=", value, "orderAnnotate");
            return (Criteria) this;
        }

        public Criteria andOrderAnnotateLike(String value) {
            addCriterion("order_annotate like", value, "orderAnnotate");
            return (Criteria) this;
        }

        public Criteria andOrderAnnotateNotLike(String value) {
            addCriterion("order_annotate not like", value, "orderAnnotate");
            return (Criteria) this;
        }

        public Criteria andOrderAnnotateIn(List<String> values) {
            addCriterion("order_annotate in", values, "orderAnnotate");
            return (Criteria) this;
        }

        public Criteria andOrderAnnotateNotIn(List<String> values) {
            addCriterion("order_annotate not in", values, "orderAnnotate");
            return (Criteria) this;
        }

        public Criteria andOrderAnnotateBetween(String value1, String value2) {
            addCriterion("order_annotate between", value1, value2, "orderAnnotate");
            return (Criteria) this;
        }

        public Criteria andOrderAnnotateNotBetween(String value1, String value2) {
            addCriterion("order_annotate not between", value1, value2, "orderAnnotate");
            return (Criteria) this;
        }

        public Criteria andOrderIsShowIsNull() {
            addCriterion("order_is_show is null");
            return (Criteria) this;
        }

        public Criteria andOrderIsShowIsNotNull() {
            addCriterion("order_is_show is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIsShowEqualTo(Integer value) {
            addCriterion("order_is_show =", value, "orderIsShow");
            return (Criteria) this;
        }

        public Criteria andOrderIsShowNotEqualTo(Integer value) {
            addCriterion("order_is_show <>", value, "orderIsShow");
            return (Criteria) this;
        }

        public Criteria andOrderIsShowGreaterThan(Integer value) {
            addCriterion("order_is_show >", value, "orderIsShow");
            return (Criteria) this;
        }

        public Criteria andOrderIsShowGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_is_show >=", value, "orderIsShow");
            return (Criteria) this;
        }

        public Criteria andOrderIsShowLessThan(Integer value) {
            addCriterion("order_is_show <", value, "orderIsShow");
            return (Criteria) this;
        }

        public Criteria andOrderIsShowLessThanOrEqualTo(Integer value) {
            addCriterion("order_is_show <=", value, "orderIsShow");
            return (Criteria) this;
        }

        public Criteria andOrderIsShowIn(List<Integer> values) {
            addCriterion("order_is_show in", values, "orderIsShow");
            return (Criteria) this;
        }

        public Criteria andOrderIsShowNotIn(List<Integer> values) {
            addCriterion("order_is_show not in", values, "orderIsShow");
            return (Criteria) this;
        }

        public Criteria andOrderIsShowBetween(Integer value1, Integer value2) {
            addCriterion("order_is_show between", value1, value2, "orderIsShow");
            return (Criteria) this;
        }

        public Criteria andOrderIsShowNotBetween(Integer value1, Integer value2) {
            addCriterion("order_is_show not between", value1, value2, "orderIsShow");
            return (Criteria) this;
        }
 public Criteria andBillsFlagIsNull() {
            addCriterion("bills_flag is null");
            return (Criteria) this;
        }

        public Criteria andBillsFlagIsNotNull() {
            addCriterion("bills_flag is not null");
            return (Criteria) this;
        }

        public Criteria andBillsFlagEqualTo(Integer value) {
            addCriterion("bills_flag =", value, "billsFlag");
            return (Criteria) this;
        }

        public Criteria andBillsFlagNotEqualTo(Integer value) {
            addCriterion("bills_flag <>", value, "billsFlag");
            return (Criteria) this;
        }

        public Criteria andBillsFlagGreaterThan(Integer value) {
            addCriterion("bills_flag >", value, "billsFlag");
            return (Criteria) this;
        }

        public Criteria andBillsFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("bills_flag >=", value, "billsFlag");
            return (Criteria) this;
        }

        public Criteria andBillsFlagLessThan(Integer value) {
            addCriterion("bills_flag <", value, "billsFlag");
            return (Criteria) this;
        }

        public Criteria andBillsFlagLessThanOrEqualTo(Integer value) {
            addCriterion("bills_flag <=", value, "billsFlag");
            return (Criteria) this;
        }

        public Criteria andBillsFlagIn(List<Integer> values) {
            addCriterion("bills_flag in", values, "billsFlag");
            return (Criteria) this;
        }

        public Criteria andBillsFlagNotIn(List<Integer> values) {
            addCriterion("bills_flag not in", values, "billsFlag");
            return (Criteria) this;
        }

        public Criteria andBillsFlagBetween(Integer value1, Integer value2) {
            addCriterion("bills_flag between", value1, value2, "billsFlag");
            return (Criteria) this;
        }

        public Criteria andBillsFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("bills_flag not between", value1, value2, "billsFlag");
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
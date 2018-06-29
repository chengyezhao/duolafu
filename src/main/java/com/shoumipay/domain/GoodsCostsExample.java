package com.shoumipay.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GoodsCostsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsCostsExample() {
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

        public Criteria andGoodsidIsNull() {
            addCriterion("goodsId is null");
            return (Criteria) this;
        }

        public Criteria andGoodsidIsNotNull() {
            addCriterion("goodsId is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsidEqualTo(Long value) {
            addCriterion("goodsId =", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotEqualTo(Long value) {
            addCriterion("goodsId <>", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThan(Long value) {
            addCriterion("goodsId >", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThanOrEqualTo(Long value) {
            addCriterion("goodsId >=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThan(Long value) {
            addCriterion("goodsId <", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThanOrEqualTo(Long value) {
            addCriterion("goodsId <=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidIn(List<Long> values) {
            addCriterion("goodsId in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotIn(List<Long> values) {
            addCriterion("goodsId not in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidBetween(Long value1, Long value2) {
            addCriterion("goodsId between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotBetween(Long value1, Long value2) {
            addCriterion("goodsId not between", value1, value2, "goodsid");
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

        public Criteria andNameEqualTo(Integer value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(Integer value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(Integer value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(Integer value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(Integer value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(Integer value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<Integer> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<Integer> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(Integer value1, Integer value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(Integer value1, Integer value2) {
            addCriterion("name not between", value1, value2, "name");
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

        public Criteria andCollectingMethodsIsNull() {
            addCriterion("collecting_Methods is null");
            return (Criteria) this;
        }

        public Criteria andCollectingMethodsIsNotNull() {
            addCriterion("collecting_Methods is not null");
            return (Criteria) this;
        }

        public Criteria andCollectingMethodsEqualTo(Integer value) {
            addCriterion("collecting_Methods =", value, "collectingMethods");
            return (Criteria) this;
        }

        public Criteria andCollectingMethodsNotEqualTo(Integer value) {
            addCriterion("collecting_Methods <>", value, "collectingMethods");
            return (Criteria) this;
        }

        public Criteria andCollectingMethodsGreaterThan(Integer value) {
            addCriterion("collecting_Methods >", value, "collectingMethods");
            return (Criteria) this;
        }

        public Criteria andCollectingMethodsGreaterThanOrEqualTo(Integer value) {
            addCriterion("collecting_Methods >=", value, "collectingMethods");
            return (Criteria) this;
        }

        public Criteria andCollectingMethodsLessThan(Integer value) {
            addCriterion("collecting_Methods <", value, "collectingMethods");
            return (Criteria) this;
        }

        public Criteria andCollectingMethodsLessThanOrEqualTo(Integer value) {
            addCriterion("collecting_Methods <=", value, "collectingMethods");
            return (Criteria) this;
        }

        public Criteria andCollectingMethodsIn(List<Integer> values) {
            addCriterion("collecting_Methods in", values, "collectingMethods");
            return (Criteria) this;
        }

        public Criteria andCollectingMethodsNotIn(List<Integer> values) {
            addCriterion("collecting_Methods not in", values, "collectingMethods");
            return (Criteria) this;
        }

        public Criteria andCollectingMethodsBetween(Integer value1, Integer value2) {
            addCriterion("collecting_Methods between", value1, value2, "collectingMethods");
            return (Criteria) this;
        }

        public Criteria andCollectingMethodsNotBetween(Integer value1, Integer value2) {
            addCriterion("collecting_Methods not between", value1, value2, "collectingMethods");
            return (Criteria) this;
        }

        public Criteria andSettlementModelIsNull() {
            addCriterion("settlement_Model is null");
            return (Criteria) this;
        }

        public Criteria andSettlementModelIsNotNull() {
            addCriterion("settlement_Model is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementModelEqualTo(Integer value) {
            addCriterion("settlement_Model =", value, "settlementModel");
            return (Criteria) this;
        }

        public Criteria andSettlementModelNotEqualTo(Integer value) {
            addCriterion("settlement_Model <>", value, "settlementModel");
            return (Criteria) this;
        }

        public Criteria andSettlementModelGreaterThan(Integer value) {
            addCriterion("settlement_Model >", value, "settlementModel");
            return (Criteria) this;
        }

        public Criteria andSettlementModelGreaterThanOrEqualTo(Integer value) {
            addCriterion("settlement_Model >=", value, "settlementModel");
            return (Criteria) this;
        }

        public Criteria andSettlementModelLessThan(Integer value) {
            addCriterion("settlement_Model <", value, "settlementModel");
            return (Criteria) this;
        }

        public Criteria andSettlementModelLessThanOrEqualTo(Integer value) {
            addCriterion("settlement_Model <=", value, "settlementModel");
            return (Criteria) this;
        }

        public Criteria andSettlementModelIn(List<Integer> values) {
            addCriterion("settlement_Model in", values, "settlementModel");
            return (Criteria) this;
        }

        public Criteria andSettlementModelNotIn(List<Integer> values) {
            addCriterion("settlement_Model not in", values, "settlementModel");
            return (Criteria) this;
        }

        public Criteria andSettlementModelBetween(Integer value1, Integer value2) {
            addCriterion("settlement_Model between", value1, value2, "settlementModel");
            return (Criteria) this;
        }

        public Criteria andSettlementModelNotBetween(Integer value1, Integer value2) {
            addCriterion("settlement_Model not between", value1, value2, "settlementModel");
            return (Criteria) this;
        }

        public Criteria andB2bModelIsNull() {
            addCriterion("B2B_Model is null");
            return (Criteria) this;
        }

        public Criteria andB2bModelIsNotNull() {
            addCriterion("B2B_Model is not null");
            return (Criteria) this;
        }

        public Criteria andB2bModelEqualTo(Integer value) {
            addCriterion("B2B_Model =", value, "b2bModel");
            return (Criteria) this;
        }

        public Criteria andB2bModelNotEqualTo(Integer value) {
            addCriterion("B2B_Model <>", value, "b2bModel");
            return (Criteria) this;
        }

        public Criteria andB2bModelGreaterThan(Integer value) {
            addCriterion("B2B_Model >", value, "b2bModel");
            return (Criteria) this;
        }

        public Criteria andB2bModelGreaterThanOrEqualTo(Integer value) {
            addCriterion("B2B_Model >=", value, "b2bModel");
            return (Criteria) this;
        }

        public Criteria andB2bModelLessThan(Integer value) {
            addCriterion("B2B_Model <", value, "b2bModel");
            return (Criteria) this;
        }

        public Criteria andB2bModelLessThanOrEqualTo(Integer value) {
            addCriterion("B2B_Model <=", value, "b2bModel");
            return (Criteria) this;
        }

        public Criteria andB2bModelIn(List<Integer> values) {
            addCriterion("B2B_Model in", values, "b2bModel");
            return (Criteria) this;
        }

        public Criteria andB2bModelNotIn(List<Integer> values) {
            addCriterion("B2B_Model not in", values, "b2bModel");
            return (Criteria) this;
        }

        public Criteria andB2bModelBetween(Integer value1, Integer value2) {
            addCriterion("B2B_Model between", value1, value2, "b2bModel");
            return (Criteria) this;
        }

        public Criteria andB2bModelNotBetween(Integer value1, Integer value2) {
            addCriterion("B2B_Model not between", value1, value2, "b2bModel");
            return (Criteria) this;
        }

        public Criteria andP2pDirectModelIsNull() {
            addCriterion("P2P_Direct_Model is null");
            return (Criteria) this;
        }

        public Criteria andP2pDirectModelIsNotNull() {
            addCriterion("P2P_Direct_Model is not null");
            return (Criteria) this;
        }

        public Criteria andP2pDirectModelEqualTo(Integer value) {
            addCriterion("P2P_Direct_Model =", value, "p2pDirectModel");
            return (Criteria) this;
        }

        public Criteria andP2pDirectModelNotEqualTo(Integer value) {
            addCriterion("P2P_Direct_Model <>", value, "p2pDirectModel");
            return (Criteria) this;
        }

        public Criteria andP2pDirectModelGreaterThan(Integer value) {
            addCriterion("P2P_Direct_Model >", value, "p2pDirectModel");
            return (Criteria) this;
        }

        public Criteria andP2pDirectModelGreaterThanOrEqualTo(Integer value) {
            addCriterion("P2P_Direct_Model >=", value, "p2pDirectModel");
            return (Criteria) this;
        }

        public Criteria andP2pDirectModelLessThan(Integer value) {
            addCriterion("P2P_Direct_Model <", value, "p2pDirectModel");
            return (Criteria) this;
        }

        public Criteria andP2pDirectModelLessThanOrEqualTo(Integer value) {
            addCriterion("P2P_Direct_Model <=", value, "p2pDirectModel");
            return (Criteria) this;
        }

        public Criteria andP2pDirectModelIn(List<Integer> values) {
            addCriterion("P2P_Direct_Model in", values, "p2pDirectModel");
            return (Criteria) this;
        }

        public Criteria andP2pDirectModelNotIn(List<Integer> values) {
            addCriterion("P2P_Direct_Model not in", values, "p2pDirectModel");
            return (Criteria) this;
        }

        public Criteria andP2pDirectModelBetween(Integer value1, Integer value2) {
            addCriterion("P2P_Direct_Model between", value1, value2, "p2pDirectModel");
            return (Criteria) this;
        }

        public Criteria andP2pDirectModelNotBetween(Integer value1, Integer value2) {
            addCriterion("P2P_Direct_Model not between", value1, value2, "p2pDirectModel");
            return (Criteria) this;
        }

        public Criteria andP2pIndirectModelIsNull() {
            addCriterion("P2P_Indirect_Model is null");
            return (Criteria) this;
        }

        public Criteria andP2pIndirectModelIsNotNull() {
            addCriterion("P2P_Indirect_Model is not null");
            return (Criteria) this;
        }

        public Criteria andP2pIndirectModelEqualTo(Integer value) {
            addCriterion("P2P_Indirect_Model =", value, "p2pIndirectModel");
            return (Criteria) this;
        }

        public Criteria andP2pIndirectModelNotEqualTo(Integer value) {
            addCriterion("P2P_Indirect_Model <>", value, "p2pIndirectModel");
            return (Criteria) this;
        }

        public Criteria andP2pIndirectModelGreaterThan(Integer value) {
            addCriterion("P2P_Indirect_Model >", value, "p2pIndirectModel");
            return (Criteria) this;
        }

        public Criteria andP2pIndirectModelGreaterThanOrEqualTo(Integer value) {
            addCriterion("P2P_Indirect_Model >=", value, "p2pIndirectModel");
            return (Criteria) this;
        }

        public Criteria andP2pIndirectModelLessThan(Integer value) {
            addCriterion("P2P_Indirect_Model <", value, "p2pIndirectModel");
            return (Criteria) this;
        }

        public Criteria andP2pIndirectModelLessThanOrEqualTo(Integer value) {
            addCriterion("P2P_Indirect_Model <=", value, "p2pIndirectModel");
            return (Criteria) this;
        }

        public Criteria andP2pIndirectModelIn(List<Integer> values) {
            addCriterion("P2P_Indirect_Model in", values, "p2pIndirectModel");
            return (Criteria) this;
        }

        public Criteria andP2pIndirectModelNotIn(List<Integer> values) {
            addCriterion("P2P_Indirect_Model not in", values, "p2pIndirectModel");
            return (Criteria) this;
        }

        public Criteria andP2pIndirectModelBetween(Integer value1, Integer value2) {
            addCriterion("P2P_Indirect_Model between", value1, value2, "p2pIndirectModel");
            return (Criteria) this;
        }

        public Criteria andP2pIndirectModelNotBetween(Integer value1, Integer value2) {
            addCriterion("P2P_Indirect_Model not between", value1, value2, "p2pIndirectModel");
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
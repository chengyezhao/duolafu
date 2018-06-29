package com.shoumipay.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsRepaymentCollectionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsRepaymentCollectionExample() {
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

        public Criteria andRepaymentIdIsNull() {
            addCriterion("repayment_id is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentIdIsNotNull() {
            addCriterion("repayment_id is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentIdEqualTo(Long value) {
            addCriterion("repayment_id =", value, "repaymentId");
            return (Criteria) this;
        }

        public Criteria andRepaymentIdNotEqualTo(Long value) {
            addCriterion("repayment_id <>", value, "repaymentId");
            return (Criteria) this;
        }

        public Criteria andRepaymentIdGreaterThan(Long value) {
            addCriterion("repayment_id >", value, "repaymentId");
            return (Criteria) this;
        }

        public Criteria andRepaymentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("repayment_id >=", value, "repaymentId");
            return (Criteria) this;
        }

        public Criteria andRepaymentIdLessThan(Long value) {
            addCriterion("repayment_id <", value, "repaymentId");
            return (Criteria) this;
        }

        public Criteria andRepaymentIdLessThanOrEqualTo(Long value) {
            addCriterion("repayment_id <=", value, "repaymentId");
            return (Criteria) this;
        }

        public Criteria andRepaymentIdIn(List<Long> values) {
            addCriterion("repayment_id in", values, "repaymentId");
            return (Criteria) this;
        }

        public Criteria andRepaymentIdNotIn(List<Long> values) {
            addCriterion("repayment_id not in", values, "repaymentId");
            return (Criteria) this;
        }

        public Criteria andRepaymentIdBetween(Long value1, Long value2) {
            addCriterion("repayment_id between", value1, value2, "repaymentId");
            return (Criteria) this;
        }

        public Criteria andRepaymentIdNotBetween(Long value1, Long value2) {
            addCriterion("repayment_id not between", value1, value2, "repaymentId");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionTimeLimitIsNull() {
            addCriterion("repayment_collection_time_limit is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionTimeLimitIsNotNull() {
            addCriterion("repayment_collection_time_limit is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionTimeLimitEqualTo(Integer value) {
            addCriterion("repayment_collection_time_limit =", value, "repaymentCollectionTimeLimit");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionTimeLimitNotEqualTo(Integer value) {
            addCriterion("repayment_collection_time_limit <>", value, "repaymentCollectionTimeLimit");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionTimeLimitGreaterThan(Integer value) {
            addCriterion("repayment_collection_time_limit >", value, "repaymentCollectionTimeLimit");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionTimeLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("repayment_collection_time_limit >=", value, "repaymentCollectionTimeLimit");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionTimeLimitLessThan(Integer value) {
            addCriterion("repayment_collection_time_limit <", value, "repaymentCollectionTimeLimit");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionTimeLimitLessThanOrEqualTo(Integer value) {
            addCriterion("repayment_collection_time_limit <=", value, "repaymentCollectionTimeLimit");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionTimeLimitIn(List<Integer> values) {
            addCriterion("repayment_collection_time_limit in", values, "repaymentCollectionTimeLimit");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionTimeLimitNotIn(List<Integer> values) {
            addCriterion("repayment_collection_time_limit not in", values, "repaymentCollectionTimeLimit");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionTimeLimitBetween(Integer value1, Integer value2) {
            addCriterion("repayment_collection_time_limit between", value1, value2, "repaymentCollectionTimeLimit");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionTimeLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("repayment_collection_time_limit not between", value1, value2, "repaymentCollectionTimeLimit");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAmountIsNull() {
            addCriterion("repayment_collection_amount is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAmountIsNotNull() {
            addCriterion("repayment_collection_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAmountEqualTo(BigDecimal value) {
            addCriterion("repayment_collection_amount =", value, "repaymentCollectionAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAmountNotEqualTo(BigDecimal value) {
            addCriterion("repayment_collection_amount <>", value, "repaymentCollectionAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAmountGreaterThan(BigDecimal value) {
            addCriterion("repayment_collection_amount >", value, "repaymentCollectionAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("repayment_collection_amount >=", value, "repaymentCollectionAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAmountLessThan(BigDecimal value) {
            addCriterion("repayment_collection_amount <", value, "repaymentCollectionAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("repayment_collection_amount <=", value, "repaymentCollectionAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAmountIn(List<BigDecimal> values) {
            addCriterion("repayment_collection_amount in", values, "repaymentCollectionAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAmountNotIn(List<BigDecimal> values) {
            addCriterion("repayment_collection_amount not in", values, "repaymentCollectionAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayment_collection_amount between", value1, value2, "repaymentCollectionAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayment_collection_amount not between", value1, value2, "repaymentCollectionAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionCapitalIsNull() {
            addCriterion("repayment_collection_capital is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionCapitalIsNotNull() {
            addCriterion("repayment_collection_capital is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionCapitalEqualTo(BigDecimal value) {
            addCriterion("repayment_collection_capital =", value, "repaymentCollectionCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionCapitalNotEqualTo(BigDecimal value) {
            addCriterion("repayment_collection_capital <>", value, "repaymentCollectionCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionCapitalGreaterThan(BigDecimal value) {
            addCriterion("repayment_collection_capital >", value, "repaymentCollectionCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionCapitalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("repayment_collection_capital >=", value, "repaymentCollectionCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionCapitalLessThan(BigDecimal value) {
            addCriterion("repayment_collection_capital <", value, "repaymentCollectionCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionCapitalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("repayment_collection_capital <=", value, "repaymentCollectionCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionCapitalIn(List<BigDecimal> values) {
            addCriterion("repayment_collection_capital in", values, "repaymentCollectionCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionCapitalNotIn(List<BigDecimal> values) {
            addCriterion("repayment_collection_capital not in", values, "repaymentCollectionCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionCapitalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayment_collection_capital between", value1, value2, "repaymentCollectionCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionCapitalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayment_collection_capital not between", value1, value2, "repaymentCollectionCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionInterestIsNull() {
            addCriterion("repayment_collection_interest is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionInterestIsNotNull() {
            addCriterion("repayment_collection_interest is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionInterestEqualTo(BigDecimal value) {
            addCriterion("repayment_collection_interest =", value, "repaymentCollectionInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionInterestNotEqualTo(BigDecimal value) {
            addCriterion("repayment_collection_interest <>", value, "repaymentCollectionInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionInterestGreaterThan(BigDecimal value) {
            addCriterion("repayment_collection_interest >", value, "repaymentCollectionInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionInterestGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("repayment_collection_interest >=", value, "repaymentCollectionInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionInterestLessThan(BigDecimal value) {
            addCriterion("repayment_collection_interest <", value, "repaymentCollectionInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionInterestLessThanOrEqualTo(BigDecimal value) {
            addCriterion("repayment_collection_interest <=", value, "repaymentCollectionInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionInterestIn(List<BigDecimal> values) {
            addCriterion("repayment_collection_interest in", values, "repaymentCollectionInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionInterestNotIn(List<BigDecimal> values) {
            addCriterion("repayment_collection_interest not in", values, "repaymentCollectionInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionInterestBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayment_collection_interest between", value1, value2, "repaymentCollectionInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionInterestNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayment_collection_interest not between", value1, value2, "repaymentCollectionInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAddTimeIsNull() {
            addCriterion("repayment_collection_add_time is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAddTimeIsNotNull() {
            addCriterion("repayment_collection_add_time is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAddTimeEqualTo(Date value) {
            addCriterion("repayment_collection_add_time =", value, "repaymentCollectionAddTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAddTimeNotEqualTo(Date value) {
            addCriterion("repayment_collection_add_time <>", value, "repaymentCollectionAddTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAddTimeGreaterThan(Date value) {
            addCriterion("repayment_collection_add_time >", value, "repaymentCollectionAddTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("repayment_collection_add_time >=", value, "repaymentCollectionAddTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAddTimeLessThan(Date value) {
            addCriterion("repayment_collection_add_time <", value, "repaymentCollectionAddTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("repayment_collection_add_time <=", value, "repaymentCollectionAddTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAddTimeIn(List<Date> values) {
            addCriterion("repayment_collection_add_time in", values, "repaymentCollectionAddTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAddTimeNotIn(List<Date> values) {
            addCriterion("repayment_collection_add_time not in", values, "repaymentCollectionAddTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAddTimeBetween(Date value1, Date value2) {
            addCriterion("repayment_collection_add_time between", value1, value2, "repaymentCollectionAddTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("repayment_collection_add_time not between", value1, value2, "repaymentCollectionAddTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionIncomeIsNull() {
            addCriterion("repayment_collection_income is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionIncomeIsNotNull() {
            addCriterion("repayment_collection_income is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionIncomeEqualTo(BigDecimal value) {
            addCriterion("repayment_collection_income =", value, "repaymentCollectionIncome");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionIncomeNotEqualTo(BigDecimal value) {
            addCriterion("repayment_collection_income <>", value, "repaymentCollectionIncome");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionIncomeGreaterThan(BigDecimal value) {
            addCriterion("repayment_collection_income >", value, "repaymentCollectionIncome");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("repayment_collection_income >=", value, "repaymentCollectionIncome");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionIncomeLessThan(BigDecimal value) {
            addCriterion("repayment_collection_income <", value, "repaymentCollectionIncome");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("repayment_collection_income <=", value, "repaymentCollectionIncome");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionIncomeIn(List<BigDecimal> values) {
            addCriterion("repayment_collection_income in", values, "repaymentCollectionIncome");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionIncomeNotIn(List<BigDecimal> values) {
            addCriterion("repayment_collection_income not in", values, "repaymentCollectionIncome");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayment_collection_income between", value1, value2, "repaymentCollectionIncome");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayment_collection_income not between", value1, value2, "repaymentCollectionIncome");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAuditorIsNull() {
            addCriterion("repayment_collection_auditor is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAuditorIsNotNull() {
            addCriterion("repayment_collection_auditor is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAuditorEqualTo(String value) {
            addCriterion("repayment_collection_auditor =", value, "repaymentCollectionAuditor");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAuditorNotEqualTo(String value) {
            addCriterion("repayment_collection_auditor <>", value, "repaymentCollectionAuditor");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAuditorGreaterThan(String value) {
            addCriterion("repayment_collection_auditor >", value, "repaymentCollectionAuditor");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAuditorGreaterThanOrEqualTo(String value) {
            addCriterion("repayment_collection_auditor >=", value, "repaymentCollectionAuditor");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAuditorLessThan(String value) {
            addCriterion("repayment_collection_auditor <", value, "repaymentCollectionAuditor");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAuditorLessThanOrEqualTo(String value) {
            addCriterion("repayment_collection_auditor <=", value, "repaymentCollectionAuditor");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAuditorLike(String value) {
            addCriterion("repayment_collection_auditor like", value, "repaymentCollectionAuditor");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAuditorNotLike(String value) {
            addCriterion("repayment_collection_auditor not like", value, "repaymentCollectionAuditor");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAuditorIn(List<String> values) {
            addCriterion("repayment_collection_auditor in", values, "repaymentCollectionAuditor");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAuditorNotIn(List<String> values) {
            addCriterion("repayment_collection_auditor not in", values, "repaymentCollectionAuditor");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAuditorBetween(String value1, String value2) {
            addCriterion("repayment_collection_auditor between", value1, value2, "repaymentCollectionAuditor");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionAuditorNotBetween(String value1, String value2) {
            addCriterion("repayment_collection_auditor not between", value1, value2, "repaymentCollectionAuditor");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionInstitutionCodeIsNull() {
            addCriterion("repayment_collection_Institution_code is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionInstitutionCodeIsNotNull() {
            addCriterion("repayment_collection_Institution_code is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionInstitutionCodeEqualTo(String value) {
            addCriterion("repayment_collection_Institution_code =", value, "repaymentCollectionInstitutionCode");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionInstitutionCodeNotEqualTo(String value) {
            addCriterion("repayment_collection_Institution_code <>", value, "repaymentCollectionInstitutionCode");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionInstitutionCodeGreaterThan(String value) {
            addCriterion("repayment_collection_Institution_code >", value, "repaymentCollectionInstitutionCode");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionInstitutionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("repayment_collection_Institution_code >=", value, "repaymentCollectionInstitutionCode");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionInstitutionCodeLessThan(String value) {
            addCriterion("repayment_collection_Institution_code <", value, "repaymentCollectionInstitutionCode");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionInstitutionCodeLessThanOrEqualTo(String value) {
            addCriterion("repayment_collection_Institution_code <=", value, "repaymentCollectionInstitutionCode");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionInstitutionCodeLike(String value) {
            addCriterion("repayment_collection_Institution_code like", value, "repaymentCollectionInstitutionCode");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionInstitutionCodeNotLike(String value) {
            addCriterion("repayment_collection_Institution_code not like", value, "repaymentCollectionInstitutionCode");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionInstitutionCodeIn(List<String> values) {
            addCriterion("repayment_collection_Institution_code in", values, "repaymentCollectionInstitutionCode");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionInstitutionCodeNotIn(List<String> values) {
            addCriterion("repayment_collection_Institution_code not in", values, "repaymentCollectionInstitutionCode");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionInstitutionCodeBetween(String value1, String value2) {
            addCriterion("repayment_collection_Institution_code between", value1, value2, "repaymentCollectionInstitutionCode");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionInstitutionCodeNotBetween(String value1, String value2) {
            addCriterion("repayment_collection_Institution_code not between", value1, value2, "repaymentCollectionInstitutionCode");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionStatusIsNull() {
            addCriterion("repayment_collection_status is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionStatusIsNotNull() {
            addCriterion("repayment_collection_status is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionStatusEqualTo(Integer value) {
            addCriterion("repayment_collection_status =", value, "repaymentCollectionStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionStatusNotEqualTo(Integer value) {
            addCriterion("repayment_collection_status <>", value, "repaymentCollectionStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionStatusGreaterThan(Integer value) {
            addCriterion("repayment_collection_status >", value, "repaymentCollectionStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("repayment_collection_status >=", value, "repaymentCollectionStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionStatusLessThan(Integer value) {
            addCriterion("repayment_collection_status <", value, "repaymentCollectionStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionStatusLessThanOrEqualTo(Integer value) {
            addCriterion("repayment_collection_status <=", value, "repaymentCollectionStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionStatusIn(List<Integer> values) {
            addCriterion("repayment_collection_status in", values, "repaymentCollectionStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionStatusNotIn(List<Integer> values) {
            addCriterion("repayment_collection_status not in", values, "repaymentCollectionStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionStatusBetween(Integer value1, Integer value2) {
            addCriterion("repayment_collection_status between", value1, value2, "repaymentCollectionStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentCollectionStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("repayment_collection_status not between", value1, value2, "repaymentCollectionStatus");
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
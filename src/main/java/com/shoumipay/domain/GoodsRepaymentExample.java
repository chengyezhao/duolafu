package com.shoumipay.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsRepaymentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsRepaymentExample() {
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

        public Criteria andRepaymentTimesIsNull() {
            addCriterion("repayment_times is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimesIsNotNull() {
            addCriterion("repayment_times is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimesEqualTo(Integer value) {
            addCriterion("repayment_times =", value, "repaymentTimes");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimesNotEqualTo(Integer value) {
            addCriterion("repayment_times <>", value, "repaymentTimes");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimesGreaterThan(Integer value) {
            addCriterion("repayment_times >", value, "repaymentTimes");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("repayment_times >=", value, "repaymentTimes");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimesLessThan(Integer value) {
            addCriterion("repayment_times <", value, "repaymentTimes");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimesLessThanOrEqualTo(Integer value) {
            addCriterion("repayment_times <=", value, "repaymentTimes");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimesIn(List<Integer> values) {
            addCriterion("repayment_times in", values, "repaymentTimes");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimesNotIn(List<Integer> values) {
            addCriterion("repayment_times not in", values, "repaymentTimes");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimesBetween(Integer value1, Integer value2) {
            addCriterion("repayment_times between", value1, value2, "repaymentTimes");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("repayment_times not between", value1, value2, "repaymentTimes");
            return (Criteria) this;
        }

        public Criteria andRepaymentAmountIsNull() {
            addCriterion("repayment_amount is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentAmountIsNotNull() {
            addCriterion("repayment_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentAmountEqualTo(BigDecimal value) {
            addCriterion("repayment_amount =", value, "repaymentAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentAmountNotEqualTo(BigDecimal value) {
            addCriterion("repayment_amount <>", value, "repaymentAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentAmountGreaterThan(BigDecimal value) {
            addCriterion("repayment_amount >", value, "repaymentAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("repayment_amount >=", value, "repaymentAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentAmountLessThan(BigDecimal value) {
            addCriterion("repayment_amount <", value, "repaymentAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("repayment_amount <=", value, "repaymentAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentAmountIn(List<BigDecimal> values) {
            addCriterion("repayment_amount in", values, "repaymentAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentAmountNotIn(List<BigDecimal> values) {
            addCriterion("repayment_amount not in", values, "repaymentAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayment_amount between", value1, value2, "repaymentAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayment_amount not between", value1, value2, "repaymentAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentCostIsNull() {
            addCriterion("repayment_cost is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCostIsNotNull() {
            addCriterion("repayment_cost is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCostEqualTo(BigDecimal value) {
            addCriterion("repayment_cost =", value, "repaymentCost");
            return (Criteria) this;
        }

        public Criteria andRepaymentCostNotEqualTo(BigDecimal value) {
            addCriterion("repayment_cost <>", value, "repaymentCost");
            return (Criteria) this;
        }

        public Criteria andRepaymentCostGreaterThan(BigDecimal value) {
            addCriterion("repayment_cost >", value, "repaymentCost");
            return (Criteria) this;
        }

        public Criteria andRepaymentCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("repayment_cost >=", value, "repaymentCost");
            return (Criteria) this;
        }

        public Criteria andRepaymentCostLessThan(BigDecimal value) {
            addCriterion("repayment_cost <", value, "repaymentCost");
            return (Criteria) this;
        }

        public Criteria andRepaymentCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("repayment_cost <=", value, "repaymentCost");
            return (Criteria) this;
        }

        public Criteria andRepaymentCostIn(List<BigDecimal> values) {
            addCriterion("repayment_cost in", values, "repaymentCost");
            return (Criteria) this;
        }

        public Criteria andRepaymentCostNotIn(List<BigDecimal> values) {
            addCriterion("repayment_cost not in", values, "repaymentCost");
            return (Criteria) this;
        }

        public Criteria andRepaymentCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayment_cost between", value1, value2, "repaymentCost");
            return (Criteria) this;
        }

        public Criteria andRepaymentCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayment_cost not between", value1, value2, "repaymentCost");
            return (Criteria) this;
        }

        public Criteria andRepaymentCapitalIsNull() {
            addCriterion("repayment_capital is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCapitalIsNotNull() {
            addCriterion("repayment_capital is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCapitalEqualTo(BigDecimal value) {
            addCriterion("repayment_capital =", value, "repaymentCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentCapitalNotEqualTo(BigDecimal value) {
            addCriterion("repayment_capital <>", value, "repaymentCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentCapitalGreaterThan(BigDecimal value) {
            addCriterion("repayment_capital >", value, "repaymentCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentCapitalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("repayment_capital >=", value, "repaymentCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentCapitalLessThan(BigDecimal value) {
            addCriterion("repayment_capital <", value, "repaymentCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentCapitalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("repayment_capital <=", value, "repaymentCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentCapitalIn(List<BigDecimal> values) {
            addCriterion("repayment_capital in", values, "repaymentCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentCapitalNotIn(List<BigDecimal> values) {
            addCriterion("repayment_capital not in", values, "repaymentCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentCapitalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayment_capital between", value1, value2, "repaymentCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentCapitalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayment_capital not between", value1, value2, "repaymentCapital");
            return (Criteria) this;
        }

        public Criteria andRepaymentInterestIsNull() {
            addCriterion("repayment_interest is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentInterestIsNotNull() {
            addCriterion("repayment_interest is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentInterestEqualTo(BigDecimal value) {
            addCriterion("repayment_interest =", value, "repaymentInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentInterestNotEqualTo(BigDecimal value) {
            addCriterion("repayment_interest <>", value, "repaymentInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentInterestGreaterThan(BigDecimal value) {
            addCriterion("repayment_interest >", value, "repaymentInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentInterestGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("repayment_interest >=", value, "repaymentInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentInterestLessThan(BigDecimal value) {
            addCriterion("repayment_interest <", value, "repaymentInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentInterestLessThanOrEqualTo(BigDecimal value) {
            addCriterion("repayment_interest <=", value, "repaymentInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentInterestIn(List<BigDecimal> values) {
            addCriterion("repayment_interest in", values, "repaymentInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentInterestNotIn(List<BigDecimal> values) {
            addCriterion("repayment_interest not in", values, "repaymentInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentInterestBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayment_interest between", value1, value2, "repaymentInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentInterestNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayment_interest not between", value1, value2, "repaymentInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentDefaultInterestIsNull() {
            addCriterion("repayment_default_interest is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentDefaultInterestIsNotNull() {
            addCriterion("repayment_default_interest is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentDefaultInterestEqualTo(BigDecimal value) {
            addCriterion("repayment_default_interest =", value, "repaymentDefaultInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentDefaultInterestNotEqualTo(BigDecimal value) {
            addCriterion("repayment_default_interest <>", value, "repaymentDefaultInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentDefaultInterestGreaterThan(BigDecimal value) {
            addCriterion("repayment_default_interest >", value, "repaymentDefaultInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentDefaultInterestGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("repayment_default_interest >=", value, "repaymentDefaultInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentDefaultInterestLessThan(BigDecimal value) {
            addCriterion("repayment_default_interest <", value, "repaymentDefaultInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentDefaultInterestLessThanOrEqualTo(BigDecimal value) {
            addCriterion("repayment_default_interest <=", value, "repaymentDefaultInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentDefaultInterestIn(List<BigDecimal> values) {
            addCriterion("repayment_default_interest in", values, "repaymentDefaultInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentDefaultInterestNotIn(List<BigDecimal> values) {
            addCriterion("repayment_default_interest not in", values, "repaymentDefaultInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentDefaultInterestBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayment_default_interest between", value1, value2, "repaymentDefaultInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentDefaultInterestNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayment_default_interest not between", value1, value2, "repaymentDefaultInterest");
            return (Criteria) this;
        }

        public Criteria andRepaymentManageCostIsNull() {
            addCriterion("repayment_manage_cost is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentManageCostIsNotNull() {
            addCriterion("repayment_manage_cost is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentManageCostEqualTo(BigDecimal value) {
            addCriterion("repayment_manage_cost =", value, "repaymentManageCost");
            return (Criteria) this;
        }

        public Criteria andRepaymentManageCostNotEqualTo(BigDecimal value) {
            addCriterion("repayment_manage_cost <>", value, "repaymentManageCost");
            return (Criteria) this;
        }

        public Criteria andRepaymentManageCostGreaterThan(BigDecimal value) {
            addCriterion("repayment_manage_cost >", value, "repaymentManageCost");
            return (Criteria) this;
        }

        public Criteria andRepaymentManageCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("repayment_manage_cost >=", value, "repaymentManageCost");
            return (Criteria) this;
        }

        public Criteria andRepaymentManageCostLessThan(BigDecimal value) {
            addCriterion("repayment_manage_cost <", value, "repaymentManageCost");
            return (Criteria) this;
        }

        public Criteria andRepaymentManageCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("repayment_manage_cost <=", value, "repaymentManageCost");
            return (Criteria) this;
        }

        public Criteria andRepaymentManageCostIn(List<BigDecimal> values) {
            addCriterion("repayment_manage_cost in", values, "repaymentManageCost");
            return (Criteria) this;
        }

        public Criteria andRepaymentManageCostNotIn(List<BigDecimal> values) {
            addCriterion("repayment_manage_cost not in", values, "repaymentManageCost");
            return (Criteria) this;
        }

        public Criteria andRepaymentManageCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayment_manage_cost between", value1, value2, "repaymentManageCost");
            return (Criteria) this;
        }

        public Criteria andRepaymentManageCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayment_manage_cost not between", value1, value2, "repaymentManageCost");
            return (Criteria) this;
        }

        public Criteria andRealAmountIsNull() {
            addCriterion("real_amount is null");
            return (Criteria) this;
        }

        public Criteria andRealAmountIsNotNull() {
            addCriterion("real_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRealAmountEqualTo(BigDecimal value) {
            addCriterion("real_amount =", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountNotEqualTo(BigDecimal value) {
            addCriterion("real_amount <>", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountGreaterThan(BigDecimal value) {
            addCriterion("real_amount >", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("real_amount >=", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountLessThan(BigDecimal value) {
            addCriterion("real_amount <", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("real_amount <=", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountIn(List<BigDecimal> values) {
            addCriterion("real_amount in", values, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountNotIn(List<BigDecimal> values) {
            addCriterion("real_amount not in", values, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_amount between", value1, value2, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_amount not between", value1, value2, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealCostIsNull() {
            addCriterion("real_cost is null");
            return (Criteria) this;
        }

        public Criteria andRealCostIsNotNull() {
            addCriterion("real_cost is not null");
            return (Criteria) this;
        }

        public Criteria andRealCostEqualTo(BigDecimal value) {
            addCriterion("real_cost =", value, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCostNotEqualTo(BigDecimal value) {
            addCriterion("real_cost <>", value, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCostGreaterThan(BigDecimal value) {
            addCriterion("real_cost >", value, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("real_cost >=", value, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCostLessThan(BigDecimal value) {
            addCriterion("real_cost <", value, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("real_cost <=", value, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCostIn(List<BigDecimal> values) {
            addCriterion("real_cost in", values, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCostNotIn(List<BigDecimal> values) {
            addCriterion("real_cost not in", values, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_cost between", value1, value2, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_cost not between", value1, value2, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCapitalIsNull() {
            addCriterion("real_capital is null");
            return (Criteria) this;
        }

        public Criteria andRealCapitalIsNotNull() {
            addCriterion("real_capital is not null");
            return (Criteria) this;
        }

        public Criteria andRealCapitalEqualTo(BigDecimal value) {
            addCriterion("real_capital =", value, "realCapital");
            return (Criteria) this;
        }

        public Criteria andRealCapitalNotEqualTo(BigDecimal value) {
            addCriterion("real_capital <>", value, "realCapital");
            return (Criteria) this;
        }

        public Criteria andRealCapitalGreaterThan(BigDecimal value) {
            addCriterion("real_capital >", value, "realCapital");
            return (Criteria) this;
        }

        public Criteria andRealCapitalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("real_capital >=", value, "realCapital");
            return (Criteria) this;
        }

        public Criteria andRealCapitalLessThan(BigDecimal value) {
            addCriterion("real_capital <", value, "realCapital");
            return (Criteria) this;
        }

        public Criteria andRealCapitalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("real_capital <=", value, "realCapital");
            return (Criteria) this;
        }

        public Criteria andRealCapitalIn(List<BigDecimal> values) {
            addCriterion("real_capital in", values, "realCapital");
            return (Criteria) this;
        }

        public Criteria andRealCapitalNotIn(List<BigDecimal> values) {
            addCriterion("real_capital not in", values, "realCapital");
            return (Criteria) this;
        }

        public Criteria andRealCapitalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_capital between", value1, value2, "realCapital");
            return (Criteria) this;
        }

        public Criteria andRealCapitalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_capital not between", value1, value2, "realCapital");
            return (Criteria) this;
        }

        public Criteria andRealInterestIsNull() {
            addCriterion("real_interest is null");
            return (Criteria) this;
        }

        public Criteria andRealInterestIsNotNull() {
            addCriterion("real_interest is not null");
            return (Criteria) this;
        }

        public Criteria andRealInterestEqualTo(BigDecimal value) {
            addCriterion("real_interest =", value, "realInterest");
            return (Criteria) this;
        }

        public Criteria andRealInterestNotEqualTo(BigDecimal value) {
            addCriterion("real_interest <>", value, "realInterest");
            return (Criteria) this;
        }

        public Criteria andRealInterestGreaterThan(BigDecimal value) {
            addCriterion("real_interest >", value, "realInterest");
            return (Criteria) this;
        }

        public Criteria andRealInterestGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("real_interest >=", value, "realInterest");
            return (Criteria) this;
        }

        public Criteria andRealInterestLessThan(BigDecimal value) {
            addCriterion("real_interest <", value, "realInterest");
            return (Criteria) this;
        }

        public Criteria andRealInterestLessThanOrEqualTo(BigDecimal value) {
            addCriterion("real_interest <=", value, "realInterest");
            return (Criteria) this;
        }

        public Criteria andRealInterestIn(List<BigDecimal> values) {
            addCriterion("real_interest in", values, "realInterest");
            return (Criteria) this;
        }

        public Criteria andRealInterestNotIn(List<BigDecimal> values) {
            addCriterion("real_interest not in", values, "realInterest");
            return (Criteria) this;
        }

        public Criteria andRealInterestBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_interest between", value1, value2, "realInterest");
            return (Criteria) this;
        }

        public Criteria andRealInterestNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_interest not between", value1, value2, "realInterest");
            return (Criteria) this;
        }

        public Criteria andRealDefaultInterestIsNull() {
            addCriterion("real_default_interest is null");
            return (Criteria) this;
        }

        public Criteria andRealDefaultInterestIsNotNull() {
            addCriterion("real_default_interest is not null");
            return (Criteria) this;
        }

        public Criteria andRealDefaultInterestEqualTo(BigDecimal value) {
            addCriterion("real_default_interest =", value, "realDefaultInterest");
            return (Criteria) this;
        }

        public Criteria andRealDefaultInterestNotEqualTo(BigDecimal value) {
            addCriterion("real_default_interest <>", value, "realDefaultInterest");
            return (Criteria) this;
        }

        public Criteria andRealDefaultInterestGreaterThan(BigDecimal value) {
            addCriterion("real_default_interest >", value, "realDefaultInterest");
            return (Criteria) this;
        }

        public Criteria andRealDefaultInterestGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("real_default_interest >=", value, "realDefaultInterest");
            return (Criteria) this;
        }

        public Criteria andRealDefaultInterestLessThan(BigDecimal value) {
            addCriterion("real_default_interest <", value, "realDefaultInterest");
            return (Criteria) this;
        }

        public Criteria andRealDefaultInterestLessThanOrEqualTo(BigDecimal value) {
            addCriterion("real_default_interest <=", value, "realDefaultInterest");
            return (Criteria) this;
        }

        public Criteria andRealDefaultInterestIn(List<BigDecimal> values) {
            addCriterion("real_default_interest in", values, "realDefaultInterest");
            return (Criteria) this;
        }

        public Criteria andRealDefaultInterestNotIn(List<BigDecimal> values) {
            addCriterion("real_default_interest not in", values, "realDefaultInterest");
            return (Criteria) this;
        }

        public Criteria andRealDefaultInterestBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_default_interest between", value1, value2, "realDefaultInterest");
            return (Criteria) this;
        }

        public Criteria andRealDefaultInterestNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_default_interest not between", value1, value2, "realDefaultInterest");
            return (Criteria) this;
        }

        public Criteria andRealManageCostIsNull() {
            addCriterion("real_manage_cost is null");
            return (Criteria) this;
        }

        public Criteria andRealManageCostIsNotNull() {
            addCriterion("real_manage_cost is not null");
            return (Criteria) this;
        }

        public Criteria andRealManageCostEqualTo(BigDecimal value) {
            addCriterion("real_manage_cost =", value, "realManageCost");
            return (Criteria) this;
        }

        public Criteria andRealManageCostNotEqualTo(BigDecimal value) {
            addCriterion("real_manage_cost <>", value, "realManageCost");
            return (Criteria) this;
        }

        public Criteria andRealManageCostGreaterThan(BigDecimal value) {
            addCriterion("real_manage_cost >", value, "realManageCost");
            return (Criteria) this;
        }

        public Criteria andRealManageCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("real_manage_cost >=", value, "realManageCost");
            return (Criteria) this;
        }

        public Criteria andRealManageCostLessThan(BigDecimal value) {
            addCriterion("real_manage_cost <", value, "realManageCost");
            return (Criteria) this;
        }

        public Criteria andRealManageCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("real_manage_cost <=", value, "realManageCost");
            return (Criteria) this;
        }

        public Criteria andRealManageCostIn(List<BigDecimal> values) {
            addCriterion("real_manage_cost in", values, "realManageCost");
            return (Criteria) this;
        }

        public Criteria andRealManageCostNotIn(List<BigDecimal> values) {
            addCriterion("real_manage_cost not in", values, "realManageCost");
            return (Criteria) this;
        }

        public Criteria andRealManageCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_manage_cost between", value1, value2, "realManageCost");
            return (Criteria) this;
        }

        public Criteria andRealManageCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_manage_cost not between", value1, value2, "realManageCost");
            return (Criteria) this;
        }

        public Criteria andRepaymentStatusIsNull() {
            addCriterion("repayment_status is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentStatusIsNotNull() {
            addCriterion("repayment_status is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentStatusEqualTo(Integer value) {
            addCriterion("repayment_status =", value, "repaymentStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentStatusNotEqualTo(Integer value) {
            addCriterion("repayment_status <>", value, "repaymentStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentStatusGreaterThan(Integer value) {
            addCriterion("repayment_status >", value, "repaymentStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("repayment_status >=", value, "repaymentStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentStatusLessThan(Integer value) {
            addCriterion("repayment_status <", value, "repaymentStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentStatusLessThanOrEqualTo(Integer value) {
            addCriterion("repayment_status <=", value, "repaymentStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentStatusIn(List<Integer> values) {
            addCriterion("repayment_status in", values, "repaymentStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentStatusNotIn(List<Integer> values) {
            addCriterion("repayment_status not in", values, "repaymentStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentStatusBetween(Integer value1, Integer value2) {
            addCriterion("repayment_status between", value1, value2, "repaymentStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("repayment_status not between", value1, value2, "repaymentStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeIsNull() {
            addCriterion("repayment_type is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeIsNotNull() {
            addCriterion("repayment_type is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeEqualTo(Integer value) {
            addCriterion("repayment_type =", value, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeNotEqualTo(Integer value) {
            addCriterion("repayment_type <>", value, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeGreaterThan(Integer value) {
            addCriterion("repayment_type >", value, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("repayment_type >=", value, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeLessThan(Integer value) {
            addCriterion("repayment_type <", value, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeLessThanOrEqualTo(Integer value) {
            addCriterion("repayment_type <=", value, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeIn(List<Integer> values) {
            addCriterion("repayment_type in", values, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeNotIn(List<Integer> values) {
            addCriterion("repayment_type not in", values, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeBetween(Integer value1, Integer value2) {
            addCriterion("repayment_type between", value1, value2, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("repayment_type not between", value1, value2, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentCardidIsNull() {
            addCriterion("repayment_cardId is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCardidIsNotNull() {
            addCriterion("repayment_cardId is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCardidEqualTo(Long value) {
            addCriterion("repayment_cardId =", value, "repaymentCardid");
            return (Criteria) this;
        }

        public Criteria andRepaymentCardidNotEqualTo(Long value) {
            addCriterion("repayment_cardId <>", value, "repaymentCardid");
            return (Criteria) this;
        }

        public Criteria andRepaymentCardidGreaterThan(Long value) {
            addCriterion("repayment_cardId >", value, "repaymentCardid");
            return (Criteria) this;
        }

        public Criteria andRepaymentCardidGreaterThanOrEqualTo(Long value) {
            addCriterion("repayment_cardId >=", value, "repaymentCardid");
            return (Criteria) this;
        }

        public Criteria andRepaymentCardidLessThan(Long value) {
            addCriterion("repayment_cardId <", value, "repaymentCardid");
            return (Criteria) this;
        }

        public Criteria andRepaymentCardidLessThanOrEqualTo(Long value) {
            addCriterion("repayment_cardId <=", value, "repaymentCardid");
            return (Criteria) this;
        }

        public Criteria andRepaymentCardidIn(List<Long> values) {
            addCriterion("repayment_cardId in", values, "repaymentCardid");
            return (Criteria) this;
        }

        public Criteria andRepaymentCardidNotIn(List<Long> values) {
            addCriterion("repayment_cardId not in", values, "repaymentCardid");
            return (Criteria) this;
        }

        public Criteria andRepaymentCardidBetween(Long value1, Long value2) {
            addCriterion("repayment_cardId between", value1, value2, "repaymentCardid");
            return (Criteria) this;
        }

        public Criteria andRepaymentCardidNotBetween(Long value1, Long value2) {
            addCriterion("repayment_cardId not between", value1, value2, "repaymentCardid");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimeIsNull() {
            addCriterion("repayment_time is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimeIsNotNull() {
            addCriterion("repayment_time is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimeEqualTo(Date value) {
            addCriterion("repayment_time =", value, "repaymentTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimeNotEqualTo(Date value) {
            addCriterion("repayment_time <>", value, "repaymentTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimeGreaterThan(Date value) {
            addCriterion("repayment_time >", value, "repaymentTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("repayment_time >=", value, "repaymentTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimeLessThan(Date value) {
            addCriterion("repayment_time <", value, "repaymentTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimeLessThanOrEqualTo(Date value) {
            addCriterion("repayment_time <=", value, "repaymentTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimeIn(List<Date> values) {
            addCriterion("repayment_time in", values, "repaymentTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimeNotIn(List<Date> values) {
            addCriterion("repayment_time not in", values, "repaymentTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimeBetween(Date value1, Date value2) {
            addCriterion("repayment_time between", value1, value2, "repaymentTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimeNotBetween(Date value1, Date value2) {
            addCriterion("repayment_time not between", value1, value2, "repaymentTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentNumberIsNull() {
            addCriterion("repayment_number is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentNumberIsNotNull() {
            addCriterion("repayment_number is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentNumberEqualTo(String value) {
            addCriterion("repayment_number =", value, "repaymentNumber");
            return (Criteria) this;
        }

        public Criteria andRepaymentNumberNotEqualTo(String value) {
            addCriterion("repayment_number <>", value, "repaymentNumber");
            return (Criteria) this;
        }

        public Criteria andRepaymentNumberGreaterThan(String value) {
            addCriterion("repayment_number >", value, "repaymentNumber");
            return (Criteria) this;
        }

        public Criteria andRepaymentNumberGreaterThanOrEqualTo(String value) {
            addCriterion("repayment_number >=", value, "repaymentNumber");
            return (Criteria) this;
        }

        public Criteria andRepaymentNumberLessThan(String value) {
            addCriterion("repayment_number <", value, "repaymentNumber");
            return (Criteria) this;
        }

        public Criteria andRepaymentNumberLessThanOrEqualTo(String value) {
            addCriterion("repayment_number <=", value, "repaymentNumber");
            return (Criteria) this;
        }

        public Criteria andRepaymentNumberLike(String value) {
            addCriterion("repayment_number like", value, "repaymentNumber");
            return (Criteria) this;
        }

        public Criteria andRepaymentNumberNotLike(String value) {
            addCriterion("repayment_number not like", value, "repaymentNumber");
            return (Criteria) this;
        }

        public Criteria andRepaymentNumberIn(List<String> values) {
            addCriterion("repayment_number in", values, "repaymentNumber");
            return (Criteria) this;
        }

        public Criteria andRepaymentNumberNotIn(List<String> values) {
            addCriterion("repayment_number not in", values, "repaymentNumber");
            return (Criteria) this;
        }

        public Criteria andRepaymentNumberBetween(String value1, String value2) {
            addCriterion("repayment_number between", value1, value2, "repaymentNumber");
            return (Criteria) this;
        }

        public Criteria andRepaymentNumberNotBetween(String value1, String value2) {
            addCriterion("repayment_number not between", value1, value2, "repaymentNumber");
            return (Criteria) this;
        }

        public Criteria andActiveIsNull() {
            addCriterion("active is null");
            return (Criteria) this;
        }

        public Criteria andActiveIsNotNull() {
            addCriterion("active is not null");
            return (Criteria) this;
        }

        public Criteria andActiveEqualTo(Integer value) {
            addCriterion("active =", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotEqualTo(Integer value) {
            addCriterion("active <>", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThan(Integer value) {
            addCriterion("active >", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("active >=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThan(Integer value) {
            addCriterion("active <", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThanOrEqualTo(Integer value) {
            addCriterion("active <=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveIn(List<Integer> values) {
            addCriterion("active in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotIn(List<Integer> values) {
            addCriterion("active not in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveBetween(Integer value1, Integer value2) {
            addCriterion("active between", value1, value2, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotBetween(Integer value1, Integer value2) {
            addCriterion("active not between", value1, value2, "active");
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
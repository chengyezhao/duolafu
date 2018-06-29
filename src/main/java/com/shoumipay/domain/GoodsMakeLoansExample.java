package com.shoumipay.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsMakeLoansExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsMakeLoansExample() {
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

        public Criteria andMakeLoansCreateTimeIsNull() {
            addCriterion("make_Loans_create_time is null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCreateTimeIsNotNull() {
            addCriterion("make_Loans_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCreateTimeEqualTo(Date value) {
            addCriterion("make_Loans_create_time =", value, "makeLoansCreateTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCreateTimeNotEqualTo(Date value) {
            addCriterion("make_Loans_create_time <>", value, "makeLoansCreateTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCreateTimeGreaterThan(Date value) {
            addCriterion("make_Loans_create_time >", value, "makeLoansCreateTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("make_Loans_create_time >=", value, "makeLoansCreateTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCreateTimeLessThan(Date value) {
            addCriterion("make_Loans_create_time <", value, "makeLoansCreateTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("make_Loans_create_time <=", value, "makeLoansCreateTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCreateTimeIn(List<Date> values) {
            addCriterion("make_Loans_create_time in", values, "makeLoansCreateTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCreateTimeNotIn(List<Date> values) {
            addCriterion("make_Loans_create_time not in", values, "makeLoansCreateTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCreateTimeBetween(Date value1, Date value2) {
            addCriterion("make_Loans_create_time between", value1, value2, "makeLoansCreateTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("make_Loans_create_time not between", value1, value2, "makeLoansCreateTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansAmountIsNull() {
            addCriterion("make_Loans_amount is null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansAmountIsNotNull() {
            addCriterion("make_Loans_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansAmountEqualTo(BigDecimal value) {
            addCriterion("make_Loans_amount =", value, "makeLoansAmount");
            return (Criteria) this;
        }

        public Criteria andMakeLoansAmountNotEqualTo(BigDecimal value) {
            addCriterion("make_Loans_amount <>", value, "makeLoansAmount");
            return (Criteria) this;
        }

        public Criteria andMakeLoansAmountGreaterThan(BigDecimal value) {
            addCriterion("make_Loans_amount >", value, "makeLoansAmount");
            return (Criteria) this;
        }

        public Criteria andMakeLoansAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("make_Loans_amount >=", value, "makeLoansAmount");
            return (Criteria) this;
        }

        public Criteria andMakeLoansAmountLessThan(BigDecimal value) {
            addCriterion("make_Loans_amount <", value, "makeLoansAmount");
            return (Criteria) this;
        }

        public Criteria andMakeLoansAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("make_Loans_amount <=", value, "makeLoansAmount");
            return (Criteria) this;
        }

        public Criteria andMakeLoansAmountIn(List<BigDecimal> values) {
            addCriterion("make_Loans_amount in", values, "makeLoansAmount");
            return (Criteria) this;
        }

        public Criteria andMakeLoansAmountNotIn(List<BigDecimal> values) {
            addCriterion("make_Loans_amount not in", values, "makeLoansAmount");
            return (Criteria) this;
        }

        public Criteria andMakeLoansAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("make_Loans_amount between", value1, value2, "makeLoansAmount");
            return (Criteria) this;
        }

        public Criteria andMakeLoansAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("make_Loans_amount not between", value1, value2, "makeLoansAmount");
            return (Criteria) this;
        }

        public Criteria andMakeLoansExpirationTimeIsNull() {
            addCriterion("make_Loans_expiration_time is null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansExpirationTimeIsNotNull() {
            addCriterion("make_Loans_expiration_time is not null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansExpirationTimeEqualTo(Date value) {
            addCriterion("make_Loans_expiration_time =", value, "makeLoansExpirationTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansExpirationTimeNotEqualTo(Date value) {
            addCriterion("make_Loans_expiration_time <>", value, "makeLoansExpirationTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansExpirationTimeGreaterThan(Date value) {
            addCriterion("make_Loans_expiration_time >", value, "makeLoansExpirationTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansExpirationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("make_Loans_expiration_time >=", value, "makeLoansExpirationTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansExpirationTimeLessThan(Date value) {
            addCriterion("make_Loans_expiration_time <", value, "makeLoansExpirationTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansExpirationTimeLessThanOrEqualTo(Date value) {
            addCriterion("make_Loans_expiration_time <=", value, "makeLoansExpirationTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansExpirationTimeIn(List<Date> values) {
            addCriterion("make_Loans_expiration_time in", values, "makeLoansExpirationTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansExpirationTimeNotIn(List<Date> values) {
            addCriterion("make_Loans_expiration_time not in", values, "makeLoansExpirationTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansExpirationTimeBetween(Date value1, Date value2) {
            addCriterion("make_Loans_expiration_time between", value1, value2, "makeLoansExpirationTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansExpirationTimeNotBetween(Date value1, Date value2) {
            addCriterion("make_Loans_expiration_time not between", value1, value2, "makeLoansExpirationTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansClosingTimeIsNull() {
            addCriterion("make_Loans_Closing_time is null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansClosingTimeIsNotNull() {
            addCriterion("make_Loans_Closing_time is not null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansClosingTimeEqualTo(Date value) {
            addCriterion("make_Loans_Closing_time =", value, "makeLoansClosingTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansClosingTimeNotEqualTo(Date value) {
            addCriterion("make_Loans_Closing_time <>", value, "makeLoansClosingTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansClosingTimeGreaterThan(Date value) {
            addCriterion("make_Loans_Closing_time >", value, "makeLoansClosingTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansClosingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("make_Loans_Closing_time >=", value, "makeLoansClosingTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansClosingTimeLessThan(Date value) {
            addCriterion("make_Loans_Closing_time <", value, "makeLoansClosingTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansClosingTimeLessThanOrEqualTo(Date value) {
            addCriterion("make_Loans_Closing_time <=", value, "makeLoansClosingTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansClosingTimeIn(List<Date> values) {
            addCriterion("make_Loans_Closing_time in", values, "makeLoansClosingTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansClosingTimeNotIn(List<Date> values) {
            addCriterion("make_Loans_Closing_time not in", values, "makeLoansClosingTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansClosingTimeBetween(Date value1, Date value2) {
            addCriterion("make_Loans_Closing_time between", value1, value2, "makeLoansClosingTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansClosingTimeNotBetween(Date value1, Date value2) {
            addCriterion("make_Loans_Closing_time not between", value1, value2, "makeLoansClosingTime");
            return (Criteria) this;
        }

        public Criteria andMakeLoansTimeLimitIsNull() {
            addCriterion("make_Loans_time_limit is null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansTimeLimitIsNotNull() {
            addCriterion("make_Loans_time_limit is not null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansTimeLimitEqualTo(Integer value) {
            addCriterion("make_Loans_time_limit =", value, "makeLoansTimeLimit");
            return (Criteria) this;
        }

        public Criteria andMakeLoansTimeLimitNotEqualTo(Integer value) {
            addCriterion("make_Loans_time_limit <>", value, "makeLoansTimeLimit");
            return (Criteria) this;
        }

        public Criteria andMakeLoansTimeLimitGreaterThan(Integer value) {
            addCriterion("make_Loans_time_limit >", value, "makeLoansTimeLimit");
            return (Criteria) this;
        }

        public Criteria andMakeLoansTimeLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("make_Loans_time_limit >=", value, "makeLoansTimeLimit");
            return (Criteria) this;
        }

        public Criteria andMakeLoansTimeLimitLessThan(Integer value) {
            addCriterion("make_Loans_time_limit <", value, "makeLoansTimeLimit");
            return (Criteria) this;
        }

        public Criteria andMakeLoansTimeLimitLessThanOrEqualTo(Integer value) {
            addCriterion("make_Loans_time_limit <=", value, "makeLoansTimeLimit");
            return (Criteria) this;
        }

        public Criteria andMakeLoansTimeLimitIn(List<Integer> values) {
            addCriterion("make_Loans_time_limit in", values, "makeLoansTimeLimit");
            return (Criteria) this;
        }

        public Criteria andMakeLoansTimeLimitNotIn(List<Integer> values) {
            addCriterion("make_Loans_time_limit not in", values, "makeLoansTimeLimit");
            return (Criteria) this;
        }

        public Criteria andMakeLoansTimeLimitBetween(Integer value1, Integer value2) {
            addCriterion("make_Loans_time_limit between", value1, value2, "makeLoansTimeLimit");
            return (Criteria) this;
        }

        public Criteria andMakeLoansTimeLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("make_Loans_time_limit not between", value1, value2, "makeLoansTimeLimit");
            return (Criteria) this;
        }

        public Criteria andMakeLoansPaymentMethodIsNull() {
            addCriterion("make_Loans_Payment_method is null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansPaymentMethodIsNotNull() {
            addCriterion("make_Loans_Payment_method is not null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansPaymentMethodEqualTo(Integer value) {
            addCriterion("make_Loans_Payment_method =", value, "makeLoansPaymentMethod");
            return (Criteria) this;
        }

        public Criteria andMakeLoansPaymentMethodNotEqualTo(Integer value) {
            addCriterion("make_Loans_Payment_method <>", value, "makeLoansPaymentMethod");
            return (Criteria) this;
        }

        public Criteria andMakeLoansPaymentMethodGreaterThan(Integer value) {
            addCriterion("make_Loans_Payment_method >", value, "makeLoansPaymentMethod");
            return (Criteria) this;
        }

        public Criteria andMakeLoansPaymentMethodGreaterThanOrEqualTo(Integer value) {
            addCriterion("make_Loans_Payment_method >=", value, "makeLoansPaymentMethod");
            return (Criteria) this;
        }

        public Criteria andMakeLoansPaymentMethodLessThan(Integer value) {
            addCriterion("make_Loans_Payment_method <", value, "makeLoansPaymentMethod");
            return (Criteria) this;
        }

        public Criteria andMakeLoansPaymentMethodLessThanOrEqualTo(Integer value) {
            addCriterion("make_Loans_Payment_method <=", value, "makeLoansPaymentMethod");
            return (Criteria) this;
        }

        public Criteria andMakeLoansPaymentMethodIn(List<Integer> values) {
            addCriterion("make_Loans_Payment_method in", values, "makeLoansPaymentMethod");
            return (Criteria) this;
        }

        public Criteria andMakeLoansPaymentMethodNotIn(List<Integer> values) {
            addCriterion("make_Loans_Payment_method not in", values, "makeLoansPaymentMethod");
            return (Criteria) this;
        }

        public Criteria andMakeLoansPaymentMethodBetween(Integer value1, Integer value2) {
            addCriterion("make_Loans_Payment_method between", value1, value2, "makeLoansPaymentMethod");
            return (Criteria) this;
        }

        public Criteria andMakeLoansPaymentMethodNotBetween(Integer value1, Integer value2) {
            addCriterion("make_Loans_Payment_method not between", value1, value2, "makeLoansPaymentMethod");
            return (Criteria) this;
        }

        public Criteria andMakeLoansStatusIsNull() {
            addCriterion("make_Loans_status is null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansStatusIsNotNull() {
            addCriterion("make_Loans_status is not null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansStatusEqualTo(Integer value) {
            addCriterion("make_Loans_status =", value, "makeLoansStatus");
            return (Criteria) this;
        }

        public Criteria andMakeLoansStatusNotEqualTo(Integer value) {
            addCriterion("make_Loans_status <>", value, "makeLoansStatus");
            return (Criteria) this;
        }

        public Criteria andMakeLoansStatusGreaterThan(Integer value) {
            addCriterion("make_Loans_status >", value, "makeLoansStatus");
            return (Criteria) this;
        }

        public Criteria andMakeLoansStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("make_Loans_status >=", value, "makeLoansStatus");
            return (Criteria) this;
        }

        public Criteria andMakeLoansStatusLessThan(Integer value) {
            addCriterion("make_Loans_status <", value, "makeLoansStatus");
            return (Criteria) this;
        }

        public Criteria andMakeLoansStatusLessThanOrEqualTo(Integer value) {
            addCriterion("make_Loans_status <=", value, "makeLoansStatus");
            return (Criteria) this;
        }

        public Criteria andMakeLoansStatusIn(List<Integer> values) {
            addCriterion("make_Loans_status in", values, "makeLoansStatus");
            return (Criteria) this;
        }

        public Criteria andMakeLoansStatusNotIn(List<Integer> values) {
            addCriterion("make_Loans_status not in", values, "makeLoansStatus");
            return (Criteria) this;
        }

        public Criteria andMakeLoansStatusBetween(Integer value1, Integer value2) {
            addCriterion("make_Loans_status between", value1, value2, "makeLoansStatus");
            return (Criteria) this;
        }

        public Criteria andMakeLoansStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("make_Loans_status not between", value1, value2, "makeLoansStatus");
            return (Criteria) this;
        }

        public Criteria andMakeLoansSerialNumberIsNull() {
            addCriterion("make_Loans_serial_number is null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansSerialNumberIsNotNull() {
            addCriterion("make_Loans_serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansSerialNumberEqualTo(String value) {
            addCriterion("make_Loans_serial_number =", value, "makeLoansSerialNumber");
            return (Criteria) this;
        }

        public Criteria andMakeLoansSerialNumberNotEqualTo(String value) {
            addCriterion("make_Loans_serial_number <>", value, "makeLoansSerialNumber");
            return (Criteria) this;
        }

        public Criteria andMakeLoansSerialNumberGreaterThan(String value) {
            addCriterion("make_Loans_serial_number >", value, "makeLoansSerialNumber");
            return (Criteria) this;
        }

        public Criteria andMakeLoansSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("make_Loans_serial_number >=", value, "makeLoansSerialNumber");
            return (Criteria) this;
        }

        public Criteria andMakeLoansSerialNumberLessThan(String value) {
            addCriterion("make_Loans_serial_number <", value, "makeLoansSerialNumber");
            return (Criteria) this;
        }

        public Criteria andMakeLoansSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("make_Loans_serial_number <=", value, "makeLoansSerialNumber");
            return (Criteria) this;
        }

        public Criteria andMakeLoansSerialNumberLike(String value) {
            addCriterion("make_Loans_serial_number like", value, "makeLoansSerialNumber");
            return (Criteria) this;
        }

        public Criteria andMakeLoansSerialNumberNotLike(String value) {
            addCriterion("make_Loans_serial_number not like", value, "makeLoansSerialNumber");
            return (Criteria) this;
        }

        public Criteria andMakeLoansSerialNumberIn(List<String> values) {
            addCriterion("make_Loans_serial_number in", values, "makeLoansSerialNumber");
            return (Criteria) this;
        }

        public Criteria andMakeLoansSerialNumberNotIn(List<String> values) {
            addCriterion("make_Loans_serial_number not in", values, "makeLoansSerialNumber");
            return (Criteria) this;
        }

        public Criteria andMakeLoansSerialNumberBetween(String value1, String value2) {
            addCriterion("make_Loans_serial_number between", value1, value2, "makeLoansSerialNumber");
            return (Criteria) this;
        }

        public Criteria andMakeLoansSerialNumberNotBetween(String value1, String value2) {
            addCriterion("make_Loans_serial_number not between", value1, value2, "makeLoansSerialNumber");
            return (Criteria) this;
        }

        public Criteria andMakeLoansInstitutionCodeIsNull() {
            addCriterion("make_Loans_Institution_code is null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansInstitutionCodeIsNotNull() {
            addCriterion("make_Loans_Institution_code is not null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansInstitutionCodeEqualTo(String value) {
            addCriterion("make_Loans_Institution_code =", value, "makeLoansInstitutionCode");
            return (Criteria) this;
        }

        public Criteria andMakeLoansInstitutionCodeNotEqualTo(String value) {
            addCriterion("make_Loans_Institution_code <>", value, "makeLoansInstitutionCode");
            return (Criteria) this;
        }

        public Criteria andMakeLoansInstitutionCodeGreaterThan(String value) {
            addCriterion("make_Loans_Institution_code >", value, "makeLoansInstitutionCode");
            return (Criteria) this;
        }

        public Criteria andMakeLoansInstitutionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("make_Loans_Institution_code >=", value, "makeLoansInstitutionCode");
            return (Criteria) this;
        }

        public Criteria andMakeLoansInstitutionCodeLessThan(String value) {
            addCriterion("make_Loans_Institution_code <", value, "makeLoansInstitutionCode");
            return (Criteria) this;
        }

        public Criteria andMakeLoansInstitutionCodeLessThanOrEqualTo(String value) {
            addCriterion("make_Loans_Institution_code <=", value, "makeLoansInstitutionCode");
            return (Criteria) this;
        }

        public Criteria andMakeLoansInstitutionCodeLike(String value) {
            addCriterion("make_Loans_Institution_code like", value, "makeLoansInstitutionCode");
            return (Criteria) this;
        }

        public Criteria andMakeLoansInstitutionCodeNotLike(String value) {
            addCriterion("make_Loans_Institution_code not like", value, "makeLoansInstitutionCode");
            return (Criteria) this;
        }

        public Criteria andMakeLoansInstitutionCodeIn(List<String> values) {
            addCriterion("make_Loans_Institution_code in", values, "makeLoansInstitutionCode");
            return (Criteria) this;
        }

        public Criteria andMakeLoansInstitutionCodeNotIn(List<String> values) {
            addCriterion("make_Loans_Institution_code not in", values, "makeLoansInstitutionCode");
            return (Criteria) this;
        }

        public Criteria andMakeLoansInstitutionCodeBetween(String value1, String value2) {
            addCriterion("make_Loans_Institution_code between", value1, value2, "makeLoansInstitutionCode");
            return (Criteria) this;
        }

        public Criteria andMakeLoansInstitutionCodeNotBetween(String value1, String value2) {
            addCriterion("make_Loans_Institution_code not between", value1, value2, "makeLoansInstitutionCode");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCardidIsNull() {
            addCriterion("make_Loans_cardId is null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCardidIsNotNull() {
            addCriterion("make_Loans_cardId is not null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCardidEqualTo(Long value) {
            addCriterion("make_Loans_cardId =", value, "makeLoansCardid");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCardidNotEqualTo(Long value) {
            addCriterion("make_Loans_cardId <>", value, "makeLoansCardid");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCardidGreaterThan(Long value) {
            addCriterion("make_Loans_cardId >", value, "makeLoansCardid");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCardidGreaterThanOrEqualTo(Long value) {
            addCriterion("make_Loans_cardId >=", value, "makeLoansCardid");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCardidLessThan(Long value) {
            addCriterion("make_Loans_cardId <", value, "makeLoansCardid");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCardidLessThanOrEqualTo(Long value) {
            addCriterion("make_Loans_cardId <=", value, "makeLoansCardid");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCardidIn(List<Long> values) {
            addCriterion("make_Loans_cardId in", values, "makeLoansCardid");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCardidNotIn(List<Long> values) {
            addCriterion("make_Loans_cardId not in", values, "makeLoansCardid");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCardidBetween(Long value1, Long value2) {
            addCriterion("make_Loans_cardId between", value1, value2, "makeLoansCardid");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCardidNotBetween(Long value1, Long value2) {
            addCriterion("make_Loans_cardId not between", value1, value2, "makeLoansCardid");
            return (Criteria) this;
        }

        public Criteria andMakeLoansIdIsNull() {
            addCriterion("make_Loans_Id is null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansIdIsNotNull() {
            addCriterion("make_Loans_Id is not null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansIdEqualTo(Long value) {
            addCriterion("make_Loans_Id =", value, "makeLoansId");
            return (Criteria) this;
        }

        public Criteria andMakeLoansIdNotEqualTo(Long value) {
            addCriterion("make_Loans_Id <>", value, "makeLoansId");
            return (Criteria) this;
        }

        public Criteria andMakeLoansIdGreaterThan(Long value) {
            addCriterion("make_Loans_Id >", value, "makeLoansId");
            return (Criteria) this;
        }

        public Criteria andMakeLoansIdGreaterThanOrEqualTo(Long value) {
            addCriterion("make_Loans_Id >=", value, "makeLoansId");
            return (Criteria) this;
        }

        public Criteria andMakeLoansIdLessThan(Long value) {
            addCriterion("make_Loans_Id <", value, "makeLoansId");
            return (Criteria) this;
        }

        public Criteria andMakeLoansIdLessThanOrEqualTo(Long value) {
            addCriterion("make_Loans_Id <=", value, "makeLoansId");
            return (Criteria) this;
        }

        public Criteria andMakeLoansIdIn(List<Long> values) {
            addCriterion("make_Loans_Id in", values, "makeLoansId");
            return (Criteria) this;
        }

        public Criteria andMakeLoansIdNotIn(List<Long> values) {
            addCriterion("make_Loans_Id not in", values, "makeLoansId");
            return (Criteria) this;
        }

        public Criteria andMakeLoansIdBetween(Long value1, Long value2) {
            addCriterion("make_Loans_Id between", value1, value2, "makeLoansId");
            return (Criteria) this;
        }

        public Criteria andMakeLoansIdNotBetween(Long value1, Long value2) {
            addCriterion("make_Loans_Id not between", value1, value2, "makeLoansId");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCodeIsNull() {
            addCriterion("make_Loans_code is null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCodeIsNotNull() {
            addCriterion("make_Loans_code is not null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCodeEqualTo(String value) {
            addCriterion("make_Loans_code =", value, "makeLoansCode");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCodeNotEqualTo(String value) {
            addCriterion("make_Loans_code <>", value, "makeLoansCode");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCodeGreaterThan(String value) {
            addCriterion("make_Loans_code >", value, "makeLoansCode");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCodeGreaterThanOrEqualTo(String value) {
            addCriterion("make_Loans_code >=", value, "makeLoansCode");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCodeLessThan(String value) {
            addCriterion("make_Loans_code <", value, "makeLoansCode");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCodeLessThanOrEqualTo(String value) {
            addCriterion("make_Loans_code <=", value, "makeLoansCode");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCodeLike(String value) {
            addCriterion("make_Loans_code like", value, "makeLoansCode");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCodeNotLike(String value) {
            addCriterion("make_Loans_code not like", value, "makeLoansCode");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCodeIn(List<String> values) {
            addCriterion("make_Loans_code in", values, "makeLoansCode");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCodeNotIn(List<String> values) {
            addCriterion("make_Loans_code not in", values, "makeLoansCode");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCodeBetween(String value1, String value2) {
            addCriterion("make_Loans_code between", value1, value2, "makeLoansCode");
            return (Criteria) this;
        }

        public Criteria andMakeLoansCodeNotBetween(String value1, String value2) {
            addCriterion("make_Loans_code not between", value1, value2, "makeLoansCode");
            return (Criteria) this;
        }

        public Criteria andMakeLoansDayRateIsNull() {
            addCriterion("make_Loans_day_rate is null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansDayRateIsNotNull() {
            addCriterion("make_Loans_day_rate is not null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansDayRateEqualTo(BigDecimal value) {
            addCriterion("make_Loans_day_rate =", value, "makeLoansDayRate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansDayRateNotEqualTo(BigDecimal value) {
            addCriterion("make_Loans_day_rate <>", value, "makeLoansDayRate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansDayRateGreaterThan(BigDecimal value) {
            addCriterion("make_Loans_day_rate >", value, "makeLoansDayRate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansDayRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("make_Loans_day_rate >=", value, "makeLoansDayRate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansDayRateLessThan(BigDecimal value) {
            addCriterion("make_Loans_day_rate <", value, "makeLoansDayRate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansDayRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("make_Loans_day_rate <=", value, "makeLoansDayRate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansDayRateIn(List<BigDecimal> values) {
            addCriterion("make_Loans_day_rate in", values, "makeLoansDayRate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansDayRateNotIn(List<BigDecimal> values) {
            addCriterion("make_Loans_day_rate not in", values, "makeLoansDayRate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansDayRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("make_Loans_day_rate between", value1, value2, "makeLoansDayRate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansDayRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("make_Loans_day_rate not between", value1, value2, "makeLoansDayRate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansServiceCostIsNull() {
            addCriterion("make_Loans_service_cost is null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansServiceCostIsNotNull() {
            addCriterion("make_Loans_service_cost is not null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansServiceCostEqualTo(BigDecimal value) {
            addCriterion("make_Loans_service_cost =", value, "makeLoansServiceCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansServiceCostNotEqualTo(BigDecimal value) {
            addCriterion("make_Loans_service_cost <>", value, "makeLoansServiceCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansServiceCostGreaterThan(BigDecimal value) {
            addCriterion("make_Loans_service_cost >", value, "makeLoansServiceCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansServiceCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("make_Loans_service_cost >=", value, "makeLoansServiceCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansServiceCostLessThan(BigDecimal value) {
            addCriterion("make_Loans_service_cost <", value, "makeLoansServiceCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansServiceCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("make_Loans_service_cost <=", value, "makeLoansServiceCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansServiceCostIn(List<BigDecimal> values) {
            addCriterion("make_Loans_service_cost in", values, "makeLoansServiceCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansServiceCostNotIn(List<BigDecimal> values) {
            addCriterion("make_Loans_service_cost not in", values, "makeLoansServiceCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansServiceCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("make_Loans_service_cost between", value1, value2, "makeLoansServiceCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansServiceCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("make_Loans_service_cost not between", value1, value2, "makeLoansServiceCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansManageCostIsNull() {
            addCriterion("make_Loans_manage_cost is null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansManageCostIsNotNull() {
            addCriterion("make_Loans_manage_cost is not null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansManageCostEqualTo(BigDecimal value) {
            addCriterion("make_Loans_manage_cost =", value, "makeLoansManageCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansManageCostNotEqualTo(BigDecimal value) {
            addCriterion("make_Loans_manage_cost <>", value, "makeLoansManageCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansManageCostGreaterThan(BigDecimal value) {
            addCriterion("make_Loans_manage_cost >", value, "makeLoansManageCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansManageCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("make_Loans_manage_cost >=", value, "makeLoansManageCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansManageCostLessThan(BigDecimal value) {
            addCriterion("make_Loans_manage_cost <", value, "makeLoansManageCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansManageCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("make_Loans_manage_cost <=", value, "makeLoansManageCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansManageCostIn(List<BigDecimal> values) {
            addCriterion("make_Loans_manage_cost in", values, "makeLoansManageCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansManageCostNotIn(List<BigDecimal> values) {
            addCriterion("make_Loans_manage_cost not in", values, "makeLoansManageCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansManageCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("make_Loans_manage_cost between", value1, value2, "makeLoansManageCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansManageCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("make_Loans_manage_cost not between", value1, value2, "makeLoansManageCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansTimeCostIsNull() {
            addCriterion("make_Loans_time_cost is null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansTimeCostIsNotNull() {
            addCriterion("make_Loans_time_cost is not null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansTimeCostEqualTo(BigDecimal value) {
            addCriterion("make_Loans_time_cost =", value, "makeLoansTimeCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansTimeCostNotEqualTo(BigDecimal value) {
            addCriterion("make_Loans_time_cost <>", value, "makeLoansTimeCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansTimeCostGreaterThan(BigDecimal value) {
            addCriterion("make_Loans_time_cost >", value, "makeLoansTimeCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansTimeCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("make_Loans_time_cost >=", value, "makeLoansTimeCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansTimeCostLessThan(BigDecimal value) {
            addCriterion("make_Loans_time_cost <", value, "makeLoansTimeCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansTimeCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("make_Loans_time_cost <=", value, "makeLoansTimeCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansTimeCostIn(List<BigDecimal> values) {
            addCriterion("make_Loans_time_cost in", values, "makeLoansTimeCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansTimeCostNotIn(List<BigDecimal> values) {
            addCriterion("make_Loans_time_cost not in", values, "makeLoansTimeCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansTimeCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("make_Loans_time_cost between", value1, value2, "makeLoansTimeCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansTimeCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("make_Loans_time_cost not between", value1, value2, "makeLoansTimeCost");
            return (Criteria) this;
        }

        public Criteria andMakeLoansOverdueRateIsNull() {
            addCriterion("make_Loans_overdue_rate is null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansOverdueRateIsNotNull() {
            addCriterion("make_Loans_overdue_rate is not null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansOverdueRateEqualTo(BigDecimal value) {
            addCriterion("make_Loans_overdue_rate =", value, "makeLoansOverdueRate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansOverdueRateNotEqualTo(BigDecimal value) {
            addCriterion("make_Loans_overdue_rate <>", value, "makeLoansOverdueRate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansOverdueRateGreaterThan(BigDecimal value) {
            addCriterion("make_Loans_overdue_rate >", value, "makeLoansOverdueRate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansOverdueRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("make_Loans_overdue_rate >=", value, "makeLoansOverdueRate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansOverdueRateLessThan(BigDecimal value) {
            addCriterion("make_Loans_overdue_rate <", value, "makeLoansOverdueRate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansOverdueRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("make_Loans_overdue_rate <=", value, "makeLoansOverdueRate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansOverdueRateIn(List<BigDecimal> values) {
            addCriterion("make_Loans_overdue_rate in", values, "makeLoansOverdueRate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansOverdueRateNotIn(List<BigDecimal> values) {
            addCriterion("make_Loans_overdue_rate not in", values, "makeLoansOverdueRate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansOverdueRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("make_Loans_overdue_rate between", value1, value2, "makeLoansOverdueRate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansOverdueRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("make_Loans_overdue_rate not between", value1, value2, "makeLoansOverdueRate");
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

        public Criteria andActiveEqualTo(Boolean value) {
            addCriterion("active =", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotEqualTo(Boolean value) {
            addCriterion("active <>", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThan(Boolean value) {
            addCriterion("active >", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("active >=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThan(Boolean value) {
            addCriterion("active <", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThanOrEqualTo(Boolean value) {
            addCriterion("active <=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveIn(List<Boolean> values) {
            addCriterion("active in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotIn(List<Boolean> values) {
            addCriterion("active not in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveBetween(Boolean value1, Boolean value2) {
            addCriterion("active between", value1, value2, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotBetween(Boolean value1, Boolean value2) {
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
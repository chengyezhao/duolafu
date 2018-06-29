package com.shoumipay.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankAccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BankAccountExample() {
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

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNumberIsNull() {
            addCriterion("Merchant_Order_Number is null");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNumberIsNotNull() {
            addCriterion("Merchant_Order_Number is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNumberEqualTo(String value) {
            addCriterion("Merchant_Order_Number =", value, "merchantOrderNumber");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNumberNotEqualTo(String value) {
            addCriterion("Merchant_Order_Number <>", value, "merchantOrderNumber");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNumberGreaterThan(String value) {
            addCriterion("Merchant_Order_Number >", value, "merchantOrderNumber");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("Merchant_Order_Number >=", value, "merchantOrderNumber");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNumberLessThan(String value) {
            addCriterion("Merchant_Order_Number <", value, "merchantOrderNumber");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("Merchant_Order_Number <=", value, "merchantOrderNumber");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNumberLike(String value) {
            addCriterion("Merchant_Order_Number like", value, "merchantOrderNumber");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNumberNotLike(String value) {
            addCriterion("Merchant_Order_Number not like", value, "merchantOrderNumber");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNumberIn(List<String> values) {
            addCriterion("Merchant_Order_Number in", values, "merchantOrderNumber");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNumberNotIn(List<String> values) {
            addCriterion("Merchant_Order_Number not in", values, "merchantOrderNumber");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNumberBetween(String value1, String value2) {
            addCriterion("Merchant_Order_Number between", value1, value2, "merchantOrderNumber");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNumberNotBetween(String value1, String value2) {
            addCriterion("Merchant_Order_Number not between", value1, value2, "merchantOrderNumber");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIsNull() {
            addCriterion("Merchant_ID is null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIsNotNull() {
            addCriterion("Merchant_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdEqualTo(String value) {
            addCriterion("Merchant_ID =", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotEqualTo(String value) {
            addCriterion("Merchant_ID <>", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThan(String value) {
            addCriterion("Merchant_ID >", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThanOrEqualTo(String value) {
            addCriterion("Merchant_ID >=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThan(String value) {
            addCriterion("Merchant_ID <", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThanOrEqualTo(String value) {
            addCriterion("Merchant_ID <=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLike(String value) {
            addCriterion("Merchant_ID like", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotLike(String value) {
            addCriterion("Merchant_ID not like", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIn(List<String> values) {
            addCriterion("Merchant_ID in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotIn(List<String> values) {
            addCriterion("Merchant_ID not in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdBetween(String value1, String value2) {
            addCriterion("Merchant_ID between", value1, value2, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotBetween(String value1, String value2) {
            addCriterion("Merchant_ID not between", value1, value2, "merchantId");
            return (Criteria) this;
        }

        public Criteria andTimeOfOrderCreatedIsNull() {
            addCriterion("Time_of_Order_Created is null");
            return (Criteria) this;
        }

        public Criteria andTimeOfOrderCreatedIsNotNull() {
            addCriterion("Time_of_Order_Created is not null");
            return (Criteria) this;
        }

        public Criteria andTimeOfOrderCreatedEqualTo(Date value) {
            addCriterion("Time_of_Order_Created =", value, "timeOfOrderCreated");
            return (Criteria) this;
        }

        public Criteria andTimeOfOrderCreatedNotEqualTo(Date value) {
            addCriterion("Time_of_Order_Created <>", value, "timeOfOrderCreated");
            return (Criteria) this;
        }

        public Criteria andTimeOfOrderCreatedGreaterThan(Date value) {
            addCriterion("Time_of_Order_Created >", value, "timeOfOrderCreated");
            return (Criteria) this;
        }

        public Criteria andTimeOfOrderCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("Time_of_Order_Created >=", value, "timeOfOrderCreated");
            return (Criteria) this;
        }

        public Criteria andTimeOfOrderCreatedLessThan(Date value) {
            addCriterion("Time_of_Order_Created <", value, "timeOfOrderCreated");
            return (Criteria) this;
        }

        public Criteria andTimeOfOrderCreatedLessThanOrEqualTo(Date value) {
            addCriterion("Time_of_Order_Created <=", value, "timeOfOrderCreated");
            return (Criteria) this;
        }

        public Criteria andTimeOfOrderCreatedIn(List<Date> values) {
            addCriterion("Time_of_Order_Created in", values, "timeOfOrderCreated");
            return (Criteria) this;
        }

        public Criteria andTimeOfOrderCreatedNotIn(List<Date> values) {
            addCriterion("Time_of_Order_Created not in", values, "timeOfOrderCreated");
            return (Criteria) this;
        }

        public Criteria andTimeOfOrderCreatedBetween(Date value1, Date value2) {
            addCriterion("Time_of_Order_Created between", value1, value2, "timeOfOrderCreated");
            return (Criteria) this;
        }

        public Criteria andTimeOfOrderCreatedNotBetween(Date value1, Date value2) {
            addCriterion("Time_of_Order_Created not between", value1, value2, "timeOfOrderCreated");
            return (Criteria) this;
        }

        public Criteria andMerchantBusinessTypeIsNull() {
            addCriterion("Merchant_Business_Type is null");
            return (Criteria) this;
        }

        public Criteria andMerchantBusinessTypeIsNotNull() {
            addCriterion("Merchant_Business_Type is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantBusinessTypeEqualTo(String value) {
            addCriterion("Merchant_Business_Type =", value, "merchantBusinessType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusinessTypeNotEqualTo(String value) {
            addCriterion("Merchant_Business_Type <>", value, "merchantBusinessType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusinessTypeGreaterThan(String value) {
            addCriterion("Merchant_Business_Type >", value, "merchantBusinessType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusinessTypeGreaterThanOrEqualTo(String value) {
            addCriterion("Merchant_Business_Type >=", value, "merchantBusinessType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusinessTypeLessThan(String value) {
            addCriterion("Merchant_Business_Type <", value, "merchantBusinessType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusinessTypeLessThanOrEqualTo(String value) {
            addCriterion("Merchant_Business_Type <=", value, "merchantBusinessType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusinessTypeLike(String value) {
            addCriterion("Merchant_Business_Type like", value, "merchantBusinessType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusinessTypeNotLike(String value) {
            addCriterion("Merchant_Business_Type not like", value, "merchantBusinessType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusinessTypeIn(List<String> values) {
            addCriterion("Merchant_Business_Type in", values, "merchantBusinessType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusinessTypeNotIn(List<String> values) {
            addCriterion("Merchant_Business_Type not in", values, "merchantBusinessType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusinessTypeBetween(String value1, String value2) {
            addCriterion("Merchant_Business_Type between", value1, value2, "merchantBusinessType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusinessTypeNotBetween(String value1, String value2) {
            addCriterion("Merchant_Business_Type not between", value1, value2, "merchantBusinessType");
            return (Criteria) this;
        }

        public Criteria andLianlianPaymentNumberIsNull() {
            addCriterion("Lianlian_Payment_Number is null");
            return (Criteria) this;
        }

        public Criteria andLianlianPaymentNumberIsNotNull() {
            addCriterion("Lianlian_Payment_Number is not null");
            return (Criteria) this;
        }

        public Criteria andLianlianPaymentNumberEqualTo(String value) {
            addCriterion("Lianlian_Payment_Number =", value, "lianlianPaymentNumber");
            return (Criteria) this;
        }

        public Criteria andLianlianPaymentNumberNotEqualTo(String value) {
            addCriterion("Lianlian_Payment_Number <>", value, "lianlianPaymentNumber");
            return (Criteria) this;
        }

        public Criteria andLianlianPaymentNumberGreaterThan(String value) {
            addCriterion("Lianlian_Payment_Number >", value, "lianlianPaymentNumber");
            return (Criteria) this;
        }

        public Criteria andLianlianPaymentNumberGreaterThanOrEqualTo(String value) {
            addCriterion("Lianlian_Payment_Number >=", value, "lianlianPaymentNumber");
            return (Criteria) this;
        }

        public Criteria andLianlianPaymentNumberLessThan(String value) {
            addCriterion("Lianlian_Payment_Number <", value, "lianlianPaymentNumber");
            return (Criteria) this;
        }

        public Criteria andLianlianPaymentNumberLessThanOrEqualTo(String value) {
            addCriterion("Lianlian_Payment_Number <=", value, "lianlianPaymentNumber");
            return (Criteria) this;
        }

        public Criteria andLianlianPaymentNumberLike(String value) {
            addCriterion("Lianlian_Payment_Number like", value, "lianlianPaymentNumber");
            return (Criteria) this;
        }

        public Criteria andLianlianPaymentNumberNotLike(String value) {
            addCriterion("Lianlian_Payment_Number not like", value, "lianlianPaymentNumber");
            return (Criteria) this;
        }

        public Criteria andLianlianPaymentNumberIn(List<String> values) {
            addCriterion("Lianlian_Payment_Number in", values, "lianlianPaymentNumber");
            return (Criteria) this;
        }

        public Criteria andLianlianPaymentNumberNotIn(List<String> values) {
            addCriterion("Lianlian_Payment_Number not in", values, "lianlianPaymentNumber");
            return (Criteria) this;
        }

        public Criteria andLianlianPaymentNumberBetween(String value1, String value2) {
            addCriterion("Lianlian_Payment_Number between", value1, value2, "lianlianPaymentNumber");
            return (Criteria) this;
        }

        public Criteria andLianlianPaymentNumberNotBetween(String value1, String value2) {
            addCriterion("Lianlian_Payment_Number not between", value1, value2, "lianlianPaymentNumber");
            return (Criteria) this;
        }

        public Criteria andLianlianSettlementDateIsNull() {
            addCriterion("Lianlian_Settlement_Date is null");
            return (Criteria) this;
        }

        public Criteria andLianlianSettlementDateIsNotNull() {
            addCriterion("Lianlian_Settlement_Date is not null");
            return (Criteria) this;
        }

        public Criteria andLianlianSettlementDateEqualTo(Date value) {
            addCriterion("Lianlian_Settlement_Date =", value, "lianlianSettlementDate");
            return (Criteria) this;
        }

        public Criteria andLianlianSettlementDateNotEqualTo(Date value) {
            addCriterion("Lianlian_Settlement_Date <>", value, "lianlianSettlementDate");
            return (Criteria) this;
        }

        public Criteria andLianlianSettlementDateGreaterThan(Date value) {
            addCriterion("Lianlian_Settlement_Date >", value, "lianlianSettlementDate");
            return (Criteria) this;
        }

        public Criteria andLianlianSettlementDateGreaterThanOrEqualTo(Date value) {
            addCriterion("Lianlian_Settlement_Date >=", value, "lianlianSettlementDate");
            return (Criteria) this;
        }

        public Criteria andLianlianSettlementDateLessThan(Date value) {
            addCriterion("Lianlian_Settlement_Date <", value, "lianlianSettlementDate");
            return (Criteria) this;
        }

        public Criteria andLianlianSettlementDateLessThanOrEqualTo(Date value) {
            addCriterion("Lianlian_Settlement_Date <=", value, "lianlianSettlementDate");
            return (Criteria) this;
        }

        public Criteria andLianlianSettlementDateIn(List<Date> values) {
            addCriterion("Lianlian_Settlement_Date in", values, "lianlianSettlementDate");
            return (Criteria) this;
        }

        public Criteria andLianlianSettlementDateNotIn(List<Date> values) {
            addCriterion("Lianlian_Settlement_Date not in", values, "lianlianSettlementDate");
            return (Criteria) this;
        }

        public Criteria andLianlianSettlementDateBetween(Date value1, Date value2) {
            addCriterion("Lianlian_Settlement_Date between", value1, value2, "lianlianSettlementDate");
            return (Criteria) this;
        }

        public Criteria andLianlianSettlementDateNotBetween(Date value1, Date value2) {
            addCriterion("Lianlian_Settlement_Date not between", value1, value2, "lianlianSettlementDate");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountIsNull() {
            addCriterion("Transaction_Amount is null");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountIsNotNull() {
            addCriterion("Transaction_Amount is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountEqualTo(BigDecimal value) {
            addCriterion("Transaction_Amount =", value, "transactionAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountNotEqualTo(BigDecimal value) {
            addCriterion("Transaction_Amount <>", value, "transactionAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountGreaterThan(BigDecimal value) {
            addCriterion("Transaction_Amount >", value, "transactionAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Transaction_Amount >=", value, "transactionAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountLessThan(BigDecimal value) {
            addCriterion("Transaction_Amount <", value, "transactionAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Transaction_Amount <=", value, "transactionAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountIn(List<BigDecimal> values) {
            addCriterion("Transaction_Amount in", values, "transactionAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountNotIn(List<BigDecimal> values) {
            addCriterion("Transaction_Amount not in", values, "transactionAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Transaction_Amount between", value1, value2, "transactionAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Transaction_Amount not between", value1, value2, "transactionAmount");
            return (Criteria) this;
        }

        public Criteria andTypeFlagIsNull() {
            addCriterion("Type_Flag is null");
            return (Criteria) this;
        }

        public Criteria andTypeFlagIsNotNull() {
            addCriterion("Type_Flag is not null");
            return (Criteria) this;
        }

        public Criteria andTypeFlagEqualTo(Integer value) {
            addCriterion("Type_Flag =", value, "typeFlag");
            return (Criteria) this;
        }

        public Criteria andTypeFlagNotEqualTo(Integer value) {
            addCriterion("Type_Flag <>", value, "typeFlag");
            return (Criteria) this;
        }

        public Criteria andTypeFlagGreaterThan(Integer value) {
            addCriterion("Type_Flag >", value, "typeFlag");
            return (Criteria) this;
        }

        public Criteria andTypeFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("Type_Flag >=", value, "typeFlag");
            return (Criteria) this;
        }

        public Criteria andTypeFlagLessThan(Integer value) {
            addCriterion("Type_Flag <", value, "typeFlag");
            return (Criteria) this;
        }

        public Criteria andTypeFlagLessThanOrEqualTo(Integer value) {
            addCriterion("Type_Flag <=", value, "typeFlag");
            return (Criteria) this;
        }

        public Criteria andTypeFlagIn(List<Integer> values) {
            addCriterion("Type_Flag in", values, "typeFlag");
            return (Criteria) this;
        }

        public Criteria andTypeFlagNotIn(List<Integer> values) {
            addCriterion("Type_Flag not in", values, "typeFlag");
            return (Criteria) this;
        }

        public Criteria andTypeFlagBetween(Integer value1, Integer value2) {
            addCriterion("Type_Flag between", value1, value2, "typeFlag");
            return (Criteria) this;
        }

        public Criteria andTypeFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("Type_Flag not between", value1, value2, "typeFlag");
            return (Criteria) this;
        }

        public Criteria andTransactionStatusIsNull() {
            addCriterion("Transaction_Status is null");
            return (Criteria) this;
        }

        public Criteria andTransactionStatusIsNotNull() {
            addCriterion("Transaction_Status is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionStatusEqualTo(Integer value) {
            addCriterion("Transaction_Status =", value, "transactionStatus");
            return (Criteria) this;
        }

        public Criteria andTransactionStatusNotEqualTo(Integer value) {
            addCriterion("Transaction_Status <>", value, "transactionStatus");
            return (Criteria) this;
        }

        public Criteria andTransactionStatusGreaterThan(Integer value) {
            addCriterion("Transaction_Status >", value, "transactionStatus");
            return (Criteria) this;
        }

        public Criteria andTransactionStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("Transaction_Status >=", value, "transactionStatus");
            return (Criteria) this;
        }

        public Criteria andTransactionStatusLessThan(Integer value) {
            addCriterion("Transaction_Status <", value, "transactionStatus");
            return (Criteria) this;
        }

        public Criteria andTransactionStatusLessThanOrEqualTo(Integer value) {
            addCriterion("Transaction_Status <=", value, "transactionStatus");
            return (Criteria) this;
        }

        public Criteria andTransactionStatusIn(List<Integer> values) {
            addCriterion("Transaction_Status in", values, "transactionStatus");
            return (Criteria) this;
        }

        public Criteria andTransactionStatusNotIn(List<Integer> values) {
            addCriterion("Transaction_Status not in", values, "transactionStatus");
            return (Criteria) this;
        }

        public Criteria andTransactionStatusBetween(Integer value1, Integer value2) {
            addCriterion("Transaction_Status between", value1, value2, "transactionStatus");
            return (Criteria) this;
        }

        public Criteria andTransactionStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("Transaction_Status not between", value1, value2, "transactionStatus");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("Update_Date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("Update_Date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("Update_Date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("Update_Date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("Update_Date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("Update_Date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("Update_Date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("Update_Date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("Update_Date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("Update_Date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("Update_Date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("Update_Date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andServiceFeeIsNull() {
            addCriterion("Service_Fee is null");
            return (Criteria) this;
        }

        public Criteria andServiceFeeIsNotNull() {
            addCriterion("Service_Fee is not null");
            return (Criteria) this;
        }

        public Criteria andServiceFeeEqualTo(BigDecimal value) {
            addCriterion("Service_Fee =", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotEqualTo(BigDecimal value) {
            addCriterion("Service_Fee <>", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeGreaterThan(BigDecimal value) {
            addCriterion("Service_Fee >", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Service_Fee >=", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeLessThan(BigDecimal value) {
            addCriterion("Service_Fee <", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Service_Fee <=", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeIn(List<BigDecimal> values) {
            addCriterion("Service_Fee in", values, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotIn(List<BigDecimal> values) {
            addCriterion("Service_Fee not in", values, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Service_Fee between", value1, value2, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Service_Fee not between", value1, value2, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andPaymentProductIsNull() {
            addCriterion("Payment_Product is null");
            return (Criteria) this;
        }

        public Criteria andPaymentProductIsNotNull() {
            addCriterion("Payment_Product is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentProductEqualTo(String value) {
            addCriterion("Payment_Product =", value, "paymentProduct");
            return (Criteria) this;
        }

        public Criteria andPaymentProductNotEqualTo(String value) {
            addCriterion("Payment_Product <>", value, "paymentProduct");
            return (Criteria) this;
        }

        public Criteria andPaymentProductGreaterThan(String value) {
            addCriterion("Payment_Product >", value, "paymentProduct");
            return (Criteria) this;
        }

        public Criteria andPaymentProductGreaterThanOrEqualTo(String value) {
            addCriterion("Payment_Product >=", value, "paymentProduct");
            return (Criteria) this;
        }

        public Criteria andPaymentProductLessThan(String value) {
            addCriterion("Payment_Product <", value, "paymentProduct");
            return (Criteria) this;
        }

        public Criteria andPaymentProductLessThanOrEqualTo(String value) {
            addCriterion("Payment_Product <=", value, "paymentProduct");
            return (Criteria) this;
        }

        public Criteria andPaymentProductLike(String value) {
            addCriterion("Payment_Product like", value, "paymentProduct");
            return (Criteria) this;
        }

        public Criteria andPaymentProductNotLike(String value) {
            addCriterion("Payment_Product not like", value, "paymentProduct");
            return (Criteria) this;
        }

        public Criteria andPaymentProductIn(List<String> values) {
            addCriterion("Payment_Product in", values, "paymentProduct");
            return (Criteria) this;
        }

        public Criteria andPaymentProductNotIn(List<String> values) {
            addCriterion("Payment_Product not in", values, "paymentProduct");
            return (Criteria) this;
        }

        public Criteria andPaymentProductBetween(String value1, String value2) {
            addCriterion("Payment_Product between", value1, value2, "paymentProduct");
            return (Criteria) this;
        }

        public Criteria andPaymentProductNotBetween(String value1, String value2) {
            addCriterion("Payment_Product not between", value1, value2, "paymentProduct");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIsNull() {
            addCriterion("Payment_Method is null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIsNotNull() {
            addCriterion("Payment_Method is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodEqualTo(String value) {
            addCriterion("Payment_Method =", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotEqualTo(String value) {
            addCriterion("Payment_Method <>", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThan(String value) {
            addCriterion("Payment_Method >", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThanOrEqualTo(String value) {
            addCriterion("Payment_Method >=", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThan(String value) {
            addCriterion("Payment_Method <", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThanOrEqualTo(String value) {
            addCriterion("Payment_Method <=", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLike(String value) {
            addCriterion("Payment_Method like", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotLike(String value) {
            addCriterion("Payment_Method not like", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIn(List<String> values) {
            addCriterion("Payment_Method in", values, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotIn(List<String> values) {
            addCriterion("Payment_Method not in", values, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodBetween(String value1, String value2) {
            addCriterion("Payment_Method between", value1, value2, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotBetween(String value1, String value2) {
            addCriterion("Payment_Method not between", value1, value2, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andOrderInfoIsNull() {
            addCriterion("Order_Info is null");
            return (Criteria) this;
        }

        public Criteria andOrderInfoIsNotNull() {
            addCriterion("Order_Info is not null");
            return (Criteria) this;
        }

        public Criteria andOrderInfoEqualTo(String value) {
            addCriterion("Order_Info =", value, "orderInfo");
            return (Criteria) this;
        }

        public Criteria andOrderInfoNotEqualTo(String value) {
            addCriterion("Order_Info <>", value, "orderInfo");
            return (Criteria) this;
        }

        public Criteria andOrderInfoGreaterThan(String value) {
            addCriterion("Order_Info >", value, "orderInfo");
            return (Criteria) this;
        }

        public Criteria andOrderInfoGreaterThanOrEqualTo(String value) {
            addCriterion("Order_Info >=", value, "orderInfo");
            return (Criteria) this;
        }

        public Criteria andOrderInfoLessThan(String value) {
            addCriterion("Order_Info <", value, "orderInfo");
            return (Criteria) this;
        }

        public Criteria andOrderInfoLessThanOrEqualTo(String value) {
            addCriterion("Order_Info <=", value, "orderInfo");
            return (Criteria) this;
        }

        public Criteria andOrderInfoLike(String value) {
            addCriterion("Order_Info like", value, "orderInfo");
            return (Criteria) this;
        }

        public Criteria andOrderInfoNotLike(String value) {
            addCriterion("Order_Info not like", value, "orderInfo");
            return (Criteria) this;
        }

        public Criteria andOrderInfoIn(List<String> values) {
            addCriterion("Order_Info in", values, "orderInfo");
            return (Criteria) this;
        }

        public Criteria andOrderInfoNotIn(List<String> values) {
            addCriterion("Order_Info not in", values, "orderInfo");
            return (Criteria) this;
        }

        public Criteria andOrderInfoBetween(String value1, String value2) {
            addCriterion("Order_Info between", value1, value2, "orderInfo");
            return (Criteria) this;
        }

        public Criteria andOrderInfoNotBetween(String value1, String value2) {
            addCriterion("Order_Info not between", value1, value2, "orderInfo");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryBankIsNull() {
            addCriterion("Beneficiary_Bank is null");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryBankIsNotNull() {
            addCriterion("Beneficiary_Bank is not null");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryBankEqualTo(String value) {
            addCriterion("Beneficiary_Bank =", value, "beneficiaryBank");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryBankNotEqualTo(String value) {
            addCriterion("Beneficiary_Bank <>", value, "beneficiaryBank");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryBankGreaterThan(String value) {
            addCriterion("Beneficiary_Bank >", value, "beneficiaryBank");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryBankGreaterThanOrEqualTo(String value) {
            addCriterion("Beneficiary_Bank >=", value, "beneficiaryBank");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryBankLessThan(String value) {
            addCriterion("Beneficiary_Bank <", value, "beneficiaryBank");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryBankLessThanOrEqualTo(String value) {
            addCriterion("Beneficiary_Bank <=", value, "beneficiaryBank");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryBankLike(String value) {
            addCriterion("Beneficiary_Bank like", value, "beneficiaryBank");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryBankNotLike(String value) {
            addCriterion("Beneficiary_Bank not like", value, "beneficiaryBank");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryBankIn(List<String> values) {
            addCriterion("Beneficiary_Bank in", values, "beneficiaryBank");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryBankNotIn(List<String> values) {
            addCriterion("Beneficiary_Bank not in", values, "beneficiaryBank");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryBankBetween(String value1, String value2) {
            addCriterion("Beneficiary_Bank between", value1, value2, "beneficiaryBank");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryBankNotBetween(String value1, String value2) {
            addCriterion("Beneficiary_Bank not between", value1, value2, "beneficiaryBank");
            return (Criteria) this;
        }

        public Criteria andBankAccountNumberIsNull() {
            addCriterion("Bank_Account_Number is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountNumberIsNotNull() {
            addCriterion("Bank_Account_Number is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountNumberEqualTo(String value) {
            addCriterion("Bank_Account_Number =", value, "bankAccountNumber");
            return (Criteria) this;
        }

        public Criteria andBankAccountNumberNotEqualTo(String value) {
            addCriterion("Bank_Account_Number <>", value, "bankAccountNumber");
            return (Criteria) this;
        }

        public Criteria andBankAccountNumberGreaterThan(String value) {
            addCriterion("Bank_Account_Number >", value, "bankAccountNumber");
            return (Criteria) this;
        }

        public Criteria andBankAccountNumberGreaterThanOrEqualTo(String value) {
            addCriterion("Bank_Account_Number >=", value, "bankAccountNumber");
            return (Criteria) this;
        }

        public Criteria andBankAccountNumberLessThan(String value) {
            addCriterion("Bank_Account_Number <", value, "bankAccountNumber");
            return (Criteria) this;
        }

        public Criteria andBankAccountNumberLessThanOrEqualTo(String value) {
            addCriterion("Bank_Account_Number <=", value, "bankAccountNumber");
            return (Criteria) this;
        }

        public Criteria andBankAccountNumberLike(String value) {
            addCriterion("Bank_Account_Number like", value, "bankAccountNumber");
            return (Criteria) this;
        }

        public Criteria andBankAccountNumberNotLike(String value) {
            addCriterion("Bank_Account_Number not like", value, "bankAccountNumber");
            return (Criteria) this;
        }

        public Criteria andBankAccountNumberIn(List<String> values) {
            addCriterion("Bank_Account_Number in", values, "bankAccountNumber");
            return (Criteria) this;
        }

        public Criteria andBankAccountNumberNotIn(List<String> values) {
            addCriterion("Bank_Account_Number not in", values, "bankAccountNumber");
            return (Criteria) this;
        }

        public Criteria andBankAccountNumberBetween(String value1, String value2) {
            addCriterion("Bank_Account_Number between", value1, value2, "bankAccountNumber");
            return (Criteria) this;
        }

        public Criteria andBankAccountNumberNotBetween(String value1, String value2) {
            addCriterion("Bank_Account_Number not between", value1, value2, "bankAccountNumber");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryIsNull() {
            addCriterion("Beneficiary is null");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryIsNotNull() {
            addCriterion("Beneficiary is not null");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryEqualTo(String value) {
            addCriterion("Beneficiary =", value, "beneficiary");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryNotEqualTo(String value) {
            addCriterion("Beneficiary <>", value, "beneficiary");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryGreaterThan(String value) {
            addCriterion("Beneficiary >", value, "beneficiary");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryGreaterThanOrEqualTo(String value) {
            addCriterion("Beneficiary >=", value, "beneficiary");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryLessThan(String value) {
            addCriterion("Beneficiary <", value, "beneficiary");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryLessThanOrEqualTo(String value) {
            addCriterion("Beneficiary <=", value, "beneficiary");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryLike(String value) {
            addCriterion("Beneficiary like", value, "beneficiary");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryNotLike(String value) {
            addCriterion("Beneficiary not like", value, "beneficiary");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryIn(List<String> values) {
            addCriterion("Beneficiary in", values, "beneficiary");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryNotIn(List<String> values) {
            addCriterion("Beneficiary not in", values, "beneficiary");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryBetween(String value1, String value2) {
            addCriterion("Beneficiary between", value1, value2, "beneficiary");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryNotBetween(String value1, String value2) {
            addCriterion("Beneficiary not between", value1, value2, "beneficiary");
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
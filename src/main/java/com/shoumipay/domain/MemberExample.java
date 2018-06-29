package com.shoumipay.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberExample() {
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

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Long value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Long value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Long value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Long value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Long value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Long value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Long> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Long> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Long value1, Long value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Long value1, Long value2) {
            addCriterion("uid not between", value1, value2, "uid");
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

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andSaltIsNull() {
            addCriterion("salt is null");
            return (Criteria) this;
        }

        public Criteria andSaltIsNotNull() {
            addCriterion("salt is not null");
            return (Criteria) this;
        }

        public Criteria andSaltEqualTo(String value) {
            addCriterion("salt =", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotEqualTo(String value) {
            addCriterion("salt <>", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThan(String value) {
            addCriterion("salt >", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThanOrEqualTo(String value) {
            addCriterion("salt >=", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThan(String value) {
            addCriterion("salt <", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThanOrEqualTo(String value) {
            addCriterion("salt <=", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLike(String value) {
            addCriterion("salt like", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotLike(String value) {
            addCriterion("salt not like", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltIn(List<String> values) {
            addCriterion("salt in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotIn(List<String> values) {
            addCriterion("salt not in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltBetween(String value1, String value2) {
            addCriterion("salt between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotBetween(String value1, String value2) {
            addCriterion("salt not between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Byte value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Byte value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Byte value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Byte value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Byte value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Byte> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Byte> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Byte value1, Byte value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Byte value1, Byte value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andAuthenticationStatusIsNull() {
            addCriterion("authentication_status is null");
            return (Criteria) this;
        }

        public Criteria andAuthenticationStatusIsNotNull() {
            addCriterion("authentication_status is not null");
            return (Criteria) this;
        }

        public Criteria andAuthenticationStatusEqualTo(Integer value) {
            addCriterion("authentication_status =", value, "authenticationStatus");
            return (Criteria) this;
        }

        public Criteria andAuthenticationStatusNotEqualTo(Integer value) {
            addCriterion("authentication_status <>", value, "authenticationStatus");
            return (Criteria) this;
        }

        public Criteria andAuthenticationStatusGreaterThan(Integer value) {
            addCriterion("authentication_status >", value, "authenticationStatus");
            return (Criteria) this;
        }

        public Criteria andAuthenticationStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("authentication_status >=", value, "authenticationStatus");
            return (Criteria) this;
        }

        public Criteria andAuthenticationStatusLessThan(Integer value) {
            addCriterion("authentication_status <", value, "authenticationStatus");
            return (Criteria) this;
        }

        public Criteria andAuthenticationStatusLessThanOrEqualTo(Integer value) {
            addCriterion("authentication_status <=", value, "authenticationStatus");
            return (Criteria) this;
        }

        public Criteria andAuthenticationStatusIn(List<Integer> values) {
            addCriterion("authentication_status in", values, "authenticationStatus");
            return (Criteria) this;
        }

        public Criteria andAuthenticationStatusNotIn(List<Integer> values) {
            addCriterion("authentication_status not in", values, "authenticationStatus");
            return (Criteria) this;
        }

        public Criteria andAuthenticationStatusBetween(Integer value1, Integer value2) {
            addCriterion("authentication_status between", value1, value2, "authenticationStatus");
            return (Criteria) this;
        }

        public Criteria andAuthenticationStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("authentication_status not between", value1, value2, "authenticationStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentPasswordIsNull() {
            addCriterion("payment_password is null");
            return (Criteria) this;
        }

        public Criteria andPaymentPasswordIsNotNull() {
            addCriterion("payment_password is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentPasswordEqualTo(String value) {
            addCriterion("payment_password =", value, "paymentPassword");
            return (Criteria) this;
        }

        public Criteria andPaymentPasswordNotEqualTo(String value) {
            addCriterion("payment_password <>", value, "paymentPassword");
            return (Criteria) this;
        }

        public Criteria andPaymentPasswordGreaterThan(String value) {
            addCriterion("payment_password >", value, "paymentPassword");
            return (Criteria) this;
        }

        public Criteria andPaymentPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("payment_password >=", value, "paymentPassword");
            return (Criteria) this;
        }

        public Criteria andPaymentPasswordLessThan(String value) {
            addCriterion("payment_password <", value, "paymentPassword");
            return (Criteria) this;
        }

        public Criteria andPaymentPasswordLessThanOrEqualTo(String value) {
            addCriterion("payment_password <=", value, "paymentPassword");
            return (Criteria) this;
        }

        public Criteria andPaymentPasswordLike(String value) {
            addCriterion("payment_password like", value, "paymentPassword");
            return (Criteria) this;
        }

        public Criteria andPaymentPasswordNotLike(String value) {
            addCriterion("payment_password not like", value, "paymentPassword");
            return (Criteria) this;
        }

        public Criteria andPaymentPasswordIn(List<String> values) {
            addCriterion("payment_password in", values, "paymentPassword");
            return (Criteria) this;
        }

        public Criteria andPaymentPasswordNotIn(List<String> values) {
            addCriterion("payment_password not in", values, "paymentPassword");
            return (Criteria) this;
        }

        public Criteria andPaymentPasswordBetween(String value1, String value2) {
            addCriterion("payment_password between", value1, value2, "paymentPassword");
            return (Criteria) this;
        }

        public Criteria andPaymentPasswordNotBetween(String value1, String value2) {
            addCriterion("payment_password not between", value1, value2, "paymentPassword");
            return (Criteria) this;
        }

        public Criteria andLevelOfRiskIsNull() {
            addCriterion("level_of_risk is null");
            return (Criteria) this;
        }

        public Criteria andLevelOfRiskIsNotNull() {
            addCriterion("level_of_risk is not null");
            return (Criteria) this;
        }

        public Criteria andLevelOfRiskEqualTo(String value) {
            addCriterion("level_of_risk =", value, "levelOfRisk");
            return (Criteria) this;
        }

        public Criteria andLevelOfRiskNotEqualTo(String value) {
            addCriterion("level_of_risk <>", value, "levelOfRisk");
            return (Criteria) this;
        }

        public Criteria andLevelOfRiskGreaterThan(String value) {
            addCriterion("level_of_risk >", value, "levelOfRisk");
            return (Criteria) this;
        }

        public Criteria andLevelOfRiskGreaterThanOrEqualTo(String value) {
            addCriterion("level_of_risk >=", value, "levelOfRisk");
            return (Criteria) this;
        }

        public Criteria andLevelOfRiskLessThan(String value) {
            addCriterion("level_of_risk <", value, "levelOfRisk");
            return (Criteria) this;
        }

        public Criteria andLevelOfRiskLessThanOrEqualTo(String value) {
            addCriterion("level_of_risk <=", value, "levelOfRisk");
            return (Criteria) this;
        }

        public Criteria andLevelOfRiskLike(String value) {
            addCriterion("level_of_risk like", value, "levelOfRisk");
            return (Criteria) this;
        }

        public Criteria andLevelOfRiskNotLike(String value) {
            addCriterion("level_of_risk not like", value, "levelOfRisk");
            return (Criteria) this;
        }

        public Criteria andLevelOfRiskIn(List<String> values) {
            addCriterion("level_of_risk in", values, "levelOfRisk");
            return (Criteria) this;
        }

        public Criteria andLevelOfRiskNotIn(List<String> values) {
            addCriterion("level_of_risk not in", values, "levelOfRisk");
            return (Criteria) this;
        }

        public Criteria andLevelOfRiskBetween(String value1, String value2) {
            addCriterion("level_of_risk between", value1, value2, "levelOfRisk");
            return (Criteria) this;
        }

        public Criteria andLevelOfRiskNotBetween(String value1, String value2) {
            addCriterion("level_of_risk not between", value1, value2, "levelOfRisk");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNull() {
            addCriterion("phone_number is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNotNull() {
            addCriterion("phone_number is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberEqualTo(String value) {
            addCriterion("phone_number =", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotEqualTo(String value) {
            addCriterion("phone_number <>", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThan(String value) {
            addCriterion("phone_number >", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThanOrEqualTo(String value) {
            addCriterion("phone_number >=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThan(String value) {
            addCriterion("phone_number <", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThanOrEqualTo(String value) {
            addCriterion("phone_number <=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLike(String value) {
            addCriterion("phone_number like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotLike(String value) {
            addCriterion("phone_number not like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIn(List<String> values) {
            addCriterion("phone_number in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotIn(List<String> values) {
            addCriterion("phone_number not in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberBetween(String value1, String value2) {
            addCriterion("phone_number between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotBetween(String value1, String value2) {
            addCriterion("phone_number not between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNull() {
            addCriterion("addtime is null");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNotNull() {
            addCriterion("addtime is not null");
            return (Criteria) this;
        }

        public Criteria andAddtimeEqualTo(Date value) {
            addCriterion("addtime =", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotEqualTo(Date value) {
            addCriterion("addtime <>", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThan(Date value) {
            addCriterion("addtime >", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("addtime >=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThan(Date value) {
            addCriterion("addtime <", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThanOrEqualTo(Date value) {
            addCriterion("addtime <=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIn(List<Date> values) {
            addCriterion("addtime in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotIn(List<Date> values) {
            addCriterion("addtime not in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeBetween(Date value1, Date value2) {
            addCriterion("addtime between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotBetween(Date value1, Date value2) {
            addCriterion("addtime not between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andUpptimeIsNull() {
            addCriterion("upptime is null");
            return (Criteria) this;
        }

        public Criteria andUpptimeIsNotNull() {
            addCriterion("upptime is not null");
            return (Criteria) this;
        }

        public Criteria andUpptimeEqualTo(Date value) {
            addCriterion("upptime =", value, "upptime");
            return (Criteria) this;
        }

        public Criteria andUpptimeNotEqualTo(Date value) {
            addCriterion("upptime <>", value, "upptime");
            return (Criteria) this;
        }

        public Criteria andUpptimeGreaterThan(Date value) {
            addCriterion("upptime >", value, "upptime");
            return (Criteria) this;
        }

        public Criteria andUpptimeGreaterThanOrEqualTo(Date value) {
            addCriterion("upptime >=", value, "upptime");
            return (Criteria) this;
        }

        public Criteria andUpptimeLessThan(Date value) {
            addCriterion("upptime <", value, "upptime");
            return (Criteria) this;
        }

        public Criteria andUpptimeLessThanOrEqualTo(Date value) {
            addCriterion("upptime <=", value, "upptime");
            return (Criteria) this;
        }

        public Criteria andUpptimeIn(List<Date> values) {
            addCriterion("upptime in", values, "upptime");
            return (Criteria) this;
        }

        public Criteria andUpptimeNotIn(List<Date> values) {
            addCriterion("upptime not in", values, "upptime");
            return (Criteria) this;
        }

        public Criteria andUpptimeBetween(Date value1, Date value2) {
            addCriterion("upptime between", value1, value2, "upptime");
            return (Criteria) this;
        }

        public Criteria andUpptimeNotBetween(Date value1, Date value2) {
            addCriterion("upptime not between", value1, value2, "upptime");
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
        public Criteria andHeadIconIsNull() {
            addCriterion("head_icon is null");
            return (Criteria) this;
        }

        public Criteria andHeadIconIsNotNull() {
            addCriterion("head_icon is not null");
            return (Criteria) this;
        }

        public Criteria andHeadIconEqualTo(String value) {
            addCriterion("head_icon =", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconNotEqualTo(String value) {
            addCriterion("head_icon <>", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconGreaterThan(String value) {
            addCriterion("head_icon >", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconGreaterThanOrEqualTo(String value) {
            addCriterion("head_icon >=", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconLessThan(String value) {
            addCriterion("head_icon <", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconLessThanOrEqualTo(String value) {
            addCriterion("head_icon <=", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconLike(String value) {
            addCriterion("head_icon like", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconNotLike(String value) {
            addCriterion("head_icon not like", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconIn(List<String> values) {
            addCriterion("head_icon in", values, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconNotIn(List<String> values) {
            addCriterion("head_icon not in", values, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconBetween(String value1, String value2) {
            addCriterion("head_icon between", value1, value2, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconNotBetween(String value1, String value2) {
            addCriterion("head_icon not between", value1, value2, "headIcon");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidIsNull() {
            addCriterion("wechat_openid is null");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidIsNotNull() {
            addCriterion("wechat_openid is not null");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidEqualTo(String value) {
            addCriterion("wechat_openid =", value, "wechatOpenid");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidNotEqualTo(String value) {
            addCriterion("wechat_openid <>", value, "wechatOpenid");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidGreaterThan(String value) {
            addCriterion("wechat_openid >", value, "wechatOpenid");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_openid >=", value, "wechatOpenid");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidLessThan(String value) {
            addCriterion("wechat_openid <", value, "wechatOpenid");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidLessThanOrEqualTo(String value) {
            addCriterion("wechat_openid <=", value, "wechatOpenid");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidLike(String value) {
            addCriterion("wechat_openid like", value, "wechatOpenid");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidNotLike(String value) {
            addCriterion("wechat_openid not like", value, "wechatOpenid");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidIn(List<String> values) {
            addCriterion("wechat_openid in", values, "wechatOpenid");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidNotIn(List<String> values) {
            addCriterion("wechat_openid not in", values, "wechatOpenid");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidBetween(String value1, String value2) {
            addCriterion("wechat_openid between", value1, value2, "wechatOpenid");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidNotBetween(String value1, String value2) {
            addCriterion("wechat_openid not between", value1, value2, "wechatOpenid");
            return (Criteria) this;
        }

        public Criteria andWechatNicknameIsNull() {
            addCriterion("wechat_nickname is null");
            return (Criteria) this;
        }

        public Criteria andWechatNicknameIsNotNull() {
            addCriterion("wechat_nickname is not null");
            return (Criteria) this;
        }

        public Criteria andWechatNicknameEqualTo(String value) {
            addCriterion("wechat_nickname =", value, "wechatNickname");
            return (Criteria) this;
        }

        public Criteria andWechatNicknameNotEqualTo(String value) {
            addCriterion("wechat_nickname <>", value, "wechatNickname");
            return (Criteria) this;
        }

        public Criteria andWechatNicknameGreaterThan(String value) {
            addCriterion("wechat_nickname >", value, "wechatNickname");
            return (Criteria) this;
        }

        public Criteria andWechatNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_nickname >=", value, "wechatNickname");
            return (Criteria) this;
        }

        public Criteria andWechatNicknameLessThan(String value) {
            addCriterion("wechat_nickname <", value, "wechatNickname");
            return (Criteria) this;
        }

        public Criteria andWechatNicknameLessThanOrEqualTo(String value) {
            addCriterion("wechat_nickname <=", value, "wechatNickname");
            return (Criteria) this;
        }

        public Criteria andWechatNicknameLike(String value) {
            addCriterion("wechat_nickname like", value, "wechatNickname");
            return (Criteria) this;
        }

        public Criteria andWechatNicknameNotLike(String value) {
            addCriterion("wechat_nickname not like", value, "wechatNickname");
            return (Criteria) this;
        }

        public Criteria andWechatNicknameIn(List<String> values) {
            addCriterion("wechat_nickname in", values, "wechatNickname");
            return (Criteria) this;
        }

        public Criteria andWechatNicknameNotIn(List<String> values) {
            addCriterion("wechat_nickname not in", values, "wechatNickname");
            return (Criteria) this;
        }

        public Criteria andWechatNicknameBetween(String value1, String value2) {
            addCriterion("wechat_nickname between", value1, value2, "wechatNickname");
            return (Criteria) this;
        }

        public Criteria andWechatNicknameNotBetween(String value1, String value2) {
            addCriterion("wechat_nickname not between", value1, value2, "wechatNickname");
            return (Criteria) this;
        }

        public Criteria andWechatHeadimgurlIsNull() {
            addCriterion("wechat_headimgurl is null");
            return (Criteria) this;
        }

        public Criteria andWechatHeadimgurlIsNotNull() {
            addCriterion("wechat_headimgurl is not null");
            return (Criteria) this;
        }

        public Criteria andWechatHeadimgurlEqualTo(String value) {
            addCriterion("wechat_headimgurl =", value, "wechatHeadimgurl");
            return (Criteria) this;
        }

        public Criteria andWechatHeadimgurlNotEqualTo(String value) {
            addCriterion("wechat_headimgurl <>", value, "wechatHeadimgurl");
            return (Criteria) this;
        }

        public Criteria andWechatHeadimgurlGreaterThan(String value) {
            addCriterion("wechat_headimgurl >", value, "wechatHeadimgurl");
            return (Criteria) this;
        }

        public Criteria andWechatHeadimgurlGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_headimgurl >=", value, "wechatHeadimgurl");
            return (Criteria) this;
        }

        public Criteria andWechatHeadimgurlLessThan(String value) {
            addCriterion("wechat_headimgurl <", value, "wechatHeadimgurl");
            return (Criteria) this;
        }

        public Criteria andWechatHeadimgurlLessThanOrEqualTo(String value) {
            addCriterion("wechat_headimgurl <=", value, "wechatHeadimgurl");
            return (Criteria) this;
        }

        public Criteria andWechatHeadimgurlLike(String value) {
            addCriterion("wechat_headimgurl like", value, "wechatHeadimgurl");
            return (Criteria) this;
        }

        public Criteria andWechatHeadimgurlNotLike(String value) {
            addCriterion("wechat_headimgurl not like", value, "wechatHeadimgurl");
            return (Criteria) this;
        }

        public Criteria andWechatHeadimgurlIn(List<String> values) {
            addCriterion("wechat_headimgurl in", values, "wechatHeadimgurl");
            return (Criteria) this;
        }

        public Criteria andWechatHeadimgurlNotIn(List<String> values) {
            addCriterion("wechat_headimgurl not in", values, "wechatHeadimgurl");
            return (Criteria) this;
        }

        public Criteria andWechatHeadimgurlBetween(String value1, String value2) {
            addCriterion("wechat_headimgurl between", value1, value2, "wechatHeadimgurl");
            return (Criteria) this;
        }

        public Criteria andWechatHeadimgurlNotBetween(String value1, String value2) {
            addCriterion("wechat_headimgurl not between", value1, value2, "wechatHeadimgurl");
            return (Criteria) this;
        }

        public Criteria andJdDataIsNull() {
            addCriterion("jd_data is null");
            return (Criteria) this;
        }

        public Criteria andJdDataIsNotNull() {
            addCriterion("jd_data is not null");
            return (Criteria) this;
        }

        public Criteria andJdDataEqualTo(String value) {
            addCriterion("jd_data =", value, "jdData");
            return (Criteria) this;
        }

        public Criteria andJdDataNotEqualTo(String value) {
            addCriterion("jd_data <>", value, "jdData");
            return (Criteria) this;
        }

        public Criteria andJdDataGreaterThan(String value) {
            addCriterion("jd_data >", value, "jdData");
            return (Criteria) this;
        }

        public Criteria andJdDataGreaterThanOrEqualTo(String value) {
            addCriterion("jd_data >=", value, "jdData");
            return (Criteria) this;
        }

        public Criteria andJdDataLessThan(String value) {
            addCriterion("jd_data <", value, "jdData");
            return (Criteria) this;
        }

        public Criteria andJdDataLessThanOrEqualTo(String value) {
            addCriterion("jd_data <=", value, "jdData");
            return (Criteria) this;
        }

        public Criteria andJdDataLike(String value) {
            addCriterion("jd_data like", value, "jdData");
            return (Criteria) this;
        }

        public Criteria andJdDataNotLike(String value) {
            addCriterion("jd_data not like", value, "jdData");
            return (Criteria) this;
        }

        public Criteria andJdDataIn(List<String> values) {
            addCriterion("jd_data in", values, "jdData");
            return (Criteria) this;
        }

        public Criteria andJdDataNotIn(List<String> values) {
            addCriterion("jd_data not in", values, "jdData");
            return (Criteria) this;
        }

        public Criteria andJdDataBetween(String value1, String value2) {
            addCriterion("jd_data between", value1, value2, "jdData");
            return (Criteria) this;
        }

        public Criteria andJdDataNotBetween(String value1, String value2) {
            addCriterion("jd_data not between", value1, value2, "jdData");
            return (Criteria) this;
        }

        public Criteria andJxlDataIsNull() {
            addCriterion("Jxl_data is null");
            return (Criteria) this;
        }

        public Criteria andJxlDataIsNotNull() {
            addCriterion("Jxl_data is not null");
            return (Criteria) this;
        }

        public Criteria andJxlDataEqualTo(String value) {
            addCriterion("Jxl_data =", value, "jxlData");
            return (Criteria) this;
        }

        public Criteria andJxlDataNotEqualTo(String value) {
            addCriterion("Jxl_data <>", value, "jxlData");
            return (Criteria) this;
        }

        public Criteria andJxlDataGreaterThan(String value) {
            addCriterion("Jxl_data >", value, "jxlData");
            return (Criteria) this;
        }

        public Criteria andJxlDataGreaterThanOrEqualTo(String value) {
            addCriterion("Jxl_data >=", value, "jxlData");
            return (Criteria) this;
        }

        public Criteria andJxlDataLessThan(String value) {
            addCriterion("Jxl_data <", value, "jxlData");
            return (Criteria) this;
        }

        public Criteria andJxlDataLessThanOrEqualTo(String value) {
            addCriterion("Jxl_data <=", value, "jxlData");
            return (Criteria) this;
        }

        public Criteria andJxlDataLike(String value) {
            addCriterion("Jxl_data like", value, "jxlData");
            return (Criteria) this;
        }

        public Criteria andJxlDataNotLike(String value) {
            addCriterion("Jxl_data not like", value, "jxlData");
            return (Criteria) this;
        }

        public Criteria andJxlDataIn(List<String> values) {
            addCriterion("Jxl_data in", values, "jxlData");
            return (Criteria) this;
        }

        public Criteria andJxlDataNotIn(List<String> values) {
            addCriterion("Jxl_data not in", values, "jxlData");
            return (Criteria) this;
        }

        public Criteria andJxlDataBetween(String value1, String value2) {
            addCriterion("Jxl_data between", value1, value2, "jxlData");
            return (Criteria) this;
        }

        public Criteria andJxlDataNotBetween(String value1, String value2) {
            addCriterion("Jxl_data not between", value1, value2, "jxlData");
            return (Criteria) this;
        }
 public Criteria andMaxAmountIsNull() {
            addCriterion("max_amount is null");
            return (Criteria) this;
        }

        public Criteria andMaxAmountIsNotNull() {
            addCriterion("max_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMaxAmountEqualTo(BigDecimal value) {
            addCriterion("max_amount =", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountNotEqualTo(BigDecimal value) {
            addCriterion("max_amount <>", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountGreaterThan(BigDecimal value) {
            addCriterion("max_amount >", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("max_amount >=", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountLessThan(BigDecimal value) {
            addCriterion("max_amount <", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("max_amount <=", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountIn(List<BigDecimal> values) {
            addCriterion("max_amount in", values, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountNotIn(List<BigDecimal> values) {
            addCriterion("max_amount not in", values, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_amount between", value1, value2, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_amount not between", value1, value2, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andBillsTrueAmountIsNull() {
            addCriterion("bills_true_amount is null");
            return (Criteria) this;
        }

        public Criteria andBillsTrueAmountIsNotNull() {
            addCriterion("bills_true_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBillsTrueAmountEqualTo(BigDecimal value) {
            addCriterion("bills_true_amount =", value, "billsTrueAmount");
            return (Criteria) this;
        }

        public Criteria andBillsTrueAmountNotEqualTo(BigDecimal value) {
            addCriterion("bills_true_amount <>", value, "billsTrueAmount");
            return (Criteria) this;
        }

        public Criteria andBillsTrueAmountGreaterThan(BigDecimal value) {
            addCriterion("bills_true_amount >", value, "billsTrueAmount");
            return (Criteria) this;
        }

        public Criteria andBillsTrueAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bills_true_amount >=", value, "billsTrueAmount");
            return (Criteria) this;
        }

        public Criteria andBillsTrueAmountLessThan(BigDecimal value) {
            addCriterion("bills_true_amount <", value, "billsTrueAmount");
            return (Criteria) this;
        }

        public Criteria andBillsTrueAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bills_true_amount <=", value, "billsTrueAmount");
            return (Criteria) this;
        }

        public Criteria andBillsTrueAmountIn(List<BigDecimal> values) {
            addCriterion("bills_true_amount in", values, "billsTrueAmount");
            return (Criteria) this;
        }

        public Criteria andBillsTrueAmountNotIn(List<BigDecimal> values) {
            addCriterion("bills_true_amount not in", values, "billsTrueAmount");
            return (Criteria) this;
        }

        public Criteria andBillsTrueAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bills_true_amount between", value1, value2, "billsTrueAmount");
            return (Criteria) this;
        }

        public Criteria andBillsTrueAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bills_true_amount not between", value1, value2, "billsTrueAmount");
            return (Criteria) this;
        }

        public Criteria andBillsFalseAmountIsNull() {
            addCriterion("bills_false_amount is null");
            return (Criteria) this;
        }

        public Criteria andBillsFalseAmountIsNotNull() {
            addCriterion("bills_false_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBillsFalseAmountEqualTo(BigDecimal value) {
            addCriterion("bills_false_amount =", value, "billsFalseAmount");
            return (Criteria) this;
        }

        public Criteria andBillsFalseAmountNotEqualTo(BigDecimal value) {
            addCriterion("bills_false_amount <>", value, "billsFalseAmount");
            return (Criteria) this;
        }

        public Criteria andBillsFalseAmountGreaterThan(BigDecimal value) {
            addCriterion("bills_false_amount >", value, "billsFalseAmount");
            return (Criteria) this;
        }

        public Criteria andBillsFalseAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bills_false_amount >=", value, "billsFalseAmount");
            return (Criteria) this;
        }

        public Criteria andBillsFalseAmountLessThan(BigDecimal value) {
            addCriterion("bills_false_amount <", value, "billsFalseAmount");
            return (Criteria) this;
        }

        public Criteria andBillsFalseAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bills_false_amount <=", value, "billsFalseAmount");
            return (Criteria) this;
        }

        public Criteria andBillsFalseAmountIn(List<BigDecimal> values) {
            addCriterion("bills_false_amount in", values, "billsFalseAmount");
            return (Criteria) this;
        }

        public Criteria andBillsFalseAmountNotIn(List<BigDecimal> values) {
            addCriterion("bills_false_amount not in", values, "billsFalseAmount");
            return (Criteria) this;
        }

        public Criteria andBillsFalseAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bills_false_amount between", value1, value2, "billsFalseAmount");
            return (Criteria) this;
        }

        public Criteria andBillsFalseAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bills_false_amount not between", value1, value2, "billsFalseAmount");
            return (Criteria) this;
        }

        public Criteria andPrepaymentAmountIsNull() {
            addCriterion("prepayment_amount is null");
            return (Criteria) this;
        }

        public Criteria andPrepaymentAmountIsNotNull() {
            addCriterion("prepayment_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPrepaymentAmountEqualTo(BigDecimal value) {
            addCriterion("prepayment_amount =", value, "prepaymentAmount");
            return (Criteria) this;
        }

        public Criteria andPrepaymentAmountNotEqualTo(BigDecimal value) {
            addCriterion("prepayment_amount <>", value, "prepaymentAmount");
            return (Criteria) this;
        }

        public Criteria andPrepaymentAmountGreaterThan(BigDecimal value) {
            addCriterion("prepayment_amount >", value, "prepaymentAmount");
            return (Criteria) this;
        }

        public Criteria andPrepaymentAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("prepayment_amount >=", value, "prepaymentAmount");
            return (Criteria) this;
        }

        public Criteria andPrepaymentAmountLessThan(BigDecimal value) {
            addCriterion("prepayment_amount <", value, "prepaymentAmount");
            return (Criteria) this;
        }

        public Criteria andPrepaymentAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("prepayment_amount <=", value, "prepaymentAmount");
            return (Criteria) this;
        }

        public Criteria andPrepaymentAmountIn(List<BigDecimal> values) {
            addCriterion("prepayment_amount in", values, "prepaymentAmount");
            return (Criteria) this;
        }

        public Criteria andPrepaymentAmountNotIn(List<BigDecimal> values) {
            addCriterion("prepayment_amount not in", values, "prepaymentAmount");
            return (Criteria) this;
        }

        public Criteria andPrepaymentAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("prepayment_amount between", value1, value2, "prepaymentAmount");
            return (Criteria) this;
        }

        public Criteria andPrepaymentAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("prepayment_amount not between", value1, value2, "prepaymentAmount");
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
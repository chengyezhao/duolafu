package com.shoumipay.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberBankcardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberBankcardExample() {
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

        public Criteria andCardidIsNull() {
            addCriterion("cardId is null");
            return (Criteria) this;
        }

        public Criteria andCardidIsNotNull() {
            addCriterion("cardId is not null");
            return (Criteria) this;
        }

        public Criteria andCardidEqualTo(Long value) {
            addCriterion("cardId =", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidNotEqualTo(Long value) {
            addCriterion("cardId <>", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidGreaterThan(Long value) {
            addCriterion("cardId >", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidGreaterThanOrEqualTo(Long value) {
            addCriterion("cardId >=", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidLessThan(Long value) {
            addCriterion("cardId <", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidLessThanOrEqualTo(Long value) {
            addCriterion("cardId <=", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidIn(List<Long> values) {
            addCriterion("cardId in", values, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidNotIn(List<Long> values) {
            addCriterion("cardId not in", values, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidBetween(Long value1, Long value2) {
            addCriterion("cardId between", value1, value2, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidNotBetween(Long value1, Long value2) {
            addCriterion("cardId not between", value1, value2, "cardid");
            return (Criteria) this;
        }

        public Criteria andBankcardNumberIsNull() {
            addCriterion("bankCard_Number is null");
            return (Criteria) this;
        }

        public Criteria andBankcardNumberIsNotNull() {
            addCriterion("bankCard_Number is not null");
            return (Criteria) this;
        }

        public Criteria andBankcardNumberEqualTo(String value) {
            addCriterion("bankCard_Number =", value, "bankcardNumber");
            return (Criteria) this;
        }

        public Criteria andBankcardNumberNotEqualTo(String value) {
            addCriterion("bankCard_Number <>", value, "bankcardNumber");
            return (Criteria) this;
        }

        public Criteria andBankcardNumberGreaterThan(String value) {
            addCriterion("bankCard_Number >", value, "bankcardNumber");
            return (Criteria) this;
        }

        public Criteria andBankcardNumberGreaterThanOrEqualTo(String value) {
            addCriterion("bankCard_Number >=", value, "bankcardNumber");
            return (Criteria) this;
        }

        public Criteria andBankcardNumberLessThan(String value) {
            addCriterion("bankCard_Number <", value, "bankcardNumber");
            return (Criteria) this;
        }

        public Criteria andBankcardNumberLessThanOrEqualTo(String value) {
            addCriterion("bankCard_Number <=", value, "bankcardNumber");
            return (Criteria) this;
        }

        public Criteria andBankcardNumberLike(String value) {
            addCriterion("bankCard_Number like", value, "bankcardNumber");
            return (Criteria) this;
        }

        public Criteria andBankcardNumberNotLike(String value) {
            addCriterion("bankCard_Number not like", value, "bankcardNumber");
            return (Criteria) this;
        }

        public Criteria andBankcardNumberIn(List<String> values) {
            addCriterion("bankCard_Number in", values, "bankcardNumber");
            return (Criteria) this;
        }

        public Criteria andBankcardNumberNotIn(List<String> values) {
            addCriterion("bankCard_Number not in", values, "bankcardNumber");
            return (Criteria) this;
        }

        public Criteria andBankcardNumberBetween(String value1, String value2) {
            addCriterion("bankCard_Number between", value1, value2, "bankcardNumber");
            return (Criteria) this;
        }

        public Criteria andBankcardNumberNotBetween(String value1, String value2) {
            addCriterion("bankCard_Number not between", value1, value2, "bankcardNumber");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNull() {
            addCriterion("card_type is null");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNotNull() {
            addCriterion("card_type is not null");
            return (Criteria) this;
        }

        public Criteria andCardTypeEqualTo(Integer value) {
            addCriterion("card_type =", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotEqualTo(Integer value) {
            addCriterion("card_type <>", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThan(Integer value) {
            addCriterion("card_type >", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("card_type >=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThan(Integer value) {
            addCriterion("card_type <", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThanOrEqualTo(Integer value) {
            addCriterion("card_type <=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeIn(List<Integer> values) {
            addCriterion("card_type in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotIn(List<Integer> values) {
            addCriterion("card_type not in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeBetween(Integer value1, Integer value2) {
            addCriterion("card_type between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("card_type not between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andBankCardNameIsNull() {
            addCriterion("bank_card_name is null");
            return (Criteria) this;
        }

        public Criteria andBankCardNameIsNotNull() {
            addCriterion("bank_card_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankCardNameEqualTo(String value) {
            addCriterion("bank_card_name =", value, "bankCardName");
            return (Criteria) this;
        }

        public Criteria andBankCardNameNotEqualTo(String value) {
            addCriterion("bank_card_name <>", value, "bankCardName");
            return (Criteria) this;
        }

        public Criteria andBankCardNameGreaterThan(String value) {
            addCriterion("bank_card_name >", value, "bankCardName");
            return (Criteria) this;
        }

        public Criteria andBankCardNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_card_name >=", value, "bankCardName");
            return (Criteria) this;
        }

        public Criteria andBankCardNameLessThan(String value) {
            addCriterion("bank_card_name <", value, "bankCardName");
            return (Criteria) this;
        }

        public Criteria andBankCardNameLessThanOrEqualTo(String value) {
            addCriterion("bank_card_name <=", value, "bankCardName");
            return (Criteria) this;
        }

        public Criteria andBankCardNameLike(String value) {
            addCriterion("bank_card_name like", value, "bankCardName");
            return (Criteria) this;
        }

        public Criteria andBankCardNameNotLike(String value) {
            addCriterion("bank_card_name not like", value, "bankCardName");
            return (Criteria) this;
        }

        public Criteria andBankCardNameIn(List<String> values) {
            addCriterion("bank_card_name in", values, "bankCardName");
            return (Criteria) this;
        }

        public Criteria andBankCardNameNotIn(List<String> values) {
            addCriterion("bank_card_name not in", values, "bankCardName");
            return (Criteria) this;
        }

        public Criteria andBankCardNameBetween(String value1, String value2) {
            addCriterion("bank_card_name between", value1, value2, "bankCardName");
            return (Criteria) this;
        }

        public Criteria andBankCardNameNotBetween(String value1, String value2) {
            addCriterion("bank_card_name not between", value1, value2, "bankCardName");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositIsNull() {
            addCriterion("bank_Of_Deposit is null");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositIsNotNull() {
            addCriterion("bank_Of_Deposit is not null");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositEqualTo(String value) {
            addCriterion("bank_Of_Deposit =", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositNotEqualTo(String value) {
            addCriterion("bank_Of_Deposit <>", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositGreaterThan(String value) {
            addCriterion("bank_Of_Deposit >", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositGreaterThanOrEqualTo(String value) {
            addCriterion("bank_Of_Deposit >=", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositLessThan(String value) {
            addCriterion("bank_Of_Deposit <", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositLessThanOrEqualTo(String value) {
            addCriterion("bank_Of_Deposit <=", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositLike(String value) {
            addCriterion("bank_Of_Deposit like", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositNotLike(String value) {
            addCriterion("bank_Of_Deposit not like", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositIn(List<String> values) {
            addCriterion("bank_Of_Deposit in", values, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositNotIn(List<String> values) {
            addCriterion("bank_Of_Deposit not in", values, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositBetween(String value1, String value2) {
            addCriterion("bank_Of_Deposit between", value1, value2, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositNotBetween(String value1, String value2) {
            addCriterion("bank_Of_Deposit not between", value1, value2, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andProvincesAndCitiesIsNull() {
            addCriterion("provinces_And_Cities is null");
            return (Criteria) this;
        }

        public Criteria andProvincesAndCitiesIsNotNull() {
            addCriterion("provinces_And_Cities is not null");
            return (Criteria) this;
        }

        public Criteria andProvincesAndCitiesEqualTo(String value) {
            addCriterion("provinces_And_Cities =", value, "provincesAndCities");
            return (Criteria) this;
        }

        public Criteria andProvincesAndCitiesNotEqualTo(String value) {
            addCriterion("provinces_And_Cities <>", value, "provincesAndCities");
            return (Criteria) this;
        }

        public Criteria andProvincesAndCitiesGreaterThan(String value) {
            addCriterion("provinces_And_Cities >", value, "provincesAndCities");
            return (Criteria) this;
        }

        public Criteria andProvincesAndCitiesGreaterThanOrEqualTo(String value) {
            addCriterion("provinces_And_Cities >=", value, "provincesAndCities");
            return (Criteria) this;
        }

        public Criteria andProvincesAndCitiesLessThan(String value) {
            addCriterion("provinces_And_Cities <", value, "provincesAndCities");
            return (Criteria) this;
        }

        public Criteria andProvincesAndCitiesLessThanOrEqualTo(String value) {
            addCriterion("provinces_And_Cities <=", value, "provincesAndCities");
            return (Criteria) this;
        }

        public Criteria andProvincesAndCitiesLike(String value) {
            addCriterion("provinces_And_Cities like", value, "provincesAndCities");
            return (Criteria) this;
        }

        public Criteria andProvincesAndCitiesNotLike(String value) {
            addCriterion("provinces_And_Cities not like", value, "provincesAndCities");
            return (Criteria) this;
        }

        public Criteria andProvincesAndCitiesIn(List<String> values) {
            addCriterion("provinces_And_Cities in", values, "provincesAndCities");
            return (Criteria) this;
        }

        public Criteria andProvincesAndCitiesNotIn(List<String> values) {
            addCriterion("provinces_And_Cities not in", values, "provincesAndCities");
            return (Criteria) this;
        }

        public Criteria andProvincesAndCitiesBetween(String value1, String value2) {
            addCriterion("provinces_And_Cities between", value1, value2, "provincesAndCities");
            return (Criteria) this;
        }

        public Criteria andProvincesAndCitiesNotBetween(String value1, String value2) {
            addCriterion("provinces_And_Cities not between", value1, value2, "provincesAndCities");
            return (Criteria) this;
        }

        public Criteria andOpeningBranchIsNull() {
            addCriterion("opening_Branch is null");
            return (Criteria) this;
        }

        public Criteria andOpeningBranchIsNotNull() {
            addCriterion("opening_Branch is not null");
            return (Criteria) this;
        }

        public Criteria andOpeningBranchEqualTo(String value) {
            addCriterion("opening_Branch =", value, "openingBranch");
            return (Criteria) this;
        }

        public Criteria andOpeningBranchNotEqualTo(String value) {
            addCriterion("opening_Branch <>", value, "openingBranch");
            return (Criteria) this;
        }

        public Criteria andOpeningBranchGreaterThan(String value) {
            addCriterion("opening_Branch >", value, "openingBranch");
            return (Criteria) this;
        }

        public Criteria andOpeningBranchGreaterThanOrEqualTo(String value) {
            addCriterion("opening_Branch >=", value, "openingBranch");
            return (Criteria) this;
        }

        public Criteria andOpeningBranchLessThan(String value) {
            addCriterion("opening_Branch <", value, "openingBranch");
            return (Criteria) this;
        }

        public Criteria andOpeningBranchLessThanOrEqualTo(String value) {
            addCriterion("opening_Branch <=", value, "openingBranch");
            return (Criteria) this;
        }

        public Criteria andOpeningBranchLike(String value) {
            addCriterion("opening_Branch like", value, "openingBranch");
            return (Criteria) this;
        }

        public Criteria andOpeningBranchNotLike(String value) {
            addCriterion("opening_Branch not like", value, "openingBranch");
            return (Criteria) this;
        }

        public Criteria andOpeningBranchIn(List<String> values) {
            addCriterion("opening_Branch in", values, "openingBranch");
            return (Criteria) this;
        }

        public Criteria andOpeningBranchNotIn(List<String> values) {
            addCriterion("opening_Branch not in", values, "openingBranch");
            return (Criteria) this;
        }

        public Criteria andOpeningBranchBetween(String value1, String value2) {
            addCriterion("opening_Branch between", value1, value2, "openingBranch");
            return (Criteria) this;
        }

        public Criteria andOpeningBranchNotBetween(String value1, String value2) {
            addCriterion("opening_Branch not between", value1, value2, "openingBranch");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNull() {
            addCriterion("phoneNumber is null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNotNull() {
            addCriterion("phoneNumber is not null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberEqualTo(String value) {
            addCriterion("phoneNumber =", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotEqualTo(String value) {
            addCriterion("phoneNumber <>", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThan(String value) {
            addCriterion("phoneNumber >", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThanOrEqualTo(String value) {
            addCriterion("phoneNumber >=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThan(String value) {
            addCriterion("phoneNumber <", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThanOrEqualTo(String value) {
            addCriterion("phoneNumber <=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLike(String value) {
            addCriterion("phoneNumber like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotLike(String value) {
            addCriterion("phoneNumber not like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIn(List<String> values) {
            addCriterion("phoneNumber in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotIn(List<String> values) {
            addCriterion("phoneNumber not in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberBetween(String value1, String value2) {
            addCriterion("phoneNumber between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotBetween(String value1, String value2) {
            addCriterion("phoneNumber not between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andBankCardValidityIsNull() {
            addCriterion("bank_card_validity is null");
            return (Criteria) this;
        }

        public Criteria andBankCardValidityIsNotNull() {
            addCriterion("bank_card_validity is not null");
            return (Criteria) this;
        }

        public Criteria andBankCardValidityEqualTo(Date value) {
            addCriterion("bank_card_validity =", value, "bankCardValidity");
            return (Criteria) this;
        }

        public Criteria andBankCardValidityNotEqualTo(Date value) {
            addCriterion("bank_card_validity <>", value, "bankCardValidity");
            return (Criteria) this;
        }

        public Criteria andBankCardValidityGreaterThan(Date value) {
            addCriterion("bank_card_validity >", value, "bankCardValidity");
            return (Criteria) this;
        }

        public Criteria andBankCardValidityGreaterThanOrEqualTo(Date value) {
            addCriterion("bank_card_validity >=", value, "bankCardValidity");
            return (Criteria) this;
        }

        public Criteria andBankCardValidityLessThan(Date value) {
            addCriterion("bank_card_validity <", value, "bankCardValidity");
            return (Criteria) this;
        }

        public Criteria andBankCardValidityLessThanOrEqualTo(Date value) {
            addCriterion("bank_card_validity <=", value, "bankCardValidity");
            return (Criteria) this;
        }

        public Criteria andBankCardValidityIn(List<Date> values) {
            addCriterion("bank_card_validity in", values, "bankCardValidity");
            return (Criteria) this;
        }

        public Criteria andBankCardValidityNotIn(List<Date> values) {
            addCriterion("bank_card_validity not in", values, "bankCardValidity");
            return (Criteria) this;
        }

        public Criteria andBankCardValidityBetween(Date value1, Date value2) {
            addCriterion("bank_card_validity between", value1, value2, "bankCardValidity");
            return (Criteria) this;
        }

        public Criteria andBankCardValidityNotBetween(Date value1, Date value2) {
            addCriterion("bank_card_validity not between", value1, value2, "bankCardValidity");
            return (Criteria) this;
        }

        public Criteria andAuditorIsNull() {
            addCriterion("auditor is null");
            return (Criteria) this;
        }

        public Criteria andAuditorIsNotNull() {
            addCriterion("auditor is not null");
            return (Criteria) this;
        }

        public Criteria andAuditorEqualTo(String value) {
            addCriterion("auditor =", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotEqualTo(String value) {
            addCriterion("auditor <>", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThan(String value) {
            addCriterion("auditor >", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThanOrEqualTo(String value) {
            addCriterion("auditor >=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThan(String value) {
            addCriterion("auditor <", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThanOrEqualTo(String value) {
            addCriterion("auditor <=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLike(String value) {
            addCriterion("auditor like", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotLike(String value) {
            addCriterion("auditor not like", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorIn(List<String> values) {
            addCriterion("auditor in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotIn(List<String> values) {
            addCriterion("auditor not in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorBetween(String value1, String value2) {
            addCriterion("auditor between", value1, value2, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotBetween(String value1, String value2) {
            addCriterion("auditor not between", value1, value2, "auditor");
            return (Criteria) this;
        }

        public Criteria andCardAddtimeIsNull() {
            addCriterion("card_addtime is null");
            return (Criteria) this;
        }

        public Criteria andCardAddtimeIsNotNull() {
            addCriterion("card_addtime is not null");
            return (Criteria) this;
        }

        public Criteria andCardAddtimeEqualTo(Date value) {
            addCriterion("card_addtime =", value, "cardAddtime");
            return (Criteria) this;
        }

        public Criteria andCardAddtimeNotEqualTo(Date value) {
            addCriterion("card_addtime <>", value, "cardAddtime");
            return (Criteria) this;
        }

        public Criteria andCardAddtimeGreaterThan(Date value) {
            addCriterion("card_addtime >", value, "cardAddtime");
            return (Criteria) this;
        }

        public Criteria andCardAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("card_addtime >=", value, "cardAddtime");
            return (Criteria) this;
        }

        public Criteria andCardAddtimeLessThan(Date value) {
            addCriterion("card_addtime <", value, "cardAddtime");
            return (Criteria) this;
        }

        public Criteria andCardAddtimeLessThanOrEqualTo(Date value) {
            addCriterion("card_addtime <=", value, "cardAddtime");
            return (Criteria) this;
        }

        public Criteria andCardAddtimeIn(List<Date> values) {
            addCriterion("card_addtime in", values, "cardAddtime");
            return (Criteria) this;
        }

        public Criteria andCardAddtimeNotIn(List<Date> values) {
            addCriterion("card_addtime not in", values, "cardAddtime");
            return (Criteria) this;
        }

        public Criteria andCardAddtimeBetween(Date value1, Date value2) {
            addCriterion("card_addtime between", value1, value2, "cardAddtime");
            return (Criteria) this;
        }

        public Criteria andCardAddtimeNotBetween(Date value1, Date value2) {
            addCriterion("card_addtime not between", value1, value2, "cardAddtime");
            return (Criteria) this;
        }

        public Criteria andCardUpptimeIsNull() {
            addCriterion("card_upptime is null");
            return (Criteria) this;
        }

        public Criteria andCardUpptimeIsNotNull() {
            addCriterion("card_upptime is not null");
            return (Criteria) this;
        }

        public Criteria andCardUpptimeEqualTo(Date value) {
            addCriterion("card_upptime =", value, "cardUpptime");
            return (Criteria) this;
        }

        public Criteria andCardUpptimeNotEqualTo(Date value) {
            addCriterion("card_upptime <>", value, "cardUpptime");
            return (Criteria) this;
        }

        public Criteria andCardUpptimeGreaterThan(Date value) {
            addCriterion("card_upptime >", value, "cardUpptime");
            return (Criteria) this;
        }

        public Criteria andCardUpptimeGreaterThanOrEqualTo(Date value) {
            addCriterion("card_upptime >=", value, "cardUpptime");
            return (Criteria) this;
        }

        public Criteria andCardUpptimeLessThan(Date value) {
            addCriterion("card_upptime <", value, "cardUpptime");
            return (Criteria) this;
        }

        public Criteria andCardUpptimeLessThanOrEqualTo(Date value) {
            addCriterion("card_upptime <=", value, "cardUpptime");
            return (Criteria) this;
        }

        public Criteria andCardUpptimeIn(List<Date> values) {
            addCriterion("card_upptime in", values, "cardUpptime");
            return (Criteria) this;
        }

        public Criteria andCardUpptimeNotIn(List<Date> values) {
            addCriterion("card_upptime not in", values, "cardUpptime");
            return (Criteria) this;
        }

        public Criteria andCardUpptimeBetween(Date value1, Date value2) {
            addCriterion("card_upptime between", value1, value2, "cardUpptime");
            return (Criteria) this;
        }

        public Criteria andCardUpptimeNotBetween(Date value1, Date value2) {
            addCriterion("card_upptime not between", value1, value2, "cardUpptime");
            return (Criteria) this;
        }

        public Criteria andCardBindTypeIsNull() {
            addCriterion("card_bind_type is null");
            return (Criteria) this;
        }

        public Criteria andCardBindTypeIsNotNull() {
            addCriterion("card_bind_type is not null");
            return (Criteria) this;
        }

        public Criteria andCardBindTypeEqualTo(Integer value) {
            addCriterion("card_bind_type =", value, "cardBindType");
            return (Criteria) this;
        }

        public Criteria andCardBindTypeNotEqualTo(Integer value) {
            addCriterion("card_bind_type <>", value, "cardBindType");
            return (Criteria) this;
        }

        public Criteria andCardBindTypeGreaterThan(Integer value) {
            addCriterion("card_bind_type >", value, "cardBindType");
            return (Criteria) this;
        }

        public Criteria andCardBindTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("card_bind_type >=", value, "cardBindType");
            return (Criteria) this;
        }

        public Criteria andCardBindTypeLessThan(Integer value) {
            addCriterion("card_bind_type <", value, "cardBindType");
            return (Criteria) this;
        }

        public Criteria andCardBindTypeLessThanOrEqualTo(Integer value) {
            addCriterion("card_bind_type <=", value, "cardBindType");
            return (Criteria) this;
        }

        public Criteria andCardBindTypeIn(List<Integer> values) {
            addCriterion("card_bind_type in", values, "cardBindType");
            return (Criteria) this;
        }

        public Criteria andCardBindTypeNotIn(List<Integer> values) {
            addCriterion("card_bind_type not in", values, "cardBindType");
            return (Criteria) this;
        }

        public Criteria andCardBindTypeBetween(Integer value1, Integer value2) {
            addCriterion("card_bind_type between", value1, value2, "cardBindType");
            return (Criteria) this;
        }

        public Criteria andCardBindTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("card_bind_type not between", value1, value2, "cardBindType");
            return (Criteria) this;
        }

        public Criteria andCardStateIsNull() {
            addCriterion("card_state is null");
            return (Criteria) this;
        }

        public Criteria andCardStateIsNotNull() {
            addCriterion("card_state is not null");
            return (Criteria) this;
        }

        public Criteria andCardStateEqualTo(Integer value) {
            addCriterion("card_state =", value, "cardState");
            return (Criteria) this;
        }

        public Criteria andCardStateNotEqualTo(Integer value) {
            addCriterion("card_state <>", value, "cardState");
            return (Criteria) this;
        }

        public Criteria andCardStateGreaterThan(Integer value) {
            addCriterion("card_state >", value, "cardState");
            return (Criteria) this;
        }

        public Criteria andCardStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("card_state >=", value, "cardState");
            return (Criteria) this;
        }

        public Criteria andCardStateLessThan(Integer value) {
            addCriterion("card_state <", value, "cardState");
            return (Criteria) this;
        }

        public Criteria andCardStateLessThanOrEqualTo(Integer value) {
            addCriterion("card_state <=", value, "cardState");
            return (Criteria) this;
        }

        public Criteria andCardStateIn(List<Integer> values) {
            addCriterion("card_state in", values, "cardState");
            return (Criteria) this;
        }

        public Criteria andCardStateNotIn(List<Integer> values) {
            addCriterion("card_state not in", values, "cardState");
            return (Criteria) this;
        }

        public Criteria andCardStateBetween(Integer value1, Integer value2) {
            addCriterion("card_state between", value1, value2, "cardState");
            return (Criteria) this;
        }

        public Criteria andCardStateNotBetween(Integer value1, Integer value2) {
            addCriterion("card_state not between", value1, value2, "cardState");
            return (Criteria) this;
        }

        public Criteria andCardnumIsNull() {
            addCriterion("cardNum is null");
            return (Criteria) this;
        }

        public Criteria andCardnumIsNotNull() {
            addCriterion("cardNum is not null");
            return (Criteria) this;
        }

        public Criteria andCardnumEqualTo(Integer value) {
            addCriterion("cardNum =", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumNotEqualTo(Integer value) {
            addCriterion("cardNum <>", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumGreaterThan(Integer value) {
            addCriterion("cardNum >", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("cardNum >=", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumLessThan(Integer value) {
            addCriterion("cardNum <", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumLessThanOrEqualTo(Integer value) {
            addCriterion("cardNum <=", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumIn(List<Integer> values) {
            addCriterion("cardNum in", values, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumNotIn(List<Integer> values) {
            addCriterion("cardNum not in", values, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumBetween(Integer value1, Integer value2) {
            addCriterion("cardNum between", value1, value2, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumNotBetween(Integer value1, Integer value2) {
            addCriterion("cardNum not between", value1, value2, "cardnum");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNull() {
            addCriterion("memberId is null");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNotNull() {
            addCriterion("memberId is not null");
            return (Criteria) this;
        }

        public Criteria andMemberidEqualTo(Long value) {
            addCriterion("memberId =", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotEqualTo(Long value) {
            addCriterion("memberId <>", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThan(Long value) {
            addCriterion("memberId >", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThanOrEqualTo(Long value) {
            addCriterion("memberId >=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThan(Long value) {
            addCriterion("memberId <", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThanOrEqualTo(Long value) {
            addCriterion("memberId <=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidIn(List<Long> values) {
            addCriterion("memberId in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotIn(List<Long> values) {
            addCriterion("memberId not in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidBetween(Long value1, Long value2) {
            addCriterion("memberId between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotBetween(Long value1, Long value2) {
            addCriterion("memberId not between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andCardProtocolIsNull() {
            addCriterion("card_Protocol is null");
            return (Criteria) this;
        }

        public Criteria andCardProtocolIsNotNull() {
            addCriterion("card_Protocol is not null");
            return (Criteria) this;
        }

        public Criteria andCardProtocolEqualTo(String value) {
            addCriterion("card_Protocol =", value, "cardProtocol");
            return (Criteria) this;
        }

        public Criteria andCardProtocolNotEqualTo(String value) {
            addCriterion("card_Protocol <>", value, "cardProtocol");
            return (Criteria) this;
        }

        public Criteria andCardProtocolGreaterThan(String value) {
            addCriterion("card_Protocol >", value, "cardProtocol");
            return (Criteria) this;
        }

        public Criteria andCardProtocolGreaterThanOrEqualTo(String value) {
            addCriterion("card_Protocol >=", value, "cardProtocol");
            return (Criteria) this;
        }

        public Criteria andCardProtocolLessThan(String value) {
            addCriterion("card_Protocol <", value, "cardProtocol");
            return (Criteria) this;
        }

        public Criteria andCardProtocolLessThanOrEqualTo(String value) {
            addCriterion("card_Protocol <=", value, "cardProtocol");
            return (Criteria) this;
        }

        public Criteria andCardProtocolLike(String value) {
            addCriterion("card_Protocol like", value, "cardProtocol");
            return (Criteria) this;
        }

        public Criteria andCardProtocolNotLike(String value) {
            addCriterion("card_Protocol not like", value, "cardProtocol");
            return (Criteria) this;
        }

        public Criteria andCardProtocolIn(List<String> values) {
            addCriterion("card_Protocol in", values, "cardProtocol");
            return (Criteria) this;
        }

        public Criteria andCardProtocolNotIn(List<String> values) {
            addCriterion("card_Protocol not in", values, "cardProtocol");
            return (Criteria) this;
        }

        public Criteria andCardProtocolBetween(String value1, String value2) {
            addCriterion("card_Protocol between", value1, value2, "cardProtocol");
            return (Criteria) this;
        }

        public Criteria andCardProtocolNotBetween(String value1, String value2) {
            addCriterion("card_Protocol not between", value1, value2, "cardProtocol");
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
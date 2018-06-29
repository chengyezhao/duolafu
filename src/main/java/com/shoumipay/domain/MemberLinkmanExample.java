package com.shoumipay.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberLinkmanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberLinkmanExample() {
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

        public Criteria andLinkmanNameIsNull() {
            addCriterion("linkman_name is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameIsNotNull() {
            addCriterion("linkman_name is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameEqualTo(String value) {
            addCriterion("linkman_name =", value, "linkmanName");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameNotEqualTo(String value) {
            addCriterion("linkman_name <>", value, "linkmanName");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameGreaterThan(String value) {
            addCriterion("linkman_name >", value, "linkmanName");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameGreaterThanOrEqualTo(String value) {
            addCriterion("linkman_name >=", value, "linkmanName");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameLessThan(String value) {
            addCriterion("linkman_name <", value, "linkmanName");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameLessThanOrEqualTo(String value) {
            addCriterion("linkman_name <=", value, "linkmanName");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameLike(String value) {
            addCriterion("linkman_name like", value, "linkmanName");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameNotLike(String value) {
            addCriterion("linkman_name not like", value, "linkmanName");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameIn(List<String> values) {
            addCriterion("linkman_name in", values, "linkmanName");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameNotIn(List<String> values) {
            addCriterion("linkman_name not in", values, "linkmanName");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameBetween(String value1, String value2) {
            addCriterion("linkman_name between", value1, value2, "linkmanName");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameNotBetween(String value1, String value2) {
            addCriterion("linkman_name not between", value1, value2, "linkmanName");
            return (Criteria) this;
        }

        public Criteria andLinkmanRelationIsNull() {
            addCriterion("linkman_relation is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanRelationIsNotNull() {
            addCriterion("linkman_relation is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanRelationEqualTo(Integer value) {
            addCriterion("linkman_relation =", value, "linkmanRelation");
            return (Criteria) this;
        }

        public Criteria andLinkmanRelationNotEqualTo(Integer value) {
            addCriterion("linkman_relation <>", value, "linkmanRelation");
            return (Criteria) this;
        }

        public Criteria andLinkmanRelationGreaterThan(Integer value) {
            addCriterion("linkman_relation >", value, "linkmanRelation");
            return (Criteria) this;
        }

        public Criteria andLinkmanRelationGreaterThanOrEqualTo(Integer value) {
            addCriterion("linkman_relation >=", value, "linkmanRelation");
            return (Criteria) this;
        }

        public Criteria andLinkmanRelationLessThan(Integer value) {
            addCriterion("linkman_relation <", value, "linkmanRelation");
            return (Criteria) this;
        }

        public Criteria andLinkmanRelationLessThanOrEqualTo(Integer value) {
            addCriterion("linkman_relation <=", value, "linkmanRelation");
            return (Criteria) this;
        }

        public Criteria andLinkmanRelationIn(List<Integer> values) {
            addCriterion("linkman_relation in", values, "linkmanRelation");
            return (Criteria) this;
        }

        public Criteria andLinkmanRelationNotIn(List<Integer> values) {
            addCriterion("linkman_relation not in", values, "linkmanRelation");
            return (Criteria) this;
        }

        public Criteria andLinkmanRelationBetween(Integer value1, Integer value2) {
            addCriterion("linkman_relation between", value1, value2, "linkmanRelation");
            return (Criteria) this;
        }

        public Criteria andLinkmanRelationNotBetween(Integer value1, Integer value2) {
            addCriterion("linkman_relation not between", value1, value2, "linkmanRelation");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneIsNull() {
            addCriterion("linkman_phone is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneIsNotNull() {
            addCriterion("linkman_phone is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneEqualTo(String value) {
            addCriterion("linkman_phone =", value, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneNotEqualTo(String value) {
            addCriterion("linkman_phone <>", value, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneGreaterThan(String value) {
            addCriterion("linkman_phone >", value, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("linkman_phone >=", value, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneLessThan(String value) {
            addCriterion("linkman_phone <", value, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneLessThanOrEqualTo(String value) {
            addCriterion("linkman_phone <=", value, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneLike(String value) {
            addCriterion("linkman_phone like", value, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneNotLike(String value) {
            addCriterion("linkman_phone not like", value, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneIn(List<String> values) {
            addCriterion("linkman_phone in", values, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneNotIn(List<String> values) {
            addCriterion("linkman_phone not in", values, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneBetween(String value1, String value2) {
            addCriterion("linkman_phone between", value1, value2, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneNotBetween(String value1, String value2) {
            addCriterion("linkman_phone not between", value1, value2, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddtimeIsNull() {
            addCriterion("linkman_addtime is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddtimeIsNotNull() {
            addCriterion("linkman_addtime is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddtimeEqualTo(Date value) {
            addCriterion("linkman_addtime =", value, "linkmanAddtime");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddtimeNotEqualTo(Date value) {
            addCriterion("linkman_addtime <>", value, "linkmanAddtime");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddtimeGreaterThan(Date value) {
            addCriterion("linkman_addtime >", value, "linkmanAddtime");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("linkman_addtime >=", value, "linkmanAddtime");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddtimeLessThan(Date value) {
            addCriterion("linkman_addtime <", value, "linkmanAddtime");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddtimeLessThanOrEqualTo(Date value) {
            addCriterion("linkman_addtime <=", value, "linkmanAddtime");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddtimeIn(List<Date> values) {
            addCriterion("linkman_addtime in", values, "linkmanAddtime");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddtimeNotIn(List<Date> values) {
            addCriterion("linkman_addtime not in", values, "linkmanAddtime");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddtimeBetween(Date value1, Date value2) {
            addCriterion("linkman_addtime between", value1, value2, "linkmanAddtime");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddtimeNotBetween(Date value1, Date value2) {
            addCriterion("linkman_addtime not between", value1, value2, "linkmanAddtime");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelIsNull() {
            addCriterion("linkman_Add_channel is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelIsNotNull() {
            addCriterion("linkman_Add_channel is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelEqualTo(String value) {
            addCriterion("linkman_Add_channel =", value, "linkmanAddChannel");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelNotEqualTo(String value) {
            addCriterion("linkman_Add_channel <>", value, "linkmanAddChannel");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelGreaterThan(String value) {
            addCriterion("linkman_Add_channel >", value, "linkmanAddChannel");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelGreaterThanOrEqualTo(String value) {
            addCriterion("linkman_Add_channel >=", value, "linkmanAddChannel");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelLessThan(String value) {
            addCriterion("linkman_Add_channel <", value, "linkmanAddChannel");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelLessThanOrEqualTo(String value) {
            addCriterion("linkman_Add_channel <=", value, "linkmanAddChannel");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelLike(String value) {
            addCriterion("linkman_Add_channel like", value, "linkmanAddChannel");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelNotLike(String value) {
            addCriterion("linkman_Add_channel not like", value, "linkmanAddChannel");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelIn(List<String> values) {
            addCriterion("linkman_Add_channel in", values, "linkmanAddChannel");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelNotIn(List<String> values) {
            addCriterion("linkman_Add_channel not in", values, "linkmanAddChannel");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelBetween(String value1, String value2) {
            addCriterion("linkman_Add_channel between", value1, value2, "linkmanAddChannel");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelNotBetween(String value1, String value2) {
            addCriterion("linkman_Add_channel not between", value1, value2, "linkmanAddChannel");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameTwoIsNull() {
            addCriterion("linkman_name_two is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameTwoIsNotNull() {
            addCriterion("linkman_name_two is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameTwoEqualTo(String value) {
            addCriterion("linkman_name_two =", value, "linkmanNameTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameTwoNotEqualTo(String value) {
            addCriterion("linkman_name_two <>", value, "linkmanNameTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameTwoGreaterThan(String value) {
            addCriterion("linkman_name_two >", value, "linkmanNameTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameTwoGreaterThanOrEqualTo(String value) {
            addCriterion("linkman_name_two >=", value, "linkmanNameTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameTwoLessThan(String value) {
            addCriterion("linkman_name_two <", value, "linkmanNameTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameTwoLessThanOrEqualTo(String value) {
            addCriterion("linkman_name_two <=", value, "linkmanNameTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameTwoLike(String value) {
            addCriterion("linkman_name_two like", value, "linkmanNameTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameTwoNotLike(String value) {
            addCriterion("linkman_name_two not like", value, "linkmanNameTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameTwoIn(List<String> values) {
            addCriterion("linkman_name_two in", values, "linkmanNameTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameTwoNotIn(List<String> values) {
            addCriterion("linkman_name_two not in", values, "linkmanNameTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameTwoBetween(String value1, String value2) {
            addCriterion("linkman_name_two between", value1, value2, "linkmanNameTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameTwoNotBetween(String value1, String value2) {
            addCriterion("linkman_name_two not between", value1, value2, "linkmanNameTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanRelationTwoIsNull() {
            addCriterion("linkman_relation_two is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanRelationTwoIsNotNull() {
            addCriterion("linkman_relation_two is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanRelationTwoEqualTo(Integer value) {
            addCriterion("linkman_relation_two =", value, "linkmanRelationTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanRelationTwoNotEqualTo(Integer value) {
            addCriterion("linkman_relation_two <>", value, "linkmanRelationTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanRelationTwoGreaterThan(Integer value) {
            addCriterion("linkman_relation_two >", value, "linkmanRelationTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanRelationTwoGreaterThanOrEqualTo(Integer value) {
            addCriterion("linkman_relation_two >=", value, "linkmanRelationTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanRelationTwoLessThan(Integer value) {
            addCriterion("linkman_relation_two <", value, "linkmanRelationTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanRelationTwoLessThanOrEqualTo(Integer value) {
            addCriterion("linkman_relation_two <=", value, "linkmanRelationTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanRelationTwoIn(List<Integer> values) {
            addCriterion("linkman_relation_two in", values, "linkmanRelationTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanRelationTwoNotIn(List<Integer> values) {
            addCriterion("linkman_relation_two not in", values, "linkmanRelationTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanRelationTwoBetween(Integer value1, Integer value2) {
            addCriterion("linkman_relation_two between", value1, value2, "linkmanRelationTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanRelationTwoNotBetween(Integer value1, Integer value2) {
            addCriterion("linkman_relation_two not between", value1, value2, "linkmanRelationTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneTwoIsNull() {
            addCriterion("linkman_phone_two is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneTwoIsNotNull() {
            addCriterion("linkman_phone_two is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneTwoEqualTo(String value) {
            addCriterion("linkman_phone_two =", value, "linkmanPhoneTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneTwoNotEqualTo(String value) {
            addCriterion("linkman_phone_two <>", value, "linkmanPhoneTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneTwoGreaterThan(String value) {
            addCriterion("linkman_phone_two >", value, "linkmanPhoneTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneTwoGreaterThanOrEqualTo(String value) {
            addCriterion("linkman_phone_two >=", value, "linkmanPhoneTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneTwoLessThan(String value) {
            addCriterion("linkman_phone_two <", value, "linkmanPhoneTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneTwoLessThanOrEqualTo(String value) {
            addCriterion("linkman_phone_two <=", value, "linkmanPhoneTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneTwoLike(String value) {
            addCriterion("linkman_phone_two like", value, "linkmanPhoneTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneTwoNotLike(String value) {
            addCriterion("linkman_phone_two not like", value, "linkmanPhoneTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneTwoIn(List<String> values) {
            addCriterion("linkman_phone_two in", values, "linkmanPhoneTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneTwoNotIn(List<String> values) {
            addCriterion("linkman_phone_two not in", values, "linkmanPhoneTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneTwoBetween(String value1, String value2) {
            addCriterion("linkman_phone_two between", value1, value2, "linkmanPhoneTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneTwoNotBetween(String value1, String value2) {
            addCriterion("linkman_phone_two not between", value1, value2, "linkmanPhoneTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddtimeTwoIsNull() {
            addCriterion("linkman_addtime_two is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddtimeTwoIsNotNull() {
            addCriterion("linkman_addtime_two is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddtimeTwoEqualTo(Date value) {
            addCriterion("linkman_addtime_two =", value, "linkmanAddtimeTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddtimeTwoNotEqualTo(Date value) {
            addCriterion("linkman_addtime_two <>", value, "linkmanAddtimeTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddtimeTwoGreaterThan(Date value) {
            addCriterion("linkman_addtime_two >", value, "linkmanAddtimeTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddtimeTwoGreaterThanOrEqualTo(Date value) {
            addCriterion("linkman_addtime_two >=", value, "linkmanAddtimeTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddtimeTwoLessThan(Date value) {
            addCriterion("linkman_addtime_two <", value, "linkmanAddtimeTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddtimeTwoLessThanOrEqualTo(Date value) {
            addCriterion("linkman_addtime_two <=", value, "linkmanAddtimeTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddtimeTwoIn(List<Date> values) {
            addCriterion("linkman_addtime_two in", values, "linkmanAddtimeTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddtimeTwoNotIn(List<Date> values) {
            addCriterion("linkman_addtime_two not in", values, "linkmanAddtimeTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddtimeTwoBetween(Date value1, Date value2) {
            addCriterion("linkman_addtime_two between", value1, value2, "linkmanAddtimeTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddtimeTwoNotBetween(Date value1, Date value2) {
            addCriterion("linkman_addtime_two not between", value1, value2, "linkmanAddtimeTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelTwoIsNull() {
            addCriterion("linkman_Add_channel_two is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelTwoIsNotNull() {
            addCriterion("linkman_Add_channel_two is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelTwoEqualTo(String value) {
            addCriterion("linkman_Add_channel_two =", value, "linkmanAddChannelTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelTwoNotEqualTo(String value) {
            addCriterion("linkman_Add_channel_two <>", value, "linkmanAddChannelTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelTwoGreaterThan(String value) {
            addCriterion("linkman_Add_channel_two >", value, "linkmanAddChannelTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelTwoGreaterThanOrEqualTo(String value) {
            addCriterion("linkman_Add_channel_two >=", value, "linkmanAddChannelTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelTwoLessThan(String value) {
            addCriterion("linkman_Add_channel_two <", value, "linkmanAddChannelTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelTwoLessThanOrEqualTo(String value) {
            addCriterion("linkman_Add_channel_two <=", value, "linkmanAddChannelTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelTwoLike(String value) {
            addCriterion("linkman_Add_channel_two like", value, "linkmanAddChannelTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelTwoNotLike(String value) {
            addCriterion("linkman_Add_channel_two not like", value, "linkmanAddChannelTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelTwoIn(List<String> values) {
            addCriterion("linkman_Add_channel_two in", values, "linkmanAddChannelTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelTwoNotIn(List<String> values) {
            addCriterion("linkman_Add_channel_two not in", values, "linkmanAddChannelTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelTwoBetween(String value1, String value2) {
            addCriterion("linkman_Add_channel_two between", value1, value2, "linkmanAddChannelTwo");
            return (Criteria) this;
        }

        public Criteria andLinkmanAddChannelTwoNotBetween(String value1, String value2) {
            addCriterion("linkman_Add_channel_two not between", value1, value2, "linkmanAddChannelTwo");
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
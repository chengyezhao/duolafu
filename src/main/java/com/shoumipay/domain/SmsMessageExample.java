package com.shoumipay.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SmsMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SmsMessageExample() {
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

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(Long value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(Long value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(Long value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(Long value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(Long value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(Long value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<Long> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<Long> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(Long value1, Long value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(Long value1, Long value2) {
            addCriterion("sid not between", value1, value2, "sid");
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

        public Criteria andPhonesIsNull() {
            addCriterion("phones is null");
            return (Criteria) this;
        }

        public Criteria andPhonesIsNotNull() {
            addCriterion("phones is not null");
            return (Criteria) this;
        }

        public Criteria andPhonesEqualTo(String value) {
            addCriterion("phones =", value, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesNotEqualTo(String value) {
            addCriterion("phones <>", value, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesGreaterThan(String value) {
            addCriterion("phones >", value, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesGreaterThanOrEqualTo(String value) {
            addCriterion("phones >=", value, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesLessThan(String value) {
            addCriterion("phones <", value, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesLessThanOrEqualTo(String value) {
            addCriterion("phones <=", value, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesLike(String value) {
            addCriterion("phones like", value, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesNotLike(String value) {
            addCriterion("phones not like", value, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesIn(List<String> values) {
            addCriterion("phones in", values, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesNotIn(List<String> values) {
            addCriterion("phones not in", values, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesBetween(String value1, String value2) {
            addCriterion("phones between", value1, value2, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesNotBetween(String value1, String value2) {
            addCriterion("phones not between", value1, value2, "phones");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNull() {
            addCriterion("sendTime is null");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNotNull() {
            addCriterion("sendTime is not null");
            return (Criteria) this;
        }

        public Criteria andSendtimeEqualTo(Date value) {
            addCriterion("sendTime =", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotEqualTo(Date value) {
            addCriterion("sendTime <>", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThan(Date value) {
            addCriterion("sendTime >", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sendTime >=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThan(Date value) {
            addCriterion("sendTime <", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThanOrEqualTo(Date value) {
            addCriterion("sendTime <=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeIn(List<Date> values) {
            addCriterion("sendTime in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotIn(List<Date> values) {
            addCriterion("sendTime not in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeBetween(Date value1, Date value2) {
            addCriterion("sendTime between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotBetween(Date value1, Date value2) {
            addCriterion("sendTime not between", value1, value2, "sendtime");
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

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Integer value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Integer value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Integer value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Integer value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Integer value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Integer> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Integer> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Integer value1, Integer value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFailuretimesIsNull() {
            addCriterion("failureTimes is null");
            return (Criteria) this;
        }

        public Criteria andFailuretimesIsNotNull() {
            addCriterion("failureTimes is not null");
            return (Criteria) this;
        }

        public Criteria andFailuretimesEqualTo(Integer value) {
            addCriterion("failureTimes =", value, "failuretimes");
            return (Criteria) this;
        }

        public Criteria andFailuretimesNotEqualTo(Integer value) {
            addCriterion("failureTimes <>", value, "failuretimes");
            return (Criteria) this;
        }

        public Criteria andFailuretimesGreaterThan(Integer value) {
            addCriterion("failureTimes >", value, "failuretimes");
            return (Criteria) this;
        }

        public Criteria andFailuretimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("failureTimes >=", value, "failuretimes");
            return (Criteria) this;
        }

        public Criteria andFailuretimesLessThan(Integer value) {
            addCriterion("failureTimes <", value, "failuretimes");
            return (Criteria) this;
        }

        public Criteria andFailuretimesLessThanOrEqualTo(Integer value) {
            addCriterion("failureTimes <=", value, "failuretimes");
            return (Criteria) this;
        }

        public Criteria andFailuretimesIn(List<Integer> values) {
            addCriterion("failureTimes in", values, "failuretimes");
            return (Criteria) this;
        }

        public Criteria andFailuretimesNotIn(List<Integer> values) {
            addCriterion("failureTimes not in", values, "failuretimes");
            return (Criteria) this;
        }

        public Criteria andFailuretimesBetween(Integer value1, Integer value2) {
            addCriterion("failureTimes between", value1, value2, "failuretimes");
            return (Criteria) this;
        }

        public Criteria andFailuretimesNotBetween(Integer value1, Integer value2) {
            addCriterion("failureTimes not between", value1, value2, "failuretimes");
            return (Criteria) this;
        }

        public Criteria andMaxfailIsNull() {
            addCriterion("maxfail is null");
            return (Criteria) this;
        }

        public Criteria andMaxfailIsNotNull() {
            addCriterion("maxfail is not null");
            return (Criteria) this;
        }

        public Criteria andMaxfailEqualTo(Integer value) {
            addCriterion("maxfail =", value, "maxfail");
            return (Criteria) this;
        }

        public Criteria andMaxfailNotEqualTo(Integer value) {
            addCriterion("maxfail <>", value, "maxfail");
            return (Criteria) this;
        }

        public Criteria andMaxfailGreaterThan(Integer value) {
            addCriterion("maxfail >", value, "maxfail");
            return (Criteria) this;
        }

        public Criteria andMaxfailGreaterThanOrEqualTo(Integer value) {
            addCriterion("maxfail >=", value, "maxfail");
            return (Criteria) this;
        }

        public Criteria andMaxfailLessThan(Integer value) {
            addCriterion("maxfail <", value, "maxfail");
            return (Criteria) this;
        }

        public Criteria andMaxfailLessThanOrEqualTo(Integer value) {
            addCriterion("maxfail <=", value, "maxfail");
            return (Criteria) this;
        }

        public Criteria andMaxfailIn(List<Integer> values) {
            addCriterion("maxfail in", values, "maxfail");
            return (Criteria) this;
        }

        public Criteria andMaxfailNotIn(List<Integer> values) {
            addCriterion("maxfail not in", values, "maxfail");
            return (Criteria) this;
        }

        public Criteria andMaxfailBetween(Integer value1, Integer value2) {
            addCriterion("maxfail between", value1, value2, "maxfail");
            return (Criteria) this;
        }

        public Criteria andMaxfailNotBetween(Integer value1, Integer value2) {
            addCriterion("maxfail not between", value1, value2, "maxfail");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andMessagetypeIsNull() {
            addCriterion("messageType is null");
            return (Criteria) this;
        }

        public Criteria andMessagetypeIsNotNull() {
            addCriterion("messageType is not null");
            return (Criteria) this;
        }

        public Criteria andMessagetypeEqualTo(Integer value) {
            addCriterion("messageType =", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeNotEqualTo(Integer value) {
            addCriterion("messageType <>", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeGreaterThan(Integer value) {
            addCriterion("messageType >", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("messageType >=", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeLessThan(Integer value) {
            addCriterion("messageType <", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeLessThanOrEqualTo(Integer value) {
            addCriterion("messageType <=", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeIn(List<Integer> values) {
            addCriterion("messageType in", values, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeNotIn(List<Integer> values) {
            addCriterion("messageType not in", values, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeBetween(Integer value1, Integer value2) {
            addCriterion("messageType between", value1, value2, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("messageType not between", value1, value2, "messagetype");
            return (Criteria) this;
        }

        public Criteria andSendtransmissionIsNull() {
            addCriterion("sendTransmission is null");
            return (Criteria) this;
        }

        public Criteria andSendtransmissionIsNotNull() {
            addCriterion("sendTransmission is not null");
            return (Criteria) this;
        }

        public Criteria andSendtransmissionEqualTo(String value) {
            addCriterion("sendTransmission =", value, "sendtransmission");
            return (Criteria) this;
        }

        public Criteria andSendtransmissionNotEqualTo(String value) {
            addCriterion("sendTransmission <>", value, "sendtransmission");
            return (Criteria) this;
        }

        public Criteria andSendtransmissionGreaterThan(String value) {
            addCriterion("sendTransmission >", value, "sendtransmission");
            return (Criteria) this;
        }

        public Criteria andSendtransmissionGreaterThanOrEqualTo(String value) {
            addCriterion("sendTransmission >=", value, "sendtransmission");
            return (Criteria) this;
        }

        public Criteria andSendtransmissionLessThan(String value) {
            addCriterion("sendTransmission <", value, "sendtransmission");
            return (Criteria) this;
        }

        public Criteria andSendtransmissionLessThanOrEqualTo(String value) {
            addCriterion("sendTransmission <=", value, "sendtransmission");
            return (Criteria) this;
        }

        public Criteria andSendtransmissionLike(String value) {
            addCriterion("sendTransmission like", value, "sendtransmission");
            return (Criteria) this;
        }

        public Criteria andSendtransmissionNotLike(String value) {
            addCriterion("sendTransmission not like", value, "sendtransmission");
            return (Criteria) this;
        }

        public Criteria andSendtransmissionIn(List<String> values) {
            addCriterion("sendTransmission in", values, "sendtransmission");
            return (Criteria) this;
        }

        public Criteria andSendtransmissionNotIn(List<String> values) {
            addCriterion("sendTransmission not in", values, "sendtransmission");
            return (Criteria) this;
        }

        public Criteria andSendtransmissionBetween(String value1, String value2) {
            addCriterion("sendTransmission between", value1, value2, "sendtransmission");
            return (Criteria) this;
        }

        public Criteria andSendtransmissionNotBetween(String value1, String value2) {
            addCriterion("sendTransmission not between", value1, value2, "sendtransmission");
            return (Criteria) this;
        }

        public Criteria andSendplatformIsNull() {
            addCriterion("sendPlatform is null");
            return (Criteria) this;
        }

        public Criteria andSendplatformIsNotNull() {
            addCriterion("sendPlatform is not null");
            return (Criteria) this;
        }

        public Criteria andSendplatformEqualTo(String value) {
            addCriterion("sendPlatform =", value, "sendplatform");
            return (Criteria) this;
        }

        public Criteria andSendplatformNotEqualTo(String value) {
            addCriterion("sendPlatform <>", value, "sendplatform");
            return (Criteria) this;
        }

        public Criteria andSendplatformGreaterThan(String value) {
            addCriterion("sendPlatform >", value, "sendplatform");
            return (Criteria) this;
        }

        public Criteria andSendplatformGreaterThanOrEqualTo(String value) {
            addCriterion("sendPlatform >=", value, "sendplatform");
            return (Criteria) this;
        }

        public Criteria andSendplatformLessThan(String value) {
            addCriterion("sendPlatform <", value, "sendplatform");
            return (Criteria) this;
        }

        public Criteria andSendplatformLessThanOrEqualTo(String value) {
            addCriterion("sendPlatform <=", value, "sendplatform");
            return (Criteria) this;
        }

        public Criteria andSendplatformLike(String value) {
            addCriterion("sendPlatform like", value, "sendplatform");
            return (Criteria) this;
        }

        public Criteria andSendplatformNotLike(String value) {
            addCriterion("sendPlatform not like", value, "sendplatform");
            return (Criteria) this;
        }

        public Criteria andSendplatformIn(List<String> values) {
            addCriterion("sendPlatform in", values, "sendplatform");
            return (Criteria) this;
        }

        public Criteria andSendplatformNotIn(List<String> values) {
            addCriterion("sendPlatform not in", values, "sendplatform");
            return (Criteria) this;
        }

        public Criteria andSendplatformBetween(String value1, String value2) {
            addCriterion("sendPlatform between", value1, value2, "sendplatform");
            return (Criteria) this;
        }

        public Criteria andSendplatformNotBetween(String value1, String value2) {
            addCriterion("sendPlatform not between", value1, value2, "sendplatform");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
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
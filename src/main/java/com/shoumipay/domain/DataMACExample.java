package com.shoumipay.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataMACExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DataMACExample() {
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

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Long value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Long value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Long> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Long> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andChannelIsNull() {
            addCriterion("channel is null");
            return (Criteria) this;
        }

        public Criteria andChannelIsNotNull() {
            addCriterion("channel is not null");
            return (Criteria) this;
        }

        public Criteria andChannelEqualTo(String value) {
            addCriterion("channel =", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotEqualTo(String value) {
            addCriterion("channel <>", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThan(String value) {
            addCriterion("channel >", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThanOrEqualTo(String value) {
            addCriterion("channel >=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThan(String value) {
            addCriterion("channel <", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThanOrEqualTo(String value) {
            addCriterion("channel <=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLike(String value) {
            addCriterion("channel like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotLike(String value) {
            addCriterion("channel not like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelIn(List<String> values) {
            addCriterion("channel in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotIn(List<String> values) {
            addCriterion("channel not in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelBetween(String value1, String value2) {
            addCriterion("channel between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotBetween(String value1, String value2) {
            addCriterion("channel not between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andAlizhimaCallIsNull() {
            addCriterion("alizhima_call is null");
            return (Criteria) this;
        }

        public Criteria andAlizhimaCallIsNotNull() {
            addCriterion("alizhima_call is not null");
            return (Criteria) this;
        }

        public Criteria andAlizhimaCallEqualTo(Long value) {
            addCriterion("alizhima_call =", value, "alizhimaCall");
            return (Criteria) this;
        }

        public Criteria andAlizhimaCallNotEqualTo(Long value) {
            addCriterion("alizhima_call <>", value, "alizhimaCall");
            return (Criteria) this;
        }

        public Criteria andAlizhimaCallGreaterThan(Long value) {
            addCriterion("alizhima_call >", value, "alizhimaCall");
            return (Criteria) this;
        }

        public Criteria andAlizhimaCallGreaterThanOrEqualTo(Long value) {
            addCriterion("alizhima_call >=", value, "alizhimaCall");
            return (Criteria) this;
        }

        public Criteria andAlizhimaCallLessThan(Long value) {
            addCriterion("alizhima_call <", value, "alizhimaCall");
            return (Criteria) this;
        }

        public Criteria andAlizhimaCallLessThanOrEqualTo(Long value) {
            addCriterion("alizhima_call <=", value, "alizhimaCall");
            return (Criteria) this;
        }

        public Criteria andAlizhimaCallIn(List<Long> values) {
            addCriterion("alizhima_call in", values, "alizhimaCall");
            return (Criteria) this;
        }

        public Criteria andAlizhimaCallNotIn(List<Long> values) {
            addCriterion("alizhima_call not in", values, "alizhimaCall");
            return (Criteria) this;
        }

        public Criteria andAlizhimaCallBetween(Long value1, Long value2) {
            addCriterion("alizhima_call between", value1, value2, "alizhimaCall");
            return (Criteria) this;
        }

        public Criteria andAlizhimaCallNotBetween(Long value1, Long value2) {
            addCriterion("alizhima_call not between", value1, value2, "alizhimaCall");
            return (Criteria) this;
        }

        public Criteria andBlacklistIsNull() {
            addCriterion("blacklist is null");
            return (Criteria) this;
        }

        public Criteria andBlacklistIsNotNull() {
            addCriterion("blacklist is not null");
            return (Criteria) this;
        }

        public Criteria andBlacklistEqualTo(Long value) {
            addCriterion("blacklist =", value, "blacklist");
            return (Criteria) this;
        }

        public Criteria andBlacklistNotEqualTo(Long value) {
            addCriterion("blacklist <>", value, "blacklist");
            return (Criteria) this;
        }

        public Criteria andBlacklistGreaterThan(Long value) {
            addCriterion("blacklist >", value, "blacklist");
            return (Criteria) this;
        }

        public Criteria andBlacklistGreaterThanOrEqualTo(Long value) {
            addCriterion("blacklist >=", value, "blacklist");
            return (Criteria) this;
        }

        public Criteria andBlacklistLessThan(Long value) {
            addCriterion("blacklist <", value, "blacklist");
            return (Criteria) this;
        }

        public Criteria andBlacklistLessThanOrEqualTo(Long value) {
            addCriterion("blacklist <=", value, "blacklist");
            return (Criteria) this;
        }

        public Criteria andBlacklistIn(List<Long> values) {
            addCriterion("blacklist in", values, "blacklist");
            return (Criteria) this;
        }

        public Criteria andBlacklistNotIn(List<Long> values) {
            addCriterion("blacklist not in", values, "blacklist");
            return (Criteria) this;
        }

        public Criteria andBlacklistBetween(Long value1, Long value2) {
            addCriterion("blacklist between", value1, value2, "blacklist");
            return (Criteria) this;
        }

        public Criteria andBlacklistNotBetween(Long value1, Long value2) {
            addCriterion("blacklist not between", value1, value2, "blacklist");
            return (Criteria) this;
        }

        public Criteria andJiaoCallIsNull() {
            addCriterion("jiao_call is null");
            return (Criteria) this;
        }

        public Criteria andJiaoCallIsNotNull() {
            addCriterion("jiao_call is not null");
            return (Criteria) this;
        }

        public Criteria andJiaoCallEqualTo(Long value) {
            addCriterion("jiao_call =", value, "jiaoCall");
            return (Criteria) this;
        }

        public Criteria andJiaoCallNotEqualTo(Long value) {
            addCriterion("jiao_call <>", value, "jiaoCall");
            return (Criteria) this;
        }

        public Criteria andJiaoCallGreaterThan(Long value) {
            addCriterion("jiao_call >", value, "jiaoCall");
            return (Criteria) this;
        }

        public Criteria andJiaoCallGreaterThanOrEqualTo(Long value) {
            addCriterion("jiao_call >=", value, "jiaoCall");
            return (Criteria) this;
        }

        public Criteria andJiaoCallLessThan(Long value) {
            addCriterion("jiao_call <", value, "jiaoCall");
            return (Criteria) this;
        }

        public Criteria andJiaoCallLessThanOrEqualTo(Long value) {
            addCriterion("jiao_call <=", value, "jiaoCall");
            return (Criteria) this;
        }

        public Criteria andJiaoCallIn(List<Long> values) {
            addCriterion("jiao_call in", values, "jiaoCall");
            return (Criteria) this;
        }

        public Criteria andJiaoCallNotIn(List<Long> values) {
            addCriterion("jiao_call not in", values, "jiaoCall");
            return (Criteria) this;
        }

        public Criteria andJiaoCallBetween(Long value1, Long value2) {
            addCriterion("jiao_call between", value1, value2, "jiaoCall");
            return (Criteria) this;
        }

        public Criteria andJiaoCallNotBetween(Long value1, Long value2) {
            addCriterion("jiao_call not between", value1, value2, "jiaoCall");
            return (Criteria) this;
        }

        public Criteria andBankCallIsNull() {
            addCriterion("bank_call is null");
            return (Criteria) this;
        }

        public Criteria andBankCallIsNotNull() {
            addCriterion("bank_call is not null");
            return (Criteria) this;
        }

        public Criteria andBankCallEqualTo(Long value) {
            addCriterion("bank_call =", value, "bankCall");
            return (Criteria) this;
        }

        public Criteria andBankCallNotEqualTo(Long value) {
            addCriterion("bank_call <>", value, "bankCall");
            return (Criteria) this;
        }

        public Criteria andBankCallGreaterThan(Long value) {
            addCriterion("bank_call >", value, "bankCall");
            return (Criteria) this;
        }

        public Criteria andBankCallGreaterThanOrEqualTo(Long value) {
            addCriterion("bank_call >=", value, "bankCall");
            return (Criteria) this;
        }

        public Criteria andBankCallLessThan(Long value) {
            addCriterion("bank_call <", value, "bankCall");
            return (Criteria) this;
        }

        public Criteria andBankCallLessThanOrEqualTo(Long value) {
            addCriterion("bank_call <=", value, "bankCall");
            return (Criteria) this;
        }

        public Criteria andBankCallIn(List<Long> values) {
            addCriterion("bank_call in", values, "bankCall");
            return (Criteria) this;
        }

        public Criteria andBankCallNotIn(List<Long> values) {
            addCriterion("bank_call not in", values, "bankCall");
            return (Criteria) this;
        }

        public Criteria andBankCallBetween(Long value1, Long value2) {
            addCriterion("bank_call between", value1, value2, "bankCall");
            return (Criteria) this;
        }

        public Criteria andBankCallNotBetween(Long value1, Long value2) {
            addCriterion("bank_call not between", value1, value2, "bankCall");
            return (Criteria) this;
        }

        public Criteria andSmsCallIsNull() {
            addCriterion("sms_call is null");
            return (Criteria) this;
        }

        public Criteria andSmsCallIsNotNull() {
            addCriterion("sms_call is not null");
            return (Criteria) this;
        }

        public Criteria andSmsCallEqualTo(Long value) {
            addCriterion("sms_call =", value, "smsCall");
            return (Criteria) this;
        }

        public Criteria andSmsCallNotEqualTo(Long value) {
            addCriterion("sms_call <>", value, "smsCall");
            return (Criteria) this;
        }

        public Criteria andSmsCallGreaterThan(Long value) {
            addCriterion("sms_call >", value, "smsCall");
            return (Criteria) this;
        }

        public Criteria andSmsCallGreaterThanOrEqualTo(Long value) {
            addCriterion("sms_call >=", value, "smsCall");
            return (Criteria) this;
        }

        public Criteria andSmsCallLessThan(Long value) {
            addCriterion("sms_call <", value, "smsCall");
            return (Criteria) this;
        }

        public Criteria andSmsCallLessThanOrEqualTo(Long value) {
            addCriterion("sms_call <=", value, "smsCall");
            return (Criteria) this;
        }

        public Criteria andSmsCallIn(List<Long> values) {
            addCriterion("sms_call in", values, "smsCall");
            return (Criteria) this;
        }

        public Criteria andSmsCallNotIn(List<Long> values) {
            addCriterion("sms_call not in", values, "smsCall");
            return (Criteria) this;
        }

        public Criteria andSmsCallBetween(Long value1, Long value2) {
            addCriterion("sms_call between", value1, value2, "smsCall");
            return (Criteria) this;
        }

        public Criteria andSmsCallNotBetween(Long value1, Long value2) {
            addCriterion("sms_call not between", value1, value2, "smsCall");
            return (Criteria) this;
        }

        public Criteria andThirdParty1IsNull() {
            addCriterion("third_party_1 is null");
            return (Criteria) this;
        }

        public Criteria andThirdParty1IsNotNull() {
            addCriterion("third_party_1 is not null");
            return (Criteria) this;
        }

        public Criteria andThirdParty1EqualTo(Long value) {
            addCriterion("third_party_1 =", value, "thirdParty1");
            return (Criteria) this;
        }

        public Criteria andThirdParty1NotEqualTo(Long value) {
            addCriterion("third_party_1 <>", value, "thirdParty1");
            return (Criteria) this;
        }

        public Criteria andThirdParty1GreaterThan(Long value) {
            addCriterion("third_party_1 >", value, "thirdParty1");
            return (Criteria) this;
        }

        public Criteria andThirdParty1GreaterThanOrEqualTo(Long value) {
            addCriterion("third_party_1 >=", value, "thirdParty1");
            return (Criteria) this;
        }

        public Criteria andThirdParty1LessThan(Long value) {
            addCriterion("third_party_1 <", value, "thirdParty1");
            return (Criteria) this;
        }

        public Criteria andThirdParty1LessThanOrEqualTo(Long value) {
            addCriterion("third_party_1 <=", value, "thirdParty1");
            return (Criteria) this;
        }

        public Criteria andThirdParty1In(List<Long> values) {
            addCriterion("third_party_1 in", values, "thirdParty1");
            return (Criteria) this;
        }

        public Criteria andThirdParty1NotIn(List<Long> values) {
            addCriterion("third_party_1 not in", values, "thirdParty1");
            return (Criteria) this;
        }

        public Criteria andThirdParty1Between(Long value1, Long value2) {
            addCriterion("third_party_1 between", value1, value2, "thirdParty1");
            return (Criteria) this;
        }

        public Criteria andThirdParty1NotBetween(Long value1, Long value2) {
            addCriterion("third_party_1 not between", value1, value2, "thirdParty1");
            return (Criteria) this;
        }

        public Criteria andThirdParty2IsNull() {
            addCriterion("third_party_2 is null");
            return (Criteria) this;
        }

        public Criteria andThirdParty2IsNotNull() {
            addCriterion("third_party_2 is not null");
            return (Criteria) this;
        }

        public Criteria andThirdParty2EqualTo(Long value) {
            addCriterion("third_party_2 =", value, "thirdParty2");
            return (Criteria) this;
        }

        public Criteria andThirdParty2NotEqualTo(Long value) {
            addCriterion("third_party_2 <>", value, "thirdParty2");
            return (Criteria) this;
        }

        public Criteria andThirdParty2GreaterThan(Long value) {
            addCriterion("third_party_2 >", value, "thirdParty2");
            return (Criteria) this;
        }

        public Criteria andThirdParty2GreaterThanOrEqualTo(Long value) {
            addCriterion("third_party_2 >=", value, "thirdParty2");
            return (Criteria) this;
        }

        public Criteria andThirdParty2LessThan(Long value) {
            addCriterion("third_party_2 <", value, "thirdParty2");
            return (Criteria) this;
        }

        public Criteria andThirdParty2LessThanOrEqualTo(Long value) {
            addCriterion("third_party_2 <=", value, "thirdParty2");
            return (Criteria) this;
        }

        public Criteria andThirdParty2In(List<Long> values) {
            addCriterion("third_party_2 in", values, "thirdParty2");
            return (Criteria) this;
        }

        public Criteria andThirdParty2NotIn(List<Long> values) {
            addCriterion("third_party_2 not in", values, "thirdParty2");
            return (Criteria) this;
        }

        public Criteria andThirdParty2Between(Long value1, Long value2) {
            addCriterion("third_party_2 between", value1, value2, "thirdParty2");
            return (Criteria) this;
        }

        public Criteria andThirdParty2NotBetween(Long value1, Long value2) {
            addCriterion("third_party_2 not between", value1, value2, "thirdParty2");
            return (Criteria) this;
        }

        public Criteria andThirdParty3IsNull() {
            addCriterion("third_party_3 is null");
            return (Criteria) this;
        }

        public Criteria andThirdParty3IsNotNull() {
            addCriterion("third_party_3 is not null");
            return (Criteria) this;
        }

        public Criteria andThirdParty3EqualTo(Long value) {
            addCriterion("third_party_3 =", value, "thirdParty3");
            return (Criteria) this;
        }

        public Criteria andThirdParty3NotEqualTo(Long value) {
            addCriterion("third_party_3 <>", value, "thirdParty3");
            return (Criteria) this;
        }

        public Criteria andThirdParty3GreaterThan(Long value) {
            addCriterion("third_party_3 >", value, "thirdParty3");
            return (Criteria) this;
        }

        public Criteria andThirdParty3GreaterThanOrEqualTo(Long value) {
            addCriterion("third_party_3 >=", value, "thirdParty3");
            return (Criteria) this;
        }

        public Criteria andThirdParty3LessThan(Long value) {
            addCriterion("third_party_3 <", value, "thirdParty3");
            return (Criteria) this;
        }

        public Criteria andThirdParty3LessThanOrEqualTo(Long value) {
            addCriterion("third_party_3 <=", value, "thirdParty3");
            return (Criteria) this;
        }

        public Criteria andThirdParty3In(List<Long> values) {
            addCriterion("third_party_3 in", values, "thirdParty3");
            return (Criteria) this;
        }

        public Criteria andThirdParty3NotIn(List<Long> values) {
            addCriterion("third_party_3 not in", values, "thirdParty3");
            return (Criteria) this;
        }

        public Criteria andThirdParty3Between(Long value1, Long value2) {
            addCriterion("third_party_3 between", value1, value2, "thirdParty3");
            return (Criteria) this;
        }

        public Criteria andThirdParty3NotBetween(Long value1, Long value2) {
            addCriterion("third_party_3 not between", value1, value2, "thirdParty3");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
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
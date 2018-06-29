package com.shoumipay.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VerifyParameterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VerifyParameterExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andHttpIsNull() {
            addCriterion("http is null");
            return (Criteria) this;
        }

        public Criteria andHttpIsNotNull() {
            addCriterion("http is not null");
            return (Criteria) this;
        }

        public Criteria andHttpEqualTo(String value) {
            addCriterion("http =", value, "http");
            return (Criteria) this;
        }

        public Criteria andHttpNotEqualTo(String value) {
            addCriterion("http <>", value, "http");
            return (Criteria) this;
        }

        public Criteria andHttpGreaterThan(String value) {
            addCriterion("http >", value, "http");
            return (Criteria) this;
        }

        public Criteria andHttpGreaterThanOrEqualTo(String value) {
            addCriterion("http >=", value, "http");
            return (Criteria) this;
        }

        public Criteria andHttpLessThan(String value) {
            addCriterion("http <", value, "http");
            return (Criteria) this;
        }

        public Criteria andHttpLessThanOrEqualTo(String value) {
            addCriterion("http <=", value, "http");
            return (Criteria) this;
        }

        public Criteria andHttpLike(String value) {
            addCriterion("http like", value, "http");
            return (Criteria) this;
        }

        public Criteria andHttpNotLike(String value) {
            addCriterion("http not like", value, "http");
            return (Criteria) this;
        }

        public Criteria andHttpIn(List<String> values) {
            addCriterion("http in", values, "http");
            return (Criteria) this;
        }

        public Criteria andHttpNotIn(List<String> values) {
            addCriterion("http not in", values, "http");
            return (Criteria) this;
        }

        public Criteria andHttpBetween(String value1, String value2) {
            addCriterion("http between", value1, value2, "http");
            return (Criteria) this;
        }

        public Criteria andHttpNotBetween(String value1, String value2) {
            addCriterion("http not between", value1, value2, "http");
            return (Criteria) this;
        }

        public Criteria andP1IsNull() {
            addCriterion("p1 is null");
            return (Criteria) this;
        }

        public Criteria andP1IsNotNull() {
            addCriterion("p1 is not null");
            return (Criteria) this;
        }

        public Criteria andP1EqualTo(String value) {
            addCriterion("p1 =", value, "p1");
            return (Criteria) this;
        }

        public Criteria andP1NotEqualTo(String value) {
            addCriterion("p1 <>", value, "p1");
            return (Criteria) this;
        }

        public Criteria andP1GreaterThan(String value) {
            addCriterion("p1 >", value, "p1");
            return (Criteria) this;
        }

        public Criteria andP1GreaterThanOrEqualTo(String value) {
            addCriterion("p1 >=", value, "p1");
            return (Criteria) this;
        }

        public Criteria andP1LessThan(String value) {
            addCriterion("p1 <", value, "p1");
            return (Criteria) this;
        }

        public Criteria andP1LessThanOrEqualTo(String value) {
            addCriterion("p1 <=", value, "p1");
            return (Criteria) this;
        }

        public Criteria andP1Like(String value) {
            addCriterion("p1 like", value, "p1");
            return (Criteria) this;
        }

        public Criteria andP1NotLike(String value) {
            addCriterion("p1 not like", value, "p1");
            return (Criteria) this;
        }

        public Criteria andP1In(List<String> values) {
            addCriterion("p1 in", values, "p1");
            return (Criteria) this;
        }

        public Criteria andP1NotIn(List<String> values) {
            addCriterion("p1 not in", values, "p1");
            return (Criteria) this;
        }

        public Criteria andP1Between(String value1, String value2) {
            addCriterion("p1 between", value1, value2, "p1");
            return (Criteria) this;
        }

        public Criteria andP1NotBetween(String value1, String value2) {
            addCriterion("p1 not between", value1, value2, "p1");
            return (Criteria) this;
        }

        public Criteria andP2IsNull() {
            addCriterion("p2 is null");
            return (Criteria) this;
        }

        public Criteria andP2IsNotNull() {
            addCriterion("p2 is not null");
            return (Criteria) this;
        }

        public Criteria andP2EqualTo(String value) {
            addCriterion("p2 =", value, "p2");
            return (Criteria) this;
        }

        public Criteria andP2NotEqualTo(String value) {
            addCriterion("p2 <>", value, "p2");
            return (Criteria) this;
        }

        public Criteria andP2GreaterThan(String value) {
            addCriterion("p2 >", value, "p2");
            return (Criteria) this;
        }

        public Criteria andP2GreaterThanOrEqualTo(String value) {
            addCriterion("p2 >=", value, "p2");
            return (Criteria) this;
        }

        public Criteria andP2LessThan(String value) {
            addCriterion("p2 <", value, "p2");
            return (Criteria) this;
        }

        public Criteria andP2LessThanOrEqualTo(String value) {
            addCriterion("p2 <=", value, "p2");
            return (Criteria) this;
        }

        public Criteria andP2Like(String value) {
            addCriterion("p2 like", value, "p2");
            return (Criteria) this;
        }

        public Criteria andP2NotLike(String value) {
            addCriterion("p2 not like", value, "p2");
            return (Criteria) this;
        }

        public Criteria andP2In(List<String> values) {
            addCriterion("p2 in", values, "p2");
            return (Criteria) this;
        }

        public Criteria andP2NotIn(List<String> values) {
            addCriterion("p2 not in", values, "p2");
            return (Criteria) this;
        }

        public Criteria andP2Between(String value1, String value2) {
            addCriterion("p2 between", value1, value2, "p2");
            return (Criteria) this;
        }

        public Criteria andP2NotBetween(String value1, String value2) {
            addCriterion("p2 not between", value1, value2, "p2");
            return (Criteria) this;
        }

        public Criteria andP3IsNull() {
            addCriterion("p3 is null");
            return (Criteria) this;
        }

        public Criteria andP3IsNotNull() {
            addCriterion("p3 is not null");
            return (Criteria) this;
        }

        public Criteria andP3EqualTo(String value) {
            addCriterion("p3 =", value, "p3");
            return (Criteria) this;
        }

        public Criteria andP3NotEqualTo(String value) {
            addCriterion("p3 <>", value, "p3");
            return (Criteria) this;
        }

        public Criteria andP3GreaterThan(String value) {
            addCriterion("p3 >", value, "p3");
            return (Criteria) this;
        }

        public Criteria andP3GreaterThanOrEqualTo(String value) {
            addCriterion("p3 >=", value, "p3");
            return (Criteria) this;
        }

        public Criteria andP3LessThan(String value) {
            addCriterion("p3 <", value, "p3");
            return (Criteria) this;
        }

        public Criteria andP3LessThanOrEqualTo(String value) {
            addCriterion("p3 <=", value, "p3");
            return (Criteria) this;
        }

        public Criteria andP3Like(String value) {
            addCriterion("p3 like", value, "p3");
            return (Criteria) this;
        }

        public Criteria andP3NotLike(String value) {
            addCriterion("p3 not like", value, "p3");
            return (Criteria) this;
        }

        public Criteria andP3In(List<String> values) {
            addCriterion("p3 in", values, "p3");
            return (Criteria) this;
        }

        public Criteria andP3NotIn(List<String> values) {
            addCriterion("p3 not in", values, "p3");
            return (Criteria) this;
        }

        public Criteria andP3Between(String value1, String value2) {
            addCriterion("p3 between", value1, value2, "p3");
            return (Criteria) this;
        }

        public Criteria andP3NotBetween(String value1, String value2) {
            addCriterion("p3 not between", value1, value2, "p3");
            return (Criteria) this;
        }

        public Criteria andP4IsNull() {
            addCriterion("p4 is null");
            return (Criteria) this;
        }

        public Criteria andP4IsNotNull() {
            addCriterion("p4 is not null");
            return (Criteria) this;
        }

        public Criteria andP4EqualTo(String value) {
            addCriterion("p4 =", value, "p4");
            return (Criteria) this;
        }

        public Criteria andP4NotEqualTo(String value) {
            addCriterion("p4 <>", value, "p4");
            return (Criteria) this;
        }

        public Criteria andP4GreaterThan(String value) {
            addCriterion("p4 >", value, "p4");
            return (Criteria) this;
        }

        public Criteria andP4GreaterThanOrEqualTo(String value) {
            addCriterion("p4 >=", value, "p4");
            return (Criteria) this;
        }

        public Criteria andP4LessThan(String value) {
            addCriterion("p4 <", value, "p4");
            return (Criteria) this;
        }

        public Criteria andP4LessThanOrEqualTo(String value) {
            addCriterion("p4 <=", value, "p4");
            return (Criteria) this;
        }

        public Criteria andP4Like(String value) {
            addCriterion("p4 like", value, "p4");
            return (Criteria) this;
        }

        public Criteria andP4NotLike(String value) {
            addCriterion("p4 not like", value, "p4");
            return (Criteria) this;
        }

        public Criteria andP4In(List<String> values) {
            addCriterion("p4 in", values, "p4");
            return (Criteria) this;
        }

        public Criteria andP4NotIn(List<String> values) {
            addCriterion("p4 not in", values, "p4");
            return (Criteria) this;
        }

        public Criteria andP4Between(String value1, String value2) {
            addCriterion("p4 between", value1, value2, "p4");
            return (Criteria) this;
        }

        public Criteria andP4NotBetween(String value1, String value2) {
            addCriterion("p4 not between", value1, value2, "p4");
            return (Criteria) this;
        }

        public Criteria andP5IsNull() {
            addCriterion("p5 is null");
            return (Criteria) this;
        }

        public Criteria andP5IsNotNull() {
            addCriterion("p5 is not null");
            return (Criteria) this;
        }

        public Criteria andP5EqualTo(String value) {
            addCriterion("p5 =", value, "p5");
            return (Criteria) this;
        }

        public Criteria andP5NotEqualTo(String value) {
            addCriterion("p5 <>", value, "p5");
            return (Criteria) this;
        }

        public Criteria andP5GreaterThan(String value) {
            addCriterion("p5 >", value, "p5");
            return (Criteria) this;
        }

        public Criteria andP5GreaterThanOrEqualTo(String value) {
            addCriterion("p5 >=", value, "p5");
            return (Criteria) this;
        }

        public Criteria andP5LessThan(String value) {
            addCriterion("p5 <", value, "p5");
            return (Criteria) this;
        }

        public Criteria andP5LessThanOrEqualTo(String value) {
            addCriterion("p5 <=", value, "p5");
            return (Criteria) this;
        }

        public Criteria andP5Like(String value) {
            addCriterion("p5 like", value, "p5");
            return (Criteria) this;
        }

        public Criteria andP5NotLike(String value) {
            addCriterion("p5 not like", value, "p5");
            return (Criteria) this;
        }

        public Criteria andP5In(List<String> values) {
            addCriterion("p5 in", values, "p5");
            return (Criteria) this;
        }

        public Criteria andP5NotIn(List<String> values) {
            addCriterion("p5 not in", values, "p5");
            return (Criteria) this;
        }

        public Criteria andP5Between(String value1, String value2) {
            addCriterion("p5 between", value1, value2, "p5");
            return (Criteria) this;
        }

        public Criteria andP5NotBetween(String value1, String value2) {
            addCriterion("p5 not between", value1, value2, "p5");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
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
package com.shoumipay.domain;

import java.util.ArrayList;
import java.util.List;

public class CertificationFileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CertificationFileExample() {
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

        public Criteria andIdcardFrontPhotoPathIsNull() {
            addCriterion("idcard_front_photo_path is null");
            return (Criteria) this;
        }

        public Criteria andIdcardFrontPhotoPathIsNotNull() {
            addCriterion("idcard_front_photo_path is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardFrontPhotoPathEqualTo(String value) {
            addCriterion("idcard_front_photo_path =", value, "idcardFrontPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardFrontPhotoPathNotEqualTo(String value) {
            addCriterion("idcard_front_photo_path <>", value, "idcardFrontPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardFrontPhotoPathGreaterThan(String value) {
            addCriterion("idcard_front_photo_path >", value, "idcardFrontPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardFrontPhotoPathGreaterThanOrEqualTo(String value) {
            addCriterion("idcard_front_photo_path >=", value, "idcardFrontPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardFrontPhotoPathLessThan(String value) {
            addCriterion("idcard_front_photo_path <", value, "idcardFrontPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardFrontPhotoPathLessThanOrEqualTo(String value) {
            addCriterion("idcard_front_photo_path <=", value, "idcardFrontPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardFrontPhotoPathLike(String value) {
            addCriterion("idcard_front_photo_path like", value, "idcardFrontPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardFrontPhotoPathNotLike(String value) {
            addCriterion("idcard_front_photo_path not like", value, "idcardFrontPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardFrontPhotoPathIn(List<String> values) {
            addCriterion("idcard_front_photo_path in", values, "idcardFrontPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardFrontPhotoPathNotIn(List<String> values) {
            addCriterion("idcard_front_photo_path not in", values, "idcardFrontPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardFrontPhotoPathBetween(String value1, String value2) {
            addCriterion("idcard_front_photo_path between", value1, value2, "idcardFrontPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardFrontPhotoPathNotBetween(String value1, String value2) {
            addCriterion("idcard_front_photo_path not between", value1, value2, "idcardFrontPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardPortraitPhotoPathIsNull() {
            addCriterion("idcard_portrait_photo_path is null");
            return (Criteria) this;
        }

        public Criteria andIdcardPortraitPhotoPathIsNotNull() {
            addCriterion("idcard_portrait_photo_path is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardPortraitPhotoPathEqualTo(String value) {
            addCriterion("idcard_portrait_photo_path =", value, "idcardPortraitPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardPortraitPhotoPathNotEqualTo(String value) {
            addCriterion("idcard_portrait_photo_path <>", value, "idcardPortraitPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardPortraitPhotoPathGreaterThan(String value) {
            addCriterion("idcard_portrait_photo_path >", value, "idcardPortraitPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardPortraitPhotoPathGreaterThanOrEqualTo(String value) {
            addCriterion("idcard_portrait_photo_path >=", value, "idcardPortraitPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardPortraitPhotoPathLessThan(String value) {
            addCriterion("idcard_portrait_photo_path <", value, "idcardPortraitPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardPortraitPhotoPathLessThanOrEqualTo(String value) {
            addCriterion("idcard_portrait_photo_path <=", value, "idcardPortraitPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardPortraitPhotoPathLike(String value) {
            addCriterion("idcard_portrait_photo_path like", value, "idcardPortraitPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardPortraitPhotoPathNotLike(String value) {
            addCriterion("idcard_portrait_photo_path not like", value, "idcardPortraitPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardPortraitPhotoPathIn(List<String> values) {
            addCriterion("idcard_portrait_photo_path in", values, "idcardPortraitPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardPortraitPhotoPathNotIn(List<String> values) {
            addCriterion("idcard_portrait_photo_path not in", values, "idcardPortraitPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardPortraitPhotoPathBetween(String value1, String value2) {
            addCriterion("idcard_portrait_photo_path between", value1, value2, "idcardPortraitPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardPortraitPhotoPathNotBetween(String value1, String value2) {
            addCriterion("idcard_portrait_photo_path not between", value1, value2, "idcardPortraitPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardBackPhotoPathIsNull() {
            addCriterion("idcard_back_photo_path is null");
            return (Criteria) this;
        }

        public Criteria andIdcardBackPhotoPathIsNotNull() {
            addCriterion("idcard_back_photo_path is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardBackPhotoPathEqualTo(String value) {
            addCriterion("idcard_back_photo_path =", value, "idcardBackPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardBackPhotoPathNotEqualTo(String value) {
            addCriterion("idcard_back_photo_path <>", value, "idcardBackPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardBackPhotoPathGreaterThan(String value) {
            addCriterion("idcard_back_photo_path >", value, "idcardBackPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardBackPhotoPathGreaterThanOrEqualTo(String value) {
            addCriterion("idcard_back_photo_path >=", value, "idcardBackPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardBackPhotoPathLessThan(String value) {
            addCriterion("idcard_back_photo_path <", value, "idcardBackPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardBackPhotoPathLessThanOrEqualTo(String value) {
            addCriterion("idcard_back_photo_path <=", value, "idcardBackPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardBackPhotoPathLike(String value) {
            addCriterion("idcard_back_photo_path like", value, "idcardBackPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardBackPhotoPathNotLike(String value) {
            addCriterion("idcard_back_photo_path not like", value, "idcardBackPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardBackPhotoPathIn(List<String> values) {
            addCriterion("idcard_back_photo_path in", values, "idcardBackPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardBackPhotoPathNotIn(List<String> values) {
            addCriterion("idcard_back_photo_path not in", values, "idcardBackPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardBackPhotoPathBetween(String value1, String value2) {
            addCriterion("idcard_back_photo_path between", value1, value2, "idcardBackPhotoPath");
            return (Criteria) this;
        }

        public Criteria andIdcardBackPhotoPathNotBetween(String value1, String value2) {
            addCriterion("idcard_back_photo_path not between", value1, value2, "idcardBackPhotoPath");
            return (Criteria) this;
        }

        public Criteria andLivingPhotoPathIsNull() {
            addCriterion("living_photo_path is null");
            return (Criteria) this;
        }

        public Criteria andLivingPhotoPathIsNotNull() {
            addCriterion("living_photo_path is not null");
            return (Criteria) this;
        }

        public Criteria andLivingPhotoPathEqualTo(String value) {
            addCriterion("living_photo_path =", value, "livingPhotoPath");
            return (Criteria) this;
        }

        public Criteria andLivingPhotoPathNotEqualTo(String value) {
            addCriterion("living_photo_path <>", value, "livingPhotoPath");
            return (Criteria) this;
        }

        public Criteria andLivingPhotoPathGreaterThan(String value) {
            addCriterion("living_photo_path >", value, "livingPhotoPath");
            return (Criteria) this;
        }

        public Criteria andLivingPhotoPathGreaterThanOrEqualTo(String value) {
            addCriterion("living_photo_path >=", value, "livingPhotoPath");
            return (Criteria) this;
        }

        public Criteria andLivingPhotoPathLessThan(String value) {
            addCriterion("living_photo_path <", value, "livingPhotoPath");
            return (Criteria) this;
        }

        public Criteria andLivingPhotoPathLessThanOrEqualTo(String value) {
            addCriterion("living_photo_path <=", value, "livingPhotoPath");
            return (Criteria) this;
        }

        public Criteria andLivingPhotoPathLike(String value) {
            addCriterion("living_photo_path like", value, "livingPhotoPath");
            return (Criteria) this;
        }

        public Criteria andLivingPhotoPathNotLike(String value) {
            addCriterion("living_photo_path not like", value, "livingPhotoPath");
            return (Criteria) this;
        }

        public Criteria andLivingPhotoPathIn(List<String> values) {
            addCriterion("living_photo_path in", values, "livingPhotoPath");
            return (Criteria) this;
        }

        public Criteria andLivingPhotoPathNotIn(List<String> values) {
            addCriterion("living_photo_path not in", values, "livingPhotoPath");
            return (Criteria) this;
        }

        public Criteria andLivingPhotoPathBetween(String value1, String value2) {
            addCriterion("living_photo_path between", value1, value2, "livingPhotoPath");
            return (Criteria) this;
        }

        public Criteria andLivingPhotoPathNotBetween(String value1, String value2) {
            addCriterion("living_photo_path not between", value1, value2, "livingPhotoPath");
            return (Criteria) this;
        }

        public Criteria andLivingVideoPathIsNull() {
            addCriterion("living_video_path is null");
            return (Criteria) this;
        }

        public Criteria andLivingVideoPathIsNotNull() {
            addCriterion("living_video_path is not null");
            return (Criteria) this;
        }

        public Criteria andLivingVideoPathEqualTo(String value) {
            addCriterion("living_video_path =", value, "livingVideoPath");
            return (Criteria) this;
        }

        public Criteria andLivingVideoPathNotEqualTo(String value) {
            addCriterion("living_video_path <>", value, "livingVideoPath");
            return (Criteria) this;
        }

        public Criteria andLivingVideoPathGreaterThan(String value) {
            addCriterion("living_video_path >", value, "livingVideoPath");
            return (Criteria) this;
        }

        public Criteria andLivingVideoPathGreaterThanOrEqualTo(String value) {
            addCriterion("living_video_path >=", value, "livingVideoPath");
            return (Criteria) this;
        }

        public Criteria andLivingVideoPathLessThan(String value) {
            addCriterion("living_video_path <", value, "livingVideoPath");
            return (Criteria) this;
        }

        public Criteria andLivingVideoPathLessThanOrEqualTo(String value) {
            addCriterion("living_video_path <=", value, "livingVideoPath");
            return (Criteria) this;
        }

        public Criteria andLivingVideoPathLike(String value) {
            addCriterion("living_video_path like", value, "livingVideoPath");
            return (Criteria) this;
        }

        public Criteria andLivingVideoPathNotLike(String value) {
            addCriterion("living_video_path not like", value, "livingVideoPath");
            return (Criteria) this;
        }

        public Criteria andLivingVideoPathIn(List<String> values) {
            addCriterion("living_video_path in", values, "livingVideoPath");
            return (Criteria) this;
        }

        public Criteria andLivingVideoPathNotIn(List<String> values) {
            addCriterion("living_video_path not in", values, "livingVideoPath");
            return (Criteria) this;
        }

        public Criteria andLivingVideoPathBetween(String value1, String value2) {
            addCriterion("living_video_path between", value1, value2, "livingVideoPath");
            return (Criteria) this;
        }

        public Criteria andLivingVideoPathNotBetween(String value1, String value2) {
            addCriterion("living_video_path not between", value1, value2, "livingVideoPath");
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
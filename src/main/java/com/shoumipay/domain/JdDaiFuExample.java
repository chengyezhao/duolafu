package com.shoumipay.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JdDaiFuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JdDaiFuExample() {
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

        public Criteria andCustomerNameIsNull() {
            addCriterion("customer_Name is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNotNull() {
            addCriterion("customer_Name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameEqualTo(String value) {
            addCriterion("customer_Name =", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotEqualTo(String value) {
            addCriterion("customer_Name <>", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThan(String value) {
            addCriterion("customer_Name >", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThanOrEqualTo(String value) {
            addCriterion("customer_Name >=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThan(String value) {
            addCriterion("customer_Name <", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThanOrEqualTo(String value) {
            addCriterion("customer_Name <=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLike(String value) {
            addCriterion("customer_Name like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotLike(String value) {
            addCriterion("customer_Name not like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIn(List<String> values) {
            addCriterion("customer_Name in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotIn(List<String> values) {
            addCriterion("customer_Name not in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameBetween(String value1, String value2) {
            addCriterion("customer_Name between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotBetween(String value1, String value2) {
            addCriterion("customer_Name not between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andWeiXinDaiFuStatusIsNull() {
            addCriterion("wei_Xin_Dai_Fu_Status is null");
            return (Criteria) this;
        }

        public Criteria andWeiXinDaiFuStatusIsNotNull() {
            addCriterion("wei_Xin_Dai_Fu_Status is not null");
            return (Criteria) this;
        }

        public Criteria andWeiXinDaiFuStatusEqualTo(Integer value) {
            addCriterion("wei_Xin_Dai_Fu_Status =", value, "weiXinDaiFuStatus");
            return (Criteria) this;
        }

        public Criteria andWeiXinDaiFuStatusNotEqualTo(Integer value) {
            addCriterion("wei_Xin_Dai_Fu_Status <>", value, "weiXinDaiFuStatus");
            return (Criteria) this;
        }

        public Criteria andWeiXinDaiFuStatusGreaterThan(Integer value) {
            addCriterion("wei_Xin_Dai_Fu_Status >", value, "weiXinDaiFuStatus");
            return (Criteria) this;
        }

        public Criteria andWeiXinDaiFuStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("wei_Xin_Dai_Fu_Status >=", value, "weiXinDaiFuStatus");
            return (Criteria) this;
        }

        public Criteria andWeiXinDaiFuStatusLessThan(Integer value) {
            addCriterion("wei_Xin_Dai_Fu_Status <", value, "weiXinDaiFuStatus");
            return (Criteria) this;
        }

        public Criteria andWeiXinDaiFuStatusLessThanOrEqualTo(Integer value) {
            addCriterion("wei_Xin_Dai_Fu_Status <=", value, "weiXinDaiFuStatus");
            return (Criteria) this;
        }

        public Criteria andWeiXinDaiFuStatusIn(List<Integer> values) {
            addCriterion("wei_Xin_Dai_Fu_Status in", values, "weiXinDaiFuStatus");
            return (Criteria) this;
        }

        public Criteria andWeiXinDaiFuStatusNotIn(List<Integer> values) {
            addCriterion("wei_Xin_Dai_Fu_Status not in", values, "weiXinDaiFuStatus");
            return (Criteria) this;
        }

        public Criteria andWeiXinDaiFuStatusBetween(Integer value1, Integer value2) {
            addCriterion("wei_Xin_Dai_Fu_Status between", value1, value2, "weiXinDaiFuStatus");
            return (Criteria) this;
        }

        public Criteria andWeiXinDaiFuStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("wei_Xin_Dai_Fu_Status not between", value1, value2, "weiXinDaiFuStatus");
            return (Criteria) this;
        }

        public Criteria andImageUrlIsNull() {
            addCriterion("image_Url is null");
            return (Criteria) this;
        }

        public Criteria andImageUrlIsNotNull() {
            addCriterion("image_Url is not null");
            return (Criteria) this;
        }

        public Criteria andImageUrlEqualTo(String value) {
            addCriterion("image_Url =", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotEqualTo(String value) {
            addCriterion("image_Url <>", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThan(String value) {
            addCriterion("image_Url >", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("image_Url >=", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThan(String value) {
            addCriterion("image_Url <", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThanOrEqualTo(String value) {
            addCriterion("image_Url <=", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLike(String value) {
            addCriterion("image_Url like", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotLike(String value) {
            addCriterion("image_Url not like", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlIn(List<String> values) {
            addCriterion("image_Url in", values, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotIn(List<String> values) {
            addCriterion("image_Url not in", values, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlBetween(String value1, String value2) {
            addCriterion("image_Url between", value1, value2, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotBetween(String value1, String value2) {
            addCriterion("image_Url not between", value1, value2, "imageUrl");
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

        public Criteria andCodeEqualTo(Integer value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(Integer value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(Integer value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(Integer value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(Integer value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<Integer> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<Integer> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(Integer value1, Integer value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andDisableWishListIsNull() {
            addCriterion("disable_Wish_List is null");
            return (Criteria) this;
        }

        public Criteria andDisableWishListIsNotNull() {
            addCriterion("disable_Wish_List is not null");
            return (Criteria) this;
        }

        public Criteria andDisableWishListEqualTo(Integer value) {
            addCriterion("disable_Wish_List =", value, "disableWishList");
            return (Criteria) this;
        }

        public Criteria andDisableWishListNotEqualTo(Integer value) {
            addCriterion("disable_Wish_List <>", value, "disableWishList");
            return (Criteria) this;
        }

        public Criteria andDisableWishListGreaterThan(Integer value) {
            addCriterion("disable_Wish_List >", value, "disableWishList");
            return (Criteria) this;
        }

        public Criteria andDisableWishListGreaterThanOrEqualTo(Integer value) {
            addCriterion("disable_Wish_List >=", value, "disableWishList");
            return (Criteria) this;
        }

        public Criteria andDisableWishListLessThan(Integer value) {
            addCriterion("disable_Wish_List <", value, "disableWishList");
            return (Criteria) this;
        }

        public Criteria andDisableWishListLessThanOrEqualTo(Integer value) {
            addCriterion("disable_Wish_List <=", value, "disableWishList");
            return (Criteria) this;
        }

        public Criteria andDisableWishListIn(List<Integer> values) {
            addCriterion("disable_Wish_List in", values, "disableWishList");
            return (Criteria) this;
        }

        public Criteria andDisableWishListNotIn(List<Integer> values) {
            addCriterion("disable_Wish_List not in", values, "disableWishList");
            return (Criteria) this;
        }

        public Criteria andDisableWishListBetween(Integer value1, Integer value2) {
            addCriterion("disable_Wish_List between", value1, value2, "disableWishList");
            return (Criteria) this;
        }

        public Criteria andDisableWishListNotBetween(Integer value1, Integer value2) {
            addCriterion("disable_Wish_List not between", value1, value2, "disableWishList");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andFailureTimeIsNull() {
            addCriterion("failure_Time is null");
            return (Criteria) this;
        }

        public Criteria andFailureTimeIsNotNull() {
            addCriterion("failure_Time is not null");
            return (Criteria) this;
        }

        public Criteria andFailureTimeEqualTo(Long value) {
            addCriterion("failure_Time =", value, "failureTime");
            return (Criteria) this;
        }

        public Criteria andFailureTimeNotEqualTo(Long value) {
            addCriterion("failure_Time <>", value, "failureTime");
            return (Criteria) this;
        }

        public Criteria andFailureTimeGreaterThan(Long value) {
            addCriterion("failure_Time >", value, "failureTime");
            return (Criteria) this;
        }

        public Criteria andFailureTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("failure_Time >=", value, "failureTime");
            return (Criteria) this;
        }

        public Criteria andFailureTimeLessThan(Long value) {
            addCriterion("failure_Time <", value, "failureTime");
            return (Criteria) this;
        }

        public Criteria andFailureTimeLessThanOrEqualTo(Long value) {
            addCriterion("failure_Time <=", value, "failureTime");
            return (Criteria) this;
        }

        public Criteria andFailureTimeIn(List<Long> values) {
            addCriterion("failure_Time in", values, "failureTime");
            return (Criteria) this;
        }

        public Criteria andFailureTimeNotIn(List<Long> values) {
            addCriterion("failure_Time not in", values, "failureTime");
            return (Criteria) this;
        }

        public Criteria andFailureTimeBetween(Long value1, Long value2) {
            addCriterion("failure_Time between", value1, value2, "failureTime");
            return (Criteria) this;
        }

        public Criteria andFailureTimeNotBetween(Long value1, Long value2) {
            addCriterion("failure_Time not between", value1, value2, "failureTime");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andShareUrlIsNull() {
            addCriterion("share_Url is null");
            return (Criteria) this;
        }

        public Criteria andShareUrlIsNotNull() {
            addCriterion("share_Url is not null");
            return (Criteria) this;
        }

        public Criteria andShareUrlEqualTo(String value) {
            addCriterion("share_Url =", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotEqualTo(String value) {
            addCriterion("share_Url <>", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlGreaterThan(String value) {
            addCriterion("share_Url >", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlGreaterThanOrEqualTo(String value) {
            addCriterion("share_Url >=", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlLessThan(String value) {
            addCriterion("share_Url <", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlLessThanOrEqualTo(String value) {
            addCriterion("share_Url <=", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlLike(String value) {
            addCriterion("share_Url like", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotLike(String value) {
            addCriterion("share_Url not like", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlIn(List<String> values) {
            addCriterion("share_Url in", values, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotIn(List<String> values) {
            addCriterion("share_Url not in", values, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlBetween(String value1, String value2) {
            addCriterion("share_Url between", value1, value2, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotBetween(String value1, String value2) {
            addCriterion("share_Url not between", value1, value2, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNull() {
            addCriterion("order_Price is null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNotNull() {
            addCriterion("order_Price is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceEqualTo(BigDecimal value) {
            addCriterion("order_Price =", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotEqualTo(BigDecimal value) {
            addCriterion("order_Price <>", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThan(BigDecimal value) {
            addCriterion("order_Price >", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_Price >=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThan(BigDecimal value) {
            addCriterion("order_Price <", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_Price <=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIn(List<BigDecimal> values) {
            addCriterion("order_Price in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotIn(List<BigDecimal> values) {
            addCriterion("order_Price not in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_Price between", value1, value2, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_Price not between", value1, value2, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andFriendTitleIsNull() {
            addCriterion("friend_Title is null");
            return (Criteria) this;
        }

        public Criteria andFriendTitleIsNotNull() {
            addCriterion("friend_Title is not null");
            return (Criteria) this;
        }

        public Criteria andFriendTitleEqualTo(String value) {
            addCriterion("friend_Title =", value, "friendTitle");
            return (Criteria) this;
        }

        public Criteria andFriendTitleNotEqualTo(String value) {
            addCriterion("friend_Title <>", value, "friendTitle");
            return (Criteria) this;
        }

        public Criteria andFriendTitleGreaterThan(String value) {
            addCriterion("friend_Title >", value, "friendTitle");
            return (Criteria) this;
        }

        public Criteria andFriendTitleGreaterThanOrEqualTo(String value) {
            addCriterion("friend_Title >=", value, "friendTitle");
            return (Criteria) this;
        }

        public Criteria andFriendTitleLessThan(String value) {
            addCriterion("friend_Title <", value, "friendTitle");
            return (Criteria) this;
        }

        public Criteria andFriendTitleLessThanOrEqualTo(String value) {
            addCriterion("friend_Title <=", value, "friendTitle");
            return (Criteria) this;
        }

        public Criteria andFriendTitleLike(String value) {
            addCriterion("friend_Title like", value, "friendTitle");
            return (Criteria) this;
        }

        public Criteria andFriendTitleNotLike(String value) {
            addCriterion("friend_Title not like", value, "friendTitle");
            return (Criteria) this;
        }

        public Criteria andFriendTitleIn(List<String> values) {
            addCriterion("friend_Title in", values, "friendTitle");
            return (Criteria) this;
        }

        public Criteria andFriendTitleNotIn(List<String> values) {
            addCriterion("friend_Title not in", values, "friendTitle");
            return (Criteria) this;
        }

        public Criteria andFriendTitleBetween(String value1, String value2) {
            addCriterion("friend_Title between", value1, value2, "friendTitle");
            return (Criteria) this;
        }

        public Criteria andFriendTitleNotBetween(String value1, String value2) {
            addCriterion("friend_Title not between", value1, value2, "friendTitle");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(Long value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Long value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Long value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Long value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Long value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Long value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<Long> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<Long> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(Long value1, Long value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(Long value1, Long value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andAppidIsNull() {
            addCriterion("appId is null");
            return (Criteria) this;
        }

        public Criteria andAppidIsNotNull() {
            addCriterion("appId is not null");
            return (Criteria) this;
        }

        public Criteria andAppidEqualTo(String value) {
            addCriterion("appId =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(String value) {
            addCriterion("appId <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(String value) {
            addCriterion("appId >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(String value) {
            addCriterion("appId >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(String value) {
            addCriterion("appId <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(String value) {
            addCriterion("appId <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLike(String value) {
            addCriterion("appId like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotLike(String value) {
            addCriterion("appId not like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<String> values) {
            addCriterion("appId in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<String> values) {
            addCriterion("appId not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(String value1, String value2) {
            addCriterion("appId between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(String value1, String value2) {
            addCriterion("appId not between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andPayidIsNull() {
            addCriterion("payId is null");
            return (Criteria) this;
        }

        public Criteria andPayidIsNotNull() {
            addCriterion("payId is not null");
            return (Criteria) this;
        }

        public Criteria andPayidEqualTo(String value) {
            addCriterion("payId =", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotEqualTo(String value) {
            addCriterion("payId <>", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidGreaterThan(String value) {
            addCriterion("payId >", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidGreaterThanOrEqualTo(String value) {
            addCriterion("payId >=", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidLessThan(String value) {
            addCriterion("payId <", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidLessThanOrEqualTo(String value) {
            addCriterion("payId <=", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidLike(String value) {
            addCriterion("payId like", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotLike(String value) {
            addCriterion("payId not like", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidIn(List<String> values) {
            addCriterion("payId in", values, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotIn(List<String> values) {
            addCriterion("payId not in", values, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidBetween(String value1, String value2) {
            addCriterion("payId between", value1, value2, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotBetween(String value1, String value2) {
            addCriterion("payId not between", value1, value2, "payid");
            return (Criteria) this;
        }

        public Criteria andPoundagePayFlagIsNull() {
            addCriterion("poundage_pay_flag is null");
            return (Criteria) this;
        }

        public Criteria andPoundagePayFlagIsNotNull() {
            addCriterion("poundage_pay_flag is not null");
            return (Criteria) this;
        }

        public Criteria andPoundagePayFlagEqualTo(Integer value) {
            addCriterion("poundage_pay_flag =", value, "poundagePayFlag");
            return (Criteria) this;
        }

        public Criteria andPoundagePayFlagNotEqualTo(Integer value) {
            addCriterion("poundage_pay_flag <>", value, "poundagePayFlag");
            return (Criteria) this;
        }

        public Criteria andPoundagePayFlagGreaterThan(Integer value) {
            addCriterion("poundage_pay_flag >", value, "poundagePayFlag");
            return (Criteria) this;
        }

        public Criteria andPoundagePayFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("poundage_pay_flag >=", value, "poundagePayFlag");
            return (Criteria) this;
        }

        public Criteria andPoundagePayFlagLessThan(Integer value) {
            addCriterion("poundage_pay_flag <", value, "poundagePayFlag");
            return (Criteria) this;
        }

        public Criteria andPoundagePayFlagLessThanOrEqualTo(Integer value) {
            addCriterion("poundage_pay_flag <=", value, "poundagePayFlag");
            return (Criteria) this;
        }

        public Criteria andPoundagePayFlagIn(List<Integer> values) {
            addCriterion("poundage_pay_flag in", values, "poundagePayFlag");
            return (Criteria) this;
        }

        public Criteria andPoundagePayFlagNotIn(List<Integer> values) {
            addCriterion("poundage_pay_flag not in", values, "poundagePayFlag");
            return (Criteria) this;
        }

        public Criteria andPoundagePayFlagBetween(Integer value1, Integer value2) {
            addCriterion("poundage_pay_flag between", value1, value2, "poundagePayFlag");
            return (Criteria) this;
        }

        public Criteria andPoundagePayFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("poundage_pay_flag not between", value1, value2, "poundagePayFlag");
            return (Criteria) this;
        }
public Criteria andPoundagePayMoneyIsNull() {
            addCriterion("poundage_pay_money is null");
            return (Criteria) this;
        }

        public Criteria andPoundagePayMoneyIsNotNull() {
            addCriterion("poundage_pay_money is not null");
            return (Criteria) this;
        }

        public Criteria andPoundagePayMoneyEqualTo(BigDecimal value) {
            addCriterion("poundage_pay_money =", value, "poundagePayMoney");
            return (Criteria) this;
        }

        public Criteria andPoundagePayMoneyNotEqualTo(BigDecimal value) {
            addCriterion("poundage_pay_money <>", value, "poundagePayMoney");
            return (Criteria) this;
        }

        public Criteria andPoundagePayMoneyGreaterThan(BigDecimal value) {
            addCriterion("poundage_pay_money >", value, "poundagePayMoney");
            return (Criteria) this;
        }

        public Criteria andPoundagePayMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("poundage_pay_money >=", value, "poundagePayMoney");
            return (Criteria) this;
        }

        public Criteria andPoundagePayMoneyLessThan(BigDecimal value) {
            addCriterion("poundage_pay_money <", value, "poundagePayMoney");
            return (Criteria) this;
        }

        public Criteria andPoundagePayMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("poundage_pay_money <=", value, "poundagePayMoney");
            return (Criteria) this;
        }

        public Criteria andPoundagePayMoneyIn(List<BigDecimal> values) {
            addCriterion("poundage_pay_money in", values, "poundagePayMoney");
            return (Criteria) this;
        }

        public Criteria andPoundagePayMoneyNotIn(List<BigDecimal> values) {
            addCriterion("poundage_pay_money not in", values, "poundagePayMoney");
            return (Criteria) this;
        }

        public Criteria andPoundagePayMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("poundage_pay_money between", value1, value2, "poundagePayMoney");
            return (Criteria) this;
        }

        public Criteria andPoundagePayMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("poundage_pay_money not between", value1, value2, "poundagePayMoney");
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
package com.shoumipay.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberDevicesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberDevicesExample() {
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

        public Criteria andDevicesPhoneIsNull() {
            addCriterion("devices_phone is null");
            return (Criteria) this;
        }

        public Criteria andDevicesPhoneIsNotNull() {
            addCriterion("devices_phone is not null");
            return (Criteria) this;
        }

        public Criteria andDevicesPhoneEqualTo(String value) {
            addCriterion("devices_phone =", value, "devicesPhone");
            return (Criteria) this;
        }

        public Criteria andDevicesPhoneNotEqualTo(String value) {
            addCriterion("devices_phone <>", value, "devicesPhone");
            return (Criteria) this;
        }

        public Criteria andDevicesPhoneGreaterThan(String value) {
            addCriterion("devices_phone >", value, "devicesPhone");
            return (Criteria) this;
        }

        public Criteria andDevicesPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("devices_phone >=", value, "devicesPhone");
            return (Criteria) this;
        }

        public Criteria andDevicesPhoneLessThan(String value) {
            addCriterion("devices_phone <", value, "devicesPhone");
            return (Criteria) this;
        }

        public Criteria andDevicesPhoneLessThanOrEqualTo(String value) {
            addCriterion("devices_phone <=", value, "devicesPhone");
            return (Criteria) this;
        }

        public Criteria andDevicesPhoneLike(String value) {
            addCriterion("devices_phone like", value, "devicesPhone");
            return (Criteria) this;
        }

        public Criteria andDevicesPhoneNotLike(String value) {
            addCriterion("devices_phone not like", value, "devicesPhone");
            return (Criteria) this;
        }

        public Criteria andDevicesPhoneIn(List<String> values) {
            addCriterion("devices_phone in", values, "devicesPhone");
            return (Criteria) this;
        }

        public Criteria andDevicesPhoneNotIn(List<String> values) {
            addCriterion("devices_phone not in", values, "devicesPhone");
            return (Criteria) this;
        }

        public Criteria andDevicesPhoneBetween(String value1, String value2) {
            addCriterion("devices_phone between", value1, value2, "devicesPhone");
            return (Criteria) this;
        }

        public Criteria andDevicesPhoneNotBetween(String value1, String value2) {
            addCriterion("devices_phone not between", value1, value2, "devicesPhone");
            return (Criteria) this;
        }

        public Criteria andDevicesIfaIsNull() {
            addCriterion("devices_ifa is null");
            return (Criteria) this;
        }

        public Criteria andDevicesIfaIsNotNull() {
            addCriterion("devices_ifa is not null");
            return (Criteria) this;
        }

        public Criteria andDevicesIfaEqualTo(String value) {
            addCriterion("devices_ifa =", value, "devicesIfa");
            return (Criteria) this;
        }

        public Criteria andDevicesIfaNotEqualTo(String value) {
            addCriterion("devices_ifa <>", value, "devicesIfa");
            return (Criteria) this;
        }

        public Criteria andDevicesIfaGreaterThan(String value) {
            addCriterion("devices_ifa >", value, "devicesIfa");
            return (Criteria) this;
        }

        public Criteria andDevicesIfaGreaterThanOrEqualTo(String value) {
            addCriterion("devices_ifa >=", value, "devicesIfa");
            return (Criteria) this;
        }

        public Criteria andDevicesIfaLessThan(String value) {
            addCriterion("devices_ifa <", value, "devicesIfa");
            return (Criteria) this;
        }

        public Criteria andDevicesIfaLessThanOrEqualTo(String value) {
            addCriterion("devices_ifa <=", value, "devicesIfa");
            return (Criteria) this;
        }

        public Criteria andDevicesIfaLike(String value) {
            addCriterion("devices_ifa like", value, "devicesIfa");
            return (Criteria) this;
        }

        public Criteria andDevicesIfaNotLike(String value) {
            addCriterion("devices_ifa not like", value, "devicesIfa");
            return (Criteria) this;
        }

        public Criteria andDevicesIfaIn(List<String> values) {
            addCriterion("devices_ifa in", values, "devicesIfa");
            return (Criteria) this;
        }

        public Criteria andDevicesIfaNotIn(List<String> values) {
            addCriterion("devices_ifa not in", values, "devicesIfa");
            return (Criteria) this;
        }

        public Criteria andDevicesIfaBetween(String value1, String value2) {
            addCriterion("devices_ifa between", value1, value2, "devicesIfa");
            return (Criteria) this;
        }

        public Criteria andDevicesIfaNotBetween(String value1, String value2) {
            addCriterion("devices_ifa not between", value1, value2, "devicesIfa");
            return (Criteria) this;
        }

        public Criteria andDevicesMacIsNull() {
            addCriterion("devices_mac is null");
            return (Criteria) this;
        }

        public Criteria andDevicesMacIsNotNull() {
            addCriterion("devices_mac is not null");
            return (Criteria) this;
        }

        public Criteria andDevicesMacEqualTo(String value) {
            addCriterion("devices_mac =", value, "devicesMac");
            return (Criteria) this;
        }

        public Criteria andDevicesMacNotEqualTo(String value) {
            addCriterion("devices_mac <>", value, "devicesMac");
            return (Criteria) this;
        }

        public Criteria andDevicesMacGreaterThan(String value) {
            addCriterion("devices_mac >", value, "devicesMac");
            return (Criteria) this;
        }

        public Criteria andDevicesMacGreaterThanOrEqualTo(String value) {
            addCriterion("devices_mac >=", value, "devicesMac");
            return (Criteria) this;
        }

        public Criteria andDevicesMacLessThan(String value) {
            addCriterion("devices_mac <", value, "devicesMac");
            return (Criteria) this;
        }

        public Criteria andDevicesMacLessThanOrEqualTo(String value) {
            addCriterion("devices_mac <=", value, "devicesMac");
            return (Criteria) this;
        }

        public Criteria andDevicesMacLike(String value) {
            addCriterion("devices_mac like", value, "devicesMac");
            return (Criteria) this;
        }

        public Criteria andDevicesMacNotLike(String value) {
            addCriterion("devices_mac not like", value, "devicesMac");
            return (Criteria) this;
        }

        public Criteria andDevicesMacIn(List<String> values) {
            addCriterion("devices_mac in", values, "devicesMac");
            return (Criteria) this;
        }

        public Criteria andDevicesMacNotIn(List<String> values) {
            addCriterion("devices_mac not in", values, "devicesMac");
            return (Criteria) this;
        }

        public Criteria andDevicesMacBetween(String value1, String value2) {
            addCriterion("devices_mac between", value1, value2, "devicesMac");
            return (Criteria) this;
        }

        public Criteria andDevicesMacNotBetween(String value1, String value2) {
            addCriterion("devices_mac not between", value1, value2, "devicesMac");
            return (Criteria) this;
        }

        public Criteria andDevicesWifiIsNull() {
            addCriterion("devices_wifi is null");
            return (Criteria) this;
        }

        public Criteria andDevicesWifiIsNotNull() {
            addCriterion("devices_wifi is not null");
            return (Criteria) this;
        }

        public Criteria andDevicesWifiEqualTo(String value) {
            addCriterion("devices_wifi =", value, "devicesWifi");
            return (Criteria) this;
        }

        public Criteria andDevicesWifiNotEqualTo(String value) {
            addCriterion("devices_wifi <>", value, "devicesWifi");
            return (Criteria) this;
        }

        public Criteria andDevicesWifiGreaterThan(String value) {
            addCriterion("devices_wifi >", value, "devicesWifi");
            return (Criteria) this;
        }

        public Criteria andDevicesWifiGreaterThanOrEqualTo(String value) {
            addCriterion("devices_wifi >=", value, "devicesWifi");
            return (Criteria) this;
        }

        public Criteria andDevicesWifiLessThan(String value) {
            addCriterion("devices_wifi <", value, "devicesWifi");
            return (Criteria) this;
        }

        public Criteria andDevicesWifiLessThanOrEqualTo(String value) {
            addCriterion("devices_wifi <=", value, "devicesWifi");
            return (Criteria) this;
        }

        public Criteria andDevicesWifiLike(String value) {
            addCriterion("devices_wifi like", value, "devicesWifi");
            return (Criteria) this;
        }

        public Criteria andDevicesWifiNotLike(String value) {
            addCriterion("devices_wifi not like", value, "devicesWifi");
            return (Criteria) this;
        }

        public Criteria andDevicesWifiIn(List<String> values) {
            addCriterion("devices_wifi in", values, "devicesWifi");
            return (Criteria) this;
        }

        public Criteria andDevicesWifiNotIn(List<String> values) {
            addCriterion("devices_wifi not in", values, "devicesWifi");
            return (Criteria) this;
        }

        public Criteria andDevicesWifiBetween(String value1, String value2) {
            addCriterion("devices_wifi between", value1, value2, "devicesWifi");
            return (Criteria) this;
        }

        public Criteria andDevicesWifiNotBetween(String value1, String value2) {
            addCriterion("devices_wifi not between", value1, value2, "devicesWifi");
            return (Criteria) this;
        }

        public Criteria andDevicesIpIsNull() {
            addCriterion("devices_ip is null");
            return (Criteria) this;
        }

        public Criteria andDevicesIpIsNotNull() {
            addCriterion("devices_ip is not null");
            return (Criteria) this;
        }

        public Criteria andDevicesIpEqualTo(String value) {
            addCriterion("devices_ip =", value, "devicesIp");
            return (Criteria) this;
        }

        public Criteria andDevicesIpNotEqualTo(String value) {
            addCriterion("devices_ip <>", value, "devicesIp");
            return (Criteria) this;
        }

        public Criteria andDevicesIpGreaterThan(String value) {
            addCriterion("devices_ip >", value, "devicesIp");
            return (Criteria) this;
        }

        public Criteria andDevicesIpGreaterThanOrEqualTo(String value) {
            addCriterion("devices_ip >=", value, "devicesIp");
            return (Criteria) this;
        }

        public Criteria andDevicesIpLessThan(String value) {
            addCriterion("devices_ip <", value, "devicesIp");
            return (Criteria) this;
        }

        public Criteria andDevicesIpLessThanOrEqualTo(String value) {
            addCriterion("devices_ip <=", value, "devicesIp");
            return (Criteria) this;
        }

        public Criteria andDevicesIpLike(String value) {
            addCriterion("devices_ip like", value, "devicesIp");
            return (Criteria) this;
        }

        public Criteria andDevicesIpNotLike(String value) {
            addCriterion("devices_ip not like", value, "devicesIp");
            return (Criteria) this;
        }

        public Criteria andDevicesIpIn(List<String> values) {
            addCriterion("devices_ip in", values, "devicesIp");
            return (Criteria) this;
        }

        public Criteria andDevicesIpNotIn(List<String> values) {
            addCriterion("devices_ip not in", values, "devicesIp");
            return (Criteria) this;
        }

        public Criteria andDevicesIpBetween(String value1, String value2) {
            addCriterion("devices_ip between", value1, value2, "devicesIp");
            return (Criteria) this;
        }

        public Criteria andDevicesIpNotBetween(String value1, String value2) {
            addCriterion("devices_ip not between", value1, value2, "devicesIp");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemTypeIsNull() {
            addCriterion("devices_System_Type is null");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemTypeIsNotNull() {
            addCriterion("devices_System_Type is not null");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemTypeEqualTo(String value) {
            addCriterion("devices_System_Type =", value, "devicesSystemType");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemTypeNotEqualTo(String value) {
            addCriterion("devices_System_Type <>", value, "devicesSystemType");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemTypeGreaterThan(String value) {
            addCriterion("devices_System_Type >", value, "devicesSystemType");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemTypeGreaterThanOrEqualTo(String value) {
            addCriterion("devices_System_Type >=", value, "devicesSystemType");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemTypeLessThan(String value) {
            addCriterion("devices_System_Type <", value, "devicesSystemType");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemTypeLessThanOrEqualTo(String value) {
            addCriterion("devices_System_Type <=", value, "devicesSystemType");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemTypeLike(String value) {
            addCriterion("devices_System_Type like", value, "devicesSystemType");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemTypeNotLike(String value) {
            addCriterion("devices_System_Type not like", value, "devicesSystemType");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemTypeIn(List<String> values) {
            addCriterion("devices_System_Type in", values, "devicesSystemType");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemTypeNotIn(List<String> values) {
            addCriterion("devices_System_Type not in", values, "devicesSystemType");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemTypeBetween(String value1, String value2) {
            addCriterion("devices_System_Type between", value1, value2, "devicesSystemType");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemTypeNotBetween(String value1, String value2) {
            addCriterion("devices_System_Type not between", value1, value2, "devicesSystemType");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemVersionIsNull() {
            addCriterion("devices_System_Version is null");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemVersionIsNotNull() {
            addCriterion("devices_System_Version is not null");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemVersionEqualTo(String value) {
            addCriterion("devices_System_Version =", value, "devicesSystemVersion");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemVersionNotEqualTo(String value) {
            addCriterion("devices_System_Version <>", value, "devicesSystemVersion");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemVersionGreaterThan(String value) {
            addCriterion("devices_System_Version >", value, "devicesSystemVersion");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemVersionGreaterThanOrEqualTo(String value) {
            addCriterion("devices_System_Version >=", value, "devicesSystemVersion");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemVersionLessThan(String value) {
            addCriterion("devices_System_Version <", value, "devicesSystemVersion");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemVersionLessThanOrEqualTo(String value) {
            addCriterion("devices_System_Version <=", value, "devicesSystemVersion");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemVersionLike(String value) {
            addCriterion("devices_System_Version like", value, "devicesSystemVersion");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemVersionNotLike(String value) {
            addCriterion("devices_System_Version not like", value, "devicesSystemVersion");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemVersionIn(List<String> values) {
            addCriterion("devices_System_Version in", values, "devicesSystemVersion");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemVersionNotIn(List<String> values) {
            addCriterion("devices_System_Version not in", values, "devicesSystemVersion");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemVersionBetween(String value1, String value2) {
            addCriterion("devices_System_Version between", value1, value2, "devicesSystemVersion");
            return (Criteria) this;
        }

        public Criteria andDevicesSystemVersionNotBetween(String value1, String value2) {
            addCriterion("devices_System_Version not between", value1, value2, "devicesSystemVersion");
            return (Criteria) this;
        }

        public Criteria andDevicesAppVersionIsNull() {
            addCriterion("devices_app_Version is null");
            return (Criteria) this;
        }

        public Criteria andDevicesAppVersionIsNotNull() {
            addCriterion("devices_app_Version is not null");
            return (Criteria) this;
        }

        public Criteria andDevicesAppVersionEqualTo(String value) {
            addCriterion("devices_app_Version =", value, "devicesAppVersion");
            return (Criteria) this;
        }

        public Criteria andDevicesAppVersionNotEqualTo(String value) {
            addCriterion("devices_app_Version <>", value, "devicesAppVersion");
            return (Criteria) this;
        }

        public Criteria andDevicesAppVersionGreaterThan(String value) {
            addCriterion("devices_app_Version >", value, "devicesAppVersion");
            return (Criteria) this;
        }

        public Criteria andDevicesAppVersionGreaterThanOrEqualTo(String value) {
            addCriterion("devices_app_Version >=", value, "devicesAppVersion");
            return (Criteria) this;
        }

        public Criteria andDevicesAppVersionLessThan(String value) {
            addCriterion("devices_app_Version <", value, "devicesAppVersion");
            return (Criteria) this;
        }

        public Criteria andDevicesAppVersionLessThanOrEqualTo(String value) {
            addCriterion("devices_app_Version <=", value, "devicesAppVersion");
            return (Criteria) this;
        }

        public Criteria andDevicesAppVersionLike(String value) {
            addCriterion("devices_app_Version like", value, "devicesAppVersion");
            return (Criteria) this;
        }

        public Criteria andDevicesAppVersionNotLike(String value) {
            addCriterion("devices_app_Version not like", value, "devicesAppVersion");
            return (Criteria) this;
        }

        public Criteria andDevicesAppVersionIn(List<String> values) {
            addCriterion("devices_app_Version in", values, "devicesAppVersion");
            return (Criteria) this;
        }

        public Criteria andDevicesAppVersionNotIn(List<String> values) {
            addCriterion("devices_app_Version not in", values, "devicesAppVersion");
            return (Criteria) this;
        }

        public Criteria andDevicesAppVersionBetween(String value1, String value2) {
            addCriterion("devices_app_Version between", value1, value2, "devicesAppVersion");
            return (Criteria) this;
        }

        public Criteria andDevicesAppVersionNotBetween(String value1, String value2) {
            addCriterion("devices_app_Version not between", value1, value2, "devicesAppVersion");
            return (Criteria) this;
        }

        public Criteria andDevicesAddtimeIsNull() {
            addCriterion("devices_addtime is null");
            return (Criteria) this;
        }

        public Criteria andDevicesAddtimeIsNotNull() {
            addCriterion("devices_addtime is not null");
            return (Criteria) this;
        }

        public Criteria andDevicesAddtimeEqualTo(Date value) {
            addCriterion("devices_addtime =", value, "devicesAddtime");
            return (Criteria) this;
        }

        public Criteria andDevicesAddtimeNotEqualTo(Date value) {
            addCriterion("devices_addtime <>", value, "devicesAddtime");
            return (Criteria) this;
        }

        public Criteria andDevicesAddtimeGreaterThan(Date value) {
            addCriterion("devices_addtime >", value, "devicesAddtime");
            return (Criteria) this;
        }

        public Criteria andDevicesAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("devices_addtime >=", value, "devicesAddtime");
            return (Criteria) this;
        }

        public Criteria andDevicesAddtimeLessThan(Date value) {
            addCriterion("devices_addtime <", value, "devicesAddtime");
            return (Criteria) this;
        }

        public Criteria andDevicesAddtimeLessThanOrEqualTo(Date value) {
            addCriterion("devices_addtime <=", value, "devicesAddtime");
            return (Criteria) this;
        }

        public Criteria andDevicesAddtimeIn(List<Date> values) {
            addCriterion("devices_addtime in", values, "devicesAddtime");
            return (Criteria) this;
        }

        public Criteria andDevicesAddtimeNotIn(List<Date> values) {
            addCriterion("devices_addtime not in", values, "devicesAddtime");
            return (Criteria) this;
        }

        public Criteria andDevicesAddtimeBetween(Date value1, Date value2) {
            addCriterion("devices_addtime between", value1, value2, "devicesAddtime");
            return (Criteria) this;
        }

        public Criteria andDevicesAddtimeNotBetween(Date value1, Date value2) {
            addCriterion("devices_addtime not between", value1, value2, "devicesAddtime");
            return (Criteria) this;
        }

        public Criteria andDevicesUpptimeIsNull() {
            addCriterion("devices_upptime is null");
            return (Criteria) this;
        }

        public Criteria andDevicesUpptimeIsNotNull() {
            addCriterion("devices_upptime is not null");
            return (Criteria) this;
        }

        public Criteria andDevicesUpptimeEqualTo(Date value) {
            addCriterion("devices_upptime =", value, "devicesUpptime");
            return (Criteria) this;
        }

        public Criteria andDevicesUpptimeNotEqualTo(Date value) {
            addCriterion("devices_upptime <>", value, "devicesUpptime");
            return (Criteria) this;
        }

        public Criteria andDevicesUpptimeGreaterThan(Date value) {
            addCriterion("devices_upptime >", value, "devicesUpptime");
            return (Criteria) this;
        }

        public Criteria andDevicesUpptimeGreaterThanOrEqualTo(Date value) {
            addCriterion("devices_upptime >=", value, "devicesUpptime");
            return (Criteria) this;
        }

        public Criteria andDevicesUpptimeLessThan(Date value) {
            addCriterion("devices_upptime <", value, "devicesUpptime");
            return (Criteria) this;
        }

        public Criteria andDevicesUpptimeLessThanOrEqualTo(Date value) {
            addCriterion("devices_upptime <=", value, "devicesUpptime");
            return (Criteria) this;
        }

        public Criteria andDevicesUpptimeIn(List<Date> values) {
            addCriterion("devices_upptime in", values, "devicesUpptime");
            return (Criteria) this;
        }

        public Criteria andDevicesUpptimeNotIn(List<Date> values) {
            addCriterion("devices_upptime not in", values, "devicesUpptime");
            return (Criteria) this;
        }

        public Criteria andDevicesUpptimeBetween(Date value1, Date value2) {
            addCriterion("devices_upptime between", value1, value2, "devicesUpptime");
            return (Criteria) this;
        }

        public Criteria andDevicesUpptimeNotBetween(Date value1, Date value2) {
            addCriterion("devices_upptime not between", value1, value2, "devicesUpptime");
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
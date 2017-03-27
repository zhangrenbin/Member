package com.ice.sh1.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.inspur.guarder.pojo.PageQueryer;

public class RemitsExample extends PageQueryer {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RemitsExample() {
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

        public Criteria andRFromUserIsNull() {
            addCriterion("r_from_user is null");
            return (Criteria) this;
        }

        public Criteria andRFromUserIsNotNull() {
            addCriterion("r_from_user is not null");
            return (Criteria) this;
        }

        public Criteria andRFromUserEqualTo(Integer value) {
            addCriterion("r_from_user =", value, "rFromUser");
            return (Criteria) this;
        }

        public Criteria andRFromUserNotEqualTo(Integer value) {
            addCriterion("r_from_user <>", value, "rFromUser");
            return (Criteria) this;
        }

        public Criteria andRFromUserGreaterThan(Integer value) {
            addCriterion("r_from_user >", value, "rFromUser");
            return (Criteria) this;
        }

        public Criteria andRFromUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("r_from_user >=", value, "rFromUser");
            return (Criteria) this;
        }

        public Criteria andRFromUserLessThan(Integer value) {
            addCriterion("r_from_user <", value, "rFromUser");
            return (Criteria) this;
        }

        public Criteria andRFromUserLessThanOrEqualTo(Integer value) {
            addCriterion("r_from_user <=", value, "rFromUser");
            return (Criteria) this;
        }

        public Criteria andRFromUserIn(List<Integer> values) {
            addCriterion("r_from_user in", values, "rFromUser");
            return (Criteria) this;
        }

        public Criteria andRFromUserNotIn(List<Integer> values) {
            addCriterion("r_from_user not in", values, "rFromUser");
            return (Criteria) this;
        }

        public Criteria andRFromUserBetween(Integer value1, Integer value2) {
            addCriterion("r_from_user between", value1, value2, "rFromUser");
            return (Criteria) this;
        }

        public Criteria andRFromUserNotBetween(Integer value1, Integer value2) {
            addCriterion("r_from_user not between", value1, value2, "rFromUser");
            return (Criteria) this;
        }

        public Criteria andRProxyNameIsNull() {
            addCriterion("r_proxy_name is null");
            return (Criteria) this;
        }

        public Criteria andRProxyNameIsNotNull() {
            addCriterion("r_proxy_name is not null");
            return (Criteria) this;
        }

        public Criteria andRProxyNameEqualTo(String value) {
            addCriterion("r_proxy_name =", value, "rProxyName");
            return (Criteria) this;
        }

        public Criteria andRProxyNameNotEqualTo(String value) {
            addCriterion("r_proxy_name <>", value, "rProxyName");
            return (Criteria) this;
        }

        public Criteria andRProxyNameGreaterThan(String value) {
            addCriterion("r_proxy_name >", value, "rProxyName");
            return (Criteria) this;
        }

        public Criteria andRProxyNameGreaterThanOrEqualTo(String value) {
            addCriterion("r_proxy_name >=", value, "rProxyName");
            return (Criteria) this;
        }

        public Criteria andRProxyNameLessThan(String value) {
            addCriterion("r_proxy_name <", value, "rProxyName");
            return (Criteria) this;
        }

        public Criteria andRProxyNameLessThanOrEqualTo(String value) {
            addCriterion("r_proxy_name <=", value, "rProxyName");
            return (Criteria) this;
        }

        public Criteria andRProxyNameLike(String value) {
            addCriterion("r_proxy_name like", value, "rProxyName");
            return (Criteria) this;
        }

        public Criteria andRProxyNameNotLike(String value) {
            addCriterion("r_proxy_name not like", value, "rProxyName");
            return (Criteria) this;
        }

        public Criteria andRProxyNameIn(List<String> values) {
            addCriterion("r_proxy_name in", values, "rProxyName");
            return (Criteria) this;
        }

        public Criteria andRProxyNameNotIn(List<String> values) {
            addCriterion("r_proxy_name not in", values, "rProxyName");
            return (Criteria) this;
        }

        public Criteria andRProxyNameBetween(String value1, String value2) {
            addCriterion("r_proxy_name between", value1, value2, "rProxyName");
            return (Criteria) this;
        }

        public Criteria andRProxyNameNotBetween(String value1, String value2) {
            addCriterion("r_proxy_name not between", value1, value2, "rProxyName");
            return (Criteria) this;
        }

        public Criteria andRMoneyIsNull() {
            addCriterion("r_money is null");
            return (Criteria) this;
        }

        public Criteria andRMoneyIsNotNull() {
            addCriterion("r_money is not null");
            return (Criteria) this;
        }

        public Criteria andRMoneyEqualTo(Float value) {
            addCriterion("r_money =", value, "rMoney");
            return (Criteria) this;
        }

        public Criteria andRMoneyNotEqualTo(Float value) {
            addCriterion("r_money <>", value, "rMoney");
            return (Criteria) this;
        }

        public Criteria andRMoneyGreaterThan(Float value) {
            addCriterion("r_money >", value, "rMoney");
            return (Criteria) this;
        }

        public Criteria andRMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("r_money >=", value, "rMoney");
            return (Criteria) this;
        }

        public Criteria andRMoneyLessThan(Float value) {
            addCriterion("r_money <", value, "rMoney");
            return (Criteria) this;
        }

        public Criteria andRMoneyLessThanOrEqualTo(Float value) {
            addCriterion("r_money <=", value, "rMoney");
            return (Criteria) this;
        }

        public Criteria andRMoneyIn(List<Float> values) {
            addCriterion("r_money in", values, "rMoney");
            return (Criteria) this;
        }

        public Criteria andRMoneyNotIn(List<Float> values) {
            addCriterion("r_money not in", values, "rMoney");
            return (Criteria) this;
        }

        public Criteria andRMoneyBetween(Float value1, Float value2) {
            addCriterion("r_money between", value1, value2, "rMoney");
            return (Criteria) this;
        }

        public Criteria andRMoneyNotBetween(Float value1, Float value2) {
            addCriterion("r_money not between", value1, value2, "rMoney");
            return (Criteria) this;
        }

        public Criteria andRBAccountIsNull() {
            addCriterion("r_b_account is null");
            return (Criteria) this;
        }

        public Criteria andRBAccountIsNotNull() {
            addCriterion("r_b_account is not null");
            return (Criteria) this;
        }

        public Criteria andRBAccountEqualTo(String value) {
            addCriterion("r_b_account =", value, "rBAccount");
            return (Criteria) this;
        }

        public Criteria andRBAccountNotEqualTo(String value) {
            addCriterion("r_b_account <>", value, "rBAccount");
            return (Criteria) this;
        }

        public Criteria andRBAccountGreaterThan(String value) {
            addCriterion("r_b_account >", value, "rBAccount");
            return (Criteria) this;
        }

        public Criteria andRBAccountGreaterThanOrEqualTo(String value) {
            addCriterion("r_b_account >=", value, "rBAccount");
            return (Criteria) this;
        }

        public Criteria andRBAccountLessThan(String value) {
            addCriterion("r_b_account <", value, "rBAccount");
            return (Criteria) this;
        }

        public Criteria andRBAccountLessThanOrEqualTo(String value) {
            addCriterion("r_b_account <=", value, "rBAccount");
            return (Criteria) this;
        }

        public Criteria andRBAccountLike(String value) {
            addCriterion("r_b_account like", value, "rBAccount");
            return (Criteria) this;
        }

        public Criteria andRBAccountNotLike(String value) {
            addCriterion("r_b_account not like", value, "rBAccount");
            return (Criteria) this;
        }

        public Criteria andRBAccountIn(List<String> values) {
            addCriterion("r_b_account in", values, "rBAccount");
            return (Criteria) this;
        }

        public Criteria andRBAccountNotIn(List<String> values) {
            addCriterion("r_b_account not in", values, "rBAccount");
            return (Criteria) this;
        }

        public Criteria andRBAccountBetween(String value1, String value2) {
            addCriterion("r_b_account between", value1, value2, "rBAccount");
            return (Criteria) this;
        }

        public Criteria andRBAccountNotBetween(String value1, String value2) {
            addCriterion("r_b_account not between", value1, value2, "rBAccount");
            return (Criteria) this;
        }

        public Criteria andRBNameIsNull() {
            addCriterion("r_b_name is null");
            return (Criteria) this;
        }

        public Criteria andRBNameIsNotNull() {
            addCriterion("r_b_name is not null");
            return (Criteria) this;
        }

        public Criteria andRBNameEqualTo(String value) {
            addCriterion("r_b_name =", value, "rBName");
            return (Criteria) this;
        }

        public Criteria andRBNameNotEqualTo(String value) {
            addCriterion("r_b_name <>", value, "rBName");
            return (Criteria) this;
        }

        public Criteria andRBNameGreaterThan(String value) {
            addCriterion("r_b_name >", value, "rBName");
            return (Criteria) this;
        }

        public Criteria andRBNameGreaterThanOrEqualTo(String value) {
            addCriterion("r_b_name >=", value, "rBName");
            return (Criteria) this;
        }

        public Criteria andRBNameLessThan(String value) {
            addCriterion("r_b_name <", value, "rBName");
            return (Criteria) this;
        }

        public Criteria andRBNameLessThanOrEqualTo(String value) {
            addCriterion("r_b_name <=", value, "rBName");
            return (Criteria) this;
        }

        public Criteria andRBNameLike(String value) {
            addCriterion("r_b_name like", value, "rBName");
            return (Criteria) this;
        }

        public Criteria andRBNameNotLike(String value) {
            addCriterion("r_b_name not like", value, "rBName");
            return (Criteria) this;
        }

        public Criteria andRBNameIn(List<String> values) {
            addCriterion("r_b_name in", values, "rBName");
            return (Criteria) this;
        }

        public Criteria andRBNameNotIn(List<String> values) {
            addCriterion("r_b_name not in", values, "rBName");
            return (Criteria) this;
        }

        public Criteria andRBNameBetween(String value1, String value2) {
            addCriterion("r_b_name between", value1, value2, "rBName");
            return (Criteria) this;
        }

        public Criteria andRBNameNotBetween(String value1, String value2) {
            addCriterion("r_b_name not between", value1, value2, "rBName");
            return (Criteria) this;
        }

        public Criteria andRTimeIsNull() {
            addCriterion("r_time is null");
            return (Criteria) this;
        }

        public Criteria andRTimeIsNotNull() {
            addCriterion("r_time is not null");
            return (Criteria) this;
        }

        public Criteria andRTimeEqualTo(Date value) {
            addCriterion("r_time =", value, "rTime");
            return (Criteria) this;
        }

        public Criteria andRTimeNotEqualTo(Date value) {
            addCriterion("r_time <>", value, "rTime");
            return (Criteria) this;
        }

        public Criteria andRTimeGreaterThan(Date value) {
            addCriterion("r_time >", value, "rTime");
            return (Criteria) this;
        }

        public Criteria andRTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("r_time >=", value, "rTime");
            return (Criteria) this;
        }

        public Criteria andRTimeLessThan(Date value) {
            addCriterion("r_time <", value, "rTime");
            return (Criteria) this;
        }

        public Criteria andRTimeLessThanOrEqualTo(Date value) {
            addCriterion("r_time <=", value, "rTime");
            return (Criteria) this;
        }

        public Criteria andRTimeIn(List<Date> values) {
            addCriterion("r_time in", values, "rTime");
            return (Criteria) this;
        }

        public Criteria andRTimeNotIn(List<Date> values) {
            addCriterion("r_time not in", values, "rTime");
            return (Criteria) this;
        }

        public Criteria andRTimeBetween(Date value1, Date value2) {
            addCriterion("r_time between", value1, value2, "rTime");
            return (Criteria) this;
        }

        public Criteria andRTimeNotBetween(Date value1, Date value2) {
            addCriterion("r_time not between", value1, value2, "rTime");
            return (Criteria) this;
        }

        public Criteria andRRemarkIsNull() {
            addCriterion("r_remark is null");
            return (Criteria) this;
        }

        public Criteria andRRemarkIsNotNull() {
            addCriterion("r_remark is not null");
            return (Criteria) this;
        }

        public Criteria andRRemarkEqualTo(String value) {
            addCriterion("r_remark =", value, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkNotEqualTo(String value) {
            addCriterion("r_remark <>", value, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkGreaterThan(String value) {
            addCriterion("r_remark >", value, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("r_remark >=", value, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkLessThan(String value) {
            addCriterion("r_remark <", value, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkLessThanOrEqualTo(String value) {
            addCriterion("r_remark <=", value, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkLike(String value) {
            addCriterion("r_remark like", value, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkNotLike(String value) {
            addCriterion("r_remark not like", value, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkIn(List<String> values) {
            addCriterion("r_remark in", values, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkNotIn(List<String> values) {
            addCriterion("r_remark not in", values, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkBetween(String value1, String value2) {
            addCriterion("r_remark between", value1, value2, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkNotBetween(String value1, String value2) {
            addCriterion("r_remark not between", value1, value2, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRStateIsNull() {
            addCriterion("r_state is null");
            return (Criteria) this;
        }

        public Criteria andRStateIsNotNull() {
            addCriterion("r_state is not null");
            return (Criteria) this;
        }

        public Criteria andRStateEqualTo(Integer value) {
            addCriterion("r_state =", value, "rState");
            return (Criteria) this;
        }

        public Criteria andRStateNotEqualTo(Integer value) {
            addCriterion("r_state <>", value, "rState");
            return (Criteria) this;
        }

        public Criteria andRStateGreaterThan(Integer value) {
            addCriterion("r_state >", value, "rState");
            return (Criteria) this;
        }

        public Criteria andRStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("r_state >=", value, "rState");
            return (Criteria) this;
        }

        public Criteria andRStateLessThan(Integer value) {
            addCriterion("r_state <", value, "rState");
            return (Criteria) this;
        }

        public Criteria andRStateLessThanOrEqualTo(Integer value) {
            addCriterion("r_state <=", value, "rState");
            return (Criteria) this;
        }

        public Criteria andRStateIn(List<Integer> values) {
            addCriterion("r_state in", values, "rState");
            return (Criteria) this;
        }

        public Criteria andRStateNotIn(List<Integer> values) {
            addCriterion("r_state not in", values, "rState");
            return (Criteria) this;
        }

        public Criteria andRStateBetween(Integer value1, Integer value2) {
            addCriterion("r_state between", value1, value2, "rState");
            return (Criteria) this;
        }

        public Criteria andRStateNotBetween(Integer value1, Integer value2) {
            addCriterion("r_state not between", value1, value2, "rState");
            return (Criteria) this;
        }

        public Criteria andRSubDateIsNull() {
            addCriterion("r_sub_date is null");
            return (Criteria) this;
        }

        public Criteria andRSubDateIsNotNull() {
            addCriterion("r_sub_date is not null");
            return (Criteria) this;
        }

        public Criteria andRSubDateEqualTo(Date value) {
            addCriterion("r_sub_date =", value, "rSubDate");
            return (Criteria) this;
        }

        public Criteria andRSubDateNotEqualTo(Date value) {
            addCriterion("r_sub_date <>", value, "rSubDate");
            return (Criteria) this;
        }

        public Criteria andRSubDateGreaterThan(Date value) {
            addCriterion("r_sub_date >", value, "rSubDate");
            return (Criteria) this;
        }

        public Criteria andRSubDateGreaterThanOrEqualTo(Date value) {
            addCriterion("r_sub_date >=", value, "rSubDate");
            return (Criteria) this;
        }

        public Criteria andRSubDateLessThan(Date value) {
            addCriterion("r_sub_date <", value, "rSubDate");
            return (Criteria) this;
        }

        public Criteria andRSubDateLessThanOrEqualTo(Date value) {
            addCriterion("r_sub_date <=", value, "rSubDate");
            return (Criteria) this;
        }

        public Criteria andRSubDateIn(List<Date> values) {
            addCriterion("r_sub_date in", values, "rSubDate");
            return (Criteria) this;
        }

        public Criteria andRSubDateNotIn(List<Date> values) {
            addCriterion("r_sub_date not in", values, "rSubDate");
            return (Criteria) this;
        }

        public Criteria andRSubDateBetween(Date value1, Date value2) {
            addCriterion("r_sub_date between", value1, value2, "rSubDate");
            return (Criteria) this;
        }

        public Criteria andRSubDateNotBetween(Date value1, Date value2) {
            addCriterion("r_sub_date not between", value1, value2, "rSubDate");
            return (Criteria) this;
        }

        public Criteria andRAdminIsNull() {
            addCriterion("r_admin is null");
            return (Criteria) this;
        }

        public Criteria andRAdminIsNotNull() {
            addCriterion("r_admin is not null");
            return (Criteria) this;
        }

        public Criteria andRAdminEqualTo(String value) {
            addCriterion("r_admin =", value, "rAdmin");
            return (Criteria) this;
        }

        public Criteria andRAdminNotEqualTo(String value) {
            addCriterion("r_admin <>", value, "rAdmin");
            return (Criteria) this;
        }

        public Criteria andRAdminGreaterThan(String value) {
            addCriterion("r_admin >", value, "rAdmin");
            return (Criteria) this;
        }

        public Criteria andRAdminGreaterThanOrEqualTo(String value) {
            addCriterion("r_admin >=", value, "rAdmin");
            return (Criteria) this;
        }

        public Criteria andRAdminLessThan(String value) {
            addCriterion("r_admin <", value, "rAdmin");
            return (Criteria) this;
        }

        public Criteria andRAdminLessThanOrEqualTo(String value) {
            addCriterion("r_admin <=", value, "rAdmin");
            return (Criteria) this;
        }

        public Criteria andRAdminLike(String value) {
            addCriterion("r_admin like", value, "rAdmin");
            return (Criteria) this;
        }

        public Criteria andRAdminNotLike(String value) {
            addCriterion("r_admin not like", value, "rAdmin");
            return (Criteria) this;
        }

        public Criteria andRAdminIn(List<String> values) {
            addCriterion("r_admin in", values, "rAdmin");
            return (Criteria) this;
        }

        public Criteria andRAdminNotIn(List<String> values) {
            addCriterion("r_admin not in", values, "rAdmin");
            return (Criteria) this;
        }

        public Criteria andRAdminBetween(String value1, String value2) {
            addCriterion("r_admin between", value1, value2, "rAdmin");
            return (Criteria) this;
        }

        public Criteria andRAdminNotBetween(String value1, String value2) {
            addCriterion("r_admin not between", value1, value2, "rAdmin");
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
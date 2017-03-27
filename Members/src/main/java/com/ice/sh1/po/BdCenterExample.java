package com.ice.sh1.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.inspur.guarder.pojo.PageQueryer;

public class BdCenterExample extends PageQueryer {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BdCenterExample() {
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

        public Criteria andMIdIsNull() {
            addCriterion("m_id is null");
            return (Criteria) this;
        }

        public Criteria andMIdIsNotNull() {
            addCriterion("m_id is not null");
            return (Criteria) this;
        }

        public Criteria andMIdEqualTo(Integer value) {
            addCriterion("m_id =", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotEqualTo(Integer value) {
            addCriterion("m_id <>", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdGreaterThan(Integer value) {
            addCriterion("m_id >", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_id >=", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLessThan(Integer value) {
            addCriterion("m_id <", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLessThanOrEqualTo(Integer value) {
            addCriterion("m_id <=", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdIn(List<Integer> values) {
            addCriterion("m_id in", values, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotIn(List<Integer> values) {
            addCriterion("m_id not in", values, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdBetween(Integer value1, Integer value2) {
            addCriterion("m_id between", value1, value2, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotBetween(Integer value1, Integer value2) {
            addCriterion("m_id not between", value1, value2, "mId");
            return (Criteria) this;
        }

        public Criteria andBDateIsNull() {
            addCriterion("b_date is null");
            return (Criteria) this;
        }

        public Criteria andBDateIsNotNull() {
            addCriterion("b_date is not null");
            return (Criteria) this;
        }

        public Criteria andBDateEqualTo(Date value) {
            addCriterion("b_date =", value, "bDate");
            return (Criteria) this;
        }

        public Criteria andBDateNotEqualTo(Date value) {
            addCriterion("b_date <>", value, "bDate");
            return (Criteria) this;
        }

        public Criteria andBDateGreaterThan(Date value) {
            addCriterion("b_date >", value, "bDate");
            return (Criteria) this;
        }

        public Criteria andBDateGreaterThanOrEqualTo(Date value) {
            addCriterion("b_date >=", value, "bDate");
            return (Criteria) this;
        }

        public Criteria andBDateLessThan(Date value) {
            addCriterion("b_date <", value, "bDate");
            return (Criteria) this;
        }

        public Criteria andBDateLessThanOrEqualTo(Date value) {
            addCriterion("b_date <=", value, "bDate");
            return (Criteria) this;
        }

        public Criteria andBDateIn(List<Date> values) {
            addCriterion("b_date in", values, "bDate");
            return (Criteria) this;
        }

        public Criteria andBDateNotIn(List<Date> values) {
            addCriterion("b_date not in", values, "bDate");
            return (Criteria) this;
        }

        public Criteria andBDateBetween(Date value1, Date value2) {
            addCriterion("b_date between", value1, value2, "bDate");
            return (Criteria) this;
        }

        public Criteria andBDateNotBetween(Date value1, Date value2) {
            addCriterion("b_date not between", value1, value2, "bDate");
            return (Criteria) this;
        }

        public Criteria andBStateIsNull() {
            addCriterion("b_state is null");
            return (Criteria) this;
        }

        public Criteria andBStateIsNotNull() {
            addCriterion("b_state is not null");
            return (Criteria) this;
        }

        public Criteria andBStateEqualTo(Integer value) {
            addCriterion("b_state =", value, "bState");
            return (Criteria) this;
        }

        public Criteria andBStateNotEqualTo(Integer value) {
            addCriterion("b_state <>", value, "bState");
            return (Criteria) this;
        }

        public Criteria andBStateGreaterThan(Integer value) {
            addCriterion("b_state >", value, "bState");
            return (Criteria) this;
        }

        public Criteria andBStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_state >=", value, "bState");
            return (Criteria) this;
        }

        public Criteria andBStateLessThan(Integer value) {
            addCriterion("b_state <", value, "bState");
            return (Criteria) this;
        }

        public Criteria andBStateLessThanOrEqualTo(Integer value) {
            addCriterion("b_state <=", value, "bState");
            return (Criteria) this;
        }

        public Criteria andBStateIn(List<Integer> values) {
            addCriterion("b_state in", values, "bState");
            return (Criteria) this;
        }

        public Criteria andBStateNotIn(List<Integer> values) {
            addCriterion("b_state not in", values, "bState");
            return (Criteria) this;
        }

        public Criteria andBStateBetween(Integer value1, Integer value2) {
            addCriterion("b_state between", value1, value2, "bState");
            return (Criteria) this;
        }

        public Criteria andBStateNotBetween(Integer value1, Integer value2) {
            addCriterion("b_state not between", value1, value2, "bState");
            return (Criteria) this;
        }

        public Criteria andBApproveDateIsNull() {
            addCriterion("b_approve_date is null");
            return (Criteria) this;
        }

        public Criteria andBApproveDateIsNotNull() {
            addCriterion("b_approve_date is not null");
            return (Criteria) this;
        }

        public Criteria andBApproveDateEqualTo(Date value) {
            addCriterion("b_approve_date =", value, "bApproveDate");
            return (Criteria) this;
        }

        public Criteria andBApproveDateNotEqualTo(Date value) {
            addCriterion("b_approve_date <>", value, "bApproveDate");
            return (Criteria) this;
        }

        public Criteria andBApproveDateGreaterThan(Date value) {
            addCriterion("b_approve_date >", value, "bApproveDate");
            return (Criteria) this;
        }

        public Criteria andBApproveDateGreaterThanOrEqualTo(Date value) {
            addCriterion("b_approve_date >=", value, "bApproveDate");
            return (Criteria) this;
        }

        public Criteria andBApproveDateLessThan(Date value) {
            addCriterion("b_approve_date <", value, "bApproveDate");
            return (Criteria) this;
        }

        public Criteria andBApproveDateLessThanOrEqualTo(Date value) {
            addCriterion("b_approve_date <=", value, "bApproveDate");
            return (Criteria) this;
        }

        public Criteria andBApproveDateIn(List<Date> values) {
            addCriterion("b_approve_date in", values, "bApproveDate");
            return (Criteria) this;
        }

        public Criteria andBApproveDateNotIn(List<Date> values) {
            addCriterion("b_approve_date not in", values, "bApproveDate");
            return (Criteria) this;
        }

        public Criteria andBApproveDateBetween(Date value1, Date value2) {
            addCriterion("b_approve_date between", value1, value2, "bApproveDate");
            return (Criteria) this;
        }

        public Criteria andBApproveDateNotBetween(Date value1, Date value2) {
            addCriterion("b_approve_date not between", value1, value2, "bApproveDate");
            return (Criteria) this;
        }

        public Criteria andBAdminIsNull() {
            addCriterion("b_admin is null");
            return (Criteria) this;
        }

        public Criteria andBAdminIsNotNull() {
            addCriterion("b_admin is not null");
            return (Criteria) this;
        }

        public Criteria andBAdminEqualTo(String value) {
            addCriterion("b_admin =", value, "bAdmin");
            return (Criteria) this;
        }

        public Criteria andBAdminNotEqualTo(String value) {
            addCriterion("b_admin <>", value, "bAdmin");
            return (Criteria) this;
        }

        public Criteria andBAdminGreaterThan(String value) {
            addCriterion("b_admin >", value, "bAdmin");
            return (Criteria) this;
        }

        public Criteria andBAdminGreaterThanOrEqualTo(String value) {
            addCriterion("b_admin >=", value, "bAdmin");
            return (Criteria) this;
        }

        public Criteria andBAdminLessThan(String value) {
            addCriterion("b_admin <", value, "bAdmin");
            return (Criteria) this;
        }

        public Criteria andBAdminLessThanOrEqualTo(String value) {
            addCriterion("b_admin <=", value, "bAdmin");
            return (Criteria) this;
        }

        public Criteria andBAdminLike(String value) {
            addCriterion("b_admin like", value, "bAdmin");
            return (Criteria) this;
        }

        public Criteria andBAdminNotLike(String value) {
            addCriterion("b_admin not like", value, "bAdmin");
            return (Criteria) this;
        }

        public Criteria andBAdminIn(List<String> values) {
            addCriterion("b_admin in", values, "bAdmin");
            return (Criteria) this;
        }

        public Criteria andBAdminNotIn(List<String> values) {
            addCriterion("b_admin not in", values, "bAdmin");
            return (Criteria) this;
        }

        public Criteria andBAdminBetween(String value1, String value2) {
            addCriterion("b_admin between", value1, value2, "bAdmin");
            return (Criteria) this;
        }

        public Criteria andBAdminNotBetween(String value1, String value2) {
            addCriterion("b_admin not between", value1, value2, "bAdmin");
            return (Criteria) this;
        }

        public Criteria andBRemarkIsNull() {
            addCriterion("b_remark is null");
            return (Criteria) this;
        }

        public Criteria andBRemarkIsNotNull() {
            addCriterion("b_remark is not null");
            return (Criteria) this;
        }

        public Criteria andBRemarkEqualTo(String value) {
            addCriterion("b_remark =", value, "bRemark");
            return (Criteria) this;
        }

        public Criteria andBRemarkNotEqualTo(String value) {
            addCriterion("b_remark <>", value, "bRemark");
            return (Criteria) this;
        }

        public Criteria andBRemarkGreaterThan(String value) {
            addCriterion("b_remark >", value, "bRemark");
            return (Criteria) this;
        }

        public Criteria andBRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("b_remark >=", value, "bRemark");
            return (Criteria) this;
        }

        public Criteria andBRemarkLessThan(String value) {
            addCriterion("b_remark <", value, "bRemark");
            return (Criteria) this;
        }

        public Criteria andBRemarkLessThanOrEqualTo(String value) {
            addCriterion("b_remark <=", value, "bRemark");
            return (Criteria) this;
        }

        public Criteria andBRemarkLike(String value) {
            addCriterion("b_remark like", value, "bRemark");
            return (Criteria) this;
        }

        public Criteria andBRemarkNotLike(String value) {
            addCriterion("b_remark not like", value, "bRemark");
            return (Criteria) this;
        }

        public Criteria andBRemarkIn(List<String> values) {
            addCriterion("b_remark in", values, "bRemark");
            return (Criteria) this;
        }

        public Criteria andBRemarkNotIn(List<String> values) {
            addCriterion("b_remark not in", values, "bRemark");
            return (Criteria) this;
        }

        public Criteria andBRemarkBetween(String value1, String value2) {
            addCriterion("b_remark between", value1, value2, "bRemark");
            return (Criteria) this;
        }

        public Criteria andBRemarkNotBetween(String value1, String value2) {
            addCriterion("b_remark not between", value1, value2, "bRemark");
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
package com.ice.sh1.po;

import java.util.ArrayList;
import java.util.List;

public class DictCityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DictCityExample() {
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

        public Criteria andNCityidIsNull() {
            addCriterion("N_CITYID is null");
            return (Criteria) this;
        }

        public Criteria andNCityidIsNotNull() {
            addCriterion("N_CITYID is not null");
            return (Criteria) this;
        }

        public Criteria andNCityidEqualTo(Integer value) {
            addCriterion("N_CITYID =", value, "nCityid");
            return (Criteria) this;
        }

        public Criteria andNCityidNotEqualTo(Integer value) {
            addCriterion("N_CITYID <>", value, "nCityid");
            return (Criteria) this;
        }

        public Criteria andNCityidGreaterThan(Integer value) {
            addCriterion("N_CITYID >", value, "nCityid");
            return (Criteria) this;
        }

        public Criteria andNCityidGreaterThanOrEqualTo(Integer value) {
            addCriterion("N_CITYID >=", value, "nCityid");
            return (Criteria) this;
        }

        public Criteria andNCityidLessThan(Integer value) {
            addCriterion("N_CITYID <", value, "nCityid");
            return (Criteria) this;
        }

        public Criteria andNCityidLessThanOrEqualTo(Integer value) {
            addCriterion("N_CITYID <=", value, "nCityid");
            return (Criteria) this;
        }

        public Criteria andNCityidIn(List<Integer> values) {
            addCriterion("N_CITYID in", values, "nCityid");
            return (Criteria) this;
        }

        public Criteria andNCityidNotIn(List<Integer> values) {
            addCriterion("N_CITYID not in", values, "nCityid");
            return (Criteria) this;
        }

        public Criteria andNCityidBetween(Integer value1, Integer value2) {
            addCriterion("N_CITYID between", value1, value2, "nCityid");
            return (Criteria) this;
        }

        public Criteria andNCityidNotBetween(Integer value1, Integer value2) {
            addCriterion("N_CITYID not between", value1, value2, "nCityid");
            return (Criteria) this;
        }

        public Criteria andSCitynameIsNull() {
            addCriterion("S_CITYNAME is null");
            return (Criteria) this;
        }

        public Criteria andSCitynameIsNotNull() {
            addCriterion("S_CITYNAME is not null");
            return (Criteria) this;
        }

        public Criteria andSCitynameEqualTo(String value) {
            addCriterion("S_CITYNAME =", value, "sCityname");
            return (Criteria) this;
        }

        public Criteria andSCitynameNotEqualTo(String value) {
            addCriterion("S_CITYNAME <>", value, "sCityname");
            return (Criteria) this;
        }

        public Criteria andSCitynameGreaterThan(String value) {
            addCriterion("S_CITYNAME >", value, "sCityname");
            return (Criteria) this;
        }

        public Criteria andSCitynameGreaterThanOrEqualTo(String value) {
            addCriterion("S_CITYNAME >=", value, "sCityname");
            return (Criteria) this;
        }

        public Criteria andSCitynameLessThan(String value) {
            addCriterion("S_CITYNAME <", value, "sCityname");
            return (Criteria) this;
        }

        public Criteria andSCitynameLessThanOrEqualTo(String value) {
            addCriterion("S_CITYNAME <=", value, "sCityname");
            return (Criteria) this;
        }

        public Criteria andSCitynameLike(String value) {
            addCriterion("S_CITYNAME like", value, "sCityname");
            return (Criteria) this;
        }

        public Criteria andSCitynameNotLike(String value) {
            addCriterion("S_CITYNAME not like", value, "sCityname");
            return (Criteria) this;
        }

        public Criteria andSCitynameIn(List<String> values) {
            addCriterion("S_CITYNAME in", values, "sCityname");
            return (Criteria) this;
        }

        public Criteria andSCitynameNotIn(List<String> values) {
            addCriterion("S_CITYNAME not in", values, "sCityname");
            return (Criteria) this;
        }

        public Criteria andSCitynameBetween(String value1, String value2) {
            addCriterion("S_CITYNAME between", value1, value2, "sCityname");
            return (Criteria) this;
        }

        public Criteria andSCitynameNotBetween(String value1, String value2) {
            addCriterion("S_CITYNAME not between", value1, value2, "sCityname");
            return (Criteria) this;
        }

        public Criteria andNProvidIsNull() {
            addCriterion("N_PROVID is null");
            return (Criteria) this;
        }

        public Criteria andNProvidIsNotNull() {
            addCriterion("N_PROVID is not null");
            return (Criteria) this;
        }

        public Criteria andNProvidEqualTo(Integer value) {
            addCriterion("N_PROVID =", value, "nProvid");
            return (Criteria) this;
        }

        public Criteria andNProvidNotEqualTo(Integer value) {
            addCriterion("N_PROVID <>", value, "nProvid");
            return (Criteria) this;
        }

        public Criteria andNProvidGreaterThan(Integer value) {
            addCriterion("N_PROVID >", value, "nProvid");
            return (Criteria) this;
        }

        public Criteria andNProvidGreaterThanOrEqualTo(Integer value) {
            addCriterion("N_PROVID >=", value, "nProvid");
            return (Criteria) this;
        }

        public Criteria andNProvidLessThan(Integer value) {
            addCriterion("N_PROVID <", value, "nProvid");
            return (Criteria) this;
        }

        public Criteria andNProvidLessThanOrEqualTo(Integer value) {
            addCriterion("N_PROVID <=", value, "nProvid");
            return (Criteria) this;
        }

        public Criteria andNProvidIn(List<Integer> values) {
            addCriterion("N_PROVID in", values, "nProvid");
            return (Criteria) this;
        }

        public Criteria andNProvidNotIn(List<Integer> values) {
            addCriterion("N_PROVID not in", values, "nProvid");
            return (Criteria) this;
        }

        public Criteria andNProvidBetween(Integer value1, Integer value2) {
            addCriterion("N_PROVID between", value1, value2, "nProvid");
            return (Criteria) this;
        }

        public Criteria andNProvidNotBetween(Integer value1, Integer value2) {
            addCriterion("N_PROVID not between", value1, value2, "nProvid");
            return (Criteria) this;
        }

        public Criteria andSStateIsNull() {
            addCriterion("S_STATE is null");
            return (Criteria) this;
        }

        public Criteria andSStateIsNotNull() {
            addCriterion("S_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andSStateEqualTo(String value) {
            addCriterion("S_STATE =", value, "sState");
            return (Criteria) this;
        }

        public Criteria andSStateNotEqualTo(String value) {
            addCriterion("S_STATE <>", value, "sState");
            return (Criteria) this;
        }

        public Criteria andSStateGreaterThan(String value) {
            addCriterion("S_STATE >", value, "sState");
            return (Criteria) this;
        }

        public Criteria andSStateGreaterThanOrEqualTo(String value) {
            addCriterion("S_STATE >=", value, "sState");
            return (Criteria) this;
        }

        public Criteria andSStateLessThan(String value) {
            addCriterion("S_STATE <", value, "sState");
            return (Criteria) this;
        }

        public Criteria andSStateLessThanOrEqualTo(String value) {
            addCriterion("S_STATE <=", value, "sState");
            return (Criteria) this;
        }

        public Criteria andSStateLike(String value) {
            addCriterion("S_STATE like", value, "sState");
            return (Criteria) this;
        }

        public Criteria andSStateNotLike(String value) {
            addCriterion("S_STATE not like", value, "sState");
            return (Criteria) this;
        }

        public Criteria andSStateIn(List<String> values) {
            addCriterion("S_STATE in", values, "sState");
            return (Criteria) this;
        }

        public Criteria andSStateNotIn(List<String> values) {
            addCriterion("S_STATE not in", values, "sState");
            return (Criteria) this;
        }

        public Criteria andSStateBetween(String value1, String value2) {
            addCriterion("S_STATE between", value1, value2, "sState");
            return (Criteria) this;
        }

        public Criteria andSStateNotBetween(String value1, String value2) {
            addCriterion("S_STATE not between", value1, value2, "sState");
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
package com.ice.sh1.po;

import java.util.ArrayList;
import java.util.List;

public class BonusRuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BonusRuleExample() {
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

        public Criteria andRNameIsNull() {
            addCriterion("r_name is null");
            return (Criteria) this;
        }

        public Criteria andRNameIsNotNull() {
            addCriterion("r_name is not null");
            return (Criteria) this;
        }

        public Criteria andRNameEqualTo(String value) {
            addCriterion("r_name =", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameNotEqualTo(String value) {
            addCriterion("r_name <>", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameGreaterThan(String value) {
            addCriterion("r_name >", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameGreaterThanOrEqualTo(String value) {
            addCriterion("r_name >=", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameLessThan(String value) {
            addCriterion("r_name <", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameLessThanOrEqualTo(String value) {
            addCriterion("r_name <=", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameLike(String value) {
            addCriterion("r_name like", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameNotLike(String value) {
            addCriterion("r_name not like", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameIn(List<String> values) {
            addCriterion("r_name in", values, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameNotIn(List<String> values) {
            addCriterion("r_name not in", values, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameBetween(String value1, String value2) {
            addCriterion("r_name between", value1, value2, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameNotBetween(String value1, String value2) {
            addCriterion("r_name not between", value1, value2, "rName");
            return (Criteria) this;
        }

        public Criteria andRDescIsNull() {
            addCriterion("r_desc is null");
            return (Criteria) this;
        }

        public Criteria andRDescIsNotNull() {
            addCriterion("r_desc is not null");
            return (Criteria) this;
        }

        public Criteria andRDescEqualTo(String value) {
            addCriterion("r_desc =", value, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescNotEqualTo(String value) {
            addCriterion("r_desc <>", value, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescGreaterThan(String value) {
            addCriterion("r_desc >", value, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescGreaterThanOrEqualTo(String value) {
            addCriterion("r_desc >=", value, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescLessThan(String value) {
            addCriterion("r_desc <", value, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescLessThanOrEqualTo(String value) {
            addCriterion("r_desc <=", value, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescLike(String value) {
            addCriterion("r_desc like", value, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescNotLike(String value) {
            addCriterion("r_desc not like", value, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescIn(List<String> values) {
            addCriterion("r_desc in", values, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescNotIn(List<String> values) {
            addCriterion("r_desc not in", values, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescBetween(String value1, String value2) {
            addCriterion("r_desc between", value1, value2, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescNotBetween(String value1, String value2) {
            addCriterion("r_desc not between", value1, value2, "rDesc");
            return (Criteria) this;
        }

        public Criteria andREnableIsNull() {
            addCriterion("r_enable is null");
            return (Criteria) this;
        }

        public Criteria andREnableIsNotNull() {
            addCriterion("r_enable is not null");
            return (Criteria) this;
        }

        public Criteria andREnableEqualTo(Integer value) {
            addCriterion("r_enable =", value, "rEnable");
            return (Criteria) this;
        }

        public Criteria andREnableNotEqualTo(Integer value) {
            addCriterion("r_enable <>", value, "rEnable");
            return (Criteria) this;
        }

        public Criteria andREnableGreaterThan(Integer value) {
            addCriterion("r_enable >", value, "rEnable");
            return (Criteria) this;
        }

        public Criteria andREnableGreaterThanOrEqualTo(Integer value) {
            addCriterion("r_enable >=", value, "rEnable");
            return (Criteria) this;
        }

        public Criteria andREnableLessThan(Integer value) {
            addCriterion("r_enable <", value, "rEnable");
            return (Criteria) this;
        }

        public Criteria andREnableLessThanOrEqualTo(Integer value) {
            addCriterion("r_enable <=", value, "rEnable");
            return (Criteria) this;
        }

        public Criteria andREnableIn(List<Integer> values) {
            addCriterion("r_enable in", values, "rEnable");
            return (Criteria) this;
        }

        public Criteria andREnableNotIn(List<Integer> values) {
            addCriterion("r_enable not in", values, "rEnable");
            return (Criteria) this;
        }

        public Criteria andREnableBetween(Integer value1, Integer value2) {
            addCriterion("r_enable between", value1, value2, "rEnable");
            return (Criteria) this;
        }

        public Criteria andREnableNotBetween(Integer value1, Integer value2) {
            addCriterion("r_enable not between", value1, value2, "rEnable");
            return (Criteria) this;
        }

        public Criteria andRClassIsNull() {
            addCriterion("r_class is null");
            return (Criteria) this;
        }

        public Criteria andRClassIsNotNull() {
            addCriterion("r_class is not null");
            return (Criteria) this;
        }

        public Criteria andRClassEqualTo(String value) {
            addCriterion("r_class =", value, "rClass");
            return (Criteria) this;
        }

        public Criteria andRClassNotEqualTo(String value) {
            addCriterion("r_class <>", value, "rClass");
            return (Criteria) this;
        }

        public Criteria andRClassGreaterThan(String value) {
            addCriterion("r_class >", value, "rClass");
            return (Criteria) this;
        }

        public Criteria andRClassGreaterThanOrEqualTo(String value) {
            addCriterion("r_class >=", value, "rClass");
            return (Criteria) this;
        }

        public Criteria andRClassLessThan(String value) {
            addCriterion("r_class <", value, "rClass");
            return (Criteria) this;
        }

        public Criteria andRClassLessThanOrEqualTo(String value) {
            addCriterion("r_class <=", value, "rClass");
            return (Criteria) this;
        }

        public Criteria andRClassLike(String value) {
            addCriterion("r_class like", value, "rClass");
            return (Criteria) this;
        }

        public Criteria andRClassNotLike(String value) {
            addCriterion("r_class not like", value, "rClass");
            return (Criteria) this;
        }

        public Criteria andRClassIn(List<String> values) {
            addCriterion("r_class in", values, "rClass");
            return (Criteria) this;
        }

        public Criteria andRClassNotIn(List<String> values) {
            addCriterion("r_class not in", values, "rClass");
            return (Criteria) this;
        }

        public Criteria andRClassBetween(String value1, String value2) {
            addCriterion("r_class between", value1, value2, "rClass");
            return (Criteria) this;
        }

        public Criteria andRClassNotBetween(String value1, String value2) {
            addCriterion("r_class not between", value1, value2, "rClass");
            return (Criteria) this;
        }

        public Criteria andRBonusIsNull() {
            addCriterion("r_bonus is null");
            return (Criteria) this;
        }

        public Criteria andRBonusIsNotNull() {
            addCriterion("r_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andRBonusEqualTo(Float value) {
            addCriterion("r_bonus =", value, "rBonus");
            return (Criteria) this;
        }

        public Criteria andRBonusNotEqualTo(Float value) {
            addCriterion("r_bonus <>", value, "rBonus");
            return (Criteria) this;
        }

        public Criteria andRBonusGreaterThan(Float value) {
            addCriterion("r_bonus >", value, "rBonus");
            return (Criteria) this;
        }

        public Criteria andRBonusGreaterThanOrEqualTo(Float value) {
            addCriterion("r_bonus >=", value, "rBonus");
            return (Criteria) this;
        }

        public Criteria andRBonusLessThan(Float value) {
            addCriterion("r_bonus <", value, "rBonus");
            return (Criteria) this;
        }

        public Criteria andRBonusLessThanOrEqualTo(Float value) {
            addCriterion("r_bonus <=", value, "rBonus");
            return (Criteria) this;
        }

        public Criteria andRBonusIn(List<Float> values) {
            addCriterion("r_bonus in", values, "rBonus");
            return (Criteria) this;
        }

        public Criteria andRBonusNotIn(List<Float> values) {
            addCriterion("r_bonus not in", values, "rBonus");
            return (Criteria) this;
        }

        public Criteria andRBonusBetween(Float value1, Float value2) {
            addCriterion("r_bonus between", value1, value2, "rBonus");
            return (Criteria) this;
        }

        public Criteria andRBonusNotBetween(Float value1, Float value2) {
            addCriterion("r_bonus not between", value1, value2, "rBonus");
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
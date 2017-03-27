package com.ice.sh1.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.inspur.guarder.pojo.PageQueryer;

public class BonusRecordExample extends PageQueryer {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BonusRecordExample() {
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

        public Criteria andRMemberIsNull() {
            addCriterion("r_member is null");
            return (Criteria) this;
        }

        public Criteria andRMemberIsNotNull() {
            addCriterion("r_member is not null");
            return (Criteria) this;
        }

        public Criteria andRMemberEqualTo(Integer value) {
            addCriterion("r_member =", value, "rMember");
            return (Criteria) this;
        }

        public Criteria andRMemberNotEqualTo(Integer value) {
            addCriterion("r_member <>", value, "rMember");
            return (Criteria) this;
        }

        public Criteria andRMemberGreaterThan(Integer value) {
            addCriterion("r_member >", value, "rMember");
            return (Criteria) this;
        }

        public Criteria andRMemberGreaterThanOrEqualTo(Integer value) {
            addCriterion("r_member >=", value, "rMember");
            return (Criteria) this;
        }

        public Criteria andRMemberLessThan(Integer value) {
            addCriterion("r_member <", value, "rMember");
            return (Criteria) this;
        }

        public Criteria andRMemberLessThanOrEqualTo(Integer value) {
            addCriterion("r_member <=", value, "rMember");
            return (Criteria) this;
        }

        public Criteria andRMemberIn(List<Integer> values) {
            addCriterion("r_member in", values, "rMember");
            return (Criteria) this;
        }

        public Criteria andRMemberNotIn(List<Integer> values) {
            addCriterion("r_member not in", values, "rMember");
            return (Criteria) this;
        }

        public Criteria andRMemberBetween(Integer value1, Integer value2) {
            addCriterion("r_member between", value1, value2, "rMember");
            return (Criteria) this;
        }

        public Criteria andRMemberNotBetween(Integer value1, Integer value2) {
            addCriterion("r_member not between", value1, value2, "rMember");
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

        public Criteria andRPointIsNull() {
            addCriterion("r_point is null");
            return (Criteria) this;
        }

        public Criteria andRPointIsNotNull() {
            addCriterion("r_point is not null");
            return (Criteria) this;
        }

        public Criteria andRPointEqualTo(String value) {
            addCriterion("r_point =", value, "rPoint");
            return (Criteria) this;
        }

        public Criteria andRPointNotEqualTo(String value) {
            addCriterion("r_point <>", value, "rPoint");
            return (Criteria) this;
        }

        public Criteria andRPointGreaterThan(String value) {
            addCriterion("r_point >", value, "rPoint");
            return (Criteria) this;
        }

        public Criteria andRPointGreaterThanOrEqualTo(String value) {
            addCriterion("r_point >=", value, "rPoint");
            return (Criteria) this;
        }

        public Criteria andRPointLessThan(String value) {
            addCriterion("r_point <", value, "rPoint");
            return (Criteria) this;
        }

        public Criteria andRPointLessThanOrEqualTo(String value) {
            addCriterion("r_point <=", value, "rPoint");
            return (Criteria) this;
        }

        public Criteria andRPointLike(String value) {
            addCriterion("r_point like", value, "rPoint");
            return (Criteria) this;
        }

        public Criteria andRPointNotLike(String value) {
            addCriterion("r_point not like", value, "rPoint");
            return (Criteria) this;
        }

        public Criteria andRPointIn(List<String> values) {
            addCriterion("r_point in", values, "rPoint");
            return (Criteria) this;
        }

        public Criteria andRPointNotIn(List<String> values) {
            addCriterion("r_point not in", values, "rPoint");
            return (Criteria) this;
        }

        public Criteria andRPointBetween(String value1, String value2) {
            addCriterion("r_point between", value1, value2, "rPoint");
            return (Criteria) this;
        }

        public Criteria andRPointNotBetween(String value1, String value2) {
            addCriterion("r_point not between", value1, value2, "rPoint");
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

        public Criteria andRAddupIsNull() {
            addCriterion("\"r_ addup\" is null");
            return (Criteria) this;
        }

        public Criteria andRAddupIsNotNull() {
            addCriterion("\"r_ addup\" is not null");
            return (Criteria) this;
        }

        public Criteria andRAddupEqualTo(Integer value) {
            addCriterion("\"r_ addup\" =", value, "rAddup");
            return (Criteria) this;
        }

        public Criteria andRAddupNotEqualTo(Integer value) {
            addCriterion("\"r_ addup\" <>", value, "rAddup");
            return (Criteria) this;
        }

        public Criteria andRAddupGreaterThan(Integer value) {
            addCriterion("\"r_ addup\" >", value, "rAddup");
            return (Criteria) this;
        }

        public Criteria andRAddupGreaterThanOrEqualTo(Integer value) {
            addCriterion("\"r_ addup\" >=", value, "rAddup");
            return (Criteria) this;
        }

        public Criteria andRAddupLessThan(Integer value) {
            addCriterion("\"r_ addup\" <", value, "rAddup");
            return (Criteria) this;
        }

        public Criteria andRAddupLessThanOrEqualTo(Integer value) {
            addCriterion("\"r_ addup\" <=", value, "rAddup");
            return (Criteria) this;
        }

        public Criteria andRAddupIn(List<Integer> values) {
            addCriterion("\"r_ addup\" in", values, "rAddup");
            return (Criteria) this;
        }

        public Criteria andRAddupNotIn(List<Integer> values) {
            addCriterion("\"r_ addup\" not in", values, "rAddup");
            return (Criteria) this;
        }

        public Criteria andRAddupBetween(Integer value1, Integer value2) {
            addCriterion("\"r_ addup\" between", value1, value2, "rAddup");
            return (Criteria) this;
        }

        public Criteria andRAddupNotBetween(Integer value1, Integer value2) {
            addCriterion("\"r_ addup\" not between", value1, value2, "rAddup");
            return (Criteria) this;
        }

        public Criteria andRRuleIsNull() {
            addCriterion("r_rule is null");
            return (Criteria) this;
        }

        public Criteria andRRuleIsNotNull() {
            addCriterion("r_rule is not null");
            return (Criteria) this;
        }

        public Criteria andRRuleEqualTo(Integer value) {
            addCriterion("r_rule =", value, "rRule");
            return (Criteria) this;
        }

        public Criteria andRRuleNotEqualTo(Integer value) {
            addCriterion("r_rule <>", value, "rRule");
            return (Criteria) this;
        }

        public Criteria andRRuleGreaterThan(Integer value) {
            addCriterion("r_rule >", value, "rRule");
            return (Criteria) this;
        }

        public Criteria andRRuleGreaterThanOrEqualTo(Integer value) {
            addCriterion("r_rule >=", value, "rRule");
            return (Criteria) this;
        }

        public Criteria andRRuleLessThan(Integer value) {
            addCriterion("r_rule <", value, "rRule");
            return (Criteria) this;
        }

        public Criteria andRRuleLessThanOrEqualTo(Integer value) {
            addCriterion("r_rule <=", value, "rRule");
            return (Criteria) this;
        }

        public Criteria andRRuleIn(List<Integer> values) {
            addCriterion("r_rule in", values, "rRule");
            return (Criteria) this;
        }

        public Criteria andRRuleNotIn(List<Integer> values) {
            addCriterion("r_rule not in", values, "rRule");
            return (Criteria) this;
        }

        public Criteria andRRuleBetween(Integer value1, Integer value2) {
            addCriterion("r_rule between", value1, value2, "rRule");
            return (Criteria) this;
        }

        public Criteria andRRuleNotBetween(Integer value1, Integer value2) {
            addCriterion("r_rule not between", value1, value2, "rRule");
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
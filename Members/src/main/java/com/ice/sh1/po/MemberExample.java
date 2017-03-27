package com.ice.sh1.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.inspur.guarder.pojo.PageQueryer;

public class MemberExample extends PageQueryer {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberExample() {
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

        public Criteria andMAccountIsNull() {
            addCriterion("m_account is null");
            return (Criteria) this;
        }

        public Criteria andMAccountIsNotNull() {
            addCriterion("m_account is not null");
            return (Criteria) this;
        }

        public Criteria andMAccountEqualTo(String value) {
            addCriterion("m_account =", value, "mAccount");
            return (Criteria) this;
        }

        public Criteria andMAccountNotEqualTo(String value) {
            addCriterion("m_account <>", value, "mAccount");
            return (Criteria) this;
        }

        public Criteria andMAccountGreaterThan(String value) {
            addCriterion("m_account >", value, "mAccount");
            return (Criteria) this;
        }

        public Criteria andMAccountGreaterThanOrEqualTo(String value) {
            addCriterion("m_account >=", value, "mAccount");
            return (Criteria) this;
        }

        public Criteria andMAccountLessThan(String value) {
            addCriterion("m_account <", value, "mAccount");
            return (Criteria) this;
        }

        public Criteria andMAccountLessThanOrEqualTo(String value) {
            addCriterion("m_account <=", value, "mAccount");
            return (Criteria) this;
        }

        public Criteria andMAccountLike(String value) {
            addCriterion("m_account like", value, "mAccount");
            return (Criteria) this;
        }

        public Criteria andMAccountNotLike(String value) {
            addCriterion("m_account not like", value, "mAccount");
            return (Criteria) this;
        }

        public Criteria andMAccountIn(List<String> values) {
            addCriterion("m_account in", values, "mAccount");
            return (Criteria) this;
        }

        public Criteria andMAccountNotIn(List<String> values) {
            addCriterion("m_account not in", values, "mAccount");
            return (Criteria) this;
        }

        public Criteria andMAccountBetween(String value1, String value2) {
            addCriterion("m_account between", value1, value2, "mAccount");
            return (Criteria) this;
        }

        public Criteria andMAccountNotBetween(String value1, String value2) {
            addCriterion("m_account not between", value1, value2, "mAccount");
            return (Criteria) this;
        }

        public Criteria andMCnnameIsNull() {
            addCriterion("m_cnname is null");
            return (Criteria) this;
        }

        public Criteria andMCnnameIsNotNull() {
            addCriterion("m_cnname is not null");
            return (Criteria) this;
        }

        public Criteria andMCnnameEqualTo(String value) {
            addCriterion("m_cnname =", value, "mCnname");
            return (Criteria) this;
        }

        public Criteria andMCnnameNotEqualTo(String value) {
            addCriterion("m_cnname <>", value, "mCnname");
            return (Criteria) this;
        }

        public Criteria andMCnnameGreaterThan(String value) {
            addCriterion("m_cnname >", value, "mCnname");
            return (Criteria) this;
        }

        public Criteria andMCnnameGreaterThanOrEqualTo(String value) {
            addCriterion("m_cnname >=", value, "mCnname");
            return (Criteria) this;
        }

        public Criteria andMCnnameLessThan(String value) {
            addCriterion("m_cnname <", value, "mCnname");
            return (Criteria) this;
        }

        public Criteria andMCnnameLessThanOrEqualTo(String value) {
            addCriterion("m_cnname <=", value, "mCnname");
            return (Criteria) this;
        }

        public Criteria andMCnnameLike(String value) {
            addCriterion("m_cnname like", value, "mCnname");
            return (Criteria) this;
        }

        public Criteria andMCnnameNotLike(String value) {
            addCriterion("m_cnname not like", value, "mCnname");
            return (Criteria) this;
        }

        public Criteria andMCnnameIn(List<String> values) {
            addCriterion("m_cnname in", values, "mCnname");
            return (Criteria) this;
        }

        public Criteria andMCnnameNotIn(List<String> values) {
            addCriterion("m_cnname not in", values, "mCnname");
            return (Criteria) this;
        }

        public Criteria andMCnnameBetween(String value1, String value2) {
            addCriterion("m_cnname between", value1, value2, "mCnname");
            return (Criteria) this;
        }

        public Criteria andMCnnameNotBetween(String value1, String value2) {
            addCriterion("m_cnname not between", value1, value2, "mCnname");
            return (Criteria) this;
        }

        public Criteria andMIdnumIsNull() {
            addCriterion("m_idnum is null");
            return (Criteria) this;
        }

        public Criteria andMIdnumIsNotNull() {
            addCriterion("m_idnum is not null");
            return (Criteria) this;
        }

        public Criteria andMIdnumEqualTo(String value) {
            addCriterion("m_idnum =", value, "mIdnum");
            return (Criteria) this;
        }

        public Criteria andMIdnumNotEqualTo(String value) {
            addCriterion("m_idnum <>", value, "mIdnum");
            return (Criteria) this;
        }

        public Criteria andMIdnumGreaterThan(String value) {
            addCriterion("m_idnum >", value, "mIdnum");
            return (Criteria) this;
        }

        public Criteria andMIdnumGreaterThanOrEqualTo(String value) {
            addCriterion("m_idnum >=", value, "mIdnum");
            return (Criteria) this;
        }

        public Criteria andMIdnumLessThan(String value) {
            addCriterion("m_idnum <", value, "mIdnum");
            return (Criteria) this;
        }

        public Criteria andMIdnumLessThanOrEqualTo(String value) {
            addCriterion("m_idnum <=", value, "mIdnum");
            return (Criteria) this;
        }

        public Criteria andMIdnumLike(String value) {
            addCriterion("m_idnum like", value, "mIdnum");
            return (Criteria) this;
        }

        public Criteria andMIdnumNotLike(String value) {
            addCriterion("m_idnum not like", value, "mIdnum");
            return (Criteria) this;
        }

        public Criteria andMIdnumIn(List<String> values) {
            addCriterion("m_idnum in", values, "mIdnum");
            return (Criteria) this;
        }

        public Criteria andMIdnumNotIn(List<String> values) {
            addCriterion("m_idnum not in", values, "mIdnum");
            return (Criteria) this;
        }

        public Criteria andMIdnumBetween(String value1, String value2) {
            addCriterion("m_idnum between", value1, value2, "mIdnum");
            return (Criteria) this;
        }

        public Criteria andMIdnumNotBetween(String value1, String value2) {
            addCriterion("m_idnum not between", value1, value2, "mIdnum");
            return (Criteria) this;
        }

        public Criteria andMMobileIsNull() {
            addCriterion("m_mobile is null");
            return (Criteria) this;
        }

        public Criteria andMMobileIsNotNull() {
            addCriterion("m_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMMobileEqualTo(String value) {
            addCriterion("m_mobile =", value, "mMobile");
            return (Criteria) this;
        }

        public Criteria andMMobileNotEqualTo(String value) {
            addCriterion("m_mobile <>", value, "mMobile");
            return (Criteria) this;
        }

        public Criteria andMMobileGreaterThan(String value) {
            addCriterion("m_mobile >", value, "mMobile");
            return (Criteria) this;
        }

        public Criteria andMMobileGreaterThanOrEqualTo(String value) {
            addCriterion("m_mobile >=", value, "mMobile");
            return (Criteria) this;
        }

        public Criteria andMMobileLessThan(String value) {
            addCriterion("m_mobile <", value, "mMobile");
            return (Criteria) this;
        }

        public Criteria andMMobileLessThanOrEqualTo(String value) {
            addCriterion("m_mobile <=", value, "mMobile");
            return (Criteria) this;
        }

        public Criteria andMMobileLike(String value) {
            addCriterion("m_mobile like", value, "mMobile");
            return (Criteria) this;
        }

        public Criteria andMMobileNotLike(String value) {
            addCriterion("m_mobile not like", value, "mMobile");
            return (Criteria) this;
        }

        public Criteria andMMobileIn(List<String> values) {
            addCriterion("m_mobile in", values, "mMobile");
            return (Criteria) this;
        }

        public Criteria andMMobileNotIn(List<String> values) {
            addCriterion("m_mobile not in", values, "mMobile");
            return (Criteria) this;
        }

        public Criteria andMMobileBetween(String value1, String value2) {
            addCriterion("m_mobile between", value1, value2, "mMobile");
            return (Criteria) this;
        }

        public Criteria andMMobileNotBetween(String value1, String value2) {
            addCriterion("m_mobile not between", value1, value2, "mMobile");
            return (Criteria) this;
        }

        public Criteria andMPasswordIsNull() {
            addCriterion("m_password is null");
            return (Criteria) this;
        }

        public Criteria andMPasswordIsNotNull() {
            addCriterion("m_password is not null");
            return (Criteria) this;
        }

        public Criteria andMPasswordEqualTo(String value) {
            addCriterion("m_password =", value, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordNotEqualTo(String value) {
            addCriterion("m_password <>", value, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordGreaterThan(String value) {
            addCriterion("m_password >", value, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("m_password >=", value, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordLessThan(String value) {
            addCriterion("m_password <", value, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordLessThanOrEqualTo(String value) {
            addCriterion("m_password <=", value, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordLike(String value) {
            addCriterion("m_password like", value, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordNotLike(String value) {
            addCriterion("m_password not like", value, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordIn(List<String> values) {
            addCriterion("m_password in", values, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordNotIn(List<String> values) {
            addCriterion("m_password not in", values, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordBetween(String value1, String value2) {
            addCriterion("m_password between", value1, value2, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordNotBetween(String value1, String value2) {
            addCriterion("m_password not between", value1, value2, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPassword2IsNull() {
            addCriterion("m_password2 is null");
            return (Criteria) this;
        }

        public Criteria andMPassword2IsNotNull() {
            addCriterion("m_password2 is not null");
            return (Criteria) this;
        }

        public Criteria andMPassword2EqualTo(String value) {
            addCriterion("m_password2 =", value, "mPassword2");
            return (Criteria) this;
        }

        public Criteria andMPassword2NotEqualTo(String value) {
            addCriterion("m_password2 <>", value, "mPassword2");
            return (Criteria) this;
        }

        public Criteria andMPassword2GreaterThan(String value) {
            addCriterion("m_password2 >", value, "mPassword2");
            return (Criteria) this;
        }

        public Criteria andMPassword2GreaterThanOrEqualTo(String value) {
            addCriterion("m_password2 >=", value, "mPassword2");
            return (Criteria) this;
        }

        public Criteria andMPassword2LessThan(String value) {
            addCriterion("m_password2 <", value, "mPassword2");
            return (Criteria) this;
        }

        public Criteria andMPassword2LessThanOrEqualTo(String value) {
            addCriterion("m_password2 <=", value, "mPassword2");
            return (Criteria) this;
        }

        public Criteria andMPassword2Like(String value) {
            addCriterion("m_password2 like", value, "mPassword2");
            return (Criteria) this;
        }

        public Criteria andMPassword2NotLike(String value) {
            addCriterion("m_password2 not like", value, "mPassword2");
            return (Criteria) this;
        }

        public Criteria andMPassword2In(List<String> values) {
            addCriterion("m_password2 in", values, "mPassword2");
            return (Criteria) this;
        }

        public Criteria andMPassword2NotIn(List<String> values) {
            addCriterion("m_password2 not in", values, "mPassword2");
            return (Criteria) this;
        }

        public Criteria andMPassword2Between(String value1, String value2) {
            addCriterion("m_password2 between", value1, value2, "mPassword2");
            return (Criteria) this;
        }

        public Criteria andMPassword2NotBetween(String value1, String value2) {
            addCriterion("m_password2 not between", value1, value2, "mPassword2");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andMAddrIsNull() {
            addCriterion("m_addr is null");
            return (Criteria) this;
        }

        public Criteria andMAddrIsNotNull() {
            addCriterion("m_addr is not null");
            return (Criteria) this;
        }

        public Criteria andMAddrEqualTo(String value) {
            addCriterion("m_addr =", value, "mAddr");
            return (Criteria) this;
        }

        public Criteria andMAddrNotEqualTo(String value) {
            addCriterion("m_addr <>", value, "mAddr");
            return (Criteria) this;
        }

        public Criteria andMAddrGreaterThan(String value) {
            addCriterion("m_addr >", value, "mAddr");
            return (Criteria) this;
        }

        public Criteria andMAddrGreaterThanOrEqualTo(String value) {
            addCriterion("m_addr >=", value, "mAddr");
            return (Criteria) this;
        }

        public Criteria andMAddrLessThan(String value) {
            addCriterion("m_addr <", value, "mAddr");
            return (Criteria) this;
        }

        public Criteria andMAddrLessThanOrEqualTo(String value) {
            addCriterion("m_addr <=", value, "mAddr");
            return (Criteria) this;
        }

        public Criteria andMAddrLike(String value) {
            addCriterion("m_addr like", value, "mAddr");
            return (Criteria) this;
        }

        public Criteria andMAddrNotLike(String value) {
            addCriterion("m_addr not like", value, "mAddr");
            return (Criteria) this;
        }

        public Criteria andMAddrIn(List<String> values) {
            addCriterion("m_addr in", values, "mAddr");
            return (Criteria) this;
        }

        public Criteria andMAddrNotIn(List<String> values) {
            addCriterion("m_addr not in", values, "mAddr");
            return (Criteria) this;
        }

        public Criteria andMAddrBetween(String value1, String value2) {
            addCriterion("m_addr between", value1, value2, "mAddr");
            return (Criteria) this;
        }

        public Criteria andMAddrNotBetween(String value1, String value2) {
            addCriterion("m_addr not between", value1, value2, "mAddr");
            return (Criteria) this;
        }

        public Criteria andMProvinceIsNull() {
            addCriterion("m_province is null");
            return (Criteria) this;
        }

        public Criteria andMProvinceIsNotNull() {
            addCriterion("m_province is not null");
            return (Criteria) this;
        }

        public Criteria andMProvinceEqualTo(Integer value) {
            addCriterion("m_province =", value, "mProvince");
            return (Criteria) this;
        }

        public Criteria andMProvinceNotEqualTo(Integer value) {
            addCriterion("m_province <>", value, "mProvince");
            return (Criteria) this;
        }

        public Criteria andMProvinceGreaterThan(Integer value) {
            addCriterion("m_province >", value, "mProvince");
            return (Criteria) this;
        }

        public Criteria andMProvinceGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_province >=", value, "mProvince");
            return (Criteria) this;
        }

        public Criteria andMProvinceLessThan(Integer value) {
            addCriterion("m_province <", value, "mProvince");
            return (Criteria) this;
        }

        public Criteria andMProvinceLessThanOrEqualTo(Integer value) {
            addCriterion("m_province <=", value, "mProvince");
            return (Criteria) this;
        }

        public Criteria andMProvinceIn(List<Integer> values) {
            addCriterion("m_province in", values, "mProvince");
            return (Criteria) this;
        }

        public Criteria andMProvinceNotIn(List<Integer> values) {
            addCriterion("m_province not in", values, "mProvince");
            return (Criteria) this;
        }

        public Criteria andMProvinceBetween(Integer value1, Integer value2) {
            addCriterion("m_province between", value1, value2, "mProvince");
            return (Criteria) this;
        }

        public Criteria andMProvinceNotBetween(Integer value1, Integer value2) {
            addCriterion("m_province not between", value1, value2, "mProvince");
            return (Criteria) this;
        }

        public Criteria andMCityIsNull() {
            addCriterion("m_city is null");
            return (Criteria) this;
        }

        public Criteria andMCityIsNotNull() {
            addCriterion("m_city is not null");
            return (Criteria) this;
        }

        public Criteria andMCityEqualTo(Integer value) {
            addCriterion("m_city =", value, "mCity");
            return (Criteria) this;
        }

        public Criteria andMCityNotEqualTo(Integer value) {
            addCriterion("m_city <>", value, "mCity");
            return (Criteria) this;
        }

        public Criteria andMCityGreaterThan(Integer value) {
            addCriterion("m_city >", value, "mCity");
            return (Criteria) this;
        }

        public Criteria andMCityGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_city >=", value, "mCity");
            return (Criteria) this;
        }

        public Criteria andMCityLessThan(Integer value) {
            addCriterion("m_city <", value, "mCity");
            return (Criteria) this;
        }

        public Criteria andMCityLessThanOrEqualTo(Integer value) {
            addCriterion("m_city <=", value, "mCity");
            return (Criteria) this;
        }

        public Criteria andMCityIn(List<Integer> values) {
            addCriterion("m_city in", values, "mCity");
            return (Criteria) this;
        }

        public Criteria andMCityNotIn(List<Integer> values) {
            addCriterion("m_city not in", values, "mCity");
            return (Criteria) this;
        }

        public Criteria andMCityBetween(Integer value1, Integer value2) {
            addCriterion("m_city between", value1, value2, "mCity");
            return (Criteria) this;
        }

        public Criteria andMCityNotBetween(Integer value1, Integer value2) {
            addCriterion("m_city not between", value1, value2, "mCity");
            return (Criteria) this;
        }

        public Criteria andMBankIsNull() {
            addCriterion("m_bank is null");
            return (Criteria) this;
        }

        public Criteria andMBankIsNotNull() {
            addCriterion("m_bank is not null");
            return (Criteria) this;
        }

        public Criteria andMBankEqualTo(String value) {
            addCriterion("m_bank =", value, "mBank");
            return (Criteria) this;
        }

        public Criteria andMBankNotEqualTo(String value) {
            addCriterion("m_bank <>", value, "mBank");
            return (Criteria) this;
        }

        public Criteria andMBankGreaterThan(String value) {
            addCriterion("m_bank >", value, "mBank");
            return (Criteria) this;
        }

        public Criteria andMBankGreaterThanOrEqualTo(String value) {
            addCriterion("m_bank >=", value, "mBank");
            return (Criteria) this;
        }

        public Criteria andMBankLessThan(String value) {
            addCriterion("m_bank <", value, "mBank");
            return (Criteria) this;
        }

        public Criteria andMBankLessThanOrEqualTo(String value) {
            addCriterion("m_bank <=", value, "mBank");
            return (Criteria) this;
        }

        public Criteria andMBankLike(String value) {
            addCriterion("m_bank like", value, "mBank");
            return (Criteria) this;
        }

        public Criteria andMBankNotLike(String value) {
            addCriterion("m_bank not like", value, "mBank");
            return (Criteria) this;
        }

        public Criteria andMBankIn(List<String> values) {
            addCriterion("m_bank in", values, "mBank");
            return (Criteria) this;
        }

        public Criteria andMBankNotIn(List<String> values) {
            addCriterion("m_bank not in", values, "mBank");
            return (Criteria) this;
        }

        public Criteria andMBankBetween(String value1, String value2) {
            addCriterion("m_bank between", value1, value2, "mBank");
            return (Criteria) this;
        }

        public Criteria andMBankNotBetween(String value1, String value2) {
            addCriterion("m_bank not between", value1, value2, "mBank");
            return (Criteria) this;
        }

        public Criteria andMBAccountIsNull() {
            addCriterion("m_b_account is null");
            return (Criteria) this;
        }

        public Criteria andMBAccountIsNotNull() {
            addCriterion("m_b_account is not null");
            return (Criteria) this;
        }

        public Criteria andMBAccountEqualTo(String value) {
            addCriterion("m_b_account =", value, "mBAccount");
            return (Criteria) this;
        }

        public Criteria andMBAccountNotEqualTo(String value) {
            addCriterion("m_b_account <>", value, "mBAccount");
            return (Criteria) this;
        }

        public Criteria andMBAccountGreaterThan(String value) {
            addCriterion("m_b_account >", value, "mBAccount");
            return (Criteria) this;
        }

        public Criteria andMBAccountGreaterThanOrEqualTo(String value) {
            addCriterion("m_b_account >=", value, "mBAccount");
            return (Criteria) this;
        }

        public Criteria andMBAccountLessThan(String value) {
            addCriterion("m_b_account <", value, "mBAccount");
            return (Criteria) this;
        }

        public Criteria andMBAccountLessThanOrEqualTo(String value) {
            addCriterion("m_b_account <=", value, "mBAccount");
            return (Criteria) this;
        }

        public Criteria andMBAccountLike(String value) {
            addCriterion("m_b_account like", value, "mBAccount");
            return (Criteria) this;
        }

        public Criteria andMBAccountNotLike(String value) {
            addCriterion("m_b_account not like", value, "mBAccount");
            return (Criteria) this;
        }

        public Criteria andMBAccountIn(List<String> values) {
            addCriterion("m_b_account in", values, "mBAccount");
            return (Criteria) this;
        }

        public Criteria andMBAccountNotIn(List<String> values) {
            addCriterion("m_b_account not in", values, "mBAccount");
            return (Criteria) this;
        }

        public Criteria andMBAccountBetween(String value1, String value2) {
            addCriterion("m_b_account between", value1, value2, "mBAccount");
            return (Criteria) this;
        }

        public Criteria andMBAccountNotBetween(String value1, String value2) {
            addCriterion("m_b_account not between", value1, value2, "mBAccount");
            return (Criteria) this;
        }

        public Criteria andMBNameIsNull() {
            addCriterion("m_b_name is null");
            return (Criteria) this;
        }

        public Criteria andMBNameIsNotNull() {
            addCriterion("m_b_name is not null");
            return (Criteria) this;
        }

        public Criteria andMBNameEqualTo(String value) {
            addCriterion("m_b_name =", value, "mBName");
            return (Criteria) this;
        }

        public Criteria andMBNameNotEqualTo(String value) {
            addCriterion("m_b_name <>", value, "mBName");
            return (Criteria) this;
        }

        public Criteria andMBNameGreaterThan(String value) {
            addCriterion("m_b_name >", value, "mBName");
            return (Criteria) this;
        }

        public Criteria andMBNameGreaterThanOrEqualTo(String value) {
            addCriterion("m_b_name >=", value, "mBName");
            return (Criteria) this;
        }

        public Criteria andMBNameLessThan(String value) {
            addCriterion("m_b_name <", value, "mBName");
            return (Criteria) this;
        }

        public Criteria andMBNameLessThanOrEqualTo(String value) {
            addCriterion("m_b_name <=", value, "mBName");
            return (Criteria) this;
        }

        public Criteria andMBNameLike(String value) {
            addCriterion("m_b_name like", value, "mBName");
            return (Criteria) this;
        }

        public Criteria andMBNameNotLike(String value) {
            addCriterion("m_b_name not like", value, "mBName");
            return (Criteria) this;
        }

        public Criteria andMBNameIn(List<String> values) {
            addCriterion("m_b_name in", values, "mBName");
            return (Criteria) this;
        }

        public Criteria andMBNameNotIn(List<String> values) {
            addCriterion("m_b_name not in", values, "mBName");
            return (Criteria) this;
        }

        public Criteria andMBNameBetween(String value1, String value2) {
            addCriterion("m_b_name between", value1, value2, "mBName");
            return (Criteria) this;
        }

        public Criteria andMBNameNotBetween(String value1, String value2) {
            addCriterion("m_b_name not between", value1, value2, "mBName");
            return (Criteria) this;
        }

        public Criteria andMRecommderIsNull() {
            addCriterion("m_recommder is null");
            return (Criteria) this;
        }

        public Criteria andMRecommderIsNotNull() {
            addCriterion("m_recommder is not null");
            return (Criteria) this;
        }

        public Criteria andMRecommderEqualTo(Integer value) {
            addCriterion("m_recommder =", value, "mRecommder");
            return (Criteria) this;
        }

        public Criteria andMRecommderNotEqualTo(Integer value) {
            addCriterion("m_recommder <>", value, "mRecommder");
            return (Criteria) this;
        }

        public Criteria andMRecommderGreaterThan(Integer value) {
            addCriterion("m_recommder >", value, "mRecommder");
            return (Criteria) this;
        }

        public Criteria andMRecommderGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_recommder >=", value, "mRecommder");
            return (Criteria) this;
        }

        public Criteria andMRecommderLessThan(Integer value) {
            addCriterion("m_recommder <", value, "mRecommder");
            return (Criteria) this;
        }

        public Criteria andMRecommderLessThanOrEqualTo(Integer value) {
            addCriterion("m_recommder <=", value, "mRecommder");
            return (Criteria) this;
        }

        public Criteria andMRecommderIn(List<Integer> values) {
            addCriterion("m_recommder in", values, "mRecommder");
            return (Criteria) this;
        }

        public Criteria andMRecommderNotIn(List<Integer> values) {
            addCriterion("m_recommder not in", values, "mRecommder");
            return (Criteria) this;
        }

        public Criteria andMRecommderBetween(Integer value1, Integer value2) {
            addCriterion("m_recommder between", value1, value2, "mRecommder");
            return (Criteria) this;
        }

        public Criteria andMRecommderNotBetween(Integer value1, Integer value2) {
            addCriterion("m_recommder not between", value1, value2, "mRecommder");
            return (Criteria) this;
        }

        public Criteria andMRegdateIsNull() {
            addCriterion("m_regdate is null");
            return (Criteria) this;
        }

        public Criteria andMRegdateIsNotNull() {
            addCriterion("m_regdate is not null");
            return (Criteria) this;
        }

        public Criteria andMRegdateEqualTo(Date value) {
            addCriterion("m_regdate =", value, "mRegdate");
            return (Criteria) this;
        }

        public Criteria andMRegdateNotEqualTo(Date value) {
            addCriterion("m_regdate <>", value, "mRegdate");
            return (Criteria) this;
        }

        public Criteria andMRegdateGreaterThan(Date value) {
            addCriterion("m_regdate >", value, "mRegdate");
            return (Criteria) this;
        }

        public Criteria andMRegdateGreaterThanOrEqualTo(Date value) {
            addCriterion("m_regdate >=", value, "mRegdate");
            return (Criteria) this;
        }

        public Criteria andMRegdateLessThan(Date value) {
            addCriterion("m_regdate <", value, "mRegdate");
            return (Criteria) this;
        }

        public Criteria andMRegdateLessThanOrEqualTo(Date value) {
            addCriterion("m_regdate <=", value, "mRegdate");
            return (Criteria) this;
        }

        public Criteria andMRegdateIn(List<Date> values) {
            addCriterion("m_regdate in", values, "mRegdate");
            return (Criteria) this;
        }

        public Criteria andMRegdateNotIn(List<Date> values) {
            addCriterion("m_regdate not in", values, "mRegdate");
            return (Criteria) this;
        }

        public Criteria andMRegdateBetween(Date value1, Date value2) {
            addCriterion("m_regdate between", value1, value2, "mRegdate");
            return (Criteria) this;
        }

        public Criteria andMRegdateNotBetween(Date value1, Date value2) {
            addCriterion("m_regdate not between", value1, value2, "mRegdate");
            return (Criteria) this;
        }

        public Criteria andMActivedateIsNull() {
            addCriterion("m_activedate is null");
            return (Criteria) this;
        }

        public Criteria andMActivedateIsNotNull() {
            addCriterion("m_activedate is not null");
            return (Criteria) this;
        }

        public Criteria andMActivedateEqualTo(Date value) {
            addCriterion("m_activedate =", value, "mActivedate");
            return (Criteria) this;
        }

        public Criteria andMActivedateNotEqualTo(Date value) {
            addCriterion("m_activedate <>", value, "mActivedate");
            return (Criteria) this;
        }

        public Criteria andMActivedateGreaterThan(Date value) {
            addCriterion("m_activedate >", value, "mActivedate");
            return (Criteria) this;
        }

        public Criteria andMActivedateGreaterThanOrEqualTo(Date value) {
            addCriterion("m_activedate >=", value, "mActivedate");
            return (Criteria) this;
        }

        public Criteria andMActivedateLessThan(Date value) {
            addCriterion("m_activedate <", value, "mActivedate");
            return (Criteria) this;
        }

        public Criteria andMActivedateLessThanOrEqualTo(Date value) {
            addCriterion("m_activedate <=", value, "mActivedate");
            return (Criteria) this;
        }

        public Criteria andMActivedateIn(List<Date> values) {
            addCriterion("m_activedate in", values, "mActivedate");
            return (Criteria) this;
        }

        public Criteria andMActivedateNotIn(List<Date> values) {
            addCriterion("m_activedate not in", values, "mActivedate");
            return (Criteria) this;
        }

        public Criteria andMActivedateBetween(Date value1, Date value2) {
            addCriterion("m_activedate between", value1, value2, "mActivedate");
            return (Criteria) this;
        }

        public Criteria andMActivedateNotBetween(Date value1, Date value2) {
            addCriterion("m_activedate not between", value1, value2, "mActivedate");
            return (Criteria) this;
        }

        public Criteria andMBalanceIsNull() {
            addCriterion("m_balance is null");
            return (Criteria) this;
        }

        public Criteria andMBalanceIsNotNull() {
            addCriterion("m_balance is not null");
            return (Criteria) this;
        }

        public Criteria andMBalanceEqualTo(Float value) {
            addCriterion("m_balance =", value, "mBalance");
            return (Criteria) this;
        }

        public Criteria andMBalanceNotEqualTo(Float value) {
            addCriterion("m_balance <>", value, "mBalance");
            return (Criteria) this;
        }

        public Criteria andMBalanceGreaterThan(Float value) {
            addCriterion("m_balance >", value, "mBalance");
            return (Criteria) this;
        }

        public Criteria andMBalanceGreaterThanOrEqualTo(Float value) {
            addCriterion("m_balance >=", value, "mBalance");
            return (Criteria) this;
        }

        public Criteria andMBalanceLessThan(Float value) {
            addCriterion("m_balance <", value, "mBalance");
            return (Criteria) this;
        }

        public Criteria andMBalanceLessThanOrEqualTo(Float value) {
            addCriterion("m_balance <=", value, "mBalance");
            return (Criteria) this;
        }

        public Criteria andMBalanceIn(List<Float> values) {
            addCriterion("m_balance in", values, "mBalance");
            return (Criteria) this;
        }

        public Criteria andMBalanceNotIn(List<Float> values) {
            addCriterion("m_balance not in", values, "mBalance");
            return (Criteria) this;
        }

        public Criteria andMBalanceBetween(Float value1, Float value2) {
            addCriterion("m_balance between", value1, value2, "mBalance");
            return (Criteria) this;
        }

        public Criteria andMBalanceNotBetween(Float value1, Float value2) {
            addCriterion("m_balance not between", value1, value2, "mBalance");
            return (Criteria) this;
        }

        public Criteria andMTotalIsNull() {
            addCriterion("m_total is null");
            return (Criteria) this;
        }

        public Criteria andMTotalIsNotNull() {
            addCriterion("m_total is not null");
            return (Criteria) this;
        }

        public Criteria andMTotalEqualTo(Float value) {
            addCriterion("m_total =", value, "mTotal");
            return (Criteria) this;
        }

        public Criteria andMTotalNotEqualTo(Float value) {
            addCriterion("m_total <>", value, "mTotal");
            return (Criteria) this;
        }

        public Criteria andMTotalGreaterThan(Float value) {
            addCriterion("m_total >", value, "mTotal");
            return (Criteria) this;
        }

        public Criteria andMTotalGreaterThanOrEqualTo(Float value) {
            addCriterion("m_total >=", value, "mTotal");
            return (Criteria) this;
        }

        public Criteria andMTotalLessThan(Float value) {
            addCriterion("m_total <", value, "mTotal");
            return (Criteria) this;
        }

        public Criteria andMTotalLessThanOrEqualTo(Float value) {
            addCriterion("m_total <=", value, "mTotal");
            return (Criteria) this;
        }

        public Criteria andMTotalIn(List<Float> values) {
            addCriterion("m_total in", values, "mTotal");
            return (Criteria) this;
        }

        public Criteria andMTotalNotIn(List<Float> values) {
            addCriterion("m_total not in", values, "mTotal");
            return (Criteria) this;
        }

        public Criteria andMTotalBetween(Float value1, Float value2) {
            addCriterion("m_total between", value1, value2, "mTotal");
            return (Criteria) this;
        }

        public Criteria andMTotalNotBetween(Float value1, Float value2) {
            addCriterion("m_total not between", value1, value2, "mTotal");
            return (Criteria) this;
        }
        
        public Criteria andMActiveIsNull() {
            addCriterion("m_active is null");
            return (Criteria) this;
        }

        public Criteria andMActiveIsNotNull() {
            addCriterion("m_active is not null");
            return (Criteria) this;
        }

        public Criteria andMActiveEqualTo(Integer value) {
            addCriterion("m_active =", value, "mActive");
            return (Criteria) this;
        }

        public Criteria andMActiveNotEqualTo(Integer value) {
            addCriterion("m_active <>", value, "mActive");
            return (Criteria) this;
        }

        public Criteria andMActiveGreaterThan(Integer value) {
            addCriterion("m_active >", value, "mActive");
            return (Criteria) this;
        }

        public Criteria andMActiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_active >=", value, "mActive");
            return (Criteria) this;
        }

        public Criteria andMActiveLessThan(Integer value) {
            addCriterion("m_active <", value, "mActive");
            return (Criteria) this;
        }

        public Criteria andMActiveLessThanOrEqualTo(Integer value) {
            addCriterion("m_active <=", value, "mActive");
            return (Criteria) this;
        }

        public Criteria andMActiveIn(List<Integer> values) {
            addCriterion("m_active in", values, "mActive");
            return (Criteria) this;
        }

        public Criteria andMActiveNotIn(List<Integer> values) {
            addCriterion("m_active not in", values, "mActive");
            return (Criteria) this;
        }

        public Criteria andMActiveBetween(Integer value1, Integer value2) {
            addCriterion("m_active between", value1, value2, "mActive");
            return (Criteria) this;
        }

        public Criteria andMActiveNotBetween(Integer value1, Integer value2) {
            addCriterion("m_active not between", value1, value2, "mActive");
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
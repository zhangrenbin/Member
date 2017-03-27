package com.ice.sh1.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.inspur.guarder.pojo.PageQueryer;

public class WithDrawExample extends PageQueryer {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WithDrawExample() {
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

        public Criteria andMembIdIsNull() {
            addCriterion("memb_id is null");
            return (Criteria) this;
        }

        public Criteria andMembIdIsNotNull() {
            addCriterion("memb_id is not null");
            return (Criteria) this;
        }

        public Criteria andMembIdEqualTo(Integer value) {
            addCriterion("memb_id =", value, "membId");
            return (Criteria) this;
        }

        public Criteria andMembIdNotEqualTo(Integer value) {
            addCriterion("memb_id <>", value, "membId");
            return (Criteria) this;
        }

        public Criteria andMembIdGreaterThan(Integer value) {
            addCriterion("memb_id >", value, "membId");
            return (Criteria) this;
        }

        public Criteria andMembIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("memb_id >=", value, "membId");
            return (Criteria) this;
        }

        public Criteria andMembIdLessThan(Integer value) {
            addCriterion("memb_id <", value, "membId");
            return (Criteria) this;
        }

        public Criteria andMembIdLessThanOrEqualTo(Integer value) {
            addCriterion("memb_id <=", value, "membId");
            return (Criteria) this;
        }

        public Criteria andMembIdIn(List<Integer> values) {
            addCriterion("memb_id in", values, "membId");
            return (Criteria) this;
        }

        public Criteria andMembIdNotIn(List<Integer> values) {
            addCriterion("memb_id not in", values, "membId");
            return (Criteria) this;
        }

        public Criteria andMembIdBetween(Integer value1, Integer value2) {
            addCriterion("memb_id between", value1, value2, "membId");
            return (Criteria) this;
        }

        public Criteria andMembIdNotBetween(Integer value1, Integer value2) {
            addCriterion("memb_id not between", value1, value2, "membId");
            return (Criteria) this;
        }

        public Criteria andTxDateIsNull() {
            addCriterion("tx_date is null");
            return (Criteria) this;
        }

        public Criteria andTxDateIsNotNull() {
            addCriterion("tx_date is not null");
            return (Criteria) this;
        }

        public Criteria andTxDateEqualTo(Date value) {
            addCriterion("tx_date =", value, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateNotEqualTo(Date value) {
            addCriterion("tx_date <>", value, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateGreaterThan(Date value) {
            addCriterion("tx_date >", value, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateGreaterThanOrEqualTo(Date value) {
            addCriterion("tx_date >=", value, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateLessThan(Date value) {
            addCriterion("tx_date <", value, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateLessThanOrEqualTo(Date value) {
            addCriterion("tx_date <=", value, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateIn(List<Date> values) {
            addCriterion("tx_date in", values, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateNotIn(List<Date> values) {
            addCriterion("tx_date not in", values, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateBetween(Date value1, Date value2) {
            addCriterion("tx_date between", value1, value2, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateNotBetween(Date value1, Date value2) {
            addCriterion("tx_date not between", value1, value2, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxMoneyIsNull() {
            addCriterion("tx_money is null");
            return (Criteria) this;
        }

        public Criteria andTxMoneyIsNotNull() {
            addCriterion("tx_money is not null");
            return (Criteria) this;
        }

        public Criteria andTxMoneyEqualTo(Float value) {
            addCriterion("tx_money =", value, "txMoney");
            return (Criteria) this;
        }

        public Criteria andTxMoneyNotEqualTo(Float value) {
            addCriterion("tx_money <>", value, "txMoney");
            return (Criteria) this;
        }

        public Criteria andTxMoneyGreaterThan(Float value) {
            addCriterion("tx_money >", value, "txMoney");
            return (Criteria) this;
        }

        public Criteria andTxMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("tx_money >=", value, "txMoney");
            return (Criteria) this;
        }

        public Criteria andTxMoneyLessThan(Float value) {
            addCriterion("tx_money <", value, "txMoney");
            return (Criteria) this;
        }

        public Criteria andTxMoneyLessThanOrEqualTo(Float value) {
            addCriterion("tx_money <=", value, "txMoney");
            return (Criteria) this;
        }

        public Criteria andTxMoneyIn(List<Float> values) {
            addCriterion("tx_money in", values, "txMoney");
            return (Criteria) this;
        }

        public Criteria andTxMoneyNotIn(List<Float> values) {
            addCriterion("tx_money not in", values, "txMoney");
            return (Criteria) this;
        }

        public Criteria andTxMoneyBetween(Float value1, Float value2) {
            addCriterion("tx_money between", value1, value2, "txMoney");
            return (Criteria) this;
        }

        public Criteria andTxMoneyNotBetween(Float value1, Float value2) {
            addCriterion("tx_money not between", value1, value2, "txMoney");
            return (Criteria) this;
        }

        public Criteria andTxBAccountIsNull() {
            addCriterion("tx_b_account is null");
            return (Criteria) this;
        }

        public Criteria andTxBAccountIsNotNull() {
            addCriterion("tx_b_account is not null");
            return (Criteria) this;
        }

        public Criteria andTxBAccountEqualTo(String value) {
            addCriterion("tx_b_account =", value, "txBAccount");
            return (Criteria) this;
        }

        public Criteria andTxBAccountNotEqualTo(String value) {
            addCriterion("tx_b_account <>", value, "txBAccount");
            return (Criteria) this;
        }

        public Criteria andTxBAccountGreaterThan(String value) {
            addCriterion("tx_b_account >", value, "txBAccount");
            return (Criteria) this;
        }

        public Criteria andTxBAccountGreaterThanOrEqualTo(String value) {
            addCriterion("tx_b_account >=", value, "txBAccount");
            return (Criteria) this;
        }

        public Criteria andTxBAccountLessThan(String value) {
            addCriterion("tx_b_account <", value, "txBAccount");
            return (Criteria) this;
        }

        public Criteria andTxBAccountLessThanOrEqualTo(String value) {
            addCriterion("tx_b_account <=", value, "txBAccount");
            return (Criteria) this;
        }

        public Criteria andTxBAccountLike(String value) {
            addCriterion("tx_b_account like", value, "txBAccount");
            return (Criteria) this;
        }

        public Criteria andTxBAccountNotLike(String value) {
            addCriterion("tx_b_account not like", value, "txBAccount");
            return (Criteria) this;
        }

        public Criteria andTxBAccountIn(List<String> values) {
            addCriterion("tx_b_account in", values, "txBAccount");
            return (Criteria) this;
        }

        public Criteria andTxBAccountNotIn(List<String> values) {
            addCriterion("tx_b_account not in", values, "txBAccount");
            return (Criteria) this;
        }

        public Criteria andTxBAccountBetween(String value1, String value2) {
            addCriterion("tx_b_account between", value1, value2, "txBAccount");
            return (Criteria) this;
        }

        public Criteria andTxBAccountNotBetween(String value1, String value2) {
            addCriterion("tx_b_account not between", value1, value2, "txBAccount");
            return (Criteria) this;
        }

        public Criteria andTxBankIsNull() {
            addCriterion("tx_bank is null");
            return (Criteria) this;
        }

        public Criteria andTxBankIsNotNull() {
            addCriterion("tx_bank is not null");
            return (Criteria) this;
        }

        public Criteria andTxBankEqualTo(String value) {
            addCriterion("tx_bank =", value, "txBank");
            return (Criteria) this;
        }

        public Criteria andTxBankNotEqualTo(String value) {
            addCriterion("tx_bank <>", value, "txBank");
            return (Criteria) this;
        }

        public Criteria andTxBankGreaterThan(String value) {
            addCriterion("tx_bank >", value, "txBank");
            return (Criteria) this;
        }

        public Criteria andTxBankGreaterThanOrEqualTo(String value) {
            addCriterion("tx_bank >=", value, "txBank");
            return (Criteria) this;
        }

        public Criteria andTxBankLessThan(String value) {
            addCriterion("tx_bank <", value, "txBank");
            return (Criteria) this;
        }

        public Criteria andTxBankLessThanOrEqualTo(String value) {
            addCriterion("tx_bank <=", value, "txBank");
            return (Criteria) this;
        }

        public Criteria andTxBankLike(String value) {
            addCriterion("tx_bank like", value, "txBank");
            return (Criteria) this;
        }

        public Criteria andTxBankNotLike(String value) {
            addCriterion("tx_bank not like", value, "txBank");
            return (Criteria) this;
        }

        public Criteria andTxBankIn(List<String> values) {
            addCriterion("tx_bank in", values, "txBank");
            return (Criteria) this;
        }

        public Criteria andTxBankNotIn(List<String> values) {
            addCriterion("tx_bank not in", values, "txBank");
            return (Criteria) this;
        }

        public Criteria andTxBankBetween(String value1, String value2) {
            addCriterion("tx_bank between", value1, value2, "txBank");
            return (Criteria) this;
        }

        public Criteria andTxBankNotBetween(String value1, String value2) {
            addCriterion("tx_bank not between", value1, value2, "txBank");
            return (Criteria) this;
        }

        public Criteria andTxBNameIsNull() {
            addCriterion("tx_b_name is null");
            return (Criteria) this;
        }

        public Criteria andTxBNameIsNotNull() {
            addCriterion("tx_b_name is not null");
            return (Criteria) this;
        }

        public Criteria andTxBNameEqualTo(String value) {
            addCriterion("tx_b_name =", value, "txBName");
            return (Criteria) this;
        }

        public Criteria andTxBNameNotEqualTo(String value) {
            addCriterion("tx_b_name <>", value, "txBName");
            return (Criteria) this;
        }

        public Criteria andTxBNameGreaterThan(String value) {
            addCriterion("tx_b_name >", value, "txBName");
            return (Criteria) this;
        }

        public Criteria andTxBNameGreaterThanOrEqualTo(String value) {
            addCriterion("tx_b_name >=", value, "txBName");
            return (Criteria) this;
        }

        public Criteria andTxBNameLessThan(String value) {
            addCriterion("tx_b_name <", value, "txBName");
            return (Criteria) this;
        }

        public Criteria andTxBNameLessThanOrEqualTo(String value) {
            addCriterion("tx_b_name <=", value, "txBName");
            return (Criteria) this;
        }

        public Criteria andTxBNameLike(String value) {
            addCriterion("tx_b_name like", value, "txBName");
            return (Criteria) this;
        }

        public Criteria andTxBNameNotLike(String value) {
            addCriterion("tx_b_name not like", value, "txBName");
            return (Criteria) this;
        }

        public Criteria andTxBNameIn(List<String> values) {
            addCriterion("tx_b_name in", values, "txBName");
            return (Criteria) this;
        }

        public Criteria andTxBNameNotIn(List<String> values) {
            addCriterion("tx_b_name not in", values, "txBName");
            return (Criteria) this;
        }

        public Criteria andTxBNameBetween(String value1, String value2) {
            addCriterion("tx_b_name between", value1, value2, "txBName");
            return (Criteria) this;
        }

        public Criteria andTxBNameNotBetween(String value1, String value2) {
            addCriterion("tx_b_name not between", value1, value2, "txBName");
            return (Criteria) this;
        }

        public Criteria andTxRemarkIsNull() {
            addCriterion("tx_remark is null");
            return (Criteria) this;
        }

        public Criteria andTxRemarkIsNotNull() {
            addCriterion("tx_remark is not null");
            return (Criteria) this;
        }

        public Criteria andTxRemarkEqualTo(String value) {
            addCriterion("tx_remark =", value, "txRemark");
            return (Criteria) this;
        }

        public Criteria andTxRemarkNotEqualTo(String value) {
            addCriterion("tx_remark <>", value, "txRemark");
            return (Criteria) this;
        }

        public Criteria andTxRemarkGreaterThan(String value) {
            addCriterion("tx_remark >", value, "txRemark");
            return (Criteria) this;
        }

        public Criteria andTxRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("tx_remark >=", value, "txRemark");
            return (Criteria) this;
        }

        public Criteria andTxRemarkLessThan(String value) {
            addCriterion("tx_remark <", value, "txRemark");
            return (Criteria) this;
        }

        public Criteria andTxRemarkLessThanOrEqualTo(String value) {
            addCriterion("tx_remark <=", value, "txRemark");
            return (Criteria) this;
        }

        public Criteria andTxRemarkLike(String value) {
            addCriterion("tx_remark like", value, "txRemark");
            return (Criteria) this;
        }

        public Criteria andTxRemarkNotLike(String value) {
            addCriterion("tx_remark not like", value, "txRemark");
            return (Criteria) this;
        }

        public Criteria andTxRemarkIn(List<String> values) {
            addCriterion("tx_remark in", values, "txRemark");
            return (Criteria) this;
        }

        public Criteria andTxRemarkNotIn(List<String> values) {
            addCriterion("tx_remark not in", values, "txRemark");
            return (Criteria) this;
        }

        public Criteria andTxRemarkBetween(String value1, String value2) {
            addCriterion("tx_remark between", value1, value2, "txRemark");
            return (Criteria) this;
        }

        public Criteria andTxRemarkNotBetween(String value1, String value2) {
            addCriterion("tx_remark not between", value1, value2, "txRemark");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andDoDateIsNull() {
            addCriterion("do_date is null");
            return (Criteria) this;
        }

        public Criteria andDoDateIsNotNull() {
            addCriterion("do_date is not null");
            return (Criteria) this;
        }

        public Criteria andDoDateEqualTo(Date value) {
            addCriterion("do_date =", value, "doDate");
            return (Criteria) this;
        }

        public Criteria andDoDateNotEqualTo(Date value) {
            addCriterion("do_date <>", value, "doDate");
            return (Criteria) this;
        }

        public Criteria andDoDateGreaterThan(Date value) {
            addCriterion("do_date >", value, "doDate");
            return (Criteria) this;
        }

        public Criteria andDoDateGreaterThanOrEqualTo(Date value) {
            addCriterion("do_date >=", value, "doDate");
            return (Criteria) this;
        }

        public Criteria andDoDateLessThan(Date value) {
            addCriterion("do_date <", value, "doDate");
            return (Criteria) this;
        }

        public Criteria andDoDateLessThanOrEqualTo(Date value) {
            addCriterion("do_date <=", value, "doDate");
            return (Criteria) this;
        }

        public Criteria andDoDateIn(List<Date> values) {
            addCriterion("do_date in", values, "doDate");
            return (Criteria) this;
        }

        public Criteria andDoDateNotIn(List<Date> values) {
            addCriterion("do_date not in", values, "doDate");
            return (Criteria) this;
        }

        public Criteria andDoDateBetween(Date value1, Date value2) {
            addCriterion("do_date between", value1, value2, "doDate");
            return (Criteria) this;
        }

        public Criteria andDoDateNotBetween(Date value1, Date value2) {
            addCriterion("do_date not between", value1, value2, "doDate");
            return (Criteria) this;
        }

        public Criteria andDoMsgIsNull() {
            addCriterion("do_msg is null");
            return (Criteria) this;
        }

        public Criteria andDoMsgIsNotNull() {
            addCriterion("do_msg is not null");
            return (Criteria) this;
        }

        public Criteria andDoMsgEqualTo(String value) {
            addCriterion("do_msg =", value, "doMsg");
            return (Criteria) this;
        }

        public Criteria andDoMsgNotEqualTo(String value) {
            addCriterion("do_msg <>", value, "doMsg");
            return (Criteria) this;
        }

        public Criteria andDoMsgGreaterThan(String value) {
            addCriterion("do_msg >", value, "doMsg");
            return (Criteria) this;
        }

        public Criteria andDoMsgGreaterThanOrEqualTo(String value) {
            addCriterion("do_msg >=", value, "doMsg");
            return (Criteria) this;
        }

        public Criteria andDoMsgLessThan(String value) {
            addCriterion("do_msg <", value, "doMsg");
            return (Criteria) this;
        }

        public Criteria andDoMsgLessThanOrEqualTo(String value) {
            addCriterion("do_msg <=", value, "doMsg");
            return (Criteria) this;
        }

        public Criteria andDoMsgLike(String value) {
            addCriterion("do_msg like", value, "doMsg");
            return (Criteria) this;
        }

        public Criteria andDoMsgNotLike(String value) {
            addCriterion("do_msg not like", value, "doMsg");
            return (Criteria) this;
        }

        public Criteria andDoMsgIn(List<String> values) {
            addCriterion("do_msg in", values, "doMsg");
            return (Criteria) this;
        }

        public Criteria andDoMsgNotIn(List<String> values) {
            addCriterion("do_msg not in", values, "doMsg");
            return (Criteria) this;
        }

        public Criteria andDoMsgBetween(String value1, String value2) {
            addCriterion("do_msg between", value1, value2, "doMsg");
            return (Criteria) this;
        }

        public Criteria andDoMsgNotBetween(String value1, String value2) {
            addCriterion("do_msg not between", value1, value2, "doMsg");
            return (Criteria) this;
        }

        public Criteria andDoAdminIsNull() {
            addCriterion("do_admin is null");
            return (Criteria) this;
        }

        public Criteria andDoAdminIsNotNull() {
            addCriterion("do_admin is not null");
            return (Criteria) this;
        }

        public Criteria andDoAdminEqualTo(String value) {
            addCriterion("do_admin =", value, "doAdmin");
            return (Criteria) this;
        }

        public Criteria andDoAdminNotEqualTo(String value) {
            addCriterion("do_admin <>", value, "doAdmin");
            return (Criteria) this;
        }

        public Criteria andDoAdminGreaterThan(String value) {
            addCriterion("do_admin >", value, "doAdmin");
            return (Criteria) this;
        }

        public Criteria andDoAdminGreaterThanOrEqualTo(String value) {
            addCriterion("do_admin >=", value, "doAdmin");
            return (Criteria) this;
        }

        public Criteria andDoAdminLessThan(String value) {
            addCriterion("do_admin <", value, "doAdmin");
            return (Criteria) this;
        }

        public Criteria andDoAdminLessThanOrEqualTo(String value) {
            addCriterion("do_admin <=", value, "doAdmin");
            return (Criteria) this;
        }

        public Criteria andDoAdminLike(String value) {
            addCriterion("do_admin like", value, "doAdmin");
            return (Criteria) this;
        }

        public Criteria andDoAdminNotLike(String value) {
            addCriterion("do_admin not like", value, "doAdmin");
            return (Criteria) this;
        }

        public Criteria andDoAdminIn(List<String> values) {
            addCriterion("do_admin in", values, "doAdmin");
            return (Criteria) this;
        }

        public Criteria andDoAdminNotIn(List<String> values) {
            addCriterion("do_admin not in", values, "doAdmin");
            return (Criteria) this;
        }

        public Criteria andDoAdminBetween(String value1, String value2) {
            addCriterion("do_admin between", value1, value2, "doAdmin");
            return (Criteria) this;
        }

        public Criteria andDoAdminNotBetween(String value1, String value2) {
            addCriterion("do_admin not between", value1, value2, "doAdmin");
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
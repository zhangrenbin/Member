package com.ice.sh1.po;

import java.util.Date;

import com.inspur.guarder.pojo.ExtendProp;

public class WithDraw extends ExtendProp{
    private Integer id;

    private Integer membId;

    private Date txDate;

    private Float txMoney;

    private String txBAccount;

    private String txBank;

    private String txBName;

    private String txRemark;

    private Integer state;

    private Date doDate;

    private String doMsg;

    private String doAdmin;
    
    private String membAccount;
    
    private String membName;

    public String getMembAccount() {
		return membAccount;
	}

	public void setMembAccount(String membAccount) {
		this.membAccount = membAccount;
	}

	public String getMembName() {
		return membName;
	}

	public void setMembName(String membName) {
		this.membName = membName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMembId() {
        return membId;
    }

    public void setMembId(Integer membId) {
        this.membId = membId;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    public Float getTxMoney() {
        return txMoney;
    }

    public void setTxMoney(Float txMoney) {
        this.txMoney = txMoney;
    }

    public String getTxBAccount() {
        return txBAccount;
    }

    public void setTxBAccount(String txBAccount) {
        this.txBAccount = txBAccount == null ? null : txBAccount.trim();
    }

    public String getTxBank() {
        return txBank;
    }

    public void setTxBank(String txBank) {
        this.txBank = txBank == null ? null : txBank.trim();
    }

    public String getTxBName() {
        return txBName;
    }

    public void setTxBName(String txBName) {
        this.txBName = txBName == null ? null : txBName.trim();
    }

    public String getTxRemark() {
        return txRemark;
    }

    public void setTxRemark(String txRemark) {
        this.txRemark = txRemark == null ? null : txRemark.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getDoDate() {
        return doDate;
    }

    public void setDoDate(Date doDate) {
        this.doDate = doDate;
    }

    public String getDoMsg() {
        return doMsg;
    }

    public void setDoMsg(String doMsg) {
        this.doMsg = doMsg == null ? null : doMsg.trim();
    }

    public String getDoAdmin() {
        return doAdmin;
    }

    public void setDoAdmin(String doAdmin) {
        this.doAdmin = doAdmin == null ? null : doAdmin.trim();
    }
}
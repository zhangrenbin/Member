package com.ice.sh1.po;

import java.util.Date;

public class BonusRecord {
    private Integer id;

    private Integer rMember;

    private Float rMoney;

    private String rPoint;

    private Date rTime;

    private Integer rAddup;

    private Integer rRule;

    private String rDesc;
    
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

    public Integer getrMember() {
        return rMember;
    }

    public void setrMember(Integer rMember) {
        this.rMember = rMember;
    }

    public Float getrMoney() {
        return rMoney;
    }

    public void setrMoney(Float rMoney) {
        this.rMoney = rMoney;
    }

    public String getrPoint() {
        return rPoint;
    }

    public void setrPoint(String rPoint) {
        this.rPoint = rPoint == null ? null : rPoint.trim();
    }

    public Date getrTime() {
        return rTime;
    }

    public void setrTime(Date rTime) {
        this.rTime = rTime;
    }

    public Integer getrAddup() {
        return rAddup;
    }

    public void setrAddup(Integer rAddup) {
        this.rAddup = rAddup;
    }

    public Integer getrRule() {
        return rRule;
    }

    public void setrRule(Integer rRule) {
        this.rRule = rRule;
    }

    public String getrDesc() {
        return rDesc;
    }

    public void setrDesc(String rDesc) {
        this.rDesc = rDesc == null ? null : rDesc.trim();
    }
}
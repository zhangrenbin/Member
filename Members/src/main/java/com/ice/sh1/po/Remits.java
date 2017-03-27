package com.ice.sh1.po;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.inspur.guarder.pojo.ExtendProp;

public class Remits extends ExtendProp {
    private Integer id;

    private Integer rFromUser;

    private String rProxyName;

    private Float rMoney;

    private String rBAccount;

    private String rBName;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date rTime;

    private String rRemark;

    private Integer rState;

    private Date rSubDate;

    private String rAdmin;
    
    private Integer rBdmemb;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getrFromUser() {
        return rFromUser;
    }

    public void setrFromUser(Integer rFromUser) {
        this.rFromUser = rFromUser;
    }

    public String getrProxyName() {
        return rProxyName;
    }

    public void setrProxyName(String rProxyName) {
        this.rProxyName = rProxyName == null ? null : rProxyName.trim();
    }

    public Float getrMoney() {
        return rMoney;
    }

    public void setrMoney(Float rMoney) {
        this.rMoney = rMoney;
    }

    public String getrBAccount() {
        return rBAccount;
    }

    public void setrBAccount(String rBAccount) {
        this.rBAccount = rBAccount == null ? null : rBAccount.trim();
    }

    public String getrBName() {
        return rBName;
    }

    public void setrBName(String rBName) {
        this.rBName = rBName == null ? null : rBName.trim();
    }

    public Date getrTime() {
        return rTime;
    }

    public void setrTime(Date rTime) {
        this.rTime = rTime;
    }

    public String getrRemark() {
        return rRemark;
    }

    public void setrRemark(String rRemark) {
        this.rRemark = rRemark == null ? null : rRemark.trim();
    }

    public Integer getrState() {
        return rState;
    }

    public void setrState(Integer rState) {
        this.rState = rState;
    }

    public Date getrSubDate() {
        return rSubDate;
    }

    public void setrSubDate(Date rSubDate) {
        this.rSubDate = rSubDate;
    }

    public String getrAdmin() {
        return rAdmin;
    }

    public void setrAdmin(String rAdmin) {
        this.rAdmin = rAdmin == null ? null : rAdmin.trim();
    }

	public Integer getrBdmemb() {
		return rBdmemb;
	}

	public void setrBdmemb(Integer rBdmemb) {
		this.rBdmemb = rBdmemb;
	}
    
}
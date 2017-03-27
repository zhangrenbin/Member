package com.ice.sh1.po;

import java.util.Date;

import com.inspur.guarder.pojo.ExtendProp;

public class Member extends ExtendProp {
    private Integer id;

    private String mAccount;

    private String mCnname;

    private String mIdnum;

    private String mMobile;

    private String mPassword;

    private String mPassword2;

    private Integer level;

    private String mAddr;

    private Integer mProvince;

    private Integer mCity;

    private String mBank;

    private String mBAccount;

    private String mBName;

    private Integer mRecommder;

    private Date mRegdate;

    private Date mActivedate;

    private Float mBalance;

    private Float mTotal;
    
    private Integer mActive;
    
    private String mRecommderName;

	public String getmRecommderName() {
		return mRecommderName;
	}

	public void setmRecommderName(String mRecommderName) {
		this.mRecommderName = mRecommderName;
	}

	public Integer getmActive() {
		return mActive;
	}

	public void setmActive(Integer mActive) {
		this.mActive = mActive;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getmAccount() {
        return mAccount;
    }

    public void setmAccount(String mAccount) {
        this.mAccount = mAccount == null ? null : mAccount.trim();
    }

    public String getmCnname() {
        return mCnname;
    }

    public void setmCnname(String mCnname) {
        this.mCnname = mCnname == null ? null : mCnname.trim();
    }

    public String getmIdnum() {
        return mIdnum;
    }

    public void setmIdnum(String mIdnum) {
        this.mIdnum = mIdnum == null ? null : mIdnum.trim();
    }

    public String getmMobile() {
        return mMobile;
    }

    public void setmMobile(String mMobile) {
        this.mMobile = mMobile == null ? null : mMobile.trim();
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword == null ? null : mPassword.trim();
    }

    public String getmPassword2() {
        return mPassword2;
    }

    public void setmPassword2(String mPassword2) {
        this.mPassword2 = mPassword2 == null ? null : mPassword2.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getmAddr() {
        return mAddr;
    }

    public void setmAddr(String mAddr) {
        this.mAddr = mAddr == null ? null : mAddr.trim();
    }

    public Integer getmProvince() {
        return mProvince;
    }

    public void setmProvince(Integer mProvince) {
        this.mProvince = mProvince;
    }

    public Integer getmCity() {
        return mCity;
    }

    public void setmCity(Integer mCity) {
        this.mCity = mCity;
    }

    public String getmBank() {
        return mBank;
    }

    public void setmBank(String mBank) {
        this.mBank = mBank == null ? null : mBank.trim();
    }

    public String getmBAccount() {
        return mBAccount;
    }

    public void setmBAccount(String mBAccount) {
        this.mBAccount = mBAccount == null ? null : mBAccount.trim();
    }

    public String getmBName() {
        return mBName;
    }

    public void setmBName(String mBName) {
        this.mBName = mBName == null ? null : mBName.trim();
    }

    public Integer getmRecommder() {
        return mRecommder;
    }

    public void setmRecommder(Integer mRecommder) {
        this.mRecommder = mRecommder;
    }

    public Date getmRegdate() {
        return mRegdate;
    }

    public void setmRegdate(Date mRegdate) {
        this.mRegdate = mRegdate;
    }

    public Date getmActivedate() {
        return mActivedate;
    }

    public void setmActivedate(Date mActivedate) {
        this.mActivedate = mActivedate;
    }

    public Float getmBalance() {
        return mBalance;
    }

    public void setmBalance(Float mBalance) {
        this.mBalance = mBalance;
    }

    public Float getmTotal() {
        return mTotal;
    }

    public void setmTotal(Float mTotal) {
        this.mTotal = mTotal;
    }
}
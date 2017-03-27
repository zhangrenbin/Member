package com.ice.sh1.po;

import java.util.Date;

import com.inspur.guarder.pojo.ExtendProp;

public class BdCenter extends ExtendProp {
    private Integer id;

    private Integer mId;

    private Date bDate;

    private Integer bState;

    private Date bApproveDate;

    private String bAdmin;

    private String bRemark;
    
    private String mAccount;
    
    private String mCnname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Date getbDate() {
        return bDate;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    public Integer getbState() {
        return bState;
    }

    public void setbState(Integer bState) {
        this.bState = bState;
    }

    public Date getbApproveDate() {
        return bApproveDate;
    }

    public void setbApproveDate(Date bApproveDate) {
        this.bApproveDate = bApproveDate;
    }

    public String getbAdmin() {
        return bAdmin;
    }

    public void setbAdmin(String bAdmin) {
        this.bAdmin = bAdmin == null ? null : bAdmin.trim();
    }

    public String getbRemark() {
        return bRemark;
    }

    public void setbRemark(String bRemark) {
        this.bRemark = bRemark == null ? null : bRemark.trim();
    }

	public String getmAccount() {
		return mAccount;
	}

	public void setmAccount(String mAccount) {
		this.mAccount = mAccount;
	}

	public String getmCnname() {
		return mCnname;
	}

	public void setmCnname(String mCnname) {
		this.mCnname = mCnname;
	}
    
    
}
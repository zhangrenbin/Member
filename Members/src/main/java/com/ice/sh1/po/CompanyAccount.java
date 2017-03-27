package com.ice.sh1.po;

public class CompanyAccount {
    private Integer id;

    private String bAccount;

    private String bName;

    private String bBank;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getbAccount() {
        return bAccount;
    }

    public void setbAccount(String bAccount) {
        this.bAccount = bAccount == null ? null : bAccount.trim();
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName == null ? null : bName.trim();
    }

    public String getbBank() {
        return bBank;
    }

    public void setbBank(String bBank) {
        this.bBank = bBank == null ? null : bBank.trim();
    }
}
package com.ice.sh1.po;

import com.ice.rule.BonusComputer;

public class BonusRule {
    private Integer id;

    private String rName;

    private String rDesc;

    private Integer rEnable;

    private String rClass;

    private Float rBonus;
    
    private BonusComputer computer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }

    public String getrDesc() {
        return rDesc;
    }

    public void setrDesc(String rDesc) {
        this.rDesc = rDesc == null ? null : rDesc.trim();
    }

    public Integer getrEnable() {
        return rEnable;
    }

    public void setrEnable(Integer rEnable) {
        this.rEnable = rEnable;
    }

    public String getrClass() {
        return rClass;
    }

    public void setrClass(String rClass) {
        this.rClass = rClass == null ? null : rClass.trim();
    }

    public Float getrBonus() {
        return rBonus;
    }

    public void setrBonus(Float rBonus) {
        this.rBonus = rBonus;
    }

	public BonusComputer getComputer() {
		return computer;
	}

	public void setComputer(BonusComputer computer) {
		this.computer = computer;
	}
}
package com.ice.sh1.po;

public class DictProvince {
    private Integer nProvid;

    private String sProvname;

    private String sType;

    private String sState;

    public Integer getnProvid() {
        return nProvid;
    }

    public void setnProvid(Integer nProvid) {
        this.nProvid = nProvid;
    }

    public String getsProvname() {
        return sProvname;
    }

    public void setsProvname(String sProvname) {
        this.sProvname = sProvname == null ? null : sProvname.trim();
    }

    public String getsType() {
        return sType;
    }

    public void setsType(String sType) {
        this.sType = sType == null ? null : sType.trim();
    }

    public String getsState() {
        return sState;
    }

    public void setsState(String sState) {
        this.sState = sState == null ? null : sState.trim();
    }
}
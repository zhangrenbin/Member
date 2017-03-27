package com.ice.sh1.po;

public class DictCity {
    private Integer nCityid;

    private String sCityname;

    private Integer nProvid;

    private String sState;

    public Integer getnCityid() {
        return nCityid;
    }

    public void setnCityid(Integer nCityid) {
        this.nCityid = nCityid;
    }

    public String getsCityname() {
        return sCityname;
    }

    public void setsCityname(String sCityname) {
        this.sCityname = sCityname == null ? null : sCityname.trim();
    }

    public Integer getnProvid() {
        return nProvid;
    }

    public void setnProvid(Integer nProvid) {
        this.nProvid = nProvid;
    }

    public String getsState() {
        return sState;
    }

    public void setsState(String sState) {
        this.sState = sState == null ? null : sState.trim();
    }
}
package com.sc.crmsys.bean;

import java.util.Date;

public class PermissionSubfieldBean {
    private String subfieldNumber;

    private String subfieldName;

    private String subfieldRemarks;

    private Date subfieldLastTime;

    public String getSubfieldNumber() {
        return subfieldNumber;
    }

    public void setSubfieldNumber(String subfieldNumber) {
        this.subfieldNumber = subfieldNumber == null ? null : subfieldNumber.trim();
    }

    public String getSubfieldName() {
        return subfieldName;
    }

    public void setSubfieldName(String subfieldName) {
        this.subfieldName = subfieldName == null ? null : subfieldName.trim();
    }

    public String getSubfieldRemarks() {
        return subfieldRemarks;
    }

    public void setSubfieldRemarks(String subfieldRemarks) {
        this.subfieldRemarks = subfieldRemarks == null ? null : subfieldRemarks.trim();
    }

    public Date getSubfieldLastTime() {
        return subfieldLastTime;
    }

    public void setSubfieldLastTime(Date subfieldLastTime) {
        this.subfieldLastTime = subfieldLastTime;
    }
}
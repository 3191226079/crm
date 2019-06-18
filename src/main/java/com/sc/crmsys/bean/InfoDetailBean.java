package com.sc.crmsys.bean;

import java.util.Date;

public class InfoDetailBean {
    private String infoDetailId;

    private String infoId;

    private String employId;

    private String infoDetailState;

    private String companyId;

    private Date infoDetailUpdateTime;

    public String getInfoDetailId() {
        return infoDetailId;
    }

    public void setInfoDetailId(String infoDetailId) {
        this.infoDetailId = infoDetailId == null ? null : infoDetailId.trim();
    }

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId == null ? null : infoId.trim();
    }

    public String getEmployId() {
        return employId;
    }

    public void setEmployId(String employId) {
        this.employId = employId == null ? null : employId.trim();
    }

    public String getInfoDetailState() {
        return infoDetailState;
    }

    public void setInfoDetailState(String infoDetailState) {
        this.infoDetailState = infoDetailState == null ? null : infoDetailState.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public Date getInfoDetailUpdateTime() {
        return infoDetailUpdateTime;
    }

    public void setInfoDetailUpdateTime(Date infoDetailUpdateTime) {
        this.infoDetailUpdateTime = infoDetailUpdateTime;
    }
}
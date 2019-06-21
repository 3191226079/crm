package com.sc.crmsys.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ActiveBean {
    private String activeId;

    private String activeType;

    private String activeTitle;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date activeStartTime;

    private String acitveDescribe;

    private String companyId;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date activeUpdateTime;
    

	public String getActiveId() {
        return activeId;
    }

    public void setActiveId(String activeId) {
        this.activeId = activeId == null ? null : activeId.trim();
    }

    public String getActiveType() {
        return activeType;
    }

    public void setActiveType(String activeType) {
        this.activeType = activeType == null ? null : activeType.trim();
    }

    public String getActiveTitle() {
        return activeTitle;
    }

    public void setActiveTitle(String activeTitle) {
        this.activeTitle = activeTitle == null ? null : activeTitle.trim();
    }

    public Date getActiveStartTime() {
        return activeStartTime;
    }

    public void setActiveStartTime(Date activeStartTime) {
        this.activeStartTime = activeStartTime;
    }

    public String getAcitveDescribe() {
        return acitveDescribe;
    }

    public void setAcitveDescribe(String acitveDescribe) {
        this.acitveDescribe = acitveDescribe == null ? null : acitveDescribe.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public Date getActiveUpdateTime() {
        return activeUpdateTime;
    }

    public void setActiveUpdateTime(Date activeUpdateTime) {
        this.activeUpdateTime = activeUpdateTime;
    }
}
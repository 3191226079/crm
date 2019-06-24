package com.sc.crmsys.bean;

import java.util.Date;

public class InfoBean {
    private String infoId;

    private String infoTitle;

    private String infoContent;

    private String infoPerson;

    private String companyId;

    private Date infoUpdateTime;
    
	public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId == null ? null : infoId.trim();
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle == null ? null : infoTitle.trim();
    }

    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent == null ? null : infoContent.trim();
    }

    public String getInfoPerson() {
        return infoPerson;
    }

    public void setInfoPerson(String infoPerson) {
        this.infoPerson = infoPerson == null ? null : infoPerson.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public Date getInfoUpdateTime() {
        return infoUpdateTime;
    }

    public void setInfoUpdateTime(Date infoUpdateTime) {
        this.infoUpdateTime = infoUpdateTime;
    }
}
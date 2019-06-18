package com.sc.crmsys.bean;

import java.util.Date;

public class ContactLogsBean {
    private String contactLogsId;

    private String contactLogsTitle;

    private Date contactLogsTime;

    private String customerId;

    private String contactLogsContent;

    private String companyId;

    private Date contactLogsLastTime;

    public String getContactLogsId() {
        return contactLogsId;
    }

    public void setContactLogsId(String contactLogsId) {
        this.contactLogsId = contactLogsId == null ? null : contactLogsId.trim();
    }

    public String getContactLogsTitle() {
        return contactLogsTitle;
    }

    public void setContactLogsTitle(String contactLogsTitle) {
        this.contactLogsTitle = contactLogsTitle == null ? null : contactLogsTitle.trim();
    }

    public Date getContactLogsTime() {
        return contactLogsTime;
    }

    public void setContactLogsTime(Date contactLogsTime) {
        this.contactLogsTime = contactLogsTime;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getContactLogsContent() {
        return contactLogsContent;
    }

    public void setContactLogsContent(String contactLogsContent) {
        this.contactLogsContent = contactLogsContent == null ? null : contactLogsContent.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public Date getContactLogsLastTime() {
        return contactLogsLastTime;
    }

    public void setContactLogsLastTime(Date contactLogsLastTime) {
        this.contactLogsLastTime = contactLogsLastTime;
    }
}
package com.sc.crmsys.bean;

import java.util.Date;

public class ContactsBean {
    private String contactsId;

    private String customerId;

    private String companyId;

    private String contactsName;

    private String contactsPost;

    private String contactsDepartment;

    private String contactsPhone;

    private String contactsOficePhone;

    private String contactsEmail;

    private String contactsAddress;

    private String contactsRemarks;

    private Date contactsTime;

    public String getContactsId() {
        return contactsId;
    }

    public void setContactsId(String contactsId) {
        this.contactsId = contactsId == null ? null : contactsId.trim();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName == null ? null : contactsName.trim();
    }

    public String getContactsPost() {
        return contactsPost;
    }

    public void setContactsPost(String contactsPost) {
        this.contactsPost = contactsPost == null ? null : contactsPost.trim();
    }

    public String getContactsDepartment() {
        return contactsDepartment;
    }

    public void setContactsDepartment(String contactsDepartment) {
        this.contactsDepartment = contactsDepartment == null ? null : contactsDepartment.trim();
    }

    public String getContactsPhone() {
        return contactsPhone;
    }

    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone == null ? null : contactsPhone.trim();
    }

    public String getContactsOficePhone() {
        return contactsOficePhone;
    }

    public void setContactsOficePhone(String contactsOficePhone) {
        this.contactsOficePhone = contactsOficePhone == null ? null : contactsOficePhone.trim();
    }

    public String getContactsEmail() {
        return contactsEmail;
    }

    public void setContactsEmail(String contactsEmail) {
        this.contactsEmail = contactsEmail == null ? null : contactsEmail.trim();
    }

    public String getContactsAddress() {
        return contactsAddress;
    }

    public void setContactsAddress(String contactsAddress) {
        this.contactsAddress = contactsAddress == null ? null : contactsAddress.trim();
    }

    public String getContactsRemarks() {
        return contactsRemarks;
    }

    public void setContactsRemarks(String contactsRemarks) {
        this.contactsRemarks = contactsRemarks == null ? null : contactsRemarks.trim();
    }

    public Date getContactsTime() {
        return contactsTime;
    }

    public void setContactsTime(Date contactsTime) {
        this.contactsTime = contactsTime;
    }
}
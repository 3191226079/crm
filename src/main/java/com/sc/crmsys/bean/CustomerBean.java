package com.sc.crmsys.bean;

import java.util.Date;

public class CustomerBean {
    private String customerId;

    private String customerName;

    private String customerUpDepartment;

    private String customerContactPerson;

    private String customerState;

    private String customerAddress;

    private String customerPhone;

    private String customerFax;

    private String customerEmail;

    private Date customerContactTime;

    private String customerInfo;

    private String companyId;

    private Date customerUpdateTime;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getCustomerUpDepartment() {
        return customerUpDepartment;
    }

    public void setCustomerUpDepartment(String customerUpDepartment) {
        this.customerUpDepartment = customerUpDepartment == null ? null : customerUpDepartment.trim();
    }

    public String getCustomerContactPerson() {
        return customerContactPerson;
    }

    public void setCustomerContactPerson(String customerContactPerson) {
        this.customerContactPerson = customerContactPerson == null ? null : customerContactPerson.trim();
    }

    public String getCustomerState() {
        return customerState;
    }

    public void setCustomerState(String customerState) {
        this.customerState = customerState == null ? null : customerState.trim();
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress == null ? null : customerAddress.trim();
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone == null ? null : customerPhone.trim();
    }

    public String getCustomerFax() {
        return customerFax;
    }

    public void setCustomerFax(String customerFax) {
        this.customerFax = customerFax == null ? null : customerFax.trim();
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail == null ? null : customerEmail.trim();
    }

    public Date getCustomerContactTime() {
        return customerContactTime;
    }

    public void setCustomerContactTime(Date customerContactTime) {
        this.customerContactTime = customerContactTime;
    }

    public String getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(String customerInfo) {
        this.customerInfo = customerInfo == null ? null : customerInfo.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public Date getCustomerUpdateTime() {
        return customerUpdateTime;
    }

    public void setCustomerUpdateTime(Date customerUpdateTime) {
        this.customerUpdateTime = customerUpdateTime;
    }
}
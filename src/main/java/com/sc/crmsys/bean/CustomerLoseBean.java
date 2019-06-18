package com.sc.crmsys.bean;

import java.util.Date;

public class CustomerLoseBean {
    private String customerLoseId;

    private String customerId;

    private String customerLoseOperation;

    private String customerLosePromethods;

    private String customerLoseSate;

    private String companyId;

    private Date customerLoseLastTime;

    public String getCustomerLoseId() {
        return customerLoseId;
    }

    public void setCustomerLoseId(String customerLoseId) {
        this.customerLoseId = customerLoseId == null ? null : customerLoseId.trim();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getCustomerLoseOperation() {
        return customerLoseOperation;
    }

    public void setCustomerLoseOperation(String customerLoseOperation) {
        this.customerLoseOperation = customerLoseOperation == null ? null : customerLoseOperation.trim();
    }

    public String getCustomerLosePromethods() {
        return customerLosePromethods;
    }

    public void setCustomerLosePromethods(String customerLosePromethods) {
        this.customerLosePromethods = customerLosePromethods == null ? null : customerLosePromethods.trim();
    }

    public String getCustomerLoseSate() {
        return customerLoseSate;
    }

    public void setCustomerLoseSate(String customerLoseSate) {
        this.customerLoseSate = customerLoseSate == null ? null : customerLoseSate.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public Date getCustomerLoseLastTime() {
        return customerLoseLastTime;
    }

    public void setCustomerLoseLastTime(Date customerLoseLastTime) {
        this.customerLoseLastTime = customerLoseLastTime;
    }
}
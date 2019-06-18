package com.sc.crmsys.bean;

import java.util.Date;

public class OrderPurchaseBean {
    private String orderPurchaseId;

    private String orderPurchaseTitle;

    private Date orderPurchaseTime;

    private String supplierId;

    private String orderPurchaseMoney;

    private String orderPurchaseNumber;

    private String orderPurchaseState;

    private Date orderPurchaseBusinessTime;

    private String orderPurchaseBusinessAddress;

    private String orderPurchaseBusinessType;

    private String orderPurchasePerson;

    private String orderPurchaseInfo;

    private String companyId;

    private Date orderPurchaseUpdateTime;

    public String getOrderPurchaseId() {
        return orderPurchaseId;
    }

    public void setOrderPurchaseId(String orderPurchaseId) {
        this.orderPurchaseId = orderPurchaseId == null ? null : orderPurchaseId.trim();
    }

    public String getOrderPurchaseTitle() {
        return orderPurchaseTitle;
    }

    public void setOrderPurchaseTitle(String orderPurchaseTitle) {
        this.orderPurchaseTitle = orderPurchaseTitle == null ? null : orderPurchaseTitle.trim();
    }

    public Date getOrderPurchaseTime() {
        return orderPurchaseTime;
    }

    public void setOrderPurchaseTime(Date orderPurchaseTime) {
        this.orderPurchaseTime = orderPurchaseTime;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId == null ? null : supplierId.trim();
    }

    public String getOrderPurchaseMoney() {
        return orderPurchaseMoney;
    }

    public void setOrderPurchaseMoney(String orderPurchaseMoney) {
        this.orderPurchaseMoney = orderPurchaseMoney == null ? null : orderPurchaseMoney.trim();
    }

    public String getOrderPurchaseNumber() {
        return orderPurchaseNumber;
    }

    public void setOrderPurchaseNumber(String orderPurchaseNumber) {
        this.orderPurchaseNumber = orderPurchaseNumber == null ? null : orderPurchaseNumber.trim();
    }

    public String getOrderPurchaseState() {
        return orderPurchaseState;
    }

    public void setOrderPurchaseState(String orderPurchaseState) {
        this.orderPurchaseState = orderPurchaseState == null ? null : orderPurchaseState.trim();
    }

    public Date getOrderPurchaseBusinessTime() {
        return orderPurchaseBusinessTime;
    }

    public void setOrderPurchaseBusinessTime(Date orderPurchaseBusinessTime) {
        this.orderPurchaseBusinessTime = orderPurchaseBusinessTime;
    }

    public String getOrderPurchaseBusinessAddress() {
        return orderPurchaseBusinessAddress;
    }

    public void setOrderPurchaseBusinessAddress(String orderPurchaseBusinessAddress) {
        this.orderPurchaseBusinessAddress = orderPurchaseBusinessAddress == null ? null : orderPurchaseBusinessAddress.trim();
    }

    public String getOrderPurchaseBusinessType() {
        return orderPurchaseBusinessType;
    }

    public void setOrderPurchaseBusinessType(String orderPurchaseBusinessType) {
        this.orderPurchaseBusinessType = orderPurchaseBusinessType == null ? null : orderPurchaseBusinessType.trim();
    }

    public String getOrderPurchasePerson() {
        return orderPurchasePerson;
    }

    public void setOrderPurchasePerson(String orderPurchasePerson) {
        this.orderPurchasePerson = orderPurchasePerson == null ? null : orderPurchasePerson.trim();
    }

    public String getOrderPurchaseInfo() {
        return orderPurchaseInfo;
    }

    public void setOrderPurchaseInfo(String orderPurchaseInfo) {
        this.orderPurchaseInfo = orderPurchaseInfo == null ? null : orderPurchaseInfo.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public Date getOrderPurchaseUpdateTime() {
        return orderPurchaseUpdateTime;
    }

    public void setOrderPurchaseUpdateTime(Date orderPurchaseUpdateTime) {
        this.orderPurchaseUpdateTime = orderPurchaseUpdateTime;
    }
}
package com.sc.crmsys.bean;

import java.util.Date;

public class SaleOutBean {
    private String saleoutId;

    private String customerId;

    private String companyId;

    private Date saleoutTime;

    private String saleoutInvoce;

    private String saleoutPrice;

    private String saleoutState;

    private String saleState;

    private String saleoutRemarks;

    private Date saleoutLastTime;

    public String getSaleoutId() {
        return saleoutId;
    }

    public void setSaleoutId(String saleoutId) {
        this.saleoutId = saleoutId == null ? null : saleoutId.trim();
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

    public Date getSaleoutTime() {
        return saleoutTime;
    }

    public void setSaleoutTime(Date saleoutTime) {
        this.saleoutTime = saleoutTime;
    }

    public String getSaleoutInvoce() {
        return saleoutInvoce;
    }

    public void setSaleoutInvoce(String saleoutInvoce) {
        this.saleoutInvoce = saleoutInvoce == null ? null : saleoutInvoce.trim();
    }

    public String getSaleoutPrice() {
        return saleoutPrice;
    }

    public void setSaleoutPrice(String saleoutPrice) {
        this.saleoutPrice = saleoutPrice == null ? null : saleoutPrice.trim();
    }

    public String getSaleoutState() {
        return saleoutState;
    }

    public void setSaleoutState(String saleoutState) {
        this.saleoutState = saleoutState == null ? null : saleoutState.trim();
    }

    public String getSaleState() {
        return saleState;
    }

    public void setSaleState(String saleState) {
        this.saleState = saleState == null ? null : saleState.trim();
    }

    public String getSaleoutRemarks() {
        return saleoutRemarks;
    }

    public void setSaleoutRemarks(String saleoutRemarks) {
        this.saleoutRemarks = saleoutRemarks == null ? null : saleoutRemarks.trim();
    }

    public Date getSaleoutLastTime() {
        return saleoutLastTime;
    }

    public void setSaleoutLastTime(Date saleoutLastTime) {
        this.saleoutLastTime = saleoutLastTime;
    }
}
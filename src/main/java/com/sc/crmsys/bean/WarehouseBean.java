package com.sc.crmsys.bean;

import java.util.Date;

public class WarehouseBean {
    private String warehouseNumber;

    private String warehouseName;

    private String warehouseInfo;

    private String companyId;

    private Date warehouseLastTime;

    public String getWarehouseNumber() {
        return warehouseNumber;
    }

    public void setWarehouseNumber(String warehouseNumber) {
        this.warehouseNumber = warehouseNumber == null ? null : warehouseNumber.trim();
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName == null ? null : warehouseName.trim();
    }

    public String getWarehouseInfo() {
        return warehouseInfo;
    }

    public void setWarehouseInfo(String warehouseInfo) {
        this.warehouseInfo = warehouseInfo == null ? null : warehouseInfo.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public Date getWarehouseLastTime() {
        return warehouseLastTime;
    }

    public void setWarehouseLastTime(Date warehouseLastTime) {
        this.warehouseLastTime = warehouseLastTime;
    }
}
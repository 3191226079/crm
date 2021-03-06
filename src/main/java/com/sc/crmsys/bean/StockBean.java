package com.sc.crmsys.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class StockBean {
    private String commodityNumber;

    private String commodityName;

    private String commodityType;

    private String description;

    private String unit;

    private String warehouseNumber;

    private String stockNumber;

    private String costPrice;

    private String retailPrice;

    private String salePrice;

    private String postscript;

    private String companyId;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date stockLastTime;
    
    private WarehouseBean warehouseBean;
    
    public WarehouseBean getWarehouseBean() {
		return warehouseBean;
	}

	public void setWarehouseBean(WarehouseBean warehouseBean) {
		this.warehouseBean = warehouseBean;
	}


	public String getCommodityNumber() {
        return commodityNumber;
    }

    public void setCommodityNumber(String commodityNumber) {
        this.commodityNumber = commodityNumber == null ? null : commodityNumber.trim();
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName == null ? null : commodityName.trim();
    }

    public String getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(String commodityType) {
        this.commodityType = commodityType == null ? null : commodityType.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getWarehouseNumber() {
        return warehouseNumber;
    }

    public void setWarehouseNumber(String warehouseNumber) {
        this.warehouseNumber = warehouseNumber == null ? null : warehouseNumber.trim();
    }

    public String getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber == null ? null : stockNumber.trim();
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice == null ? null : costPrice.trim();
    }

    public String getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(String retailPrice) {
        this.retailPrice = retailPrice == null ? null : retailPrice.trim();
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice == null ? null : salePrice.trim();
    }

    public String getPostscript() {
        return postscript;
    }

    public void setPostscript(String postscript) {
        this.postscript = postscript == null ? null : postscript.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public Date getStockLastTime() {
        return stockLastTime;
    }

    public void setStockLastTime(Date stockLastTime) {
        this.stockLastTime = stockLastTime;
    }

	@Override
	public String toString() {
		return "StockBean [commodityNumber=" + commodityNumber + ", commodityName=" + commodityName + ", commodityType="
				+ commodityType + ", description=" + description + ", unit=" + unit + ", warehouseNumber="
				+ warehouseNumber + ", stockNumber=" + stockNumber + ", costPrice=" + costPrice + ", retailPrice="
				+ retailPrice + ", salePrice=" + salePrice + ", postscript=" + postscript + ", companyId=" + companyId
				+ ", stockLastTime=" + stockLastTime + ", warehouseBean=" + warehouseBean + "]";
	}
    
}
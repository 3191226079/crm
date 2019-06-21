package com.sc.crmsys.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class PurchaseBean {
    private String purchaseId;

    private String productId;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date purchaseTime;

    private String purchaseState;

    private String purchasePerson;

    private String purchaseInfo;

    private String companyId;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date purchaseUpdateTime;
    
    private WarehouseBean warehouseBean;
    
    private StockBean stockBean;
    
    private DetailPurchaseBean detailPurchaseBean;
    
    

    public DetailPurchaseBean getDetailPurchaseBean() {
		return detailPurchaseBean;
	}

	public void setDetailPurchaseBean(DetailPurchaseBean detailPurchaseBean) {
		this.detailPurchaseBean = detailPurchaseBean;
	}

	public WarehouseBean getWarehouseBean() {
		return warehouseBean;
	}

	public void setWarehouseBean(WarehouseBean warehouseBean) {
		this.warehouseBean = warehouseBean;
	}

	public StockBean getStockBean() {
		return stockBean;
	}

	public void setStockBean(StockBean stockBean) {
		this.stockBean = stockBean;
	}

	public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId == null ? null : purchaseId.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public String getPurchaseState() {
        return purchaseState;
    }

    public void setPurchaseState(String purchaseState) {
        this.purchaseState = purchaseState == null ? null : purchaseState.trim();
    }

    public String getPurchasePerson() {
        return purchasePerson;
    }

    public void setPurchasePerson(String purchasePerson) {
        this.purchasePerson = purchasePerson == null ? null : purchasePerson.trim();
    }

    public String getPurchaseInfo() {
        return purchaseInfo;
    }

    public void setPurchaseInfo(String purchaseInfo) {
        this.purchaseInfo = purchaseInfo == null ? null : purchaseInfo.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public Date getPurchaseUpdateTime() {
        return purchaseUpdateTime;
    }

    public void setPurchaseUpdateTime(Date purchaseUpdateTime) {
        this.purchaseUpdateTime = purchaseUpdateTime;
    }
}
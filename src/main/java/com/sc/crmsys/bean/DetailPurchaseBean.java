package com.sc.crmsys.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DetailPurchaseBean {
    private String detailPurchaseId;

    private String orderPurchaseId;

    private String productId;

    private String productNum;

    private String productPrice;

    private String detailPurchaseState;

    private String detailPurchasePerson;

    private String detailPurchaseInfo;

    private String companyId;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date detailPurchaseUpdateTime;
    
    private OrderPurchaseBean orderPurchaseBean; 

    public OrderPurchaseBean getOrderPurchaseBean() {
		return orderPurchaseBean;
	}

	public void setOrderPurchaseBean(OrderPurchaseBean orderPurchaseBean) {
		this.orderPurchaseBean = orderPurchaseBean;
	}

	public String getDetailPurchaseId() {
        return detailPurchaseId;
    }

    public void setDetailPurchaseId(String detailPurchaseId) {
        this.detailPurchaseId = detailPurchaseId == null ? null : detailPurchaseId.trim();
    }

    public String getOrderPurchaseId() {
        return orderPurchaseId;
    }

    public void setOrderPurchaseId(String orderPurchaseId) {
        this.orderPurchaseId = orderPurchaseId == null ? null : orderPurchaseId.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum == null ? null : productNum.trim();
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice == null ? null : productPrice.trim();
    }

    public String getDetailPurchaseState() {
        return detailPurchaseState;
    }

    public void setDetailPurchaseState(String detailPurchaseState) {
        this.detailPurchaseState = detailPurchaseState == null ? null : detailPurchaseState.trim();
    }

    public String getDetailPurchasePerson() {
        return detailPurchasePerson;
    }

    public void setDetailPurchasePerson(String detailPurchasePerson) {
        this.detailPurchasePerson = detailPurchasePerson == null ? null : detailPurchasePerson.trim();
    }

    public String getDetailPurchaseInfo() {
        return detailPurchaseInfo;
    }

    public void setDetailPurchaseInfo(String detailPurchaseInfo) {
        this.detailPurchaseInfo = detailPurchaseInfo == null ? null : detailPurchaseInfo.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public Date getDetailPurchaseUpdateTime() {
        return detailPurchaseUpdateTime;
    }

    public void setDetailPurchaseUpdateTime(Date detailPurchaseUpdateTime) {
        this.detailPurchaseUpdateTime = detailPurchaseUpdateTime;
    }

	@Override
	public String toString() {
		return "DetailPurchaseBean [detailPurchaseId=" + detailPurchaseId + ", orderPurchaseId=" + orderPurchaseId
				+ ", productId=" + productId + ", productNum=" + productNum + ", productPrice=" + productPrice
				+ ", detailPurchaseState=" + detailPurchaseState + ", detailPurchasePerson=" + detailPurchasePerson
				+ ", detailPurchaseInfo=" + detailPurchaseInfo + ", companyId=" + companyId
				+ ", detailPurchaseUpdateTime=" + detailPurchaseUpdateTime + ", orderPurchaseBean=" + orderPurchaseBean
				+ "]";
	}
    
}
package com.sc.crmsys.bean;

import java.util.Date;

public class SaleInfoBean {
    private String saleinfoId;

    private String companyId;

    private String saleoutId;

    private String goodsId;

    private String goodsNum;

    private String goodsPrice;

    private String saleinfoRemarks;

    private Date saleinfoLastTime;

    public String getSaleinfoId() {
        return saleinfoId;
    }

    public void setSaleinfoId(String saleinfoId) {
        this.saleinfoId = saleinfoId == null ? null : saleinfoId.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getSaleoutId() {
        return saleoutId;
    }

    public void setSaleoutId(String saleoutId) {
        this.saleoutId = saleoutId == null ? null : saleoutId.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum == null ? null : goodsNum.trim();
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice == null ? null : goodsPrice.trim();
    }

    public String getSaleinfoRemarks() {
        return saleinfoRemarks;
    }

    public void setSaleinfoRemarks(String saleinfoRemarks) {
        this.saleinfoRemarks = saleinfoRemarks == null ? null : saleinfoRemarks.trim();
    }

    public Date getSaleinfoLastTime() {
        return saleinfoLastTime;
    }

    public void setSaleinfoLastTime(Date saleinfoLastTime) {
        this.saleinfoLastTime = saleinfoLastTime;
    }
}
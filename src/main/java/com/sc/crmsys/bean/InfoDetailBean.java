package com.sc.crmsys.bean;

import java.util.Date;

public class InfoDetailBean {
    private String infoDetailId;

    private String infoId;

    private String employId;

    private String infoDetailState;

    private String companyId;

    private Date infoDetailUpdateTime;
    
    private EmployBean employBean = new EmployBean();
    
    private InfoBean infoBean = new InfoBean();
    
    public InfoBean getInfoBean() {
		return infoBean;
	}

	public void setInfoBean(InfoBean infoBean) {
		this.infoBean = infoBean;
	}

	public EmployBean getEmployBean() {
		return employBean;
	}

	public void setEmployBean(EmployBean employBean) {
		this.employBean = employBean;
	}

    public String getInfoDetailId() {
        return infoDetailId;
    }

    public void setInfoDetailId(String infoDetailId) {
        this.infoDetailId = infoDetailId == null ? null : infoDetailId.trim();
    }

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId == null ? null : infoId.trim();
    }

    public String getEmployId() {
        return employId;
    }

    public void setEmployId(String employId) {
        this.employId = employId == null ? null : employId.trim();
    }

    public String getInfoDetailState() {
        return infoDetailState;
    }

    public void setInfoDetailState(String infoDetailState) {
        this.infoDetailState = infoDetailState == null ? null : infoDetailState.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public Date getInfoDetailUpdateTime() {
        return infoDetailUpdateTime;
    }

    public void setInfoDetailUpdateTime(Date infoDetailUpdateTime) {
        this.infoDetailUpdateTime = infoDetailUpdateTime;
    }
}
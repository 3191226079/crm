package com.sc.crmsys.bean;

import java.util.Date;
import java.util.List;

public class PermissionSubfieldBean {
    private String subfieldNumber;

    private String subfieldName;

    private String subfieldRemarks;

    private Date subfieldLastTime;
    
    private List<PermissionSubfieldBean> permissionSubfieldList;
    
    private PermissionInformationBean permissionInformationBean;
    
    

    

	public List<PermissionSubfieldBean> getPermissionSubfieldList() {
		return permissionSubfieldList;
	}

	public void setPermissionSubfieldList(List<PermissionSubfieldBean> permissionSubfieldList) {
		this.permissionSubfieldList = permissionSubfieldList;
	}

	public PermissionInformationBean getPermissionInformationBean() {
		return permissionInformationBean;
	}

	public void setPermissionInformationBean(PermissionInformationBean permissionInformationBean) {
		this.permissionInformationBean = permissionInformationBean;
	}

	public String getSubfieldNumber() {
        return subfieldNumber;
    }

    public void setSubfieldNumber(String subfieldNumber) {
        this.subfieldNumber = subfieldNumber == null ? null : subfieldNumber.trim();
    }

    public String getSubfieldName() {
        return subfieldName;
    }

    public void setSubfieldName(String subfieldName) {
        this.subfieldName = subfieldName == null ? null : subfieldName.trim();
    }

    public String getSubfieldRemarks() {
        return subfieldRemarks;
    }

    public void setSubfieldRemarks(String subfieldRemarks) {
        this.subfieldRemarks = subfieldRemarks == null ? null : subfieldRemarks.trim();
    }

    public Date getSubfieldLastTime() {
        return subfieldLastTime;
    }

    public void setSubfieldLastTime(Date subfieldLastTime) {
        this.subfieldLastTime = subfieldLastTime;
    }
}
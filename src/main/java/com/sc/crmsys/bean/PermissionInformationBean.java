package com.sc.crmsys.bean;

import java.util.Date;

public class PermissionInformationBean {
    private String permissionNumber;

    private String permissionName;

    private String permission;

    private String subfieldNumber;

    private String informationRemarks;

    private Date informationLastTime;

    public String getPermissionNumber() {
        return permissionNumber;
    }

    public void setPermissionNumber(String permissionNumber) {
        this.permissionNumber = permissionNumber == null ? null : permissionNumber.trim();
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    public String getSubfieldNumber() {
        return subfieldNumber;
    }

    public void setSubfieldNumber(String subfieldNumber) {
        this.subfieldNumber = subfieldNumber == null ? null : subfieldNumber.trim();
    }

    public String getInformationRemarks() {
        return informationRemarks;
    }

    public void setInformationRemarks(String informationRemarks) {
        this.informationRemarks = informationRemarks == null ? null : informationRemarks.trim();
    }

    public Date getInformationLastTime() {
        return informationLastTime;
    }

    public void setInformationLastTime(Date informationLastTime) {
        this.informationLastTime = informationLastTime;
    }
}
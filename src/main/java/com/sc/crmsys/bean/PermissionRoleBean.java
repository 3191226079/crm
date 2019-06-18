package com.sc.crmsys.bean;

import java.util.Date;

public class PermissionRoleBean {
    private String permissionRoleNumber;

    private String permissionNumber;

    private String roleNumber;

    private String permissionRoleOperator;

    private Date permissionRoleLastTime;

    public String getPermissionRoleNumber() {
        return permissionRoleNumber;
    }

    public void setPermissionRoleNumber(String permissionRoleNumber) {
        this.permissionRoleNumber = permissionRoleNumber == null ? null : permissionRoleNumber.trim();
    }

    public String getPermissionNumber() {
        return permissionNumber;
    }

    public void setPermissionNumber(String permissionNumber) {
        this.permissionNumber = permissionNumber == null ? null : permissionNumber.trim();
    }

    public String getRoleNumber() {
        return roleNumber;
    }

    public void setRoleNumber(String roleNumber) {
        this.roleNumber = roleNumber == null ? null : roleNumber.trim();
    }

    public String getPermissionRoleOperator() {
        return permissionRoleOperator;
    }

    public void setPermissionRoleOperator(String permissionRoleOperator) {
        this.permissionRoleOperator = permissionRoleOperator == null ? null : permissionRoleOperator.trim();
    }

    public Date getPermissionRoleLastTime() {
        return permissionRoleLastTime;
    }

    public void setPermissionRoleLastTime(Date permissionRoleLastTime) {
        this.permissionRoleLastTime = permissionRoleLastTime;
    }
}
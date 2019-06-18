package com.sc.crmsys.bean;

import java.util.Date;

public class UserRoleBean {
    private String userRoleId;

    private String userId;

    private String roleNumber;

    private String userRolePerson;

    private Date userRoleUpdateTime;

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId == null ? null : userRoleId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getRoleNumber() {
        return roleNumber;
    }

    public void setRoleNumber(String roleNumber) {
        this.roleNumber = roleNumber == null ? null : roleNumber.trim();
    }

    public String getUserRolePerson() {
        return userRolePerson;
    }

    public void setUserRolePerson(String userRolePerson) {
        this.userRolePerson = userRolePerson == null ? null : userRolePerson.trim();
    }

    public Date getUserRoleUpdateTime() {
        return userRoleUpdateTime;
    }

    public void setUserRoleUpdateTime(Date userRoleUpdateTime) {
        this.userRoleUpdateTime = userRoleUpdateTime;
    }
}
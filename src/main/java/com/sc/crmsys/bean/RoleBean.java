package com.sc.crmsys.bean;

import java.util.Date;

public class RoleBean {
    private String roleNumber;

    private String roleName;

    private String roleDescribe;

    private String roleUpperNumber;

    private String rolePerson;

    private Date roleLastTime;

    public String getRoleNumber() {
        return roleNumber;
    }

    public void setRoleNumber(String roleNumber) {
        this.roleNumber = roleNumber == null ? null : roleNumber.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleDescribe() {
        return roleDescribe;
    }

    public void setRoleDescribe(String roleDescribe) {
        this.roleDescribe = roleDescribe == null ? null : roleDescribe.trim();
    }

    public String getRoleUpperNumber() {
        return roleUpperNumber;
    }

    public void setRoleUpperNumber(String roleUpperNumber) {
        this.roleUpperNumber = roleUpperNumber == null ? null : roleUpperNumber.trim();
    }

    public String getRolePerson() {
        return rolePerson;
    }

    public void setRolePerson(String rolePerson) {
        this.rolePerson = rolePerson == null ? null : rolePerson.trim();
    }

    public Date getRoleLastTime() {
        return roleLastTime;
    }

    public void setRoleLastTime(Date roleLastTime) {
        this.roleLastTime = roleLastTime;
    }
}
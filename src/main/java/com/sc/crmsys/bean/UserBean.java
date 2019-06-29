package com.sc.crmsys.bean;

import java.util.Date;

public class UserBean {
    private String userId;

    private String userName;

    private String userPassword;

    private String employId;

    private String companyId;

    private String userState;

    private Date userRegisterTime;

    private Date userUpdateTime;
    
    private UserRoleBean userRoleBean;

    private String userSalt;

    public String getUserId() {
        return userId;
    }

    
    
    public UserRoleBean getUserRoleBean() {
		return userRoleBean;
	}



	public void setUserRoleBean(UserRoleBean userRoleBean) {
		this.userRoleBean = userRoleBean;
	}



	public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getEmployId() {
        return employId;
    }

    public void setEmployId(String employId) {
        this.employId = employId == null ? null : employId.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState == null ? null : userState.trim();
    }

    public Date getUserRegisterTime() {
        return userRegisterTime;
    }

    public void setUserRegisterTime(Date userRegisterTime) {
        this.userRegisterTime = userRegisterTime;
    }

    public Date getUserUpdateTime() {
        return userUpdateTime;
    }

    public void setUserUpdateTime(Date userUpdateTime) {
        this.userUpdateTime = userUpdateTime;
    }

    public String getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt == null ? null : userSalt.trim();
    }
    @Override
	public String toString() {
		return "UserBean [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", employId=" + employId + ", companyId=" + companyId + ", userState=" + userState
				+ ", userRegisterTime=" + userRegisterTime + ", userUpdateTime=" + userUpdateTime + "]";
	}

}
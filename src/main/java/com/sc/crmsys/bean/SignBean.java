package com.sc.crmsys.bean;

import java.util.Date;

public class SignBean {
    private String signId;

    private String userId;

    private Date signTime;

    private String signNum;

    private String signDays;

    public String getSignId() {
        return signId;
    }

    public void setSignId(String signId) {
        this.signId = signId == null ? null : signId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public String getSignNum() {
        return signNum;
    }

    public void setSignNum(String signNum) {
        this.signNum = signNum == null ? null : signNum.trim();
    }

    public String getSignDays() {
        return signDays;
    }

    public void setSignDays(String signDays) {
        this.signDays = signDays == null ? null : signDays.trim();
    }

	public SignBean(String signId, String userId, Date signTime, String signNum, String signDays) {
		super();
		this.signId = signId;
		this.userId = userId;
		this.signTime = signTime;
		this.signNum = signNum;
		this.signDays = signDays;
	}

	public SignBean() {
		super();
	}
    
}
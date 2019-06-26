package com.sc.crmsys.bean;

import java.util.Date;

public class SignBean {
    private String signId;

    private String userId;

    private Date signTime;

    private String signNum;

    private String signDays;

    private String signState;

    private String signYear;

    private String signMonth;

    public SignBean(String signId, String userId, Date signTime, String signNum, String signDays, String signState, String signYear, String signMonth) {
        this.signId = signId;
        this.userId = userId;
        this.signTime = signTime;
        this.signNum = signNum;
        this.signDays = signDays;
        this.signState = signState;
        this.signYear = signYear;
        this.signMonth = signMonth;
    }

    public SignBean() {
        super();
    }

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

    public String getSignState() {
        return signState;
    }

    public void setSignState(String signState) {
        this.signState = signState == null ? null : signState.trim();
    }

    public String getSignYear() {
        return signYear;
    }

    public void setSignYear(String signYear) {
        this.signYear = signYear == null ? null : signYear.trim();
    }

    public String getSignMonth() {
        return signMonth;
    }

    public void setSignMonth(String signMonth) {
        this.signMonth = signMonth == null ? null : signMonth.trim();
    }
}
package com.sc.crmsys.bean;

import java.util.Date;

public class SignCountBean {
    private String signCountId;

    private String userId;

    private String signCounts;

    private Date signCountTime;

    private String signState;

    private String signMonth;

    private String signYear;

    public SignCountBean(String signCountId, String userId, String signCounts, Date signCountTime, String signState, String signMonth, String signYear) {
        this.signCountId = signCountId;
        this.userId = userId;
        this.signCounts = signCounts;
        this.signCountTime = signCountTime;
        this.signState = signState;
        this.signMonth = signMonth;
        this.signYear = signYear;
    }

    public SignCountBean() {
        super();
    }

    public String getSignCountId() {
        return signCountId;
    }

    public void setSignCountId(String signCountId) {
        this.signCountId = signCountId == null ? null : signCountId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getSignCounts() {
        return signCounts;
    }

    public void setSignCounts(String signCounts) {
        this.signCounts = signCounts == null ? null : signCounts.trim();
    }

    public Date getSignCountTime() {
        return signCountTime;
    }

    public void setSignCountTime(Date signCountTime) {
        this.signCountTime = signCountTime;
    }

    public String getSignState() {
        return signState;
    }

    public void setSignState(String signState) {
        this.signState = signState == null ? null : signState.trim();
    }

    public String getSignMonth() {
        return signMonth;
    }

    public void setSignMonth(String signMonth) {
        this.signMonth = signMonth == null ? null : signMonth.trim();
    }

    public String getSignYear() {
        return signYear;
    }

    public void setSignYear(String signYear) {
        this.signYear = signYear == null ? null : signYear.trim();
    }
}
package com.sc.crmsys.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CheckPointBean {
    private String checkPointId;

    private String checkPointTarget;

    private String checkPointInfo;

    private String companyId;
    
    @DateTimeFormat(pattern="yyyy-MM-dd  HH:mm:ss")
    private Date checkPointUpdateTime;

    public String getCheckPointId() {
        return checkPointId;
    }

    public void setCheckPointId(String checkPointId) {
        this.checkPointId = checkPointId == null ? null : checkPointId.trim();
    }

    public String getCheckPointTarget() {
        return checkPointTarget;
    }

    public void setCheckPointTarget(String checkPointTarget) {
        this.checkPointTarget = checkPointTarget == null ? null : checkPointTarget.trim();
    }

    public String getCheckPointInfo() {
        return checkPointInfo;
    }

    public void setCheckPointInfo(String checkPointInfo) {
        this.checkPointInfo = checkPointInfo == null ? null : checkPointInfo.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public Date getCheckPointUpdateTime() {
        return checkPointUpdateTime;
    }

    public void setCheckPointUpdateTime(Date checkPointUpdateTime) {
        this.checkPointUpdateTime = checkPointUpdateTime;
    }
}
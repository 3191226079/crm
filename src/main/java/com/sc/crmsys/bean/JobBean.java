package com.sc.crmsys.bean;

import java.util.Date;

public class JobBean {
    private String jobId;

    private String jobName;

    private String deptNumber;

    private String jobRemarks;

    private String companyId;

    private Date jobLastTime;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId == null ? null : jobId.trim();
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getDeptNumber() {
        return deptNumber;
    }

    public void setDeptNumber(String deptNumber) {
        this.deptNumber = deptNumber == null ? null : deptNumber.trim();
    }

    public String getJobRemarks() {
        return jobRemarks;
    }

    public void setJobRemarks(String jobRemarks) {
        this.jobRemarks = jobRemarks == null ? null : jobRemarks.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public Date getJobLastTime() {
        return jobLastTime;
    }

    public void setJobLastTime(Date jobLastTime) {
        this.jobLastTime = jobLastTime;
    }
}
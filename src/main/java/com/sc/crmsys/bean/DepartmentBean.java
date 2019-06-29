package com.sc.crmsys.bean;

import java.util.Date;
import java.util.List;

public class DepartmentBean {
    private String deptNumber;

    private String deptName;

    private String deptRemarks;

    private String companyId;

    private Date deptLastTime;
    
    private List<JobBean> jobList;
    

    public List<JobBean> getJobList() {
		return jobList;
	}

	public void setJobList(List<JobBean> jobList) {
		this.jobList = jobList;
	}

	public String getDeptNumber() {
        return deptNumber;
    }

    public void setDeptNumber(String deptNumber) {
        this.deptNumber = deptNumber == null ? null : deptNumber.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getDeptRemarks() {
        return deptRemarks;
    }

    public void setDeptRemarks(String deptRemarks) {
        this.deptRemarks = deptRemarks == null ? null : deptRemarks.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public Date getDeptLastTime() {
        return deptLastTime;
    }

    public void setDeptLastTime(Date deptLastTime) {
        this.deptLastTime = deptLastTime;
    }
}
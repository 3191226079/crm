package com.sc.crmsys.bean;

import java.util.Date;

public class EmployBean {
    private String employId;

    private String employName;

    private String employSex;

    private String employImg;

    private String employSalary;

    private String employIdentify;

    private String employAddress;

    private String employEducation;

    private String employPolitic;

    private String employSchool;

    private String employPhone;

    private String checkState;

    private String jobId;

    private String employState;

    private String companyId;

    private Date employUpdateTime;
    
    private JobBean jobBean;

    public String getEmployId() {
        return employId;
    }

    public void setEmployId(String employId) {
        this.employId = employId == null ? null : employId.trim();
    }

    public String getEmployName() {
        return employName;
    }

    public void setEmployName(String employName) {
        this.employName = employName == null ? null : employName.trim();
    }

    public String getEmploySex() {
        return employSex;
    }

    public void setEmploySex(String employSex) {
        this.employSex = employSex == null ? null : employSex.trim();
    }

    public String getEmployImg() {
        return employImg;
    }

    public void setEmployImg(String employImg) {
        this.employImg = employImg == null ? null : employImg.trim();
    }

    public String getEmploySalary() {
        return employSalary;
    }

    public void setEmploySalary(String employSalary) {
        this.employSalary = employSalary == null ? null : employSalary.trim();
    }

    public String getEmployIdentify() {
        return employIdentify;
    }

    public void setEmployIdentify(String employIdentify) {
        this.employIdentify = employIdentify == null ? null : employIdentify.trim();
    }

    public String getEmployAddress() {
        return employAddress;
    }

    public void setEmployAddress(String employAddress) {
        this.employAddress = employAddress == null ? null : employAddress.trim();
    }

    public String getEmployEducation() {
        return employEducation;
    }

    public void setEmployEducation(String employEducation) {
        this.employEducation = employEducation == null ? null : employEducation.trim();
    }

    public String getEmployPolitic() {
        return employPolitic;
    }

    public void setEmployPolitic(String employPolitic) {
        this.employPolitic = employPolitic == null ? null : employPolitic.trim();
    }

    public String getEmploySchool() {
        return employSchool;
    }

    public void setEmploySchool(String employSchool) {
        this.employSchool = employSchool == null ? null : employSchool.trim();
    }

    public String getEmployPhone() {
        return employPhone;
    }

    public void setEmployPhone(String employPhone) {
        this.employPhone = employPhone == null ? null : employPhone.trim();
    }

    public String getCheckState() {
        return checkState;
    }

    public void setCheckState(String checkState) {
        this.checkState = checkState == null ? null : checkState.trim();
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId == null ? null : jobId.trim();
    }

    public String getEmployState() {
        return employState;
    }

    public void setEmployState(String employState) {
        this.employState = employState == null ? null : employState.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public Date getEmployUpdateTime() {
        return employUpdateTime;
    }
    
    

    public EmployBean(String employId, String employName, String employSex, String employImg, String employSalary,
			String employIdentify, String employAddress, String employEducation, String employPolitic,
			String employSchool, String employPhone, String checkState, String jobId, String employState,
			String companyId, Date employUpdateTime, JobBean jobBean) {
		super();
		this.employId = employId;
		this.employName = employName;
		this.employSex = employSex;
		this.employImg = employImg;
		this.employSalary = employSalary;
		this.employIdentify = employIdentify;
		this.employAddress = employAddress;
		this.employEducation = employEducation;
		this.employPolitic = employPolitic;
		this.employSchool = employSchool;
		this.employPhone = employPhone;
		this.checkState = checkState;
		this.jobId = jobId;
		this.employState = employState;
		this.companyId = companyId;
		this.employUpdateTime = employUpdateTime;
		this.jobBean = jobBean;
	}

	public JobBean getJobBean() {
		return jobBean;
	}

	public void setJobBean(JobBean jobBean) {
		this.jobBean = jobBean;
	}

	public void setEmployUpdateTime(Date employUpdateTime) {
        this.employUpdateTime = employUpdateTime;
    }

	public EmployBean() {
		super();
	}
	
}
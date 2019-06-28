package com.sc.crmsys.bean;

import java.util.Date;

public class TaskDetailBean {
    private String taskDetailId;

    private String taskId;

    private String employId;

    private String taskDetailState;

    private String companyId;

    private Date taskDetailUpdateTime;
    
    private TaskBean taskBean = new TaskBean();
    
    private EmployBean employBean = new EmployBean();

    public TaskBean getTaskBean() {
		return taskBean;
	}

	public void setTaskBean(TaskBean taskBean) {
		this.taskBean = taskBean;
	}

	public EmployBean getEmployBean() {
		return employBean;
	}

	public void setEmployBean(EmployBean employBean) {
		this.employBean = employBean;
	}

	public String getTaskDetailId() {
        return taskDetailId;
    }

    public void setTaskDetailId(String taskDetailId) {
        this.taskDetailId = taskDetailId == null ? null : taskDetailId.trim();
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public String getEmployId() {
        return employId;
    }

    public void setEmployId(String employId) {
        this.employId = employId == null ? null : employId.trim();
    }

    public String getTaskDetailState() {
        return taskDetailState;
    }

    public void setTaskDetailState(String taskDetailState) {
        this.taskDetailState = taskDetailState == null ? null : taskDetailState.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public Date getTaskDetailUpdateTime() {
        return taskDetailUpdateTime;
    }

    public void setTaskDetailUpdateTime(Date taskDetailUpdateTime) {
        this.taskDetailUpdateTime = taskDetailUpdateTime;
    }
}
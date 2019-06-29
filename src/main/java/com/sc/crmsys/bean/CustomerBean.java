package com.sc.crmsys.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CustomerBean {
    private String customerId;

    private String customerName;

    private String customerUpDepartment;

    private String customerContactPerson;

    private String customerState;

    private String customerAddress;

    private String customerPhone;

    private String customerFax;

    private String customerEmail;

    @DateTimeFormat(pattern="yyyy/MM/dd")
    private Date customerContactTime;

    private String customerInfo;

    private String companyId;

    @DateTimeFormat(pattern="yyyy/MM/dd")
    private Date customerUpdateTime;
    
    private String companyName;
    
   



	public CustomerBean() {
		super();
	}

	public CustomerBean(String customerId, String customerName, String customerUpDepartment,
			String customerContactPerson, String customerState, String customerAddress, String customerPhone,
			String customerFax, String customerEmail, Date customerContactTime, String customerInfo, String companyId,
			Date customerUpdateTime, String companyName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerUpDepartment = customerUpDepartment;
		this.customerContactPerson = customerContactPerson;
		this.customerState = customerState;
		this.customerAddress = customerAddress;
		this.customerPhone = customerPhone;
		this.customerFax = customerFax;
		this.customerEmail = customerEmail;
		this.customerContactTime = customerContactTime;
		this.customerInfo = customerInfo;
		this.companyId = companyId;
		this.customerUpdateTime = customerUpdateTime;
		this.companyName = companyName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getCustomerUpDepartment() {
        return customerUpDepartment;
    }

    public void setCustomerUpDepartment(String customerUpDepartment) {
        this.customerUpDepartment = customerUpDepartment == null ? null : customerUpDepartment.trim();
    }

    public String getCustomerContactPerson() {
        return customerContactPerson;
    }

    public void setCustomerContactPerson(String customerContactPerson) {
        this.customerContactPerson = customerContactPerson == null ? null : customerContactPerson.trim();
    }

    public String getCustomerState() {
        return customerState;
    }

    public void setCustomerState(String customerState) {
        this.customerState = customerState == null ? null : customerState.trim();
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress == null ? null : customerAddress.trim();
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone == null ? null : customerPhone.trim();
    }

    public String getCustomerFax() {
        return customerFax;
    }

    public void setCustomerFax(String customerFax) {
        this.customerFax = customerFax == null ? null : customerFax.trim();
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail == null ? null : customerEmail.trim();
    }

    public Date getCustomerContactTime() {
        return customerContactTime;
    }

    public void setCustomerContactTime(Date customerContactTime) {
        this.customerContactTime = customerContactTime;
    }

    public String getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(String customerInfo) {
        this.customerInfo = customerInfo == null ? null : customerInfo.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public Date getCustomerUpdateTime() {
        return customerUpdateTime;
    }

    public void setCustomerUpdateTime(Date customerUpdateTime) {
        this.customerUpdateTime = customerUpdateTime;
    }

	@Override
	public String toString() {
		return "CustomerBean [customerId=" + customerId + ", customerName=" + customerName + ", customerUpDepartment="
				+ customerUpDepartment + ", customerContactPerson=" + customerContactPerson + ", customerState="
				+ customerState + ", customerAddress=" + customerAddress + ", customerPhone=" + customerPhone
				+ ", customerFax=" + customerFax + ", customerEmail=" + customerEmail + ", customerContactTime="
				+ customerContactTime + ", customerInfo=" + customerInfo + ", companyId=" + companyId
				+ ", customerUpdateTime=" + customerUpdateTime + "]";
	}
    
    
}
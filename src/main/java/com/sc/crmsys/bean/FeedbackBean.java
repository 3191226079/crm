package com.sc.crmsys.bean;

import java.util.Date;

public class FeedbackBean {
    private String feedbackId;

    private String customerId;

    private String companyId;

    private String feedbackState;

    private String feedbackType;

    private Date feedbackTime;

    private String feedbackReason;

    private String feedbackCharge;

    private String feedbackTitle;

    private String feedbackContent;

    private String feedbackAnalyse;

    private Date feedbackLastTime;

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId == null ? null : feedbackId.trim();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getFeedbackState() {
        return feedbackState;
    }

    public void setFeedbackState(String feedbackState) {
        this.feedbackState = feedbackState == null ? null : feedbackState.trim();
    }

    public String getFeedbackType() {
        return feedbackType;
    }

    public void setFeedbackType(String feedbackType) {
        this.feedbackType = feedbackType == null ? null : feedbackType.trim();
    }

    public Date getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(Date feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

    public String getFeedbackReason() {
        return feedbackReason;
    }

    public void setFeedbackReason(String feedbackReason) {
        this.feedbackReason = feedbackReason == null ? null : feedbackReason.trim();
    }

    public String getFeedbackCharge() {
        return feedbackCharge;
    }

    public void setFeedbackCharge(String feedbackCharge) {
        this.feedbackCharge = feedbackCharge == null ? null : feedbackCharge.trim();
    }

    public String getFeedbackTitle() {
        return feedbackTitle;
    }

    public void setFeedbackTitle(String feedbackTitle) {
        this.feedbackTitle = feedbackTitle == null ? null : feedbackTitle.trim();
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent == null ? null : feedbackContent.trim();
    }

    public String getFeedbackAnalyse() {
        return feedbackAnalyse;
    }

    public void setFeedbackAnalyse(String feedbackAnalyse) {
        this.feedbackAnalyse = feedbackAnalyse == null ? null : feedbackAnalyse.trim();
    }

    public Date getFeedbackLastTime() {
        return feedbackLastTime;
    }

    public void setFeedbackLastTime(Date feedbackLastTime) {
        this.feedbackLastTime = feedbackLastTime;
    }
}
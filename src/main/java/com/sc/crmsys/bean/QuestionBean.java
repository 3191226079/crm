package com.sc.crmsys.bean;

import java.util.Date;

public class QuestionBean {
    private String questionId;

    private String questionContent;

    private String questionState;

    private Date questionTime;

    private String answerContent;

    private Date answerTime;

    private String answerPopular;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId == null ? null : questionId.trim();
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent == null ? null : questionContent.trim();
    }

    public String getQuestionState() {
        return questionState;
    }

    public void setQuestionState(String questionState) {
        this.questionState = questionState == null ? null : questionState.trim();
    }

    public Date getQuestionTime() {
        return questionTime;
    }

    public void setQuestionTime(Date questionTime) {
        this.questionTime = questionTime;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent == null ? null : answerContent.trim();
    }

    public Date getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }

    public String getAnswerPopular() {
        return answerPopular;
    }

    public void setAnswerPopular(String answerPopular) {
        this.answerPopular = answerPopular == null ? null : answerPopular.trim();
    }
}
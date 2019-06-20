package com.sc.crmsys.bean;

import java.util.Date;

public class AnswerBean {
    private String answerId;

    private String questionId;

    private String answerContent;

    private Date answerTime;

    private String answerPopular;

    private String answerUnpopular;

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId == null ? null : answerId.trim();
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId == null ? null : questionId.trim();
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

    public String getAnswerUnpopular() {
        return answerUnpopular;
    }

    public void setAnswerUnpopular(String answerUnpopular) {
        this.answerUnpopular = answerUnpopular == null ? null : answerUnpopular.trim();
    }
}
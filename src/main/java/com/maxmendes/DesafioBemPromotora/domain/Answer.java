package com.maxmendes.DesafioBemPromotora.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Answer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer client_id;
    private String answerQuestionOne;
    private String answerQuestionTwo;
    private String answerQuestionThree;
    private String answerQuestionFour;

    public Answer() {
    }


    public Answer(Integer id, Integer client_id, String answerQuestionOne, String answerQuestionTwo, String answerQuestionThree, String answerQuestionFour) {
        this.id = id;
        this.client_id = client_id;
        this.answerQuestionOne = answerQuestionOne;
        this.answerQuestionTwo = answerQuestionTwo;
        this.answerQuestionThree = answerQuestionThree;
        this.answerQuestionFour = answerQuestionFour;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public String getAnswerQuestionOne() {
        return answerQuestionOne;
    }

    public void setAnswerQuestionOne(String answerQuestionOne) {
        this.answerQuestionOne = answerQuestionOne;
    }

    public String getAnswerQuestionTwo() {
        return answerQuestionTwo;
    }

    public void setAnswerQuestionTwo(String answerQuestionTwo) {
        this.answerQuestionTwo = answerQuestionTwo;
    }

    public String getAnswerQuestionThree() {
        return answerQuestionThree;
    }

    public void setAnswerQuestionThree(String answerQuestionThree) {
        this.answerQuestionThree = answerQuestionThree;
    }

    public String getAnswerQuestionFour() {
        return answerQuestionFour;
    }

    public void setAnswerQuestionFour(String answerQuestionFour) {
        this.answerQuestionFour = answerQuestionFour;
    }
}

package com.example.leonsbrbara.quizapp.Models;

/**
 * Created by LeonsBärbara on 2017-03-02.
 */

public class Question {
    private Long id;

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return Question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getAlternativ1() {
        return alternativ1;
    }

    public String getAlternativ2() {
        return alternativ2;
    }

    public String getAlternativ3() {
        return alternativ3;
    }

    private String Question;

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setAlternativ1(String alternativ1) {
        this.alternativ1 = alternativ1;
    }

    public void setAlternativ2(String alternativ2) {
        this.alternativ2 = alternativ2;
    }

    public void setAlternativ3(String alternativ3) {
        this.alternativ3 = alternativ3;
    }

    private String answer;
    private String alternativ1;
    private String alternativ2;
    private String alternativ3;

    public Question(Long id, String Question, String answer, String alternativ1,String alternativ2,String alternativ3){
        this.id = id;
        this.Question = Question;
        this.answer = answer;
        this.alternativ1 = alternativ1;
        this.alternativ2 = alternativ2;
        this.alternativ3 = alternativ3;
    }
}

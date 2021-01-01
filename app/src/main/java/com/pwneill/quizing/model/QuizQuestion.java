package com.pwneill.quizing.model;

public class QuizQuestion {

    private String questionText;
    private boolean trueFalse;

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public boolean isTrueFalse() {
        return trueFalse;
    }

    public void setTrueFalse(boolean trueFalse) {
        this.trueFalse = trueFalse;
    }

    public QuizQuestion(String questionText, boolean trueFalse) {
        this.questionText = questionText;
        this.trueFalse = trueFalse;
    }
}

package com.ljk.bit.entity;

import java.util.Objects;

public class Question {
    private int questionID;
    private String A;
    private String B;
    private String C;
    private String D;
    private String answer;

    private String submit;

    public Question() {
    }

    public Question(int questionID, String a, String b, String c, String d, String answer, String submit) {
        this.questionID = questionID;
        A = a;
        B = b;
        C = c;
        D = d;
        this.answer = answer;
        this.submit = submit;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getSubmit() {
        return submit;
    }

    public void setSubmit(String submit) {
        this.submit = submit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return questionID == question.questionID &&
                Objects.equals(A, question.A) &&
                Objects.equals(B, question.B) &&
                Objects.equals(C, question.C) &&
                Objects.equals(D, question.D) &&
                Objects.equals(answer, question.answer) &&
                Objects.equals(submit, question.submit);
    }

    @Override
    public int hashCode() {

        return Objects.hash(questionID, A, B, C, D, answer, submit);
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionID=" + questionID +
                ", A='" + A + '\'' +
                ", B='" + B + '\'' +
                ", C='" + C + '\'' +
                ", D='" + D + '\'' +
                ", answer='" + answer + '\'' +
                ", submit='" + submit + '\'' +
                '}';
    }
}

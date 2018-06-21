package com.ljk.bit.entity;

import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class Tutor {
    private String tutorID;
    private String tutorName;
    private String password;
    private float funds;
    private String orderID;
    private int role;
    private String email;
    private String instrumentID;

    public Tutor() {
    }

    public Tutor(String tutorID, String tutorName, String password, float funds, String orderID, int role, String email, String instrumentID) {
        this.tutorID = tutorID;
        this.tutorName = tutorName;
        this.password = password;
        this.funds = funds;
        this.orderID = orderID;
        this.role = role;
        this.email = email;
        this.instrumentID = instrumentID;
    }

    public String getTutorID() {
        return tutorID;
    }

    public void setTutorID(String tutorID) {
        this.tutorID = tutorID;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getFunds() {
        return funds;
    }

    public void setFunds(float funds) {
        this.funds = funds;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstrumentID() {
        return instrumentID;
    }

    public void setInstrumentID(String instrumentID) {
        this.instrumentID = instrumentID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tutor tutor = (Tutor) o;
        return Float.compare(tutor.funds, funds) == 0 &&
                role == tutor.role &&
                Objects.equals(tutorID, tutor.tutorID) &&
                Objects.equals(tutorName, tutor.tutorName) &&
                Objects.equals(password, tutor.password) &&
                Objects.equals(orderID, tutor.orderID) &&
                Objects.equals(email, tutor.email) &&
                Objects.equals(instrumentID, tutor.instrumentID);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tutorID, tutorName, password, funds, orderID, role, email, instrumentID);
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "tutorID='" + tutorID + '\'' +
                ", tutorName='" + tutorName + '\'' +
                ", password='" + password + '\'' +
                ", funds=" + funds +
                ", orderID='" + orderID + '\'' +
                ", role=" + role +
                ", email='" + email + '\'' +
                ", instrumentID='" + instrumentID + '\'' +
                '}';
    }
}

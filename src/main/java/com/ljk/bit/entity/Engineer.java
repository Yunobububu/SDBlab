package com.ljk.bit.entity;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Engineer {
    private String engineerID;
    private String name;
    private String email;
    private String password;
    private String instrumentID;
    private String orderID;
    private int role;

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Engineer{" +
                "engineerID='" + engineerID + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", instrumentID='" + instrumentID + '\'' +
                ", orderID='" + orderID + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engineer engineer = (Engineer) o;
        return role == engineer.role &&
                Objects.equals(engineerID, engineer.engineerID) &&
                Objects.equals(name, engineer.name) &&
                Objects.equals(email, engineer.email) &&
                Objects.equals(password, engineer.password) &&
                Objects.equals(instrumentID, engineer.instrumentID) &&
                Objects.equals(orderID, engineer.orderID);
    }

    @Override
    public int hashCode() {

        return Objects.hash(engineerID, name, email, password, instrumentID, orderID, role);
    }

    public Engineer(String engineerID, String name, String email, String password, String instrumentID, String orderID, int role) {

        this.engineerID = engineerID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.instrumentID = instrumentID;
        this.orderID = orderID;
        this.role = role;
    }

    public Engineer(String engineerID, String name, String email, String password, String instrumentID, String orderID) {
        this.engineerID = engineerID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.instrumentID = instrumentID;
        this.orderID = orderID;
    }

    public Engineer() {
    }

    public String getInstrumentID() {

        return instrumentID;
    }

    public void setInstrumentID(String instrumentID) {
        this.instrumentID = instrumentID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getEngineerID() {
        return engineerID;
    }

    public void setEngineerID(String engineerID) {
        this.engineerID = engineerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

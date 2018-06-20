package com.ljk.bit.entity;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class LoginInfo {
    private String userID;
    private String password;
    private boolean rememberMe;
    private int role;

    public LoginInfo() {
    }

    public LoginInfo(String userID, String password, boolean rememberMe, int role) {
        this.userID = userID;
        this.password = password;
        this.rememberMe = rememberMe;
        this.role = role;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginInfo loginInfo = (LoginInfo) o;
        return rememberMe == loginInfo.rememberMe &&
                role == loginInfo.role &&
                Objects.equals(userID, loginInfo.userID) &&
                Objects.equals(password, loginInfo.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userID, password, rememberMe, role);
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "userID='" + userID + '\'' +
                ", password='" + password + '\'' +
                ", rememberMe=" + rememberMe +
                ", role=" + role +
                '}';
    }
}

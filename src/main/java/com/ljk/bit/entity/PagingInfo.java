package com.ljk.bit.entity;

import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class PagingInfo {
    private String token;
    private int page;
    private String userID;

    public PagingInfo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagingInfo that = (PagingInfo) o;
        return page == that.page &&
                Objects.equals(token, that.token) &&
                Objects.equals(userID, that.userID);
    }

    @Override
    public int hashCode() {

        return Objects.hash(token, page, userID);
    }

    public PagingInfo(String token, int page, String userID) {
        this.token = token;
        this.page = page;
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "PagingInfo{" +
                "token='" + token + '\'' +
                ", page=" + page +
                ", userID='" + userID + '\'' +
                '}';
    }
}

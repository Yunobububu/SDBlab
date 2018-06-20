package com.ljk.bit.entity;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
@Component
public class Orders {
    private String orderID;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int status;
    private String instrumentID;
    private LocalDateTime createTime;

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Orders() {
    }

    public Orders(String orderID, LocalDateTime startTime, LocalDateTime endTime, int status, String instrumentID, LocalDateTime createTime) {
        this.orderID = orderID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.instrumentID = instrumentID;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderID='" + orderID + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status=" + status +
                ", instrumentID='" + instrumentID + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return status == orders.status &&
                Objects.equals(orderID, orders.orderID) &&
                Objects.equals(startTime, orders.startTime) &&
                Objects.equals(endTime, orders.endTime) &&
                Objects.equals(instrumentID, orders.instrumentID) &&
                Objects.equals(createTime, orders.createTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderID, startTime, endTime, status, instrumentID, createTime);
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInstrumentID() {
        return instrumentID;
    }

    public void setInstrumentID(String instrumentID) {
        this.instrumentID = instrumentID;
    }

}

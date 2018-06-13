package com.ljk.bit.entity;

import java.util.Date;
import java.util.Objects;

public class Orders {
    private String order_ID;
    private Date startTime;
    private Date endTime;
    private int status;
    private String instrumentID;

    public Orders() {
    }

    public String getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(String order_ID) {
        this.order_ID = order_ID;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return status == orders.status &&
                Objects.equals(order_ID, orders.order_ID) &&
                Objects.equals(startTime, orders.startTime) &&
                Objects.equals(endTime, orders.endTime) &&
                Objects.equals(instrumentID, orders.instrumentID);
    }

    @Override
    public int hashCode() {

        return Objects.hash(order_ID, startTime, endTime, status, instrumentID);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "order_ID='" + order_ID + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status=" + status +
                ", instrumentID='" + instrumentID + '\'' +
                '}';
    }
}

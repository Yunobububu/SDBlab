package com.ljk.bit.entity;

import java.util.Date;
import java.util.Objects;

public class Instrument {
    private String instrumentID;
    private String name;
    private double price;
    private int status;
    private Date startTime;
    private Date endTime;

    public Instrument() {
    }

    public Instrument(String instrumentID, String name, double price, int status, Date startTime, Date endTime) {
        this.instrumentID = instrumentID;
        this.name = name;
        this.price = price;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getInstrumentID() {
        return instrumentID;
    }

    public void setInstrumentID(String instrumentID) {
        this.instrumentID = instrumentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instrument that = (Instrument) o;
        return Double.compare(that.price, price) == 0 &&
                status == that.status &&
                Objects.equals(instrumentID, that.instrumentID) &&
                Objects.equals(name, that.name) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(instrumentID, name, price, status, startTime, endTime);
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "instrumentID='" + instrumentID + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}

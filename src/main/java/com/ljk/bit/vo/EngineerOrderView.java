package com.ljk.bit.vo;

import com.ljk.bit.entity.Orders;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class EngineerOrderView extends Orders{
    private float price;
    private String studentName;
    private String instrumentName;

    public EngineerOrderView() {
    }

    public EngineerOrderView(float price, String studentName, String instrumentName) {
        this.price = price;
        this.studentName = studentName;
        this.instrumentName = instrumentName;
    }

    public EngineerOrderView(String orderID, LocalDateTime startTime, LocalDateTime endTime, int status, String instrumentID, LocalDateTime createTime, float price, String studentName, String instrumentName) {
        super(orderID, startTime, endTime, status, instrumentID, createTime);
        this.price = price;
        this.studentName = studentName;
        this.instrumentName = instrumentName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EngineerOrderView that = (EngineerOrderView) o;
        return Float.compare(that.price, price) == 0 &&
                Objects.equals(studentName, that.studentName) &&
                Objects.equals(instrumentName, that.instrumentName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), price, studentName, instrumentName);
    }

    @Override
    public String toString() {
        return "EngineerOrderView{" +
                "price=" + price +
                ", studentName='" + studentName + '\'' +
                ", instrumentName='" + instrumentName + '\'' +
                "} " + super.toString();
    }
}

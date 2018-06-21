package com.ljk.bit.vo;

import com.ljk.bit.entity.Orders;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;
@Component
public class TutorOrderView extends Orders{
    private String studentName;
    private String instrumentName;
    private float price;

    public TutorOrderView() {
    }

    public TutorOrderView(long orderID, LocalDateTime startTime, LocalDateTime endTime, int status, String instrumentID, LocalDateTime createTime, String instrumentName, float price) {
        super(orderID, startTime, endTime, status, instrumentID, createTime);
        this.instrumentName = instrumentName;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TutorOrderView that = (TutorOrderView) o;
        return Float.compare(that.price, price) == 0 &&
                Objects.equals(studentName, that.studentName) &&
                Objects.equals(instrumentName, that.instrumentName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), studentName, instrumentName, price);
    }

    @Override
    public String toString() {
        return "TutorOrderView{" +
                "studentName='" + studentName + '\'' +
                ", instrumentName='" + instrumentName + '\'' +
                ", price=" + price +
                "} " + super.toString();
    }
}

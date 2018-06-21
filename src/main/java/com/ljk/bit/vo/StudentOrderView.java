package com.ljk.bit.vo;

import com.ljk.bit.entity.Orders;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;
@Component
public class StudentOrderView extends Orders{
    private float price;
    private String instrumentName;

    public StudentOrderView(float price, String instrumentName) {
        this.price = price;
        this.instrumentName = instrumentName;
    }

    public StudentOrderView(long orderID, LocalDateTime startTime, LocalDateTime endTime, int status, String instrumentID, LocalDateTime createTime, float price, String instrumentName) {
        super(orderID, startTime, endTime, status, instrumentID, createTime);
        this.price = price;
        this.instrumentName = instrumentName;
    }

    public StudentOrderView() {
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
        StudentOrderView that = (StudentOrderView) o;
        return Float.compare(that.price, price) == 0 &&
                Objects.equals(instrumentName, that.instrumentName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), price, instrumentName);
    }

    @Override
    public String toString() {
        return "StudentOrderView{" +
                "price=" + price +
                ", instrumentName='" + instrumentName + '\'' +
                "} " + super.toString();
    }

}

package com.ljk.bit.vo;

import com.ljk.bit.entity.Orders;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;
@Component
public class OrdersVo extends Orders{
    private String userID;
    public OrdersVo() {
    }

    public OrdersVo(long orderID, LocalDateTime startTime, LocalDateTime endTime, int status, String instrumentID, LocalDateTime createTime) {
        super(orderID, startTime, endTime, status, instrumentID, createTime);
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
        if (!super.equals(o)) return false;
        OrdersVo ordersVo = (OrdersVo) o;
        return Objects.equals(userID, ordersVo.userID);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), userID);
    }

    @Override
    public String toString() {
        return "OrdersVo{" +
                "userID='" + userID + '\'' +
                '}';
    }

}

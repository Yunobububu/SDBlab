package com.ljk.bit.service.serviceImpl;

import com.ljk.bit.dao.OrdersDao;
import com.ljk.bit.entity.Orders;
import com.ljk.bit.service.OrdersService;
import com.ljk.bit.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Service
public class OrdersServiceImpl implements OrdersService{
    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private Orders order;
    @Override
    public void insert(Orders order) {
        ordersDao.insertOrUpdate(order);
    }

    @Override
    public List<LocalDateTime> queryStartTimeList(LocalDateTime startTime, LocalDateTime endTime) {
        return ordersDao.queryStartTimeList(startTime,endTime);
    }


    @Override
    public List<Map<String, LocalDateTime>> queryOrderedMap(LocalDateTime startTime, LocalDateTime endTime) {
        return ordersDao.queryStartTimeMap(startTime,endTime);
    }
    public void insert(int day,String time,String instrumentID){

        order.setCreateTime(DateUtils.createTime());
        order.setStartTime(DateUtils.startTime(day,time));
        order.setEndTime(DateUtils.endTime(day,time));
        order.setInstrumentID(instrumentID);
        String ID = LocalTime.now().toString();
        order.setOrderID(ID);
        ordersDao.insertOrUpdate(order);
    }
    public List<Boolean> isOrdered(){
        List<LocalDateTime> orderedDates = ordersDao.queryStartTimeList(DateUtils.MonEight(),DateUtils.FriSeventeen());
        List<Boolean> isOrdered = new ArrayList<>();
        int time = 1;
        int day = 1;
        LocalDateTime now = LocalDateTime.now();
        for(;day< 6;day++){
            LocalDateTime dayNine = DateUtils.dayNine(day);
            LocalDateTime dayTen = DateUtils.dayTen(day);
            LocalDateTime dayFourteen = DateUtils.dayFourteen(day);
            LocalDateTime dayFifteen = DateUtils.dayFifteen(day);
            for(time = 1;time < 5;time++) {
                switch (time) {
                    case 1:
                        isOrdered.add(orderedDates.contains(dayNine));
                        break;
                    case 2:
                        isOrdered.add(orderedDates.contains(dayTen));
                        break;
                    case 3:
                        isOrdered.add(orderedDates.contains(dayFourteen));
                        break;
                    case 4:
                        isOrdered.add(orderedDates.contains(dayFifteen));
                        break;
                }
            }
        }
        System.out.println(isOrdered);
        return isOrdered;
    }
}

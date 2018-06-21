package com.ljk.bit.service;

import com.ljk.bit.entity.Orders;
import com.ljk.bit.vo.EngineerOrderView;
import com.ljk.bit.vo.OrdersVo;
import com.ljk.bit.vo.StudentOrderView;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public interface OrdersService {
    void insert(OrdersVo order);
    List<LocalDateTime> queryStartTimeList(LocalDateTime startTime,
                                           LocalDateTime endTime);
    List<Map<String,LocalDateTime>> queryOrderedMap(LocalDateTime startTime, LocalDateTime endTime);
    List<Boolean> isOrdered();
    List<OrdersVo> queryByUserID(String userID);
    List<StudentOrderView> studentOrderView(String userID);
    void deleteByID(String orderID);
    List<EngineerOrderView> queryOrdersInWeek(LocalDateTime startTime,LocalDateTime endTime);
    void export(String[] titles, ServletOutputStream out,String tutorID);
}

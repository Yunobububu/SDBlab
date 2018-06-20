package com.ljk.bit.service;

import com.ljk.bit.entity.Orders;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public interface OrdersService {
    void insert(Orders order);
    List<LocalDateTime> queryStartTimeList(LocalDateTime startTime,
                                           LocalDateTime endTime);
    List<Map<String,LocalDateTime>> queryOrderedMap(LocalDateTime startTime, LocalDateTime endTime);
    List<Boolean> isOrdered();
}

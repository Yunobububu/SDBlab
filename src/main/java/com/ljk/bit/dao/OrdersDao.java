package com.ljk.bit.dao;

import com.ljk.bit.entity.Orders;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component
public interface OrdersDao {
    void insertOrUpdate(@Param("order") Orders order);
    List<Map<String,LocalDateTime>> queryStartTimeMap(@Param("startTime") LocalDateTime startTime,
                                         @Param("endTime") LocalDateTime endTime);
    List<LocalDateTime> queryStartTimeList(@Param("startTime") LocalDateTime startTime,
                                                      @Param("endTime") LocalDateTime endTime);
}

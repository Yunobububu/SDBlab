package com.ljk.bit.dao;

import com.ljk.bit.entity.Orders;
import com.ljk.bit.vo.EngineerOrderView;
import com.ljk.bit.vo.OrdersVo;
import com.ljk.bit.vo.StudentOrderView;
import com.ljk.bit.vo.TutorOrderView;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component
public interface OrdersDao {
    void insertOrUpdate(@Param("order") OrdersVo order);
    List<Map<String,LocalDateTime>> queryStartTimeMap(@Param("startTime") LocalDateTime startTime,
                                         @Param("endTime") LocalDateTime endTime);
    List<LocalDateTime> queryStartTimeList(@Param("startTime") LocalDateTime startTime,
                                                      @Param("endTime") LocalDateTime endTime);
    List<OrdersVo> queryByUserID(@Param("userID") String userID);
    List<StudentOrderView> queryOrderOfStudent(@Param("studentID") String studentID);
    void deleteByOrderID(@Param("orderID") long orderID);
    List<EngineerOrderView> queryOrdersInWeek(@Param("startTime") LocalDateTime startTime,
                                              @Param("endTime") LocalDateTime endTime);
    void pass(@Param("orderID") String orderID);
    List<TutorOrderView> queryOrdersForTutor(@Param("tutorID") String tutorID);
}

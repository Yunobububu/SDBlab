package com.ljk.bit.service.serviceImpl;

import com.ljk.bit.dao.OrdersDao;
import com.ljk.bit.entity.Orders;
import com.ljk.bit.service.OrdersService;
import com.ljk.bit.util.DateUtils;
import com.ljk.bit.vo.EngineerOrderView;
import com.ljk.bit.vo.OrdersVo;
import com.ljk.bit.vo.StudentOrderView;
import com.ljk.bit.vo.TutorOrderView;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class OrdersServiceImpl implements OrdersService{
    @Autowired
    private OrdersDao ordersDao;
    @Qualifier("ordersVo")
    @Autowired
    private OrdersVo order;
    @Override
    public void insert(OrdersVo order) {
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
    public void insert(int day,String time,String instrumentID,String userID){

        order.setCreateTime(DateUtils.createTime());
        order.setStartTime(DateUtils.startTime(day,time));
        order.setEndTime(DateUtils.endTime(day,time));
        order.setInstrumentID(instrumentID);
        order.setUserID(userID);
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

    @Override
    public List<OrdersVo> queryByUserID(String userID) {
        return ordersDao.queryByUserID(userID);
    }

    @Override
    public List<StudentOrderView> studentOrderView(String userID) {
        return ordersDao.queryOrderOfStudent(userID);
    }

    @Override
    public void deleteByID(long orderID) {
        ordersDao.deleteByOrderID(orderID);
    }

    @Override
    public List<EngineerOrderView> queryOrdersInWeek(LocalDateTime startTime, LocalDateTime endTime) {
        return ordersDao.queryOrdersInWeek(startTime,endTime);
    }
    public void pass(String orderID){
        ordersDao.pass(orderID);
    }
    @Override
    public void export(String[] titles, ServletOutputStream out,String tutorID){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<TutorOrderView>  orderViews = ordersDao.queryOrdersForTutor(tutorID);
        System.out.println(orderViews);
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet hssfSheet = workbook.createSheet("预约信息");
        HSSFRow hssfRow = hssfSheet.createRow(0);
        HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
        hssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
        HSSFCell hssfCell = null;
        for(int i = 0; i < titles.length;i++){
            hssfCell = hssfRow.createCell(i);
            hssfCell.setCellValue(titles[i]);
            hssfCell.setCellStyle(hssfCellStyle);
        }

        if(orderViews != null && orderViews.size() > 0){
            for(int i = 0;i < orderViews.size();i++){
                hssfRow = hssfSheet.createRow(i + 1);
                TutorOrderView tutorOrderView = orderViews.get(i);
                String studentName = "";
                if(tutorOrderView.getStudentName() != null){
                    studentName = tutorOrderView.getStudentName();
                }
                hssfRow.createCell(0).setCellValue(studentName);
                String instrumentName = "";
                if(tutorOrderView.getInstrumentName() != null){
                    instrumentName = tutorOrderView.getInstrumentName();
                }
                hssfRow.createCell(1).setCellValue(instrumentName);

                LocalDateTime startTime = null;
                if(tutorOrderView.getStartTime() != null){
                    startTime = tutorOrderView.getStartTime();
                }
                hssfRow.createCell(2).setCellValue(df.format(startTime));

                LocalDateTime endTime = null;
                if(tutorOrderView.getEndTime() != null){
                    endTime = tutorOrderView.getEndTime();
                }
                hssfRow.createCell(3).setCellValue(df.format(endTime));

                float price = tutorOrderView.getPrice();
                hssfRow.createCell(4).setCellValue(price);

            }
            try {
                workbook.write(out);
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("导出失败");
            }
        }

    }
}

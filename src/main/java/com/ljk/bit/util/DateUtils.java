package com.ljk.bit.util;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/*
 *辅助完成日期的转换,如获取当前日期,根据星期获取当前星期的具体日期
 *
 */
public class DateUtils {
    private static LocalDate today = LocalDate.now();
    public static LocalDateTime createTime(){
        return LocalDateTime.now();
    }
    public static LocalDateTime startTime(int day,String time){
        LocalDate localDate = null;
        LocalTime localTime = LocalTime.parse(time);
        switch (day){
            case 1 :
                localDate = today.with(DayOfWeek.MONDAY);
                break;
            case 2:
                localDate = today.with(DayOfWeek.TUESDAY);
                break;
            case 3:
                localDate = today.with(DayOfWeek.WEDNESDAY);
                break;
            case 4:
                localDate = today.with(DayOfWeek.THURSDAY);
                break;
            case 5:
                localDate = today.with(DayOfWeek.FRIDAY);
                break;
            case 6:
                localDate = today.with(DayOfWeek.SATURDAY);
                break;
            case 7:
                localDate = today.with(DayOfWeek.SUNDAY);
                break;
        }
        return LocalDateTime.of(localDate,localTime);
    }
    public static LocalDateTime endTime(int day,String time){
        return startTime(day,time).plusHours(1);
    }
    public static LocalDateTime now(){
        return LocalDateTime.now();
    }
    public static LocalDateTime dayNine(int day){
        return startTime(day,"09:00:00");
    }
    public static LocalDateTime dayTen(int day){
        return startTime(day,"10:00:00");
    }
    public static LocalDateTime dayFourteen(int day){
        return startTime(day,"14:00:00");
    }
    public static LocalDateTime dayFifteen(int day){
        return startTime(day,"15:00:00");
    }
    /*
     * 返回值查看当前时间段是否过期
     */
    public static List<Boolean> isPast(){
        List<Boolean> isPast = new ArrayList<>();
        int time = 1;
        int day = 1;
        LocalDateTime now = now();
        for(;day< 6;day++){
            LocalDateTime dayNine = dayNine(day);
            LocalDateTime dayTen = dayTen(day);
            LocalDateTime dayFourteen = dayFourteen(day);
            LocalDateTime dayFifteen = dayFifteen(day);
            for(time = 1;time < 5;time++) {
                switch (time) {
                    case 1:
                        isPast.add(now.isAfter(dayNine));
                        break;
                    case 2:
                        isPast.add(now.isAfter(dayTen));
                        break;
                    case 3:
                        isPast.add(now.isAfter(dayFourteen));
                        break;
                    case 4:
                        isPast.add(now.isAfter(dayFifteen));
                        break;
                }
            }
        }
        return isPast;
    }
    public static LocalDateTime MonEight(){
        return dayNine(1).minusHours(1);
    }
    public static LocalDateTime FriSeventeen(){
        return dayFifteen(5).plusHours(2);
    }
}

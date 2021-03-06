package com.demo.demo.controller;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author ：zhengrong.liu@taotu-partner.com
 * @since ：Created in 2020/1/9 17:39
 */
public class MainTest8 {
    public static void main(String[] args) {
        List<String> list1 = getDatesByIntervalDay("2019/01/07", 6);
        List<String> list2 = getDatesByIntervalDay("2019/01/07", -7);
        System.out.println(list1);
        System.out.println(list2);


    }

    public static List<String> getDatesByIntervalDay(String time, int intervalDay) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        List<String> result = new ArrayList<>();
        try {
            Date startDate = sdf.parse(time);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            calendar.add(Calendar.DATE, intervalDay);
            Date endDate = calendar.getTime();
            String endTime = sdf.format(endDate);
            if (intervalDay < 0) {
                result = getBetweenDate(endTime, time);
            } else {
                result = getBetweenDate(time, endTime);
            }
        } catch (ParseException e) {
            //logger.error("getDatesByIntervalDay {}" + e.getMessage());
        }
        return result;
    }

    public static List<String> getBetweenDate(String startTime, String endTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        // 声明保存日期集合
        List<String> list = new ArrayList<>();
        try {
            // 转化成日期类型
            Date startDate = sdf.parse(startTime);
            Date endDate = sdf.parse(endTime);

            //用Calendar 进行日期比较判断
            Calendar calendar = Calendar.getInstance();
            while (startDate.getTime() <= endDate.getTime()) {
                // 把日期添加到集合
                list.add(sdf.format(startDate));
                // 设置日期
                calendar.setTime(startDate);
                //把日期增加一天
                calendar.add(Calendar.DATE, 1);
                // 获取增加后的日期
                startDate = calendar.getTime();
            }
        } catch (ParseException e) {
            //logger.error("getBetweenDate {}" + e.getMessage());
        }
        return list;
    }


}

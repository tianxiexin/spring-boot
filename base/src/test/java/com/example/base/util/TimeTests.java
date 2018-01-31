package com.example.base.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.*;
import java.util.Date;

/**
 * jdk8 time新特性test(不可变？怎么理解 todo)
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TimeTests {

    @Test
    public void localDateTest() {
        //now
        LocalDate now = LocalDate.now();
        System.out.println("now date is :" + now);

        //创建日期
        LocalDate localDate = LocalDate.of(2018, 1, 1);
        System.out.println("localDate of method:" + localDate);

        //时间的属性
        int year = localDate.getYear();
        Month month = localDate.getMonth();
        int dayOfMonth = localDate.getDayOfMonth();
        System.out.println("---------year month day of localDate: " + year + "-" + month.getValue() + "-" + dayOfMonth);

        //时间的解析和格式化
        LocalDate date = LocalDate.parse("2017-01-21");
        LocalTime time = LocalTime.parse("13:45:20");
        System.out.println("格式化的date：" + date + "  time:" + time);

        //合并日期和时间
        LocalDateTime localDateTime = LocalDateTime.of(2015, 3, 20, 13, 10, 10);
        System.out.println("localDateTime:" + localDateTime);
        LocalDateTime localDateAddTime = localDate.atTime(time);
        System.out.println("localDateAddTime:" + localDateAddTime);

        //指定年的指定天数
        LocalDate hundredDay2014 = LocalDate.ofYearDay(2014, 100);
        System.out.println("100th day of 2014=" + hundredDay2014);
    }

    @Test
    public void localTimeTest() {
        //Current Time
        LocalTime time = LocalTime.now();
        System.out.println("Current Time="+time);

        //指定时间
        LocalTime specificTime = LocalTime.of(12,20,25,40);
        System.out.println("Specific Time of Day="+specificTime);
    }

    @Test
    public void localDateTimeTest() {
        //Current Date
        LocalDateTime today = LocalDateTime.now();
        System.out.println("Current DateTime="+today);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        System.out.println("localDateTime :"+ localDateTime);
    }

    //todo 有疑问
    @Test
    public void instantTest() {
        OffsetDateTime instant = Instant.now().atOffset(ZoneOffset.ofHours(8));
        System.out.println("Current Timestamp = "+instant);
        Instant timestamp2 = Instant.ofEpochMilli(new Date().getTime());
        System.out.println("Current Timestamp2 = "+timestamp2);
    }

}

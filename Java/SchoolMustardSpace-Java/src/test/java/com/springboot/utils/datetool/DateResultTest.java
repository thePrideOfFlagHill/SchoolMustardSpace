package com.springboot.utils.datetool;

import org.junit.Assert;
import org.junit.Test;
import com.springboot.utils.datetool.DateResult;
import org.junit.runner.RunWith;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;


/**
 * @author 会飞的大野鸡
 * @create 2020/5/6
 * TODO:
 */


public class DateResultTest {

    @Test
    public void getCurrentTime() {
        DateResult dateResult = new DateResult();
        String time = dateResult.getCurrentTime();

        SimpleDateFormat ct = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String systemTime = ct.format(new Date());

        Assert.assertEquals(time , systemTime);
    }

    @Test
    public void getBetweenDay() {
        Date date1 = new Date(2020-1900 , 6-1 , 12);
        Date date2 = new Date(2020-1900 , 6-1 , 13);
        int count = new DateResult().getBetweenDay(date1 , date2);
        Assert.assertEquals(1 , count);

        Date date3 = new Date(2020-1900 , 12-1 , 14);
        Date date4 = new Date(2020-1900 , 7-1 , 7);
        int count1 = new DateResult().getBetweenDay(date3 , date4);
        Assert.assertEquals(-160 , count1);
    }

    @Test
    public void moveTime() {
        Date date1 = new Date(2020-1900 , 7-1 , 14);
        Date test = new Date(2020-1900 , 12-1 , 14);

        Assert.assertEquals(test , new DateResult().moveTime(date1,153));
    }
}

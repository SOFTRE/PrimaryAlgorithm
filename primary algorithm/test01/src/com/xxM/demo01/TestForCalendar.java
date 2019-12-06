package com.xxM.demo01;

import java.util.Calendar;

/**
 * @Program: IntelliJ IDEA test
 * @Description: TODO
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-11-27 13:05:17 周三
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: V1.0
 */
public class TestForCalendar {
    public static void main(String[] args) {
        Calendar calendar=Calendar.getInstance();
        //本月的最后一天
        System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(12));
        System.out.println(calendar.getTimeInMillis());
        //昨日的时间
        calendar.add(Calendar.DATE,-1);
        System.out.println(calendar.getTime());
    }
}

package com.tan.tools.test;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName DataUtilTest
 * @Description TODO
 * @Author Tan.li
 * @Date 2020-09-15
 * @Since 1.0
 */
public class DataUtilTest {


    public static Date getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    public static Date getFirstDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.MONTH, -1);
        return cal.getTime();
    }

    public static String format(java.util.Date date, String format) {
        String result = "";
        try {
            if (date != null) {
                java.text.DateFormat df = new java.text.SimpleDateFormat(format);
                result = df.format(date);
            }
        } catch (Exception e) {
        }
        return result;
    }
    public static String format1(java.util.Date date) {
        if(null!=date){
            return format(date, "yyyy-MM-dd");
        }
        return null;
    }
    public static int getMonth(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(java.util.Calendar.MONTH) + 1;
    }
    /**
     * 日期月份相加减
     * @param date 具体的时间
     * @param month 相加减的月份
     * @return 处理后的时间
     */
    public static Date addMonth(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

    public static int getYear(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(java.util.Calendar.YEAR);
    }

    @Test
    public void testDate(){
       System.out.println( format1(getFirstDayOfMonth(2020,8)));
        System.out.println(format1(getLastDayOfMonth(2020,8)));
        System.out.println(getMonth(new Date()));
        System.out.println(getMonth(addMonth(new Date(),-1)));
        System.out.println(format1(addMonth(new Date(),-1)));
        System.out.println(getYear(new Date()));

        System.out.println(format1(addMonth(new Date(),-1)));
    }

}

package com.tan.tools.test;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName DataGrid
 * @Description TODO
 * @Author Tan.li
 * @Date 2020-09-08
 * @Since 1.0
 */
public class DataGrid {


    public static Date getFirstDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.MONTH, -1);
        return cal.getTime();
    }

    @Test
    public void testDate() {
        try {
            Date dt = getFirstDayOfMonth(Integer.parseInt("2020"), Integer.parseInt("08")); //fastDay     f
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(sdf.format(dt));
            Date date = sdf.parse("2020-09-01");    //锁
            System.out.println(sdf.format(date));
            System.out.println(date.equals(dt));
            if (-1 != date.compareTo(dt) || date.equals(dt)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    @Test
    public void testBeforeDate() {
        try {
            Date dt = getFirstDayOfMonth(Integer.parseInt("2020"), Integer.parseInt("09")); //fastDay     f
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(sdf.format(dt));
            Date date = sdf.parse("2020-09-01");    //锁
            System.out.println(sdf.format(date));
            if (date.before(dt)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

    }
    @Test
    public void testAfterDate() {
        try {
            Date dt = getFirstDayOfMonth(Integer.parseInt("2020"), Integer.parseInt("09")); //fastDay     f
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(sdf.format(dt));
            Date date = sdf.parse("2020-09-01");    //锁
            System.out.println(sdf.format(date));
            if (date.after(dt)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    @Test
    public  void testDateEquals(){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dt = sdf.parse("2020-09-01");
            Date dt2 = sdf.parse("2020-09-01");
            System.out.println(dt.equals(dt2));
        }catch (Exception e){

        }

    }


}

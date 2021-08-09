package cn.tanli.test.vo;/**
 * cn.tanli.test.vo
 *
 * @author Tan.li
 * @date 2021/7/16
 */

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *@ClassName Test
 *@Description TODO
 *@Author Tan.li
 *@Date 2021/7/16
 *@Since 1.0
 */
public class Test {



    @org.junit.Test
    public  void testCodeTime(){
        System.out.println(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long lon=Long.parseLong("1626078339000");
        System.out.println(sdf.format(new Date(lon)));
    }
    
    @org.junit.Test
    public void testPaserInt(){
        System.out.println(Double.parseDouble("910.73"));
    }

}

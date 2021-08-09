package cn.tanli.test.vo;/**
 * cn.tanli.test.vo
 *
 * @author Tan.li
 * @date 2021/7/26
 */

import org.junit.Test;

/**
 *@ClassName BastTestCode
 *@Description TODO
 *@Author Tan.li
 *@Date 2021/7/26
 *@Since 1.0
 */
public class BastTestCode {


    @Test
    public void testSpit(){

        String dt= "AAA,BBB";
       String[] ss= dt.split(",");
        for (String str:ss) {
            System.out.println(str);
        }
    }

}

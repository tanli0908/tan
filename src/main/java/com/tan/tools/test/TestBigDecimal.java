package com.tan.tools.test;

import org.junit.Test;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @ClassName TestBigDe
 * @Description TODO
 * @Author Tan.li
 * @Date 2020-11-16
 * @Since 1.0
 */
public class TestBigDecimal {


    public static void main(String[] args) {

        BigDecimal saleAmount=BigDecimal.valueOf(414);
        BigDecimal mallBillingAmount=BigDecimal.valueOf(26622.42);
        BigDecimal systemSalesAmount=BigDecimal.valueOf(23151.79);
        BigDecimal sss=(saleAmount.multiply(mallBillingAmount)).divide(systemSalesAmount,2,BigDecimal.ROUND_HALF_UP);
        System.out.println(sss);



        BigDecimal countBigDecimal=BigDecimal.valueOf(26622.42);
        BigDecimal size1BigDecimal=BigDecimal.valueOf(4987.10);
        BigDecimal size2BigDecimal=BigDecimal.valueOf(479.98);

        BigDecimal countSize=size1BigDecimal.add(size2BigDecimal);
        System.out.println(countSize);
        System.out.println(countBigDecimal.subtract(countSize));



    }
    @Test
    public  void testTc(){

        //销售金额*商场开票金额/系统收入
        BigDecimal saleAmount=BigDecimal.valueOf(16);
        BigDecimal mallBillingAmount=BigDecimal.valueOf(43815.21);
        BigDecimal systemSalesAmount=BigDecimal.valueOf(85763);
        BigDecimal sss=(saleAmount.multiply(mallBillingAmount)).divide(systemSalesAmount,2,BigDecimal.ROUND_HALF_UP);
        System.out.println(sss);
    }
}

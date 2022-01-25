package com.tan.test;


import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName JunitTest
 * @Description TODO
 * @Author tanli
 * @Date 2022/1/6
 * @Since 1.0
 */
public class JunitTest {

    @Test
    public void testConct(){
        String sst="'Z0029','Z0031','Z0032','Z0067','Z0065','Z0033','Z0050','B0099','B0013','B0014','B0015','Z0011','Z0012','B0018','Z0024','Z0025','Z0002','Z0026','Z0027','B0021','B0022','Z0001','Z0003','Z0004','I0007','F0007','Z0008','Z0007','B0025'";

        boolean cc= sst.contains("0001");
        System.out.println(cc);

       List<String> ls= Arrays.asList(sst.replaceAll("'","").split(","));
        System.out.println(ls.contains("0001"));

    }
    
    @Test
    public void testVoid(){
       BigDecimal ssd=BigDecimal.valueOf(0);
        System.out.println( ssd.setScale(2,BigDecimal.ROUND_HALF_UP));
    }
    
    @Test
    public void testConcat(){
        System.out.println("x".concat(null).concat(";"));
    }
    
    @Test
    public void testMap(){
        Map<String,String> s=new HashMap<String,String>();
        s.put("1","1");
        s.put("2","2");
        String cs="c_z";
        cs=s.get("3");
        System.out.println(cs);
        
    }
}


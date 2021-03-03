package com.tan.tools.test;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName TestMap
 * @Description TODO
 * @Author Tan.li
 * @Date 2020-09-27
 * @Since 1.0
 */
public class TestMap {

    @Test
    public void testCoamp(){

        ArrayList list=new ArrayList(Arrays.asList(new Integer[]{2,12,33,34}));
        System.out.println("===True==="+list.indexOf(2)+"========"+list.indexOf(5));
        list.forEach(a->{
            System.out.println(a);
        });

        System.out.println("===============");
        List<Integer> intlist=Arrays.asList(new Integer[]{2,33});
        list.removeAll(intlist);
        list.forEach(ist->{
            System.out.println(ist);
        });

    }

    @Test
    public void testString(){
        String[] ss={"1","2","3","4","5","6"};
        String[] ss2={"2","4"};
        List<String> ssl=new ArrayList<>(Arrays.asList(ss));
        List<String> ssl2=new ArrayList<>(Arrays.asList(ss2));
        ssl.removeAll(ssl2);
        System.out.println(ssl.toString());
    }

    @Test
    public void testTTD(){
     Double b=  Double.valueOf(0);
     System.out.println(b);
    }


    @Test
    public void testC1(){
       System.out.println(String.format("IC-生成成本-批次插入数据- 总共:%s 条,开始时间:%s",12));
    }
}

package com.tan.test;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ListTestAddAll
 * @Description TODO
 * @Author Tan.li
 * @Date 2021/9/16
 * @Since 1.0
 */
public class ListTestAddAll {

    @Test
    public void test(){
        List<String> list=new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        List<String> list1=null;
        list1.addAll(list);
        list1.forEach((i)->{System.out.println(i);}

                );
        System.out.println();
    }
}

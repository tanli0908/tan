package com.tan.tools.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MapTest
 * @Description TODO
 * @Author Tan.li
 * @Date 2021-03-09
 * @Since 1.0
 */
public class MapTest {

    public static void main(String[] args) {
        Map map = new HashMap();       //定义Map对象
        map.put("apple", "新鲜的苹果");      //向集合中添加对象
        map.put("computer", "配置优良的计算机");
        //map.put("book", "堆积成山的图书");
        map.put("bookZ1", "堆积成山的图书2");
        map.put("time", new Date());
        String key = "book";
        boolean contains = map.containsKey(key);    //判断是否包含指定的键值
        if (contains) {         //如果条件为真
            System.out.println("在Map集合中包含键名" + key); //输出信息
        } else {
            System.out.println("在Map集合中不包含键名" + key);
        }
    }

}

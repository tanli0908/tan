package com.tan.test;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @ClassName RunableTest
 * @Description TODO
 * @Author Tan.li
 * @Date 2021/9/17
 * @Since 1.0
 */
public class RunableTest {

    public static void main(String[] args) {
        try {
            System.out.println("RunableTest.main");
            List<List<String>> ls = new ArrayList<List<String>>();
            ExecutorService executor = Executors.newFixedThreadPool(2);
            for (int i = 0; i <= 100; i++) {
                Future<List<String>> ss = executor.submit(new MyTask(i));
                ls.add(ss.get());
            }
            for (int i = 101; i <= 150; i++) {
                Future<List<String>> ss = executor.submit(new MyTask(i));
                ls.add(ss.get());
            }
            executor.shutdown();
            for (List<String> l : ls) {
                for (String s : l) {
                    System.out.println("RunableTest.main" + s);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }

    }


}

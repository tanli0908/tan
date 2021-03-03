package com.tan.tools.test;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName SimpleThread
 * @Description TODO
 * @Author Tan.li
 * @Date 2020-09-15
 * @Since 1.0
 */
public class SimpleThread {

    public class Souprint extends Thread implements Runnable {

        private Integer sysPint;

        public Souprint(Integer pint) {
            this.sysPint = pint;
        }

        @Override
        public void run() {

            try {
                System.out.println("参数："+sysPint + "线程打印 ThreadName:"+Thread.currentThread().getName()+" ID:"+Thread.currentThread().getId());
                Thread.sleep(3);
                System.out.println("休眠后 线程打印 ThreadName:"+Thread.currentThread().getName()+" ID:"+Thread.currentThread().getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void testThead() {
        //创建一个线程池
        ExecutorService exe = Executors.newFixedThreadPool(4);
        String[] str = new String[]{"1", "2", "3", "4"};
        for (String s : str) {
            int sssss = Integer.parseInt(s);
            System.out.println(sssss);
            exe.execute(new Thread(new Souprint(sssss)));
        }
        exe.shutdown();
    }
}

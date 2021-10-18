package cn.tanli;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName TheadTest
 * @Description TODO
 * @Author Tan.li
 * @Date 2021/8/23
 * @Since 1.0
 */
public class TheadTest  implements Runnable{

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Thread.currentThread().setName("线程名字:"+i);
            System.out.println(Thread.currentThread().getName()+"=============="+i);
        }
    }


    public static void main(String[] args) throws  Exception{
        ExecutorService executorService= Executors.newFixedThreadPool(30);
        executorService.execute(new TheadTest());
        executorService.shutdown();
        System.out.println("处理线程结束");
        executorService.awaitTermination(1000000, TimeUnit.HOURS);
    }


}

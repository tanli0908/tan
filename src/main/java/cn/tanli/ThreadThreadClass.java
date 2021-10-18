package cn.tanli;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadThreadClass
 * @Description TODO
 * @Author Tan.li
 * @Date 2021/8/23
 * @Since 1.0
 */
public class ThreadThreadClass  extends  Thread{

    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     * @see #Thread(ThreadGroup, Runnable, String)
     */
    @Override
    public void run() {
        Thread.currentThread().setName("TS:"+"形式");
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"======"+i);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        executorService.execute(new ThreadThreadClass());
        executorService.shutdown();
        System.out.println("线程处理完毕");
        executorService.awaitTermination(1, TimeUnit.HOURS);

    }
}

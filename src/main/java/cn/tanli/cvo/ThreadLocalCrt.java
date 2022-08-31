package cn.tanli.cvo;


/**
 * @ClassName ThreadLocal
 * @Description TODO
 * @Author tanli
 * @Date 2022/5/7
 * @Since 1.0
 */
public class ThreadLocalCrt {

    
    /***
     * @MethodName 
     * @param    
     * @return  
     * @Author tanli
     * @Date 2022/5/9 16:55
     * @throws
     * @Description TODO  请描述方法功能 
     */
    static ThreadLocal<String> localVar = new ThreadLocal<>();

    static void print(String str) {
        //打印当前线程中本地内存中本地变量的值
        System.out.println(str + " :" + localVar.get());
        Thread.currentThread().setName("Thread===="+str);
        //清除本地内存中的本地变量
        localVar.remove();
    }


    public static void main(String[] args) {


        
        Thread t1  = new Thread(new Runnable() {
            @Override
            public void run() {
                //设置线程1中本地变量的值
                localVar.set("localVar1");
                //调用打印方法
                print("thread1");
                //打印本地变量
                System.out.println("after remove : " + localVar.get());
                System.out.println("Thread name: " + Thread.currentThread().getName());
                
                

            }
        });

        Thread t2  = new Thread(new Runnable() {
            @Override
            public void run() {
                //设置线程1中本地变量的值
                localVar.set("localVar2");
                //调用打印方法
                print("thread2");
                //打印本地变量
                System.out.println("after remove : " + localVar.get());
                System.out.println("Thread name: " + Thread.currentThread().getName());
            }
        });

        t1.start();
        t2.start();
    }
}

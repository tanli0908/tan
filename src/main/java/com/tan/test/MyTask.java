package com.tan.test;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @ClassName MyTask
 * @Description TODO
 * @Author Tan.li
 * @Date 2021/9/17
 * @Since 1.0
 */
public class MyTask implements Callable<List<String>> {

    int sx=0;
    MyTask(int i){
        this.sx=i;
    }
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public List<String> call() throws Exception {
        List<String> l=new ArrayList<>();
        l.add("11==="+this.sx+"===new Date"+new SimpleDateFormat("y-M-d h:m:ss").format(new Date()));
        Thread.sleep(100);
        return l;
    }
}

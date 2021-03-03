package com.tan.tools;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class TanToolsApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    public void testContinue(){
        int i=0;
        while (i<20){
            i++;
            if(i==5){
                continue;
            }
            System.out.println("打印:"+i);

        }
    }
    @Test
    public void testBreak(){
        int i=0;
        while (i<20){
            i++;
            if(i==5){
                break;
            }
            System.out.println("打印:"+i);
        }
    }
    @Test
    public void testReturn(){
        int i=0;
        while (i<20){
            i++;
            if(i==5){
                return;
            }
            System.out.println("打印:"+i);
        }
    }
}

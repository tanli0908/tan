package cn.tanli.codecraft;


import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JavaTime
 * @Description TODO
 * @Author tanli
 * @Date 2022/4/20
 * @Since 1.0
 */
public class JavaTime {

    public static void main(String[] args) {
        List<String> ls=new ArrayList<>();
        ls.add("1");
        ls.add("2");
        ls.add("3");
        ls.add("4");
        for (String str:ls) {
            if(str.equals("1")) {
                try {
                    Thread.sleep(10000);
                    System.out.println("XXX"+str);
                } catch (Exception e) {

                }
            }else{
                System.out.println(str);
            }
            
        }
    }

}

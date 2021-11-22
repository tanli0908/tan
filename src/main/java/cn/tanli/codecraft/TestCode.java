package cn.tanli.codecraft;


import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @ClassName TestCode
 * @Description TODO
 * @Author Mr.Tan
 * @Date 2021/11/15
 * @Since 1.0
 */
public class TestCode {


    public static void main(String[] args){
        String slist="OS26,秒杀小程序,OS26,秒杀小程序,OS26,秒杀小程序,OS26,秒杀小程序,OS26,秒杀小程序,OS26,秒杀小程序,OS26,秒杀小程序,OS26,秒杀小程序,OS26,秒杀小程序,OS26,秒杀小程序,OS26,秒杀小程序,OS26,秒杀小程序,OS26,秒杀小程序,OS26,秒杀小程序,OS26,秒杀小程序,OS26,秒杀小程序,OS26,秒杀小程序,OS26,秒杀小程序,OS26,秒杀小程序,OS26,秒杀小程序,OS26,秒杀小程序,OS26,秒杀小程序,OS26,秒杀小程序";
//        List<String> ls= Arrays.asList(slist.split(","));
//        List<String> lc= ls.stream().distinct().collect(Collectors.toList());
//       String sss= lc.stream().collect(Collectors.joining(","));
//        System.out.println(sss);
        System.out.println(StringDistinct(""));


    }

    public static String StringDistinct(String ss) {
        String tempRek=  Arrays.asList(ss.split(",")).stream().distinct().collect(Collectors.joining(","));
        return tempRek;
    }
}

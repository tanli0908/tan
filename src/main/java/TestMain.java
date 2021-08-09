import cn.tanli.test.vo.BaseTest;
import cn.tanli.test.vo.Person;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName TestMain
 * @Description TODO
 * @Author Tan.li
 * @Date 2021-01-08
 * @Since 1.0
 */
public class TestMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Person p1 = new Person();
        p1.setId(1);
        p1.setCode("I00001");
        p1.setName("编号I00001");
        p1.setAge(12);
        p1.setReson("测试数据");
        p1.setCost(BigDecimal.valueOf(Double.parseDouble("120.111")));

        Person p2 = new Person();
        p2.setId(2);
        p2.setCode("I00001");
        p2.setName("编号I00002");
        p2.setAge(22);
        p2.setReson("测试数据2");
        p2.setCost(BigDecimal.valueOf(Double.parseDouble("122.111")));

        Person p3 = new Person();
        p3.setId(3);
        p3.setCode("I00002");
        p3.setName("编号I00002");
        p3.setAge(32);
        p3.setReson("测试数据3");
        p3.setCost(BigDecimal.valueOf(Double.parseDouble("126.111")));


        List<Person> list = new ArrayList<Person>();
        list.add(p1);
        list.add(p2);
        list.add(p3);


        for (Person pe : list) {
            System.out.println(pe.toString());
        }


        System.out.println("===============================");

        List<Person> list2 = new ArrayList<Person>();
        list.stream().collect(Collectors.groupingBy(Person::getName, Collectors.toList())).forEach((code, listByName) -> {
            list2.add(listByName.get(0));
        });

        for (BaseTest pe : list2) {
            System.out.println(pe.toString());
        }

        System.out.println("===============================");
        for (Person pe : list) {
            System.out.println(pe.toString());
        }


        System.out.println("===============================");

        Map<String, List<Person>> ml = list.stream().collect(Collectors.groupingBy(Person::getCode));

        Map<String, Double> mapage=new HashMap<>();
        ml.forEach((key,value)->{
            double age=  value.stream().collect(Collectors.averagingDouble(Person-> Person.getAge()));
//            double costsun=value.stream().mapToDouble(Person->Person.getCost().doubleValue()).sum();

            int  countAge= value.stream().mapToInt(Person->Person.getAge()).sum();
            BigDecimal costsun=BigDecimal.ZERO;
            for (Person p: value) {
                BigDecimal sb=p.getCost().multiply(BigDecimal.valueOf(p.getAge()));
                System.out.println("===sb==="+sb);
                costsun=costsun.add(sb);
            }

            System.out.println("===costsun==="+costsun);

           double sss= costsun.divide(BigDecimal.valueOf(2)).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
            System.out.println(key+"=========age:"+age+"=====countAge:"+countAge+"====costsun:"+costsun+"===sss:"+sss);
            mapage.put(key,age);
        });



       /* List<Person>  listdesc=new ArrayList<>();
        CollectionUtils.addAll(listdesc,new Person[list.size()]);
        Collections.copy(listdesc,list);


        List<Person>  listXx=new ArrayList<>();

        listdesc.stream().collect(Collectors.groupingBy(Person::getCode,Collectors.toList())).forEach((a,person)->{
            Person p= person.get(0);
            double sa=mapage.get(p.getCode());
            p.setAge((int) sa);
            listXx.add(p);
        });

        System.out.println("=listXx========================");
        listXx.forEach(obj->{
            System.out.println("===obj==="+obj.toString());
        });
        System.out.println("===list======================");
        list.forEach(obj->{
            System.out.println(obj.toString());
        });
*/





    }


    //关键代码 运行序列化和反序列化  进行深度拷贝
    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }

}

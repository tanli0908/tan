package cn.tanli.lambda;


import cn.tanli.test.vo.Uto;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName ListToMap
 * @Description TODO
 * @Author tanli
 * @Date 2022/4/20
 * @Since 1.0
 */
public class ListToMap {
    
    List<Uto> list=new ArrayList<Uto>();
    
    @Before
    public void init(){
        Uto to1=new Uto("1","张三");
        Uto to2=new Uto("2","李四");
        Uto to3=new Uto("3","王五");
        list.add(to1);list.add(to3);list.add(to2);
    }
    

    @Test
    public void testListToMap(){
      Map<String,String> map=  list.stream().collect(Collectors.toMap(Uto->{
            String s = Uto.getId().concat(",").concat(Uto.getName());
            return s;
            
        },Uto->{
            String s = Uto.getId() + Uto.getName();
            return s;

        }));
        System.out.println("===="+list.size());
        System.out.println(map.get("1,张三"));
        if(map.containsKey("1,张三")){
            System.out.println("true");
        }
        
    }
}

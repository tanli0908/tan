package com.tan.test;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TestMapKey
 * @Description TODO
 * @Author tanli
 * @Date 2022/3/7
 * @Since 1.0
 */
public class TestMapKey {

    /**
     * 我地图
     */
    public static Map<String, String> MY_MAP=new HashMap<>();

    /**
     * 测试ccmap
     */
    @Test
    public void testCCMap() {
        
            //特殊大区处理
//             Map<String, String> MY_MAP = new HashMap<String, String>();
            MY_MAP.put("U010101_Z1", "U010101_Z");

            MY_MAP.put("U010101_0", "U010101_Z");
            MY_MAP.put("U010101_1", "U010101_Z");
            MY_MAP.put("U010101_2", "U010101_Z");
            MY_MAP.put("U010101_3", "U010101_Z");
            MY_MAP.put("U010101_4", "U010101_Z");
            MY_MAP.put("U010101_5", "U010101_Z");
            MY_MAP.put("U010101_6", "U010101_Z");
            MY_MAP.put("U010101_7", "U010101_Z");
            MY_MAP.put("U010101_8", "U010101_Z");
            MY_MAP.put("U010101_9", "U010101_Z");
            MY_MAP.put("U010101_10", "U010101_Z");


            MY_MAP.put("U010105_V", "U010105_B");
            MY_MAP.put("U010105_P", "U010105_B");
            MY_MAP.put("U010105_O", "U010105_B");
            MY_MAP.put("U010105_U", "U010105_B");
            //新增中区
            MY_MAP.put("U010105_BZ", "U010105_B");
            MY_MAP.put("U010105_Y", "U010105_B");

            MY_MAP.put("U010105_1", "U010105_B");
            MY_MAP.put("U010105_2", "U010105_B");
            MY_MAP.put("U010105_3", "U010105_B");
            MY_MAP.put("U010105_4", "U010105_B");


            String keyA="U010101_7";
         System.out.println(MY_MAP.containsKey(keyA));
        if (MY_MAP.containsKey(keyA)) {
            System.out.println(MY_MAP.get(keyA));
        }
            
            
            
        
    }
}

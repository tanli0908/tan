package com.tan.tools.controller;

import com.tan.tools.entity.SqlData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName sqlSelectController
 * @Description TODO
 * @Author Tan.li
 * @Date 2021-03-03
 * @Since 1.0
 */
@RestController
@RequestMapping("sqlSelectController")
public class sqlSelectController {

    @PostMapping("testCode")
    @ResponseBody
    public Map<String,Object> testCode(@RequestBody SqlData sqlData){
        System.out.println("=========聊聊====");
        Map<String, Object> map=new HashMap<>();
        map.put("key","2");
        map.put("key1","3");
        map.put("key2","4");
        return map;

    }


}

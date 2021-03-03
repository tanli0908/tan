package com.tan.tools.controller;

import com.tan.tools.service.SqlLogService;
import com.tan.tools.entity.Sqllog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName LogController
 * @Description TODO
 * @Author Tan.li
 * @Date 2020-09-01
 * @Since 1.0
 */
@RestController
@RequestMapping("logController")
public class LogController {
    @Autowired
    private SqlLogService sqlLogService;

    @PostMapping("insertSqlLog")
    @ResponseBody
    public void insertSqlLog(@RequestBody  Sqllog sqllog) {
            this.saveLog(sqllog);
    }

    @GetMapping("selectAlllog")
    public List<Sqllog> selectAlllog(){
        return sqlLogService.selectAlllog();
    }

    @Async
    public void saveLog(Sqllog sqllog){
        sqlLogService.insertSqlLog(sqllog);
    }
}

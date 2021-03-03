package com.tan.tools.service;

import com.tan.tools.entity.Sqllog;
import java.util.List;

/**
 * @InterfaceName SqlLogService
 * @Description TODO
 * @Author Tan.li
 * @Date 2020-09-01
 * @Since 1.0
 */
public interface SqlLogService {

     void insertSqlLog(Sqllog Sqllog);


    List<Sqllog> selectAlllog();
}

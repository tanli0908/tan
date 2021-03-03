package com.tan.tools.service;

import com.tan.tools.dao.SqllogDao;
import com.tan.tools.entity.Sqllog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SqlLogServiceImpl
 * @Description TODO
 * @Author Tan.li
 * @Date 2020-09-01
 * @Since 1.0
 */
@Service("sqlLogService")
public class SqlLogServiceImpl implements  SqlLogService{

    @Autowired
    SqllogDao sqllogDao;

    @Override
    public void insertSqlLog(Sqllog sqllog) {
        sqllogDao.insertSelective(sqllog);

    }

    @Override
    public List<Sqllog> selectAlllog() {
        return sqllogDao.selectAlllog();
    }
}

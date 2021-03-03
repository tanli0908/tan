package com.tan.tools.dao;

import com.tan.tools.entity.Sqllog;

import java.util.List;


public interface SqllogDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Sqllog record);

    int insertSelective(Sqllog record);

    Sqllog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sqllog record);

    int updateByPrimaryKey(Sqllog record);

    List<Sqllog> selectAlllog();
}
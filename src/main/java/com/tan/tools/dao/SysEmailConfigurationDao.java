package com.tan.tools.dao;

import com.tan.tools.entity.SysEmailConfiguration;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 邮箱配置表(SysEmailConfiguration)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-10 15:56:05
 */
public interface SysEmailConfigurationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysEmailConfiguration queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysEmailConfiguration> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysEmailConfiguration 实例对象
     * @return 对象列表
     */
    List<SysEmailConfiguration> queryAll(SysEmailConfiguration sysEmailConfiguration);

    /**
     * 新增数据
     *
     * @param sysEmailConfiguration 实例对象
     * @return 影响行数
     */
    int insert(SysEmailConfiguration sysEmailConfiguration);
    
    /**
     * 选择新增数据
     *
     * @param sysEmailConfiguration 实例对象
     * @return 影响行数
     */
    int insertSelective(SysEmailConfiguration sysEmailConfiguration);

    /**
     * 修改数据
     *
     * @param sysEmailConfiguration 实例对象
     * @return 影响行数
     */
    int update(SysEmailConfiguration sysEmailConfiguration);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}
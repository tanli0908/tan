package com.tan.tools.service;

import com.tan.tools.entity.SysEmailConfiguration;
import java.util.List;

/**
 * 邮箱配置表(SysEmailConfiguration)表服务接口
 *
 * @author makejava
 * @since 2020-09-10 15:56:05
 */
public interface SysEmailConfigurationService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysEmailConfiguration queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysEmailConfiguration> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysEmailConfiguration 实例对象
     * @return 实例对象
     */
    SysEmailConfiguration insert(SysEmailConfiguration sysEmailConfiguration);

    /**
     * 修改数据
     *
     * @param sysEmailConfiguration 实例对象
     * @return 实例对象
     */
    SysEmailConfiguration update(SysEmailConfiguration sysEmailConfiguration);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
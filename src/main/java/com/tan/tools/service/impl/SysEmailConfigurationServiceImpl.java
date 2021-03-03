package com.tan.tools.service.impl;

import com.tan.tools.entity.SysEmailConfiguration;
import com.tan.tools.dao.SysEmailConfigurationDao;
import com.tan.tools.service.SysEmailConfigurationService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * 邮箱配置表(SysEmailConfiguration)表服务实现类
 *
 * @author makejava
 * @since 2020-09-10 15:56:05
 */
@Service("sysEmailConfigurationService")
public class SysEmailConfigurationServiceImpl implements SysEmailConfigurationService {
    @Autowired
    private SysEmailConfigurationDao sysEmailConfigurationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysEmailConfiguration queryById(Integer id) {
        return this.sysEmailConfigurationDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysEmailConfiguration> queryAllByLimit(int offset, int limit) {
        return this.sysEmailConfigurationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysEmailConfiguration 实例对象
     * @return 实例对象
     */
    @Override
    public SysEmailConfiguration insert(SysEmailConfiguration sysEmailConfiguration) {
        this.sysEmailConfigurationDao.insert(sysEmailConfiguration);
        return sysEmailConfiguration;
    }

    /**
     * 修改数据
     *
     * @param sysEmailConfiguration 实例对象
     * @return 实例对象
     */
    @Override
    public SysEmailConfiguration update(SysEmailConfiguration sysEmailConfiguration) {
        this.sysEmailConfigurationDao.update(sysEmailConfiguration);
        return this.queryById(sysEmailConfiguration.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.sysEmailConfigurationDao.deleteById(id) > 0;
    }
}
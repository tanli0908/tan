package com.tan.tools.controller;

import com.tan.tools.entity.SysEmailConfiguration;
import com.tan.tools.service.SysEmailConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 邮箱配置表(SysEmailConfiguration)表控制层
 *
 * @author makejava
 * @since 2020-09-10 15:56:05
 */
@RestController
@RequestMapping("sys_email_configuration")
public class SysEmailConfigurationController {


    /**
     * 服务对象
     */
    @Autowired
    private SysEmailConfigurationService sysEmailConfigurationService;


   /**
     * 跳转list页面
     *
     */ 
    @RequestMapping(value = "/list")
	public String list() {
		return   "sys_email_configuration/list";
	}
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysEmailConfiguration selectOne(Integer id) {
        return  sysEmailConfigurationService.queryById(id);
    }
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @PostMapping("queryAllByLimit")
    @ResponseBody
    public List<SysEmailConfiguration> queryAllByLimit(@RequestParam("offset")  int offset,@RequestParam("limit") int limit){
        return sysEmailConfigurationService.queryAllByLimit(offset,limit);
    }
    
    /**
     * 新增数据
     *
     * @param sysEmailConfiguration 实例对象
     * @return 实例对象
     */
    @PostMapping("insert")
    @ResponseBody
    public SysEmailConfiguration insert(SysEmailConfiguration sysEmailConfiguration){
        return sysEmailConfigurationService.insert(sysEmailConfiguration);
    }

    /**
     * 修改数据
     *
     * @param sysEmailConfiguration 实例对象
     * @return 实例对象
     */
    @PostMapping("update")
    @ResponseBody
    public SysEmailConfiguration update(SysEmailConfiguration sysEmailConfiguration){
        return sysEmailConfigurationService.update(sysEmailConfiguration);
    }



}
package com.tan.tools.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 邮箱配置表(SysEmailConfiguration)实体类
 *
 * @author makejava
 * @since 2020-09-10 15:56:05
 */
public class SysEmailConfiguration implements Serializable {
    private static final long serialVersionUID = 601244220342177992L;
    
    /**
    * 主键ID
    */
    private Integer id;
    /**
    * 品牌部编号
    */
    private String brandUnitNo;
    /**
    * 品牌部名称
    */
    private String brandUnitName;
    /**
    * 邮箱地址
    */
    private String emailAddr;
    /**
    * 1.启用 0.禁用
    */
    private Integer status;
    /**
    * 备注
    */
    private String remark;
    /**
    * 建档人
    */
    private String createUser;
    /**
    * 建档时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;
    /**
    * 修改人
    */
    private String updateUser;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandUnitNo() {
        return brandUnitNo;
    }

    public void setBrandUnitNo(String brandUnitNo) {
        this.brandUnitNo = brandUnitNo;
    }

    public String getBrandUnitName() {
        return brandUnitName;
    }

    public void setBrandUnitName(String brandUnitName) {
        this.brandUnitName = brandUnitName;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

}
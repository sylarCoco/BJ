package com.platform.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 nideshop_area
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-07-13 11:56:21
 */
public class AreaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //id
    private Long id;
    //全称
    private String fullname;
    //层级
    private Integer grade;
    //名称
    private String name;
    //树路径
    private String treepath;
    //是否删除(1是 0否)
    private Integer isdelete;
    //排序
    private Integer orders;
    //版本
    private Float version;
    //创建日期
    private Date createddate;
    //更新日期
    private Date lastmodifieddate;
    //地区父id
    private Long parentId;

    /**
     * 设置：id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：id
     */
    public Long getId() {
        return id;
    }
    /**
     * 设置：全称
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * 获取：全称
     */
    public String getFullname() {
        return fullname;
    }
    /**
     * 设置：层级
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * 获取：层级
     */
    public Integer getGrade() {
        return grade;
    }
    /**
     * 设置：名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：名称
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：树路径
     */
    public void setTreepath(String treepath) {
        this.treepath = treepath;
    }

    /**
     * 获取：树路径
     */
    public String getTreepath() {
        return treepath;
    }
    /**
     * 设置：是否删除(1是 0否)
     */
    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    /**
     * 获取：是否删除(1是 0否)
     */
    public Integer getIsdelete() {
        return isdelete;
    }
    /**
     * 设置：排序
     */
    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    /**
     * 获取：排序
     */
    public Integer getOrders() {
        return orders;
    }
    /**
     * 设置：版本
     */
    public void setVersion(Float version) {
        this.version = version;
    }

    /**
     * 获取：版本
     */
    public Float getVersion() {
        return version;
    }
    /**
     * 设置：创建日期
     */
    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    /**
     * 获取：创建日期
     */
    public Date getCreateddate() {
        return createddate;
    }
    /**
     * 设置：更新日期
     */
    public void setLastmodifieddate(Date lastmodifieddate) {
        this.lastmodifieddate = lastmodifieddate;
    }

    /**
     * 获取：更新日期
     */
    public Date getLastmodifieddate() {
        return lastmodifieddate;
    }
    /**
     * 设置：地区父id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取：地区父id
     */
    public Long getParentId() {
        return parentId;
    }
}

package com.platform.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 nideshop_register
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-08-09 09:45:55
 */
public class RegisterEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Integer id;
    //登录名
    private String peopleName;
    //联系方式
    private String contactMobile;
    //管理者姓名
    private String mangeName;

    /**
     * 设置：主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：主键
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：登录名
     */
    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    /**
     * 获取：登录名
     */
    public String getPeopleName() {
        return peopleName;
    }
    /**
     * 设置：联系方式
     */
    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    /**
     * 获取：联系方式
     */
    public String getContactMobile() {
        return contactMobile;
    }
    /**
     * 设置：管理者姓名
     */
    public void setMangeName(String mangeName) {
        this.mangeName = mangeName;
    }

    /**
     * 获取：管理者姓名
     */
    public String getMangeName() {
        return mangeName;
    }
}

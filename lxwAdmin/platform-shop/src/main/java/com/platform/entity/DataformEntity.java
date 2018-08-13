package com.platform.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 nideshop_dataform
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-08-02 13:50:04
 */
public class DataformEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Integer id;
    //周期号
    private String cycleno;
    //周期名字
    private String cyclename;
    //周期类型
    private String cycletype;
    //最小时间
    private String mintime;
    //最大时间
    private String maxtime;

    public String getMaxtime() {
        return maxtime;
    }

    public String getMintime() {
        return mintime;
    }

    public void setMintime(String mintime) {
        this.mintime = mintime;
    }

    public void setMaxtime(String maxtime) {
        this.maxtime = maxtime;
    }

    //
    private String dueDate;

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
     * 设置：周期号
     */
    public void setCycleno(String cycleno) {
        this.cycleno = cycleno;
    }

    /**
     * 获取：周期号
     */
    public String getCycleno() {
        return cycleno;
    }
    /**
     * 设置：周期名字
     */
    public void setCyclename(String cyclename) {
        this.cyclename = cyclename;
    }

    /**
     * 获取：周期名字
     */
    public String getCyclename() {
        return cyclename;
    }
    /**
     * 设置：周期类型
     */
    public void setCycletype(String cycletype) {
        this.cycletype = cycletype;
    }

    /**
     * 获取：周期类型
     */
    public String getCycletype() {
        return cycletype;
    }
    /**
     * 设置：最小时间
     */


    /**
     * 获取：最大时间
     */
    /**
     * 设置：
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * 获取：
     */
    public String getDueDate() {
        return dueDate;
    }
}

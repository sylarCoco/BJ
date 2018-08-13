package com.platform.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 nideshop_databaseform
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-07-31 11:38:20
 */
public class DatabaseformEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Integer id;
    //
    private Integer minTime;
    //
    private Integer maxTime;
    //标识
    private String simble;
    //
    private Integer year;
    //
    private Integer month;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMinTime() {
        return minTime;
    }

    public void setMinTime(Integer minTime) {
        this.minTime = minTime;
    }

    public Integer getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(Integer maxTime) {
        this.maxTime = maxTime;
    }

    public String getSimble() {
        return simble;
    }

    public void setSimble(String simble) {
        this.simble = simble;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
}
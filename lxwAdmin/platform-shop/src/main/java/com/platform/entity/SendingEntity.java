package com.platform.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 nideshop_sending
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-06-25 14:06:02
 */
public class SendingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Integer id;
    //配送方式
    private String modeDistribution;
    //配送时间

    private Date time;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    //配送人
    private String person;

    public String getMobiles() {
        return mobiles;
    }

    //配送人联系方式
    private String mobiles;

    private String orderSn;

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }


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
     * 设置：配送方式
     */
    public void setModeDistribution(String modeDistribution) {
        this.modeDistribution = modeDistribution;
    }

    /**
     * 获取：配送方式
     */
    public String getModeDistribution() {
        return modeDistribution;
    }
    /**
     * 设置：配送时间
     */

    public void setPerson(String person) {
        this.person = person;
    }

    /**
     * 获取：配送人
     */
    public String getPerson() {
        return person;
    }
    /**
     * 设置：配送人联系方式
     */
    public void setMobiles(String mobile) {
        this.mobiles = mobile;
    }

    /**
     * 获取：配送人联系方式
     * @param mobiles
     */
    public String getMobiles(String mobiles) {
        return mobiles;
    }
}

package com.platform.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 nideshop_orderdata
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-08-03 16:45:01
 */
public class OrderdataEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Integer id;
    //主账单号
    private String mid;
    //订单编号
    private String orderSn;
    //申请时间
    private String addTime;
    //配送时间
    private String time;
    //完成时间
    private String bargainTime;

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBargainTime() {
        return bargainTime;
    }

    public void setBargainTime(String bargainTime) {
        this.bargainTime = bargainTime;
    }

    //
    private String money;
    //
    private String applyType;

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
     * 设置：主账单号
     */
    public void setMid(String mid) {
        this.mid = mid;
    }

    /**
     * 获取：主账单号
     */
    public String getMid() {
        return mid;
    }
    /**
     * 设置：订单编号
     */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    /**
     * 获取：订单编号
     */
    public String getOrderSn() {
        return orderSn;
    }
    /**
     * 设置：申请时间
     */

    /**
     * 获取：申请时间
     */

    /**
     * 设置：
     */
    public void setMoney(String money) {
        this.money = money;
    }

    /**
     * 获取：
     */
    public String getMoney() {
        return money;
    }
    /**
     * 设置：
     */
    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    /**
     * 获取：
     */
    public String getApplyType() {
        return applyType;
    }
}

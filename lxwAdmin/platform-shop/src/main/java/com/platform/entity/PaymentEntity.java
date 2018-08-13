package com.platform.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 nideshop_payment
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-06-26 14:51:14
 */
public class PaymentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Integer id;
    //账期
    private String payment;
    //回款时间
    private String callbackTime;
    //回款金额
    private String money;
    //订单号
    private String orderSn;
    //计费类型
    private String moneyType;
    //图片链接
    private String link;
    //用户
    private String user;
    //账单编号
    private String billNumber;

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
     * 设置：账期
     */
    public void setPayment(String payment) {
        this.payment = payment;
    }

    /**
     * 获取：账期
     */
    public String getPayment() {
        return payment;
    }
    /**
     * 设置：回款时间
     */
    public void setCallbackTime(String callbackTime) {
        this.callbackTime = callbackTime;
    }

    /**
     * 获取：回款时间
     */
    public String getCallbackTime() {
        return callbackTime;
    }
    /**
     * 设置：回款金额
     */
    public void setMoney(String money) {
        this.money = money;
    }

    /**
     * 获取：回款金额
     */
    public String getMoney() {
        return money;
    }
    /**
     * 设置：订单号
     */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    /**
     * 获取：订单号
     */
    public String getOrderSn() {
        return orderSn;
    }
    /**
     * 设置：计费类型
     */
    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    /**
     * 获取：计费类型
     */
    public String getMoneyType() {
        return moneyType;
    }
    /**
     * 设置：图片链接
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * 获取：图片链接
     */
    public String getLink() {
        return link;
    }
    /**
     * 设置：用户
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * 获取：用户
     */
    public String getUser() {
        return user;
    }
    /**
     * 设置：账单编号
     */
    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    /**
     * 获取：账单编号
     */
    public String getBillNumber() {
        return billNumber;
    }
}

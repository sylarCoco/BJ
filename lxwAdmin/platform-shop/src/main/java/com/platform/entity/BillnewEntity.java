package com.platform.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 nideshop_billnew
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-06-26 14:37:56
 */
public class BillnewEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Integer id;
    //申请时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date applyTime;
    //成交时间

    private String bargainTime;

    public String getBargainTime() {
        return bargainTime;
    }

    public void setBargainTime(String bargainTime) {
        this.bargainTime = bargainTime;
    }

    private String pid;
    //完成时间
    private String accomplishTime;
    //交易金额
    private String money;
    //订单号
    private String orderSn;
    //计费类型
    private String moneyType;
    //结算状态
    private String settlementStatus;
    //用户
    private String user;
    //订单状态
    private String orderStatus;
    //账单编号
    private String billNumber;

    private String clientName;
    //到期时间
    private String expireTime;


    private String cycleNo;

    private OrderEntity orderEntity;
    private String orderNo;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date time;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    private String suplierType;

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }



    public String getSuplierType() {
        return suplierType;
    }

    public void setSuplierType(String suplierType) {
        this.suplierType = suplierType;
    }

    public String getCycleNo() {
        return cycleNo;
    }

    public void setCycleNo(String cycleNo) {
        this.cycleNo = cycleNo;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    private String custnumber;

    public String getCustnumber() {
        return custnumber;
    }

    public void setCustnumber(String custnumber) {
        this.custnumber = custnumber;
    }



    private UserEntity userEntity;


    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
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
     * 设置：申请时间
     * @param applyTime
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * 获取：申请时间
     */
    public Date getApplyTime() {
        return applyTime;
    }
    /**
     * 设置：成交时间
     */

    public void setAccomplishTime(String accomplishTime) {
        this.accomplishTime = accomplishTime;
    }

    /**
     * 获取：完成时间
     */
    public String getAccomplishTime() {
        return accomplishTime;
    }
    /**
     * 设置：交易金额
     */
    public void setMoney(String money) {
        this.money = money;
    }

    /**
     * 获取：交易金额
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
     * 设置：结算状态
     */
    public void setSettlementStatus(String settlementStatus) {
        this.settlementStatus = settlementStatus;
    }

    /**
     * 获取：结算状态
     */
    public String getSettlementStatus() {
        return settlementStatus;
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
     * 设置：订单状态
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 获取：订单状态
     */
    public String getOrderStatus() {
        return orderStatus;
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

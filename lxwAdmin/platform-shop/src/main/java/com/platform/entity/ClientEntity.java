package com.platform.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 nideshop_client
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-07-05 14:38:25
 */
public class ClientEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Integer id;
    //客户名称
    private String clientName;
    //结算方式
    private String clearingForm;
    //所属地区
    private String area;
    //城市
    private String city;
    //客户地址
    private String address;
    //业务负责人
    private String principal;
    //业务负责人邮箱
    private String email;
    //业务负责人电话
    private String mobile;
    //财务负责人
    private String financePrincipal;
    //财务负责人邮箱
    private String financeEmail;
    //财务负责人电话
    private String financeMobile;

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
     * 设置：客户名称
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * 获取：客户名称
     */
    public String getClientName() {
        return clientName;
    }
    /**
     * 设置：结算方式
     */
    public void setClearingForm(String clearingForm) {
        this.clearingForm = clearingForm;
    }

    /**
     * 获取：结算方式
     */
    public String getClearingForm() {
        return clearingForm;
    }
    /**
     * 设置：所属地区
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取：所属地区
     */
    public String getArea() {
        return area;
    }
    /**
     * 设置：城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取：城市
     */
    public String getCity() {
        return city;
    }
    /**
     * 设置：客户地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取：客户地址
     */
    public String getAddress() {
        return address;
    }
    /**
     * 设置：业务负责人
     */
    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    /**
     * 获取：业务负责人
     */
    public String getPrincipal() {
        return principal;
    }
    /**
     * 设置：业务负责人邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取：业务负责人邮箱
     */
    public String getEmail() {
        return email;
    }
    /**
     * 设置：业务负责人电话
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取：业务负责人电话
     */
    public String getMobile() {
        return mobile;
    }
    /**
     * 设置：财务负责人
     */
    public void setFinancePrincipal(String financePrincipal) {
        this.financePrincipal = financePrincipal;
    }

    /**
     * 获取：财务负责人
     */
    public String getFinancePrincipal() {
        return financePrincipal;
    }
    /**
     * 设置：财务负责人邮箱
     */
    public void setFinanceEmail(String financeEmail) {
        this.financeEmail = financeEmail;
    }

    /**
     * 获取：财务负责人邮箱
     */
    public String getFinanceEmail() {
        return financeEmail;
    }
    /**
     * 设置：财务负责人电话
     */
    public void setFinanceMobile(String financeMobile) {
        this.financeMobile = financeMobile;
    }

    /**
     * 获取：财务负责人电话
     */
    public String getFinanceMobile() {
        return financeMobile;
    }
}

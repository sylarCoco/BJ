package com.platform.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Date;


/**
 * 实体
 * 表名 nideshop_order
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-06-25 13:14:05
 */
public class OrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String billNumber;
    //
    private Integer id;
    //
    private String orderSn;
    //
    private Integer userId;
    //
    private Integer orderStatus;
    //
    private Integer shippingStatus;
    //
    private Integer payStatus;
    //
    private String consignee;
    //
    private String country;
    //
    private String province;
    //
    private String city;
    //
    private String district;
    //
    private String address;
    //
    private String mobile;
    //
    private String postscript;
    //
    private Integer shippingId;
    //
    private String shippingName;
    //
    private String payId;
    //
    private String payName;
    //
    private BigDecimal shippingFee;
    //实际需要支付的金额
    private BigDecimal actualPrice;
    //
    private Integer integral;
    //
    private BigDecimal integralMoney;
    //订单总价
    private BigDecimal orderPrice;
    //商品总价
    private BigDecimal goodsPrice;
    //

    private Date addTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date confirmTime;
    //
    private String payTime;
    //配送费用
    private Integer freightPrice;
    //使用的优惠券id
    private Integer couponId;
    //
    private Integer parentId;
    //
    private BigDecimal couponPrice;
    //
    private String callbackStatus;
    //
    private String shippingNo;
    //
    private BigDecimal fullCutPrice;
    //
    private String orderType;
    //
    private String bookbillId;
    //供应商
    private String username;
    //申请类型
    private String suplierType;
    //订单品类
    private String orderForm0;
    //订单品类
    private String orderForm1;
    //订单品类
    private String orderForm2;
    //商品
    private String commodity;
    //售卖单价
    private String unitPrice;
    //税后售卖单价
    private String nunitPrice;
    //总预算
    private String generalBudget;

    private SendingEntity sendingEntity;

    private String modeDistribution;
    //配送时间

    private Date time;

    public void setTime(Date time) {
        this.time = time;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    //配送人
    private String person;
    //配送人联系方式
    private String mobiles;
    //数量
    private String quantity;

    private String commodityName;
    //客户名称
    private String clientName;

    private UserEntity userEntity;

    //申请类型
    private String applyType;
    //是否需求明确
    private String makeSure;
    //处理人
    private String dispose;
    //处理时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date creatingTime;
   //确认状态
    private String confirmStatus;
    //申请类型
    private String applyTypes;

    private String orderNo;

    private String billingType;

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getBargainTime() {
        return bargainTime;
    }

    public void setBargainTime(String bargainTime) {
        this.bargainTime = bargainTime;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCycleNo() {
        return cycleNo;
    }

    public void setCycleNo(String cycleNo) {
        this.cycleNo = cycleNo;
    }

    public BillnewEntity getBillnewEntity() {
        return billnewEntity;
    }

    public void setBillnewEntity(BillnewEntity billnewEntity) {
        this.billnewEntity = billnewEntity;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date applyTime;
    //成交时间
    private String bargainTime;
    private String pid;
    private String cycleNo;
    private BillnewEntity billnewEntity;
    private String money;

    public String getBillingType() {
        return billingType;
    }

    public void setBillingType(String billingType) {
        this.billingType = billingType;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getApplyTypes() {
        return applyTypes;
    }

    public void setApplyTypes(String applyTypes) {
        this.applyTypes = applyTypes;
    }

    public String getConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(String confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public String getMakeSure() {
        return makeSure;
    }

    public void setMakeSure(String makeSure) {
        this.makeSure = makeSure;
    }

    public String getDispose() {
        return dispose;
    }

    public void setDispose(String dispose) {
        this.dispose = dispose;
    }

    public Date getCreatingTime() {
        return creatingTime;
    }

    public void setCreatingTime(Date creatingTime) {
        this.creatingTime = creatingTime;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public SendingEntity getSendingEntity() {
        return sendingEntity;
    }

    public void setSendingEntity(SendingEntity sendingEntity) {
        this.sendingEntity = sendingEntity;
    }
    public String getModeDistribution() {
        return modeDistribution;
    }

    public void setModeDistribution(String modeDistribution) {
        this.modeDistribution = modeDistribution;
    }

    /*@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")*/
    public Date getTime() {
        return time;
    }
    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getMobiles() {
        return mobiles;
    }

    public void setMobiles(String mobiles) {
        this.mobiles = mobiles;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：
     */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    /**
     * 获取：
     */
    public String getOrderSn() {
        return orderSn;
    }
    /**
     * 设置：
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取：
     */
    public Integer getUserId() {
        return userId;
    }
    /**
     * 设置：
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 获取：
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }
    /**
     * 设置：
     */
    public void setShippingStatus(Integer shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    /**
     * 获取：
     */
    public Integer getShippingStatus() {
        return shippingStatus;
    }
    /**
     * 设置：
     */
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * 获取：
     */
    public Integer getPayStatus() {
        return payStatus;
    }
    /**
     * 设置：
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    /**
     * 获取：
     */
    public String getConsignee() {
        return consignee;
    }
    /**
     * 设置：
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 获取：
     */
    public String getCountry() {
        return country;
    }
    /**
     * 设置：
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取：
     */
    public String getProvince() {
        return province;
    }
    /**
     * 设置：
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取：
     */
    public String getCity() {
        return city;
    }
    /**
     * 设置：
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * 获取：
     */
    public String getDistrict() {
        return district;
    }
    /**
     * 设置：
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取：
     */
    public String getAddress() {
        return address;
    }
    /**
     * 设置：
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取：
     */
    public String getMobile() {
        return mobile;
    }
    /**
     * 设置：
     */
    public void setPostscript(String postscript) {
        this.postscript = postscript;
    }

    /**
     * 获取：
     */
    public String getPostscript() {
        return postscript;
    }
    /**
     * 设置：
     */
    public void setShippingId(Integer shippingId) {
        this.shippingId = shippingId;
    }

    /**
     * 获取：
     */
    public Integer getShippingId() {
        return shippingId;
    }
    /**
     * 设置：
     */
    public void setShippingName(String shippingName) {
        this.shippingName = shippingName;
    }

    /**
     * 获取：
     */
    public String getShippingName() {
        return shippingName;
    }
    /**
     * 设置：
     */
    public void setPayId(String payId) {
        this.payId = payId;
    }

    /**
     * 获取：
     */
    public String getPayId() {
        return payId;
    }
    /**
     * 设置：
     */
    public void setPayName(String payName) {
        this.payName = payName;
    }

    /**
     * 获取：
     */
    public String getPayName() {
        return payName;
    }
    /**
     * 设置：
     */
    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    /**
     * 获取：
     */
    public BigDecimal getShippingFee() {
        return shippingFee;
    }
    /**
     * 设置：实际需要支付的金额
     */
    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    /**
     * 获取：实际需要支付的金额
     */
    public BigDecimal getActualPrice() {
        return actualPrice;
    }
    /**
     * 设置：
     */
    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    /**
     * 获取：
     */
    public Integer getIntegral() {
        return integral;
    }
    /**
     * 设置：
     */
    public void setIntegralMoney(BigDecimal integralMoney) {
        this.integralMoney = integralMoney;
    }

    /**
     * 获取：
     */
    public BigDecimal getIntegralMoney() {
        return integralMoney;
    }
    /**
     * 设置：订单总价
     */
    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * 获取：订单总价
     */
    public BigDecimal getOrderPrice() {
        return orderPrice;
    }
    /**
     * 设置：商品总价
     */
    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    /**
     * 获取：商品总价
     */
    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }
    /**
     * 设置：
     * @param addTime
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取：
     */
    public Date getAddTime() {
        return addTime;
    }
    /**
     * 设置：
     * @param confirmTime
     */
    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    /**
     * 获取：
     */
    public Date getConfirmTime() {
        return confirmTime;
    }
    /**
     * 设置：
     */
    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取：
     */
    public String getPayTime() {
        return payTime;
    }
    /**
     * 设置：配送费用
     */
    public void setFreightPrice(Integer freightPrice) {
        this.freightPrice = freightPrice;
    }

    /**
     * 获取：配送费用
     */
    public Integer getFreightPrice() {
        return freightPrice;
    }
    /**
     * 设置：使用的优惠券id
     */
    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    /**
     * 获取：使用的优惠券id
     */
    public Integer getCouponId() {
        return couponId;
    }
    /**
     * 设置：
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取：
     */
    public Integer getParentId() {
        return parentId;
    }
    /**
     * 设置：
     */
    public void setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
    }

    /**
     * 获取：
     */
    public BigDecimal getCouponPrice() {
        return couponPrice;
    }
    /**
     * 设置：
     */
    public void setCallbackStatus(String callbackStatus) {
        this.callbackStatus = callbackStatus;
    }

    /**
     * 获取：
     */
    public String getCallbackStatus() {
        return callbackStatus;
    }
    /**
     * 设置：
     */
    public void setShippingNo(String shippingNo) {
        this.shippingNo = shippingNo;
    }

    /**
     * 获取：
     */
    public String getShippingNo() {
        return shippingNo;
    }
    /**
     * 设置：
     */
    public void setFullCutPrice(BigDecimal fullCutPrice) {
        this.fullCutPrice = fullCutPrice;
    }

    /**
     * 获取：
     */
    public BigDecimal getFullCutPrice() {
        return fullCutPrice;
    }
    /**
     * 设置：
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    /**
     * 获取：
     */
    public String getOrderType() {
        return orderType;
    }
    /**
     * 设置：
     */
    public void setBookbillId(String bookbillId) {
        this.bookbillId = bookbillId;
    }

    /**
     * 获取：
     */
    public String getBookbillId() {
        return bookbillId;
    }
    /**
     * 设置：供应商
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取：供应商
     */
    public String getUsername() {
        return username;
    }
    /**
     * 设置：申请类型
     */
    public void setSuplierType(String suplierType) {
        this.suplierType = suplierType;
    }

    /**
     * 获取：申请类型
     */
    public String getSuplierType() {
        return suplierType;
    }
    /**
     * 设置：订单品类
     */
    public void setOrderForm0(String orderForm0) {
        this.orderForm0 = orderForm0;
    }

    /**
     * 获取：订单品类
     */
    public String getOrderForm0() {
        return orderForm0;
    }
    /**
     * 设置：订单品类
     */
    public void setOrderForm1(String orderForm1) {
        this.orderForm1 = orderForm1;
    }

    /**
     * 获取：订单品类
     */
    public String getOrderForm1() {
        return orderForm1;
    }
    /**
     * 设置：订单品类
     */
    public void setOrderForm2(String orderForm2) {
        this.orderForm2 = orderForm2;
    }

    /**
     * 获取：订单品类
     */
    public String getOrderForm2() {
        return orderForm2;
    }
    /**
     * 设置：商品
     */
    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    /**
     * 获取：商品
     */
    public String getCommodity() {
        return commodity;
    }
    /**
     * 设置：售卖单价
     */
    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * 获取：售卖单价
     */
    public String getUnitPrice() {
        return unitPrice;
    }
    /**
     * 设置：税后售卖单价
     */
    public void setNunitPrice(String nunitPrice) {
        this.nunitPrice = nunitPrice;
    }

    /**
     * 获取：税后售卖单价
     */
    public String getNunitPrice() {
        return nunitPrice;
    }
    /**
     * 设置：总预算
     */
    public void setGeneralBudget(String generalBudget) {
        this.generalBudget = generalBudget;
    }

    /**
     * 获取：总预算
     */
    public String getGeneralBudget() {
        return generalBudget;
    }
}

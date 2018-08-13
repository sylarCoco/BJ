package com.platform.entity;

import java.io.Serializable;

public class CommondityEntity implements Serializable {


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private int id;
    //商品名称
    private String name;
    //商品类别
    private String classing;
    private String classing1;
    private String classing2;

    public String getFrontdesc() {
        return frontdesc;
    }

    public void setFrontdesc(String frontdesc) {
        this.frontdesc = frontdesc;
    }

    //品牌
    private String frontdesc;
    //型号
    private String model;
    //规格
    private String specification;
    //售卖单价
    private String price;
    //含税价格
    private String taxprice;
    //供应商
    private String username;
    //商品图片地址
    private String imgurl;

    private String goodstyle;

    private String productid;

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getGoodstyle() {
        return goodstyle;
    }

    public void setGoodstyle(String goodstyle) {
        this.goodstyle = goodstyle;
    }

    public String getClassing() {
        return classing;
    }

    public void setClassing(String classing) {
        this.classing = classing;
    }

    public String getClassing1() {
        return classing1;
    }

    public void setClassing1(String classing1) {
        this.classing1 = classing1;
    }

    public String getClassing2() {
        return classing2;
    }

    public void setClassing2(String classing2) {
        this.classing2 = classing2;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public String getProvider() {
        return username;
    }

    public void setProvider(String provider) {
        this.username = provider;
    }

    public String getTaxprice() {
        return taxprice;
    }

    public void setTaxprice(String taxprice) {
        this.taxprice = taxprice;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

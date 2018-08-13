package com.platform.entity;

import java.io.Serializable;

public class Provider implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer  id;
    private String  brandId;
    private String username;
    private String supplyStatus;
    private String stateCooperation;
    private String creator;
    private String lastCreator;
    private String abbreviation;
    private String enterpriseServiceArea;
    private String serviceCategory;
    private String scopeOperation;
    private String businessQualification;
    private String area;//供货类型 这里标错了就用area吧
    private String supplyAddress;
    private String person;
    private String email;
    private String contact;
    private String opengingBank;
    private String accountName;
    private String accountNumber;
    private OpeningBank openingBank;
    private String address;
    //省
    private String province;
    //市
    private String town;
    //区
    private String region;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getSupplyStatus() {
        return supplyStatus;
    }

    public void setSupplyStatus(String supplyStatus) {
        this.supplyStatus = supplyStatus;
    }

    public String getStateCooperation() {
        return stateCooperation;
    }

    public void setStateCooperation(String stateCooperation) {
        this.stateCooperation = stateCooperation;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getLastCreator() {
        return lastCreator;
    }

    public void setLastCreator(String lastCreator) {
        this.lastCreator = lastCreator;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getEnterpriseServiceArea() {
        return enterpriseServiceArea;
    }

    public void setEnterpriseServiceArea(String enterpriseServiceArea) {
        this.enterpriseServiceArea = enterpriseServiceArea;
    }

    public String getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(String serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    public String getScopeOperation() {
        return scopeOperation;
    }

    public void setScopeOperation(String scopeOperation) {
        this.scopeOperation = scopeOperation;
    }

    public String getBusinessQualification() {
        return businessQualification;
    }

    public void setBusinessQualification(String businessQualification) {
        this.businessQualification = businessQualification;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSupplyAddress() {
        return supplyAddress;
    }

    public void setSupplyAddress(String supplyAddress) {
        this.supplyAddress = supplyAddress;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getOpengingBank() {
        return opengingBank;
    }

    public void setOpengingBank(String opengingBank) {
        this.opengingBank = opengingBank;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public OpeningBank getOpeningBank() {
        return openingBank;
    }

    public void setOpeningBank(OpeningBank openingBank) {
        this.openingBank = openingBank;
    }


}

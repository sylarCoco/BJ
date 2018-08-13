package com.platform.entity;

public class OpeningBank {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getOpeningBank() {
        return opengingBank;
    }

    public void setOpeningBank(String openingBank) {
        this.opengingBank = openingBank;
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

    private String brandId;
    private String opengingBank;
    private String accountName;
    private String accountNumber;



}

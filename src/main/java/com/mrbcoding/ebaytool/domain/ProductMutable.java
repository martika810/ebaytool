package com.mrbcoding.ebaytool.domain;

/**
 * Created by rsm095 on 17/05/2018.
 */
public class ProductMutable {
    private String id;
    private String name;
    private float netPrice; // the price that I have paid
    private float finalPrice;
    private String status;

    public ProductMutable(){}

    public ProductMutable(String id,String name, float netPrice,float finalPrice, String status) {
        this.id = id;
        this.name = name;
        this.netPrice = netPrice;
        this.finalPrice = finalPrice;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNetPrice(float netPrice) {
        this.netPrice = netPrice;
    }

    public void setFinalPrice(float finalPrice) {
        this.finalPrice = finalPrice;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public float getNetPrice() {
        return netPrice;
    }

    public float getFinalPrice() {
        return finalPrice;
    }

    public String getStatus() {
        return status;
    }
}


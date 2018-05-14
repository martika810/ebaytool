package com.mrbcoding.ebaytool.domain;

public class Product {
    private final String name;
    private final float netPrice; // the price that I have paid
    private final float finalPrice;
    private final ProductStatus status;

    public Product(String name, float netPrice,float finalPrice, ProductStatus status) {
        this.name = name;
        this.netPrice = netPrice;
        this.finalPrice = finalPrice;
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

    public ProductStatus getStatus() {
        return status;
    }
}

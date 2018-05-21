package com.mrbcoding.ebaytool.domain;

public class Product {
    private final String id;
    private final String name;
    private final float netPrice; // the price that I have paid
    private final float finalPrice;
    private final ProductStatus status;

    public Product(String id, String name, float netPrice,float finalPrice, ProductStatus status) {
        this.id = id;
        this.name = name;
        this.netPrice = netPrice;
        this.finalPrice = finalPrice;
        this.status = status;
    }

    public String getId() {
        return id;
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

    public ProductMutable toMutable(){
        return new ProductMutable(id,name,netPrice,finalPrice,status.toString());
    }

    public static Product of(ProductMutable mutable){
        return new Product(mutable.getId(),mutable.getName(),mutable.getNetPrice(),mutable.getFinalPrice(),ProductStatus.valueOf(mutable.getStatus()));
    }
}

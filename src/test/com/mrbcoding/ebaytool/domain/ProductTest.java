package com.mrbcoding.ebaytool.domain;

import org.junit.Test;

import java.util.UUID;

/**
 * Created by rsm095 on 18/05/2018.
 */
public class ProductTest {

    @Test
    public void ofCOnstructor(){
        ProductMutable mutable = new ProductMutable(UUID.randomUUID().toString(),"Product2",22.3F,22.3F,"INTRANSIT");
        Product product= Product.of(mutable);
        assert(product.getName().equals(mutable.getName()));
        assert(product.getNetPrice()==mutable.getNetPrice());
        assert(product.getFinalPrice()==mutable.getFinalPrice());
        assert(product.getStatus().toString().equals(mutable.getStatus()));
    }
}

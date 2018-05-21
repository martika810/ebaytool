package com.mrbcoding.ebaytool.repositories;

import com.mrbcoding.ebaytool.domain.Product;
import com.mrbcoding.ebaytool.domain.ProductStatus;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProductRepository implements Repository<String,Product>{

    private Map<String,Product> dataSource;

    public ProductRepository(){
        this.dataSource = new HashMap<>();
        init();
    }
    @Override
    public Product add(Product obj) {
        dataSource.put(obj.getId(), obj);
        return dataSource.get(obj.getId());
    }

    @Override
    public Product update(Product obj) {
        dataSource.put(obj.getId(), obj);
        return dataSource.get(obj.getName());
    }

    @Override
    public void update(List<Product> list) {
        for (Product product : list) {

            dataSource.put(product.getId(), product);
        }
    }

    @Override
    public Product read(String id) {
        return dataSource.get(id);
    }

    @Override
    public void delete(String id) {
        dataSource.remove(dataSource.get(id));
    }

    @Override
    public Map<String, Product> readAll() {
        return new HashMap<>(dataSource);
    }

    private void init() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(UUID.randomUUID().toString(),"Product1",12.3F,22.3F,ProductStatus.INTRANSIT));
        products.add(new Product(UUID.randomUUID().toString(),"Product2",12.3F,0F,ProductStatus.INTRANSIT));
        products.add(new Product(UUID.randomUUID().toString(),"Product3",12.3F,0F,ProductStatus.INTRANSIT));
        products.add(new Product(UUID.randomUUID().toString(),"Product4",12.3F,0F,ProductStatus.SOLD));

        update(products);
    }
}

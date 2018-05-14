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
        dataSource.put(obj.getName(), obj);
        return dataSource.get(obj.getName());
    }

    @Override
    public Product update(Product obj) {
        dataSource.put(obj.getName(), obj);
        return dataSource.get(obj.getName());
    }

    @Override
    public void update(List<Product> list) {
        for (Product product : list) {
            dataSource.put(product.getName(), product);
        }
    }

    @Override
    public Product read(String name) {
        return dataSource.get(name);
    }

    @Override
    public void delete(String name) {
        dataSource.remove(dataSource.get(name));
    }

    @Override
    public Map<String, Product> readAll() {
        return new HashMap<>(dataSource);
    }

    private void init() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product1",12.3F,22.3F,ProductStatus.IN_TRANSIT));
        products.add(new Product("Product2",12.3F,0F,ProductStatus.IN_TRANSIT));
        products.add(new Product("Product3",12.3F,0F,ProductStatus.IN_TRANSIT));
        products.add(new Product("Product4",12.3F,0F,ProductStatus.SOLD));

        update(products);
    }
}

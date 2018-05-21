package com.mrbcoding.ebaytool.controllers;

import com.mrbcoding.ebaytool.domain.ProductMutable;
import com.mrbcoding.ebaytool.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.mrbcoding.ebaytool.domain.Product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/products")
public class ProductController implements com.mrbcoding.ebaytool.controllers.Controller<ProductMutable> {

    private ProductRepository repository;

    @Autowired
    public ProductController(ProductRepository repository){
        this.repository = repository;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ProductMutable>> getAll() {
        Map<String, Product> products = repository.readAll();
        //Map<String, EmployeeMutable> employeeReponse = convertToApi(employees);
        List<Product> productList = new ArrayList(products.values());
        List<ProductMutable> mutables = productList.stream().map(x->x.toMutable()).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(mutables);
    }

    @Override
    public ResponseEntity<ProductMutable> update(ProductMutable obj) {
        return null;
    }

    @Override
    @RequestMapping(consumes = "application/json", method = RequestMethod.PUT)
    public ResponseEntity<List<ProductMutable>> update(@RequestBody List<ProductMutable> list) {

        List<Product> products = list.stream().map(x-> Product.of(x)).collect(Collectors.toList());
        repository.update(products);
        Map<String, Product> productMap = repository.readAll();
        products = new ArrayList(productMap.values());
        List<ProductMutable> mutables = products.stream().map(x->x.toMutable()).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(mutables);

    }

    @Override
    @RequestMapping(path="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") String id) {
        repository.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @Override
    public ResponseEntity<ProductMutable> create(ProductMutable obj) {
        return null;
    }



}

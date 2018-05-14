package com.mrbcoding.ebaytool.controllers;

import com.mrbcoding.ebaytool.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.mrbcoding.ebaytool.domain.Product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.Annotation;
import java.util.Map;

@Controller
@RequestMapping("/products")
public class ProductController implements com.mrbcoding.ebaytool.controllers.Controller<Product> {

    private ProductRepository repository;

    @Autowired
    public ProductController(ProductRepository repository){
        this.repository = repository;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Map<String, Product>> getAll() {
        Map<String, Product> products = repository.readAll();
        //Map<String, EmployeeMutable> employeeReponse = convertToApi(employees);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @Override
    public ResponseEntity<Product> update(Product obj) {
        return null;
    }

    @Override
    public ResponseEntity delete(String id) {
        return null;
    }

    @Override
    public ResponseEntity<Product> create(Product obj) {
        return null;
    }



}

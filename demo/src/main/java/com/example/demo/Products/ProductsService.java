package com.example.demo.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Products> getAllProducts(){
        return productsRepository.findAll();
    }

    public Products getProduct(String id){
        Integer product_id = Integer.parseInt(id);
        return productsRepository.findById(product_id).orElse(null);
    }

    public void updateProduct(String id, String name){
        Integer product_id = Integer.parseInt(id);
        Products product = productsRepository.findById(product_id).orElse(null);
        if (product != null){
            product.setProductName(name);

            productsRepository.save(product);
        }
    }

    public ResponseEntity<String> deleteProduct(String id){
        int Product_id = Integer.valueOf(id);
        productsRepository.deleteById(Product_id);
    return ResponseEntity.ok().body("Product id:" +id);
    }

    public Products addProduct(int id, String name, double price){
        Products product = new Products();
        product.setID(id);
        product.setProductName(name);
        product.setPrice(price);
        return productsRepository.save(product);
    }
}

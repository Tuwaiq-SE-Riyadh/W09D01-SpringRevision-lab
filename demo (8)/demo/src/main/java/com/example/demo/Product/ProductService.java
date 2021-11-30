package com.example.demo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){ this.productRepository = productRepository; }

    public List<Product> getProducts(){ return productRepository.findAll(); }

    public Product getProduct(String id){
        Long product_id = Long.parseLong(id);
        return productRepository.findById(product_id).orElse(null);
    }

    public Product addProduct(Long id, String name, double price) {
        Product product = new Product();
        product.setId(id);
        product.setProductName(name);
        product.setPrice(price);
        return productRepository.save(product);
    }

    public ResponseEntity<String> deleteProduct(String id){
        Long product_id = Long.parseLong(id);
        productRepository.deleteById(product_id);
        return ResponseEntity.ok().body(id);
    }

    public void updateProduct(String id, String name){
        Long product_id = Long.parseLong(id);
        Product product = productRepository.findById(product_id).orElse(null);

        if(product != null){
            product.setProductName(name);
            productRepository.save(product);
        }
    }
}

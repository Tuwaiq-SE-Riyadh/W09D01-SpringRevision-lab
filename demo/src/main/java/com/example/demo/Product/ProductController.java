package com.example.demo.Product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "products")
public class ProductController {

    private final ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){
         return productService.addProduct(product);
    }

    @GetMapping("/{id}/{name}")
    public ResponseEntity<String>getProduct(@PathVariable String id ,@PathVariable String name){
        return ResponseEntity.ok().body(productService.getProduct(id,name));

    }


}

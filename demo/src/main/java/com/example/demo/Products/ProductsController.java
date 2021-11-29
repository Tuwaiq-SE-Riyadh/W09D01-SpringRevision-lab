package com.example.demo.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "products")
public class ProductsController {

    private final ProductsService productsService;


    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping
    @ResponseBody
    public void addProduct(@RequestParam String id, @RequestParam String name, @RequestParam  double price){
        productsService.addProduct(Integer.valueOf(id), name, price);
    }

    @GetMapping
    public List<Products> getAllProducts(){
        return productsService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Products getProduct(@PathVariable String id){
        return productsService.getProduct(id);
    }

    @PutMapping
    @ResponseBody
    public void updateProduct(@RequestParam String id, @RequestParam String name){
        productsService.updateProduct(id,name);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delProduct(@PathVariable String id){
        return productsService.deleteProduct(id);
    }


}

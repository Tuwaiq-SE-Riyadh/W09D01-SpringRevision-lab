package com.example.demo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){ this.productService = productService; }

    @GetMapping
    public ResponseEntity<String>getIdAndName(@RequestParam String id, @RequestParam String name){
        return ResponseEntity.ok().body(id+ " " +name);
    }
    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id){
        return productService.getProduct(id);
    }

    @PostMapping
    public void addProduct(@RequestParam String id, @RequestParam String name, @RequestParam double price){ productService.addProduct(Long.parseLong(id), name, price); }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id){
       return productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@RequestParam String id, @RequestParam String name){ productService.updateProduct(id, name); }
}

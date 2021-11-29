package com.example.lab.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "product")
public class Controller {

    private final service Service;

    @Autowired
    public Controller(service Service, service service) {
        this.Service = service;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<String> Responseproduct(@RequestParam String id, @RequestParam String name) {
        return Service.Responseproduct(id,name);
    }

    @GetMapping("/{id}")
    public product GetProduct(@PathVariable String id ){
        return Service.GetProduct(id);
    }

    @PostMapping
    public product addProduct(@RequestBody product p){
        return Service.AddProduct(p);
    }

    @PutMapping("/{id}")
    public product Updateproduct(@PathVariable String id , @RequestBody product p){
        return Service.UpdateProduct(id,p);
    }

    @DeleteMapping ("/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteproduct(@PathVariable String id) {
        return Service.DeleteProduct(id);
    }

}
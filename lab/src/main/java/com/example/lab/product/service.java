package com.example.lab.product;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;


@Service
public class service {

    private final repository repo;

    public service(repository repo) {
        this.repo = repo;
    }

    public ResponseEntity<String> Responseproduct(String id, String name){
        return ResponseEntity.ok().body(id+" "+name);
    }

    public product GetProduct(String id){
        Long Id = Long.parseLong(id);
        return repo.findById(Id).orElse(null);
    }

    public product AddProduct(product p) {
        return repo.save(p);
    }

    @ResponseBody
    public ResponseEntity<String> DeleteProduct(String id){
        Long Id = Long.parseLong(id);
        repo.deleteById(Id);
        return ResponseEntity.ok().body("deleted");
    }

    public product UpdateProduct(String id, product p) {
        Long Id = Long.parseLong(id);
        product result = repo.findById(Id).orElse(null);
        if (result != null){
            result.setProductName(p.getProductName());
            repo.save(result);
        }
        return result;
    }


}

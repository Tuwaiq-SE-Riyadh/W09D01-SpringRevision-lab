package com.example.Lab.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    public ResponseEntity<String> getProduct(String id, String name){

        return ResponseEntity.ok().body(id+" "+name);
    }

}

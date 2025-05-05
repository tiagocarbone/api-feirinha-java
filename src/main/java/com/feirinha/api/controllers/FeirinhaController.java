package com.feirinha.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feirinha.api.repositories.FeirinhaRepository;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("items")
public class FeirinhaController {

    private final FeirinhaRepository feirinhaRepository;

    FeirinhaController (FeirinhaRepository feirinhaRepository){
        this.feirinhaRepository = feirinhaRepository;
    }

    

    @GetMapping()
    public ResponseEntity<Object> getItems() {

        return ResponseEntity.status(HttpStatus.OK).body("ffc");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getItemsById(@PathVariable("id") Long id) {

        return ResponseEntity.status(HttpStatus.OK).body("ffc");
    }

    @PostMapping()
    public ResponseEntity<Object> postItem (@RequestBody String body) {
        
        return ResponseEntity.status(HttpStatus.OK).body("ffc");
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> putItem(@PathVariable("id") Long id, @RequestBody String body) {
        
        return ResponseEntity.status(HttpStatus.OK).body("ffc");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteItem(@PathVariable("id") Long id ){
        return ResponseEntity.status(HttpStatus.OK).body("ffc");
    }



}

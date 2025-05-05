package com.feirinha.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feirinha.api.dtos.ItemDTO;
import com.feirinha.api.models.ItemModel;
import com.feirinha.api.repositories.FeirinhaRepository;
import com.feirinha.api.services.FeirinhaService;

import jakarta.validation.Valid;

import java.lang.foreign.Linker.Option;
import java.util.Optional;

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

    private final FeirinhaService feirinhaService;

    FeirinhaController (FeirinhaService feirinhaService){
        this.feirinhaService = feirinhaService;
    }

    @GetMapping()
    public ResponseEntity<Object> getItems() {

        return ResponseEntity.status(HttpStatus.OK).body(feirinhaService.getItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getItemsById(@PathVariable("id") Long id) {

        Optional<ItemModel> item = feirinhaService.getItemById(id);

        if(!item.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item with this id not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(item.get());
    }

    @PostMapping()
    public ResponseEntity<Object> postItem (@RequestBody @Valid ItemDTO body) {
        
        ItemModel item = feirinhaService.createItem(body);

        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> putItem(@PathVariable("id") Long id, @RequestBody @Valid ItemDTO body) {
        
        Optional<ItemModel> item = feirinhaService.updateItem(id, body);

        if(!item.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(item.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteItem(@PathVariable("id") Long id ){
        feirinhaService.deleteItem(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }



}

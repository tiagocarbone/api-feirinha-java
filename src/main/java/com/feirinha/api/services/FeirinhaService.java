package com.feirinha.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.feirinha.api.dtos.ItemDTO;
import com.feirinha.api.models.ItemModel;
import com.feirinha.api.repositories.FeirinhaRepository;

@Service
public class FeirinhaService {
    
    final FeirinhaRepository feirinhaRepository;

    public FeirinhaService(FeirinhaRepository feirinhaRepository){
        this.feirinhaRepository = feirinhaRepository;
    }


    public List<ItemModel> getItems(){
        return feirinhaRepository.findAll();
    }


    public Optional<ItemModel> getItemById(Long id){
        Optional<ItemModel> item = feirinhaRepository.findById(id);

        if(!item.isPresent()){
            return Optional.empty();
        }else{
            return item;
        }
    }


    public ItemModel createItem(ItemDTO body){
        ItemModel item = new ItemModel(body);
        feirinhaRepository.save(item);

        return item;
    }

    public Optional<ItemModel> updateItem(Long id, ItemDTO body){
        Optional<ItemModel> item = feirinhaRepository.findById(id);

        if(!item.isPresent()){
            return Optional.empty();
        }

        ItemModel newItem = new ItemModel(body);
        newItem.setId(id);
        feirinhaRepository.save(newItem);
        return Optional.of(newItem);
    }


    public void deleteItem(Long id){
        feirinhaRepository.deleteById(id);
    }

}

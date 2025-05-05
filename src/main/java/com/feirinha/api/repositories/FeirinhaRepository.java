package com.feirinha.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feirinha.api.models.ItemModel;

@Repository
public interface FeirinhaRepository  extends JpaRepository<ItemModel, Long>{
   
} 
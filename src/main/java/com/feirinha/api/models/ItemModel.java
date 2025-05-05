package com.feirinha.api.models;

import com.feirinha.api.dtos.ItemDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "item")
public class ItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer quantity;

    public ItemModel(ItemDTO dto){
        this.name = dto.getName();
        this.quantity = dto.getQuantity();
    }

}

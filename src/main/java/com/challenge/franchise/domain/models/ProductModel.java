package com.challenge.franchise.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ProductModel {
    private Long id;
    private String name;
    private  int quantity;
}

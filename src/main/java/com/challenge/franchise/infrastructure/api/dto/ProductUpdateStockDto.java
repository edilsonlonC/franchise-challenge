package com.challenge.franchise.infrastructure.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductUpdateStockDto {
    private Long id;
    private int quantity;
}

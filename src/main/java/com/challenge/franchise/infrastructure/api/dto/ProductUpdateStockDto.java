package com.challenge.franchise.infrastructure.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductUpdateStockDto {
    private Long id;
    @Min(value = 1, message = "Quantity must be greater than 0 ")
    private int quantity;
}

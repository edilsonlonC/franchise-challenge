package com.challenge.franchise.infrastructure.mapper;

import com.challenge.franchise.domain.models.ProductModel;
import com.challenge.franchise.infrastructure.api.dto.ProductCreateDto;
import com.challenge.franchise.infrastructure.api.dto.ProductResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDtoMapper {
    ProductModel productCreateDtoToProductModel(ProductCreateDto product);
    ProductResponseDto productModelToProductResponseDto (ProductModel product);
}

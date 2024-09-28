package com.challenge.franchise.infrastructure.mapper;

import com.challenge.franchise.domain.models.ProductModel;
import com.challenge.franchise.infrastructure.database.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = BranchMapper.class)
public interface ProductMapper {
    ProductModel productEntityToProductModel (ProductEntity product);
    ProductEntity productModelToProductEntity (ProductModel product);

}

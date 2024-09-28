package com.challenge.franchise.infrastructure.repositories;

import com.challenge.franchise.domain.models.ProductModel;
import com.challenge.franchise.domain.repositories.ProductRepository;
import com.challenge.franchise.infrastructure.database.entities.ProductEntity;
import com.challenge.franchise.infrastructure.database.jpaRepisitories.ProductJpaRepository;
import com.challenge.franchise.infrastructure.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private final ProductJpaRepository productJpaRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductModel create(ProductModel product) {
        ProductEntity productEntity =  productMapper.productModelToProductEntity(product);
        ProductModel productModel = productMapper.productEntityToProductModel(productJpaRepository.save(productEntity));
        return  productModel;
    }


}

package com.challenge.franchise.domain.repositories;

import com.challenge.franchise.domain.models.ProductModel;

import java.util.List;
import java.util.Optional;


public interface ProductRepository {
    ProductModel create (ProductModel product);
    boolean delete (Long id);
    Optional<ProductModel> findById(Long id);
    ProductModel update (ProductModel product);
    List<ProductModel> findTopProductsByStock(Long franchiseId);
}

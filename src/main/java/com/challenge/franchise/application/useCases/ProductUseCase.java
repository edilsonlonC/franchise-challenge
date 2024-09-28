package com.challenge.franchise.application.useCases;

import com.challenge.franchise.domain.models.ProductModel;
import com.challenge.franchise.domain.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductUseCase {
   private final ProductRepository productRepository;
   public ProductModel create (ProductModel product) {
       return productRepository.create(product);
   }
   public List<ProductModel> findAll (){
       return productRepository.findAll();
   }

}

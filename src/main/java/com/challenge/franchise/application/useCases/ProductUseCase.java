package com.challenge.franchise.application.useCases;

import com.challenge.franchise.domain.models.ProductModel;
import com.challenge.franchise.domain.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductUseCase {
   private final ProductRepository productRepository;
   public ProductModel create (ProductModel product) {
       return productRepository.create(product);
   }
    public boolean delete(Long productId) {
        return productRepository.delete(productId);
    }
    //TODO: validate range for stock
    public boolean modifyStock (Long id, int quantity) {
       Optional<ProductModel> productResult = productRepository.findById(id);
       if(productResult.isEmpty()) return false;
       ProductModel product = productResult.get();
       product.setQuantity(quantity);
       productRepository.update(product);
       return true;
    }
    public List<ProductModel> findTopProducts(Long franchiseId){
       return productRepository.findTopProductsByStock(franchiseId);
    }
    public Optional<ProductModel> findById(Long productId) {
        return productRepository.findById(productId);
    }

}

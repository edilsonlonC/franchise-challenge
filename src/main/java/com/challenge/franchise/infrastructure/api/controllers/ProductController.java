package com.challenge.franchise.infrastructure.api.controllers;

import com.challenge.franchise.application.useCases.BranchUseCase;
import com.challenge.franchise.application.useCases.ProductUseCase;
import com.challenge.franchise.domain.models.BranchModel;
import com.challenge.franchise.domain.models.ProductModel;
import com.challenge.franchise.infrastructure.api.dto.ProductCreateDto;
import com.challenge.franchise.infrastructure.mapper.ProductDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final BranchUseCase branchUseCase;
    private final ProductUseCase productUseCase;
    private final ProductDtoMapper productDtoMapper;
   @PostMapping
   public ResponseEntity<?> create(@RequestBody ProductCreateDto productCreateDto) {
       Optional<BranchModel> branchModel = branchUseCase.findById(productCreateDto.getBranchId());
       if (branchModel.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Branch not found");
       ProductModel productModel = new ProductModel();
       productModel.setName(productCreateDto.getName());
       productModel.setQuantity(productCreateDto.getQuantity());
       productModel.setBranch(branchModel.get());

       return new ResponseEntity<>(
              productDtoMapper.productModelToProductResponseDto(
                      productUseCase.create(productModel)
              ),
              HttpStatus.CREATED
       );
   }
   @GetMapping
    public ResponseEntity<List<ProductModel>> findAll() {
       return new ResponseEntity<>(productUseCase.findAll() , HttpStatus.OK);
   }
}

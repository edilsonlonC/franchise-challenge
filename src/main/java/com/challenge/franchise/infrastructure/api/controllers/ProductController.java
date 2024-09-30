package com.challenge.franchise.infrastructure.api.controllers;

import com.challenge.franchise.application.useCases.BranchUseCase;
import com.challenge.franchise.application.useCases.ProductUseCase;
import com.challenge.franchise.domain.models.BranchModel;
import com.challenge.franchise.domain.models.ProductModel;
import com.challenge.franchise.infrastructure.api.dto.ProductCreateDto;
import com.challenge.franchise.infrastructure.api.dto.ProductResponseDto;
import com.challenge.franchise.infrastructure.api.dto.ProductUpdateDto;
import com.challenge.franchise.infrastructure.api.dto.ProductUpdateStockDto;
import com.challenge.franchise.infrastructure.mapper.ProductDtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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


   @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
       boolean isDeleted = productUseCase.delete(id);
       if(!isDeleted) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "product not found");
       return new ResponseEntity<>(HttpStatus.OK);
   }

   @PutMapping("/stock")
    public ResponseEntity<?> updateStock(@Valid @RequestBody ProductUpdateStockDto productUpdateStockDto) {
        boolean isModified = productUseCase.modifyStock(productUpdateStockDto.getId(), productUpdateStockDto.getQuantity());
        if (!isModified) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(HttpStatus.OK);
   }
   @GetMapping("/top/{franchiseId}")
    public ResponseEntity<List<ProductResponseDto>> findTop(@PathVariable("franchiseId") Long franchiseId){
               return new ResponseEntity<>( productUseCase.findTopProducts(franchiseId).stream()
                       .map(p -> productDtoMapper.productModelToProductResponseDto(p) ).collect(Collectors.toList()), HttpStatus.OK);
   }

   @PutMapping()
    public ResponseEntity<ProductResponseDto> update (@RequestBody ProductUpdateDto productUpdateDto){
       Optional<ProductModel> productModelResult = productUseCase.findById(productUpdateDto.getId());
       if(productModelResult.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
       ProductModel productModel = productModelResult.get();
       productModel.setName(productUpdateDto.getName());
       return new ResponseEntity<>(
               productDtoMapper.productModelToProductResponseDto(
                       productUseCase.create(productModel)
               ), HttpStatus.OK
       );

   }
}

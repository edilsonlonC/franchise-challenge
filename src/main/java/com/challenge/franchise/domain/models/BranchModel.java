package com.challenge.franchise.domain.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BranchModel {
    private Long id;
    private String name;
    private List<ProductModel> products;
    private FranchiseModel franchise;
}

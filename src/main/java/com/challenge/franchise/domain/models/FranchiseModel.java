package com.challenge.franchise.domain.models;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FranchiseModel {
    private Long id;
    private String name;
    private List<BranchModel> branches;
}

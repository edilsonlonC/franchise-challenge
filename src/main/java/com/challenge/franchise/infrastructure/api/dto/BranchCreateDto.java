package com.challenge.franchise.infrastructure.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BranchCreateDto {
    private String name;
    private Long franchiseId;
}

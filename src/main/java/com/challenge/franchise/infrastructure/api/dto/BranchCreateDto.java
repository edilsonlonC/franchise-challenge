package com.challenge.franchise.infrastructure.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BranchCreateDto {
    @NotBlank(message = "Name is required")
    private String name;
    @NotNull(message = "Franchise id is required")
    private Long franchiseId;
}

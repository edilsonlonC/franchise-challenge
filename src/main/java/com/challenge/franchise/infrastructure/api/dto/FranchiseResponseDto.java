package com.challenge.franchise.infrastructure.api.dto;

import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class FranchiseResponseDto {
    private Long id;
    private String name;
    private List<BranchResponseDto> branches;
}

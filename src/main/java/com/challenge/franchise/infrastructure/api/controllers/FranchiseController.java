package com.challenge.franchise.infrastructure.api.controllers;

import com.challenge.franchise.application.useCases.FranchiseUseCase;
import com.challenge.franchise.domain.models.FranchiseModel;
import com.challenge.franchise.infrastructure.api.dto.FranchiseCreateDto;
import com.challenge.franchise.infrastructure.api.dto.FranchiseResponseDto;
import com.challenge.franchise.infrastructure.mapper.FranchiseDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/franchise")
public class FranchiseController {
    private final FranchiseUseCase franchiseUseCase;
    private final FranchiseDtoMapper franchiseDtoMapper;
    @PostMapping
    public ResponseEntity<FranchiseResponseDto> create(@RequestBody FranchiseCreateDto franchiseCreateDto) {
        FranchiseModel franchiseModel = franchiseDtoMapper.franchiseCreateDtoToFranchiseModel(franchiseCreateDto);
        FranchiseResponseDto franchiseResponseDto = franchiseDtoMapper.franchiseModelToFranchiseResponseDto(
                franchiseUseCase.createFranchise(franchiseModel)
        );
        return new ResponseEntity<>(franchiseResponseDto, HttpStatus.CREATED);
    }
}

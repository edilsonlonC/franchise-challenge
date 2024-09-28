package com.challenge.franchise.infrastructure.api.controllers;

import com.challenge.franchise.application.useCases.BranchUseCase;
import com.challenge.franchise.application.useCases.FranchiseUseCase;
import com.challenge.franchise.domain.models.BranchModel;
import com.challenge.franchise.domain.models.FranchiseModel;
import com.challenge.franchise.infrastructure.api.dto.BranchCreateDto;
import com.challenge.franchise.infrastructure.api.dto.BranchResponseDto;
import com.challenge.franchise.infrastructure.mapper.BranchDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/branch")
@RequiredArgsConstructor
public class BranchController {
    private final FranchiseUseCase franchiseUseCase;
    private final BranchUseCase branchUseCase;
    private final BranchDtoMapper branchDtoMapper;
    @PostMapping
    public ResponseEntity<BranchResponseDto> createBranch (@RequestBody BranchCreateDto branchCreateDto) {
        Optional<FranchiseModel> franchiseResult = franchiseUseCase.findById(branchCreateDto.getFranchiseId());
        if(franchiseResult.isEmpty()) throw  new ResponseStatusException( HttpStatus.NOT_FOUND, "Franchise not found");
        BranchModel branchModel = new BranchModel();
        branchModel.setName(branchCreateDto.getName());
        branchModel.setFranchise(franchiseResult.get());
        return new ResponseEntity<>(branchDtoMapper.branchModelToBranchDtoResponse(
                branchUseCase.createBranch(branchModel)
        ), HttpStatus.CREATED);

    }
}

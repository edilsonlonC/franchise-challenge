package com.challenge.franchise.application.useCases;

import com.challenge.franchise.domain.models.FranchiseModel;
import com.challenge.franchise.domain.repositories.FranchiseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FranchiseUseCase {

    private final FranchiseRepository franchiseRepository;

    public FranchiseModel createFranchise(FranchiseModel franchise) {
        return franchiseRepository.create(franchise);
    }
    public Optional<FranchiseModel> findById(Long franchiseId) {
        return franchiseRepository.findById(franchiseId);
    }

}

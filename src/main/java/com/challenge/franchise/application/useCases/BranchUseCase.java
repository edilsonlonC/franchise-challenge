package com.challenge.franchise.application.useCases;

import com.challenge.franchise.domain.models.BranchModel;
import com.challenge.franchise.domain.repositories.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BranchUseCase {
    private final BranchRepository branchRepository;
    public BranchModel createBranch (BranchModel branchModel) {
        return branchRepository.create(branchModel);
    }
}

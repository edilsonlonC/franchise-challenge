package com.challenge.franchise.domain.repositories;

import com.challenge.franchise.domain.models.BranchModel;

import java.util.Optional;

public interface BranchRepository {
    public BranchModel create (BranchModel branchModel);
    public Optional<BranchModel> findById (Long id);
}

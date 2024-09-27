package com.challenge.franchise.domain.repositories;

import com.challenge.franchise.domain.models.FranchiseModel;

import java.util.Optional;


public interface FranchiseRepository {
   FranchiseModel create(FranchiseModel franchise);
   Optional<FranchiseModel> findById(Long franchiseId);
}

package com.challenge.franchise.infrastructure.repositories;

import com.challenge.franchise.domain.models.BranchModel;
import com.challenge.franchise.domain.repositories.BranchRepository;
import com.challenge.franchise.infrastructure.database.entities.BranchEntity;
import com.challenge.franchise.infrastructure.database.entities.FranchiseEntity;
import com.challenge.franchise.infrastructure.database.jpaRepisitories.BranchJpaRepository;
import com.challenge.franchise.infrastructure.mapper.BranchMapper;
import com.challenge.franchise.infrastructure.mapper.FranchiseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BranchRepositoryImpl implements BranchRepository {
    private final BranchJpaRepository branchJpaRepository;
    private final BranchMapper branchMapper;
    private final FranchiseMapper franchiseMapper;
    @Override
    public BranchModel create(BranchModel branchModel) {
        BranchEntity branchEntity = branchMapper.branchModelToBranchEntity(branchModel);
        FranchiseEntity franchiseEntity = franchiseMapper.franchiseModelToFranchiseEntity(branchModel.getFranchise());
        branchEntity.setFranchise(franchiseEntity);
       return branchMapper.BranchEntityToBranchModel(
               branchJpaRepository.save(branchEntity)
       );
    }
}

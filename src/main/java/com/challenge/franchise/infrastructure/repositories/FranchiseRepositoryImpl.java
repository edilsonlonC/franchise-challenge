package com.challenge.franchise.infrastructure.repositories;

import com.challenge.franchise.domain.models.FranchiseModel;
import com.challenge.franchise.domain.repositories.FranchiseRepository;
import com.challenge.franchise.infrastructure.database.entities.FranchiseEntity;
import com.challenge.franchise.infrastructure.database.jpaRepisitories.FranchiseJpaRepository;
import com.challenge.franchise.infrastructure.mapper.FranchiseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FranchiseRepositoryImpl implements FranchiseRepository {
    private final FranchiseJpaRepository franchiseJpaRepository;
    private final FranchiseMapper franchiseMapper;
    @Override
    public FranchiseModel create(FranchiseModel franchise) {
        return franchiseMapper.franchiseEntityToFranchiseModel(
                franchiseJpaRepository.save(franchiseMapper.franchiseModelToFranchiseEntity(franchise))
        );
    }
    public Optional<FranchiseModel> findById (Long franchiseId) {
       Optional<FranchiseEntity> franchiseEntity = franchiseJpaRepository.findById(franchiseId);
       FranchiseModel franchiseModel = franchiseMapper.franchiseEntityToFranchiseModel(franchiseEntity.get());
       return Optional.ofNullable(
              franchiseMapper.franchiseEntityToFranchiseModel(
                      franchiseJpaRepository.findById(franchiseId).orElseGet(null)
              )
       );
    }
}

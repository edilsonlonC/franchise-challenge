package com.challenge.franchise.infrastructure.mapper;


import com.challenge.franchise.domain.models.FranchiseModel;
import com.challenge.franchise.infrastructure.database.entities.FranchiseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FranchiseMapper {
    @Mapping(target = "branches", ignore = true)
    FranchiseModel franchiseEntityToFranchiseModel(FranchiseEntity franchise);

    FranchiseEntity franchiseModelToFranchiseEntity(FranchiseModel franchise);
}

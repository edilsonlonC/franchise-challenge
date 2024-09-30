package com.challenge.franchise.infrastructure.mapper;

import com.challenge.franchise.domain.models.BranchModel;
import com.challenge.franchise.infrastructure.database.entities.BranchEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = FranchiseMapper.class)
public interface BranchMapper {
    BranchEntity branchModelToBranchEntity(BranchModel branch);
    @Mapping(target = "products", ignore = true)
    BranchModel branchEntityToBranchModel(BranchEntity branch);
}

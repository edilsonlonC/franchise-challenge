package com.challenge.franchise.infrastructure.mapper;

import com.challenge.franchise.domain.models.FranchiseModel;
import com.challenge.franchise.infrastructure.api.dto.FranchiseCreateDto;
import com.challenge.franchise.infrastructure.api.dto.FranchiseResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FranchiseDtoMapper {
    FranchiseDtoMapper INSTANCE = Mappers.getMapper(FranchiseDtoMapper.class);
    FranchiseModel franchiseCreateDtoToFranchiseModel(FranchiseCreateDto franchise);
    FranchiseResponseDto franchiseModelToFranchiseResponseDto(FranchiseModel franchise);
}

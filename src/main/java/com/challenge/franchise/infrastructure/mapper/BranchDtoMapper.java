package com.challenge.franchise.infrastructure.mapper;

import com.challenge.franchise.domain.models.BranchModel;
import com.challenge.franchise.infrastructure.api.dto.BranchResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BranchDtoMapper {
    BranchDtoMapper INSTANCE = Mappers.getMapper(BranchDtoMapper.class);
    BranchResponseDto branchModelToBranchDtoResponse(BranchModel branch);
}

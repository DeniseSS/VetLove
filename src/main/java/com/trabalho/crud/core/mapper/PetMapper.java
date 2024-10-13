package com.trabalho.crud.core.mapper;

import org.mapstruct.Mapper;

import com.trabalho.crud.core.dto.PetDto;
import com.trabalho.crud.core.entity.Pet;

@Mapper(componentModel = "spring")
public interface PetMapper {

  Pet toEntity(PetDto dto);

  PetDto toDto(Pet entity);
  
}

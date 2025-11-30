package com.spring.boot.mapper;
import com.spring.boot.dto.ChefDto;
import com.spring.boot.model.Chef;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChefMapper {

    Chef toEntity(ChefDto chefDto);
    ChefDto toDto(Chef chef);

    List<Chef> toEntityList(List<ChefDto> chefs);
    List<ChefDto> toDtoList(List<Chef> chefs);
}

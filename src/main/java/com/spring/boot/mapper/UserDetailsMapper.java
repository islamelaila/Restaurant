package com.spring.boot.mapper;

import com.spring.boot.dto.UserDetailsDto;
import com.spring.boot.model.UserDetails;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDetailsMapper {

    UserDetails toEntity(UserDetailsDto userDetailsDto);

    UserDetailsDto toDto(UserDetails userDetails);

    List<UserDetailsDto> toDtoList(List<UserDetails> userDetailsList);
    List<UserDetails> toEntityList(List<UserDetailsDto> userDetailsDtoList);



}

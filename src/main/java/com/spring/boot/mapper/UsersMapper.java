package com.spring.boot.mapper;

import com.spring.boot.dto.UsersDto;
import com.spring.boot.model.Users;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    Users toEntity(UsersDto usersDTO);

    List<Users> toEntityList(List<UsersDto> usersDTOList);

    List<UsersDto> toDtoList(List<Users> usersList);

    UsersDto toDto(Users users);
}

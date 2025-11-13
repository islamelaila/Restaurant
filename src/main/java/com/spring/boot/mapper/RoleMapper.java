package com.spring.boot.mapper;
import com.spring.boot.dto.RoleDto;
import com.spring.boot.model.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role toEntity(RoleDto roleDto);

    List<Role> toEntityList(List<RoleDto> roleDtoList);

    List<RoleDto> toDtoList(List<Role> roleList);

    RoleDto toDto(Role role);

}

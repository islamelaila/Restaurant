package com.spring.boot.service;

import com.spring.boot.dto.RoleDto;
import com.spring.boot.enums.Roles;
import com.spring.boot.model.Role;

public interface RoleService {

    RoleDto createRole(RoleDto roleDto);

    RoleDto findByCode(String code);


}

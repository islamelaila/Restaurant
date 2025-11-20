package com.spring.boot.service.impl;
import com.spring.boot.dto.RoleDto;
import com.spring.boot.enums.Roles;
import com.spring.boot.mapper.RoleMapper;
import com.spring.boot.model.Role;
import com.spring.boot.repo.RoleRepo;
import com.spring.boot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepo roleRepo;

    private RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleRepo roleRepo , RoleMapper roleMapper) {
        this.roleRepo = roleRepo;
        this.roleMapper = roleMapper;
    }




    @Override
    public RoleDto createRole(RoleDto roleDto) {
        Role role = roleRepo.save(roleMapper.toEntity(roleDto));
        return roleMapper.toDto(role);
    }



    @Override
    public RoleDto findByCode(String code) {
        Role role = roleRepo.findByCode(code);
        if (role == null) {
            throw new RuntimeException("Role not found with code: " + code);
        }
        return roleMapper.toDto(role);
    }

}

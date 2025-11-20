package com.spring.boot.service.impl;
import com.spring.boot.config.jwt.TokenHandler;
import com.spring.boot.dto.RoleDto;
import com.spring.boot.dto.UsersDto;
import com.spring.boot.enums.Roles;
import com.spring.boot.mapper.RoleMapper;
import com.spring.boot.mapper.UsersMapper;
import com.spring.boot.model.Users;
import com.spring.boot.repo.UsersRepo;
import com.spring.boot.service.RoleService;
import com.spring.boot.service.UsersService;
import com.spring.boot.vm.LoginRequestVM;
import com.spring.boot.vm.LoginResponseVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class UsersServiceImpl implements UsersService {


    private UsersRepo usersRepo;


    private UsersMapper usersMapper;


    private PasswordEncoder passwordEncoder;

    private TokenHandler tokenHandler;


    private RoleService roleService;


    private RoleMapper roleMapper ;

    @Autowired
    public UsersServiceImpl(UsersRepo usersRepo, UsersMapper usersMapper , PasswordEncoder passwordEncoder , TokenHandler tokenHandler , RoleService roleService , RoleMapper roleMapper ) {
        this.usersRepo = usersRepo;
        this.usersMapper = usersMapper;
        this.passwordEncoder = passwordEncoder;
        this.tokenHandler = tokenHandler;
        this.roleService = roleService;
        this.roleMapper = roleMapper;

    }


    @Override
    public List<UsersDto> getAllUsers() {
        List<Users> users = usersRepo.findAll();
        return usersMapper.toDtoList(users);
    }

    @Override
    public UsersDto signUp(UsersDto usersDto) {
        Users user = usersMapper.toEntity(usersDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        RoleDto roleDto = roleService.findByCode(Roles.USER.toString());
        user.setRoles(Arrays.asList(roleMapper.toEntity(roleDto)));
        usersRepo.save(user);
        return usersMapper.toDto(user);
    }

    @Override
    public LoginResponseVM login(LoginRequestVM loginRequestVM) {
        Users user = usersRepo.findByUsername(loginRequestVM.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        if (!passwordEncoder.matches(loginRequestVM.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        UsersDto usersDto = usersMapper.toDto(user);
        String token = tokenHandler.CreateToken(usersDto);
        return new LoginResponseVM(token);
    }


    @Override
    public UsersDto getUserByUsername(String username) {
        return usersRepo.findByUsername(username)
                .map(usersMapper::toDto)
                .orElse(null);
    }



}

package com.spring.boot.service.impl;
import com.spring.boot.dto.RoleDto;
import com.spring.boot.dto.UsersDto;
import com.spring.boot.mapper.UsersMapper;
import com.spring.boot.model.Role;
import com.spring.boot.model.Users;
import com.spring.boot.repo.UsersRepo;
import com.spring.boot.service.RoleService;
import com.spring.boot.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsersServiceImpl implements UsersService {


    private UsersRepo usersRepo;


    private UsersMapper usersMapper;


    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsersServiceImpl(UsersRepo usersRepo, UsersMapper usersMapper , PasswordEncoder passwordEncoder) {
        this.usersRepo = usersRepo;
        this.usersMapper = usersMapper;
        this.passwordEncoder = passwordEncoder;

    }


    @Override
    public List<UsersDto> getAllUsers() {
        List<Users> users = usersRepo.findAll();
        return usersMapper.toDtoList(users);
    }

    @Override
    public UsersDto saveUser(UsersDto usersDto) {
        Users user = usersMapper.toEntity(usersDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersRepo.save(user);
        return usersMapper.toDto(user);
    }

    @Override
    public UsersDto getUserByUsername(String username) {
        Users user = usersRepo.findByUsername(username);
        return usersMapper.toDto(user);
    }
}

package com.spring.boot.service;
import com.spring.boot.dto.UsersDto;

import java.util.List;

public interface UsersService {

    List<UsersDto> getAllUsers();

    UsersDto saveUser(UsersDto usersDto);

    UsersDto getUserByUsername(String username);

}

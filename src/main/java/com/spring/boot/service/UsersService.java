package com.spring.boot.service;
import com.spring.boot.dto.UsersDto;
import com.spring.boot.vm.LoginRequestVM;
import com.spring.boot.vm.LoginResponseVM;

import java.util.List;

public interface UsersService {

    List<UsersDto> getAllUsers();

    UsersDto signUp(UsersDto usersDto);

    LoginResponseVM login (LoginRequestVM loginRequestVM) ;

     UsersDto getUserByUsername (String username) ;

}

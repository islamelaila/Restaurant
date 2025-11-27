package com.spring.boot.service;
import com.spring.boot.dto.UsersDto;
import com.spring.boot.vm.LoginRequestVm;
import com.spring.boot.vm.LoginResponseVm;

import java.util.List;

public interface UsersService {

    List<UsersDto> getAllUsers();

    UsersDto signUp(UsersDto usersDto);

    LoginResponseVm login (LoginRequestVm loginRequestVM) ;

     UsersDto getUserByUsername (String username) ;

}

package com.spring.boot.service;

import com.spring.boot.dto.UserDetailsDto;

import java.util.List;

public interface UserDetailsService {

    List<UserDetailsDto> getAllUserDetails();

    UserDetailsDto saveUserDetails(UserDetailsDto userDetailsDto);
}

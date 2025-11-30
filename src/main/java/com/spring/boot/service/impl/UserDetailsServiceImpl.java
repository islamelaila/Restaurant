package com.spring.boot.service.impl;

import com.spring.boot.dto.UserDetailsDto;
import com.spring.boot.mapper.UserDetailsMapper;
import com.spring.boot.model.UserDetails;
import com.spring.boot.repo.UserDetailsRepo;
import com.spring.boot.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserDetailsRepo userDetailsRepo;

    private UserDetailsMapper userDetailsMapper ;

    @Autowired
    public UserDetailsServiceImpl(UserDetailsRepo userDetailsRepo , UserDetailsMapper userDetailsMapper) {
        this.userDetailsRepo = userDetailsRepo;
        this.userDetailsMapper = userDetailsMapper;
    }





    @Override
    public List<UserDetailsDto> getAllUserDetails() {
        List<UserDetails> userDetailsList = userDetailsRepo.findAll();
        return userDetailsMapper.toDtoList(userDetailsList);
    }

    @Override
    public UserDetailsDto saveUserDetails(UserDetailsDto userDetailsDto) {
        if(Objects.nonNull(userDetailsDto.getId())){
            throw new RuntimeException("User details already exists");
        }
        UserDetails userDetails = userDetailsRepo.save(userDetailsMapper.toEntity(userDetailsDto));
        userDetailsDto.setId(userDetails.getId());
        return userDetailsMapper.toDto(userDetails);
    }
}

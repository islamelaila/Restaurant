package com.spring.boot.service;

import com.spring.boot.dto.ChefDto;

import java.util.List;

public interface ChefService {

    List<ChefDto> getAllChefs();

    ChefDto saveChef(ChefDto chefDto);

}

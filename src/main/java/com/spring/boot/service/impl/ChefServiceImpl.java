package com.spring.boot.service.impl;
import com.spring.boot.dto.ChefDto;
import com.spring.boot.mapper.ChefMapper;
import com.spring.boot.model.Chef;
import com.spring.boot.repo.ChefRepo;
import com.spring.boot.service.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ChefServiceImpl implements ChefService {

    private ChefRepo chefRepo ;

    private ChefMapper chefMapper;

    @Autowired
    public ChefServiceImpl(ChefRepo chefRepo , ChefMapper chefMapper) {
        this.chefRepo = chefRepo;
        this.chefMapper = chefMapper;
    }


    @Override
    public List<ChefDto> getAllChefs() {
        List<Chef> chefs = chefRepo.findAll();
        return chefMapper.toDtoList(chefs) ;
    }

    @Override
    public ChefDto saveChef(ChefDto chefDto) {
        if (Objects.nonNull(chefDto.getId())){
            throw new RuntimeException("id teacher not required");
        }
        Chef chefExist = chefRepo.findByName(chefDto.getName());
        if (chefExist!= null){
            throw new RuntimeException("Chef already exist");
        }
        Chef chef = chefRepo.save(chefMapper.toEntity(chefDto));

        chefDto.setId(chef.getId());
        return chefMapper.toDto(chef);
    }
}


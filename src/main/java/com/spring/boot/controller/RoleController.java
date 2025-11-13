package com.spring.boot.controller;

import com.spring.boot.dto.RoleDto;
import com.spring.boot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/role")
public class RoleController {

    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @PostMapping ("/create")
    public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto roleDto) throws URISyntaxException {
        return ResponseEntity.created(new URI("/role/create")).body(roleService.createRole(roleDto));
    }
}

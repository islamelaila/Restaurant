package com.spring.boot.controller;

import com.spring.boot.dto.RoleDto;
import com.spring.boot.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/role")
@Tag(
        name = "Role Controller",
        description = "APIs responsible for managing roles and permissions"
)
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }



    @PostMapping("/create")
    @Operation(
            summary = "Create new role",
            description = "Create a new role in the system"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Role created successfully",
                    content = @Content(
                            schema = @Schema(implementation = RoleDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid role data"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error"
            )
    })
    public ResponseEntity<RoleDto> createRole(
            @RequestBody RoleDto roleDto
    ) throws URISyntaxException {
        return ResponseEntity
                .created(new URI("/role/create"))
                .body(roleService.createRole(roleDto));
    }
}

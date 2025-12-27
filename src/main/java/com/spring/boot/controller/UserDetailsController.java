package com.spring.boot.controller;

import com.spring.boot.dto.UserDetailsDto;
import com.spring.boot.service.UserDetailsService;
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
import java.util.List;

@RestController
@RequestMapping("/userDetails")
@Tag(
        name = "User Details Controller",
        description = "APIs responsible for managing user personal details"
)
public class UserDetailsController {

    private final UserDetailsService userDetailsService;

    @Autowired
    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }



    @GetMapping("/all")
    @Operation(
            summary = "Get all user details",
            description = "Retrieve all user details"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "User details retrieved successfully",
                    content = @Content(
                            schema = @Schema(implementation = UserDetailsDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error"
            )
    })
    public ResponseEntity<List<UserDetailsDto>> getAllUserDetails() {
        return ResponseEntity.ok(userDetailsService.getAllUserDetails());
    }



    @PostMapping("/save")
    @Operation(
            summary = "Create user details",
            description = "Save user personal details"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "User details saved successfully",
                    content = @Content(
                            schema = @Schema(implementation = UserDetailsDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid user details data"
            )
    })
    public ResponseEntity<UserDetailsDto> saveUserDetails(
            @RequestBody UserDetailsDto userDetailsDto
    ) throws URISyntaxException {
        return ResponseEntity
                .created(new URI("/userDetails/save"))
                .body(userDetailsService.saveUserDetails(userDetailsDto));
    }
}

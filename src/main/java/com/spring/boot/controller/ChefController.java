package com.spring.boot.controller;

import com.spring.boot.dto.ChefDto;
import com.spring.boot.service.ChefService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/chefs")
@Tag(
        name = "Chef Controller",
        description = "APIs responsible for managing chefs"
)
public class ChefController {

    private final ChefService chefService;

    @Autowired
    public ChefController(ChefService chefService) {
        this.chefService = chefService;
    }



    @GetMapping("/all")
    @Operation(
            summary = "Get all chefs",
            description = "Retrieve list of all chefs"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Chefs retrieved successfully",
                    content = @Content(
                            schema = @Schema(implementation = ChefDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error"
            )
    })
    public ResponseEntity<List<ChefDto>> getAllChefs() {
        return ResponseEntity.ok(chefService.getAllChefs());
    }



    @PostMapping("/save")
    @Operation(
            summary = "Create new chef",
            description = "Create a new chef"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Chef created successfully",
                    content = @Content(
                            schema = @Schema(implementation = ChefDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid chef data"
            )
    })
    public ResponseEntity<ChefDto> saveChef(
            @RequestBody @Valid ChefDto chefDto
    ) throws URISyntaxException {
        return ResponseEntity
                .created(new URI("/chefs/save"))
                .body(chefService.saveChef(chefDto));
    }
}

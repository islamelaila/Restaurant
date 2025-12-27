package com.spring.boot.controller;

import com.spring.boot.dto.ContactInfoDto;
import com.spring.boot.service.ContactInfoService;
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
@RequestMapping("/contact")
@Tag(
        name = "Contact Info Controller",
        description = "APIs responsible for managing user contact information"
)
public class ContactInfoController {

    private final ContactInfoService contactInfoService;

    @Autowired
    public ContactInfoController(ContactInfoService contactInfoService) {
        this.contactInfoService = contactInfoService;
    }



    @PostMapping("/save")
    @Operation(
            summary = "Save contact information",
            description = "Save user contact information"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Contact information saved successfully",
                    content = @Content(
                            schema = @Schema(implementation = ContactInfoDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid contact information data"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error"
            )
    })
    public ResponseEntity<ContactInfoDto> saveContactInfo(
            @RequestBody ContactInfoDto contactInfoDto
    ) throws URISyntaxException {
        return ResponseEntity
                .created(new URI("/contact/save"))
                .body(contactInfoService.saveContactInfo(contactInfoDto));
    }
}

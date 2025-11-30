package com.spring.boot.controller;
import com.spring.boot.dto.UserDetailsDto;
import com.spring.boot.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/userDetails")
public class UserDetailsController {


    private UserDetailsService userDetailsService;

    @Autowired
    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }



    @GetMapping("/all")
    ResponseEntity<List<UserDetailsDto>> getAllUserDetails() {
        List<UserDetailsDto> userDetailsDtos = userDetailsService.getAllUserDetails();
        return ResponseEntity.ok(userDetailsDtos);
    }


    @PostMapping("/save")
    ResponseEntity<UserDetailsDto> saveUserDetails(@RequestBody UserDetailsDto userDetailsDto) throws URISyntaxException {
        UserDetailsDto savedUserDetailsDto = userDetailsService.saveUserDetails(userDetailsDto);
        return ResponseEntity.created(new URI("/userDetails/save")).body(savedUserDetailsDto);
    }

}

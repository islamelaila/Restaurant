package com.spring.boot.controller;
import com.spring.boot.dto.UsersDto;
import com.spring.boot.service.UsersService;
import com.spring.boot.vm.LoginRequestVm;
import com.spring.boot.vm.LoginResponseVm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {

    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }


    @GetMapping("/All")
    public ResponseEntity<List<UsersDto>> getAllUsers() {
        return ResponseEntity.ok(usersService.getAllUsers());
    }


    @PostMapping("/signup")
    public ResponseEntity<UsersDto> signUp(@RequestBody UsersDto usersDto) throws URISyntaxException {
        return ResponseEntity.created(new URI("/auth/signup/")).body(usersService.signUp(usersDto));
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponseVm> login(@RequestBody @Valid LoginRequestVm loginRequestVM) {
        return ResponseEntity.ok(usersService.login(loginRequestVM));
    }


}

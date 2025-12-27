package com.spring.boot.controller;
import com.spring.boot.dto.UsersDto;
import com.spring.boot.service.UsersService;
import com.spring.boot.vm.LoginRequestVm;
import com.spring.boot.vm.LoginResponseVm;
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
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(
        name = "Authentication & Users",
        description = "APIs responsible for user registration, authentication, and user management"
)
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }



    @GetMapping("/all")
    @Operation(
            summary = "Get all users",
            description = "Retrieve list of all registered users"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Users retrieved successfully",
                    content = @Content(schema = @Schema(implementation = UsersDto.class))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error"
            )
    })
    public ResponseEntity<List<UsersDto>> getAllUsers() {
        return ResponseEntity.ok(usersService.getAllUsers());
    }



    @PostMapping("/signup")
    @Operation(
            summary = "User registration",
            description = "Register a new user"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "User registered successfully",
                    content = @Content(schema = @Schema(implementation = UsersDto.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid registration data")
    })
    public ResponseEntity<UsersDto> signUp(
            @RequestBody @Valid UsersDto usersDto
    ) throws URISyntaxException {
        return ResponseEntity
                .created(new URI("/auth/signup"))
                .body(usersService.signUp(usersDto));
    }

    @PostMapping("/login")
    @Operation(
            summary = "User login",
            description = "Authenticate user and return JWT / login response"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Login successful",
                    content = @Content(schema = @Schema(implementation = LoginResponseVm.class))
            ),
            @ApiResponse(responseCode = "401", description = "Invalid username or password"),
            @ApiResponse(responseCode = "400", description = "Invalid login request")
    })
    public ResponseEntity<LoginResponseVm> login(
            @RequestBody @Valid LoginRequestVm loginRequestVM
    ) {
        return ResponseEntity.ok(usersService.login(loginRequestVM));
    }
}

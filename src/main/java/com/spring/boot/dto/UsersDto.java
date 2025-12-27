package com.spring.boot.dto;
import com.spring.boot.model.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {

    private Long id ;
    @NotBlank(message = "Username required field ")
    @Schema(
            name = "username",
            description = "Username of the user",
            example = "islam El-aila"
    )
    private String username ;
    @NotBlank(message = "Password required field ")
    private String password ;

    private List<Role> roles;


}

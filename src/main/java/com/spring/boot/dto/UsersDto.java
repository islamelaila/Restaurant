package com.spring.boot.dto;
import com.spring.boot.model.ContactInfo;
import com.spring.boot.model.Role;
import com.spring.boot.model.UserDetails;
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
    private String username ;
    @NotBlank(message = "Password required field ")
    private String password ;

    private List<Role> roles;

    private UserDetails userDetails;


    private List<ContactInfo> contactInfos;

}

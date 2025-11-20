package com.spring.boot.config.security;
import com.spring.boot.dto.UsersDto;
import com.spring.boot.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private UsersService usersService;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String userName = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        UsersDto usersDto = usersService.getUserByUsername(userName);
        if (!passwordEncoder.matches(password, usersDto.getPassword())){
            throw new BadCredentialsException("Invalid username or password");
        }

        List<SimpleGrantedAuthority> roles = usersDto.getRoles().stream().map(roleDto -> new SimpleGrantedAuthority("ROLE_" + roleDto.getCode())).collect(Collectors.toList());


        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userName,password,roles);

        return usernamePasswordAuthenticationToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

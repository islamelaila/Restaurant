package com.spring.boot.filter;
import com.spring.boot.config.jwt.TokenHandler;
import com.spring.boot.dto.UsersDto;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Component
public class AuthFilter extends OncePerRequestFilter {

    @Autowired
    private TokenHandler tokenHandler ;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        if (Objects.isNull(token) || !token.startsWith("Bearer")){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        token = token.substring(7);
        UsersDto usersDto = tokenHandler.VaildateToken(token);
        if (Objects.isNull(usersDto)){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        List<SimpleGrantedAuthority> roles = usersDto.getRoles().stream().map(roleDto -> new SimpleGrantedAuthority("ROLE_" + roleDto.getCode())).collect(Collectors.toList());
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(usersDto, usersDto.getPassword(), roles);
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        filterChain.doFilter(request, response);



    }


    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String uri = request.getRequestURI();
        return uri.contains("/auth/login") || uri.contains("/auth/signup");
    }

}


package com.spring.boot.config.auditing;
import com.spring.boot.dto.UsersDto;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
@Component
public class AuditAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.isNull(authentication) || Objects.isNull(authentication.getPrincipal()) || authentication.getPrincipal().equals("anonymousUser") ){
            return Optional.of("RES-0");
        }
        UsersDto usersDto = (UsersDto) authentication.getPrincipal();
        return Optional.of(usersDto.getUsername());
    }
}

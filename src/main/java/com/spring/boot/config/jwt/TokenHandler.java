package com.spring.boot.config.jwt;
import com.spring.boot.dto.UsersDto;
import com.spring.boot.helper.JwtToken;
import com.spring.boot.service.UsersService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Duration;
import java.util.Date;
import java.util.Objects;

@Component
public class TokenHandler {


    private String secret ;

    private Duration time ;

    private JwtBuilder jwtBuilder ;

    private JwtParser jwtParser ;

    @Lazy
    @Autowired
    private UsersService usersService ;


    public TokenHandler(JwtToken jwtToken ) {
        this.secret = jwtToken.getSecret();
        this.time = jwtToken.getTime();
        Key key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        jwtBuilder = Jwts.builder().signWith(key);
        jwtParser = Jwts.parserBuilder().setSigningKey(key).build();

    }

    public String CreateToken(UsersDto usersDto) {
        Date issuDate = new Date() ;
        Date expireDate = Date.from(issuDate.toInstant().plus(time));
        jwtBuilder.setSubject(usersDto.getUsername());
        jwtBuilder.setIssuedAt(issuDate);
        jwtBuilder.setExpiration(expireDate);
        return jwtBuilder.compact();
    }




    public UsersDto VaildateToken(String token) {
        try {

            if (!jwtParser.isSigned(token)){
                return null ;
            }

            Claims claims = jwtParser.parseClaimsJws(token).getBody();
            Date issueDate = claims.getIssuedAt();
            Date expireDate = claims.getExpiration();
            String username = claims.getSubject();

            UsersDto usersDto = usersService.getUserByUsername(username);

            boolean isTokenValid =expireDate.after(issueDate) && expireDate.after(new Date());

            if (isTokenValid && Objects.nonNull(usersDto)){
                return usersDto ;
            }

            return null ;

        }catch (Exception e){
            return null ;
        }

    }

}

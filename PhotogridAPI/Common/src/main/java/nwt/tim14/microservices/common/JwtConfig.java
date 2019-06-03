package nwt.tim14.microservices.common;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

@Getter
@ToString
public class JwtConfig {
    @Value("${security.jwt.uri:/api/users/auth/**}")
    private String Uri;

    @Value("${security.jwt.header:Authorization}")
    private String header;

    @Value("${security.jwt.prefix:Bearer }")
    private String prefix;

    @Value("${security.jwt.expiration:#{24*60*60}}")
    private int expiration;

    @Value("${security.jwt.secret:JwtSecretKey}")
    private String secret;

}
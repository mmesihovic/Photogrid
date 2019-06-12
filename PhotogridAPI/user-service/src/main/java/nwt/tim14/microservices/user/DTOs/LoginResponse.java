package nwt.tim14.microservices.user.DTOs;

import lombok.Builder;

@Builder
public class LoginResponse {
    public String token;

    public String username;

    public long expires_in;
}

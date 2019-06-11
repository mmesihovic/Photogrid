package nwt.tim14.microservices.user.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@Builder
@AllArgsConstructor
public class UserResponse {
    public Long id;

    public String firstName;

    public String lastName;

    public String username;

    public String email;

    public List<String> roles;
}

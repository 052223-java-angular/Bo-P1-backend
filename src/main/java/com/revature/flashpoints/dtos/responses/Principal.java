package com.revature.flashpoints.dtos.responses;

import com.revature.flashpoints.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Principal {
    private String id;
    private String username;
    private String role;
    private String token;
    private Boolean isBanned;
    private String profile_img;


    public Principal(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.role = user.getRole().getName();
        this.isBanned = user.getIsBanned();
        this.profile_img = user.getProfile_img();
    }
}

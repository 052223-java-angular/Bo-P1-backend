package com.revature.flashpoints.dtos.requests;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewTagRequest {
    private String user_id;
    private String role_id;
    private String name;
    private String image;
}

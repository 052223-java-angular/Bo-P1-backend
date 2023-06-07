package com.revature.flashpoints.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewArticleRequest {
    private String user_id;
    private String token;
    private String title;
    private String image_url;
    private String tag_name;
    private String content;
}

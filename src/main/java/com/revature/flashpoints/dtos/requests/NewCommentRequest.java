package com.revature.flashpoints.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewCommentRequest {
    private String user_id;
    private String article_id;
    private String token;
    private String comment;
}

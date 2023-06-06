package com.revature.flashpoints.dtos.requests;

import com.revature.flashpoints.entities.User;
import com.revature.flashpoints.entities.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewCommentRequest {
    private User user;
    private Article article;
    private Token token;
    private String comment;
}

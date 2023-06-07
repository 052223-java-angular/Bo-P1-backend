package com.revature.flashpoints.services;

import org.springframework.stereotype.Service;
import com.revature.flashpoints.entities.Article;
import com.revature.flashpoints.dtos.requests.NewArticleRequest;
import com.revature.flashpoints.repositories.ArticleRepository;
import com.revature.flashpoints.repositories.UserRepository;
import com.revature.flashpoints.services.UserService;

@Service
public class ArticleService {
    private ArticleRepository articleRepository;
    private UserService userService;
    
    // public Article newArticle(NewArticleRequest req) {
    //     User user = userService.findById(req.getUser_id());
    // }
}

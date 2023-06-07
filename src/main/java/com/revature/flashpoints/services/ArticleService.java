package com.revature.flashpoints.services;

import org.springframework.stereotype.Service;
import com.revature.flashpoints.repositories.ArticleRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final UserService userService;
}

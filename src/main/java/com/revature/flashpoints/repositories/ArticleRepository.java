package com.revature.flashpoints.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.flashpoints.entities.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, String> {
    Optional<Article> findByTitle(String title);
}

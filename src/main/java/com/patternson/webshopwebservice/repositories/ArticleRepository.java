package com.patternson.webshopwebservice.repositories;

import com.patternson.webshopwebservice.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}

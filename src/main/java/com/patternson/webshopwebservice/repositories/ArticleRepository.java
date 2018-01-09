package com.patternson.webshopwebservice.repositories;

import com.patternson.webshopwebservice.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * Created by Tobias Pettersson 20180108
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {
}

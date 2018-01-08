package com.patternson.webshopwebservice.services;

import com.patternson.webshopwebservice.api.v1.model.ArticleDTO;

import java.util.List;

public interface ArticleService {

    List<ArticleDTO> getAllArticles();

    ArticleDTO getArticleById(Long id);

    ArticleDTO createNewArticle(ArticleDTO articleDTO);

    ArticleDTO saveArticleByDTO(Long id, ArticleDTO articleDTO);

    ArticleDTO patchArticle(Long id, ArticleDTO articleDTO);

    void deleteArticleById(Long id);
}

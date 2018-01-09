package com.patternson.webshopwebservice.api.v1.mapper;

import com.patternson.webshopwebservice.api.v1.model.ArticleDTO;
import com.patternson.webshopwebservice.domain.Article;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * Created by Tobias Pettersson 20180108
 */
@Mapper
public interface ArticleMapper {

    ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);

    ArticleDTO articleToArticleDTO(Article article);

    Article articleDtoToArticle(ArticleDTO articleDTO);

}

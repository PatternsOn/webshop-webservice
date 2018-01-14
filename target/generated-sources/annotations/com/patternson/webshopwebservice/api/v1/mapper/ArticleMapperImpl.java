package com.patternson.webshopwebservice.api.v1.mapper;

import com.patternson.webshopwebservice.api.v1.model.ArticleDTO;
import com.patternson.webshopwebservice.domain.Article;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-01-14T14:17:45+0100",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
)
@Component
public class ArticleMapperImpl implements ArticleMapper {

    @Override
    public ArticleDTO articleToArticleDTO(Article article) {
        if ( article == null ) {
            return null;
        }

        ArticleDTO articleDTO = new ArticleDTO();

        articleDTO.setName( article.getName() );
        articleDTO.setDescription( article.getDescription() );
        articleDTO.setPrice( article.getPrice() );
        articleDTO.setCompany( article.getCompany() );
        articleDTO.setStock( article.getStock() );

        return articleDTO;
    }

    @Override
    public Article articleDtoToArticle(ArticleDTO articleDTO) {
        if ( articleDTO == null ) {
            return null;
        }

        Article article = new Article();

        article.setName( articleDTO.getName() );
        article.setDescription( articleDTO.getDescription() );
        article.setPrice( articleDTO.getPrice() );
        article.setCompany( articleDTO.getCompany() );
        article.setStock( articleDTO.getStock() );

        return article;
    }
}

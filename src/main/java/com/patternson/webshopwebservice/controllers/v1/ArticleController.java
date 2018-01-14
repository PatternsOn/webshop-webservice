package com.patternson.webshopwebservice.controllers.v1;

import com.patternson.webshopwebservice.api.v1.model.ArticleDTO;
import com.patternson.webshopwebservice.api.v1.model.ArticleListDTO;
import com.patternson.webshopwebservice.services.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *
 * Created by Tobias Pettersson 20180108
 */
@Slf4j
@RestController
@RequestMapping(ArticleController.BASE_URL)
public class ArticleController {

    public static final String BASE_URL = "/api/v1/articles";

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ArticleListDTO getListOfArticles() {
        return new ArticleListDTO(articleService.getAllArticles());
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ArticleDTO getArticleById(@PathVariable Long id) {
        return  articleService.getArticleById(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ArticleDTO createNewArticle(@Valid @RequestBody ArticleDTO articleDTO) {
        return articleService.createNewArticle(articleDTO);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ArticleDTO updateArticle(@PathVariable Long id, @RequestBody ArticleDTO articleDTO) {
        return articleService.saveArticleByDTO(id, articleDTO);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ArticleDTO patchArticle(@PathVariable Long id, @RequestBody ArticleDTO articleDTO) {
        return articleService.patchArticle(id, articleDTO);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticleById(id);
    }
}

package com.patternson.webshopwebservice.controllers.v1;


import com.patternson.webshopwebservice.api.v1.model.ArticleDTO;
import com.patternson.webshopwebservice.api.v1.model.ArticleListDTO;
import com.patternson.webshopwebservice.services.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 * Created by Tobias Pettersson 20180108
 */
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ArticleDTO createNewArticle(@RequestBody ArticleDTO articleDTO) {
        return articleService.createNewArticle(articleDTO);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ArticleDTO updateArticle(@PathVariable Long id, @RequestBody ArticleDTO articleDTO) {
        return articleService.saveArticleByDTO(id, articleDTO);
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ArticleDTO patchArticle(@PathVariable Long id, @RequestBody ArticleDTO articleDTO) {
        return articleService.patchArticle(id, articleDTO);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticleById(id);
    }
}

package com.patternson.webshopwebservice.bootstrap;

import com.patternson.webshopwebservice.domain.Article;
import com.patternson.webshopwebservice.repositories.ArticleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Bootstrap implements CommandLineRunner {

    private final ArticleRepository articleRepository;

    public Bootstrap(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadArticles();
    }

    private void loadArticles() {

        Article article1 = new Article();
        article1.setId(1l);
        article1.setName("Spenat");
        article1.setDescription("Alla äter spenat");
        article1.setCompany("Lama lama");
        BigDecimal bd = new BigDecimal(22.55);
        article1.setPrice(bd);
        article1.setStock(50);

        articleRepository.save(article1);

        Article article2 = new Article();
        article2.setId(2l);
        article2.setName("Mjölk");
        article2.setDescription("Mjölk är kogöra");
        article2.setCompany("På landet");
        BigDecimal bigDecimal = new BigDecimal(67.89);
        article2.setPrice(bigDecimal);
        article2.setStock(6);

        articleRepository.save(article2);

        System.out.println("Articles loaded " + articleRepository.count());
    }
}

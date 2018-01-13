package com.patternson.webshopwebservice.bootstrap;

import com.patternson.webshopwebservice.domain.ApplicationUser;
import com.patternson.webshopwebservice.domain.Article;
import com.patternson.webshopwebservice.repositories.ArticleRepository;
import com.patternson.webshopwebservice.repositories.ApplicationUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 *
 * Created by Tobias Pettersson 20180108
 */
@Component
public class Bootstrap implements CommandLineRunner {

    private final ArticleRepository articleRepository;
    private final ApplicationUserRepository applicationUserRepository;

    public Bootstrap(ArticleRepository articleRepository, ApplicationUserRepository applicationUserRepository) {
        this.articleRepository = articleRepository;
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadArticles();
        loadUsers();
    }

    private void loadArticles() {

        Article article1 = new Article();
        article1.setId(1L);
        article1.setName("Spenat");
        article1.setDescription("Alla äter spenat");
        article1.setCompany("Lama lama");
        BigDecimal bd = new BigDecimal(22.55);
        article1.setPrice(bd);
        article1.setStock(50);

        articleRepository.save(article1);

        Article article2 = new Article();
        article2.setId(2L);
        article2.setName("Mjölk");
        article2.setDescription("Mjölk är kogöra");
        article2.setCompany("På landet");
        BigDecimal bigDecimal = new BigDecimal(67.89);
        article2.setPrice(bigDecimal);
        article2.setStock(6);

        articleRepository.save(article2);

        System.out.println("Articles loaded " + articleRepository.count());
    }

    private void loadUsers() {
        ApplicationUser applicationUser1 = new ApplicationUser();

        applicationUser1.setId(1L);
        applicationUser1.setEmail("applicationUser1@webshop.com");
        applicationUser1.setPassword("password");

        applicationUserRepository.save(applicationUser1);

        ApplicationUser applicationUser2 = new ApplicationUser();

        applicationUser2.setId(2L);
        applicationUser2.setEmail("applicationUser2@webshop.com");
        applicationUser2.setPassword("password");

        applicationUserRepository.save(applicationUser2);

        System.out.println("Users loaded " + applicationUserRepository.count());
    }
}

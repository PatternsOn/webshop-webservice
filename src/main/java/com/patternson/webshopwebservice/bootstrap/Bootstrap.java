package com.patternson.webshopwebservice.bootstrap;

import com.patternson.webshopwebservice.domain.User;
import com.patternson.webshopwebservice.domain.Article;
import com.patternson.webshopwebservice.repositories.ArticleRepository;
import com.patternson.webshopwebservice.repositories.UserRepository;
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
    private final UserRepository userRepository;

    public Bootstrap(ArticleRepository articleRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
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
        User user1 = new User();

        user1.setId(1L);
        user1.setEmail("user1@webshop.com");
        user1.setPassword("password");

        userRepository.save(user1);

        User user2 = new User();

        user2.setId(2L);
        user2.setEmail("user2@webshop.com");
        user2.setPassword("password");

        userRepository.save(user2);

        System.out.println("Users loaded " + userRepository.count());
    }
}

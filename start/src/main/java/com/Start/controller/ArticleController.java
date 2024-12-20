package com.Start.controller;

import com.Start.entity.Article;
import com.Start.entity.CustomUserDetails;
import com.Start.service.impl.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    @Autowired
    private ArticleService service;

    @GetMapping
    public List<Article> getAllArticles() {
        return service.getAllArticles();
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable Long id) {
        return service.getArticleById(id);
    }

    @GetMapping("/by-author/{username}")
    public List<Article> getArticlesByAuthor(@PathVariable String username) {
        return service.getArticlesByAuthor(username);
    }

    @PostMapping("/write")
    public Article createArticle(@RequestBody Article article) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();

            article.setAuthor(username);
        }
        return service.createArticle(article);
    }

    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable Long id, @RequestBody Article articleDetails) {
        return service.updateArticle(id, articleDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Long id) {
        service.deleteArticle(id);
    }

    // Optional: Search endpoint
    @GetMapping("/search")
    public List<Article> searchArticles(@RequestParam String query) {
        return service.searchArticles(query);
    }
}
package com.Start.service.impl;

import com.Start.entity.Article;
import com.Start.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    // Get all articles
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    // Get article by ID
    public Article getArticleById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found with id: " + id));
    }

    // Get articles by author
    public List<Article> getArticlesByAuthor(String author) {
        return articleRepository.findByAuthorOrderByCreatedAtDesc(author);
    }

    // Create a new article
    @Transactional
    public Article createArticle(Article article) {
        // Set creation timestamp
        article.setCreatedAt(LocalDateTime.now());

        // You might want to add additional validation here
        return articleRepository.save(article);
    }

    // Update an existing article
    @Transactional
    public Article updateArticle(Long id, Article articleDetails) {
        // Find the existing article
        Article existingArticle = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found with id: " + id));

        // Update fields
        existingArticle.setTitle(articleDetails.getTitle());
        existingArticle.setContent(articleDetails.getContent());
        existingArticle.setUpdatedAt(LocalDateTime.now());

        // Save and return the updated article
        return articleRepository.save(existingArticle);
    }

    // Delete an article
    @Transactional
    public void deleteArticle(Long id) {
        // Check if article exists
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found with id: " + id));

        // Delete the article
        articleRepository.delete(article);
    }

    // Optional: Search articles by title or content
    public List<Article> searchArticles(String query) {
        return articleRepository.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(query, query);
    }
}
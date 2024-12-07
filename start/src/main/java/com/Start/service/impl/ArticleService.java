package com.Start.service.impl;

import com.Start.entity.Article;
import com.Start.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository repository;

    public List<Article> getAllArticles() {
        return repository.findAll();
    }

    public Article getArticleById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Article not found"));
    }

    public Article createArticle(Article article) {
        return repository.save(article);
    }

    public Article updateArticle(Long id, Article articleDetails) {
        Article article = getArticleById(id);
        article.setTitle(articleDetails.getTitle());
        article.setContent(articleDetails.getContent());
        article.setAuthor(articleDetails.getAuthor());
        return repository.save(article);
    }

    public void deleteArticle(Long id) {
        repository.deleteById(id);
    }
}

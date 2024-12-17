package com.Start.repository;

import com.Start.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    // Custom method to find articles by author, sorted by creation date
    List<Article> findByAuthorOrderByCreatedAtDesc(String author);

    // Search method for finding articles by title or content
    List<Article> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(String title, String content);
}
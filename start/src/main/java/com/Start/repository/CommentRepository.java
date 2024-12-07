package com.Start.repository;

import com.Start.dao.Response;
import com.Start.entity.Article;
import com.Start.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Response findAllByArticle(Article article);
}

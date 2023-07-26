package com.anything.s3.domain.article.repository;

import com.anything.s3.domain.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    boolean existsByTitle (String title);
}

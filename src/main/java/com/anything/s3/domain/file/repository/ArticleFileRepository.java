package com.anything.s3.domain.file.repository;

import com.anything.s3.domain.article.entity.Article;
import com.anything.s3.domain.file.entity.ArticleFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleFileRepository extends JpaRepository<ArticleFile, Long> {

    void deleteAllByArticle(Article article);

    List<ArticleFile> getBoardFileByArticleId(Long id);

    ArticleFile getArticleFileByArticle(Article article);
}

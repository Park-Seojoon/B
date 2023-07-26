package com.anything.s3.global.util;

import com.anything.s3.domain.article.entity.Article;
import com.anything.s3.domain.article.exception.ArticleNotFoundException;
import com.anything.s3.domain.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArticleUtil {

    private final ArticleRepository articleRepository;

    public Article findArticleById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(ArticleNotFoundException::new);
    }
}

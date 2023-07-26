package com.anything.s3.domain.article.service;

import com.anything.s3.domain.article.entity.Article;
import com.anything.s3.domain.article.exception.ArticleNotFoundException;
import com.anything.s3.domain.article.presentation.response.ArticleDetailResponse;
import com.anything.s3.domain.article.repository.ArticleRepository;
import com.anything.s3.global.annotation.ReadOnlyService;
import lombok.RequiredArgsConstructor;

@ReadOnlyService
@RequiredArgsConstructor
public class ArticleDetailService {

    private final ArticleRepository articleRepository;

    public ArticleDetailResponse execute(Long id) {

        Article article = articleRepository.findById(id)
                .orElseThrow(ArticleNotFoundException::new);

        return ArticleDetailResponse.builder()
                .title(article.getTitle())
                .content(article.getContent())
                .point(article.getPoint())
                .build();
    }
}

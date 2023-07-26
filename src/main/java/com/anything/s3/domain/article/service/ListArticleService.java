package com.anything.s3.domain.article.service;

import com.anything.s3.domain.article.entity.Article;
import com.anything.s3.domain.article.presentation.response.ArticleResponse;
import com.anything.s3.domain.article.presentation.response.ListArticleResponse;
import com.anything.s3.domain.article.repository.ArticleRepository;
import com.anything.s3.global.annotation.ReadOnlyService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@ReadOnlyService
public class ListArticleService {

    private final ArticleRepository articleRepository;

    public ListArticleResponse execute() {

        List<Article> articleList = articleRepository.findAll();

        return ListArticleResponse.builder()
                .boardList(
                        articleList.stream()
                                .map(ArticleResponse::articleResponse)
                                .collect(Collectors.toList())
                )
                .build();
    }
}

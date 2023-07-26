package com.anything.s3.domain.article.service;

import com.anything.s3.domain.article.entity.Article;
import com.anything.s3.domain.article.exception.ArticleNotFoundException;
import com.anything.s3.domain.article.presentation.response.ArticleDetailResponse;
import com.anything.s3.domain.article.repository.ArticleRepository;
import com.anything.s3.domain.file.entity.ArticleFile;
import com.anything.s3.domain.file.repository.ArticleFileRepository;
import com.anything.s3.global.annotation.ReadOnlyService;
import lombok.RequiredArgsConstructor;

@ReadOnlyService
@RequiredArgsConstructor
public class ArticleDetailService {

    private final ArticleRepository articleRepository;
    private final ArticleFileRepository articleFileRepository;

    public ArticleDetailResponse execute(Long id) {

        Article article = articleRepository.findById(id)
                .orElseThrow(ArticleNotFoundException::new);

        ArticleFile articleFile = articleFileRepository.getArticleFileByArticle(article);

        return ArticleDetailResponse.builder()
                .title(article.getTitle())
                .content(article.getContent())
                .name(article.getMember().getName())
                .point(article.getPoint())
                .completed(article.getCompleted())
                .url(articleFile.getUrl())
                .build();
    }
}

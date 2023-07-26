package com.anything.s3.domain.file.service;

import com.anything.s3.domain.article.entity.Article;
import com.anything.s3.domain.article.exception.ArticleNotFoundException;
import com.anything.s3.domain.article.repository.ArticleRepository;
import com.anything.s3.domain.file.entity.ArticleFile;
import com.anything.s3.domain.file.repository.ArticleFileRepository;
import com.anything.s3.global.annotation.RollbackService;
import lombok.RequiredArgsConstructor;

@RollbackService
@RequiredArgsConstructor
public class GetImageUrlService {

    private final ArticleFileRepository articleFileRepository;
    private final ArticleRepository articleRepository;

    public String execute(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(ArticleNotFoundException::new);

        ArticleFile file = articleFileRepository.getArticleFileByArticle(article);

        return file.getUrl();
    }
}

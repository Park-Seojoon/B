package com.anything.s3.domain.article.service;

import com.anything.s3.domain.article.entity.Article;
import com.anything.s3.domain.article.exception.ExistTitleException;
import com.anything.s3.domain.article.presentation.request.EditArticleRequest;
import com.anything.s3.domain.article.repository.ArticleRepository;
import com.anything.s3.global.annotation.RollbackService;
import com.anything.s3.global.util.ArticleUtil;
import lombok.RequiredArgsConstructor;

@RollbackService
@RequiredArgsConstructor
public class EditArticleService {

    private final ArticleRepository articleRepository;

    private final ArticleUtil articleUtil;

    public void execute(Long articleId, EditArticleRequest editArticleRequest) {
        Article article = articleUtil.findArticleById(articleId);

        if (articleRepository.existsByTitle(editArticleRequest.getTitle())) {
            throw new ExistTitleException();
        }

        article.update(editArticleRequest);

        articleRepository.save(article);
    }
}

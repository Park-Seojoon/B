package com.anything.s3.domain.article.service;

import com.anything.s3.domain.article.entity.Article;
import com.anything.s3.domain.article.entity.enums.IngType;
import com.anything.s3.domain.article.exception.AlreadyDoItMemberException;
import com.anything.s3.domain.article.exception.ArticleNotFoundException;
import com.anything.s3.domain.article.exception.NoPermissionMyArticleException;
import com.anything.s3.domain.article.repository.ArticleRepository;
import com.anything.s3.domain.member.entity.Member;
import com.anything.s3.global.annotation.RollbackService;
import com.anything.s3.global.util.UserUtil;
import lombok.RequiredArgsConstructor;

@RollbackService
@RequiredArgsConstructor
public class ArticleDoItService {

    private final ArticleRepository articleRepository;
    private final UserUtil util;

    public void execute(Long id) {
        Member member = util.currentUser();

        Article article = articleRepository.findById(id)
                .orElseThrow(ArticleNotFoundException::new);

        if (member.equals(article.getMember())) {
            throw new NoPermissionMyArticleException();
        }

        if (article.getCompleted()) {
            throw new AlreadyDoItMemberException();
        }

        article.updateDoIt(member);
        article.updateCompleted(true, IngType.PROCEED);

        articleRepository.save(article);
    }
}

package com.anything.s3.domain.article.service;

import com.anything.s3.domain.article.entity.Article;
import com.anything.s3.domain.article.entity.enums.IngType;
import com.anything.s3.domain.article.exception.ArticleNotFoundException;
import com.anything.s3.domain.article.exception.ArticleOwnerMismatchException;
import com.anything.s3.domain.article.repository.ArticleRepository;
import com.anything.s3.domain.member.entity.Member;
import com.anything.s3.domain.member.repository.MemberRepository;
import com.anything.s3.global.annotation.RollbackService;
import com.anything.s3.global.util.UserUtil;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RollbackService
public class CheckOutMyArticleService {

    private final UserUtil util;
    private final ArticleRepository articleRepository;
    private final MemberRepository memberRepository;

    public void execute(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(ArticleNotFoundException::new);

        Member member = util.currentUser();

        if (!(article.getMember().equals(member))) {
            throw new ArticleOwnerMismatchException();
        }

        article.updateCompleted(true, IngType.COMPLETED);
        articleRepository.save(article);

        Member doMember = article.getDoMember();

        doMember.updatePoint(1000);
        memberRepository.save(doMember);
    }
}

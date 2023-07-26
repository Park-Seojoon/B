package com.anything.s3.domain.article.service;

import com.anything.s3.domain.article.entity.Article;
import com.anything.s3.domain.article.presentation.response.*;
import com.anything.s3.domain.article.repository.ArticleRepository;
import com.anything.s3.domain.member.entity.Member;
import com.anything.s3.global.annotation.ReadOnlyService;
import com.anything.s3.global.util.UserUtil;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@ReadOnlyService
@RequiredArgsConstructor
public class MyDoArticleListService {

    private final UserUtil util;
    private final ArticleRepository articleRepository;

    public DolistArticleResponse execute() {
        Member member = util.currentUser();

        List<Article> list = articleRepository.findByDoMember(member);

        return DolistArticleResponse.builder()
                .boardList(
                        list.stream()
                                .map(DoArticlingResponses::doArticlingResponses)
                                .collect(Collectors.toList())
                )
                .build();
    }
}

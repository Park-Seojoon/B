package com.anything.s3.domain.article.service;

import com.anything.s3.domain.article.entity.Article;
import com.anything.s3.domain.article.presentation.response.ArticlingResponse;
import com.anything.s3.domain.article.presentation.response.MyListArticleResponse;
import com.anything.s3.domain.article.repository.ArticleRepository;
import com.anything.s3.domain.file.repository.ArticleFileRepository;
import com.anything.s3.domain.member.entity.Member;
import com.anything.s3.global.annotation.ReadOnlyService;
import com.anything.s3.global.util.UserUtil;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@ReadOnlyService
@RequiredArgsConstructor
public class MyArticleListService {

    private final UserUtil util;
    private final ArticleRepository articleRepository;
    private final ArticleFileRepository articleFileRepository;

    public MyListArticleResponse execute() {
        Member member = util.currentUser();

        List<Article> list = articleRepository.findByMember(member);

        return MyListArticleResponse.builder()
                .boardList(
                        list.stream()
                                .map(ArticlingResponse::articlingResponse)
                                .collect(Collectors.toList())
                )
                .build();
    }
}

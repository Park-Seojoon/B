package com.anything.s3.domain.article.presentation.response;

import com.anything.s3.domain.article.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ArticleResponse {

    private Long id;
    private String title;
    private int point;
    private String url;

    public static ArticleResponse articleResponse(Article article) {

        return ArticleResponse.builder()
                .id(article.getId())
                .title(article.getTitle())
                .point(article.getPoint())
                .url(article.getUrl())
                .build();
    }
}

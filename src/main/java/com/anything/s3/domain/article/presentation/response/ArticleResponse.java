package com.anything.s3.domain.article.presentation.response;

import com.anything.s3.domain.article.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ArticleResponse {

    private String title;

    public static ArticleResponse articleResponse(Article article) {

        return ArticleResponse.builder()
                .title(article.getTitle())
                .build();
    }
}

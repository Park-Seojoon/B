package com.anything.s3.domain.article.presentation.response;

import com.anything.s3.domain.article.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ArticlingResponse {

    private String title;
    private int point;
    private Boolean completed;
    private String url;

    public static ArticlingResponse articlingResponse(Article article) {

        return ArticlingResponse.builder()
                .title(article.getTitle())
                .point(article.getPoint())
                .completed(article.getCompleted())
                .url(article.getUrl())
                .build();
    }
}

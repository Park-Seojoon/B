package com.anything.s3.domain.article.presentation.response;

import com.anything.s3.domain.article.entity.Article;
import com.anything.s3.domain.article.entity.enums.MyListIngType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ArticlingResponse {

    private Long id;
    private String title;
    private int point;
    private MyListIngType myListIngType;
    private String url;

    public static ArticlingResponse articlingResponse(Article article) {

        return ArticlingResponse.builder()
                .id(article.getId())
                .title(article.getTitle())
                .point(article.getPoint())
                .myListIngType(article.getMyListIngType())
                .url(article.getUrl())
                .build();
    }
}

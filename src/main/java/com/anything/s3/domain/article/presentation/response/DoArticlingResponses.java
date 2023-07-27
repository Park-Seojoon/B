package com.anything.s3.domain.article.presentation.response;

import com.anything.s3.domain.article.entity.Article;
import com.anything.s3.domain.article.entity.enums.IngType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class DoArticlingResponses {

    private Long id;
    private String title;
    private int point;
    private Boolean completed;
    private String url;
    private IngType ingType;

    public static DoArticlingResponses doArticlingResponses(Article article) {

        return DoArticlingResponses.builder()
                .id(article.getId())
                .title(article.getTitle())
                .point(article.getPoint())
                .completed(article.getCompleted())
                .url(article.getUrl())
                .ingType(article.getIngType())
                .build();
    }
}

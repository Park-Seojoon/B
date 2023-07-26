package com.anything.s3.domain.article.presentation.response;

import lombok.*;

@Getter
@AllArgsConstructor
@Builder
public class ArticleDetailResponse {

    private Long id;
    private String title;
    private String content;
    private String name;
    private int point;
    private Boolean completed;
    private String url;
}

package com.anything.s3.domain.article.presentation.response;

import lombok.*;

@Getter
@AllArgsConstructor
@Builder
public class ArticleDetailResponse {

    private String title;
    private String content;
    private int point;
    private Boolean completed;
}

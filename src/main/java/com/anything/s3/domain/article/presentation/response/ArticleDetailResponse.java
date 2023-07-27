package com.anything.s3.domain.article.presentation.response;

import com.anything.s3.domain.article.entity.enums.MyListIngType;
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
    private MyListIngType myListIngType;
    private String url;
}

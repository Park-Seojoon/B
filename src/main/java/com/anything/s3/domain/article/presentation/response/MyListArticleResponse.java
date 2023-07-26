package com.anything.s3.domain.article.presentation.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class MyListArticleResponse {

    List<ArticlingResponse> boardList;
}

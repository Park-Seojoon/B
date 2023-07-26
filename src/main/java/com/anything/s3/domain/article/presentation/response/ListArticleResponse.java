package com.anything.s3.domain.article.presentation.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ListArticleResponse {

    private List<ArticleResponse> boardList;
}

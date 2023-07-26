package com.anything.s3.domain.article.presentation.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class CreateArticleRequest {

    @NotBlank(message = "제목은 필수 요소입니다.")
    private String title;

    @NotBlank(message = "내용은 필수 요소입니다")
    private String content;
}

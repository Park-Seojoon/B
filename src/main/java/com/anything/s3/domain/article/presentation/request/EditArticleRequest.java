package com.anything.s3.domain.article.presentation.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EditArticleRequest {

    @NotBlank(message = "제목은 필수 입력값입니다")
    private String title;

    @NotBlank(message = "내용은 필수 입력값입니다")
    private String content;
}

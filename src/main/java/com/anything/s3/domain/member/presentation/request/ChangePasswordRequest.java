package com.anything.s3.domain.member.presentation.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChangePasswordRequest {

    @NotBlank(message = "현재 비밀번호는 필수 입력입니다.")
    private String currentPassword;

    @NotBlank(message = "바꿀 비밀번호는 필수 입력입니다.")
    private String wantChangePassword;

    @NotBlank(message = "바꿀 비밀번호를 필수로 입력해주십시오.")
    private String wantChangePassword2;
}

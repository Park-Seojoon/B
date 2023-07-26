package com.anything.s3.domain.auth.presentation.dto.request;

import com.anything.s3.domain.member.entity.enums.Role;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@AllArgsConstructor
@Component
@NoArgsConstructor
public class SignUpRequest {

    @Email
    @NotBlank(message = "이메일은 필수 입력값입니다")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "이름은 필수 입력값입니다")
    private String name;
    @NotBlank(message = "비밀번호는 필수 입력값입니다")
    private String password;
    private Role role;
}
package com.anything.s3.domain.member.service;

import com.anything.s3.domain.auth.exception.MisMatchPasswordException;
import com.anything.s3.domain.member.entity.Member;
import com.anything.s3.domain.member.exception.ChangePasswordMismatchException;
import com.anything.s3.domain.member.presentation.request.ChangePasswordRequest;
import com.anything.s3.global.annotation.RollbackService;
import com.anything.s3.global.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;

@RequiredArgsConstructor
@RollbackService
public class MemberPasswordChangeService {

    private final PasswordEncoder passwordEncoder;
    private final UserUtil util;

    public void execute(ChangePasswordRequest changePasswordRequest) {

        Member member = util.currentUser();

        if (!Objects.equals(changePasswordRequest.getWantChangePassword(), changePasswordRequest.getWantChangePassword2())) {
            throw new ChangePasswordMismatchException();
        }

        if (passwordIsNotMatch(changePasswordRequest, member))
            throw new MisMatchPasswordException();

        member.updatePassword(passwordEncoder.encode(changePasswordRequest.getWantChangePassword()));
    }

    private boolean passwordIsNotMatch(ChangePasswordRequest changePasswordRequest, Member member) {
        return !passwordEncoder.matches(changePasswordRequest.getCurrentPassword(), member.getPassword());
    }
}

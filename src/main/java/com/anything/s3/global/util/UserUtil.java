package com.anything.s3.global.util;

import com.anything.s3.domain.member.entity.Member;
import com.anything.s3.domain.member.repository.MemberRepository;
import com.anything.s3.global.exception.TokenNotValidException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserUtil {

    private final MemberRepository memberRepository;

    public Member currentUser() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return memberRepository.findByName(name)
                .orElseThrow(TokenNotValidException::new);
    }
}
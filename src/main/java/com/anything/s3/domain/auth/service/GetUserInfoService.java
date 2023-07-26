package com.anything.s3.domain.auth.service;

import com.anything.s3.domain.auth.presentation.dto.response.UserInfoResponse;
import com.anything.s3.domain.member.entity.Member;
import com.anything.s3.domain.member.repository.MemberRepository;
import com.anything.s3.global.annotation.ReadOnlyService;
import com.anything.s3.global.util.UserUtil;
import lombok.RequiredArgsConstructor;

@ReadOnlyService
@RequiredArgsConstructor
public class GetUserInfoService {

    private final MemberRepository memberRepository;
    private final UserUtil util;

    public UserInfoResponse execute() {
        Member member = util.currentUser();

        return UserInfoResponse.builder()
                .name(member.getName())
                .point(member.getPoint())
                .build();
    }
}

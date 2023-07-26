package com.anything.s3.domain.auth.service;

import com.anything.s3.domain.auth.entity.BlackList;
import com.anything.s3.domain.auth.entity.RefreshToken;
import com.anything.s3.domain.auth.exception.BlackListAlreadyExistException;
import com.anything.s3.domain.auth.exception.RefreshTokenNotFoundException;
import com.anything.s3.domain.auth.repository.BlackListRepository;
import com.anything.s3.domain.auth.repository.RefreshTokenRepository;
import com.anything.s3.domain.member.entity.Member;
import com.anything.s3.global.security.jwt.TokenProvider;
import com.anything.s3.global.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberLogoutService {

    private final BlackListRepository blackListRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final TokenProvider tokenProvider;
    private final UserUtil util;

    public void execute(String accessToken) {
        Member member = util.currentUser();
        String email = member.getEmail();

        RefreshToken refreshToken = refreshTokenRepository.findById(email)
                .orElseThrow(RefreshTokenNotFoundException::new);
        refreshTokenRepository.delete(refreshToken);
        saveBlackList(member.getEmail(), accessToken);
    }

    private void saveBlackList(String email, String accessToken) {
        if (blackListRepository.existsById(accessToken)) {
            throw new BlackListAlreadyExistException();
        }

        long expiredTime = tokenProvider.getACCESS_TOKEN_EXPIRE_TIME();

        BlackList blackList = BlackList.builder()
                .email(email)
                .accessToken(accessToken)
                .timeToLive(expiredTime)
                .build();

        blackListRepository.save(blackList);
    }
}

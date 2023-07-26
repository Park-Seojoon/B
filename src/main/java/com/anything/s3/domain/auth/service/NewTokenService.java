package com.anything.s3.domain.auth.service;

import com.anything.s3.domain.auth.entity.RefreshToken;
import com.anything.s3.domain.auth.exception.RefreshTokenNotFoundException;
import com.anything.s3.domain.auth.presentation.dto.response.NewTokenResponse;
import com.anything.s3.domain.auth.repository.RefreshTokenRepository;
import com.anything.s3.global.exception.TokenNotValidException;
import com.anything.s3.global.security.jwt.TokenProvider;
import com.anything.s3.global.security.jwt.properties.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class NewTokenService {

    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtProperties jwtProperties;

    public NewTokenResponse execute(String requestToken) {
        String email = tokenProvider.getUserEmail(requestToken, jwtProperties.getRefreshSecret());
        RefreshToken token = refreshTokenRepository.findById(email)
                .orElseThrow(RefreshTokenNotFoundException::new);

        if (!token.getRefreshToken().equals(requestToken)) {
            throw new TokenNotValidException();
        }

        String accessToken = tokenProvider.generatedAccessToken(email);
        String refreshToken = tokenProvider.generatedRefreshToken(email);
        ZonedDateTime accessExpiredTime = tokenProvider.getExpiredAtToken(accessToken, jwtProperties.getAccessSecret());
        ZonedDateTime refreshExpiredTime = tokenProvider.getRefreshExpiredAtToken(refreshToken, jwtProperties.getRefreshSecret());

        token.exchangeRefreshToken(refreshToken);
        refreshTokenRepository.save(token);

        return NewTokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .accessExpiredAt(accessExpiredTime)
                .refreshExpiredAt(refreshExpiredTime)
                .build();
    }
}

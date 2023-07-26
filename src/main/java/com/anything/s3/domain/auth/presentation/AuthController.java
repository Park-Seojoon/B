package com.anything.s3.domain.auth.presentation;

import com.anything.s3.domain.auth.presentation.dto.request.SignInRequest;
import com.anything.s3.domain.auth.presentation.dto.request.SignUpRequest;
import com.anything.s3.domain.auth.presentation.dto.response.NewTokenResponse;
import com.anything.s3.domain.auth.presentation.dto.response.SignInResponse;
import com.anything.s3.domain.auth.service.MemberLoginService;
import com.anything.s3.domain.auth.service.MemberLogoutService;
import com.anything.s3.domain.auth.service.MemberSignUpService;
import com.anything.s3.domain.auth.service.NewTokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

        private final MemberSignUpService signUpService;
        private final MemberLoginService loginService;
        private final MemberLogoutService logoutService;
        private final NewTokenService newTokenService;

        @GetMapping("/signup")
        public ResponseEntity<?> signUp(@Valid @RequestBody SignUpRequest request) {
            signUpService.execute(request);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        @PostMapping("/login")
        public ResponseEntity<SignInResponse> login(@Valid @RequestBody SignInRequest request) {
            SignInResponse response = loginService.execute(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        @DeleteMapping
        public ResponseEntity<?> logout(@RequestHeader("Authorization")String accessToken) {
            logoutService.execute(accessToken);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @PatchMapping
        public ResponseEntity<NewTokenResponse> reIssueToken(@RequestHeader("RefreshToken") String token) {
            NewTokenResponse newTokenResponse = newTokenService.execute(token);
            return new ResponseEntity<>(newTokenResponse, HttpStatus.OK);
        }
}

package com.anything.s3.domain.member.presentation;

import com.anything.s3.domain.auth.presentation.dto.response.UserInfoResponse;
import com.anything.s3.domain.auth.service.GetUserInfoService;
import com.anything.s3.domain.member.presentation.request.ChangePasswordRequest;
import com.anything.s3.domain.member.service.MemberPasswordChangeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class MemberController {

    private final MemberPasswordChangeService passwordChangeService;
    private final GetUserInfoService getUserInfoService;

    @PatchMapping("/password")
    public ResponseEntity<Void> changePassword(@RequestBody @Valid ChangePasswordRequest changePasswordRequest) {
        passwordChangeService.execute(changePasswordRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/info")
    public ResponseEntity<UserInfoResponse> getInfo() {
        UserInfoResponse response = getUserInfoService.execute();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

package com.anything.s3.domain.member.presentation;

import com.anything.s3.domain.member.presentation.request.ChangePasswordRequest;
import com.anything.s3.domain.member.service.MemberPasswordChangeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class MemberController {

    private final MemberPasswordChangeService passwordChangeService;

    @PatchMapping("/password")
    public ResponseEntity<Void> changePassword(@RequestBody @Valid ChangePasswordRequest changePasswordRequest) {
        passwordChangeService.execute(changePasswordRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

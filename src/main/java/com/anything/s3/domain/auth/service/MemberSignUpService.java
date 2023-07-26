package com.anything.s3.domain.auth.service;

import com.anything.s3.domain.auth.exception.DuplicatedEmailException;
import com.anything.s3.domain.auth.presentation.dto.request.SignUpRequest;
import com.anything.s3.domain.member.entity.Member;
import com.anything.s3.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberSignUpService {

     private final MemberRepository memberRepository;
     private final PasswordEncoder passwordEncoder;

     public void execute(SignUpRequest request) {
         if (memberRepository.existsByEmail(request.getEmail())) {
             throw new DuplicatedEmailException();
         }


         Member member = Member.builder()
                 .email(request.getEmail())
                 .name(request.getName())
                 .password(passwordEncoder.encode(request.getPassword()))
                 .build();

         memberRepository.save(member);
     }
}

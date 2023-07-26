package com.anything.s3.domain.auth.service;

import com.anything.s3.domain.auth.exception.DuplicatedEmailException;
import com.anything.s3.domain.auth.exception.DuplicatedNameException;
import com.anything.s3.domain.auth.exception.MisMatchPasswordException;
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

         if (memberRepository.existsByName(request.getName())) {
             throw new DuplicatedNameException();
         }

         if(!(request.getPassword().equals(request.getRePassword()))) {
             throw new MisMatchPasswordException();
         }


         Member member = Member.builder()
                 .name(request.getName())
                 .email(request.getEmail())
                 .password(passwordEncoder.encode(request.getPassword()))
                 .point(0)
                 .build();

         memberRepository.save(member);
     }
}

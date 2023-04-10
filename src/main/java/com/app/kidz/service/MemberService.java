package com.app.kidz.service;

import com.app.kidz.domain.member.Member;
import com.app.kidz.domain.member.User;
import com.app.kidz.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long registerUser(User user) {


        return memberRepository.saveUser(user);
    }

    private void memberDuplicateValidation(Member member) {

    }
}

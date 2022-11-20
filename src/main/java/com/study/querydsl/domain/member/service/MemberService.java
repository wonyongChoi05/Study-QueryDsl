package com.study.querydsl.domain.member.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.querydsl.domain.member.domain.Member;
import com.study.querydsl.domain.member.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public void search() {
        List<Member> member = memberRepository.searchMember("member", 10);
        member.forEach(m -> {
            System.out.println("member.getId() = " + m.getId());
            System.out.println("member.getUsername() = " + m.getUsername());
            System.out.println("member.getAge() = " + m.getAge());
            System.out.println("<================================>");
        });
    }
}

package com.study.querydsl.domain.member.service;

import com.study.querydsl.domain.member.domain.Member;
import com.study.querydsl.domain.member.domain.repository.MemberRepository;
import com.study.querydsl.domain.member.presentation.dto.res.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public void search() {
        List<Member> members = memberRepository.searchMember("member", 10);
        members.forEach(m -> {
            System.out.println("member.getId() = " + m.getId());
            System.out.println("member.getUsername() = " + m.getUsername());
            System.out.println("member.getAge() = " + m.getAge());
            System.out.println("<================================>");
        });
    }

    public void searchUserAndTeam() {
        List<Member> members = memberRepository.searchMemberAndTeamName();
        System.out.println("members = " + members);
        members.forEach(member -> {
            System.out.println("member.getId = " + member.getId());
            System.out.println("member.getUsername() = " + member.getUsername());
            System.out.println("member.getAge() = " + member.getAge());
            System.out.println("member.getTeam().getName() = " + member.getTeam().getName());
            System.out.println("<================================>");
        });
    }

    public void searchUserByTeamName() {
        List<Member> members = memberRepository.searchMemberByTeamName();
        System.out.println(members);
        members.forEach(member -> {
            System.out.println("member.getUsername() = " + member.getUsername());
        });
    }

    public void searchOlderMember() {
        Member member = memberRepository.searchMemberByOrderByAgeFirstOne();
        System.out.println("member.getAge() = " + member.getAge());
        System.out.println("member.getTeam().getName() = " + member.getTeam().getName());
    }


    public void searchMemberResponseDto() {
        MemberResponseDto memberResponseDto = memberRepository.searchMemberResponseDto();
        System.out.println("username = " + memberResponseDto.getUsername());
        System.out.println("age = " + memberResponseDto.getAge());
    }
}

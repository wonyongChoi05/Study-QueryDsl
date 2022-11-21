package com.study.querydsl.domain.member.domain.repository;

import com.study.querydsl.domain.member.domain.Member;

import java.util.List;

public interface MemberCustomRepository {

    List<Member> searchMember(String username, int age);

    List<Member> searchMemberAndTeamName();

    List<Member> searchMemberByTeamName();
}

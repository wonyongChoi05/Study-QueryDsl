package com.study.querydsl.domain.member.domain.repository;

import com.study.querydsl.domain.member.domain.Member;
import com.study.querydsl.domain.member.presentation.dto.res.MemberResponseDto;

import java.util.List;

public interface MemberCustomRepository {

    List<Member> searchMember(String username, int age);

    List<Member> searchMemberAndTeamName();

    List<Member> searchMemberByTeamName();

    Member searchMemberByOrderByAgeFirstOne();

    MemberResponseDto searchMemberResponseDto();

}

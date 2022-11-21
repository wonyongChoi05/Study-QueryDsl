package com.study.querydsl.domain.member.presentation.dto.res;

import com.study.querydsl.domain.member.domain.Member;
import lombok.Getter;

@Getter
public class MemberResponseDto {

    private final String username;
    private final Integer age;

    public MemberResponseDto(Member member) {
        this.username = member.getUsername();
        this.age = member.getAge();
    }
}

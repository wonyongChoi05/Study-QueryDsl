package com.study.querydsl.domain.member.domain.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.querydsl.domain.member.domain.Member;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.study.querydsl.domain.member.domain.QMember.member;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Member> searchMember(String username, int age) {
        return jpaQueryFactory.selectFrom(member)
                .where(member.username.eq("member")
                        .and(member.age.eq(10)))
                .fetch();
    }
}

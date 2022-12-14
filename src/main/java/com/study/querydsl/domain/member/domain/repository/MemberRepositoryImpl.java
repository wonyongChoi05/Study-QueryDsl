package com.study.querydsl.domain.member.domain.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.querydsl.domain.member.domain.Member;
import com.study.querydsl.domain.member.presentation.dto.res.MemberResponseDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.study.querydsl.domain.member.domain.QMember.member;
import static com.study.querydsl.domain.team.domain.QTeam.team;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Member> searchMember(String username, int age) {
        return jpaQueryFactory.selectFrom(member)
                .where(member.username.eq("member1")
                        .and(member.age.eq(10)))
                .fetch();
    }

    @Override
    public List<Member> searchMemberAndTeamName() {
        return jpaQueryFactory.selectFrom(member)
                // 연관관계가 맺어져 있는 상태여서 굳이 join 쿼리를 작성하지 않아도 됨
                .leftJoin(member.team, team)
                .where(team.name.eq("team1"))
                .fetch();
    }

    @Override
    public List<Member> searchMemberByTeamName() {
        return jpaQueryFactory.select(member)
                .from(member)
                .leftJoin(member.team, team)
                .fetchJoin()
                .where(member.username.eq("member3"))
                .fetch();
    }

    @Override // 서브쿼리 사용시 한방쿼리로 성능 최적화 불가능
    public Member searchMemberByOrderByAgeFirstOne() {
        return jpaQueryFactory.select(member)
                .from(member)
                .where(member.age.eq(
                        JPAExpressions
                                .select(member.age.max())
                                .from(member)
                ))
                .leftJoin(member.team, team)
                .fetchJoin()
                .fetchFirst();
    }

    @Override
    public MemberResponseDto searchMemberResponseDto() {
        return jpaQueryFactory.select(Projections.constructor(MemberResponseDto.class, member))
                .from(member)
                .where(member.username.eq("member1"))
                .fetchOne();
    }
}
package com.study.querydsl.domain.member.domain.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.querydsl.domain.member.domain.Member;
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


}

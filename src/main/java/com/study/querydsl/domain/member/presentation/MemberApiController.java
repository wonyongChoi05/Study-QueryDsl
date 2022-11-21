package com.study.querydsl.domain.member.presentation;

import com.study.querydsl.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/member")
@RestController
public class MemberApiController {

    private final MemberService memberService;

    @GetMapping
    public void printMember() {
        memberService.search();
    }

    @GetMapping("/join")
    public void printMemberAndTeam() {
        memberService.searchUserAndTeam();
    }

    @GetMapping("/fetch")
    public void printMemberByTeamName() {
        memberService.searchUserByTeamName();
    }

    @GetMapping("/sub")
    public void printMemberByAgeOrderByAgeDescByFirstOne() {
        memberService.searchOlderMember();
    }

    @GetMapping("/dto")
    public void printResponseDto() {
        memberService.searchMemberResponseDto();
    }
}

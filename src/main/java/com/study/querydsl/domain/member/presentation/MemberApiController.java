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

}

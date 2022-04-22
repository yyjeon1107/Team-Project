package team.project.WhatToEatToday.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import team.project.WhatToEatToday.Service.MemberService;
import team.project.WhatToEatToday.domain.member.Member;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    public final MemberService memberService;

    @GetMapping("/members")
    public String getMembers(Model model) {
        List<Member> members = memberService.findAll();
        model.addAttribute("page", "members");
        model.addAttribute("members", members);
        System.out.println("---haaaaa----" + members.get(5).getAddress());
        return "layout";
    }
}

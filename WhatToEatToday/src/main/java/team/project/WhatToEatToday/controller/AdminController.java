package team.project.WhatToEatToday.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import team.project.WhatToEatToday.Service.AdminService;
import team.project.WhatToEatToday.Service.CustomerService;
import team.project.WhatToEatToday.Service.ManagerService;
import team.project.WhatToEatToday.Service.MemberService;
import team.project.WhatToEatToday.domain.member.Admin;
import team.project.WhatToEatToday.domain.member.Customer;
import team.project.WhatToEatToday.domain.member.Manager;
import team.project.WhatToEatToday.domain.member.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    public final MemberService memberService;
    public final AdminService adminService;
    public final ManagerService managerService;
    public final CustomerService customerService;

    @GetMapping("/members")
    public String getMembers(Model model) {
        List<Member> members = memberService.findAll();
        List<Member> sortedMembers = new ArrayList<>();
        for(Member member : members){
            if(member.getClass().getSimpleName().equals("Admin")){
                sortedMembers.add(member);
            }
        }
        for(Member member : members){
            if(member.getClass().getSimpleName().equals("Manager")){
                sortedMembers.add(member);
            }
        }
        for(Member member : members){
            if(member.getClass().getSimpleName().equals("Customer")){
                sortedMembers.add(member);
            }
        }
        model.addAttribute("page", "members");
        model.addAttribute("members", sortedMembers);
        return "layout";
    }

    @GetMapping("/members/delete/{memberId}")
    public String deleteMembers(HttpServletRequest request, @PathVariable String memberId) {
        HttpSession session = request.getSession();
        RestTemplate restTemplate = new RestTemplate();
        Member member = memberService.findOne(memberId);
        String memberClassName = member.getClass().getSimpleName();
        switch (memberClassName){
            case "Admin":
                Admin admin = adminService.findOne(memberId);
                adminService.delete(admin);
                return "redirect:/logout";
            case "Manager":
                Manager manager = managerService.findOne(memberId);
                managerService.delete(manager);
                break;
            case "Customer":
                Customer customer = customerService.findOne(memberId);
                customerService.delete(customer);
                break;
            default:
                session.setAttribute("message", "오류");
                return "redirect:/";
        }
        return "redirect:/admin/members";
    }
}

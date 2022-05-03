package team.project.WhatToEatToday.domain.controller;

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
import java.util.*;

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
        ArrayList<String> memberKindList = new ArrayList<>(Arrays.asList("Admin", "Manager", "Customer"));
        members.sort(Comparator.comparingInt(a -> memberKindList.indexOf(a.getClass().getSimpleName())));

        HashMap<String, Object> jsMembers = new HashMap<>();
        List<String> membersId = new ArrayList<>();
        List<String> membersPassword = new ArrayList<>();
        List<String> membersName = new ArrayList<>();
        List<String> membersEmail = new ArrayList<>();
        List<String> membersTel = new ArrayList<>();
        List<String> membersAddress = new ArrayList<>();
        List<String> membersAddressDetail = new ArrayList<>();
        for (Member member : members){
            membersId.add(member.getId());
            membersPassword.add(member.getPassword());
            membersName.add(member.getName());
            membersEmail.add(member.getEmail());
            membersTel.add(member.getTel());
            membersAddress.add(member.getAddress());
            membersAddressDetail.add(member.getAddressDetail());
        }
        jsMembers.put("id", membersId);
        jsMembers.put("password", membersPassword);
        jsMembers.put("name", membersName);
        jsMembers.put("email", membersEmail);
        jsMembers.put("tel", membersTel);
        jsMembers.put("address", membersAddress);
        jsMembers.put("addressDetail", membersAddressDetail);

        model.addAttribute("page", "members");
        model.addAttribute("members", members);
        model.addAttribute("jsMembers", jsMembers);

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

package team.project.WhatToEatToday.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import team.project.WhatToEatToday.Service.CustomerService;
import team.project.WhatToEatToday.Service.EatingHouseService;
import team.project.WhatToEatToday.Service.MemberService;
import team.project.WhatToEatToday.domain.EatingHouse;
import team.project.WhatToEatToday.domain.member.Manager;
import team.project.WhatToEatToday.dto.EatingHouseForm;
import team.project.WhatToEatToday.dto.JoinForm;

@Controller
@RequestMapping("/eatinghouse")
@RequiredArgsConstructor
public class EatingHouseController {
	
	private final EatingHouseService eatingHouseService;
	
    @GetMapping("/store")
    public String joinStore(Model model) {
        model.addAttribute("page", "joinEatingHouse");
        model.addAttribute("joinStore", new EatingHouseForm());
        return "layout";        
    }
    
    @PostMapping("/store")
    public String postJoinManager(HttpServletRequest request, @Valid EatingHouseForm eatingHouseForm) {
        HttpSession session = request.getSession();
        try {
            EatingHouse eatinghouse = new EatingHouse();
            //eatinghouse.setManager(session.);
            eatinghouse.setName(eatingHouseForm.getName());
            eatinghouse.setTel(eatingHouseForm.getTel());
            eatinghouse.setAddress(eatingHouseForm.getAddress());
            eatinghouse.setAddressDetail(eatingHouseForm.getAddressDetail());
            eatingHouseService.join(eatinghouse);
            session.setAttribute("message", "매장이 등록되었습니다.");
            return "redirect:/";
        } catch (IllegalStateException e) {
            session.setAttribute("message", "이미 존재하는 가게입니다.");
            return "redirect:/join/manager";
        }
    }
    
}

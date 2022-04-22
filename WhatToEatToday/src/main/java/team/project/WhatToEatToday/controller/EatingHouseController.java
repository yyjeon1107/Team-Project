package team.project.WhatToEatToday.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import team.project.WhatToEatToday.Service.EatingHouseService;
import team.project.WhatToEatToday.Service.ManagerService;
import team.project.WhatToEatToday.domain.EatingHouse;
import team.project.WhatToEatToday.domain.member.Manager;
import team.project.WhatToEatToday.domain.member.Member;
import team.project.WhatToEatToday.dto.EatingHouseForm;

@Controller
@RequestMapping("/eatinghouse")
@RequiredArgsConstructor
public class EatingHouseController {
	
	private final EatingHouseService eatingHouseService;
	private final ManagerService managerService;
	
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
            Member member = (Member)session.getAttribute("member");
            Manager manager = managerService.findOne(member.getId());
            eatinghouse.setManager(manager);
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

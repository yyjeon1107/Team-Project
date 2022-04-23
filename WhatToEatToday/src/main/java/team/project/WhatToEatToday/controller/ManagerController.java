package team.project.WhatToEatToday.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import team.project.WhatToEatToday.Service.AdminService;
import team.project.WhatToEatToday.Service.CustomerService;
import team.project.WhatToEatToday.Service.ManagerService;
import team.project.WhatToEatToday.Service.MemberService;
import team.project.WhatToEatToday.domain.member.Admin;
import team.project.WhatToEatToday.domain.member.Customer;
import team.project.WhatToEatToday.domain.member.Manager;
import team.project.WhatToEatToday.domain.member.Member;
import team.project.WhatToEatToday.dto.JoinForm;

<<<<<<< Updated upstream
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
=======
import lombok.RequiredArgsConstructor;
import team.project.WhatToEatToday.Service.EatingHouseItemService;
import team.project.WhatToEatToday.Service.EatingHouseService;
import team.project.WhatToEatToday.domain.EatingHouse;
import team.project.WhatToEatToday.domain.Item;
>>>>>>> Stashed changes

@Controller
@RequestMapping("/manager")
@RequiredArgsConstructor
public class ManagerController {
	
	private final MemberService memberService;
    private final CustomerService customerService;

<<<<<<< Updated upstream

    @GetMapping("/store")
    public String all(Model model) {
    	List<Member> members = memberService.findAll();
        model.addAttribute("page", "members");
        model.addAttribute("members", members);
=======
	private final EatingHouseService eatingHouseService;
	private final EatingHouseItemService eatingHouseItemService;


    @GetMapping("/store")
    public String all(Model model) {
    	List<EatingHouse> eatingHouses = eatingHouseService.findAll();
    	List<Item> eatingHousesItem = eatingHouseItemService.findAll();
        model.addAttribute("page", "eatinghouses");
        model.addAttribute("eatinghouses", eatingHouses);
        model.addAttribute("eatinghousesitem", eatingHousesItem);
>>>>>>> Stashed changes
        return "layout";
        
    }
}

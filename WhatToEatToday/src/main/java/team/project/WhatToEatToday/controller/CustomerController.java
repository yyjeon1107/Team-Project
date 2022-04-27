package team.project.WhatToEatToday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import team.project.WhatToEatToday.Service.CustomerService;
import team.project.WhatToEatToday.Service.EatingHouseService;
import team.project.WhatToEatToday.domain.member.Customer;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
	CustomerService customerService;

	@GetMapping("/mypage/{customerId}")
    public String getMypage(@PathVariable String customerId, Model model) {
        Customer customer = customerService.findOne(customerId);
        model.addAttribute("customer", customer);
        model.addAttribute("page", "myPage");
        return "layout";
        
    }
	

	@GetMapping("/recommend")
    public String recommendMenu(Model model) {
    	model.addAttribute("page", "menuRecommend");
        return "layout";
        
    }

	@GetMapping("/recommendResult")
    public String recommendMenuResult(Model model) {
    	model.addAttribute("page", "menuRecommendResult");
        return "layout";

    }
	
	
	@GetMapping("/menuAll")
    public String viewMenuAll(Model model) {
    	model.addAttribute("page", "viewMenuAll");
        return "layout";
        
    }
	

	
}

package team.project.WhatToEatToday.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import team.project.WhatToEatToday.Service.EatingHouseService;
import team.project.WhatToEatToday.domain.EatingHouse;
import team.project.WhatToEatToday.domain.Item;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

	private final EatingHouseService eatingHouseService;

	
	@GetMapping("/mypage")
    public String all(Model model) {
    	List<EatingHouse> eatingHouses = eatingHouseService.findAll();
        model.addAttribute("page", "eatinghouses");
        model.addAttribute("eatinghouses", eatingHouses);
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

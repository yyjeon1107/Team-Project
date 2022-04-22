package team.project.WhatToEatToday.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import team.project.WhatToEatToday.Service.EatingHouseService;
import team.project.WhatToEatToday.domain.EatingHouse;

@Controller
@RequestMapping("/manager")
@RequiredArgsConstructor
public class ManagerController {
	
	private final EatingHouseService eatingHouseService;


    @GetMapping("/store")
    public String all(Model model) {
    	List<EatingHouse> eatingHouses = eatingHouseService.findAll();
        model.addAttribute("page", "eatinghouses");
        model.addAttribute("eatinghouses", eatingHouses);
        System.out.println("---------HEEEEEE--------- " + eatingHouses.get(1).getId());
        return "layout";
        
    }
}

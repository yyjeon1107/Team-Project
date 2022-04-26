package team.project.WhatToEatToday.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.boot.Banner.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import team.project.WhatToEatToday.Service.EatingHouseItemService;
import team.project.WhatToEatToday.Service.EatingHouseService;
import team.project.WhatToEatToday.Service.ManagerService;
import team.project.WhatToEatToday.domain.EatingHouse;
import team.project.WhatToEatToday.domain.Item;
import team.project.WhatToEatToday.domain.member.Manager;
import team.project.WhatToEatToday.domain.member.Member;
import team.project.WhatToEatToday.dto.EatingHouseForm;
import team.project.WhatToEatToday.dto.EatingHouseItemForm;

@Controller
@RequestMapping("/eatinghouse")
@RequiredArgsConstructor
public class EatingHouseController {
	
	private final EatingHouseItemService eatingHouseItemService;
	private final EatingHouseService eatingHouseService;
	private final ManagerService managerService;
	
    @GetMapping("/store")
    public String joinStore(Model model) {
        model.addAttribute("page", "joinEatingHouse");
        model.addAttribute("joinStore", new EatingHouseForm());
        return "layout";        
    }
    
    @PostMapping("/store")
    public String postJoinStore(HttpServletRequest request, @Valid EatingHouseForm eatingHouseForm) {
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
            return "redirect:/eatinghouse/store";
        }
    }
    
    @GetMapping("/item")
    public String joinItem(Model model) {
        model.addAttribute("page", "joinEatingHouseItem");
        model.addAttribute("joinStoreItem", new EatingHouseItemForm());
        return "layout";        
    }
    
    @PostMapping("/item")
    public String postJoinManager(HttpServletRequest request, @Valid EatingHouseItemForm eatingHouseItemForm) {
        HttpSession session = request.getSession();
        try {
            Item item = new Item();
            Member member = (Member)session.getAttribute("member");
            Manager manager = managerService.findOne(member.getId());
            EatingHouse eatinghouse = eatingHouseService.findId(manager);
            System.out.println("*************************************");
            System.out.println(eatinghouse);
            System.out.println("*************************************");
            item.setEatingHouse(eatinghouse);
            item.setName(eatingHouseItemForm.getName());
            item.setPrice(eatingHouseItemForm.getPrice());
            item.setCategories(eatingHouseItemForm.getCategories());
            eatingHouseItemService.join(item);
            session.setAttribute("message", "음식이 등록되었습니다.");
            return "redirect:/";
        } catch (IllegalStateException e) {
            session.setAttribute("message", "이미 존재하는 메뉴입니다.");
            return "redirect:/eatinghouse/item";
        }
    }
    
    @GetMapping("item/{itemId}/edit")
    public String updateItem(@PathVariable("itemId") Long itemId, Model model) {
    	
    	Item item = eatingHouseItemService.findOne(itemId);
    	
    	EatingHouseItemForm updateEatingHouseForm = new EatingHouseItemForm();
    	updateEatingHouseForm.setId(item.getId());
    	updateEatingHouseForm.setName(item.getName());
    	updateEatingHouseForm.setPrice(item.getPrice());
    	model.addAttribute("page", "updateEatingHouseItem");
    	model.addAttribute("form", updateEatingHouseForm);
    	
    	return "layout";
    }
    
    
    @PostMapping("item/{itemId}/edit")
    public String updateItem(@ModelAttribute("form") EatingHouseItemForm form) {
    	
    	Item item = new Item();
    	
    	item.setId(form.getId());
    	item.setName(form.getName());
    	item.setPrice(form.getPrice());
    	
    	eatingHouseItemService.join(item);
    	return "redirect:/manager/store";
    }
    
    
    
    
}

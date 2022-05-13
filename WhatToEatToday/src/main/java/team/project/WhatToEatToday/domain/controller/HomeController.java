package team.project.WhatToEatToday.domain.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.project.WhatToEatToday.Service.MenuService;
import team.project.WhatToEatToday.domain.Menu;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {


    private final MenuService menuService;


    @GetMapping
    public String home(Model model) {
        log.info("home controller");
        model.addAttribute("page", "home");
        return "layout";
    }


    @GetMapping("/search")
    public String SearchMenu(Model model){

        model.addAttribute("page", "home");
        return "layout";
    }


    @GetMapping("/search/result")
    public String SearchResult(@RequestParam(required = false, value = "name") String text, Model model){

        List<Menu> menuList = menuService.findByName(text);
        System.out.println(menuList);



        model.addAttribute("page", "researchMenuList");
        model.addAttribute("menu",menuList);
        return "layout";
    }


}

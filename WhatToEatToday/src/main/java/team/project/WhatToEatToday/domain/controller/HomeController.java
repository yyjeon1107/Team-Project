package team.project.WhatToEatToday.domain.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/")
public class HomeController {


    @GetMapping
    public String home(Model model) {
        log.info("home controller");
        model.addAttribute("page", "home");
        return "layout";
    }

}

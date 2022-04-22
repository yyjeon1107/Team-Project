package team.project.WhatToEatToday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import team.project.WhatToEatToday.domain.EatingHouse;
import team.project.WhatToEatToday.repository.EatingHouseRepository;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired // 연관성 주입
	EatingHouseRepository eatingHouseRepository;

    @RequestMapping("/message_reset")
    public void messageReset(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("message", null);
    }

	
//	@ResponseBody
//    @GetMapping("/item")
//    public List<EatingHouse> joinStore() {
//        return eatingHouseRepository.findAll();        
//    }
}

package team.project.WhatToEatToday.controller;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import team.project.WhatToEatToday.domain.EatingHouse;
import team.project.WhatToEatToday.repository.EatingHouseRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
public class RestController {

	private final EatingHouseRepository eatingHouseRepository;
	
    @RequestMapping("/message_reset")
    public void messageReset(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("message", null);
    }
    
    @ResponseBody
    @RequestMapping("/data")
    public Admin a() {
    	
    	return eatingHouseRepository.findId("admin");
    }
}

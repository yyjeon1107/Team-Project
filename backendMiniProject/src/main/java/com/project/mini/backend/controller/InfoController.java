package com.project.mini.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.mini.backend.dao.UserMapper;
import com.project.mini.backend.dto.User;

@Controller
@RequestMapping("/info")
public class InfoController {
	
	@Autowired
	UserMapper userMapper;
	
    @GetMapping("/{id}")
	public String infoGet(@PathVariable("id") String id, Model model) {
    	User user = userMapper.getById(id);
		model.addAttribute("user", user);
		model.addAttribute("products", user.getProductList());
		return "info";
	}
}

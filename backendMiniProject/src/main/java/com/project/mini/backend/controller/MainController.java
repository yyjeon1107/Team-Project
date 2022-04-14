package com.project.mini.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.mini.backend.dao.ProductMapper;

@Controller
public class MainController {

	@Autowired
	ProductMapper productMapper;
	
    @RequestMapping(value="/")
	public String main(Model model) {
    	model.addAttribute("products", productMapper.getAll());
		return "index";
	}
}

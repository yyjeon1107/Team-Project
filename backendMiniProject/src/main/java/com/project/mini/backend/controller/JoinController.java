package com.project.mini.backend.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.mini.backend.dao.UserMapper;
import com.project.mini.backend.dto.User;

@Controller
@RequestMapping("/join")
public class JoinController {

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public String joinGet() {
		return "join";
	}
	
	@PostMapping("")
	public String loginPost(HttpServletRequest request, Model model) {
		String id = request.getParameter("id"); 
		String password = request.getParameter("password"); 
		String name = request.getParameter("name"); 
		String email = request.getParameter("email"); 
		String address = request.getParameter("address"); 
		try {
			User user = new User();
			user.setId(id);
			user.setPassword(password);
			user.setName(name);
			user.setEmail(email);
			user.setAddress(address);
			userService.add(user);
			return "redirect:";
		}catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("fail", "가입에 실패했습니다.");
			return "join";
		}
	}
}

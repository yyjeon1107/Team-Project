package com.project.mini.backend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.mini.backend.dao.UserMapper;
import com.project.mini.backend.dto.User;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("")
	public String loginGet() {
		return "login";
	}
	
	@PostMapping("")
	public String loginPost(HttpServletRequest request, Model model) {
		String id = request.getParameter("id"); 
		try {
			User user = userMapper.getById(id);
			String password = request.getParameter("password");
			if(user.getPassword().equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				return "redirect:";
			} else {
				model.addAttribute("fail", "비밀번호가 다릅니다.");
				return "login";
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("fail", "아이디가 존재하지 않습니다.");
			return "login";
		}
	}
}

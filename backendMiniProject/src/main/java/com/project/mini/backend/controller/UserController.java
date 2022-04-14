package com.project.mini.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.mini.backend.dao.UserMapper;
import com.project.mini.backend.dto.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("")
	public User post(@RequestBody User user) throws Exception{
//		userMapper.insert(user);
		userService.add(user);
		return user;
	}
	
	@GetMapping("")
	public List<User> getAll() {
		return userMapper.getAll();
	}
	
	@GetMapping("/{id}")
	public User getById(@PathVariable("id") String id) {
		return userMapper.getById(id);
	}
}

package com.project.mini.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.mini.backend.dao.ProductMapper;
import com.project.mini.backend.dao.UserMapper;
import com.project.mini.backend.dto.User;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private ProductMapper productMapper;
	
	public List<User> getAll(){
		List<User> userList = userMapper.getAll();
		if(userList != null && userList.size() > 0) {
			for (User user : userList) {
				user.setProductList(productMapper.getByProductUserId(user.getId()));
			}
		}
		return userList;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public User add(User user) throws Exception {
		userMapper.insert(user);
		//add company into legacy system
		return user;
	}
}

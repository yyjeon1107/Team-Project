package com.project.mini.backend.dto;

import lombok.Data;


public class Product {
	private int id;
	private String userId;
	private String name;
	private String info;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", userId=" + userId + ", name=" + name + ", info=" + info + "]";
	}
	
}

package com.project.mini.backend.dto;

import java.util.List;

import lombok.Data;


public class User {
	private String id;
	private String password;
	private String name;
	private String email;
	private String address;
	private List<Product> productList;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	@Override
	public String toString() {
		return "id=" + id + "<br> password=" + password + "<br> name=" + name + "<br> email=" + email + "<br> address="
				+ address;
	}

	public String pringProductList() {
		String print = "";
		for(Product product: productList) {
			print += product.toString() + "<br>";
		}
		return print;
	}
	
	
	
}

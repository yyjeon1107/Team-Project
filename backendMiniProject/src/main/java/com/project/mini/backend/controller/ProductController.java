package com.project.mini.backend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.mini.backend.dao.ProductMapper;
import com.project.mini.backend.dto.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductMapper productMapper;
	
	@PostMapping("")
	public Product post(@RequestBody Product product) {
		productMapper.insert(product);
		return product;
	}
	
	@GetMapping("")
	public List<Product> getAll() {
		return productMapper.getAll();
	}

	
	@GetMapping("/{id}/add")
	public String ProductAddGet(@PathVariable("id") String id) {
		return "add";
	}
	
	@PostMapping("/{id}/add")
	public String ProductAddPost(@PathVariable("id") String id, HttpServletRequest request, Model model) {
		Product product = new Product();
		product.setUserId(id);
		product.setName(request.getParameter("name"));
		product.setInfo(request.getParameter("info"));
		try {
			productMapper.insert(product);
			model.addAttribute("alert", "성공 :" + product);
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("alert", "실패");
		}
		return "add";
	}
	
	@GetMapping("/{id}")
	public String getById(@PathVariable("id") int id, Model model) {
		model.addAttribute("product", productMapper.getById(id));
		return "productDetail";
	}
}

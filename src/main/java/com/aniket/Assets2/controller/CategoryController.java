package com.aniket.Assets2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aniket.Assets2.entity.Category;
import com.aniket.Assets2.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService service;

	@PostMapping
	public Category addCat(@RequestBody Category cat) {
		return service.save(cat);
	}

	@PostMapping("update/{id}")
	public Category updateCat(Long id, @RequestBody Category cat) {
		return service.update(id, cat);
	}

	@GetMapping
	public List<Category> listAllCat() {
		return service.listAll();
	}
}

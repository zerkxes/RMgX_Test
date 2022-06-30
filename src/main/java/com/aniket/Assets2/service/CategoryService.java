package com.aniket.Assets2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aniket.Assets2.Repository.CategoryRepository;
import com.aniket.Assets2.entity.Category;

@Service
@Transactional
public class CategoryService {

	@Autowired
	CategoryRepository catRepo;

	public Category update(Long id, Category cat) {
		Optional<Category> cate = catRepo.findById(id);
		if (cate.isPresent()) {
			cate.get().setDescription(cat.getDescription());
			cate.get().setName(cat.getName());
			return cate.get();
		} else
			return null;
	}

	public List<Category> listAll() {
		List<Category> list = new ArrayList<>();
		for (Category cat : catRepo.findAll()) {
			list.add(cat);
		}
		return list;
	}

	public Category save(Category cat) {
		return catRepo.save(cat);
	}
}

package com.example.demo.services;

import com.example.demo.models.Category;
import com.example.demo.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

	private final CategoryRepository categoryRepository;

	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	public Optional<Category> getById(Integer id) {
		return categoryRepository.findById(id);
	}

	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	public void deleteById(Integer id) {
		categoryRepository.deleteById(id);
	}
}

package com.example.demo.controllers.admin;

import com.example.demo.exceptions.CategoryNotFoundException;
import com.example.demo.models.Category;
import com.example.demo.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryRestController {

	private final CategoryService categoryService;

	@GetMapping
	public List<Category> getAll() {

		return categoryService.getAll();
	}

	@GetMapping("/{id}")
	public Category getOne(@PathVariable Integer id) {

		return categoryService.getById(id)
				.orElseThrow(() -> new CategoryNotFoundException(id));
	}

	@PostMapping
	public Category newCategory(@RequestBody Category category) {

		return categoryService.save(category);
	}

	@PutMapping("/{id}")
	public Category updateCategory(@PathVariable Integer id, @RequestBody Category category) {

		category.setId(id);
		return categoryService.save(category);
	}

	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Integer id) {

		categoryService.deleteById(id);
	}
}

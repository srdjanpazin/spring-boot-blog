package com.example.demo.controllers.admin;

import com.example.demo.models.Category;
import com.example.demo.models.Post;
import com.example.demo.models.Tag;
import com.example.demo.services.CategoryService;
import com.example.demo.services.PostService;
import com.example.demo.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminDashboardController {

	private final PostService postService;
	private final CategoryService categoryService;
	private final TagService tagService;

	@GetMapping
	public String home() {
		return "admin/home";
	}

	@GetMapping("/posts")
	public String postsPage(Model model) {

		List<Post> allPosts = postService.getAll();
		model.addAttribute("posts", allPosts);

		return "admin/posts_list";
	}

	@GetMapping("/posts/create")
	public String getCreatePostPage(Model model) {

		model.addAttribute("categories", categoryService.getAll());
		model.addAttribute("tags", tagService.getAll());
		return "admin/edit_post";
	}

	@GetMapping("/posts/{id}/edit")
	public String getEditPostPage(@PathVariable Integer id, Model model) {

		Optional<Post> postOptional = postService.getById(id);

		if (postOptional.isEmpty())
			return "404";

		model.addAttribute("post", postOptional.get());
		model.addAttribute("categories", categoryService.getAll());
		model.addAttribute("tags", tagService.getAll());

		return "admin/edit_post";
	}

	@GetMapping("/categories")
	public String categoriesPage(Model model) {

		List<Category> allCategories = categoryService.getAll();
		model.addAttribute("categories", allCategories);

		return "admin/categories_list";
	}

	@GetMapping("/tags")
	public String tagsPage(Model model) {

		List<Tag> allTags = tagService.getAll();
		model.addAttribute("tags", allTags);

		return "admin/tags_list";
	}
}

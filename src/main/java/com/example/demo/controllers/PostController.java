package com.example.demo.controllers;

import com.example.demo.models.Post;
import com.example.demo.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;

	@GetMapping("/{id}")
	public String singlePageView(@PathVariable Integer id, Model model) {

		Optional<Post> postOptional = postService.getById(id);

		if (postOptional.isEmpty())
			return "404";

		model.addAttribute("post", postOptional.get());
		return "single_post";
	}
}

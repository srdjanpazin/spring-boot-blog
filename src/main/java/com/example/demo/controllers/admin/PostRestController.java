package com.example.demo.controllers.admin;

import com.example.demo.exceptions.PostNotFoundException;
import com.example.demo.models.Post;
import com.example.demo.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostRestController {

	private final PostService postService;

	@GetMapping
	public List<Post> getAll() {

		return postService.getAll();
	}

	@GetMapping("/{id}")
	public Post getOne(@PathVariable Integer id) {

		return postService.getById(id)
				.orElseThrow(() -> new PostNotFoundException(id));
	}

	@PostMapping("/create")
	public Post newPost(@RequestBody Post post) {

		return postService.save(post);
	}

	@PutMapping("/{id}")
	public Post updatePost(@PathVariable Integer id, @RequestBody Post post) {

		post.setId(id);
		return postService.save(post);
	}

	@DeleteMapping("/{id}")
	public void deletePost(@PathVariable Integer id) {

		postService.deleteById(id);
	}
}

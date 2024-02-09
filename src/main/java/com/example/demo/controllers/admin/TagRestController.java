package com.example.demo.controllers.admin;

import com.example.demo.exceptions.TagNotFoundException;
import com.example.demo.models.Tag;
import com.example.demo.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
@RequiredArgsConstructor
public class TagRestController {

	private final TagService tagService;

	@GetMapping
	public List<Tag> getAll() {

		return tagService.getAll();
	}

	@GetMapping("/{id}")
	public Tag getOne(@PathVariable Integer id) {

		return tagService.getById(id)
				.orElseThrow(() -> new TagNotFoundException(id));
	}

	@PostMapping
	public Tag newTag(@RequestBody Tag tag) {

		return tagService.save(tag);
	}

	@PutMapping("/{id}")
	public Tag updateTag(@PathVariable Integer id, @RequestBody Tag tag) {

		tag.setId(id);
		return tagService.save(tag);
	}

	@DeleteMapping("/{id}")
	public void deleteTag(@PathVariable Integer id) {

		tagService.deleteById(id);
	}
}

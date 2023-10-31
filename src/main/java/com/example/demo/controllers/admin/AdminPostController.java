package com.example.demo.controllers.admin;

import com.example.demo.models.Post;
import com.example.demo.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/admin/posts")
@RequiredArgsConstructor
public class AdminPostController {

    private final PostService postService;

    @GetMapping("/")
    public String home() {
        return "admin/posts-list";
    }

    @GetMapping("/create")
    public String getCreatePostPage() {
        return "admin/create-post";
    }

    @GetMapping("/{id}/edit")
    public String getEditPostPage(@PathVariable Long id, Model model) {

        Optional<Post> postOptional = postService.getById(id);

        if (postOptional.isEmpty())
            return "404";

        model.addAttribute("post", postOptional.get());
        return "admin/edit-post";
    }

    @PostMapping("/create")
    public String createPost(@RequestBody Post post) {

        postService.save(post);
        return "redirect:/admin/posts";
    }

    @PutMapping("/{id}")
    public String updatePost(@PathVariable Long id, @RequestBody Post post) {

        post.setId(id);
        postService.save(post);
        return "redirect:/admin/posts";
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id) {

        postService.deleteById(id);
        return "redirect:/admin/posts";
    }
}

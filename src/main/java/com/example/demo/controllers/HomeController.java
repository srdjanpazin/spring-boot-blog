package com.example.demo.controllers;

import com.example.demo.models.Post;
import com.example.demo.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final PostService postService;

    @GetMapping
    public String home(Model model) {

        List<Post> latestPosts = postService.getLatest();

        model.addAttribute("latestPosts", latestPosts);

        return "home";
    }
}
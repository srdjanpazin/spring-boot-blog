package com.example.demo.services;

import com.example.demo.models.Post;
import com.example.demo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public List<Post> getLatest() {
        List<Post> latestPosts = postRepository.findTop20ByOrderByCreatedAtDesc();

        latestPosts.forEach(post -> {
            post.setShortContent(truncateContent(post.getContent()));
        });

        return latestPosts;
    }

    public Optional<Post> getById(Long id) {
        return postRepository.findById(id);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    public String truncateContent(String fullContent) {
        return fullContent.substring(0, 400) + "...";
    }
}

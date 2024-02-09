package com.example.demo.services;

import com.example.demo.models.Post;
import com.example.demo.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

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

    public Optional<Post> getById(Integer id) {
        return postRepository.findById(id);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public void deleteById(Integer id) {
        postRepository.deleteById(id);
    }

    public String truncateContent(String fullContent) {

        int previewTextLimit = 400;

        if (fullContent.length() <= previewTextLimit)
            return fullContent;
        else
            return fullContent.substring(0, previewTextLimit) + "...";
    }
}

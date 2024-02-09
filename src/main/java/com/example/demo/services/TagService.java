package com.example.demo.services;

import com.example.demo.models.Tag;
import com.example.demo.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public List<Tag> getAll() {
        return tagRepository.findAll();
    }

    public Optional<Tag> getById(Integer id) {
        return tagRepository.findById(id);
    }

    public Tag save(Tag category) {
        return tagRepository.save(category);
    }

    public void deleteById(Integer id) {
        tagRepository.deleteById(id);
    }
}

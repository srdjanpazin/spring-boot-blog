package com.example.demo.exceptions;

public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(Integer id) {
        super("Could not find post with id " + id);
    }
}

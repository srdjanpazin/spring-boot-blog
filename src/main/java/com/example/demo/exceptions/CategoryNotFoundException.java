package com.example.demo.exceptions;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(Integer id) {
        super("Could not find category with id " + id);
    }
}

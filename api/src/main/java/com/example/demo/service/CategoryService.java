package com.example.demo.service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.entities.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category save(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());

        return repository.save(category);
    }

    public Category findById(Long id) {
        Optional<Category> category = repository.findById(id);
        return category.orElse(null);
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public void update(Long id, CategoryDto categoryDto) {
        Category category = this.findById(id);

        if (category != null) {
            category.setName(categoryDto.getName());
            repository.save(category);
        }
    }

    public void delete(Long id) {
        Category category = this.findById(id);

        if (category != null) {
            repository.delete(category);
        }
    }
}
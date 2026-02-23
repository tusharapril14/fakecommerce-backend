package com.example.fakecommerce.controllers;

import com.example.fakecommerce.dtos.CreateCategoryDTO;
import com.example.fakecommerce.schema.Category;
import com.example.fakecommerce.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping()
    public List<Category> findAllCategories() {
        return this.categoryService.getAllCategories();
    }

    @PostMapping()
    public Category createCategory(@RequestBody CreateCategoryDTO category) {
        return this.categoryService.createCategory(category);
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
        return this.categoryService.deleteCategory(id);
    }
}
package com.example.fakecommerce.services;

import com.example.fakecommerce.dtos.CreateCategoryDTO;
import com.example.fakecommerce.repositories.CategoryRepository;
import com.example.fakecommerce.schema.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return this.categoryRepository.findAll();
    }


    public Category createCategory(CreateCategoryDTO reqDto){
        Category newCategory = Category.builder()
                .name(reqDto.getName()).build();
        return this.categoryRepository.save(newCategory);
    }

    public String deleteCategory(Long id){
        Category category = this.categoryRepository.findById(id).orElseThrow();
        this.categoryRepository.delete(category);
        return "Category deleted successfully";
    }

}

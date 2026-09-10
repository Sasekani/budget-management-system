package com.sasekani.budget_management_system.service;

import com.sasekani.budget_management_system.entity.Category;
import com.sasekani.budget_management_system.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllcategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public Category updateCategory(Long id, Category updatedCategory){

        Category existingCategory = getCategoryById(id);

        existingCategory.setName(updatedCategory.getName());
        existingCategory.setType(updatedCategory.getType());

        return categoryRepository.save(existingCategory);
    }

    public void deleteCategory(Long id){

        Category existingCategory = getCategoryById(id);
        categoryRepository.delete(existingCategory);
    }
}

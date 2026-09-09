package com.sasekani.budget_management_system.repository;

import com.sasekani.budget_management_system.entity.Category;
import com.sasekani.budget_management_system.entity.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByType(CategoryType type);
}

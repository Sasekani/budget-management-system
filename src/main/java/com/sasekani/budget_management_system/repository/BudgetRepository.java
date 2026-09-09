package com.sasekani.budget_management_system.repository;

import com.sasekani.budget_management_system.entity.Budget;
import com.sasekani.budget_management_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BudgetRepository extends JpaRepository<Budget, Long> {

    List<Budget> findByUser(User user);
    Optional<Budget> findByUserAndCategoryIdAndMonthAndYear(User user, Long categoryId, Integer month, Integer year);
}

package com.sasekani.budget_management_system.repository;

import com.sasekani.budget_management_system.entity.Expense;
import com.sasekani.budget_management_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByUser(User user);
}

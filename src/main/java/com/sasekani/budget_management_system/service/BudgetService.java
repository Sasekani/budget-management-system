package com.sasekani.budget_management_system.service;

import com.sasekani.budget_management_system.entity.Budget;
import com.sasekani.budget_management_system.entity.User;
import com.sasekani.budget_management_system.repository.BudgetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;

    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public Budget createBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public List<Budget> getAllBudgets() {
        return budgetRepository.findAll();
    }

    public List<Budget> getBudgetsByUser(User user) {
        return budgetRepository.findByUser(user);
    }

    public Budget getBudgetById(Long id) {
        return budgetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Budget not found"));
    }

    public Budget updateBudget(Long id, Budget updatedBudget) {

        Budget existingBudget = getBudgetById(id);

        existingBudget.setAmount(updatedBudget.getAmount());
        existingBudget.setMonth(updatedBudget.getMonth());
        existingBudget.setYear(updatedBudget.getYear());
        existingBudget.setCategory(updatedBudget.getCategory());

        return budgetRepository.save(existingBudget);
    }

    public void deleteBudget(Long id) {

        Budget existingBudget = getBudgetById(id);

        budgetRepository.delete(existingBudget);
    }
}

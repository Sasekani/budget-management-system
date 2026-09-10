package com.sasekani.budget_management_system.service;

import com.sasekani.budget_management_system.entity.Expense;
import com.sasekani.budget_management_system.entity.User;
import com.sasekani.budget_management_system.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public List<Expense> getExpensesByUser(User user) {
        return expenseRepository.findByUser(user);
    }

    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
    }

    public Expense updateExpense(Long id, Expense updatedExpense) {

        Expense existingExpense = getExpenseById(id);

        existingExpense.setAmount(updatedExpense.getAmount());
        existingExpense.setDescription(updatedExpense.getDescription());
        existingExpense.setExpenseDate(updatedExpense.getExpenseDate());
        existingExpense.setCategory(updatedExpense.getCategory());

        return expenseRepository.save(existingExpense);
    }

    public void deleteExpense(Long id) {

        Expense existingExpense = getExpenseById(id);

        expenseRepository.delete(existingExpense);
    }
}

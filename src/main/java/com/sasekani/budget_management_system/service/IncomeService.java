package com.sasekani.budget_management_system.service;

import com.sasekani.budget_management_system.entity.Income;
import com.sasekani.budget_management_system.entity.User;
import com.sasekani.budget_management_system.repository.IncomeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public Income createIncome(Income income){
        return incomeRepository.save(income);
    }

    public List<Income> getAllIncome(){
        return incomeRepository.findAll();
    }

    public List<Income> getIncomeByUser(User user) {
        return incomeRepository.findByUser(user);
    }

    public Income getIncomeById(Long id){
        return incomeRepository.findById(id).orElseThrow(() -> new RuntimeException("Income record not found"));
    }

    public Income updateIncome(Long id, Income updatedIncome){

        Income existingIncome = getIncomeById(id);

        existingIncome.setAmount(updatedIncome.getAmount());
        existingIncome.setDescription(updatedIncome.getDescription());
        existingIncome.setIncomeDate(updatedIncome.getIncomeDate());
        existingIncome.setCategory(updatedIncome.getCategory());

        return incomeRepository.save(existingIncome);

    }

    public void deleteIncome(Long id) {

        Income existingIncome = getIncomeById(id);

        incomeRepository.delete(existingIncome);
    }
}

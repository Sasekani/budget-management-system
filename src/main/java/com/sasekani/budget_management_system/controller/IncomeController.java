package com.sasekani.budget_management_system.controller;

import com.sasekani.budget_management_system.entity.Income;
import com.sasekani.budget_management_system.entity.User;
import com.sasekani.budget_management_system.service.IncomeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/income")
public class IncomeController {

    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @PostMapping
    public Income createService(@RequestBody Income income){
        return incomeService.createIncome(income);
    }

    @GetMapping
    public List<Income> getAllIncome(){
        return incomeService.getAllIncome();
    }

    @GetMapping("/{id}")
    public Income getIncomeById(@PathVariable Long id){
        return incomeService.getIncomeById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Income> getIncomeByUser(@PathVariable Long userId){
        User user = new User();
        user.setId(userId);

        return  incomeService.getIncomeByUser(user);
    }

    @PutMapping("/{id}")
    public Income updateIncome(@PathVariable Long id, @RequestBody Income income){
        return incomeService.updateIncome(id, income);
    }

    @DeleteMapping("/{id}")
    public void deleteIncome(@PathVariable Long id){
        incomeService.deleteIncome(id);
    }
}

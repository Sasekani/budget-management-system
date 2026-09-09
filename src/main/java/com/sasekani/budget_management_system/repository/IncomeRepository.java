package com.sasekani.budget_management_system.repository;

import com.sasekani.budget_management_system.entity.Income;
import com.sasekani.budget_management_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncomeRepository extends JpaRepository<Income, Long> {

    List<Income> findByUser(User user);
}

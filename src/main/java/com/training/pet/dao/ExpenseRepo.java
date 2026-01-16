package com.training.pet.dao;

import com.training.pet.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepo extends JpaRepository<Expense, Integer> {
}

package com.training.pet.service;

import com.training.pet.entity.Expense;
import com.training.pet.models.AddExpense;
import org.springframework.stereotype.Component;

@Component
public interface ExpenseService {

    public Expense addExpense(AddExpense expense);
    public Expense updateExpense(int id, AddExpense expense);
}

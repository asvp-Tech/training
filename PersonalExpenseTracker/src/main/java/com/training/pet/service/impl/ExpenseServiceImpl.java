package com.training.pet.service.impl;

import com.training.pet.dao.ExpenseDao;
import com.training.pet.entity.Expense;
import com.training.pet.models.AddExpense;
import com.training.pet.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    ExpenseDao expenseDao;

    @Override
    public Expense addExpense(AddExpense expense) {
        Expense expenseEntity = new Expense(expense.getAmount(),expense.getCategory(),
                expense.getDescription(),expense.getPaymentType(),expense.getDate());
        Expense addExpense = expenseDao.addExpense(expenseEntity);
        return addExpense;
    }

    @Override
    public Expense updateExpense(int id, AddExpense expense) {
        Expense update = expenseDao.updateExpense(id,expense);
        return update;
    }
}

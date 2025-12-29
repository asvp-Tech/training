package com.training.pet.dao.impl;

import com.training.pet.dao.ExpenseDao;
import com.training.pet.dao.ExpenseRepo;
import com.training.pet.entity.Expense;
import com.training.pet.models.AddExpense;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ExpenseDaoImpl implements ExpenseDao {

    @Autowired
    ExpenseRepo expenseRepo;

    @Override
    @Transactional
    public Expense addExpense(Expense expense) {
        Expense addExpense = expenseRepo.save(expense);
        return addExpense == null ? null : addExpense;
    }

    @Override
    @Transactional
    public Expense updateExpense(int id, AddExpense expense) {
        Optional<Expense> obj = expenseRepo.findById(id);
        if(obj.isPresent()){
            Expense existingExpense = obj.get();
            existingExpense.setAmount(expense.getAmount());
            existingExpense.setDate(expense.getDate());
            existingExpense.setCategory(expense.getCategory());
            existingExpense.setDescription(expense.getDescription());
            Expense success = expenseRepo.save(existingExpense);
            return success;
        }
        return null;
    }
}

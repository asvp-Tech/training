package com.training.pet.dao;

import com.training.pet.entity.Expense;
import com.training.pet.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExpenseRepo extends JpaRepository<Expense, Long> {

    Page<Expense> findAllByUser(User user, Pageable pageable);

    Optional<Expense> findByIdAndUser(Long id, User user);
}

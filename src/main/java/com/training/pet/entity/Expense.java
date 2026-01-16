package com.training.pet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private double amount;
    @Column
    private String category;
    @Column
    private String description;
    @Column
    private Date date;

    public Expense(double amount, String category, String description, Date date) {
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
    }
}

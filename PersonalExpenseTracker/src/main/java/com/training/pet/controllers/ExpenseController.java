package com.training.pet.controllers;

import com.training.pet.Response.ApiResponse;
import com.training.pet.entity.Expense;
import com.training.pet.models.AddExpense;
import com.training.pet.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/pet/api/v1")
public class ExpenseController {

    @Autowired
    ExpenseService service;

    @PostMapping("/expense/add")
    public ApiResponse addExpense(@RequestBody @Valid AddExpense expense){
        ApiResponse response = new ApiResponse();
        try{
            Expense addExpense = service.addExpense(expense);
            if(addExpense!=null){
                response.setMessage("Expense Saved Successfully");
                response.setCode("200");
            }
            return response;
        }
        catch (Exception e){
            e.printStackTrace();
            response.setCode("ErrorCode100");
            response.setError("Something is wrong!!");
            return response;
        }
    }

    @PutMapping("/expense/update/{id}")
    public ApiResponse updateExpense(@PathVariable("id") int id, @RequestBody AddExpense expense){
        ApiResponse response = new ApiResponse();
        try{
            Expense update = service.updateExpense(id,expense);
            if(update!=null){
                response.setMessage("Expense Update Successfully with this id = "+id);
                response.setCode("200");
                return response;
            }else{
                response.setCode("ErrorUpdateCode100");
                response.setError("Something is wrong!!");
                return response;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            response.setCode("ErrorUpdateCode101");
            response.setError("Something is wrong!!");
            return response;
        }
    }
}

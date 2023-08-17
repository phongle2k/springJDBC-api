package com.sakila_ex5_1.sakila_ex5_1.controller;

import com.sakila_ex5_1.sakila_ex5_1.dto.CustomerDTO;
import com.sakila_ex5_1.sakila_ex5_1.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/films")
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    @GetMapping("/findAll")
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }
}

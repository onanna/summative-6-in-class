package com.example.U1M6Summative.controller;

import com.example.U1M6Summative.dto.Customer;
import com.example.U1M6Summative.viewmodel.CustomerViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.PipedOutputStream;

@RestController

@RequestMapping("/customer")
public class CustomerController {

    @PostMapping
    public CustomerViewModel addCustomer(@RequestBody CustomerViewModel customer){

        return customer;
    }

    @GetMapping("/{id}")
    public CustomerViewModel getCustomer(@PathVariable(name = "id") int id) {
        CustomerViewModel customer = new CustomerViewModel();
        return customer;
    }

    @PutMapping("/{id}")
    public CustomerViewModel updateCustomer(@PathVariable(name = "id") int id, @RequestBody CustomerViewModel customer){

        return customer;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable(name = "id") int id){
        //no code here, will delete
    }
}

package com.example.U1M6Summative.controller;

import com.example.U1M6Summative.dto.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.PipedOutputStream;

@RestController

@RequestMapping("/customer")
public class CustomerController {

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){

        return customer;
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable(name = "id") int id) {
        Customer customer = new Customer();
        return customer;
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable(name = "id") @RequestBody Customer customer){

        return customer;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable(name = "id") int id){
        //no code here, will delete
    }
}

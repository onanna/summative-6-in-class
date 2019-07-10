package com.example.U1M6Summative.controller;

import com.example.U1M6Summative.dto.Customer;
import com.example.U1M6Summative.service.ServiceLayer;
import com.example.U1M6Summative.viewmodel.CustomerViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.PipedOutputStream;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ServiceLayer serviceLayer;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){

        return serviceLayer.saveCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return serviceLayer.findAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable(name = "id") int id) {
        return serviceLayer.findCustomer(id);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable(name = "id") int id, @RequestBody Customer customer){

        serviceLayer.updateCustomer(customer);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable(name = "id") int id){
        serviceLayer.removeCustomer(id);
    }
}

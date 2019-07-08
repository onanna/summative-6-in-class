package com.example.U1M6Summative.controller;

import com.example.U1M6Summative.dto.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.PipedOutputStream;

@RestController
public class CustomerController {
    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Customer addCustomer(@RequestBody Customer customer){

    }

    @RequestMapping(value = "/customer{id}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable(name = "id") int id) {

    }

    @RequestMapping(value = "/customer{id}", method = RequestMethod.PUT)
    public Customer updateCustomer(@PathVariable(name = "id") @RequestBody Customer customer){

    }

    @RequestMapping(value = "/customer{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable(name = "id") int id){
        //no code here, will delete

    }

}

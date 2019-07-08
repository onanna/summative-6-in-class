package com.example.U1M6Summative.controller;

import com.example.U1M6Summative.dto.Invoice;
import org.springframework.web.bind.annotation.*;

@RestController
public class InvoiceController {
    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Invoice addCustomer(@RequestBody Invoice invoice){

    }

    @RequestMapping(value ="/invoice{id}", method = RequestMethod.GET)
    public Invoice getCustomer(@PathVariable(name = "id") int id) {

    }

    @RequestMapping(value = "/invoice{id}", method = RequestMethod.DELETE)
    public void deleteInvoice(@PathVariable(name = "id") int id){

    }

    @RequestMapping(value = "/invoice/customer/{customerId}", method = RequestMethod.GET)
    public Invoice getInvoiceByCustomerId(@PathVariable(name = "customerId"), int customerId){

    }
}

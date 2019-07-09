package com.example.U1M6Summative.controller;

import com.example.U1M6Summative.dto.Invoice;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @PostMapping
    public Invoice addInvoice(@RequestBody Invoice invoice){

        return invoice;
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public Invoice getInvoice(@PathVariable(name = "id") int id) {
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteInvoice(@PathVariable(name = "id") int id){

    }

    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
    public Invoice getInvoiceByCustomerId(@PathVariable int customerId){
        return null;
    }
}

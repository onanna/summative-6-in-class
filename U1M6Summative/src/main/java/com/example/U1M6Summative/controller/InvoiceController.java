package com.example.U1M6Summative.controller;

import com.example.U1M6Summative.dto.Invoice;
import com.example.U1M6Summative.viewmodel.InvoiceViewModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @PostMapping
    public InvoiceViewModel addInvoice(@RequestBody InvoiceViewModel invoice){

        return invoice;
    }

    @GetMapping("/{id}")
    public InvoiceViewModel getInvoice(@PathVariable(name = "id") int id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteInvoice(@PathVariable(name = "id") int id){

    }

    @GetMapping("/customer/{customerId}")
    public InvoiceViewModel getInvoiceByCustomerId(@PathVariable int customerId){
        return null;
    }
}

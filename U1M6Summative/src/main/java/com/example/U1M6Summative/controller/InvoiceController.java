package com.example.U1M6Summative.controller;

import com.example.U1M6Summative.dto.Invoice;
import com.example.U1M6Summative.service.ServiceLayer;
import com.example.U1M6Summative.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    ServiceLayer serviceLayer;

    @PostMapping
    public InvoiceViewModel addInvoice(@RequestBody InvoiceViewModel invoice){

        return serviceLayer.saveInvoice(invoice);
    }

    @GetMapping
    public List<InvoiceViewModel> getAllInvoices() {
        return serviceLayer.findAllInvoices();
    }

    @GetMapping("/{id}")
    public InvoiceViewModel getInvoice(@PathVariable(name = "id") int id) {
        return serviceLayer.findInvoice(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<InvoiceViewModel> getInvoiceByCustomerId(@PathVariable int customerId){
        return serviceLayer.findAllInvoicesByCustomer(customerId);
    }

    @DeleteMapping("/{id}")
    public void deleteInvoice(@PathVariable(name = "id") int id){
        serviceLayer.deleteInvoice(id);

    }

}

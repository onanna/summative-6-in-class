package com.example.U1M6Summative.dao;

import com.example.U1M6Summative.dto.Invoice;

import java.util.List;

public interface InvoiceDao {
    Invoice addInvoice(Invoice invoice);

    void deleteInvoice(int id);

    List<Invoice> getInvoiceByCustomer(Integer customerId);

    List<Invoice> getAllInvoices();

    Invoice getInvoiceById( int id);

}

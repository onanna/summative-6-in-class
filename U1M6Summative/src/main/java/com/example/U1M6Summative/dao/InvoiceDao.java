package com.example.U1M6Summative.dao;

import com.example.U1M6Summative.dto.Invoice;

import java.util.List;

public interface InvoiceDao {

    Invoice addInvoice(Invoice invoice);

    void updateInvoice(Invoice invoice);

    Invoice getInvoiceById(int id);

    List<Invoice> getAllInvoices();

    void deleteInvoice(int id);

    List<Invoice> getInvoiceByCustomer(Integer customerId);
}

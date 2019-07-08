package com.example.U1M6Summative.dao;

public interface InvoiceDao {

    Invoice getInvoiceById(int id);
    void deleteInvoice(int id);
    void deleteInvoiceItems(int id);
}

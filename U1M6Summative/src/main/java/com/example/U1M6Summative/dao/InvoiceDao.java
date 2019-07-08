package com.example.U1M6Summative.dao;

import com.example.U1M6Summative.dto.Invoice;

public interface InvoiceDao {

    Invoice getInvoiceById(int id);
    void deleteInvoice(int id);
    void deleteInvoiceItems(int id);
}

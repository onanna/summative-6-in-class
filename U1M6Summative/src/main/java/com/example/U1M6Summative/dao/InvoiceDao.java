package com.example.U1M6Summative.dao;

import com.example.U1M6Summative.dto.Invoice;

public interface InvoiceDao {
    Invoice addInvoice(Invoice invoice);

    void deleteInvoice(int id);

}

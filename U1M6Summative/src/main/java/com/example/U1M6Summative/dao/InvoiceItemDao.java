package com.example.U1M6Summative.dao;

import com.example.U1M6Summative.dto.InvoiceItem;

import java.util.List;

public interface InvoiceItemDao {

    InvoiceItem getInvoiceItem(Integer id);

    List<InvoiceItem> getAllInvoiceItems();

    InvoiceItem addInvoiceItem(InvoiceItem invoiceItem);

    List<InvoiceItem> getInvoiceItemByInvoice(int invoiceId);

    void updateInvoiceItem(InvoiceItem invoiceItem);

    void deleteInvoiceItem(Integer id);

}

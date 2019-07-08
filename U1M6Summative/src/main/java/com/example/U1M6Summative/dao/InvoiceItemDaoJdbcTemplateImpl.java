package com.example.U1M6Summative.dao;

import com.example.U1M6Summative.dto.InvoiceItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InvoiceItemDaoJdbcTemplateImpl implements InvoiceItemDao {

    @Override
    public InvoiceItem getInvoiceItem(Integer id) {
        return null;
    }

    @Override
    public List<InvoiceItem> getAllInvoiceItems() {
        return null;
    }

    @Override
    public InvoiceItem addInvoiceItem(InvoiceItem invoiceItem) {
        return null;
    }

    @Override
    public void updateInvoiceItem(InvoiceItem invoiceItem) {

    }

    @Override
    public void deleteInvoiceItem(Integer id) {

    }

}

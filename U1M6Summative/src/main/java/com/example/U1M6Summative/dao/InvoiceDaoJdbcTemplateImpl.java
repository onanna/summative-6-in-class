package com.example.U1M6Summative.dao;

import com.example.U1M6Summative.dto.Invoice;
import org.springframework.stereotype.Repository;

@Repository
public class InvoiceDaoJdbcTemplateImpl implements InvoiceDao {

    @Override
    public Invoice getInvoiceById(int id) {
        return null;
    }

    @Override
    public void deleteInvoice(int id) {

    }

    @Override
    public void deleteInvoiceItems(int id) {

    }
}

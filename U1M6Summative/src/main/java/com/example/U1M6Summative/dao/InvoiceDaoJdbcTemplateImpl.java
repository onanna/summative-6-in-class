package com.example.U1M6Summative.dao;

import com.example.U1M6Summative.dto.Invoice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InvoiceDaoJdbcTemplateImpl implements InvoiceDao {
//for actual inplementation we are only implementing the 3 methods which are required
    @Override
    public Invoice getInvoiceById(int id) {
        return null;
    }

    //implementing this one below
    @Override
    public Invoice addInvoice(Invoice invoice) {
        return null;
    }

    //implementing this one below
    @Override
    public void deleteInvoice(int id) {

    }


    //implementing this one below
    @Override
    public List<Invoice> getInvoiceByCustomer(Integer customerId) {
        return null;
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return null;
    }


}

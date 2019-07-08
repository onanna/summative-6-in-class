package com.example.U1M6Summative.dao;

public interface CustomerDao {

    Customer getInvoiceById(int id);
    void deleteCustomer(int id);
    void deleteCustomerItems(int id);
}

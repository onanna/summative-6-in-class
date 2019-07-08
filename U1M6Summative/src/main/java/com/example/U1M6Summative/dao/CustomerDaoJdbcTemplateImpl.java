package com.example.U1M6Summative.dao;

import com.example.U1M6Summative.dto.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustomerDaoJdbcTemplateImpl implements CustomerDao{
    @Override
    public Customer addCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer getCustomer(int id) {
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public void deleteCustomer(int id) {

    }
}

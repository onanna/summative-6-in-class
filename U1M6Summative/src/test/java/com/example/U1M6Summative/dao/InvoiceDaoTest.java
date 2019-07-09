package com.example.U1M6Summative.dao;

import com.example.U1M6Summative.dto.Customer;
import com.example.U1M6Summative.dto.Invoice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoTest {

    @Autowired
    CustomerDao customerDao;
    @Autowired
    InvoiceDao invoiceDao;

    @Before
    public void setUp() throws Exception {

        List<Customer> customerList = customerDao.getAllCustomers();
        for (Customer customer : customerList) {
            customerDao.deleteCustomer(customer.getCustomerId());
        }
        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        for (Invoice invoice : invoiceList) {
            invoiceDao.deleteInvoice(invoice.getInvoiceId());
        }

    }

    @Test(expected  = DataIntegrityViolationException.class)
    public void addWithRefIntegrityException(){
        Invoice invoice = new Invoice();
        invoice.setReturnDate(LocalDate.of(2013, 03, 20));
        invoice.setPickupDate(LocalDate.of(2014, 03, 10));
        invoice.setOrderDate(LocalDate.of(2013, 04, 1));
        invoice.setLateFee(new BigDecimal(3.55));
        invoice.setCustomerId(25);
        invoice.setInvoiceId(40);
    }


    @Test
    public void addGetAndDeleteInvoice() {

        Customer customer = new Customer();
        customer.setFirstName("Mirabel");
        customer.setLastName("Halls");
        customer.setEmail("mirabelhalls@gmail.com");
        customer.setCompany("Trilogy");
        customer.setPhone("37487498734");


        customer = customerDao.addCustomer(customer);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setLateFee(new BigDecimal(2.55));
        invoice.setOrderDate(LocalDate.of(2013,04,20));
        invoice.setPickupDate(LocalDate.of(2014,04,20));
        invoice.setReturnDate(LocalDate.of(2015,04,20));

        invoice = invoiceDao.addInvoice(invoice);

        Invoice invoice1 = invoiceDao.getInvoiceById(invoice.getInvoiceId());
        assertEquals(invoice1, invoice);

        invoiceDao.deleteInvoice(invoice.getInvoiceId());

        invoice1 = invoiceDao.getInvoiceById(invoice.getInvoiceId());
        assertNull(invoice1);
    }



    @Test
    public void findInvoiceByCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Mirabel");
        customer.setLastName("Halls");
        customer.setEmail("mirabelhalls@gmail.com");
        customer.setCompany("Trilogy");
        customer.setPhone("37487498734");


        customer = customerDao.addCustomer(customer);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setLateFee(new BigDecimal(2.55));
        invoice.setOrderDate(LocalDate.of(2013,04,20));
        invoice.setPickupDate(LocalDate.of(2014,04,20));
        invoice.setReturnDate(LocalDate.of(2015,04,20));

        invoice = invoiceDao.addInvoice(invoice);

        List<Invoice> invoice1 = invoiceDao.getInvoiceByCustomer(customer.getCustomerId());

        assertEquals(invoice1.size(), 1);

        assertEquals(invoice1.get(0), invoice);

    }
}

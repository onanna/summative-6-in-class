package com.example.U1M6Summative.dao;

import com.example.U1M6Summative.dto.Customer;
import com.example.U1M6Summative.dto.Invoice;
import com.example.U1M6Summative.dto.InvoiceItem;
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
        InvoiceItem invoiceItem = new InvoiceItem();

        invoiceItem.setDiscount(new BigDecimal(2.99));
        invoiceItem.setUnitRate(new BigDecimal(3.99));
        invoiceItem.setInvoiceId(35);
        invoiceItem.setItemId(24);
        invoiceItem.setQuantity(25);
        invoiceItem.setInvoiceItemId(40);
    }


    @Test
    public void addInvoice() {

        Customer customer = new Customer("Jane", "Williams", "jane@gmail.com", "KemiL", "100234567");
        customer = customerDao.addCustomer(customer);
        Invoice invoice = new Invoice(customer.getCustomerId(), LocalDate.of(2015, 01, 20), LocalDate.of(2015, 01, 23), LocalDate.of(2016, 2, 23), 23.45f);
        Invoice invoice1 = invoiceDao.addInvoice(invoice);
        assertEquals(invoice1, invoice);


    }

    @Test
    public void deleteInvoice() {

        Customer customer = new Customer("Mary", "Louise", "mary@gmail.com", "Gemboree", "130456789");
        customer = customerDao.addCustomer(customer);
        Invoice invoice = new Invoice(customer.getCustomerId(), LocalDate.of(2015, 01, 20), LocalDate.of(2015, 01, 23), LocalDate.of(2016, 2, 23), 23.45f);
        invoice = invoiceDao.addInvoice(invoice);
        invoiceDao.deleteInvoice(invoice.getInvoiceId());
        invoice = invoiceDao.getInvoiceById(invoice.getInvoiceId());
        assertNull(invoice);

    }

    @Test
    public void findInvoiceByCustomer() {
        Customer customer = new Customer("Donald", "Prince", "donald@gmail.com", "Telprince", "123006789");
        customer = customerDao.addCustomer(customer);
        Invoice invoice = new Invoice(customer.getCustomerId(), LocalDate.of(2015, 01, 20), LocalDate.of(2015, 01, 23), LocalDate.of(2016, 2, 23), 23.45f);
        invoiceDao.addInvoice(invoice);
        List<Invoice> invoice1 = invoiceDao.findInvoiceByCustomer(customer.getCustomerId());
        assertEquals(invoice1.size(), 1);

    }
}

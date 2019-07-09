package com.example.U1M6Summative.dao;

import com.example.U1M6Summative.dto.Customer;
import com.example.U1M6Summative.dto.Invoice;

import com.example.U1M6Summative.dto.InvoiceItem;
import com.example.U1M6Summative.dto.Item;
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
    InvoiceItemDao invoiceItemDao;

    @Autowired
    InvoiceDao invoiceDao;

    @Autowired
    CustomerDao customerDao;

    @Autowired
    ItemDao itemDao;

    @Before
    public void setUp() throws Exception {
        List<InvoiceItem> invoiceItemList = invoiceItemDao.getAllInvoiceItems();
        for (InvoiceItem i : invoiceItemList) {
            invoiceItemDao.deleteInvoiceItem(i.getInvoiceItemId());
        }

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        for(Invoice i : invoiceList){
            invoiceDao.deleteInvoice(i.getInvoiceId());
        }

        List<Customer> customerList = customerDao.getAllCustomers();
        for(Customer c : customerList){
            customerDao.deleteCustomer(c.getCustomerId());
        }

        List<Item> itemList = itemDao.getAllItems();
        for(Item t : itemList){
            itemDao.deleteItem(t.getItemId());
        }
    }

    @Test(expected  = DataIntegrityViolationException.class)
    public void addWithRefIntegrityException(){
        Invoice invoice = new Invoice();
        invoice.setCustomerId(25);
        invoice.setOrderDate(LocalDate.of(2013, 04, 1));
        invoice.setPickupDate(LocalDate.of(2014, 03, 10));
        invoice.setReturnDate(LocalDate.of(2013, 03, 20));
        invoice.setLateFee(new BigDecimal("3.55"));

        invoice = invoiceDao.addInvoice(invoice);
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
        invoice.setOrderDate(LocalDate.of(2013,04,20));
        invoice.setPickupDate(LocalDate.of(2014,04,20));
        invoice.setReturnDate(LocalDate.of(2015,04,20));
        invoice.setLateFee(new BigDecimal("2.55"));

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
        invoice.setOrderDate(LocalDate.of(2013,04,20));
        invoice.setPickupDate(LocalDate.of(2014,04,20));
        invoice.setReturnDate(LocalDate.of(2015,04,20));
        invoice.setLateFee(new BigDecimal("2.55"));

        invoice = invoiceDao.addInvoice(invoice);

        List<Invoice> invoiceList = invoiceDao.getInvoiceByCustomer(customer.getCustomerId());

        System.out.println("LIST : " + invoiceList.size());
        assertEquals(1, invoiceList.size());

        System.out.println("ITEM" + invoice.getLateFee());
        System.out.println("ITEM" + (BigDecimal)invoiceList.get(0).getLateFee());
        assertEquals(invoice, invoiceList.get(0));
    }
}

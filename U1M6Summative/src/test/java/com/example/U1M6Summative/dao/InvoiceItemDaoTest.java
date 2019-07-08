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
public class InvoiceItemDaoTest {

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
            invoiceItemDao.deleteInvoiceItem(i.getInvoiceId());
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
        InvoiceItem invoiceItem = new InvoiceItem();

        invoiceItem.setDiscount(new BigDecimal(2.99));
        invoiceItem.setUnitRate(new BigDecimal(3.99));
        invoiceItem.setInvoiceId(35);
        invoiceItem.setItemId(24);
        invoiceItem.setQuantity(25);
        invoiceItem.setInvoiceItemId(40);
    }


    @Test
    public void addGetAndDeleteInvoiceItems(){
        Customer customer = new Customer();

        customer.setPhone("59752943982");
        customer.setCompany("Rutgers");
        customer.setEmail("rutgers@gmail.com");
        customer.setLastName("Nanna");
        customer.setFirstName("ofe");

        customer = customerDao.addCustomer(customer);

        Invoice invoice = new Invoice();

        invoice.setCustomerId(customer.getCustomerId());
        invoice.setLateFee(new BigDecimal("3.00"));
        invoice.setOrderDate(LocalDate.of(2017, 02, 03));
        invoice.setPickupDate(LocalDate.of(2018, 03, 20));
        invoice.setReturnDate(LocalDate.of(2018, 03, 30));


        invoice = invoiceDao.addInvoice(invoice);

        Item item = new Item();

        item.setDailyRate(new BigDecimal(3.50));
        item.setName("Ketchup");
        item.setDescription("This is a condiment");
        item = itemDao.addItem(item);

        InvoiceItem invoiceItem = new InvoiceItem();

        invoiceItem.setDiscount(new BigDecimal(2.99));
        invoiceItem.setUnitRate(new BigDecimal(3.99));
        invoiceItem.setInvoiceId(invoice.getInvoiceId());
        invoiceItem.setItemId(item.getItemId());
        invoiceItem.setQuantity(25);

        invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);

        InvoiceItem invoiceItem1 = invoiceItemDao.getInvoiceItem(invoiceItem.getInvoiceItemId());

        assertEquals(invoiceItem, invoiceItem1);

        invoiceItemDao.deleteInvoiceItem(invoiceItem.getInvoiceItemId());

        invoiceItem1 = invoiceItemDao.getInvoiceItem(invoiceItem.getInvoiceItemId());

        assertNull(invoiceItem1);


    }

    @Test
    public void getAllInvoiceItems() {
        Customer customer = new Customer();

        customer.setPhone("59752943982");
        customer.setCompany("Rutgers");
        customer.setEmail("rutgers@gmail.com");
        customer.setLastName("Nanna");
        customer.setFirstName("ofe");

        customer = customerDao.addCustomer(customer);

        Invoice invoice = new Invoice();

        invoice.setCustomerId(customer.getCustomerId());
        invoice.setLateFee(new BigDecimal("3.00"));
        invoice.setOrderDate(LocalDate.of(2017, 02, 03));
        invoice.setPickupDate(LocalDate.of(2018, 03, 20));
        invoice.setReturnDate(LocalDate.of(2018, 03, 30));


        invoice = invoiceDao.addInvoice(invoice);

        Item item = new Item();

        item.setDailyRate(new BigDecimal(3.50));
        item.setName("Ketchup");
        item.setDescription("This is a condiment");
        item = itemDao.addItem(item);

        InvoiceItem invoiceItem = new InvoiceItem();

        invoiceItem.setDiscount(new BigDecimal(2.99));
        invoiceItem.setUnitRate(new BigDecimal(3.99));
        invoiceItem.setInvoiceId(invoice.getInvoiceId());
        invoiceItem.setItemId(item.getItemId());
        invoiceItem.setQuantity(25);

        invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);

        List<InvoiceItem> invoiceItemList = invoiceItemDao.getAllInvoiceItems();

        assertEquals(invoiceItemList.size(), 1);
    }

    @Test
    public void updateInvoiceItem() {
        Customer customer = new Customer();

        customer.setPhone("59752943982");
        customer.setCompany("Rutgers");
        customer.setEmail("rutgers@gmail.com");
        customer.setLastName("Nanna");
        customer.setFirstName("ofe");

        customer = customerDao.addCustomer(customer);

        Invoice invoice = new Invoice();

        invoice.setCustomerId(customer.getCustomerId());
        invoice.setLateFee(new BigDecimal("3.00"));
        invoice.setOrderDate(LocalDate.of(2017, 02, 03));
        invoice.setPickupDate(LocalDate.of(2018, 03, 20));
        invoice.setReturnDate(LocalDate.of(2018, 03, 30));


        invoice = invoiceDao.addInvoice(invoice);

        Item item = new Item();

        item.setDailyRate(new BigDecimal(3.50));
        item.setName("Ketchup");
        item.setDescription("This is a condiment");
        item = itemDao.addItem(item);

        InvoiceItem invoiceItem = new InvoiceItem();

        invoiceItem.setDiscount(new BigDecimal(2.99));
        invoiceItem.setUnitRate(new BigDecimal(3.99));
        invoiceItem.setInvoiceId(invoice.getInvoiceId());
        invoiceItem.setItemId(item.getItemId());
        invoiceItem.setQuantity(25);

        invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);

        invoiceItem.setQuantity(32);
        invoiceItem.setUnitRate(new BigDecimal(3.50));

        invoiceItemDao.updateInvoiceItem(invoiceItem);

        InvoiceItem invoiceItem1 = invoiceItemDao.getInvoiceItem(invoiceItem.getInvoiceItemId());

        assertEquals(invoiceItem, invoiceItem1);

    }
}
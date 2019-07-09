package com.example.U1M6Summative.service;

import com.example.U1M6Summative.dao.*;
import com.example.U1M6Summative.dto.Customer;
import com.example.U1M6Summative.dto.Invoice;
import com.example.U1M6Summative.dto.InvoiceItem;
import com.example.U1M6Summative.dto.Item;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ServiceLayerTest {

    ServiceLayer serviceLayer;
    CustomerDao customerDao;
    ItemDao itemDao;
    InvoiceItemDao invoiceItemDao;
    InvoiceDao invoiceDao;

    @Before
    public void setUp() throws Exception {
        setupCustomerDao();
        setupInvoiceDao();
        setupInvoiceItemDao();
        setupItemDao();

        serviceLayer = new ServiceLayer(customerDao, invoiceDao, invoiceItemDao, itemDao);


    }

    @Test
    public void saveCustomer() {
    }

    @Test
    public void findCustomer() {
    }

    @Test
    public void removeCustomer() {
    }

    @Test
    public void updateCustomer() {
    }

    @Test
    public void saveItem() {
    }

    @Test
    public void findItem() {
    }

    @Test
    public void removeItem() {
    }

    @Test
    public void updateItem() {
    }

    @Test
    public void saveInvoice() {
    }

    @Test
    public void findInvoice() {
    }

    @Test
    public void deleteInvoice() {
    }

    @Test
    public void findAllInvoicesByCustomer() {
    }

    private void setupCustomerDao(){
        customerDao = mock(CustomerDaoJdbcTemplateImpl.class);
        Customer customerMock = new Customer();
        customerMock.setCustomerId(35);
        customerMock.setFirstName("Waluigi");
        customerMock.setLastName("Waaaaaaaaa");
        customerMock.setEmail("waluigi@waaaah.com");
        customerMock.setCompany("Cognizant");
        customerMock.setPhone("4334336363");

        Customer customer = new Customer();
        customer.setFirstName("Wario");
        customer.setLastName("Waaa");
        customer.setEmail("wario@waaaah.com");
        customer.setCompany("Trilogy");
        customer.setPhone("587556576");

        List<Customer> customerList = new ArrayList<>();
        customerList.add(customerMock);

        doReturn(customerMock).when(customerDao).addCustomer(customer);
        doReturn(customerMock).when(customerDao).getCustomer(35);
        doReturn(customerList).when(customerDao).getAllCustomers();


    }
    private void setupItemDao(){
        itemDao = mock(ItemDaoJdbcTemplateImpl.class);
        Item itemMock = new Item();
        itemMock.setItemId(35);
        itemMock.setName("Ketchup");
        itemMock.setDescription("A condiment");
        itemMock.setDailyRate(new BigDecimal("3.99"));

        Item item = new Item();
        item.setName("Mayo");
        item.setDescription("A Chocolate");
        item.setDailyRate(new BigDecimal("2.55"));

        List<Item> itemList = new ArrayList<>();
        itemList.add(itemMock);

        doReturn(itemMock).when(itemDao).addItem(item);
        doReturn(itemMock).when(itemDao).getItem(35);
        doReturn(itemList).when(itemDao).getAllItems();

    }
    private void setupInvoiceDao(){
        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);
        Invoice invoiceMock = new Invoice();
        invoiceMock.setInvoiceId(45);
        invoiceMock.setCustomerId(25);
        invoiceMock.setOrderDate(LocalDate.of(2013, 04, 1));
        invoiceMock.setPickupDate(LocalDate.of(2014, 03, 10));
        invoiceMock.setReturnDate(LocalDate.of(2013, 03, 20));
        invoiceMock.setLateFee(new BigDecimal("3.55"));

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

        List<Invoice> invoiceList = new ArrayList<>();
        invoiceList.add(invoiceMock);

        doReturn(invoiceMock).when(invoiceDao).addInvoice(invoice);
        doReturn(invoiceMock).when(invoiceDao).getInvoiceById(45);
        doReturn(invoiceList).when(invoiceDao).getAllInvoices();

    }
    private void setupInvoiceItemDao(){
        invoiceItemDao = mock(InvoiceItemDaoJdbcTemplateImpl.class);
        InvoiceItem invoiceItemMock = new InvoiceItem();

        invoiceItemMock.setInvoiceItemId(22);
        invoiceItemMock.setInvoiceId(35);
        invoiceItemMock.setItemId(24);
        invoiceItemMock.setQuantity(25);
        invoiceItemMock.setUnitRate(new BigDecimal("3.99"));
        invoiceItemMock.setDiscount(new BigDecimal("2.99"));
        invoiceItemMock.setInvoiceItemId(40);

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

        List<InvoiceItem> invoiceItemList = new ArrayList<>();
        invoiceItemList.add(invoiceItemMock);

        doReturn(invoiceItemMock).when(invoiceItemDao).addInvoiceItem(invoiceItem);
        doReturn(invoiceItemMock).when(invoiceItemDao).getInvoiceItem(22);
        doReturn(invoiceItemList).when(invoiceItemDao).getAllInvoiceItems();
    }
}
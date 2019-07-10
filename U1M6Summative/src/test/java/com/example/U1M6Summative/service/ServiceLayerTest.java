package com.example.U1M6Summative.service;

import com.example.U1M6Summative.dao.*;
import com.example.U1M6Summative.dto.Customer;
import com.example.U1M6Summative.dto.Invoice;
import com.example.U1M6Summative.dto.InvoiceItem;
import com.example.U1M6Summative.dto.Item;
import com.example.U1M6Summative.viewmodel.InvoiceItemViewModel;
import com.example.U1M6Summative.viewmodel.InvoiceViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
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

        serviceLayer = new ServiceLayer(customerDao, itemDao, invoiceDao, invoiceItemDao);
    }

    @Test
    public void saveCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Rocky");
        customer.setLastName("Smith");
        customer.setEmail("rocky.smith@email.com");
        customer.setCompany("Cog");
        customer.setPhone("345-866-7879");

        customer = serviceLayer.saveCustomer(customer);
        Customer fromService = serviceLayer.findCustomer(customer.getCustomerId());
        assertEquals(customer, fromService);

        List<Customer> customerList = serviceLayer.findAllCustomers();
        assertEquals(1, customerList.size());
        assertEquals(customer, customerList.get(0));
    }

    @Test
    public void findCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Rocky");
        customer.setLastName("Smith");
        customer.setEmail("rocky.smith@email.com");
        customer.setCompany("Cog");
        customer.setPhone("345-866-7879");

        customer = serviceLayer.saveCustomer(customer);
        Customer fromService = serviceLayer.findCustomer(customer.getCustomerId());
        assertEquals(customer, fromService);
    }

    @Test
    public void removeCustomer() {
    }

    @Test
    public void updateCustomer() {
    }

    @Test
    public void saveItem() {
        Item item = new Item();
        item.setName("Ketchup");
        item.setDescription("A condiment");
        item.setDailyRate(new BigDecimal("3.99"));

        item = serviceLayer.saveItem(item);

        assertEquals(item, serviceLayer.findItem(item.getItemId()));
    }

    @Test
    public void findItem() {
        List<Item> itemList = serviceLayer.findItems();

        Item item1 = serviceLayer.findItem(35);

        Item item2 = itemList.get(0);

        assertEquals(item1, item2);
    }

    @Test
    public void removeItem() {
    }

    @Test
    public void updateItem() {
    }

    @Test
    public void saveInvoice() {
        Customer customer = new Customer();
        customer.setFirstName("Rocky");
        customer.setLastName("Smith");
        customer.setEmail("rocky.smith@email.com");
        customer.setCompany("Cog");
        customer.setPhone("345-866-7879");
        customer = serviceLayer.saveCustomer(customer);

        Item item = new Item();
        item.setName("Ketchup");
        item.setDescription("A condiment");
        item.setDailyRate(new BigDecimal("3.99"));
        item = serviceLayer.saveItem(item);

        InvoiceViewModel invVM = new InvoiceViewModel();
        invVM.setCustomer(customer);
        invVM.setOrderDate(LocalDate.of(2013, 04, 1));
        invVM.setPickupDate(LocalDate.of(2014, 03, 10));
        invVM.setReturnDate(LocalDate.of(2013, 03, 20));
        invVM.setLateFee(new BigDecimal("3.55"));
        invVM = serviceLayer.saveInvoice(invVM);

        InvoiceItemViewModel invoiceItemViewModel = new InvoiceItemViewModel();
        invoiceItemViewModel.setInvoiceId(invVM.getInvoiceId());
        invoiceItemViewModel.setItem(item);
        invoiceItemViewModel.setQuantity(25);
        invoiceItemViewModel.setUnitRate(new BigDecimal("3.99"));
        invoiceItemViewModel.setDiscount(new BigDecimal("2.99"));
        invoiceItemViewModel = serviceLayer.saveInvoiceItem(invoiceItemViewModel);

        List<InvoiceItemViewModel> invItemVM = new ArrayList<>();
        invItemVM.add(invoiceItemViewModel);
        invVM.setInvoiceItemViewModels(invItemVM);

        invVM = serviceLayer.saveInvoice(invVM);
        InvoiceViewModel fromService = serviceLayer.findInvoice(invVM.getInvoiceId());
        assertEquals(invVM, fromService);
    }

    @Test
    public void findInvoice() {
        List<InvoiceViewModel> invoiceViewModelList = serviceLayer.findAllInvoices();

        InvoiceViewModel invoiceViewModel = serviceLayer.findInvoice(33);

        InvoiceViewModel invoiceViewModel1 = invoiceViewModelList.get(0);

        assertEquals(invoiceViewModel, invoiceViewModel1);
    }

    @Test
    public void updateInvoice() {
    }

    @Test
    public void deleteInvoice() {
    }

    @Test
    public void findAllInvoicesByCustomer() {
    }

    private void setupCustomerDao(){
        customerDao = mock(CustomerDaoJdbcTemplateImpl.class);
        Customer customer = new Customer();
        customer.setCustomerId(45);
        customer.setFirstName("Rocky");
        customer.setLastName("Smith");
        customer.setEmail("rocky.smith@email.com");
        customer.setCompany("Cog");
        customer.setPhone("345-866-7879");

        Customer customer1 = new Customer();
        customer1.setFirstName("Rocky");
        customer1.setLastName("Smith");
        customer1.setEmail("rocky.smith@email.com");
        customer1.setCompany("Cog");
        customer1.setPhone("345-866-7879");

        List<Customer> customerList = new ArrayList();
        customerList.add(customer);

        doReturn(customer).when(customerDao).addCustomer(customer1);
        doReturn(customer).when(customerDao).getCustomer(45);
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
        item.setName("Ketchup");
        item.setDescription("A condiment");
        item.setDailyRate(new BigDecimal("3.99"));

        List<Item> itemList = new ArrayList<>();
        itemList.add(itemMock);

        doReturn(itemMock).when(itemDao).addItem(item);
        doReturn(itemMock).when(itemDao).getItem(35);
        doReturn(itemList).when(itemDao).getAllItems();
    }
    private void setupInvoiceDao(){
        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);
        Invoice invoiceMock = new Invoice();
        invoiceMock.setInvoiceId(33);
        invoiceMock.setCustomerId(45);
        invoiceMock.setOrderDate(LocalDate.of(2013, 04, 1));
        invoiceMock.setPickupDate(LocalDate.of(2014, 03, 10));
        invoiceMock.setReturnDate(LocalDate.of(2013, 03, 20));
        invoiceMock.setLateFee(new BigDecimal("3.55"));

        Invoice invoice = new Invoice();
        invoice.setCustomerId(45);
        invoice.setOrderDate(LocalDate.of(2013, 04, 1));
        invoice.setPickupDate(LocalDate.of(2014, 03, 10));
        invoice.setReturnDate(LocalDate.of(2013, 03, 20));
        invoice.setLateFee(new BigDecimal("3.55"));

        List<Invoice> invoiceList = new ArrayList<>();
        invoiceList.add(invoiceMock);

        doReturn(invoiceMock).when(invoiceDao).addInvoice(invoice);
        doReturn(invoiceMock).when(invoiceDao).getInvoiceById(33);
        doReturn(invoiceList).when(invoiceDao).getAllInvoices();
    }

    private void setupInvoiceItemDao(){
        invoiceItemDao = mock(InvoiceItemDaoJdbcTemplateImpl.class);

        InvoiceItem invoiceItemMock = new InvoiceItem();
        invoiceItemMock.setInvoiceItemId(22);
        invoiceItemMock.setInvoiceId(33);
        invoiceItemMock.setItemId(35);
        invoiceItemMock.setQuantity(25);
        invoiceItemMock.setUnitRate(new BigDecimal("3.99"));
        invoiceItemMock.setDiscount(new BigDecimal("2.99"));

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(33);
        invoiceItem.setItemId(35);
        invoiceItem.setQuantity(25);
        invoiceItem.setUnitRate(new BigDecimal("3.99"));
        invoiceItem.setDiscount(new BigDecimal("2.99"));

        List<InvoiceItem> invoiceItemList = new ArrayList<>();
        invoiceItemList.add(invoiceItemMock);

        doReturn(invoiceItemMock).when(invoiceItemDao).addInvoiceItem(invoiceItem);
        doReturn(invoiceItemMock).when(invoiceItemDao).getInvoiceItem(22);
        doReturn(invoiceItemList).when(invoiceItemDao).getAllInvoiceItems();
    }
}
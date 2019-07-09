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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ItemDaoTest {

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

    @Test
    public void addGetAndDeleteItem(){
        Item item = new Item();

        item.setName("Ketchup");
        item.setDescription("A condiment");
        item.setDailyRate(new BigDecimal("3.99"));

        item = itemDao.addItem(item);

        Item item1 = itemDao.getItem(item.getItemId());

        assertEquals(item, item1);

        itemDao.deleteItem(item.getItemId());

        item1 = itemDao.getItem(item.getItemId());

        assertNull(item1);
    }

    @Test
    public void getAllItems() {
        Item item = new Item();

        item.setDescription("A condiment");
        item.setName("Ketchup");
        item.setDailyRate(new BigDecimal(3.99));

        item = itemDao.addItem(item);

        List<Item> itemList = itemDao.getAllItems();

        assertEquals(itemList.size(), 1);

    }

    @Test
    public void updateItem() {
        Item item = new Item();

        item.setName("Ketchup");
        item.setDescription("A condiment");
        item.setDailyRate(new BigDecimal("3.99"));

        item = itemDao.addItem(item);

        item.setName("Mayo");
        item.setDescription("A Chocolate");
        item.setDailyRate(new BigDecimal("2.55"));

        itemDao.updateItem(item);

        Item item1 = itemDao.getItem(item.getItemId());

        assertEquals(item, item1);
    }
}

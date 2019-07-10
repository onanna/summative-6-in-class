package com.example.U1M6Summative.service;

import com.example.U1M6Summative.dao.CustomerDao;
import com.example.U1M6Summative.dao.InvoiceDao;
import com.example.U1M6Summative.dao.InvoiceItemDao;
import com.example.U1M6Summative.dao.ItemDao;

import com.example.U1M6Summative.dto.Customer;
import com.example.U1M6Summative.dto.Invoice;
import com.example.U1M6Summative.dto.InvoiceItem;
import com.example.U1M6Summative.dto.Item;
import com.example.U1M6Summative.viewmodel.InvoiceItemViewModel;
import com.example.U1M6Summative.viewmodel.InvoiceViewModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    private CustomerDao customerDao;
    private ItemDao itemDao;
    private InvoiceDao invoiceDao;
    private InvoiceItemDao invoiceItemDao;

    @Autowired
    public ServiceLayer(CustomerDao customerDao, ItemDao itemDao, InvoiceDao invoiceDao, InvoiceItemDao invoiceItemDao) {
        this.customerDao = customerDao;
        this.itemDao = itemDao;
        this.invoiceDao = invoiceDao;
        this.invoiceItemDao = invoiceItemDao;
    }

    // customer Api
    // add customer
    public Customer saveCustomer(Customer customer){

        return customerDao.addCustomer(customer);
    }

    // get customer by id
    public Customer findCustomer(Integer customerId) {

        return customerDao.getCustomer(customerId);
    }

    // get customer by id
    public List<Customer> findAllCustomers() {

        return customerDao.getAllCustomers();
    }

    // remove customer
    public void updateCustomer(Customer customer) {

        customerDao.updateCustomer(customer);
    }

    // delete customer
    public void removeCustomer(int customerId){
        customerDao.deleteCustomer(customerId);
    }

    // item API
    //add item
    public Item saveItem(Item item){

        return itemDao.addItem(item);
    }

    // get item by id
    public Item findItem(Integer itemId){
        return itemDao.getItem(itemId);
    }

    // get all items
    public List<Item> findItems(){
        return itemDao.getAllItems();
    }

    //update item
    public void updateItem(Item item){
        itemDao.updateItem(item);
    }

    // remove item by id
    public void removeItem(int itemId){
        itemDao.deleteItem(itemId);
    }

    @Transactional
    public InvoiceItemViewModel saveInvoiceItem(InvoiceItemViewModel invItemVM){

        // Persist Invoice
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(invItemVM.getInvoiceId());
        invoiceItem.setItemId(invItemVM.getItem().getItemId());
        invoiceItem.setQuantity(invItemVM.getQuantity());
        invoiceItem.setUnitRate(invItemVM.getUnitRate());
        invoiceItem.setDiscount(invItemVM.getDiscount());
        invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);

        invItemVM.setInvoiceItemId(invoiceItem.getInvoiceItemId());

        return invItemVM;
    }

    // invoice Api
    // add invoice
    @Transactional
    public InvoiceViewModel saveInvoice(InvoiceViewModel invoiceViewModel){

        // Persist Invoice
        Invoice invoice = new Invoice();
        invoice.setCustomerId(invoiceViewModel.getCustomer().getCustomerId());
        invoice.setOrderDate(invoiceViewModel.getOrderDate());
        invoice.setPickupDate(invoiceViewModel.getPickupDate());
        invoice.setReturnDate(invoiceViewModel.getReturnDate());
        invoice.setLateFee(invoiceViewModel.getLateFee());
        invoice = invoiceDao.addInvoice(invoice);
        invoiceViewModel.setInvoiceId(invoice.getInvoiceId());

        // Add Invoice Id to InvoiceItems and Persist InvoiceItems
        List<InvoiceItemViewModel> invoiceItemList = invoiceViewModel.getInvoiceItemViewModels();

        for (InvoiceItemViewModel i : invoiceItemList)
        {
            InvoiceItem iv = new InvoiceItem();
            iv.setInvoiceId(invoiceViewModel.getInvoiceId());
            iv.setItemId(i.getItem().getItemId());
            iv.setQuantity(i.getQuantity());
            iv.setUnitRate(i.getUnitRate());
            iv.setDiscount(i.getDiscount());

            invoiceItemDao.addInvoiceItem(iv);
        }

        List<InvoiceItem> invoiceItem = invoiceItemDao.getInvoiceItemByInvoice(invoiceViewModel.getInvoiceId());
        List<InvoiceItemViewModel> invItemVM = new ArrayList<>();
        for (InvoiceItem i : invoiceItem)
        {
            invItemVM.add(buildInvoiceItemViewModel(i));
        }
        invoiceViewModel.setInvoiceItemViewModels(invItemVM);

        return invoiceViewModel;
    }

    // get Invoice by id
    public InvoiceViewModel findInvoice(Integer invoiceId){

        Invoice invoice = invoiceDao.getInvoiceById(invoiceId);

        return buildInvoiceViewModel(invoice);
    }

    // get all Invoices
    public List<InvoiceViewModel> findAllInvoices( ){

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        List<InvoiceViewModel> invVMList = new ArrayList<>();

        for (Invoice i : invoiceList)
        {
            invVMList.add(buildInvoiceViewModel(i));
        }

        return invVMList;
    }

    //delete Invoice by id
    @Transactional
    public void deleteInvoice( int id){
        // Remove all associated invoiceItems first
        List<InvoiceItem> invoiceItemList = invoiceItemDao.getInvoiceItemByInvoice(id);

        invoiceItemList.stream()
                .forEach(invoiceItem -> invoiceItemDao.deleteInvoiceItem(invoiceItem.getInvoiceItemId()));

        // Remove Invoice
        invoiceDao.deleteInvoice(id);
    }

    // get all invoices by customer
    public List<InvoiceViewModel> findAllInvoicesByCustomer( int customerId ){

        List<InvoiceViewModel> invoiceViewModelList = new ArrayList<>();
        List<Invoice> invoiceList = invoiceDao.getInvoiceByCustomer(customerId);

        for (Invoice i : invoiceList)
        {
            invoiceViewModelList.add(buildInvoiceViewModel(i));
        }
        return invoiceViewModelList;
    }

    // Helper Methods
    private InvoiceItemViewModel buildInvoiceItemViewModel(InvoiceItem invoiceItem) {

        // Get the associated items
        Item item = itemDao.getItem(invoiceItem.getItemId());

        // Assemble the AlbumViewModel
        InvoiceItemViewModel invItemVM = new InvoiceItemViewModel();
        invItemVM.setInvoiceItemId(invoiceItem.getInvoiceItemId());
        invItemVM.setInvoiceId(invoiceItem.getInvoiceId());
        invItemVM.setItem(item);
        invItemVM.setQuantity(invoiceItem.getQuantity());
        invItemVM.setUnitRate(invoiceItem.getUnitRate());
        invItemVM.setDiscount(invoiceItem.getDiscount());

        // Return the InvoiceItemViewModel
        return invItemVM;
    }

    // Helper Methods
    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {

        // Get the associated Customer
        Customer customer = customerDao.getCustomer(invoice.getCustomerId());

        // Get the InvoiceItems associated with the Invoice
        List<InvoiceItem> invItemList = invoiceItemDao.getInvoiceItemByInvoice(invoice.getInvoiceId());

        // BuildInvoiceItemViewModel
        List<InvoiceItemViewModel> invItemVMList = new ArrayList<>();

        for (InvoiceItem i : invItemList)
        {
            invItemVMList.add(buildInvoiceItemViewModel(i));
        }

        // Assemble the InvoiceViewModel
        InvoiceViewModel invVM = new InvoiceViewModel();
        invVM.setInvoiceId(invoice.getInvoiceId());
        invVM.setCustomer(customer);
        invVM.setOrderDate(invoice.getOrderDate());
        invVM.setPickupDate(invoice.getPickupDate());
        invVM.setReturnDate(invoice.getReturnDate());
        invVM.setLateFee(invoice.getLateFee());
        invVM.setInvoiceItemViewModels(invItemVMList);

        // Return the InvoiceViewModel
        return invVM;
    }
}

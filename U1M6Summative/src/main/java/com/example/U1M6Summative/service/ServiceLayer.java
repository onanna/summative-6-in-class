package com.example.U1M6Summative.service;

import com.example.U1M6Summative.dao.CustomerDao;
import com.example.U1M6Summative.dao.InvoiceDao;
import com.example.U1M6Summative.dao.InvoiceItemDao;
import com.example.U1M6Summative.dao.ItemDao;
import com.example.U1M6Summative.dto.Invoice;
import com.example.U1M6Summative.viewmodel.CustomerViewModel;
import com.example.U1M6Summative.viewmodel.InvoiceViewModel;
import com.example.U1M6Summative.viewmodel.ItemViewModel;
import org.graalvm.compiler.lir.alloc.lsra.LinearScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    private CustomerDao customerDao;
    private InvoiceDao invoiceDao;
    private InvoiceItemDao invoiceItemDao;
    private ItemDao itemDao;

    @Autowired

    public ServiceLayer(CustomerDao customerDao, InvoiceDao invoiceDao, InvoiceItemDao invoiceItemDao, ItemDao itemDao) {
        this.customerDao = customerDao;
        this.invoiceDao = invoiceDao;
        this.invoiceItemDao = invoiceItemDao;
        this.itemDao = itemDao;
    }


// customer Api
    // add customer
    public CustomerViewModel saveCustomer( CustomerViewModel customerViewModel){

        return customerViewModel;
    }

    // get customer by id
    public CustomerViewModel findCustomer( CustomerViewModel customerViewModel) {

        //returns helper method with an object of customer from the dao passed as a param

        //below is just a placeholder

        return customerViewModel;
    }

    // delete customer
    public void removeCustomer( int id){


    }

    // update customer
    public void updateCustomer(CustomerViewModel customerViewModel) {


    }


// item API
    //add item
    public ItemViewModel saveItem(ItemViewModel itemViewModel){

        return itemViewModel;
    }

    // get item by id
    public ItemViewModel findItem(ItemViewModel itemViewModel){

        //returns helper method with an object of item from the dao passed as a param

        //below is just a placeholder
        return itemViewModel;
    }

    // remove item by id
    public void removeItem( int id){

    }

    //update item
    public void updateItem(ItemViewModel itemViewModel){

    }


 //    invoice Api


    // add invoice
    public InvoiceViewModel saveInvoice(InvoiceViewModel invoiceViewModel){


        return invoiceViewModel;
    }

    // get Invoice by id
    public InvoiceViewModel findInvoice(InvoiceViewModel invoiceViewModel){

        //returns helper method with an object of Invoice from the dao passed as a param

        //below is just a placeholder
        return invoiceViewModel;
    }


    //delete Invoice by id
    public void deleteInvoice( int id){

    }

    // get all invoices by customer
    public List<InvoiceViewModel> findAllInvoicesByCustomer( int customerId ){

        //new list built and populated with the helper method in an enhanced for loop

        //below is just a placeholder
        List<InvoiceViewModel> invoiceViewModelList = new ArrayList<>();
        return invoiceViewModelList;
    }

}

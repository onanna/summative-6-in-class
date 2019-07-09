package com.example.U1M6Summative.dao;

import com.example.U1M6Summative.dto.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerDaoTest {
    //making the setup later once the Service Layer is created

    @Autowired
    CustomerDao customerDao;


    @Before
    public void setUp() throws Exception {
        List<Customer> customerList = customerDao.getAllCustomers();
        for(Customer c : customerList){
            customerDao.deleteCustomer(c.getCustomerId());
        }

    }


    @Test
    public void addGetDeleteCustomer(){

        Customer customer1 = new Customer();
        customer1.setFirstName("Waluigi");
        customer1.setLastName("Waaaaaaaaa");
        customer1.setEmail("waluigi@waaaah.com");
        customer1.setCompany("Cognizant");
        customer1.setPhone("4334336363");

        customer1 = customerDao.addCustomer(customer1);
        Customer customer2 = customerDao.getCustomer(customer1.getCustomerId());

        assertEquals(customer1, customer2);

        customerDao.deleteCustomer(customer1.getCustomerId());

        customer2 = customerDao.getCustomer(customer1.getCustomerId());

        assertNull(customer2);
    }

    @Test
    public void getAllCustomers(){

        Customer customer1 = new Customer();

        customer1.setFirstName("Waluigi");
        customer1.setLastName("Waaaaaaaaa");
        customer1.setEmail("waluigi@waaaah.com");
        customer1.setCompany("Cognizant");
        customer1.setPhone("37462646474");

       customer1 = customerDao.addCustomer(customer1);

        List<Customer> customerList = customerDao.getAllCustomers();

        assertEquals(1, customerList.size());


    }
    @Test
    public void updateCustomer(){
        Customer customer1 = new Customer();

        customer1.setFirstName("Waluigi");
        customer1.setLastName("Waaaaaaaaa");
        customer1.setEmail("waluigi@waaaah.com");
        customer1.setCompany("Cognizant");
        customer1.setPhone("48854985803");

        customer1 = customerDao.addCustomer(customer1);


        customer1.setFirstName("Wario");
        customer1.setLastName("Waaa");
        customer1.setEmail("wario@waaaah.com");
        customer1.setCompany("Trilogy");

        customerDao.updateCustomer(customer1);

        Customer customer2 = customerDao.getCustomer(customer1.getCustomerId());

        assertEquals(customer1,customer2);



    }



}
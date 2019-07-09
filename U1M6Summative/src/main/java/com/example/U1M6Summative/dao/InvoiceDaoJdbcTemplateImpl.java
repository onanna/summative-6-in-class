package com.example.U1M6Summative.dao;

import com.example.U1M6Summative.dto.Invoice;
import com.example.U1M6Summative.dto.InvoiceItem;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InvoiceDaoJdbcTemplateImpl implements InvoiceDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public InvoiceDaoJdbcTemplateImpl (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //defined statements
    private static final String INSERT_INVOICE_SQL =
            "insert into invoice (customer_id, order_date, pickup_date, return_date, late_fee) values (?,?,?,?,?)";
    private static final String SELECT_INVOICE_SQL =
            "select * from invoice where invoice_id = ?";
    private static final String SELECT_ALL_INVOICE_SQL =
            "select * from invoice";
    private static final String UPDATE_INVOICE_SQL =
            "update invoice set customer_id = ?, order_date = ?, pickup_date = ?, return_date = ?, late_fee = ? where invoice_id = ?";
    private static final String DELETE_INVOICE_SQL =
            "delete invoice where invoice_id = ?";
    private static final String SELECT_ALL_CUSTOMER_BY_INVOICE_SQL =
            "select * from invoice where customer_id = ?";

    @Override
    public Invoice getInvoiceById( int id)
    {
        try {
            return jdbcTemplate.queryForObject(SELECT_INVOICE_SQL, this::mapRowToInvoice, id);
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Invoice> getAllInvoices(){
        return jdbcTemplate.query(SELECT_ALL_INVOICE_SQL, this::mapRowToInvoice);
    }

    @Override
    @Transactional
    public Invoice addInvoice(Invoice invoice) {
        jdbcTemplate.update(INSERT_INVOICE_SQL,
                invoice.getCustomerId(),
                invoice.getOrderDate(),
                invoice.getPickupDate(),
                invoice.getReturnDate(),
                invoice.getLateFee());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        invoice.setInvoiceId(id);

        return invoice;
    }

    @Override
<<<<<<< HEAD
    public void updateInvoice(Invoice invoice) {
        jdbcTemplate.update(UPDATE_INVOICE_SQL,
                invoice.getCustomerId(),
                invoice.getOrderDate(),
                invoice.getPickupDate(),
                invoice.getReturnDate(),
                invoice.getLateFee(),
                invoice.getInvoiceId());
=======
    public List<Invoice> getInvoicByCustomer(Integer customerId) {
        return null;
>>>>>>> 43b143b1f1817b943783d6b30eeba7b6d6e07f89
    }

    @Override
    public void deleteInvoice(int id){
        jdbcTemplate.update(DELETE_INVOICE_SQL, id);
    }

    public List<Invoice> getInvoiceByCustomer(Integer customerId){
        return jdbcTemplate.query(SELECT_ALL_CUSTOMER_BY_INVOICE_SQL, this::mapRowToInvoice);
    }

    private Invoice mapRowToInvoice(ResultSet rs, int rowNum)throws SQLException {
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(rs.getInt("invoice_id"));
        invoice.setCustomerId(rs.getInt("customer_id"));
        invoice.setOrderDate(rs.getDate("order_date").toLocalDate());
        invoice.setPickupDate(rs.getDate("pickup_date").toLocalDate());
        invoice.setReturnDate(rs.getDate("return_date").toLocalDate());
        invoice.setLateFee(rs.getBigDecimal("late_fee"));

        return invoice;
    }
}

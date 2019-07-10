package com.example.U1M6Summative.viewmodel;

import com.example.U1M6Summative.dto.Customer;
import com.example.U1M6Summative.dto.InvoiceItem;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InvoiceViewModel {

    private Integer invoiceId;
    private Customer customer;
    private LocalDate orderDate;
    private LocalDate pickupDate;
    private LocalDate returnDate;
    private BigDecimal lateFee;
    private List<InvoiceItemViewModel> invoiceItemViewModels = new ArrayList<>( );

    public InvoiceViewModel() {
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public BigDecimal getLateFee() {
        return lateFee;
    }

    public void setLateFee(BigDecimal lateFee) {
        this.lateFee = lateFee;
    }

    public List<InvoiceItemViewModel> getInvoiceItemViewModels() {
        return invoiceItemViewModels;
    }

    public void setInvoiceItemViewModels(List<InvoiceItemViewModel> invoiceItemViewModels) {
        this.invoiceItemViewModels = invoiceItemViewModels;
    }

    public void addInvoiceItemViewModel(InvoiceItemViewModel invoiceItemViewModel) {
        invoiceItemViewModels.add(invoiceItemViewModel);
    }

    public void removeInvoiceItemViewModel(InvoiceItemViewModel invoiceItemViewModel) {
        invoiceItemViewModels.remove(invoiceItemViewModel);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceViewModel invoiceViewModel = (InvoiceViewModel) o;
        return getInvoiceId() == invoiceViewModel.getInvoiceId() &&
                Objects.equals(getCustomer(), invoiceViewModel.getCustomer()) &&
                Objects.equals(getOrderDate(), invoiceViewModel.getOrderDate()) &&
                Objects.equals(getPickupDate(), invoiceViewModel.getPickupDate()) &&
                Objects.equals(getReturnDate(), invoiceViewModel.getReturnDate()) &&
                Objects.equals(getLateFee(), invoiceViewModel.getLateFee()) &&
                Objects.equals(getInvoiceItemViewModels(), invoiceViewModel.getInvoiceItemViewModels());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInvoiceId(),
                getCustomer(),
                getOrderDate(),
                getPickupDate(),
                getReturnDate(),
                getLateFee(),
                getInvoiceItemViewModels());
    }
}

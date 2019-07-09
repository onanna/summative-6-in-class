package com.example.U1M6Summative.viewmodel;

import com.example.U1M6Summative.dto.InvoiceItem;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InvoiceViewModel {

  private Integer id;
  private Integer customerId;
  private LocalDate orderDate;
  private LocalDate pickupDate;
  private LocalDate returnDate;
  private BigDecimal lateFee;

  List<InvoiceItem> invoiceItemList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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

    public List<InvoiceItem> getInvoiceItemList() {
        return invoiceItemList;
    }

    public void setInvoiceItemList(List<InvoiceItem> invoiceItemList) {
        this.invoiceItemList = invoiceItemList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvoiceViewModel)) return false;
        InvoiceViewModel that = (InvoiceViewModel) o;
        return getId().equals(that.getId()) &&
                getCustomerId().equals(that.getCustomerId()) &&
                getOrderDate().equals(that.getOrderDate()) &&
                getPickupDate().equals(that.getPickupDate()) &&
                getReturnDate().equals(that.getReturnDate()) &&
                getLateFee().equals(that.getLateFee()) &&
                getInvoiceItemList().equals(that.getInvoiceItemList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCustomerId(), getOrderDate(), getPickupDate(), getReturnDate(), getLateFee(), getInvoiceItemList());
    }
}

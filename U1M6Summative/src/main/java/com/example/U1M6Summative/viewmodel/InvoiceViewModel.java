package com.example.U1M6Summative.viewmodel;

import com.example.U1M6Summative.dto.InvoiceItem;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InvoiceViewModel {

    private Integer invoiceId;

    @NotNull(message = "customerId cannot be null")
    @NotBlank(message = "customerId cannot be blank")
    private Integer customerId;

    @NotNull (message = "orderDate cannot be null")
    @NotBlank(message = "orderDate cannot be blank")
    private LocalDate orderDate;

    @NotNull (message = "pickupDate cannot be null")
    @NotBlank(message = "pickupDate cannot be blank")
    private LocalDate pickupDate;

    @NotNull (message = "returnDate cannot be null")
    @NotBlank(message = "returnDate cannot be blank")
    private LocalDate returnDate;

    @NotNull (message = "lateFee cannot be null")
    @NotBlank(message = "lateFee cannot be blank")
    private BigDecimal lateFee;

    List<InvoiceItem> invoiceItems = new ArrayList<>();

    public InvoiceViewModel() {
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
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

    public List<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvoiceViewModel)) return false;
        InvoiceViewModel that = (InvoiceViewModel) o;
        return getInvoiceId().equals(that.getInvoiceId()) &&
                getCustomerId().equals(that.getCustomerId()) &&
                getOrderDate().equals(that.getOrderDate()) &&
                getPickupDate().equals(that.getPickupDate()) &&
                getReturnDate().equals(that.getReturnDate()) &&
                getLateFee().equals(that.getLateFee()) &&
                getInvoiceItems().equals(that.getInvoiceItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInvoiceId(), getCustomerId(), getOrderDate(), getPickupDate(), getReturnDate(), getLateFee(), getInvoiceItems());
    }
}

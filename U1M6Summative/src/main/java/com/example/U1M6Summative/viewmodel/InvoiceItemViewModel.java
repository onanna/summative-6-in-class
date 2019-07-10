package com.example.U1M6Summative.viewmodel;

import com.example.U1M6Summative.dto.Item;

import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceItemViewModel {

    private Integer invoiceItemId;
    private Integer invoiceId;
    private Item item;
    private Integer quantity;
    private BigDecimal unitRate;
    private BigDecimal discount;

    public InvoiceItemViewModel() {
    }

    public Integer getInvoiceItemId() {
        return invoiceItemId;
    }

    public void setInvoiceItemId(Integer invoiceItemId) {
        this.invoiceItemId = invoiceItemId;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitRate() {
        return unitRate;
    }

    public void setUnitRate(BigDecimal unitRate) {
        this.unitRate = unitRate;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceItemViewModel invoiceItemViewModel = (InvoiceItemViewModel) o;
        return getInvoiceItemId() == invoiceItemViewModel.getInvoiceItemId() &&
                Objects.equals(getInvoiceId(), invoiceItemViewModel.getInvoiceId()) &&
                Objects.equals(getItem(), invoiceItemViewModel.getItem()) &&
                Objects.equals(getQuantity(), invoiceItemViewModel.getQuantity()) &&
                Objects.equals(getUnitRate(), invoiceItemViewModel.getUnitRate()) &&
                Objects.equals(getDiscount(), invoiceItemViewModel.getDiscount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInvoiceItemId(),
                            getInvoiceId(),
                            getItem(),
                            getQuantity(),
                            getUnitRate(),
                            getDiscount());
    }
}

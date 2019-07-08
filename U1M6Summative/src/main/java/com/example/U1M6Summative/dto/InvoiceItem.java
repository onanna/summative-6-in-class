package com.example.U1M6Summative.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceItem {

    private Integer invoiceItemId;

    @NotNull(message = "invoiceId cannot be null")
    @NotBlank(message = "invoiceId cannot be blank")
    private Integer invoiceId;

    @NotNull(message = "itemId cannot be null")
    @NotBlank(message = "itemId cannot be blank")
    private Integer itemId;

    @NotNull(message = "quantity cannot be null")
    @NotBlank(message = "quantity cannot be blank")
    private Integer quantity;

    @NotNull(message = "unitRate cannot be null")
    @NotBlank(message = "unitRate cannot be blank")
    private BigDecimal unitRate;

    @NotNull(message = "discount cannot be null")
    @NotBlank(message = "discount cannot be blank")
    private BigDecimal discount;

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

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
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
        InvoiceItem invoiceItem = (InvoiceItem) o;
        return getInvoiceId() == invoiceItem.getInvoiceId() &&
                getInvoiceItemId() == invoiceItem.getInvoiceItemId() &&
                getItemId() == invoiceItem.getItemId() &&
                getQuantity() == invoiceItem.getQuantity() &&
                getUnitRate() == invoiceItem.getUnitRate() &&
                getDiscount() == invoiceItem.getDiscount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInvoiceId(), getInvoiceItemId(), getItemId(), getQuantity(), getUnitRate(), getDiscount());
    }
}

package com.example.U1M6Summative.viewmodel;

import com.example.U1M6Summative.dto.Item;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InvoiceItemViewModel {

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

    List<Item> items = new ArrayList<>();

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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvoiceItemViewModel)) return false;
        InvoiceItemViewModel that = (InvoiceItemViewModel) o;
        return getInvoiceItemId().equals(that.getInvoiceItemId()) &&
                getInvoiceId().equals(that.getInvoiceId()) &&
                getItemId().equals(that.getItemId()) &&
                getQuantity().equals(that.getQuantity()) &&
                getUnitRate().equals(that.getUnitRate()) &&
                getDiscount().equals(that.getDiscount()) &&
                getItems().equals(that.getItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInvoiceItemId(), getInvoiceId(), getItemId(), getQuantity(), getUnitRate(), getDiscount(), getItems());
    }
}

package com.example.U1M6Summative.dto;

import java.util.Objects;

public class InvoiceItem {
    private int invoiceId;
    private int invoiceItemId;
    private int itemId;
    private int quantity;
    private double unitRate;
    private double discount;

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getInvoiceItemId() {
        return invoiceItemId;
    }

    public void setInvoiceItemId(int invoiceItemId) {
        this.invoiceItemId = invoiceItemId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitRate() {
        return unitRate;
    }

    public void setUnitRate(double unitRate) {
        this.unitRate = unitRate;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
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
        return Objects.hash(getInvoiceId(), getInvoiceItemId(), getQuantity(), getUnitRate(), getDiscount());
    }
}

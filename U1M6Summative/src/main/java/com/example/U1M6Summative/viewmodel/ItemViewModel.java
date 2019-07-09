package com.example.U1M6Summative.viewmodel;

import com.example.U1M6Summative.dto.InvoiceItem;
import com.example.U1M6Summative.dto.Item;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemViewModel {

    private Integer itemId;
    private String name;
    private String description;
    private BigDecimal dailyRate;



    public ItemViewModel() {
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(BigDecimal dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemViewModel)) return false;
        ItemViewModel that = (ItemViewModel) o;
        return getItemId().equals(that.getItemId()) &&
                getName().equals(that.getName()) &&
                getDescription().equals(that.getDescription()) &&
                getDailyRate().equals(that.getDailyRate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemId(), getName(), getDescription(), getDailyRate());
    }
}

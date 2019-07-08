package com.example.U1M6Summative.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Item {

    private Integer itemId;
    private String name;
    private String description;
    private BigDecimal dailyRate;

    public Item() {
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
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return getItemId().equals(item.getItemId()) &&
                getName().equals(item.getName()) &&
                getDescription().equals(item.getDescription()) &&
                getDailyRate().equals(item.getDailyRate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemId(), getName(), getDescription(), getDailyRate());
    }
}
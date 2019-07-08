package com.example.U1M6Summative.dao;

import com.example.U1M6Summative.dto.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDaoJdbcTemplateImpl implements ItemDao{
    //jdbcTemplate and constructor

    // mapping function

    // prepared statements
    

    @Override
    public Item addItem(Item item) {
        return null;
    }

    @Override
    public Item getItem(int id) {
        return null;
    }

    @Override
    public List<Item> getAllItems() {
        return null;
    }

    @Override
    public void updateItem(Item item) {

    }

    @Override
    public void deleteItem(int id) {

    }
}

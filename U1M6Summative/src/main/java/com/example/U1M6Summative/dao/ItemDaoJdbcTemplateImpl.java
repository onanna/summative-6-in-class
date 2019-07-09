package com.example.U1M6Summative.dao;

import com.example.U1M6Summative.dto.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ItemDaoJdbcTemplateImpl implements ItemDao{

    //jdbcTemplate and constructor
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ItemDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // mapping function
    private Item mapToItem(ResultSet rs, int rowNum) throws SQLException {
        Item item = new Item();
        item.setItemId(rs.getInt("item_id"));
        item.setName(rs.getString("name"));
        item.setDescription(rs.getString("description"));
        item.setDailyRate(rs.getBigDecimal("daily_rate"));

        return item;
    }

    // prepared statements
    private static final String INSERT_ITEM_SQL =
            "insert into item (name, description, daily_rate) values (?, ?, ?)";

    private static final String SELECT_ITEM_SQL =
            "select * from item where item_id = ?";

    private static final String SELECT_ALL_ITEM_SQL =
            "select * from item";

    private static final String UPDATE_ITEM_SQL =
            "update item set name = ?, description = ?, daily_rate = ? where item_id = ?";

    private static final String DELETE_ITEM =
            "delete from item where item_id = ?";

    @Override
    @Transactional
    public Item addItem(Item item) {
        jdbcTemplate.update(INSERT_ITEM_SQL,
                item.getName(),
                item.getDescription(),
                item.getDailyRate());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        item.setItemId(id);
        return item;
    }

    @Override
    public Item getItem(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_ITEM_SQL, this::mapToItem, id);
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Item> getAllItems() {
        return jdbcTemplate.query(SELECT_ALL_ITEM_SQL, this::mapToItem);
    }

    @Override
    public void updateItem(Item item) {
        jdbcTemplate.update(UPDATE_ITEM_SQL,
                item.getName(),
                item.getDescription(),
                item.getDailyRate(),
                item.getItemId());
    }

    @Override
    public void deleteItem(int id) {
        jdbcTemplate.update(DELETE_ITEM, id);
    }
}

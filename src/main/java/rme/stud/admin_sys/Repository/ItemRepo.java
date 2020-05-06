/*
package com.example.demo.Repository;

import com.example.demo.Model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepo {

    @Autowired
    JdbcTemplate template;

    public List<Item> fetchAllItems(){

        String sql = "SELECT * FROM item";
        RowMapper<Item> rowMapper = new BeanPropertyRowMapper<>(Item.class);
            return template.query(sql, rowMapper);

    }

    public void addItem(Item i){
        String sql = "INSERT INTO item (id, name, price) VALUES (?,?,?)";
        template.update(sql, i.getId(), i.getName(), i.getPrice());

    }

    public void deleteItem(int id){
        String sql = "DELETE FROM item WHERE id=?";
        template.update(sql,id);

    }

    public Item findItemById(int id){
        String sql = "SELECT * FROM item WHERE id=?";
        RowMapper<Item> rowMapper = new BeanPropertyRowMapper<>(Item.class);
                return template.queryForObject(sql, rowMapper, id);

    }

    public void updateItem(Item i){
        String sql = "UPDATE item SET name=?, price=? WHERE id=?";
        template.update(sql, i.getName(),i.getPrice(),i.getId());
    }

}
*/
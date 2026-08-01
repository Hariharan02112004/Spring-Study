package com.SpringStudy2.Spring.AmazonInventory.Repository;

import com.SpringStudy2.Spring.AmazonInventory.Model.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepo {
    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }
    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Items item) {
        String insQuery = "insert into Items values(?,?,?,?)";
        int res = jdbc.update(insQuery,item.getItemNo(),item.getItemName(),item.getItemDescription(),item.getItemPrice());
        if(res>0){
            System.out.println("Item has been saved successfully");
        }else{
            System.out.println("Error in saving Item");
        }
    }

    public List<Items> findAll() {
        String selQuery = "select * from Items";
        RowMapper<Items> rowMapper = (rs,rowNum)->{
                Items it =new Items();
                it.setItemNo(rs.getInt("itemNo"));
                it.setItemName(rs.getString("itemName"));
                it.setItemDescription(rs.getString("itemDescription"));
                it.setItemPrice(rs.getDouble("itemPrice"));
                return it;
        };
        return jdbc.query(selQuery,rowMapper);
    }
}

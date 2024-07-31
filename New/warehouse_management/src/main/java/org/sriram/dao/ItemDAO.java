package org.sriram.dao;

import org.sriram.model.Item;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO {
    void addItem(Item item) throws SQLException;
    void updateItem(Item item) throws SQLException;
    void deleteItem(int id, String name) throws SQLException;
    List<Item> getItems() throws ClassNotFoundException;
}

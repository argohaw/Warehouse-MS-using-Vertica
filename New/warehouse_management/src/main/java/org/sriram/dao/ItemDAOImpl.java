package org.sriram.dao;

import org.sriram.model.Item;
import org.sriram.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {

    @Override
    public void addItem(Item item) throws SQLException
    {
        String query = "INSERT INTO items (id, name, type, quantity) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, item.getId());
            stmt.setString(2, item.getName());
            stmt.setString(3, item.getType());
            stmt.setInt(4, item.getQuantity());
            stmt.executeUpdate();
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateItem(Item item) throws SQLException
    {
        String query = "UPDATE items SET type = ?, quantity = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, item.getType());
            stmt.setInt(2, item.getQuantity());
            stmt.setInt(3, item.getId());
            stmt.executeUpdate();
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteItem(int id, String name) throws SQLException {
        String query = "DELETE FROM items WHERE id = ? OR name = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.executeUpdate();
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Item> getItems() throws ClassNotFoundException
    {
        List<Item> items = new ArrayList<>();
        Class.forName("com.vertica.jdbc.Driver");
        try (Connection connection = DBUtil.getConnection();
             Statement statement = connection.createStatement()) {
            String query = "SELECT id, name, type, quantity FROM items";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                int quantity = resultSet.getInt("quantity");
                items.add(new Item(id, name, type, quantity));
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return items;
    }
}

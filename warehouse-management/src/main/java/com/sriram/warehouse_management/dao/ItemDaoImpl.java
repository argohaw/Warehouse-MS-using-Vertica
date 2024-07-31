package com.sriram.warehouse_management.dao;

import com.sriram.warehouse_management.Model.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ItemDaoImpl implements ItemDao {

    private final String url;
    private final String username;
    private final String password;

    public ItemDaoImpl(@Value("${spring.datasource.url}") String url, @Value("${spring.datasource.username}") String username, @Value("${spring.datasource.password}")String password) {

         this.url = url;
        this.username = username;
        this.password = password;
        System.out.println("ItemDaoImpl Bean Created");
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public Optional<Item> findById(Long id) {
        String sql = "SELECT * FROM items WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately
        }
        return Optional.empty();
    }

    @Override
    public List<Item> findAll() {
        String sql = "SELECT * FROM items";
        List<Item> items = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                items.add(mapRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately
        }
        return items;
    }

    @Override
    public void save(Item item) {
        String sql = "INSERT INTO items (id, name, type, quantity) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, item.getId());
            statement.setString(2, item.getName());
            statement.setString(3, item.getType());
            statement.setInt(4, item.getQuantity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately
        }
    }

    @Override
    public void update(Item item) {
        String sql = "UPDATE items SET name = ?, type = ?, quantity = ? WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, item.getName());
            statement.setString(2, item.getType());
            statement.setInt(3, item.getQuantity());
            statement.setLong(4, item.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM items WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately
        }
    }

    @Override
    public Optional<Item> findByName(String name) {
        String sql = "SELECT * FROM items WHERE name = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately
        }
        return Optional.empty();
    }

    private Item mapRow(ResultSet rs) throws SQLException {
        return new Item(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("type"),
                rs.getInt("quantity")
        );
    }
}


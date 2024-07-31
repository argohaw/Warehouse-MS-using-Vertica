package org.sriram.servlet;

import org.sriram.dao.ItemDAO;
import org.sriram.dao.ItemDAOImpl;
import org.sriram.model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

//@WebServlet("/update-item")
public class UpdateItemServlet extends HttpServlet
{
    private ItemDAO itemDAO = new ItemDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int id = Integer.parseInt(req.getParameter("id"));
        String type = req.getParameter("type");
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        Item item = new Item();
        item.setId(id);
        item.setType(type);
        item.setQuantity(quantity);

        try {
            itemDAO.updateItem(item);
            req.setAttribute("message", "Item updated successfully!");
        } catch (SQLException e) {
            req.setAttribute("message", "Failed to update item.");
            e.printStackTrace();
        }

        req.getRequestDispatcher("/update-item.jsp").forward(req, resp);
    }
}

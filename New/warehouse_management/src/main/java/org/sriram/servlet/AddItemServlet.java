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

//@WebServlet("/add-item")
public class AddItemServlet extends HttpServlet
{
    private ItemDAO itemDAO = new ItemDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        Item item = new Item(id, name, type, quantity);

        try {
            itemDAO.addItem(item);
            req.setAttribute("message", "Item added successfully!");
        } catch (SQLException e) {
            req.setAttribute("message", "Failed to add item.");
            e.printStackTrace();
        }

        req.getRequestDispatcher("/add-item.jsp").forward(req, resp);
    }
}

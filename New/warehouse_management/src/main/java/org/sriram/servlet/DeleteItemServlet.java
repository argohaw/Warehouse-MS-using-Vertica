package org.sriram.servlet;

import org.sriram.dao.ItemDAO;
import org.sriram.dao.ItemDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

//@WebServlet("/delete-item")
public class DeleteItemServlet extends HttpServlet
{
    private ItemDAO itemDAO = new ItemDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");

        try {
            itemDAO.deleteItem(id, name);
            req.setAttribute("message", "Item deleted successfully!");
        } catch (SQLException e) {
            req.setAttribute("message", "Failed to delete item.");
            e.printStackTrace();
        }

        req.getRequestDispatcher("/delete-item.jsp").forward(req, resp);
    }
}

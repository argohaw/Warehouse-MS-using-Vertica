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
import java.util.List;

public class ItemsChartServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try {
            ItemDAO dao = new ItemDAOImpl();
            List<Item> items = dao.getItems();
            request.setAttribute("items", items);
            request.getRequestDispatcher("/WEB-INF/items-chart.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error retrieving data.");
        }
    }
}

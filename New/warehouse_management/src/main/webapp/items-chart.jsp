<%@ page import="java.util.List" %>
<%@ page import="org.sriram.dao.ItemDAO" %>
<%@ page import="org.sriram.model.Item" %>
<%@ page import="org.sriram.dao.ItemDAOImpl" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Items Bar Chart</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://unpkg.com/@mui/material@5.0.0-alpha.24/dist/material-ui.min.css">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            margin: 20px;
            padding: 0;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 800px;
            margin: auto;
            padding: 20px;
            background-color: white;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        h1 {
            color: #3f51b5;
            text-align: center;
        }
        .chart-container {
            width: 100%;
            height: 400px;
        }
        .mui-btn {
            text-transform: uppercase;
            font-weight: bold;
            padding: 10px 20px;
            border-radius: 4px;
            border: none;
            color: white;
            cursor: pointer;
            font-size: 14px;
        }
        .mui-btn-back {
            background-color: #3f51b5;
        }
        .mui-btn-back:hover {
            background-color: #3949ab;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Items Bar Chart</h1>
        <div class="chart-container">
            <canvas id="itemsChart"></canvas>
        </div>
        <a href="/warehouse_management-1.0-SNAPSHOT/homepage" class="mui-btn mui-btn-back">Back</a>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script>
        document.addEventListener('DOMContentLoaded', function () {
            var ctx = document.getElementById('itemsChart').getContext('2d');

            // Data fetched from the server
            var labels = [];
            var data = [];

            <%
                // Fetch data from DAO and prepare it for JavaScript
                ItemDAO dao = new ItemDAOImpl();
                List<Item> items = dao.getItems();
                for (Item item : items) {
                    out.print("labels.push('" + item.getName() + "');\n");
                    out.print("data.push(" + item.getQuantity() + ");\n");
                }
            %>

            var itemsChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: labels,
                    datasets: [{
                        label: 'Quantity',
                        data: data,
                        backgroundColor: '#3f51b5',
                        borderColor: '#303f9f',
                        borderWidth: 1
                    }]
                },
                options: {
                    responsive: true,
                    scales: {
                        x: {
                            beginAtZero: true
                        },
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });
        });
    </script>
</body>
</html>

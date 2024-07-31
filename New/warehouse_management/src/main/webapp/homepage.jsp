<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Warehouse Management - Homepage</title>
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
            max-width: 600px;
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
        .link-list {
            list-style: none;
            padding: 0;
            text-align: center;
        }
        .link-list li {
            margin: 10px 0;
        }
        .link-list a {
            text-decoration: none;
            color: #3f51b5;
            font-weight: bold;
            padding: 10px 20px;
            border: 1px solid #3f51b5;
            border-radius: 4px;
            transition: background-color 0.3s, color 0.3s;
        }
        .link-list a:hover {
            background-color: #3f51b5;
            color: white;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to the Warehouse Management System</h1>
        <ul class="link-list">
            <li><a href="add-item.jsp"><span class="material-icons">add</span> Add Item</a></li>
            <li><a href="update-item.jsp"><span class="material-icons">edit</span> Update Item</a></li>
            <li><a href="delete-item.jsp"><span class="material-icons">delete</span> Delete Item</a></li>
            <li><a href="items-chart.jsp">Items Chart</a></li>
        </ul>
    </div>
</body>
</html>

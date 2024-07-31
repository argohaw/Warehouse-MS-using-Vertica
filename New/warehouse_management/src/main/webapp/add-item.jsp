<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Item</title>
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
        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }
        label {
            font-size: 16px;
            margin-bottom: 5px;
        }
        input[type="text"],
        input[type="number"] {
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
            width: 100%;
            box-sizing: border-box;
        }
        .buttons {
            display: flex;
            justify-content: space-between;
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
        .mui-btn-submit {
            background-color: #4CAF50;
        }
        .mui-btn-submit:hover {
            background-color: #45a049;
        }
        .mui-btn-reset {
            background-color: #f44336;
        }
        .mui-btn-reset:hover {
            background-color: #e53935;
        }
        .mui-btn-back {
            background-color: #3f51b5;
        }
        .mui-btn-back:hover {
            background-color: #3949ab;
        }
        p.message {
            color: #4CAF50;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Add Item</h1>
        <form action="add-item" method="post">
            <label for="id">ID:</label>
            <input type="number" id="id" name="id" required/>

            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required/>

            <label for="type">Type:</label>
            <input type="text" id="type" name="type" required/>

            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" required/>

            <div class="buttons">
                <button type="submit" class="mui-btn mui-btn-submit">Submit</button>
                <button type="reset" class="mui-btn mui-btn-reset">Reset</button>
            </div>
        </form>

        <div class="buttons" style="margin-top: 20px;">
            <a href="/warehouse_management-1.0-SNAPSHOT/homepage" class="mui-btn mui-btn-back">Back</a>
        </div>

        <p class="message">${message}</p>
    </div>
</body>
</html>

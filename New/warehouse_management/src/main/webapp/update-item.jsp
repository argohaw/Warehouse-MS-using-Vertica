<!DOCTYPE html>
<html>
<head>
    <title>Update Item</title>
    <!-- MUI CSS -->
    <link href="https://cdn.muicss.com/mui-0.9.41/css/mui.min.css" rel="stylesheet" type="text/css" />
    <style>
        .container {
            max-width: 600px;
            margin-top: 50px;
        }
        .btn-back {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="mui-container container">
        <h1 class="mui--text-center">Update Item</h1>
        <form action="update-item" method="post" class="mui-form">
            <div class="mui-textfield">
                <label for="id">ID:</label>
                <input type="number" id="id" name="id" required/>
            </div>
            <div class="mui-textfield">
                <label for="type">Type:</label>
                <input type="text" id="type" name="type" required/>
            </div>
            <div class="mui-textfield">
                <label for="quantity">Quantity:</label>
                <input type="number" id="quantity" name="quantity" required/>
            </div>
            <div class="mui--text-center">
                <input type="submit" class="mui-btn mui-btn--primary" value="Submit"/>
                <input type="reset" class="mui-btn mui-btn--danger" value="Reset"/>
            </div>
        </form>
        <div class="mui--text-center btn-back">
            <a href="/warehouse_management-1.0-SNAPSHOT/homepage" class="mui-btn mui-btn--flat">Back</a>
        </div>
        <p class="mui--text-center mui--text-subhead mui--text-dark-secondary">${message}</p>
    </div>

    <!-- MUI JS (Optional) -->
    <script src="https://cdn.muicss.com/mui-0.9.41/js/mui.min.js"></script>
</body>
</html>

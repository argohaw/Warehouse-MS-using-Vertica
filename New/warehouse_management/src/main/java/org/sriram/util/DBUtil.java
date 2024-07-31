package org.sriram.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:vertica://localhost:5433/VMart";
    private static final String USER = "dbadmin";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException, ClassNotFoundException
    {
        Class.forName("com.vertica.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

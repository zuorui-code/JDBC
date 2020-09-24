package com.java.JDBC;

import java.sql.*;

/**
 * @author zuorui
 * @creat 2020-09-24-13:11
 */
public class DBUtils {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {

        Connection connection = null;

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_erp", "root", "000412");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return connection;
    }

    public static void closeAll(Connection connection, Statement statement, ResultSet rs) throws SQLException {

        if (rs != null) {
            rs.close();

        }
        if (statement != null) {
            statement.close();
        }

        if (connection != null) {
            connection.close();
        }

    }


}

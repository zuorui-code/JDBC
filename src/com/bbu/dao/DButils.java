package com.bbu.dao;

import jdk.internal.dynalink.beans.StaticClass;

import java.sql.*;

/**
 * @author zuorui
 * @creat 2020-09-24-14:52
 */
public class DButils {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {

        Connection connection;
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_erp");
        return connection;
    }

    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {

        if (resultSet != null) {
            resultSet.close();

        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }

    }
}

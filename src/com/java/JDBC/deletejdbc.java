package com.java.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author zuorui
 * @creat 2020-09-24-10:29
 */
public class deletejdbc {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_erp", "root", "000412");

        if (connection != null) {

            System.out.println("连接成功了");
        } else {

            System.out.println("连接失败");
        }

        Statement statement = connection.createStatement();
        String sql = "delete from employee where id = '1014'";
        int result = statement.executeUpdate(sql);

        if (result == 1) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }

        statement.close();
        connection.close();

    }
}

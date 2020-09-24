package com.java.JDBC;

import java.sql.*;
import java.util.Scanner;

/**
 * @author zuorui
 * @creat 2020-09-24-11:26
 */
public class LoginJdbc {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入账号");
        String id = scanner.next();

        System.out.println("请输入密码");
        String password = scanner.next();

        Class.forName("com.mysql.jdbc.Driver");


        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_erp", "root", "000412");

        Statement statement = connection.createStatement();

        String sql = String.format("select *from employee where id ='%s'and password = '%s'", id, password);
        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
        rs.close();
        statement.close();
        connection.close();

    }
}

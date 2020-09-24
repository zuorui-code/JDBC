package com.java.JDBC;

import java.sql.*;
import java.util.Scanner;

/**
 * @author zuorui
 * @creat 2020-09-24-12:03
 */
public class LoginPrepared {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入账号");
        String id = scanner.next();

        System.out.println("请输入密码");
        String password = scanner.next();

        Connection connection = DBUtils.getConnection();
        //获取preparedstatement对象，预编译sql语句
        PreparedStatement preparedStatement = connection.prepareStatement("select *from employee where id = ? and password = ?");

        //为占位符赋值
        preparedStatement.setString(1, id);
        preparedStatement.setString(2, password);

//        System.out.println(preparedStatement);
        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            System.out.println("登录成功");

        } else {
            System.out.println("登录失败");
        }

        DBUtils.closeAll(connection, preparedStatement, rs);

    }
}

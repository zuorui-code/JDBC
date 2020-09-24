package com.java.JDBC;

import java.sql.*;

/**
 * @author zuorui
 * @creat 2020-09-24-10:43
 */
public class QueryJdbc {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");//注册驱动

        String url = "jdbc:mysql://localhost:3306/employee_erp";
        String user = "root";
        String pass = "000412";

        Connection connection = DriverManager.getConnection(url, user, pass);//获得连接

        Statement statement = connection.createStatement();//获取执行sql语句的对象
        String sql = "select * from employee";

        ResultSet rs = statement.executeQuery(sql);//执行sql语句，接收结果


        //处理结果
        while (rs.next()) {//判断下一行是否有数据
            //根据列的编号进行数据的获取
            String id = rs.getString(1);
            String name = rs.getString(2);
            String gender = rs.getString(3);
            String password = rs.getString(4);
            String grade = rs.getString(5);
            System.out.println(id + " " + name + " " + gender + " " + password + " " + grade);
        }
        //释放资源
        rs.close();
        statement.close();
        connection.close();
    }
}

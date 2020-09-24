package com.java.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author zuorui
 * @creat 2020-09-24-9:23
 */
public class inserjdbc {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");//注册驱动

        String url = "jdbc:mysql://localhost:3306/employee_erp";//获得连接
        String user = "root";
        String password = "000412";
        Connection connection = DriverManager.getConnection(url, user, password);
        if (connection != null) {

            System.out.println("连接数据库了");

        } else {

            System.out.println("连接失败");
        }

        Statement statement = connection.createStatement();//获得执行sql语句的对象

        String sql = "insert into employee (id,name,gender,password,grade) values ('1014','zhangxidong','男','11521','100')";//编写sql语句


        int result = statement.executeUpdate(sql);//DML操作调用方法

        if (result == 1) {//返回处理结果
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }

        statement.close();//释放资源
        connection.close();

    }
}

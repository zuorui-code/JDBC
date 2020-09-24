package com.java.test;

import com.java.JDBC.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zuorui
 * @creat 2020-09-24-13:54
 */
public class TestORM {

    public static void main(String[] args) throws SQLException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        connection = DBUtils.getConnection();
        preparedStatement = connection.prepareStatement("select *from employee");

        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {

            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            String password = resultSet.getString("password");
            String grade = resultSet.getString("grade");

            Employee employee = new Employee(id, name, gender, password, grade);
            employee.setId(id);
            employee.setName(name);
            employee.setGender(gender);
            employee.setPassword(password);
            employee.setGrade(grade);

            List<Employee> lsit = new ArrayList<>();
            lsit.add(employee);
            lsit.forEach(x -> System.out.println(x));

        }

        DBUtils.closeAll(connection, preparedStatement, resultSet);


    }
}

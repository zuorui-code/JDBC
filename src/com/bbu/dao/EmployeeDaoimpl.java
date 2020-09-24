package com.bbu.dao;

import com.java.JDBC.DBUtils;
import sun.awt.SunHints;

import javax.xml.stream.events.DTD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zuorui
 * @creat 2020-09-24-15:05
 */
public class EmployeeDaoimpl {

    public int insert(Employee employee) throws SQLException {
        Connection connection;
        PreparedStatement preparedStatement;

        String sql = "insert into employee(id,name,gender,password,grade) values(?,?,?,?,?)";

        connection = DBUtils.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getId());
        preparedStatement.setString(2, employee.getName());
        preparedStatement.setString(3, employee.getGender());
        preparedStatement.setString(4, employee.getPassword());
        preparedStatement.setString(5, employee.getGrade());
        int result = preparedStatement.executeUpdate();

        return result;


    }

    public int update(Employee employee) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement;
        String sql = "update employee set name = ?,gender = ?,password = ? grade = ? where id = ?";
        connection = DBUtils.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getGender());
        preparedStatement.setString(3, employee.getPassword());
        preparedStatement.setString(4, employee.getGrade());
        preparedStatement.setString(5, employee.getId());

        int result = preparedStatement.executeUpdate();

        return result;


    }

    public int delete(int id) throws SQLException {

        Connection connection;
        PreparedStatement preparedStatement = null;
        String sql = "delete from employee where id = ?";
        connection = DBUtils.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, String.valueOf(id));
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public Employee select(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from employee where id = ?";
        connection = DBUtils.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, String.valueOf(id));

        resultSet = preparedStatement.executeQuery();
        Employee employee = null;
        if (resultSet.next()) {

            employee = new Employee();
            String pid = resultSet.getString("id");
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            String password = resultSet.getString("password");
            String grade = resultSet.getString("grade");

            employee.setId(pid);
            employee.setName(name);
            employee.setGender(gender);
            employee.setPassword(password);
            employee.setGrade(grade);


        }


        return employee;
    }

    public List<Employee> selectAll() throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Employee employee = null;
        List<Employee> alist = new ArrayList<>();
        String sql = "select * from  employee";
        connection = DBUtils.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            
            String pid = resultSet.getString("id");
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            String password = resultSet.getString("password");
            String grade = resultSet.getString("grade");

            /*employee.setId(pid);
            employee.setName(name);
            employee.setGrade(gender);
            employee.setPassword(password);
            employee.setGrade(grade);*/
            employee = new Employee(pid, name, gender, password, grade);


            alist.add(employee);
        }

        return alist;
    }
}

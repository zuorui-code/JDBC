package com.java.JDBC;

import com.bbu.dao.Employee;
import com.bbu.dao.EmployeeDaoimpl;

import java.sql.SQLException;
import java.util.List;

/**
 * @author zuorui
 * @creat 2020-09-24-17:05
 */
public class TsetSelectAll {


    public static void main(String[] args) throws SQLException {
        EmployeeDaoimpl employeeDaoimpl = new EmployeeDaoimpl();
        List<Employee> alist = employeeDaoimpl.selectAll();

        alist.forEach(x-> System.out.println(x));
    }

}

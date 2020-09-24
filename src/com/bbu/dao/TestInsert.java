package com.bbu.dao;

import java.sql.SQLException;

/**
 * @author zuorui
 * @creat 2020-09-24-15:33
 */
public class TestInsert {

    public static void main(String[] args) throws SQLException {
        EmployeeDaoimpl employeeDao = new EmployeeDaoimpl();
        Employee employee = new Employee( "1012","清华", "男", "12345", "62");
        int result = employeeDao.insert(employee);

        if (result == 1) {
            System.out.println("新增成功");
        } else {
            System.out.println("新增失败");
        }
    }
}

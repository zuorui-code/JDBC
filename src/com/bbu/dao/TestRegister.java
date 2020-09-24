package com.bbu.dao;

import java.sql.SQLException;

/**
 * @author zuorui
 * @creat 2020-09-24-18:46
 */
public class TestRegister {
    public static void main(String[] args) throws SQLException {

        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        Employee employee = new Employee("1017","zuoxingyu","women","458963","48");
        employeeService.register(employee);

    }





}

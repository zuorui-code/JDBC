package com.bbu.dao;

import javax.sound.midi.Soundbank;
import java.sql.SQLException;

/**
 * @author zuorui
 * @creat 2020-09-24-18:33
 */

public class EmployeeServiceImpl {

    //注册
    public void register(Employee employee) throws SQLException {

        EmployeeDaoimpl employeeDao = new EmployeeDaoimpl();
        Employee employee1 = employeeDao.select(employee.getId());

        if (employee1 == null) {
            employeeDao.insert(employee);
            System.out.println("注册成功");
        } else {
            System.out.println("用户已存在");
        }
    }
}


package com.bbu.dao;

import java.sql.SQLException;

/**
 * @author zuorui
 * @creat 2020-09-24-15:58
 */
public class TestUpdate {

    public static void main(String[] args) throws SQLException {

        EmployeeDaoimpl employeeDao = new EmployeeDaoimpl();
        Employee employee = new Employee("1001","李虎","null","14525","42");
        int result =  employeeDao.update(employee);
        if(result == 1){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }

    }
}

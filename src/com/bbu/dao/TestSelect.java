package com.bbu.dao;

import java.sql.SQLException;
import java.sql.SQLOutput;

/**
 * @author zuorui
 * @creat 2020-09-24-16:41
 */
public class TestSelect {
    public static void main(String[] args) throws SQLException {


        EmployeeDaoimpl employeeDaoimpl = new EmployeeDaoimpl();
        Employee employee = employeeDaoimpl.select(1004);
        if(employee!=null){
            System.out.println(employee);
        }else{

            System.out.println("没有找到该用户");
        }


    }
}

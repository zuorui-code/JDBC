package com.bbu.dao;

import java.sql.SQLException;

/**
 * @author zuorui
 * @creat 2020-09-24-16:14
 */
public class TestDelete {

    public static void main(String[] args) throws SQLException {

        EmployeeDaoimpl employeeDaoimpl = new EmployeeDaoimpl();
        int result = employeeDaoimpl.delete(1012);

        if (result == 1) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }

    }


}

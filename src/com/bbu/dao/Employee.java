package com.bbu.dao;

/**
 * @author zuorui
 * @creat 2020-09-24-15:02
 */
public class Employee {

    private String id;
    private String name;
    private String gender;
    private String password;
    private String grade;

    public Employee(String id, String name, String gender, String password, String grade) {

        this.id = id;
        this.name = name;
        this.gender = gender;
        this.password = password;
        this.grade = grade;
    }

    public Employee() {

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}

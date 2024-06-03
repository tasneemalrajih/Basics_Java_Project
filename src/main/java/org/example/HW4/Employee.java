package org.example.HW4;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Employee class representing the structure of an employee
class Employee {
    private int employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private String hire_date;
    private double salary;
    private int job_id;
    private int manager_id;
    private int department_id;

    public Employee(int employee_id, String first_name, String last_name, String email, String phone_number, String hire_date, double salary, int job_id, int manager_id, int department_id) {

        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.hire_date = hire_date;
        this.salary = salary;
        this.job_id = job_id;
        this.manager_id = manager_id;
        this.department_id = department_id;
    }

    public Employee(ResultSet rs) {
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getHire_date() {
        return hire_date;
    }

    public double getSalary() {
        return salary;
    }

    public int getJob_id() {
        return job_id;
    }

    public int getManager_id() {
        return manager_id;
    }

    public int getDepartment_id() {
        return department_id;
    }
}

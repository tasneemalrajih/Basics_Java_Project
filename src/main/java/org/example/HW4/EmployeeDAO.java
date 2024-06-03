package org.example.HW4;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

 private static final String URL = "jdbc:sqlite:C:\\Users\\dev\\Desktop\\SDAIA-Java-Course\\JavaBasics\\HomeWork\\hr.db";
private static final String SELECT_ALL_EMP = "select * from employees";
private static final String SELECT_ONE_EMP = "select * from employees where employee_id = ?";
private static final String INSERT_EMP = "insert into employees values (? ,? ,? ,? ,? ,? ,? ,? ,? ,?)";
private static final String UPDATE_EMP = "update employees set employee_id = ?, first_name = ?, last_name=?, email=? , phone_number=? , hire_date=?, salary=?, job_id=?, manager_id=?, department_id=?";
private static final String DELETE_EMP = "delete from employees where employee_id = ?";

    public void insertEMP(Employee EMP) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(INSERT_EMP);
        st.setInt(1, EMP.getEmployee_id());
        st.setString(2, EMP.getFirst_name());
        st.setString(3, EMP.getLast_name());
        st.setString(4, EMP.getEmail());
        st.setString(5, EMP.getPhone_number());
        st.setString(6, EMP.getHire_date());
        st.setDouble(7, EMP.getSalary());
        st.setInt(8, EMP.getJob_id());
        st.setInt(9, EMP.getManager_id());
        st.setInt(10, EMP.getDepartment_id());
        st.executeUpdate();
    }


    public void updateEMP(Employee employee) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(UPDATE_EMP);
            st.setString(1, employee.getFirst_name());
            st.setString(2, employee.getLast_name());
            st.setString(3, employee.getEmail());
            st.setString(4, employee.getPhone_number());
            st.setString(5, employee.getHire_date());
            st.setDouble(6, employee.getSalary());
            st.setInt(7, employee.getJob_id());
            st.setInt(8, employee.getManager_id());
            st.setInt(9, employee.getDepartment_id());
            st.setInt(10, employee.getEmployee_id());
            st.executeUpdate();
    }

    public void deleteEMP(int employee_id) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(DELETE_EMP);
        st.setInt(1, employee_id);
        st.executeUpdate();
    }
    public Employee selectDept(int employee_id) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(SELECT_ONE_EMP);
        st.setInt(1, employee_id);
        ResultSet rs = st.executeQuery();
        if(rs.next()) {
            return new Employee(rs);
        }
        else {
            return null;
        }
    }

    public ArrayList<Employee> selectAllEMP() throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(SELECT_ALL_EMP);
        ResultSet rs = st.executeQuery();
        ArrayList<Employee> EMP = new ArrayList<>();
        while (rs.next()) {
            EMP.add(new Employee(rs));
        }

        return EMP;
    }

}

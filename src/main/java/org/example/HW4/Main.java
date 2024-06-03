package org.example.HW4;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String url = "jdbc:sqlite:C:\\Users\\dev\\Desktop\\SDAIA-Java-Course\\JavaBasics\\HomeWork\\hr.db";
        String query = "insert into employees values (? ,? ,? ,? ,? ,? ,? ,? ,? ,?)";


        try (Connection conn = DriverManager.getConnection(url)) {
            conn.setAutoCommit(false);
            PreparedStatement st = conn.prepareStatement(query);

            while (true) {

                System.out.println("Enter Employee ID: ");
                int empId = sc.nextInt();
                st.setInt(1, empId);
                sc.nextLine();

                System.out.println("Enter First Name: ");
                String EMPFName = sc.nextLine();
                st.setString(2, EMPFName);

                System.out.println("Enter Last Name: ");
                String EMPLName = sc.nextLine();
                st.setString(3, EMPLName);

                System.out.println("Enter Email: ");
                String EMPemail = sc.nextLine();
                st.setString(4, EMPemail);

                System.out.println("Enter Phone Number: ");
                String EMPphome = sc.nextLine();
                st.setString(5, EMPphome);

                System.out.println("Enter Hire Date: ");
                String EMPdate = sc.nextLine();
                st.setString(6, EMPdate);

                System.out.println("Enter Salary: ");
                double EMPsalary = sc.nextDouble();
                st.setDouble(7, EMPsalary);

                System.out.println("Enter Job ID: ");
                int JOBId = sc.nextInt();
                st.setInt(8, JOBId);
                sc.nextLine();

                System.out.println("Enter Manager ID: ");
                int MANId = sc.nextInt();
                st.setInt(9, MANId);
                sc.nextLine();

                System.out.println("Enter Department ID: ");
                int DEPId = sc.nextInt();
                st.setInt(10, DEPId);
                sc.nextLine();

                st.addBatch();

                sc.nextLine();
                System.out.println("Do you want to save: ");
                String toSave = sc.nextLine();
                if (toSave.equals("yes")) {
                    int[] rows = st.executeBatch();
                    for (int r : rows) {
                        System.out.println(r + " inserted");
                    }
                    conn.commit();
                    System.out.println("Data saved");
                    break;
                } else if (toSave.equals("no")) {
                    conn.rollback();
                    System.out.println("Save cancelled");
                    break;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

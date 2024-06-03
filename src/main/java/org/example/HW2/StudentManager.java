package org.example.HW2;
import java.util.ArrayList;
public class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null; // Return null if student not found
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }

    public boolean removeStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                return true; // Return true if removal successful
            }
        }
        return false; // Return false if student not found
    }
}

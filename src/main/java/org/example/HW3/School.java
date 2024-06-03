package org.example.HW3;
import java.util.*;
import java.io.*;

public class School {
    private List<Student> students;

    public School(List<Student> students) {
        this.students = students;
    }

    public School() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void remove(int studentId) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getStudentId() == studentId) {
                iterator.remove();
                System.out.println("Student with ID " + studentId + " removed.");
                return;
            }
        }
        System.out.println("Student with ID " + studentId + " not found.");
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the school.");
            return;
        }
        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }

    public void sortStudentsByName() {
        Collections.sort(students, Comparator.comparing(Student::getName));
    }

    public void writeStudentsToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
            for (Student student : students) {
                writer.println(student.getName() + "," + student.getAge() + "," + student.getAddress() + "," + student.getStudentId() + "," + student.getCourse());
            }
            System.out.println("Student details written to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void readStudentsFromFile(String filename) {
        students.clear(); // Clear existing students before reading from file
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 5) { // Assuming each line contains 5 fields
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    String address = parts[2];
                    int studentId = Integer.parseInt(parts[3]);
                    String course = parts[4];
                    students.add(new Student(name, age, address, studentId, course));
                } else {
                    System.out.println("Invalid format in file: " + line);
                }
            }
            System.out.println("Student details read from " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
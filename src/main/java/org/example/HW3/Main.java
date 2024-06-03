package org.example.HW3;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Tasneem Alrajih", 25, "Saudi Arabia-Riyadh");
        Person p2 = new Person("Hessah Alrajih", 29, "Saudi Arabia-Riyadh");
        System.out.print(p1.getName()+", ");
        System.out.print(p1.getAge()+" , ");
        System.out.println(p1.getAddress()+"  ");
        System.out.print(p2.getName()+", ");
        System.out.print(p2.getAge()+", ");
        System.out.println(p2.getAddress()+" ");
        System.out.println("--------------------");
        System.out.println("--------------------");
        Student s1 = new Student("Tasneem Alrajih", 25, "Saudi Arabia-Riyadh", 1010, "Computer Science");
       System.out.println(s1.getDetails());
        System.out.println("--------------------");
//         ComparableById
        int Id = 100;
        if (s1.compareById(Id)) {
            System.out.println("Student ID is Equal" );
        } else {
            System.out.println("Student ID Not Equal");
        }
        System.out.println("--------------------");
//         Validation Person Age
        p1.setAge(170);
        System.out.println(p1.getAge());
        System.out.println("--------------------");
//         Validation Student ID
        s1.setStudentId(-12);
        System.out.println(s1.getStudentId());
        System.out.println("--------------------");


        School school = new School();

        // Adding students
        school.addStudent(new Student("Tasneem", 25, "Saudi Arabia-Riyadh", 1010, "Computer Science"));
        school.addStudent(new Student("Hessah", 29, "Saudi Arabia-Riyadh", 1011, "Mathematics"));


        // Displaying all students
        school.displayAllStudents();
        System.out.println("--------------------");
        // Removing a student by ID
        school.remove(1010);
        System.out.println("--------------------");

        // Displaying all students after removal
        school.displayAllStudents();
        System.out.println("--------------------");

        // Writing students to file
        school.writeStudentsToFile("students.txt");
        // Reading students from file
        System.out.println(".............................");

        school.readStudentsFromFile("students.txt");

        System.out.println("--------------------");

        // Displaying all students
        school.displayAllStudents();


    }
}
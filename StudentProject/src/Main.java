//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        StudentManager manager = new StudentManager();


        Student student1 = new Student("Tasneem", 1);
        Student student2 = new Student("Hessah", 2);
        Student student3 = new Student("Shima", 3);


        manager.addStudent(student1);
        manager.addStudent(student2);
        manager.addStudent(student3);


        int searchId = 2;
        Student foundStudent = manager.getStudentById(searchId);
        if (foundStudent != null) {
            System.out.println("Student found with ID " + searchId + ": " + foundStudent.getName());
        } else {
            System.out.println("No student found with ID " + searchId);
        }


        System.out.println("All students:");
        for (Student student : manager.getAllStudents()) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName());
        }

        int removeId = 1;
        boolean removed = manager.removeStudentById(removeId);
        if (removed) {
            System.out.println("Student with ID " + removeId + " removed successfully.");
        } else {
            System.out.println("No student found with ID " + removeId + ". Removal unsuccessful.");
        }

        // Display all students in the list again
        System.out.println("All students after removal:");
        for (Student student : manager.getAllStudents()) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName());
        }
    }
}
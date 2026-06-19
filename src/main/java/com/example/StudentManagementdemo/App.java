package com.example.StudentManagementdemo;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {

            System.out.println("\n===== STUDENT MENU =====");
            System.out.println("1. Insert Student");
            System.out.println("2. Read All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter student id: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter age: ");
                    int age = sc.nextInt();

                    Student student = new Student(id, name, email, course, age);

                    dao.saveStudent(student);

                    System.out.println("Student inserted successfully!");
                    break;

                case 2:

                    List<Student> students = dao.getAllStudents();

                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (Student s : students) {
                            System.out.println(s);
                        }
                    }

                    break;

                case 3:

                    System.out.print("Enter student id to update: ");
                    int updateId = sc.nextInt();

                    Student existing = dao.getStudent(updateId);

                    if (existing == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    sc.nextLine();

                    System.out.print("Enter new name: ");
                    existing.setStudentName(sc.nextLine());

                    System.out.print("Enter new email: ");
                    existing.setEmail(sc.nextLine());

                    System.out.print("Enter new course: ");
                    existing.setCourse(sc.nextLine());

                    System.out.print("Enter new age: ");
                    existing.setAge(sc.nextInt());

                    dao.updateStudent(existing);

                    System.out.println("Student updated successfully!");
                    break;

                case 4:

                    System.out.print("Enter student id to delete: ");
                    int deleteId = sc.nextInt();

                    dao.deleteStudent(deleteId);

                    System.out.println("Student deleted (if it existed).");
                    break;

                case 5:

                    System.out.println("Exiting...");

                    sc.close();
                    Utility.getSessionFactory().close();

                    System.exit(0);
                    break;

                default:

                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}		
package com.example.Employeedemo;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while (true) {

            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee By ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    int salary = sc.nextInt();

                    System.out.print("Enter Joining Date (yyyy-MM-dd): ");
                    LocalDate joiningDate =
                            LocalDate.parse(sc.next());

                    Employee employee = new Employee(
                            id,
                            name,
                            department,
                            salary,
                            joiningDate
                    );

                    dao.saveEmployee(employee);

                    System.out.println(
                            "Employee Added Successfully!");
                    break;

                case 2:

                    List<Employee> employees =
                            dao.getAllEmployees();

                    if (employees.isEmpty()) {
                        System.out.println("No employees found.");
                    } else {
                        employees.forEach(System.out::println);
                    }

                    break;

                case 3:

                    System.out.print("Enter Employee ID: ");
                    int searchId = sc.nextInt();

                    Employee e =
                            dao.getEmployeeById(searchId);

                    if (e != null) {
                        System.out.println(e);
                    } else {
                        System.out.println(
                                "Employee Not Found!");
                    }

                    break;

                case 4:

                    System.out.print(
                            "Enter Employee ID to Update: ");

                    int updateId = sc.nextInt();
                    sc.nextLine();

                    Employee emp =
                            dao.getEmployeeById(updateId);

                    if (emp != null) {

                        System.out.print(
                                "Enter New Name: ");

                        emp.setEmployeeName(
                                sc.nextLine());

                        System.out.print(
                                "Enter New Department: ");

                        emp.setDepartment(
                                sc.nextLine());

                        System.out.print(
                                "Enter New Salary: ");

                        emp.setSalary(sc.nextInt());

                        sc.nextLine();

                        System.out.print(
                                "Enter New Joining Date (yyyy-MM-dd): ");

                        emp.setJoiningDate(
                                LocalDate.parse(
                                        sc.nextLine()));

                        dao.updateEmployee(emp);

                        System.out.println(
                                "Employee Updated Successfully!");
                    } else {
                        System.out.println(
                                "Employee Not Found!");
                    }

                    break;

                case 5:

                    System.out.print(
                            "Enter Employee ID to Delete: ");

                    int deleteId = sc.nextInt();

                    dao.deleteEmployee(deleteId);

                    System.out.println(
                            "Employee Deleted Successfully!");

                    break;

                case 6:

                    System.out.println("Exiting...");

                    sc.close();
                    Utility.getSessionFactory().close();

                    System.exit(0);
                    break;

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}
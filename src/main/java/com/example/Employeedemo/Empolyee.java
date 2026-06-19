package com.example.Employeedemo;

import java.time.LocalDate;


@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    private int employeeId;

    private String employeeName;
    private String department;
    private int salary;
    private LocalDate joiningDate;

    public Employee() {
    }

    public Employee(int employeeId, String employeeName,
                    String department, int salary,
                    LocalDate joiningDate) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }
}
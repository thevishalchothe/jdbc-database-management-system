package com.sms.jdbc.statementInterface.ui;

import java.util.Scanner;

import com.sms.jdbc.statementInterface.serviceI.StudentServiceI;
import com.sms.jdbc.statementInterface.serviceImpl.StudentServiceImpl;

public class MainApplication {

    private final StudentServiceI studentServiceI;

    // Constructor Injection
    public MainApplication(StudentServiceI studentServiceI) {
        this.studentServiceI = studentServiceI; // Dependency injected through constructor
    }

    public static void main(String[] args) {
        // Initialize necessary services and DAOs
        StudentServiceI studentServiceI = new StudentServiceImpl(new com.sms.jdbc.statementInterface.daoImpl.StudentDaoImpl());

        System.out.println("Student Management System using JDBC CRUD With Statement Interface");

        while (true) {
        	Scanner scanner=new Scanner(System.in);
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Get Student by ID");
            System.out.println("3. Get Student by RollNo");
            System.out.println("4. Get All Students");
            System.out.println("5. Update Student");
            System.out.println("6. Delete Student by ID");
            System.out.println("7. Delete Student by RollNo");
            System.out.println("8. Delete All Students");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt(); 

            switch (choice) {
                case 1:
                    studentServiceI.addStudent(); 
                    break;

                case 2:
                    studentServiceI.getStudentById(); 
                    break;

                case 3:
                    studentServiceI.getStudentByRollNo(); 
                    break;

                case 4:
                    studentServiceI.getAllStudents(); 
                    break;

                case 5:
                    studentServiceI.updateStudent();
                    break;

                case 6:
                    studentServiceI.deleteStudentById(); 
                    break;

                case 7:
                    studentServiceI.deleteStudentByRollNo(); 
                    break;

                case 8:
                    studentServiceI.deleteAllStudents(); 
                    break;

                case 9:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

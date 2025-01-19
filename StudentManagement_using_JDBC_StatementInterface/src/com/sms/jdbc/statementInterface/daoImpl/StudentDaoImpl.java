package com.sms.jdbc.statementInterface.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sms.jdbc.statementInterface.daoI.StudentDaoI;
import com.sms.jdbc.statementInterface.model.Student;
import com.sms.jdbc.statementInterface.util.DatabaseConnection;

public class StudentDaoImpl implements StudentDaoI {

    @Override
    public void addStudent(Student student) {
        String query = "INSERT INTO students (roll_no, name, email, course) VALUES ('" + student.getRollNo() + "', '"
                + student.getName() + "', '" + student.getEmail() + "', '" + student.getCourse() + "')";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(query);
            System.out.println("\nStudent added successfully! -> RollNo: " + student.getRollNo() + " , Name: "
                    + student.getName() + " , Email: " + student.getEmail() + ", Course: " + student.getCourse());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student getStudentById(int id) {
        String query = "SELECT * FROM students WHERE id = " + id;
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setRollNo(resultSet.getString("roll_no")); 
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setCourse(resultSet.getString("course"));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Student getStudentByRollNo(String rollNo) {
        String query = "SELECT * FROM students WHERE roll_no = '" + rollNo + "'";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                Student student = new Student();
                student.setRollNo(resultSet.getString("roll_no"));
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setCourse(resultSet.getString("course"));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setRollNo(resultSet.getString("roll_no")); 
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setCourse(resultSet.getString("course"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void updateStudent(Student student) {
        String query = "UPDATE students SET name = '" + student.getName() + "', email = '" + student.getEmail()
                + "', course = '" + student.getCourse() + "' WHERE id = " + student.getId();

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            
            System.out.println("\nStudent updated successfully! ID: " + student.getId() + ", Roll No: " + student.getRollNo()
                    + ", Name: " + student.getName() + ", Email: " + student.getEmail() + ", Course: " + student.getCourse());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deleteStudentById(int id) {
        String query = "DELETE FROM students WHERE id = " + id;
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            System.out.println("Student deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudentByRollNo(String rollNo) {
        String query = "DELETE FROM students WHERE roll_no = '" + rollNo + "'";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            System.out.println("Student deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAllStudents() {
        String query = "DELETE FROM students";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            System.out.println("All students deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

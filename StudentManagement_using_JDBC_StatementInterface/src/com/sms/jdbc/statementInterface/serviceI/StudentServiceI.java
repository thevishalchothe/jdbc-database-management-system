package com.sms.jdbc.statementInterface.serviceI;

import java.util.List;

import com.sms.jdbc.statementInterface.model.Student;

public interface StudentServiceI {

	void addStudent();

	Student getStudentById();

	Student getStudentByRollNo();

	List<Student> getAllStudents();

	void updateStudent();

	void deleteStudentById();

	void deleteStudentByRollNo();

	void deleteAllStudents();
}

package com.sms.jdbc.statementInterface.daoI;

import java.util.List;

import com.sms.jdbc.statementInterface.model.Student;

public interface StudentDaoI {

	void addStudent(Student student);

	Student getStudentById(int id);

	Student getStudentByRollNo(String searchRollNo);

	List<Student> getAllStudents();

	void updateStudent(Student student);

	void deleteStudentById(int id);

	void deleteStudentByRollNo(String rollNo);

	void deleteAllStudents();



}

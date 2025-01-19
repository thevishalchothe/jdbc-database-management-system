package com.sms.jdbc.statementInterface.serviceImpl;

import java.util.List;
import java.util.Scanner;

import com.sms.jdbc.statementInterface.daoI.StudentDaoI;
import com.sms.jdbc.statementInterface.model.Student;
import com.sms.jdbc.statementInterface.serviceI.StudentServiceI;

public class StudentServiceImpl implements StudentServiceI {

	private final StudentDaoI studentDaoI;

	// Constructor injection (Preferred approach for loose coupling)
	public StudentServiceImpl(StudentDaoI studentDaoI) {
		this.studentDaoI = studentDaoI;
	}

	Scanner scanner = new Scanner(System.in);

	@Override
	public void addStudent() {
		System.out.print("Enter roll number: ");
		String rollNo = scanner.next();
		System.out.print("Enter name: ");
		String name = scanner.next();
		System.out.print("Enter email: ");
		String email = scanner.next();
		System.out.print("Enter course: ");
		String course = scanner.next();

		Student student = new Student();
		student.setRollNo(rollNo);
		student.setName(name);
		student.setEmail(email);
		student.setCourse(course);

		studentDaoI.addStudent(student);
	}

	@Override
	public Student getStudentById() {
		System.out.print("Enter student ID: ");
		int id = scanner.nextInt();
		return studentDaoI.getStudentById(id);
	}

	@Override
	public Student getStudentByRollNo() {
		System.out.print("Enter roll number: ");
		String rollNo = scanner.next();
		return studentDaoI.getStudentByRollNo(rollNo);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentDaoI.getAllStudents();
	}

	@Override
	public void updateStudent() {
		System.out.print("Enter student ID to update: ");
		int updateId = scanner.nextInt();
		System.out.print("Enter new roll number: ");
		String newRollNo = scanner.next();
		System.out.print("Enter new name: ");
		String newName = scanner.next();
		System.out.print("Enter new email: ");
		String newEmail = scanner.next();
		System.out.print("Enter new course: ");
		String newCourse = scanner.next();

		Student updateStudent = new Student();
		updateStudent.setId(updateId);
		updateStudent.setRollNo(newRollNo);
		updateStudent.setName(newName);
		updateStudent.setEmail(newEmail);
		updateStudent.setCourse(newCourse);

		studentDaoI.updateStudent(updateStudent);
	}

	@Override
	public void deleteStudentById() {
		System.out.print("Enter student ID to delete: ");
		int deleteId = scanner.nextInt();
		studentDaoI.deleteStudentById(deleteId);
	}

	@Override
	public void deleteStudentByRollNo() {
		System.out.print("Enter roll number to delete: ");
		String deleteRollNo = scanner.next();
		studentDaoI.deleteStudentByRollNo(deleteRollNo);
	}

	@Override
	public void deleteAllStudents() {
		studentDaoI.deleteAllStudents();
	}
}

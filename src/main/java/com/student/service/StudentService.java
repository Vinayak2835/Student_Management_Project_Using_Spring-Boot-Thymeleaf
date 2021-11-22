package com.student.service;

import java.util.List;

import com.student.entity.Student;

public interface StudentService {
	List<Student> getAllStudents();
	
	Student save(Student student);
	
	Student getStudentById(int id);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(int id);
}

package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	@Override
	public List<Student> getAllStudents() {
		
		List<Student> studentList = studentRepository.findAll();
		
		return studentList;
	}  
	
	@Override
	public Student save(Student student) {
		
		return  studentRepository.save(student);
		
	}

	@Override
	public Student getStudentById(int id) {
		Student getStudent = studentRepository.getById(id);
		return getStudent;
	}

	@Override
	public Student updateStudent(Student student) {
		
		Student updateStudent = studentRepository.save(student);
		
		return updateStudent;
	}

	@Override
	public void deleteStudentById(int id) {
		
		studentRepository.deleteById(id);
		
	}

}

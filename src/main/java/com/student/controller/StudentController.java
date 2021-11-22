package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.student.entity.Student;
import com.student.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/getAllStudents", method=RequestMethod.GET)
	public String getAllStudents(Model model) {
		
		List<Student> studentList = studentService.getAllStudents();
		
		   studentList.forEach(students->{
			 //  System.out.println(students);
		   });
		
		model.addAttribute("studentlist", studentList);
		
		return "student-list";
	}
	
	//To Add a new Student to the table
	
	@GetMapping("/addStudent")
	public String AddStudent(Model model ) {
		
		//Create an empty student object
		Student student = new Student();
		
		model.addAttribute("student", student);
		
		return "add-student";
	}
	
	//To save a student into the table
	
	@PostMapping("/proceed")
	public String saveStudent(@ModelAttribute("student") Student student) {
		
		Student addStudent = studentService.save(student);
		
		System.out.println(addStudent);
		
		return "redirect:/getAllStudents";
	}
	
	@GetMapping("/Update/{id}")
	public String UpStudent(@PathVariable("id") int id, Model model) {
	   
		Student getStudentById = studentService.getStudentById(id);
		
		model.addAttribute("student", getStudentById);
		
		return "edit-student";
	}
	
	@PostMapping("/edit/{id}")
	public String deleStudent(@PathVariable("id") int id,@ModelAttribute("student") Student student,  Model model) {
		
		Student getStudent = studentService.updateStudent(student);
		
			getStudent.setId(id);
			getStudent.setFirstName(student.getFirstName());
			getStudent.setLastName(student.getLastName());
			getStudent.setEmail(student.getEmail());
		
		return "redirect:/getAllStudents";
	}
	
	//Handler method to delete a student from the table
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		
		studentService.deleteStudentById(id);
		
		return "redirect:/getAllStudents";
	}
}

package com.example.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.model.Students;
import com.example.student.service.IStudentService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/student")
public class StudentController {
	@Autowired
	IStudentService studentService;
	
	@PostMapping("/insert")
	public Students insertStudent(@RequestBody Students students) {
		return studentService.insertStudent(students);
	}
	
	@GetMapping("/getAll")
	public List<Students> getAllStudent(){
		return studentService.getAllStudent();
	}
	
	@PutMapping("/update/{id}")
	public Students updateStudent(@PathVariable int id, @RequestBody Students students) {
		return studentService.updateStudent(id, students);
	}
	
	@DeleteMapping("/delete/{id}")
	public Students deleteStudent(@PathVariable int id) {
		return studentService.deleteStudent(id);
	}
	
	@GetMapping("/getStudent/{id}")
	public Students getStudent(@PathVariable int id) {
		return studentService.getStudent(id);
	}

}

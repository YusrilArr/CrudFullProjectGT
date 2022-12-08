package com.example.student.service;

import java.util.List;

import com.example.student.model.Students;

public interface IStudentService {
	public Students insertStudent(Students students);
	public List<Students> getAllStudent();
	public Students updateStudent(int id, Students students);
	public Students deleteStudent(int id);
	public Students getStudent(int id);
	

}

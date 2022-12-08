package com.example.student.repository;

import com.example.student.model.Students;

import java.util.List;

public interface IStudentRepository {

	public Students insertStudent(Students students);
	public List<Students> getAllStudent();
	public Students updateStudent(int id, Students students);
	public Students deleteStudent(int id);
	public Students getStudent(int id);
	

}

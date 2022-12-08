package com.example.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.model.Students;
import com.example.student.repository.IStudentRepository;
import com.example.student.service.IStudentService;

@Service
public class StudentService implements IStudentService {
	
	@Autowired
	IStudentRepository studentRepository;

	@Override
	public Students insertStudent(Students students) {
		// TODO Auto-generated method stub
		return studentRepository.insertStudent(students); 
	}

	@Override
	public List<Students> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.getAllStudent();
	}

	@Override
	public Students updateStudent(int id, Students students) {
		// TODO Auto-generated method stub
		return studentRepository.updateStudent(id, students);
	}

	@Override
	public Students deleteStudent(int id) {
		// TODO Auto-generated method stub
		return studentRepository.deleteStudent(id);
	}

	@Override
	public Students getStudent(int id) {
		// TODO Auto-generated method stub
		
		return studentRepository.getStudent(id);
	}

}

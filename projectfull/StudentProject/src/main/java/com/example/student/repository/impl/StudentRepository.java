package com.example.student.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.student.model.Students;
import com.example.student.repository.IStudentRepository;

@Repository
public class StudentRepository implements IStudentRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Students insertStudent(Students students) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO tb_student(deskripsi_diri, email, hard_skill, interest, jenis_kelamin, nama, soft_skill, umur) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(query, new Object[] {students.getDeskripsi_diri(), students.getEmail(), students.getHard_skill(), students.getInterest(),
								students.getJenis_kelamin(), students.getNama(), students.getSoft_skill(), students.getUmur()});
		return students;
	}

	@Override
	public List<Students> getAllStudent() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_student";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Students.class));
	}

	@Override
	public Students updateStudent(int id, Students students) {
		// TODO Auto-generated method stub
		String query = "UPDATE tb_student SET deskripsi_diri = ?, email = ?, hard_skill = ?, interest = ?, jenis_kelamin = ?,"
				+ "nama = ?, soft_skill = ?, umur = ? WHERE  id = ?";
		
		jdbcTemplate.update(query, new Object[] {students.getDeskripsi_diri(), students.getEmail(), students.getHard_skill(), students.getInterest(),
				students.getJenis_kelamin(), students.getNama(), students.getSoft_skill(), students.getUmur(), id});
		return students;
	}

	@Override
	public Students deleteStudent(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_student WHERE id = ?";
		var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Students.class), id);
		
		query = "DELETE FROM tb_student WHERE id = ?";
		jdbcTemplate.update(query, id);
		return result;
	}

	@Override
	public Students getStudent(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_student WHERE id = ?";
		return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Students.class), id);
	}


}
  
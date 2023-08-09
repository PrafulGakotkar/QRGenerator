package com.Numitry.in.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Numitry.in.entity.Student;
import com.Numitry.in.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository repo;
	
	public List<Student> getStudents(){
		return repo.findAll();		
	}
	
	public Student addStudent(Student stud) {
		return repo.save(stud);
	}
	
	public Student findById(Long id) {
		return repo.findById(id).orElseThrow(()->new RuntimeException("Student Not Found"));
	}

}

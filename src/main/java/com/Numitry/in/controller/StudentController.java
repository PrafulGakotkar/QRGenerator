package com.Numitry.in.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Numitry.in.entity.Student;
import com.Numitry.in.service.StudentService;
import com.Numitry.in.util.QRCodeGenerator;
import com.google.zxing.WriterException;

@RestController
@RequestMapping("/")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getStudent() throws WriterException, IOException{
		List<Student> student=service.getStudents();
		if(student.size()!=0) {
			for(Student x:student) {
				QRCodeGenerator.generateQRCode(x);
			}
		}
		
		return ResponseEntity.ok(service.getStudents());
	}
	
	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student) {
		return service.addStudent(student);
		}
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return service.findById(id);
	}
}

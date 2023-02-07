package com.example.student.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
@RestController
@Slf4j
public class StudentController {
	@Autowired
	private StudentService ss;
	
	@GetMapping("/")
	public String check() {
		log.info("working");
		return "Student application is working";
	}
	@PostMapping("/register")
	public Student register(@Valid @RequestBody Student std){
		log.info("Student registration started");
		return ss.addStudent(std);
		
	}
	
	@PostMapping("/registerAll")
	public List<Student> registerAll(@RequestBody List<Student> stds){
		log.info("Registering list of students");
		return ss.addAllStudents(stds);
		
	}
	
	@GetMapping("/getAllStudents")
	public Optional<List<Student>> findAllStudents(){
		log.info("Getting student details from database");
		return ss.getAllStudents();
	}
	
	@GetMapping("/getStudentById/{id}")
	public Optional<Student> findStudentById(@PathVariable long id) {
		log.info("getting student info of: "+id);
		return ss.getByRollNo(id);
	}
	
	@GetMapping("/getStudentByName/{name}")
	public Optional<Student> findStudentByName(@PathVariable String name) {
		log.info("getting student info of: "+name);
		return ss.getByName(name);
	}
	
	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student std) {
		log.info("Updating student info");
		return ss.updateStudent(std);
	}
	
	@DeleteMapping("/deleteStudent/{rollNo}")
	public String deleteStudent(@PathVariable long rollNo) {
		log.info("Deleting student info of: "+rollNo);
		return ss.deleteByRollNo(rollNo);
	}
	
	@DeleteMapping("/deleteAll")
	public String deleteAll() {
		log.info("deleted all students from database");
		return ss.deleteAll();
	}
	
	
	

}

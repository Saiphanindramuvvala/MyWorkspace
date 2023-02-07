package com.example.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.entity.Student;
import com.example.student.jpa.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository sr;
	
	
	public Student addStudent(Student std) {
		return sr.save(std);
	}
	public List<Student> addAllStudents(List<Student> products){
		return sr.saveAll(products);
	}
	public Optional<List<Student>> getAllStudents(){
		return Optional.ofNullable(sr.findAll());
	}
	public Optional<Student> getByRollNo(long rollNo){
		return sr.findById(rollNo);
	}
	public Optional<Student> getByName(String name){
		return sr.findByName(name);
	}
	public String deleteByRollNo(long rollNo){
		sr.deleteByRollNo(rollNo);
		return ("Item deleted successfully:"+rollNo);
	}
	public String deleteAll() {
		sr.deleteAll();
		return "deleted all students from database";
	}
	public Student updateStudent(Student std) {
		Student existingStudent= sr.findById(std.getRollNo()).orElse(null);
		existingStudent.setName(std.getName());
		existingStudent.setStd(std.getStd());
		existingStudent.setTotal(std.getTotal());
		existingStudent.setPercentage(std.getPercentage());
		return sr.save(existingStudent);
		
	}
	
}

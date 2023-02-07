package com.example.student.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	Optional<Student> findByName(String name);
//	Optional<Student> findByRollNo(long rollNo);
	  default void deleteByRollNo(long rollNo) {
		this.deleteById(rollNo);
	}

}

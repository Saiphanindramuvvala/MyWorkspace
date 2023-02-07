package com.example.student.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "StudentTable")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long rollNo;
	@NotNull
	private String name;
	@NotNull
	private String std;
	@NotNull
	private long total;
	@NotNull
	private int percentage;

}

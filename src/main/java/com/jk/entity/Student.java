package com.jk.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "stu_table")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sid;
	@NotEmpty(message = "Name should not be empty")
	private String name;
	@Email(message = "Use Valid Email")
	@NotEmpty(message = "Please enter correct email")
	private String email;
	@NotEmpty(message = "Enter Password")
	@Size(min = 3, max = 6, message = "Enter min 3 and max 6")
	private String password;
	private Long pho;

	@CreationTimestamp
	private LocalDateTime createdDate;
	@UpdateTimestamp
	private LocalDateTime updatedDate;

}

package com.jk.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "stu_table")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sid;
	private String stuName;
	private String email;
	private String password;
	private Long pho;

	@CreationTimestamp
	private LocalDateTime createdDate;
	@UpdateTimestamp
	private LocalDateTime updatedDate;

}

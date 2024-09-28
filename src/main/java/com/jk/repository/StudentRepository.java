package com.jk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jk.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	public Student findByEmail(String email);

	public Student findByEmailAndPassword(String email, String password);
}

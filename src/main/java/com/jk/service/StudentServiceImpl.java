package com.jk.service;

import org.springframework.stereotype.Service;

import com.jk.entity.Student;
import com.jk.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository repository;

	public StudentServiceImpl(StudentRepository repository) {
		this.repository = repository;
	}

	@Override
	public boolean saveStudent(Student s) {

		Student student = repository.save(s);

		return student.getSid() != null;
	}

	@Override
	public boolean duplicateEmail(String email) {
		return repository.findByEmail(email) != null;
	}

	@Override
	public Student studentLogin(String email, String password) {
		return repository.findByEmailAndPassword(email, password);
	}

}

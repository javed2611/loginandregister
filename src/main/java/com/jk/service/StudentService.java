package com.jk.service;

import com.jk.entity.Student;

public interface StudentService {

	public boolean saveStudent(Student s);

	public boolean duplicateEmail(String email);

	public Student studentLogin(String email, String password);
}

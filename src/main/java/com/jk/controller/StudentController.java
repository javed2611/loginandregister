package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jk.entity.Student;
import com.jk.service.StudentService;

import jakarta.validation.Valid;

@Controller
public class StudentController {

	private StudentService service;

	public StudentController(StudentService service) {
		this.service = service;
	}

	@GetMapping("/")
	public String register(Model model) {
		model.addAttribute("student", new Student());
		return "index";
	}

	@PostMapping("/save")
	public String handleRegister(@Valid Student student, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {

			return "index";
		}

		boolean duplicateEmail = service.duplicateEmail(student.getEmail());
		if (duplicateEmail) {
			model.addAttribute("emsg", "Student Already Present");
			return "index";
		}

		boolean saveStudent = service.saveStudent(student);
		if (saveStudent) {
			model.addAttribute("smsg", "Student added");
		} else {
			model.addAttribute("emsg", "Unable to add student");
		}
		return "index";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("student", new Student());
		return "login";
	}

	@PostMapping("/login")
	public String handlelogin(@Valid Student student, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {

			return "login";
		}

		Student studentObj = service.studentLogin(student.getEmail(), student.getPassword());
		if (studentObj == null) {
			model.addAttribute("emsg", "Invalid Crendentials");
			return "login";
		}

		return "dashboard";
	}
}

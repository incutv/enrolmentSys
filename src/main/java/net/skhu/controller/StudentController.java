package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	private final StudentService studentService;

	public StudentController(StudentService studnetService) {
		this.studentService = studnetService;
	}



}

package net.skhu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.dto.req.ReqStudent;
import net.skhu.dto.res.ResStudent;
import net.skhu.dto.res.Response;
import net.skhu.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentApiController {
	private StudentService studentService;
	private PasswordEncoder passwordEncoder;

	public StudentApiController(StudentService studnetService, PasswordEncoder passwordEncoder) {
		this.studentService = studnetService;
		this.passwordEncoder = passwordEncoder;
	}

	//회원가입
	@PostMapping("/signup")
	public ResponseEntity<Response> signup(HttpServletRequest request, @RequestBody ReqStudent reqStudent){
		reqStudent.setPassword(passwordEncoder.encode(reqStudent.getPassword()));

		studentService.insertStudent(reqStudent);

		return ResponseEntity.ok()
				.body(Response.builder()
				.message("signup")
				.url(request.getRequestURL().toString())
				.data(reqStudent).build());

	}

	//로그인
	@PostMapping("/login")
	public ResponseEntity<Response> login(HttpServletRequest request, @RequestBody ReqStudent reqStudent){

		ResStudent loginStudent = studentService.loginStudent(reqStudent);

		HttpSession session = request.getSession(true);
		session.setAttribute("student", loginStudent);
		session.setAttribute("name", loginStudent.getName());
		session.setAttribute("studentId", loginStudent.getId());
		session.setAttribute("studentNo", loginStudent.getStudentNo());

		return ResponseEntity.ok()
				.body(Response.builder()
				.message("login")
				.url(request.getRequestURL().toString())
				.data(loginStudent).build());

	}

}

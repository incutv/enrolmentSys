package net.skhu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.skhu.dto.Message;
import net.skhu.dto.req.ReqStudent;
import net.skhu.dto.res.ResDepartment;
import net.skhu.dto.res.ResMessage;
import net.skhu.dto.res.ResStudent;
import net.skhu.service.MailService;
import net.skhu.service.StudentService;
import net.skhu.service.strategy.GoogleMailStrategy;
@Controller
@RequestMapping("/student")
public class StudentController {
	private StudentService studentService;
	private PasswordEncoder passwordEncoder;
	private JavaMailSender javaMailSender;

	public StudentController(StudentService studnetService, PasswordEncoder passwordEncoder, JavaMailSender javaMailSender) {
		this.studentService = studnetService;
		this.passwordEncoder = passwordEncoder;
		this.javaMailSender = javaMailSender;
	}

	//회원가입
	@GetMapping("/signup")
	public String signup(Model model) {
        List<ResDepartment> departments = studentService.selectDepartment();
        model.addAttribute("departments", departments);

		return "student/signup";
	}


	@PostMapping("/signup")
	public ModelAndView signup(@ModelAttribute ReqStudent student, ModelAndView mav) {
		System.out.println(student.getPassword());
		student.setPassword(passwordEncoder.encode(student.getPassword()));
		System.out.println(student.getPassword());

		try {
			if ( studentService.insertStudent(student) == 1 ) {

				MailService mailService = new MailService();
				mailService.sign(googleSignMail(), student.getEmail(), student.getName());

				mav.addObject("data", new ResMessage(Message.APPLY_MESSAGE.getMessage(), "login"));
				mav.setViewName("Message");
			} else {
				throw new Exception(Message.FAIL_MESSAGE.getMessage());
			}

		} catch(Exception e) {
			mav.addObject("data", new ResMessage(e.getMessage(), "login"));
			mav.setViewName("Message");
		}

		return mav;
	}


	public GoogleMailStrategy googleSignMail() {
		return new GoogleMailStrategy(javaMailSender);
	}

	//로그인
	@GetMapping("/login")
	public String login() {
		return "student/login";
	}

	@PostMapping("/login")
	public ModelAndView loginStudent(HttpServletRequest request, @ModelAttribute ReqStudent student, ModelAndView mav){
		try {

			ResStudent loginStudent = studentService.loginStudent(student);
			String url = "http://localhost:8088/sugang/studentList?id=" + loginStudent.getId() ;
			mav.addObject("data", new ResMessage(loginStudent.getName() +"님 " + Message.SUCCESS_LOGIN.getMessage(), url));
			mav.setViewName("Message");

			HttpSession session = request.getSession(true);
			session.setAttribute("student", loginStudent);
			session.setAttribute("name", loginStudent.getName());
			session.setAttribute("studentId", loginStudent.getId());
			session.setAttribute("studentNo", loginStudent.getStudentNo());

		} catch(Exception e) {

			mav.addObject("data", new ResMessage(e.getMessage(), "login"));
			mav.setViewName("Message");

		}


		return mav;
	}

	//로그아웃
	@GetMapping("/logout")
	public String logout() {
		return "student/logout";
	}


	//회원탈퇴
	@GetMapping("/withdraw")
	public String withdraw() {
		return "student/withdraw";
	}

	//회원탈퇴
	@PostMapping("/withdraw")
	public String withdraw(@ModelAttribute ReqStudent reqStudent) {
		ResStudent student = studentService.loginStudent(reqStudent);

		studentService.deleteStudent(student.getStudentNo());

		MailService mailService = new MailService();
		mailService.withraw(googleSignMail(), student.getEmail(), student.getName());

		return "student/login";
	}

}

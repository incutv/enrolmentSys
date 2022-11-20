package net.skhu.controller;

import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
import net.skhu.service.StudentService;
@Controller
@RequestMapping("/student")
public class StudentController {
	private StudentService studentService;
	private PasswordEncoder passwordEncoder;
	private JavaMailSender mailSender;


	public StudentController(StudentService studnetService, PasswordEncoder passwordEncoder, JavaMailSender mailSender) {
		this.studentService = studnetService;
		this.passwordEncoder = passwordEncoder;
		this.mailSender = mailSender;
	}

	//회원가입
	@GetMapping("/signup")
	public String signup(Model model) {
        List<ResDepartment> departments = studentService.selectDepartment();
        model.addAttribute("departments", departments);

		return "student/signup";
	}

	public void sendMail(String name, String email) throws Exception{

		String subject = name + "님 가입을 환영합니다";
		String content = name + "님 수강신청 서비스에 가입하신 것을 환영합니다";
		String from = "수강신청서비스 <daonmom1204@gmail.com> ";
		String to = email;

		try {
			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");

			mailHelper.setFrom(from);
            // 빈에 아이디 설정한 것은 단순히 smtp 인증을 받기 위해 사용 따라서 보내는이(setFrom())반드시 필요
            // 보내는이와 메일주소를 수신하는이가 볼때 모두 표기 되게 원하신다면 아래의 코드를 사용하시면 됩니다.
            //mailHelper.setFrom("보내는이 이름 <보내는이 아이디@도메인주소>");
			mailHelper.setTo(to);
			mailHelper.setSubject(subject);
			mailHelper.setText(content, true);
			mailSender.send(mail);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}


	@PostMapping("/signup")
	public ModelAndView signup(@ModelAttribute ReqStudent student, ModelAndView mav) {
		System.out.println(student.getPassword());
		student.setPassword(passwordEncoder.encode(student.getPassword()));
		System.out.println(student.getPassword());

		try {
			if ( studentService.insertStudent(student) == 1 ) {
				sendMail(student.getName(), student.getEmail());
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

}

package net.skhu.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.skhu.dto.Message;
import net.skhu.dto.req.ReqSugang;
import net.skhu.dto.res.ResMessage;
import net.skhu.dto.res.ResStudent;
import net.skhu.service.SugangService;

@Controller
@RequestMapping("/sugang")
public class SugangController {

	private final SugangService sugangService;

	public SugangController(SugangService sugangService) {
		this.sugangService = sugangService;
	}

	//학생별 수강신청내역
	@GetMapping("/studentList")
	public ModelAndView list(ModelAndView mav, @RequestParam("id") int id) {

		try {
			List<ResStudent> students = sugangService.studentSugangList(id);
			mav.addObject("students", students);

			if ( students == null ) {

				mav.addObject("data", new ResMessage(Message.NOT_FOUND_STUDENT_SUGANG.getMessage(), "list"));
				mav.setViewName("Message");
			}

		} catch(Exception e) {
			mav.addObject("data", new ResMessage(e.getMessage(), "list"));
			mav.setViewName("Message");
		}


		return mav;
	}

	//수강취소
	@PostMapping("/studentList")
	public ModelAndView cancelEnrolment(@ModelAttribute ResStudent student, ModelAndView mav) {

		int studentId = student.getId();
		int lectureId = student.getLectureId();
		System.out.println( studentId );
		System.out.println( lectureId );
		try {
			if ( sugangService.deleteSugang(studentId, lectureId) == 1 ) {
				mav.addObject("data", new ResMessage(Message.DELETE_MESSAGE.getMessage(), "studentList?id=" + studentId));
				mav.setViewName("Message");
			} else {
				throw new Exception(Message.FAIL_MESSAGE.getMessage());
			}

		} catch(Exception e) {
			mav.addObject("data", new ResMessage(e.getMessage(), "studentList?id=" + studentId));
			mav.setViewName("Message");
		}

		return mav;
	}

	//수강신청리스트
	@GetMapping("/list")
	public String enrolment(Model model) {
		model.addAttribute("lectures", sugangService.sugangList());
		return "sugang/list";
	}

	//수강신청
	@PostMapping("/list")
	public ModelAndView enrolment(@ModelAttribute ReqSugang sugang, ModelAndView mav) {
		try {
			if ( sugangService.insertSugang(sugang) == 1 ) {
				mav.addObject("data", new ResMessage(Message.APPLY_MESSAGE.getMessage(), "list"));
				mav.setViewName("Message");
			} else {
				throw new Exception(Message.FAIL_MESSAGE.getMessage());
			}

		} catch(Exception e) {
			mav.addObject("data", new ResMessage(e.getMessage(), "list"));
			mav.setViewName("Message");
		}

		return mav;
	}
}


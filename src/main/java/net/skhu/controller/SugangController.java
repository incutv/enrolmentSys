package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.skhu.dto.req.ReqSugang;
import net.skhu.dto.res.ResMessage;
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
	public String list(Model model, @RequestParam("id") int id) {
		//List<Student> students = sugangMapper.studentSugangList(id);
		model.addAttribute("students", sugangService.studentSugangList(id));
		return "sugang/studentList";
	}

	//수강신청리스트
	@GetMapping("/list")
	public String enrolment(Model model) {
		model.addAttribute("lectures", sugangService.sugangList());
		return "sugang/list";
	}

	//수강신청
	@PostMapping("/list")
	public ModelAndView enrolment(@RequestBody ReqSugang sugang, ModelAndView mav) {
		if ( sugangService.countSugang(sugang.getLectureId()) == "OK") {
			sugangService.insertSugang(sugang);
			mav.addObject("data", new ResMessage("신청 완료!", "redirect:list"));
			mav.setViewName("Message");
		}
		else {
			mav.addObject("data", new ResMessage("신청인원을 초과하였습니다.", "redirect:list"));
			mav.setViewName("Message");
		}

		return mav;
	}
}


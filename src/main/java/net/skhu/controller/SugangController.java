package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.skhu.dto.Message;
import net.skhu.dto.Sugang;
import net.skhu.mapper.SugangMapper;

@Controller
@RequestMapping("/sugang")
public class SugangController {

	private final SugangMapper sugangMapper;

	public SugangController(SugangMapper sugangMapper) {
		this.sugangMapper = sugangMapper;
	}

	//학생별 수강신청내역
	@GetMapping("/studentList")
	public String list(Model model, @RequestParam("id") String id) {
		model.addAttribute("sugangs", sugangMapper.studentSugangList(id));
		return "sugang/studentList";
	}

	//수강신청리스트
	@GetMapping("/list")
	public String enrolment(Model model) {
		model.addAttribute("lectures", sugangMapper.sugangList());
		return "sugang/list";
	}

	//수강신청
	@PostMapping("/list")
	public ModelAndView enrolment(@RequestBody Sugang sugang, ModelAndView mav) {
		if ( sugangMapper.countSugang(sugang.getLectureId()) == "OK") {
			sugangMapper.insertSugang(sugang);
			mav.addObject("data", new Message("신청 완료!", "redirect:list"));
			mav.setViewName("Message");
		}
		else {
			mav.addObject("data", new Message("신청인원을 초과하였습니다.", "redirect:list"));
			mav.setViewName("Message");
		}

		return mav;
	}



}


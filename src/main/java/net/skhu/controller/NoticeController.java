package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.skhu.dto.Criteria;
import net.skhu.dto.Message;
import net.skhu.dto.Notice;
import net.skhu.dto.Pagination;
import net.skhu.mapper.NoticeMapper;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	/*
	 * 1. write edit delete 까지..메소드 오류! 수정 필요 ..
	 * There was an unexpected error (type=Unsupported Media Type, status=415).
	 * 2. 캐시설정해봤는데 안됨.. 수정필요
	 *  */
	private final NoticeMapper noticeMapper;

	public NoticeController(NoticeMapper noticeMapper) {
		this.noticeMapper = noticeMapper;
	}

	//공지사항 리스트
	@GetMapping("/list")
	public String list(Model model, Criteria cri) {
		model.addAttribute("notices", noticeMapper.findAll(cri));
		model.addAttribute("pageMaker", new Pagination(cri, noticeMapper.countNotice()));
		return "notice/list";
	}

	//게시물 클릭
	@GetMapping("/view")
	public String view(Model model, @RequestParam("seq") int seq) {
		Notice notice = noticeMapper.findOne(seq);
		model.addAttribute("notice", notice);

		//조회수 +1
		noticeMapper.viewCnt(seq);

		return "notice/view";
	}

	//작성
	@GetMapping("/write")
	public String write() {
		return "notice/write";
	}

	@PostMapping("/write")
	public ModelAndView write(@RequestBody Notice notice, ModelAndView mav) {
		if ( noticeMapper.insertNotice(notice) > 0 )
			mav.addObject("data", new Message("공지사항이 등록되었습니다.", "redirect:/view?seq=" + notice.getSeq()));
		else
			mav.addObject("data", new Message("오류", "redirect:/list"));

		mav.setViewName("Message");

		return mav;
	}

	//수정
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam("seq") int seq) {
		Notice notice = noticeMapper.findOne(seq);
		model.addAttribute("notice", notice);
		return "notice/edit";
	}

	@PutMapping("/edit")
	public ModelAndView edit(@RequestBody Notice notice, ModelAndView mav) {
		if ( noticeMapper.updateNotice(notice) > 0 )
			mav.addObject("data", new Message("수정되었습니다.", "redirect:list"));
		else
			mav.addObject("data", new Message("오류", "redirect:list"));

		mav.setViewName("Message");

		return mav;
	}

	//삭제
	@DeleteMapping("/delete")
	public ModelAndView delete(@RequestParam("seq") int seq, ModelAndView mav) {
		if ( noticeMapper.deleteNotice(seq) > 0 )
			mav.addObject("data", new Message("삭제되었습니다.", "redirect:list"));
		else
			mav.addObject("data", new Message("오류", "redirect:list"));

		mav.setViewName("Message");

		return mav;
	}

}

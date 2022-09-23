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

import net.skhu.dto.Criteria;
import net.skhu.dto.Message;
import net.skhu.dto.Notice;
import net.skhu.dto.Pagination;
import net.skhu.dto.Reply;
import net.skhu.service.NoticeService;
import net.skhu.service.ReplyService;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	private final NoticeService noticeService;
	private final ReplyService replyService;

	public NoticeController(NoticeService noticeService, ReplyService replyService) {
		this.noticeService = noticeService;
		this.replyService = replyService;
	}


	//공지사항 리스트
	@GetMapping("/list")
	public String list(Model model, Criteria cri) {
		model.addAttribute("notices", noticeService.findAll(cri));
		model.addAttribute("pageMaker", new Pagination(cri, noticeService.countNotice()));
		return "notice/list";
	}

	//게시물 클릭
	@GetMapping("/view")
	public String view(Model model, @RequestParam("seq") int seq) {
		Notice notice = noticeService.findOne(seq);
		model.addAttribute("notice", notice);

		//조회수 +1
		noticeService.viewCnt(seq);

		List<Reply> replyList = replyService.selectReply(seq);
		model.addAttribute("replyList", replyList);

		return "notice/view";
	}

	//작성
	@GetMapping("/write")
	public String write() {
		return "notice/write";
	}

	@PostMapping("/write")
	public ModelAndView write(@ModelAttribute Notice notice, ModelAndView mav) {
		if ( noticeService.insertNotice(notice) > 0 )
			mav.addObject("data", new Message("공지사항이 등록되었습니다.", "list"));
		else
			mav.addObject("data", new Message("오류", "list"));

		mav.setViewName("Message");

		return mav;
	}

	//수정
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam("seq") int seq) {
		Notice notice = noticeService.findOne(seq);
		model.addAttribute("notice", notice);
		return "notice/edit";
	}

	@PostMapping("/edit")
	public ModelAndView edit(@ModelAttribute Notice notice, ModelAndView mav) {
		if ( noticeService.updateNotice(notice) > 0 )
			mav.addObject("data", new Message("수정되었습니다.", "list"));
		else
			mav.addObject("data", new Message("오류", "list"));

		mav.setViewName("Message");

		return mav;
	}

	//삭제
	@GetMapping("/delete")
	public ModelAndView delete( int seq, ModelAndView mav) {
		if ( noticeService.deleteNotice(seq) > 0 )
			mav.addObject("data", new Message("삭제되었습니다.", "list"));
		else
			mav.addObject("data", new Message("오류", "list"));

		mav.setViewName("Message");

		return mav;
	}

}

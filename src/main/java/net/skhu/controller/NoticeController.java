package net.skhu.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Criteria;
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
		model.addAttribute("pageMaker", new Pagination(cri, noticeMapper.count()));
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
	public String write(@RequestBody Notice notice) {
		notice.setDate(new Date());
		notice.setStart_date(new Date());
		notice.setEnd_date(new Date());
		notice.setViews(0);
		noticeMapper.insert(notice);
		return "redirect: /view?seq=" + notice.getSeq();
	}

	//수정
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam("seq") int seq) {
		Notice notice = noticeMapper.findOne(seq);
		model.addAttribute("notice", notice);
		return "notice/edit";
	}

	@PutMapping("/edit")
	public String edit(@RequestBody Notice notice) {
		noticeMapper.update(notice);
		return "redirect:list";
	}

	//삭제
	@DeleteMapping("/delete")
	public String delete(Model model, @RequestParam("seq") int seq) {
		noticeMapper.delete(seq);
		return "redirect:list";
	}

}

package net.skhu.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Notice;
import net.skhu.mapper.NoticeMapper;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	private final NoticeMapper noticeMapper;

	public NoticeController(NoticeMapper noticeMapper) {
		this.noticeMapper = noticeMapper;
	}

	@GetMapping("list")
	public String list(Model model) {
		List<Notice> notices = noticeMapper.findAll();
		model.addAttribute("notices", notices);
		return "notice/list";
	}

	@GetMapping("write")
	public String write(Model model) {
		LocalDate now = LocalDate.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		String defaultDate = now.format(dateFormat);

		model.addAttribute("date", defaultDate);
		model.addAttribute("start_date", defaultDate);
		model.addAttribute("end_date", defaultDate);
		model.addAttribute("writer", "");	//로그인화면 구현시 구현필요 + 권한
		return "notice/edit";
	}

	@PostMapping("write")
	public String write(Model model, Notice notice) {
		noticeMapper.insert(notice);
		return "redirect:list";
	}

	@GetMapping("edit")
	public String edit(Model model, @RequestParam("seq") int seq) {
		Notice notice = noticeMapper.findOne(seq);
		model.addAttribute("notice", notice);
		return "notice/edit";
	}

	@PutMapping("edit")
	public String edit(Model model, Notice notice) {
		noticeMapper.update(notice);
		return "redirect:list";
	}

	@DeleteMapping("delete")
	public String delete(Model model, @RequestParam("seq") int seq) {
		noticeMapper.delete(seq);
		return "redirect:list";
	}

}

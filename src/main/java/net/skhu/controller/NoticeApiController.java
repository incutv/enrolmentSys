package net.skhu.controller;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.skhu.dto.Notice;
import net.skhu.mapper.NoticeMapper;

@ApiResponses({
    @ApiResponse(code = 200, message = "Success"),
    @ApiResponse(code = 400, message = "Bad Request"),
    @ApiResponse(code = 500, message = "Internal Server Error")
})
@RestController
@RequestMapping("/")
public class NoticeApiController {

	private final NoticeMapper noticeMapper;

	public NoticeApiController(NoticeMapper noticeMapper) {
		this.noticeMapper = noticeMapper;
	}

	@ApiOperation(value="리스트", notes="공지사항 리스트출력")
	@GetMapping("/list")
	public List<Notice> list() {
		List<Notice> notices = noticeMapper.findAll();
		return notices;
	}


	@ApiOperation(value="작성", notes="공지사항 기본값 작성")
	@GetMapping("/write")
	public Notice write() {
		Notice notice = new Notice();
		Date date = new Date();
		notice.setDate(date);
		notice.setStart_date(date);
		notice.setEnd_date(date);
		notice.setWriter("관리자"); //로그인화면 구현 후 수정
		return notice;
	}

	@ApiOperation(value="작성", notes="공지사항 저장")
	@PostMapping("/write")
	public void write(@RequestBody Notice notice) {
		noticeMapper.insert(notice);
	}


	@ApiOperation(value="공지사항 클릭", notes="공지사항 클릭한 게시물 검색")
	@GetMapping("/edit")
	public Notice edit(@RequestParam int seq) {
		return noticeMapper.findOne(seq);
	}

	@ApiOperation(value="수정", notes="공지사항 수정")
	@PutMapping("/edit")
	public void edit(@RequestBody Notice notice) {
		noticeMapper.update(notice);
	}

	@ApiOperation(value="삭제", notes="공지사항 삭제")
	@DeleteMapping("/delete")
	public void delete(@RequestParam int seq) {
		noticeMapper.delete(seq);
	}

}

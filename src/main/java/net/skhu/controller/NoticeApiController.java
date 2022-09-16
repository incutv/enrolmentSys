package net.skhu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.skhu.dto.Criteria;
import net.skhu.dto.Notice;
import net.skhu.mapper.NoticeMapper;

@ApiResponses({
    @ApiResponse(code = 200, message = "Success"),
    @ApiResponse(code = 400, message = "Bad Request"),
    @ApiResponse(code = 500, message = "Internal Server Error")
})
@RestController
@RequestMapping("/notice")
public class NoticeApiController {

	private final NoticeMapper noticeMapper;

	public NoticeApiController(NoticeMapper noticeMapper) {
		this.noticeMapper = noticeMapper;
	}

	@ApiOperation(value="리스트", notes="공지사항 리스트출력")
	@GetMapping("/apiList")
	@ResponseBody
	public List<Notice> list(Criteria cri) {
		List<Notice> notices = noticeMapper.findAll(cri);
		return notices;
	}

	@ApiOperation(value="작성", notes="공지사항 저장")
	@PostMapping("/apiWrite")
	public Notice write(@RequestBody Notice notice) {
		noticeMapper.insertNotice(notice);
		return notice;
	}


	@ApiOperation(value="공지사항 클릭", notes="공지사항 클릭한 게시물 검색")
	@GetMapping("/apiEdit")
	public Notice edit(@RequestParam int seq) {
		return noticeMapper.findOne(seq);
	}

	@ApiOperation(value="수정", notes="공지사항 수정")
	@PutMapping("/apiEdit")
	public Notice edit(@RequestBody Notice notice) {
		noticeMapper.updateNotice(notice);
		return notice;
	}

	@ApiOperation(value="삭제", notes="공지사항 삭제")
	@DeleteMapping("/apiDelete")
	public int delete(@RequestParam int seq) {
		return noticeMapper.deleteNotice(seq);
	}

}

package net.skhu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import net.skhu.dto.req.ReqCriteria;
import net.skhu.dto.req.ReqNotice;
import net.skhu.dto.req.ReqReply;
import net.skhu.dto.res.ResNotice;
import net.skhu.dto.res.Response;
import net.skhu.service.NoticeService;
import net.skhu.service.ReplyService;

@ApiResponses({
    @ApiResponse(code = 200, message = "Success"),
    @ApiResponse(code = 400, message = "Bad Request"),
    @ApiResponse(code = 500, message = "Internal Server Error")
})
@RestController
@RequestMapping("/api/notice")
public class NoticeApiController {

	private final NoticeService noticeService;
	private final ReplyService replyService;

	public NoticeApiController(NoticeService noticeService, ReplyService replyService) {
		this.noticeService = noticeService;
		this.replyService = replyService;
	}

	@ApiOperation(value="리스트", notes="공지사항 리스트출력")
	@GetMapping("")
	@ResponseBody
	public ResponseEntity<Response> list(HttpServletRequest request, ReqCriteria cri) {
		//List<Map<String, String>> notices = noticeService.findAll(cri);
		List<ResNotice> notices = noticeService.findAll(cri);
		//String url = request.getContextPath();
		StringBuffer url = request.getRequestURL();

		return ResponseEntity.ok()
				.body(Response.builder()
				.message("notice list")
				.url(url.toString())
				.data(notices).build());
	}

	@ApiOperation(value="작성", notes="공지사항 저장")
	@PostMapping("")
	public int write(@RequestBody ReqNotice notice) {
		return noticeService.insertNotice(notice);
	}


	@ApiOperation(value="공지사항 클릭", notes="공지사항 클릭한 게시물 검색")
	@GetMapping("/{seq}")
	public ResponseEntity<Response> edit(HttpServletRequest request, @PathVariable int seq) {
		ResNotice notice = noticeService.findOne(seq);

		StringBuffer url = request.getRequestURL();

		return ResponseEntity.ok()
				.body(Response.builder()
						.message("notice findone")
						.url(url.toString())
						.data(notice).build());
	}


	@ApiOperation(value="댓글", notes="게시물에 대한 댓글")
	@GetMapping("/reply/{seq}")
	public ResponseEntity<Response> replyList(HttpServletRequest request, @PathVariable int seq) {
		List<ReqReply> reply = replyService.selectReply(seq);

		StringBuffer url = request.getRequestURL();

		return ResponseEntity.ok()
				.body(Response.builder()
						.message("reply list")
						.url(url.toString())
						.data(reply).build());
	}


	@ApiOperation(value="수정", notes="공지사항 수정")
	@PutMapping("")
	public int edit(@RequestBody ReqNotice notice) {
		return noticeService.updateNotice(notice);
	}

	@ApiOperation(value="삭제", notes="공지사항 삭제")
	@DeleteMapping("")
	public int delete(@RequestParam int seq) {
		return noticeService.deleteNotice(seq);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public Object argumentExceptionCheck(Exception e) {
		System.out.println(e.getClass());
		return e.getMessage();
	}

	@ExceptionHandler(NullPointerException.class)
	public Object nullExceptionCheck(Exception e) {
		System.out.println(e.getClass());
		return e.getMessage();
	}

}

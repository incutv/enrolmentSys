package net.skhu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import net.skhu.dto.req.ReqCriteria;
import net.skhu.dto.req.ReqPagination;
import net.skhu.dto.req.ReqReply;
import net.skhu.dto.res.ResReply;
import net.skhu.service.ReplyService;

@RestController
@RequestMapping("/api/reply")
public class ReplyApiController {

	private final ReplyService replyService;

	public ReplyApiController(ReplyService replyService) {
		this.replyService = replyService;
	}


	@ApiOperation(value="댓글", notes="게시물에 대한 댓글")
	@GetMapping("/{seq}")
	 public ResponseEntity<Map<String, Object>> list(HttpServletRequest request,
			 								@PathVariable("seq") int seq,
			 								@RequestParam("amount") int amount,
			 								@RequestParam("pageNum") int pageNum) {

		ResponseEntity<Map<String, Object>> entity = null;

		try {

            ReqCriteria cri = new ReqCriteria();
            cri.setPageNum(pageNum);

            List<ResReply> reply = replyService.selectReply(seq, amount, pageNum);

            int cnt = replyService.countReply(seq);

            ReqPagination pageMaker = new ReqPagination(cri, cnt);

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("reply", reply);
            map.put("pageMaker", pageMaker);

            entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        } catch (Exception e) {

            e.printStackTrace();
            entity = new ResponseEntity<Map<String, Object>>(HttpStatus.OK);

        }

        return entity;

//		List<ResReply> replyList = replyService.selectReply(seq, amount, pageNum);
//
//		StringBuffer url = request.getRequestURL();
//
//		return ResponseEntity.ok()
//				.body(Response.builder()
//				.message("reply list")
//				.url(url.toString())
//				.data(replyList).build());
    }

	@ApiOperation(value="댓글작성", notes="댓글작성")
	@PostMapping("")
    public ResponseEntity<String> write(@RequestBody ReqReply reply) {
		ResponseEntity<String> entity = null;

        try {
            replyService.insertReply(reply);
            entity = new ResponseEntity<String>("regSuccess", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

	@ApiOperation(value="댓글수정", notes="댓글수정")
	@PutMapping("/{seq}")
    public ResponseEntity<String> update(@PathVariable("seq") int seq, @RequestBody ReqReply reply) {
		ResponseEntity<String> entity = null;

        try {
        	reply.setReply_seq(seq);
            replyService.updateReply(reply);
            entity = new ResponseEntity<String>("regSuccess", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return entity;
    }


	@ApiOperation(value="댓글삭제", notes="댓글삭제")
	@DeleteMapping("/{seq}")
    public ResponseEntity<String> delete(@PathVariable("seq") int seq) {
		ResponseEntity<String> entity = null;

        try {
            replyService.deleteReply(seq);
            entity = new ResponseEntity<String>("regSuccess", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return entity;
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



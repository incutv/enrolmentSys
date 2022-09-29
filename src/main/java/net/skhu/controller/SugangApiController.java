package net.skhu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.skhu.dto.res.ResLecture;
import net.skhu.dto.res.ResStudent;
import net.skhu.dto.res.Response;
import net.skhu.service.SugangService;

@ApiResponses(value = {
    @ApiResponse(code = 200, message = "Success"),
    @ApiResponse(code = 400, message = "Bad Request"),
    @ApiResponse(code = 500, message = "Internal Server Error")
})
@RestController
@RequestMapping("/api/sugang")
public class SugangApiController {

	private final SugangService sugangService;

	public SugangApiController(SugangService sugangService) {
		this.sugangService = sugangService;
	}

	@ApiOperation(value="학생별 리스트", notes="학생별 수강신청 리스트")
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Response> studentList(HttpServletRequest request, @PathVariable int id) {
		List<ResStudent> students = sugangService.studentSugangList(id);
		StringBuffer url = request.getRequestURL();

		return ResponseEntity.ok()
				.body(Response.builder()
				.message("notice list")
				.url(url.toString())
				.data(students).build());
	}

	@ApiOperation(value="리스트", notes="수강신청 리스트")
	@GetMapping("")
	@ResponseBody
	public ResponseEntity<Response> list(HttpServletRequest request) {
		List<ResLecture> sugangs = sugangService.sugangList();
		StringBuffer url = request.getRequestURL();

		return ResponseEntity.ok()
				.body(Response.builder()
				.message("notice list")
				.url(url.toString())
				.data(sugangs).build());

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

package net.skhu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.skhu.dto.Lecture;
import net.skhu.dto.Student;
import net.skhu.service.SugangService;

@ApiResponses(value = {
    @ApiResponse(code = 200, message = "Success"),
    @ApiResponse(code = 400, message = "Bad Request"),
    @ApiResponse(code = 500, message = "Internal Server Error")
})
@RestController
@RequestMapping("/sugang")
public class SugangApiController {

	private final SugangService sugangService;

	public SugangApiController(SugangService sugangService) {
		this.sugangService = sugangService;
	}

	@ApiOperation(value="리스트", notes="학생별 수강신청 리스트")
	@GetMapping("/apiStudentList")
	@ResponseBody
	public List<Student> studentList(@RequestParam("id") int id) {
		List<Student> students = sugangService.studentSugangList(id);
		return students;
	}

	@ApiOperation(value="리스트", notes="수강신청 리스트")
	@GetMapping("/apiList")
	@ResponseBody
	public List<Lecture> list() {
		List<Lecture> sugangs = sugangService.sugangList();
		return sugangs;
	}

}

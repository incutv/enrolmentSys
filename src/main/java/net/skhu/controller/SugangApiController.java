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
import net.skhu.dto.Sugang;
import net.skhu.mapper.SugangMapper;

@ApiResponses(value = {
    @ApiResponse(code = 200, message = "Success"),
    @ApiResponse(code = 400, message = "Bad Request"),
    @ApiResponse(code = 500, message = "Internal Server Error")
})
@RestController
@RequestMapping("/sugang")
public class SugangApiController {

	private final SugangMapper sugangMapper;

	public SugangApiController(SugangMapper sugangMapper) {
		this.sugangMapper = sugangMapper;
	}

	@ApiOperation(value="리스트", notes="학생별 수강신청 리스트")
	@GetMapping("/apiStudentList")
	@ResponseBody
	public List<Sugang> studentList(@RequestParam("id") String id) {
		List<Sugang> sugangs = sugangMapper.studentSugangList(id);
		return sugangs;
	}

	@ApiOperation(value="리스트", notes="수강신청 리스트")
	@GetMapping("/apiList")
	@ResponseBody
	public List<Lecture> list() {
		List<Lecture> sugangs = sugangMapper.sugangList();
		return sugangs;
	}

}

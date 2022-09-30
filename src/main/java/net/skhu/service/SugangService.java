package net.skhu.service;

import java.util.List;

import net.skhu.dto.req.ReqSugang;
import net.skhu.dto.res.ResLecture;
import net.skhu.dto.res.ResStudent;

public interface SugangService {
	//학생별 수강신청내역리스트
	public List<ResStudent> studentSugangList(int id) ;

	//수강신청화면
	public List<ResLecture> sugangList();

	//강좌 인원체크
	public String countSugang(int lectureId);

	//수강신청
	public int insertSugang(ReqSugang sugang);
}

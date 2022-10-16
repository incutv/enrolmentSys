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
	public String countSugang(int year, int semester, int lectureId);

	//수강신청
	public int insertSugang(ReqSugang sugang);

	//학점조회(학생,년도,학기별 최대학점이상 신청못하게하기위함)
	public int studentCredit(int studentId, int year, int semester);

	//수강취소
	public int deleteSugang(int studentId, int lectureId);

	//중복체크
	public int duplicateCheck(int studentId, int year, int semester, int lectureId);
}

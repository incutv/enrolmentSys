package net.skhu.service;

import java.util.List;

import net.skhu.dto.Lecture;
import net.skhu.dto.Student;
import net.skhu.dto.Sugang;

public interface SugangService {
	//학생별 수강신청내역리스트
	public List<Student> studentSugangList(int id) ;

	//수강신청화면
	public List<Lecture> sugangList();

	//강좌 인원체크
	public String countSugang(int lectureId);

	//수강신청
	public int insertSugang(Sugang sugang);
}

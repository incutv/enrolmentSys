package net.skhu.mapper.read;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.res.ResLecture;
import net.skhu.dto.res.ResStudent;

@Mapper
public interface SugangReadMapper {
	//학생별 수강신청내역리스트
//	HashMap<K, V> studentSugangList(String studentNo);
	List<ResStudent> studentSugangList(int id);

	//수강신청화면
	List<ResLecture> sugangList();

	//강좌 인원체크
	String countSugang(int year, int semester, int lectureId);

	int countSugangInt(int year, int semester, int lectureId);

	//학점조회(학생,년도,학기별 최대학점이상 신청못하게하기위함)
	int studentCredit(int studentId, int year, int semester);

	//중복체크
	int duplicateCheck(int studentId, int year, int semester, int lectureId);

}

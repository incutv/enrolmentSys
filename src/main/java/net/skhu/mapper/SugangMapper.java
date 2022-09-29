package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.req.ReqSugang;
import net.skhu.dto.res.ResLecture;
import net.skhu.dto.res.ResStudent;

@Mapper
public interface SugangMapper {
	//학생별 수강신청내역리스트
//	HashMap<K, V> studentSugangList(String studentNo);
	List<ResStudent> studentSugangList(int id);

	//수강신청화면
	List<ResLecture> sugangList();

	//강좌 인원체크
	String countSugang(int lectureId);

	//수강신청
	int insertSugang(ReqSugang sugang);



}

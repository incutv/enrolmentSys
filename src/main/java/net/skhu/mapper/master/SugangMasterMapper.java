package net.skhu.mapper.master;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.req.ReqSugang;

@Mapper
public interface SugangMasterMapper {

	//수강신청
	void insertSugang(ReqSugang sugang);

	//수강취소
	int deleteSugang(int studentId, int lectureId);


}
